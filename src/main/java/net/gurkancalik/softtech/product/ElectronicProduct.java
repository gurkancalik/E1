package net.gurkancalik.softtech.product;

/**
 * electronic products
 * @author gurkan.calik
 *
 */
class ElectronicProduct extends Product implements Electronics, PercentageDiscount
{
	public ElectronicProduct(final int productId, final String productName, final double price)
	{
		super(productId, productName, price);
	}
}
