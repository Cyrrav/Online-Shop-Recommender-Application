package ShopApp;
/**
 * 
 * @author Dale Morrell
 * 
 * Abstract class; Implements comparable interface + stores product codes and pricing
 *
 */

public abstract class Product implements Comparable<Product>
{

	protected Integer productIDCode;
	protected Double productPrice;
	
	public int compareTo(Product other) // COmpares products with each other based on price; @returns an integer where the integer is less than 0 if the current product is lower priced, or 0 and above if equally or greater priced
	{
        return productPrice.compareTo(other.productPrice);
	}

	/**
	 * @returns boolean: false if not equal or true if equal
	 * 
	 * Checks if a product object is = to current product object; 
	 */
	@Override 
	public boolean equals(Object object1)
	{
		if (this == object1) 
		{
			return true;
		}
		
		Product product = (Product) object1;
		if ((this.productIDCode != null) && (product.getProductCode() != null)) 
		{
			if (this.productIDCode.equals(product.getProductCode())) 
			{
				return true;
			}
			return false;
		}
		return false;
	}

	public Integer getProductCode() // Gets the product's code; @returns an integer
	{
		return this.productIDCode;
	}

	public Double getProductPrice() // Gets the product's price; @returns a double
	{
		return this.productPrice;
	}
}
