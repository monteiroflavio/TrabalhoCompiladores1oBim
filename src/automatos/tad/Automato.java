package automatos.tad;

import java.util.HashMap;

import exceptions.EstadoNaoExistenteException;
import exceptions.TransicaoNaoExistenteException;

public class Automato {
	private HashMap<Integer, Vertice> estados;
	private HashMap<Integer, Vertice> estadosFinais;
	private Vertice estadoInicial;
	private HashMap<Integer, Aresta> transicoes;
	
	public void addEstado(int id){
		if(estados == null)
			estados = new HashMap<Integer, Vertice>();
		this.estados.put(id, new Vertice(id));
	}
	public void addEstadoFinal(int id) throws EstadoNaoExistenteException{
		if(estadosFinais == null)
			estadosFinais = new HashMap<Integer, Vertice>();
		if(!this.estados.containsKey(id))
			throw new EstadoNaoExistenteException(id);
		this.estadosFinais.put(id, this.estados.get(id));
	}
	public void setEstadoInicial(int id) throws EstadoNaoExistenteException{
		if(!this.estados.containsKey(id))
			throw new EstadoNaoExistenteException(id);
		this.estadoInicial = this.estados.get(id);
	}
	public void addTransicao(Vertice verticeOrigem, Vertice verticeDestino,
								String simbolo, int id) 
										throws EstadoNaoExistenteException{
		if(this.transicoes == null)
			this.transicoes = new HashMap<Integer, Aresta>();
		if(!this.estados.containsKey(verticeDestino.getId())||
				!this.estados.containsKey(verticeOrigem.getId()))
			throw new EstadoNaoExistenteException(id);
		this.transicoes.put(id, new Aresta(verticeOrigem, verticeDestino, 
							simbolo, id));
	}
	public Aresta getTransicao(int id){
		return this.transicoes.get(id);
	}
	public Vertice getEstadoInicial(int id){
		return this.estadoInicial;
	}
	public HashMap<Integer, Vertice> getEstadosFinais(){
		return this.estadosFinais;
	}
	public Vertice getEstadoFinal(int id){
		return this.estados.get(id);
	}
	public Vertice getEstado(int id){
		return this.estados.get(id);
	}
	public boolean isEstadoInicial(int id){
		return this.estadoInicial.getId()==id;
	}
	public boolean isEstadoFinal(int id){
		return this.estadosFinais.containsKey(id);
	}
	public int transita(char simbolo, int estadoAtualId) 
			throws TransicaoNaoExistenteException{
		for(Integer transicaoId : this.transicoes.keySet()){
			if((this.transicoes.get(transicaoId).getOrigem().
					getId()==estadoAtualId)
			&& (this.transicoes.get(transicaoId).getSimbolo().equals(simbolo)))
				estadoAtualId = this.transicoes.get(transicaoId).
					getDestino().getId();
			else
				throw new TransicaoNaoExistenteException(estadoAtualId,simbolo);
		}
		return estadoAtualId;
	}
}
