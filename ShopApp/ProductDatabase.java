package ShopApp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 *
 * @author Dale Morrell
 * 
 * ProductDatabase Class that stores a database of products
 * 
 */
public class ProductDatabase 
{
	
	HashMap<Integer, Product> products;
	
	/**
	 * Constructor initializing HashMap collection; Maps Integers to product objects
	 */
	public ProductDatabase() 
	{
		products = new HashMap<Integer, Product>();
	}

	/**
	 * 
	 * @param p = Product object
	 * 
	 * Adds a product to the database
	 * 
	 */
	public void addProduct(Product p) 
	{
		products.put(p.getProductCode(), p);
	}

	/**
	 * 
	 * @return returns ArrayList for database-stored Product objects
	 * 
	 */
	public ArrayList<Product> getProductDatabase() 
	{
		ArrayList<Product> productArrayList = new ArrayList<Product>(products.values());
		Collections.sort(productArrayList);
		return productArrayList;
	}

	/**
	 * 
	 * @return returns a String representation for ProductDatabase objects
	 * 
	 */
	public String toString() 
	{
		int listNumber = 1;
		String productList = "";
		for (Product p : getProductDatabase()) 
		{
			productList += (listNumber++)+" "+p.toString();
			
			if (listNumber <= getProductDatabase().size()) 
			{
				productList += "\n";
			}
		}
		return productList;
	}
}
