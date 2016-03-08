package analisadores;

import java.util.ArrayList;

import automatos.AutomatoOperadores;
import tabelas.TabelaDeSimbolos;
import util.PalavraReconhecida;

public class AnalisadorLexico {
	private static AnalisadorLexico instance;
	private AnalisadorLexico(){
		instance = new AnalisadorLexico();
	}
	public static AnalisadorLexico getInstance(){
		return instance;
	}
	public ArrayList<String> retornaTokens(String palavra){
		PalavraReconhecida palavraReconhecida;
		int characterCounter = 0;
		ArrayList<String> tokens = new ArrayList<String>();
		while(characterCounter < palavra.length()){
			switch (palavra.charAt(characterCounter)){
				case '>'|'<'|'=':
					palavraReconhecida = AutomatoOperadores.getInstance().
						reconhecePalavra(palavra, characterCounter);
					tokens.add(TabelaDeSimbolos.getInstance().
						getSimbolo(palavraReconhecida.getPalavra()));
					characterCounter = palavraReconhecida.getPosicao();
				case '\n':
					++characterCounter;
					
			}
			
		}
		return tokens;
	}
}
