package model;

public class Expr extends Reducer{
	@Override
	protected SExpr evalArgs(SExpr largs) {
		if(largs.isNil()) return Nil.Nil;
		return new SCons(largs.car().eval(),evalArgs(largs.cdr()));
	}

}
