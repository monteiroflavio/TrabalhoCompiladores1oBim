package automatos.tad;

public class Vertice {
	private int id;
	private String nome;
	private String rotulo;
	public Vertice(int id){
		this.id = id;
		this.nome = "q"+id;
	}
	public Vertice(int id, String rotulo){
		this(id);
		this.nome = "q"+id;
		this.rotulo = rotulo;
	}
	public int getId(){
		return this.id;
	}
	public String getNome(){
		return this.nome;
	}
	public String getRotulo(){
		return this.rotulo;
	}
	public void setRotulo(String rotulo){
		this.rotulo = rotulo;
	}
}
