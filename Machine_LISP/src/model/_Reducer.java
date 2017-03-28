package model;

public interface _Reducer {

	public SExpr reduction(SExpr foncteur, SExpr parametre);
	public SExpr apply(SExpr foncteur, SExpr parametre);
}
