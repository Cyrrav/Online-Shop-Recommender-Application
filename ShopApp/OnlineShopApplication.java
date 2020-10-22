package ShopApp;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 * @author Dale Morrell
 * 
 * This main() program provides the interaction for an Online Shop that allows users to both select 
 * and purchase products from a database; It implements a Product Recommendation Algorithm (PRA)
 * that recommends the customer products based off of their purchases.
 * 
 * The PRA works by analyzing transaction histories from a text file, observing the product purchase frequencies.
 * Other products with similarly high purchase frequencies to the customer's current purchases are then recommended to them.
 *
 */

public class OnlineShopApplication 
{
	
	/**
	 * 
	 * @param String array containing command line arguments
	 * 
	 * Implements functionality of the Online Shop; takes in user input via the console
	 * 
	 */
	public static void main(String[] args) 
	{
		System.out.println("Welcome to: The WalMart Online Store!\n");
		OnlineShop walMart = new OnlineShop(generateSampleDatabase()); // new OnlineShop object
		// Attempt to read purchase history transcript from text file
		try  
		{
			walMart.getRecommenderSystem().setPurchaseHistories(readPurchaseHistoryData(generateSampleDatabase(), "src/assignment3/purchase-history.txt")); 
		} 
		catch (NumberFormatException e) // Error handling
		{ 
			System.out.println("ERROR: Cannot process product codes; Program will now terminate");
			System.exit(0); 
		}
		catch (ProductNotFoundException e) 
		{
			System.out.println("ERROR: Product is missing from product database; Program will now terminate");
			System.exit(0);
		} 
		catch (IOException e) 
		{
			System.out.println("ERROR: The purchase transcript file cannot be opened or read; Program will now terminate");
			System.exit(0);
		}
		
		// Main Menu
		String menuMain = "" +"\nFunctions of the online store:" +"\n1.) Add a product to your cart" +"\n2.) View your current cart" +"\n3.) Finalize transaction" +"\n4.) Exit program" +"\nPlease select an option (1-4):";
		Scanner input = new Scanner(System.in);
		boolean quitBool = false;
		int menuSelection = 0;
		
		do // Functionality for the main menu
		{
			do // Loop until input is actually within the range
			{ 
				System.out.println(menuMain);
				try 
				{
					menuSelection = input.nextInt();
				} 
				catch (InputMismatchException e) 
				{
					System.out.println("ERROR: Invalid input type! Please restart the application.");
					System.exit(0);
				}
			} while (menuSelection < 1 || menuSelection > 4);
			
			if (menuSelection == 1) // Display product menu; Allow customer to add products to cart
			{ 
				int productSelection = 0;
				do // Loop until input is actually within the range
				{
					System.out.println("" +"\nPlease select a product from the list.");
					System.out.println(generateSampleDatabase());
					System.out.println("Please enter a menu option (1-"+generateSampleDatabase().getProductDatabase().size()+"):");
					try 
					{
						productSelection = input.nextInt();
					} 
						
					catch (InputMismatchException e) 
					{
						System.out.println("ERROR: Invalid input type! Please restart the application.");
						System.exit(0);
					}
				} while (productSelection < 1 || productSelection > generateSampleDatabase().getProductDatabase().size());
					walMart.addProductToCart((generateSampleDatabase().getProductDatabase().get(productSelection-1)));
					System.out.println("Adding item: "+(generateSampleDatabase().getProductDatabase().get(productSelection-1))+" to shopping cart");
			 }
			
				if (menuSelection == 2) // Display cart's current contents
				{ 
					if (!walMart.getCart().isEmpty()) 
					{
						System.out.println(""+"\nContents of the current cart (sorted by price)");
					
						for (Product p : walMart.getCart()) 
						{
							System.out.println(p);
						}
					} 
				
					else 
					{
						System.out.println("Your shopping cart is currently empty.");
					}
				}
			
			if (menuSelection == 3) // Compute total payment owed; Finalize transaction
			{ 
				int payFull = 0;
				
				if (!walMart.getCart().isEmpty()) 
				{
					do 
					{
						System.out.println(""+"\nContents of the current cart (sorted by lowest to highest price)");
						for (Product p : walMart.getCart()) 
						{
							System.out.println(p);
						}
						
						System.out.println("Total amount owing: $"+String.format("%.2f", walMart.owedAmount()));
						System.out.println("Pay full amount?\n1.) Yes\n2.) No, return to Main Menu");
						System.out.println("Please select an option (1-2):");
						
						try 
						{
							payFull = input.nextInt();
						} 
						catch (InputMismatchException e) 
						{
							System.out.println("ERROR: Invalid input type! Please restart the application.");
							System.exit(0);
						}
						
						if (payFull == 1) 
						{
							System.out.println("Thank you for your purchase!"+" You might also like:");
							ArrayList<Product> recommended = new ArrayList<Product>();
							recommended.addAll(walMart.getRecommenderSystem().praAlgorithm(walMart.getCart(), 2)); // Store the recommendations in a list
							if (!recommended.isEmpty()) 
							{
								for (Product p : recommended) // Display recommended products
								{	
									System.out.println(p);
								}
							}
							
							else 
							{
								System.out.println("We are unable to recommend you items at this time.");
							}
							walMart.transactionComplete();
						}
					}  while (payFull < 1 || payFull > 2); // Loop menu until input within range
				}
				
				else 
				{
					System.out.println("Your shopping cart is currently empty.");
				}
			}
			
			if (menuSelection == 4) // Quit program
			{ 
				System.out.println("Thank you for using the WalMart Online Shopping experience!");
				quitBool = true;
			}
	  } while(!quitBool);	
		
	    input.close();
	} 
		

	/**
	 * 
	 * @return returns a ProductDatabase object full of sample items
	 * 
	 * Generate a sample database of products 
	 * 
	 */
	private static ProductDatabase generateSampleDatabase() 
	{
		ProductDatabase productDatabase = new ProductDatabase();
		productDatabase.addProduct(new Instrumentality("Korg", "Kronos LS Keyboard", 123, 1250.00));
		productDatabase.addProduct(new MusicFile("Road of Resistance", "BABYMETAL Feat. Dragonforce", 187, 24.99));
		productDatabase.addProduct(new BowlingBall(7, "SEA GREEN", 199, 212.00));
		productDatabase.addProduct(new Rug("Woolen", 2, 200, 19.99));
		productDatabase.addProduct(new DigitalFilm("Stranger Things: The Movie", false, 865, 30.50));
		
		return productDatabase;
	}

	/**
	 * 
	 * @param pd = ProductDatabase; Database of products
	 * @param fileName = String representing the read textfile's name
	 * @throws ProductNotFoundException = An exception that throws if a product in the file is missing from the database supplied
	 * @throws IOException = Exception that throws if the file cannot be opened or read
	 * @throws NumberFormatException = Exception that throws if Integer parsing fails
	 * @return returns HashSet for PurchaseHistory objects
	 * 
	 * Reads purchase history from text file; Returns customer purchases as a set
	 * 
	 */
	public static HashSet<PurchaseHistory> readPurchaseHistoryData(ProductDatabase pd, String fileName) throws ProductNotFoundException, IOException, NumberFormatException 
	{
		HashSet<PurchaseHistory> purchaseHistorySet = new HashSet<PurchaseHistory>(); // Initialize Customer purchase history
		FileReader fileReader = new FileReader(fileName); // File reading
		BufferedReader br = new BufferedReader(fileReader);
		System.out.println("Currently reading transcript of purchases from file: "+ fileName);
		String line = null;
		
		while ((line = br.readLine()) != null) 
		{
			ArrayList<Product> customerPurchases = new ArrayList<Product>(); 
			int nProductsPurchased = new Integer(line);
			for (int count = 0; count < nProductsPurchased; count++) 
			{
				int itemIDCode = new Integer(br.readLine());
				if ((pd.products.get(itemIDCode)) == null) // Throw exception if item ID code in file =/= match any ID Code in program
				{ 
					br.close();
					throw new ProductNotFoundException("ERROR: Product cannot be found in database!", itemIDCode);
				}
				customerPurchases.add(pd.products.get(itemIDCode)); // Populate an array with 'frequently-purchased-together' items.
			}
			PurchaseHistory purchaseHistory = new PurchaseHistory(customerPurchases); // Initialize array as PurchaseHistory object
			purchaseHistorySet.add(purchaseHistory); // PurchaseHistory object added to set
		}
		br.close();
		return purchaseHistorySet; // Return set
	}
}