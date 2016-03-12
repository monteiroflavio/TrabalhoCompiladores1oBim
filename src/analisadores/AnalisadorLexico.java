package analisadores;

import java.util.ArrayList;

import automatos.AutomatoDemaisSimbolos;
import automatos.AutomatoOperadoresAritmeticos;
import automatos.AutomatoOperadoresDeAtribuicao;
import automatos.AutomatoOperadoresRelacionais;
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
			switch (palavra.charAt(characterCounter)){
				case '=':
				case '<':
				case '>':
					palavraReconhecida = AutomatoOperadoresRelacionais.
					getInstance().reconhecePalavra(palavra, characterCounter);
					tokens.add(TabelaDeSimbolos.getInstance().
						getSimbolo(palavraReconhecida.getPalavra()));
					characterCounter = palavraReconhecida.getPosicao();
					continue;
				case '+':
				case '-':
				case '*':
				case '/':
					palavraReconhecida = AutomatoOperadoresAritmeticos.
					getInstance().reconhecePalavra(palavra, characterCounter);
					tokens.add(TabelaDeSimbolos.getInstance().
						getSimbolo(palavraReconhecida.getPalavra()));
					characterCounter = palavraReconhecida.getPosicao();
					continue;
				case ':':
					palavraReconhecida = AutomatoOperadoresDeAtribuicao.
					getInstance().reconhecePalavra(palavra, characterCounter);
					tokens.add(TabelaDeSimbolos.getInstance().
						getSimbolo(palavraReconhecida.getPalavra()));
					characterCounter = palavraReconhecida.getPosicao();
					continue;
				case ';':
				case ',':
				case '.':
				case '(':
				case ')':
				case '{':
				case '}':
					palavraReconhecida = AutomatoDemaisSimbolos.
					getInstance().reconhecePalavra(palavra, characterCounter);
					tokens.add(TabelaDeSimbolos.getInstance().
						getSimbolo(palavraReconhecida.getPalavra()));
					characterCounter = palavraReconhecida.getPosicao();
					continue;
			}
			++characterCounter;
		}
		return tokens;
	}
}
