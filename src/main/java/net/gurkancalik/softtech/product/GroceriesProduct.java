package net.gurkancalik.softtech.product;

class GroceriesProduct extends Product implements Groceries
{
	public GroceriesProduct(final int productId, final String productName, final double price)
	{
		super(productId, productName, price);
	}

}
