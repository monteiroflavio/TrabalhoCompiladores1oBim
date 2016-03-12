package tabelas;

import java.util.HashMap;

public class TabelaDeSimbolos {
	private HashMap<String, String> simbolos = new HashMap<String, String>();
	private static TabelaDeSimbolos instance;
	private TabelaDeSimbolos(){}
	public static TabelaDeSimbolos getInstance(){
		if(instance == null){
			instance = new TabelaDeSimbolos();
			instance.simbolos.put("<>","DIFERENTE");
			instance.simbolos.put("=","COMPARACAO");
			instance.simbolos.put(":=","ATRIBUICAO");
			instance.simbolos.put(">","MAIOR");
			instance.simbolos.put("<","MENOR");
			instance.simbolos.put(":","ATRIBUICAO_TIPO");
			instance.simbolos.put("+","ADICAO");
			instance.simbolos.put("-","SUBTRACAO");
			instance.simbolos.put("*","MULTIPLICACAO");
			instance.simbolos.put("/","DIVISAO");
			instance.simbolos.put("<=","MENOR_IGUAL");
			instance.simbolos.put(">=","MAIOR_IGUAL");
			instance.simbolos.put(";","PONTO_VIRGULA");
			instance.simbolos.put(".","PONTO_FINAL");
			instance.simbolos.put(",","VIRGULA");
			instance.simbolos.put("(","ABRE_PARENTESE");
			instance.simbolos.put(")","FECHA_PARENTESE");
			instance.simbolos.put("{","ABRE_CHAVE");
			instance.simbolos.put("}","FECHA_CHAVE");
		}
		return instance;
	}
	public String getSimbolo(String token){
		return instance.simbolos.get(token);
	}
}
