package ShopApp;
/**
 * 
 * @author Dale Morrell
 * 
 * digitalFilm = concrete subclass of Product; Has attributes for both film name and age-restriction
 * 
 */

public class DigitalFilm extends Product 
{
	
	private String filmName;
	private boolean restricted;
	
	/**
	 * @param filmName = String of the Film Name
	 * @param restricted = Boolean of True or False (Age restricted or not age restricted)
	 * @param productCode = Integer for the product ID code
	 * @param productPrice = Double for the product's price
	 */
	
	public DigitalFilm(String filmName, boolean restricted, Integer productIDCode, Double productPrice) // Constructor with all (including inheritance) attribute input parameters
	{
		this.filmName = filmName;
		this.restricted = restricted;
		this.productIDCode = productIDCode;
		this.productPrice = productPrice;
	}
	
	/**
	 * 
	 * @return a String
	 * 
	 * Gets film name
	 * 
	 */
	public String getFilmName() 
	{
		return filmName;
	}
	
	/**
	 * 
	 * @param concertName A String
	 * 
	 * Sets film name
	 * 
	 */
	public void setFilmName(String filmName) 
	{
		this.filmName = filmName;
	}
	
	/**
	 * 
	 * @return a boolean, true if age restricted and false otherwise
	 * 
	 * Gets the film's age-restriction status
	 * 
	 */
	public boolean isRestricted() 
	{
		return this.restricted;
	}
	
	/**
	 * 
	 * @param restricted A boolean
	 * 
	 * Sets the film's age-restricted status
	 * 
	 */
	public void setRestricted(boolean restricted) 
	{
		this.restricted = restricted;
	}
	
	/**
	 *
	 * @return String representation of Digital Film
	 * 
	 * 
	 */
	public String toString() 
	{
		return "Film: " + this.filmName + " Age restricted: " + (this.restricted?"Yes":"No") + " (" + this.productIDCode + ") - Price: $" + String.format("%.2f", this.productPrice);
	}
}
