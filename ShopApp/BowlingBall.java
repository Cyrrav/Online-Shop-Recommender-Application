package ShopApp;
/**
 * 
 * @author Dale Morrell
 * 
 * bowlingBall = concrete subclass of Product; Has attributes for both ball size and ball color
 * 
 */

public class BowlingBall extends Product 
{
	private int ballSize;
	private String ballColor;

	/**
	 * @param ballSize = Integer detailing the size of the bowling ball
	 * @param ballColor = String detailing the color of the bowling ball
	 * @param productIDCode = Integer for the product ID code
	 * @param productPrice = Double for the product's price
	 */
	public BowlingBall(int ballSize, String ballColor, int productIDCode, double productPrice) 
	{
		this.ballSize = ballSize;
		this.ballColor = ballColor;
		this.productIDCode = productIDCode;
		this.productPrice = productPrice;
	}
	
	/**
	 * 
	 * @return ballSize = Integer detailing the size of the bowling ball
	 * 
	 * Gets the size of the bowling ball
	 * 
	 */
	public int getBallSize() 
	{
		return this.ballSize;
	}

	/**
	 * 
	 * @param ballSize = Integer detailing the size of the bowling ball
	 * 
	 * Sets the size of the bowling ball
	 * 
	 */
	public void setBallSize(int ballSize) 
	{
		this.ballSize = ballSize;
	}
	
	/**
	 * 
	 * @return ballColor = String detailing the color of the bowling ball
	 * 
	 * Gets color of the bowling ball
	 * 
	 */
	public String getBallColor() 
	{
		return this.ballColor;
	}

	/**
	 * 
	 * @param ballColor = String detailing the color of the bowling ball
	 * 
	 * Sets color of the bowling ball
	 * 
	 */
	public void setBallColor(String ballColor) 
	{
		this.ballColor = ballColor;
	}

	/**
	 * 
	 * @return returns string representation of the bowling ball
	 * 
	 */
	public String toString() 
	{
		return "Bowling Ball: " + "SIZE: " + this.ballSize + " in the color " + this.ballColor + " (ITEM: " + this.productIDCode + ") - Price: $" + String.format("%.2f", this.productPrice);
	}
}
