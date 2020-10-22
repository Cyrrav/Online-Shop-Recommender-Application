package ShopApp;
/**
 * 
 * @author Dale Morrell
 * 
 * Instrument = concrete subclass of Product; Has attributes for a musical instrument's type and brand
 * 
 */

public class Instrumentality extends Product 
{
	private String instrumentalBrand;
	private String instrumentalType;

	/**
	 * @param instrumentBrand = String detailing the brand of the instrument
	 * @param instrumentType = String detailing the type of instrument
	 * @param productIDCode = Integer for the product ID code
	 * @param productPrice = Double for the product's price
	 */
	public Instrumentality(String instrumentalBrand, String instrumentalType, Integer productIDCode, Double productPrice) // Constructor with all (including inheritance) attribute input parameters
	{
		this.instrumentalBrand = instrumentalBrand;
		this.instrumentalType = instrumentalType;
		this.productIDCode = productIDCode;
		this.productPrice = productPrice;
	}

	/**
	 * 
	 * @return String detailing instrument's brand
	 * 
	 * Gets instrument brand
	 * 
	 */
	public String getInstrumentalBrand() 
	{
		return instrumentalBrand;
	}
	
	/**
	 * 
	 * @param instrumentBrand = String detailing what brand the instrument is
	 * 
	 * Sets instrument brand
	 * 
	 */
	public void setInstrumentalBrand(String instrumentalBrand) 
	{
		this.instrumentalBrand = instrumentalBrand;
	}

	/**
	 * 
	 * @return String detailing the type of instrument
	 * 
	 * Gets type of instrument
	 * 
	 */
	public String getInstrumentalType() 
	{
		return instrumentalType;
	}

	/**
	 * 
	 * @param instrumentType = String detailing the type of instrument
	 * 
	 * Sets type of instrument
	 * 
	 */
	public void setInstrumentalType(String instrumentalType) 
	{
		this.instrumentalType = instrumentalType;
	}

	/**
	 * 
	 * @return String representation of Instrument
	 * 
	 */
	public String toString() 
	{
		return "Instrument: " + this.instrumentalBrand + " " + this.instrumentalType + " (" + this.productIDCode + ") - Price: $" + String.format("%.2f", this.productPrice);
	}
}
