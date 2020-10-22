package ShopApp;
/**
 * 
 * @author Dale Morrell
 *
 * Product subclass; Contains details for specific product; CONCRETE CLASS
 *
 */

public class MusicFile extends Product
{
	private String songTitle;
	private String songArtist;
	
	/**
	 * @param songTitle = Song title
	 * @param songArtist = Artist of song
	 * @param productIDCode = ID code of product
	 * @param productPrice = Price of the product
	 */
	public MusicFile(String songTitle, String songArtist, Integer productIDCode, Double productPrice) // Constructor with all (including inheritance) attribute input parameters
	{
		this.songTitle = songTitle;
		this.songArtist = songArtist;
		this.productIDCode = productIDCode;
		this.productPrice = productPrice;
	}
	
	/**
	 * @return a string (Title of the music file)
	 * 
	 * Gets title of the music file
	 */
	public String getSongTitle() 
	{
		return this.songTitle;
	}
	
	/**
	 * @param albumTitle = Title of the music file
	 * 
	 * Sets title of the music file
	 */
	public void setSongTitle(String songTitle)
	{
		this.songTitle = songTitle;
	}
	
	/**
	 * @return a string
	 * 
	 * Gets title of the music file
	 */
	public String getSongArtist()
	{
		return this.songArtist;
	}
	
	/**
	 * @param albumArtist = Artist of the track
	 * 
	 * Sets the Artist for the music file
	 */
	public void setSongArtist(String songArtist) // Sets product detail #2
	{
		this.songArtist = songArtist;
	}
	
	/**
	 * @return string representation of music file and it's details
	 */
	public String toString()
	{
		return "Track: \"" + this.songTitle + "\" by "+ this.songArtist +" (" + this.productIDCode + ") - Price: $" + String.format("%.2f", this.productPrice);
	}
}
