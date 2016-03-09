package analisadores;

import java.util.ArrayList;

import automatos.AutomatoOperadores;
import tabelas.TabelaDeSimbolos;
import util.PalavraReconhecida;

public class AnalisadorLexico {
	private static AnalisadorLexico instance;
	private AnalisadorLexico(){}
	public static AnalisadorLexico getInstance(){
		if(instance == null)
			instance = new AnalisadorLexico();
		return instance;
	}
	public ArrayList<String> retornaTokens(String palavra){
		PalavraReconhecida palavraReconhecida;
		int characterCounter = 0;
		ArrayList<String> tokens = new ArrayList<String>();
		while(characterCounter < palavra.length()){
			System.out.println(palavra.charAt(characterCounter));
			switch (palavra.charAt(characterCounter)){
				case '=':
					palavraReconhecida = AutomatoOperadores.getInstance().
						reconhecePalavra(palavra, characterCounter);
					tokens.add(TabelaDeSimbolos.getInstance().
						getSimbolo(palavraReconhecida.getPalavra()));
					characterCounter = palavraReconhecida.getPosicao();
				case '\n':
					++characterCounter;
			}
			++characterCounter;
		}
		return tokens;
	}
}
