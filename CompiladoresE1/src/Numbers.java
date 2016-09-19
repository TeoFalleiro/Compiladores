import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.antlr.v4.runtime.*; // class ANTLRInputStream , Token

public class Numbers {
    public static void main(String[] args) {
        NumbersLexer lexer;
        Token tk;
        // Cria instancia do lexer criado pelo ANTLR

        try {
        	File input = new File("test1.txt");
        	FileInputStream fin = new FileInputStream(input);
            lexer = new NumbersLexer(new ANTLRInputStream( fin ));
        } catch (Exception e) {
            // Pikachu!
            System.out.println("Erro:" + e);
            System.exit(1);
            return;
        }


      do {
            tk = lexer.nextToken();
            switch(tk.getType()) {
                case NumbersLexer.EXPR:
                	System.out.println("Reconheceu "+tk.getText());
                	break;
                default:
                	System.out.println("Expressão não reconhecida");
                	break;
                
            }
        } while (tk != null && tk.getType() != Token.EOF);

    }


}
