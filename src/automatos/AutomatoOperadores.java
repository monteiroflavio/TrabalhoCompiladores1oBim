package automatos;

import automatos.tad.Automato;
import exceptions.EstadoNaoExistenteException;
import exceptions.TransicaoNaoExistenteException;

public class AutomatoOperadores {
	private Automato automato;
	private static AutomatoOperadores instance;
	private AutomatoOperadores(){
		instance.automato = new Automato();
		instance.automato.addEstado(0);
		instance.automato.addEstado(1);
		instance.automato.addEstado(2);
		instance.automato.addEstado(3);
		instance.automato.addEstado(4);
		instance.automato.addEstado(5);
		instance.automato.addEstado(6);
		instance.automato.addEstado(7);
		instance.automato.addEstado(8);
		try {
			instance.automato.addEstadoFinal(2);
			instance.automato.addEstadoFinal(3);
			instance.automato.addEstadoFinal(4);
			instance.automato.addEstadoFinal(5);
			instance.automato.addEstadoFinal(7);
			instance.automato.addEstadoFinal(8);
			instance.automato.addTransicao(instance.automato.getEstado(0), 
					instance.automato.getEstado(1), "<", 0);
			instance.automato.addTransicao(instance.automato.getEstado(1), 
					instance.automato.getEstado(2), "=", 1);
			instance.automato.addTransicao(instance.automato.getEstado(1), 
					instance.automato.getEstado(3), ">", 2);
			instance.automato.addTransicao(instance.automato.getEstado(0), 
					instance.automato.getEstado(5), "=", 4);
			instance.automato.addTransicao(instance.automato.getEstado(0), 
					instance.automato.getEstado(6), ">", 5);
			instance.automato.addTransicao(instance.automato.getEstado(6), 
					instance.automato.getEstado(7), "=", 6);
		} catch (EstadoNaoExistenteException e){
			
		}
	}
	public static AutomatoOperadores getInstance(){
		return instance;
	}
	public String reconhecePalavra(String palavra, int posicao){
		String palavraReconhecida = new String();
		int estadoAtualId = 0;
		while(posicao++ < palavra.length()){
			try {
				estadoAtualId = instance.automato.transita(
						palavra.charAt(posicao), estadoAtualId);
				palavraReconhecida += palavra.charAt(posicao);
			} catch (TransicaoNaoExistenteException e) {
				
			}
			if(instance.automato.getEstadoFinal(estadoAtualId)!=null)
				return palavraReconhecida;
		}
		return palavraReconhecida;
	}
}