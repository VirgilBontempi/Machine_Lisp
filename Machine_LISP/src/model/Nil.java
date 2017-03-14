package model;

public class Nil extends Atome implements Liste {

	public static final Nil Nil = new Nil();
	
	private Nil() {}
	
	@Override
	public SExpr car() throws LispException { return this; }

	@Override
	public SExpr cdr() throws LispException { return this; }

	@Override
	public boolean isNil() { return true; }
	
	/**
	 * TODO FAIRE LA JDOC
	 * @return
	 */
	public String toString(){ return "()"; }
}
