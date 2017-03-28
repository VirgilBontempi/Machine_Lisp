package model;

import java.util.HashMap;
import java.util.Map;

public class Context {

	private static Map<Symbole, SExpr> table = new HashMap<>();
	
	public static SExpr getSexpr(Symbole symbole){
		if(!table.containsKey(symbole)) throw new LispException("Variable indéfinie");
		return table.get(symbole);	
	}
	
	public static void bind1(SExpr sExprFormel, SExpr sExprEffectif){
		if(sExprFormel instanceof Symbole){
			
		}
		if(sExprFormel.atom() && sExprEffectif.atom()){
			table.put(sExprFormel, sExprEffectif);
		}
	}
	
	public static void bind2(){
		
	}
}
