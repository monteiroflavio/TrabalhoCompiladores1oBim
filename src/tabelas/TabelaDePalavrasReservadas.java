package tabelas;

import java.util.HashMap;

public class TabelaDePalavrasReservadas {
	private HashMap<String, String> palavrasReservadas = 
			new HashMap<String, String>();
	private static TabelaDePalavrasReservadas instance;
	private TabelaDePalavrasReservadas(){
		instance.palavrasReservadas.put("begin", "begin");
		instance.palavrasReservadas.put("if", "if");
		instance.palavrasReservadas.put("else", "else");
		instance.palavrasReservadas.put("then", "then");
		instance.palavrasReservadas.put("program", "program");
		instance.palavrasReservadas.put("var", "var");
		instance.palavrasReservadas.put("end", "end");
		instance.palavrasReservadas.put("while", "while");
		instance.palavrasReservadas.put("do", "do");
		instance.palavrasReservadas.put("procedure", "procedure");
		instance.palavrasReservadas.put("integer", "integer");
		instance.palavrasReservadas.put("real", "real");
		instance.palavrasReservadas.put("read", "read");
		instance.palavrasReservadas.put("write", "write");
	}
	public static TabelaDePalavrasReservadas getInstance(){
		return instance;
	}
	public String getPalavraReservada(String token){
		return instance.palavrasReservadas.get(token);
	}
}
