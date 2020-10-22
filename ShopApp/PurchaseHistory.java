package ShopApp;
import java.util.ArrayList;

/**
 * 
 * @author Dale Morrell
 * 
 * This class models the customer's purchased products
 * 
 */

public class PurchaseHistory 
{
	private ArrayList<Product> purchasedProducts = new ArrayList<Product>();
	
	/**
	 * 
	 * @param purchasedProducts = An ArrayList for Product objects
	 * 
	 * Constructor; Supplies ArrayList of product objects
	 * 
	 */
	public PurchaseHistory(ArrayList<Product> purchasedProducts) 
	{
		this.purchasedProducts = purchasedProducts;
	} 
	
	/**
	 * 
	 * @return Returns an ArrayList of products purchased
	 * 
	 * Gets ArrayList for purchased products
	 * 
	 */
	public ArrayList<Product> getPurchasedProducts() 
	{
		return this.purchasedProducts;
	}
}
