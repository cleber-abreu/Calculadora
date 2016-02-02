
public class ControleCalculadora {
	private static float valor1;
	private static float valor2;
	private static String operador1 = "";
	private static String operador2 = "";
	
	public static String adicionaOperador(String valor, String op) {
		String resultado = "";
		
		if (op.equals("=")) {
			if (valor.length() <= 1) {
				resultado = valor;
			}
			
			else if (valor.charAt(valor.length()-1) == '.') {
				resultado = valor.substring(0, valor.length()-1);
				operador1 = "";
			}
			
			else if(operador1==null || operador1.equals("")) {
				resultado = valor;
			}
			
			else if (valor.charAt(valor.length()-1) == operador1.charAt(0)) {
				resultado = valor.substring(0, valor.length()-1);
				operador1 = "";
			}
			
			else {
				valor2 = getValor2(valor);
				resultado = "" + calculaResultado();
			}
			
			if (resultado.indexOf('.') > -1) {
				resultado = arredonda(resultado);
			}
			
			operador2 = "=";
		}
		
		else if (op.equals("<-")) {
			if (valor.length() > 1) {
				if(seOperadorBinario(valor.charAt(valor.length()-1)))
					operador1 = "";
				resultado = valor.substring(0, valor.length()-1);
			}
			else
				resultado = "0";
		}
				
		else if((operador1==null || operador1.equals(""))  && !seOperadorUnario(op)){
			if (valor.length() > 1 || (!seSinalNumerico(valor))) {
				valor1 = Float.parseFloat(valor);
				operador2 = "";
			}
			operador1 = op;
			resultado = valor + op;
		}
		
		/*
		 *  trata se ultimo digito foi um operador
		 */
		
		else if(seSinalNumerico(op)) {
			
			if(op.charAt(0) == valor.charAt(valor.length()-1))
				resultado = valor;
			
			else if (seOperadorBinario(valor.charAt(valor.length()-1)))
				resultado = valor + op;
			
			else if (seSinalNumerico(valor.charAt(valor.length()-1)))
				resultado = valor.substring(0, valor.length()-1)
							+ op;
			else {
				
				//Realiza calculo e acrescenta operador para o próximo calculo
				valor1 = getValor1(valor);
				valor2 = getValor2(valor);
				operador2 = op;
				resultado = "" + calculaResultado() + op;
			}
		}
		
		else if (seOperadorBinario(op)) { 
			if (seSinalNumerico(valor.charAt(valor.length()-1))
					|| seOperadorBinario(valor.charAt(valor.length()-1))) {
				
				operador1 = op;
	        	valor1 = Float.parseFloat(valor.substring(0, valor.length()-1));
	        	resultado = valor.substring(0, valor.length()- 1)
	        					+ op;
			}
			
			else {
				
				//Realiza calculo e acrescenta operador para o próximo calculo
				valor1 = getValor1(valor);
				valor2 = getValor2(valor);
				operador2 = op;
				resultado = "" + calculaResultado() + op;
			}
		}
		
		else if (seOperadorUnario(op)) {
			
			if (operador1.equals(""))
				valor1 = getValor1(valor);
			
			else {
				valor1 = getValor1(valor);
				valor2 = getValor2(valor);
				valor1 = Float.parseFloat(calculaResultado());
			}
			
			switch (op) {
			case "!":
				valor1 = fatorial(valor1);
				break;
				
			case "^2":
				valor1 = quadrado();
				break;
				
			case "^1/2":
				valor2 = 2;
				valor1 = raiz();
				break;
			
			case "Log":
				valor1 = logaritmo();
				break;
				
			default:
				break;
			}
			
			operador1 = "";
			operador2 = "=";
			resultado = arredonda(valor1);
		}
			
		return resultado;
	}
	
	
	private static Float getValor1(String valor) {
		if(operador1.equals("")) {
			return Float.parseFloat(valor);
		}
		else
			return Float.parseFloat(
					valor.substring(0, valor.substring(1).indexOf(operador1)+1));
	}
	
	private static Float getValor2(String valor) {
		return Float.parseFloat(
				valor.substring(valor.lastIndexOf(operador1) + operador1.length()));
	}
	
	public static String adicionaDigito(String valor1, String valor2) {
		if (valor1.equals("0") || operador2.equals("=")) {
			operador2 = "";
			return valor2;
		}
		else 
			return valor1 + valor2;
	}
	
	public static String adicionaPonto(String valor) {
		if (operador2.equals("=")) {
			operador1 = "";
			operador2 = "";
			return "0.";
		}
		
		else if(((valor.lastIndexOf('.') > -1) && operador1.equals(""))
			|| (String.valueOf(getValor1(valor)).lastIndexOf('.') > -1)) {
			return valor + ".";
		}
		
		return valor;
	}
	
	public static void limpa(){
		valor1 		= 0;
		valor2 		= 0;
		operador1 	= "";
		operador2 	= "";
	}
	
	private static boolean seOperadorBinario(char op) {
		switch (op) { 		
	        case '*':			
	        case '/':
	        case '^':
	        	return true;
	        default:
	        	return false;
		}
	}
	
	private static boolean seOperadorBinario(String op) {
		if (op.length() > 1)
			return false;
		else
			return seOperadorBinario(op.charAt(0));
	}
	
	private static boolean seOperadorUnario(String op) {
		switch (op) { 		
	        case "!":
	        case "^2":
	        case "^1/2":
	        case "Log":
	        	return true;
	        default:
	        	return false;
		}
	}
	
	private static boolean seSinalNumerico(char op) {
		switch (op) { 		
	        case '+':			
	        case '-':
	        	return true;
	        default:
	        	return false;
		}
	}
	
	private static boolean seSinalNumerico(String op) {
		return seSinalNumerico(op.charAt(0));
	}
	
	private static String arredonda(String resultado) {
		if(resultado.indexOf('.') > 0) {
			if(0 == Float.parseFloat(
					resultado.substring(
							resultado.indexOf(".")+1, resultado.length()))){
				return resultado.substring(0, resultado.indexOf("."));
			}
		}
		
		return resultado;
	}
	
	private static String arredonda(Float resultado) {
		return arredonda(String.valueOf(resultado));
	}
	
	private static String calculaResultado() {
		switch(operador1)
	    {
	    	case "+": 
	    		valor1 = soma(); 
	    		break;
	    		
	    	case "-": 
	    		valor1 = subtrai();
	    		break;
	    		
	    	case "*": 
	    		valor1 = mutiplica();
	    		break;
	    		
	    	case "/": 
	    		valor1 = divide();
	    		break;
	    	case "^":
	    		valor1 = potencia();
	    		break;
	    	case "^1/":
	    		valor1 = raiz();
	    		break;
	    		
	    }
		
		valor2 = 0;
		if (!operador2.equals("="))
			operador1 = operador2;
		operador2 = "";
		
		return arredonda(String.valueOf(valor1));
	}
	private static float soma() {
		return valor1 + valor2;
	}
	
	private static float subtrai() {
		return valor1 - valor2;
	}
	
	private static float mutiplica() {
		return valor1 * valor2;
	}
	
	private static float divide() {
		return valor1 / valor2;
	}
	
	private static float quadrado() {
		return valor1 * valor1;
	}
	
	private static float potencia() {
		return (float) Math.pow(valor1, valor2);
	}
	
	private static float raiz() {
		return (float) Math.pow(valor1, 1/valor2);
	}
	
	private static float fatorial(Float valor) {
		if (valor <= 1.0) {
			return 1;
		}
		else
			return fatorial(valor-1) * valor;
	}
	
	private static float logaritmo() {
		return (float) Math.log10(valor1);
	}
}
