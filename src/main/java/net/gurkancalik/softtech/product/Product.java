package net.gurkancalik.softtech.product;

/**
 * base for products
 * @author gurkan.calik
 *
 */
public class Product
{
	private int productId;
	private String productName;
	private double price;

	/**
	 * create product
	 * @param productId
	 * @param productName
	 * @param price TODO
	 */
	public Product(final int productId, final String productName, final double price)
	{
		setProductId(productId);
		setProductName(productName);
		setPrice(price);
	}
	
	public double calculatePercentageDiscount(final double percentage)
	{
		double calculatedPrice = 0;
		if (this instanceof PercentageDiscount)
		{
			calculatedPrice = price / 100 * (100- percentage); 
		}
		return calculatedPrice;
	}
	
	public int getProductId()
	{
		return productId;
	}
	
	public void setProductId(final int productId)
	{
		this.productId = productId;
	}
	
	public String getProductName()
	{
		return productName;
	}
	
	public void setProductName(final String productName)
	{
		this.productName = productName;
	}

	public double getPrice()
	{
		return price;
	}

	public void setPrice(final double price)
	{
		this.price = price;
	}

}
