package util;

import java.util.List;

import analisadores.AnalisadorLexico;

public class CompilerController {
	private static CompilerController instance;
	private CompilerController(){}
	public static CompilerController getInstance(){
		if(instance == null)
			instance = new CompilerController();
		return instance;
	}
	public List<String> getTokens(String palavra){
		return AnalisadorLexico.getInstance().retornaTokens(palavra);	
	}
}