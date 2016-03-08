package util;

import java.util.List;

import analisadores.AnalisadorLexico;

public class CompilerController {
	private static CompilerController instance;
	private CompilerController(){
		instance = new CompilerController();
	}
	public static CompilerController getInstance(){
		return instance;
	}
	public List<String> getTokens(String palavra){
		return AnalisadorLexico.getInstance().retornaTokens(palavra);	
	}
}