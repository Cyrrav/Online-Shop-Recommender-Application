package ShopApp;
/**
 * 
 * @author Dale Morrell
 * 
 * Subclass of Exception; Thrown when a references product ID Code doesn't match an existing database product.
 * 
 */

@SuppressWarnings("serial")
public class ProductNotFoundException extends Exception 
{
	private int productIDCode;
	
	/**
	 * @param message = A String containing an exception message
	 * @param productCode = An Integer detailing the ID code of a product
	 * 
	 * Constructor with inputs
	 * 
	 */
	public ProductNotFoundException(String message, int productCode) 
	{
		super(message);
		this.productIDCode = productCode;
	}
	
	/**
	 * 
	 * @return returns a String which is a generic description of ProductNotFoundException
	 * 
	 */
	@Override
	public String toString() 
	{
		return super.getMessage() + " for product ID code: " + productIDCode;
	}
}
