package ShopApp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

/**
 * 
 * @author Dale Morrell
 * 
 * RecommenderSystem class contains product recommendation algorithm (PRA)
 * 
 */
public class RecommenderSystem 
{
	
	private ProductDatabase productDatabase;
	private HashSet<PurchaseHistory> purchaseHistories;
	
	/**
	 * 
	 * Instance variables initialized by default constructor; ProductDatabse object; HashSet of PurchaseHistory
	 * 
	 */
	public RecommenderSystem() 
	{
		productDatabase = new ProductDatabase();
		purchaseHistories = new HashSet<PurchaseHistory>();
	}

	/**
	 * 
	 * @param productDatabase = ProductDatabase object containing a database of products
	 * 
	 * Feeds the Recommendation System with a product database
	 * 
	 */
	public void setProductDatabase(ProductDatabase productDatabase) 
	{
		this.productDatabase = productDatabase;
	}

	/**
	 * 
	 * @param purchaseHistories = A HashSet of PurchaseHistory objects
	 * 
	 * Feeds Recommendation System a set of purchase histories
	 * 
	 */
	public void setPurchaseHistories(HashSet<PurchaseHistory> purchaseHistories) 
	{
		this.purchaseHistories = purchaseHistories;
	}

	/**
	 * Generates a list of recommended products based on the customer's cart. The list contains
	 * products which, according to purchase history data, have been purchased alongside those in the 
	 * customer's cart with equal/greater frequency to a number specified. This algorithm takes care
	 * not to recommend duplicate products or products already in the customer's cart.
	 * @param cart An ArrayList of Product objects
	 * @param freq An int specifying a minimum observation frequency
	 * 
	 */
	public ArrayList<Product> praAlgorithm(ArrayList<Product> cart, int freq) 
	{
		// Find products purchased alongside each cart product according to purchase history; Store those in a list
		ArrayList<Product> otherProducts = new ArrayList<Product>(); 
		for (Product cartProduct : cart) 
		{
			for (PurchaseHistory ph : this.purchaseHistories) 
			{
				if (ph.getPurchasedProducts().contains(cartProduct)) 
				{
					ph.getPurchasedProducts().remove(cartProduct);
					otherProducts.addAll(ph.getPurchasedProducts());
				}
			}
		}

		for (Product cartProduct : cart) // Remove occurrences of products currently in the cart from list of other products
		{
			if (otherProducts.contains(cartProduct)) 
			{
				otherProducts.removeAll(Collections.singleton(cartProduct));
			}
		}

		HashMap<Product, Integer> productFrequencyCountMap = new HashMap<Product, Integer>(); // Map each product in the overall list of products to a number, representing frequency of appearance
		for (Product otherProduct : otherProducts) 
		{
			if (productFrequencyCountMap.containsKey(otherProduct)) 
			{
				productFrequencyCountMap.put(otherProduct, (productFrequencyCountMap.get(otherProduct)+1));
			}
			else 
			{
				productFrequencyCountMap.put(otherProduct, 1);
			}
		}
		
		ArrayList<Product> recommendations = new ArrayList<Product>(); // Add to a list of recommended products the products that are mapped to a number equal/greater than the specified frequency.
		for (Entry<Product, Integer> p : productFrequencyCountMap.entrySet()) 
		{
			if (p.getValue() >= freq) 
			{
				recommendations.add(p.getKey());
			}
		}
		
		Collections.sort(recommendations); // Sort & Return recommended product list
		return recommendations;
	}
}
