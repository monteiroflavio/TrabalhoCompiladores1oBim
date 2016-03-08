package exceptions;

public class TransicaoNaoExistenteException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public TransicaoNaoExistenteException(int estadoNaoContidoId, 
			char caractereNaoContido){
		super("N�o existe uma transi��o do estado "+estadoNaoContidoId+
				" e s�mbolo "+caractereNaoContido+".");
	}

}