package model;

public class test {

	public static void main(String[] args) {
	SExpr S1 = new SCons(Symbole.newSymbole("a"),Symbole.newSymbole("ad"));
	SExpr S2 = new SCons(Symbole.newSymbole("a"),Symbole.newSymbole("bd"));
	SExpr S3 = new SCons(Symbole.newSymbole("a"),S2);
	SExpr S4 = new SCons(Symbole.newSymbole("a"),S3);
	SExpr S5 = new SCons(S2,S3);
	SExpr S6 = new SCons(S2,S2);
	
	System.out.println("Resultat attendu : (a (a . bd))");
	
	System.out.println("S3 : " + S3);
	System.out.println("S5 : " + S5);
	System.out.println("S6 : " + S6);

	}

}
