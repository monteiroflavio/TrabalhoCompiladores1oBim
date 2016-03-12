package automatos;

import automatos.tad.Automato;
import exceptions.EstadoNaoExistenteException;
import exceptions.TransicaoNaoExistenteException;
import util.PalavraReconhecida;

public class AutomatoOperadoresAritmeticos {
	private Automato automato;
	private static AutomatoOperadoresAritmeticos instance;
	private AutomatoOperadoresAritmeticos(){}
	public static AutomatoOperadoresAritmeticos getInstance(){
		if(instance == null){
			instance = new AutomatoOperadoresAritmeticos();
			instance.automato = new Automato();
			instance.automato.addEstado(0);
			instance.automato.addEstado(1);
			instance.automato.addEstado(2);
			instance.automato.addEstado(3);
			instance.automato.addEstado(4);
			try {
				instance.automato.addEstadoFinal(1);
				instance.automato.addEstadoFinal(2);
				instance.automato.addEstadoFinal(3);
				instance.automato.addEstadoFinal(4);
				instance.automato.addTransicao(instance.automato.getEstado(0), 
						instance.automato.getEstado(1), "+", 0);
				instance.automato.addTransicao(instance.automato.getEstado(0), 
						instance.automato.getEstado(2), "-", 1);
				instance.automato.addTransicao(instance.automato.getEstado(0), 
						instance.automato.getEstado(3), "*", 2);
				instance.automato.addTransicao(instance.automato.getEstado(0), 
						instance.automato.getEstado(4), "/", 4);
			} catch (EstadoNaoExistenteException e){}
		}
		return instance;
	}
	public PalavraReconhecida reconhecePalavra(String palavra, int posicao){
		String palavraReconhecida = new String();
		int estadoAtualId = 0;
		while(posicao < palavra.length()){
			try {
				estadoAtualId = instance.automato.transita(
						palavra.charAt(posicao), estadoAtualId);
				palavraReconhecida += palavra.charAt(posicao);
				++posicao;
			} catch (TransicaoNaoExistenteException e){
				return new PalavraReconhecida(palavraReconhecida, posicao);
			}
			if(instance.automato.isEstadoFinal(estadoAtualId))
				return new PalavraReconhecida(palavraReconhecida, posicao);
		}
		return new PalavraReconhecida(palavraReconhecida, posicao);
	}
}