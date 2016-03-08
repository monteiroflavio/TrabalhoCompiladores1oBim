package exceptions;

public class TransicaoNaoExistenteException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public TransicaoNaoExistenteException(int estadoNaoContidoId, 
			char caractereNaoContido){
		super("Não existe uma transição do estado "+estadoNaoContidoId+
				" e símbolo "+caractereNaoContido+".");
	}

}