package util;

public class PalavraReconhecida {
	private String palavra;
	private int posicao;
	public PalavraReconhecida(String palavra, int posicao){
		this.palavra = palavra;
		this.posicao = posicao;
	}
	public String getPalavra(){
		return this.palavra;
	}
	public int getPosicao(){
		return this.posicao;
	}
}