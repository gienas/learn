package pl.ene.common.rest;

public class EntityNotFoundException  extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EntityNotFoundException() {
		// TODO Auto-generated constructor stub
		super("Nie znaleziono encji");
	}

	public EntityNotFoundException(String str)
	{
		super(str);
	}
}
