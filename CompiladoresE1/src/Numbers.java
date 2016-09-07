import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.antlr.v4.runtime.*; // class ANTLRInputStream , Token

public class Numbers {
    public static void main(String[] args) {
        NumbersLexer lexer;
        Token tk;
    	ArrayList<Float> stack = new ArrayList<Float>();
    	float retorno, x, y;
    	int tamanho;
        // Cria instancia do lexer criado pelo ANTLR

        try {
        	File input = new File("entrada.txt");
        	FileInputStream fin = new FileInputStream(input);
            lexer = new NumbersLexer(new ANTLRInputStream( fin ));
        } catch (Exception e) {
            // Pikachu!
            System.out.println("Erro:" + e);
            System.exit(1);
            return;
        }

        // Le da entrada padrao ateh chegar digitar CTRL-D (Linux/Mac)
        // ou CTRL-Z (Windows)

        do {
            tk = lexer.nextToken();
            switch(tk.getType()) {
                
            case NumbersLexer.BINARY:
                	retorno = Conversor.convBinary(tk.getText());
                	stack.add(retorno);
                	break;

                
                case NumbersLexer.INTEGER:
                	float f = Float.parseFloat(tk.getText());
                	stack.add(f);
                	break;

                    
                case NumbersLexer.REAL:
                	retorno = Conversor.convReal(tk.getText());
                	stack.add(retorno);
                	break;
                
                case NumbersLexer.HEXADECIMAL:
                	retorno = Conversor.convHexa(tk.getText());
                	stack.add(retorno);
                	break;
                case NumbersLexer.OPERADORES:
                	switch (tk.getText()) {
                	case "+":
                		try{
                			tamanho = stack.size();
                			x = stack.get(tamanho - 1);
                			y = stack.get(tamanho);
                			retorno = x + y;
                			stack.remove(tamanho);
                			stack.remove(tamanho - 1);
                			stack.add(retorno);
                		}catch(IndexOutOfBoundsException e){
                			System.out.println("\n Erro:" + e);
                		}
                		break;
                	case "-" :
                		try{
                			tamanho = stack.size();
                			x = stack.get(tamanho - 1);
                			y = stack.get(tamanho);
                			retorno = x - y;
                			stack.remove(tamanho - 1);
                			stack.remove(tamanho);
                			stack.add(retorno);
                		}catch(IndexOutOfBoundsException e){
                			System.out.println("\n Erro:" + e);
                		}
                		break;
                	case "*" :
                		try{
                			tamanho = stack.size();
                			x = stack.get(tamanho - 1);
                			y = stack.get(tamanho);
                			retorno = x * y;
                			stack.remove(tamanho - 1);
                			stack.remove(tamanho);
                			stack.add(retorno);
                		}catch(IndexOutOfBoundsException e){
                			System.out.println("\n Erro:" + e);
                		}
                		break;
                	case "/" :
                		try{
                			tamanho = stack.size();
                			x = stack.get(tamanho - 1);
                			y = stack.get(tamanho);
                			retorno = x / y;
                			stack.remove(tamanho);
                			stack.remove(tamanho-1);
                			stack.add(retorno);
                		}catch(IndexOutOfBoundsException e){
                			System.out.println("\n Erro:" + e);
                		}
                		break;
                	case "^" :
                		try{
                			tamanho = stack.size();
                			x = stack.get(tamanho - 1);
                			y = stack.get(tamanho);

                			retorno = (float) Math.pow(x, y);
                			stack.remove(tamanho);
                			stack.remove(tamanho-1);
                			stack.add(retorno);

                		}catch(IndexOutOfBoundsException e){
                			System.out.println("\n Erro:" + e);
                		}
                		break;
                	case "status" :
                		int i;
                		for(i=0;i > stack.size();i++){
                			float stat = stack.get(i);
                			System.out.println("Status: " +stat);
                		}
                		break;
                	case "reset" :
                		stack.clear();
                		break;
                	}
                	System.out.println("\n Topo: " + stack);
            }
        } while (tk != null && tk.getType() != Token.EOF);

    }


}
