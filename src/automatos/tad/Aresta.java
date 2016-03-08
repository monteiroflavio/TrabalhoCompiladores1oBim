package automatos.tad;

public class Aresta {
	private int id;
	private Vertice verticeOrigem;
	private Vertice verticeDestino;
	@SuppressWarnings("unused")
	private String simbolo;
	public Aresta(Vertice verticeOrigem, Vertice verticeDestino,
					String simbolo, int id){
		this.id = id;
		this.verticeDestino = verticeDestino;
		this.verticeOrigem = verticeOrigem;
		this.simbolo = simbolo;
	}
	public int getId(){
		return this.id;
	}
	public Vertice getOrigem(){
		return this.verticeOrigem;
	}
	public Vertice getDestino(){
		return this.verticeDestino;
	}
	public String getSimbolo(){
		return this.getSimbolo();
	}
	public boolean equals(Aresta aresta){
		return this.verticeOrigem == aresta.getOrigem() &&
				this.verticeDestino == aresta.verticeDestino &&
				this.getSimbolo() == aresta.getSimbolo();
	}
}
