/* Generated By:JavaCC: Do not edit this line. Reader.java */
package Gramm;
import model.*;
import java.io.*;


public class Reader implements ReaderConstants {
/** le support de lecture */
protected static java.io.Reader in = new BufferedReader(new InputStreamReader(System.in));
//protected static Reader lereader = new Reader(in);
/** lecture d'une S-EXPR au terminal
* @return Sexpr : la Sexpr construite.
* @throws LispException une erreur de syntaxe
*/
public static void main(String[] args) {
  while(true) {
  System.out.println(Reader.read());
}
}
public static SExpr read() throws LispException{
  Reader lereader = new Reader(in);
        try {
                        return lereader.SEXPRESSION();
                } catch (ParseException e) {
                        throw new LispException("ce n'est pas une SExpr");
                }
  }
/** lecture d'une S-EXPR à partir de la chaîne
* @param s : la chaîne
* @return Sexpr : la Sexpr construite.
* @throws LispException une erreur de syntaxe
*/
public static SExpr read(String s) throws LispException{
        java.io.Reader sauv = in;
        in = new StringReader(s);
        SExpr r = read();
        in = sauv;
        return r;
   }
/** évaluation de la séquence S-EXPRs à partir du fichier s
* @param s : le nom du fichier
* @return Sexpr : symbole du nom du fichier.
* @throws LispException une erreur de lecture
*/
/*
public static SEXPR importe(String s) throws LispException{
  File f = new File(s);
  InputStream inputStr = new FileInputStream(f);
  
  
  }*/

private SExpr quote(SExpr s) {

return new SCons(Symbole.newSymbole("quote"),s);
}

private SExpr cons(SExpr s1,SExpr s2) {

return new SCons(s1,s2);
}

  final public SExpr SEXPRESSION() throws ParseException {
                       SExpr s1;
    s1 = SEXPR();
           {if (true) return s1;}
    throw new Error("Missing return statement in function");
  }

  final public void SEXPRESSIONS() throws ParseException {
                       SExpr s1;
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case QUOTE:
      case LPAREN:
      case ID:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      s1 = SEXPRESSION();

    }
    jj_consume_token(0);
  }

  final public SExpr SEXPR() throws ParseException {
                 SExpr s1;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ID:
      s1 = ATOME();
                   {if (true) return s1;}
      break;
    case LPAREN:
      jj_consume_token(LPAREN);
      s1 = LIST();
      jj_consume_token(RPAREN);
                                         {if (true) return s1;}
      break;
    case QUOTE:
      jj_consume_token(QUOTE);
      s1 = SEXPR();
                               {if (true) return quote(s1);}
      break;
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public SExpr LIST() throws ParseException {
                SExpr s1,s2;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case QUOTE:
    case LPAREN:
    case ID:
      s1 = SEXPR();
      s2 = LIST();
                                                       {if (true) return cons(s1,s2);}
      break;
    default:
      jj_la1[2] = jj_gen;
    {if (true) return Nil.Nil;}
    }
    throw new Error("Missing return statement in function");
  }

  final public SExpr ATOME() throws ParseException {
                 SExpr s1;
    s1 = SYMBOLE();
                     {if (true) return s1;}
    throw new Error("Missing return statement in function");
  }

  final public SExpr SYMBOLE() throws ParseException {
                   Token s1;
    s1 = jj_consume_token(ID);
                      {if (true) return Symbole.newSymbole(s1.image);}
    throw new Error("Missing return statement in function");
  }

  /** Generated Token Manager. */
  public ReaderTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[3];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x0,0x0,0x0,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x5800,0x5800,0x5800,};
   }

  /** Constructor with InputStream. */
  public Reader(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Reader(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new ReaderTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Reader(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new ReaderTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Reader(ReaderTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(ReaderTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[47];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 3; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 47; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}
