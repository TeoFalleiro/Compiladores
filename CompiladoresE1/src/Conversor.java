

public class Conversor {

	public static float convReal(String text) {
		if(text.contains("E") || text.contains("e")){
            int sinalIndex = (text.contains("E"))?text.indexOf("E")+1 : text.indexOf("e")+1;
            
            char sinal = text.charAt(sinalIndex);

            float x;
            if(sinal=='-'){
                float base = Float.parseFloat(text.substring(0, sinalIndex-1));
                int exp = Integer.parseInt(text.substring(sinalIndex));
                x = (float) Math.pow(base, exp);
                return x;
            }else if(sinal=='+'){
                float base = Float.parseFloat(text.substring(0, sinalIndex-1));
                int exp = Integer.parseInt(text.substring(sinalIndex));
                x = (float) Math.pow(base, exp);
                return x;
            }else{
                float base = Float.parseFloat(text.substring(0, sinalIndex-1));
                int exp = Integer.parseInt(text.substring(sinalIndex));
                x = (float) Math.pow(base, exp);
                return x;
            }
        }else{
            return Float.parseFloat(text);
        }
		
	}

	public static float convHexa(String text) {
		int i = Integer.parseInt(text.substring(2, (text.length() - 1)),16);
        return i;
	
	}

	public static float convBinary(String text) {
		String binario = text.substring(0, text.length()-2);
		int intBits = Integer.parseInt(binario, 2);
		float x = Float.intBitsToFloat(intBits);
		return x;
	}

}
