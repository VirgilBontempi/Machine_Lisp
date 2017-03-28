package model;

public abstract class Subr extends Primitive {
	@Override
	protected SExpr evalArgs(SExpr largs) {
		if(largs.isNil()) return Nil.Nil;
		return new SCons(largs.car().eval(),evalArgs(largs.cdr()));
	}
}
