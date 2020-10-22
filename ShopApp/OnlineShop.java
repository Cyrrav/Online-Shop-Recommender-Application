package ShopApp;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Dale Morrell
 * 
 * Class contains recommendation system, shopping cart and product database;
 * Implements payment system computing the owed amount;
 * Completes customer's transaction
 * 
 */

public class OnlineShop implements PaymentSystem 
{
	private ProductDatabase productDatabase;
	private RecommenderSystem recommenderSystem;
	private ArrayList<Product> cartShop;
	
	/**
	 * 
	 * @param productDatabase = Database for products in the store
	 * 
	 * Constructor which supplies a product database while also initializing some instance variables
	 * 
	 */
	public OnlineShop(ProductDatabase productDatabase) 
	{
		this.productDatabase = productDatabase;
		this.recommenderSystem = new RecommenderSystem();
		this.cartShop = new ArrayList<Product>();
	}

	/**
	 * 
	 * @return Double detailing total price of items in cart
	 * 
	 * Calculates total price of items in current cart
	 * 
	 */
	@Override
	public Double owedAmount() 
	{
		Double totalPrice = 0.00;
		
		for (Product p : this.cartShop) 
		{
			totalPrice += p.getProductPrice();
		}
		
		return totalPrice;
	}

	/**
	 * 
	 * Empties the current cart
	 * 
	 */
	@Override
	public void transactionComplete() 
	{
		this.cartShop.clear();
	}

	/**
	 * 
	 * @param p = the entered product object into the cart
	 * 
	 * Enters an object into the shopping cart
	 * 
	 */
	public void addProductToCart(Product p) 
	{
		this.cartShop.add(p);
	}

	/**
	 * 
	 * @return returns an ArrayList of items in the cart (Product objects)
	 * 
	 * Returns the products inside the current cart
	 * 
	 */
	public ArrayList<Product> getCart() 
	{
		Collections.sort(this.cartShop);
		return this.cartShop;
	}

	/**
	 * 
	 * @return returns a recommender system object
	 * 
	 * References recommenderSystem
	 * 
	 */
	public RecommenderSystem getRecommenderSystem() 
	{
		return this.recommenderSystem;
	}
}
