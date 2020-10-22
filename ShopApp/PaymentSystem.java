package ShopApp;
/**
 * 
 * @author Dale Morrell
 * 
 * Interface which specifies payment related functions and functionality
 * 
 */

public interface PaymentSystem 
{
	public Double owedAmount();
	public void transactionComplete();
}
