package ShopApp;
/**
 * 
 * @author Dale Morrell
 * 
 * Rug = concrete subclass of Product; Has attributes for both rug type and rug length (in meters)
 * 
 */

public class Rug extends Product 
{
	private String rugType;
	private int rugMetres;
	
	/**
	 * @param rugType = String of the Rug type
	 * @param rugMetres = Integer of the Rug length
	 * @param productIDCode = Integer for the product ID code
	 * @param productPrice = Double for the product's price
	 */
	public Rug(String rugType, int rugMetres, Integer productIDCode, Double productPrice) // Constructor with all (including inheritance) attribute input parameters
	{
		this.rugType = rugType;
		this.rugMetres = rugMetres;
		this.productIDCode = productIDCode;
		this.productPrice = productPrice;
	}

	/**
	 * 
	 * @return rugType = String of the Rug type
	 * 
	 * Gets the rug type
	 * 
	 */
	public String getRugType() 
	{
		return rugType;
	}

	/**
	 * 
	 * @param rugType = String detailing what type of rug
	 * 
	 * Sets the rug type
	 * 
	 */
	public void setRugType(String rugType) 
	{
		this.rugType = rugType;
	}

	/**
	 * 
	 * @return = int detailing rug length in meters
	 * 
	 * Gets the rug's length in meters
	 * 
	 */
	public int getRugMetres() 
	{
		return rugMetres;
	}

	/**
	 * 
	 * @param rugMetres = Int detailing rug length in meters
	 * 
	 * Sets the meter length for the rug
	 * 
	 */
	public void setRugMetres(int rugMetres) 
	{
		this.rugMetres = rugMetres;
	}

	/**
	 * 
	 * @return returns a String representation of Rug
	 * 
	 */
	public String toString() 
	{
		return "Rug: " + this.rugType + " " + this.rugMetres + "m" + " (" + this.productIDCode + ") - Price: $" + String.format("%.2f", this.productPrice);
	}
}
