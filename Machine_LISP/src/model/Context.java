package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Context {

	private static Map<SExpr, SExpr> table = new HashMap<>();
	private static Stack<Map<SExpr, SExpr>> stack = new Stack<>();
	
	static{
		Symbole t = Symbole.newSymbole("t"); define(t,t);
		Symbole nil = Symbole.newSymbole("nil"); define(nil,Nil.Nil);
	}
	
	public static SExpr getSexpr(Symbole symbole){
		if(!table.containsKey(symbole)) throw new LispException("Variable indéfinie");
		return table.get(symbole);	
	}
	
	public static void define(Symbole s , SExpr e){ table.put(s, e);}
	
	public static void bind(SExpr sExprFormel, SExpr sExprEffectif){
		Map<SExpr,SExpr> local;
		stack.push(local=new HashMap<>());
		bindInternal(local,sExprFormel, sExprEffectif);
	}
	
	private static void bindInternal(Map<SExpr,SExpr> local, SExpr sExprFormel, SExpr sExprEffectif){
		if(sExprFormel instanceof Symbole) {
			table.put(sExprFormel, sExprEffectif);
			local.put(sExprFormel.car(),table.get(sExprFormel));
		}
		if(!sExprFormel.car().atom() && sExprEffectif.car().atom() || !sExprFormel.car().isNil() && sExprEffectif.car().isNil()) {
			throw new LispException("Variable différente");
		}
		bindInternal(local,sExprFormel.car(), sExprEffectif.car());
		bindInternal(local,sExprFormel.cdr(), sExprEffectif.cdr());
	}

	public static void unbind(){
		Map<SExpr,SExpr> local = stack.pop();
		for(Map.Entry<SExpr, SExpr> e : local.entrySet()){
			if(e.getValue()==null) table.remove(e.getKey());
			else table.put(e.getKey(), e.getValue());
		}
	}
}