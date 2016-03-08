package exceptions;

public class EstadoNaoExistenteException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public EstadoNaoExistenteException(int estadoNaoContidoId){
		super("Estado "+estadoNaoContidoId+"não contido no conjunto de estados.");
	}

}
