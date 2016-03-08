package analisadores;

import java.util.ArrayList;

import automatos.AutomatoOperadores;
import tabelas.TabelaDeSimbolos;

public class AnalisadorLexico {
	private static AnalisadorLexico instance;
	private AnalisadorLexico(){
		instance = new AnalisadorLexico();
	}
	public static AnalisadorLexico getInstance(){
		return instance;
	}
	public ArrayList<String> retornaTokens(String palavra){
		int characterCounter = 0;
		String palavraReconhecida;
		ArrayList<String> tokens = new ArrayList<String>();
		while(characterCounter++ < palavra.length()){
			switch (palavra.charAt(characterCounter)){
				case '>'|'<'|'=':
					palavraReconhecida = AutomatoOperadores.getInstance().
						reconhecePalavra(palavra, characterCounter);
					tokens.add(TabelaDeSimbolos.getInstance().
						getSimbolo(palavraReconhecida));
				case '\n':
					continue;
					
			}
			
		}
		return tokens;
	}
}
