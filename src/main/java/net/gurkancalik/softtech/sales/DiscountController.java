package net.gurkancalik.softtech.sales;

import net.gurkancalik.softtech.product.Product;

/**
 * Discount calculator
 * @author gurkan.calik
 *
 */
public class DiscountController
{
	
	
	public DiscountController()
	{
		
	}
	
	public double evalueatePrice(final Basket basket)
	{
		final double percentage = findFittingPercentage(basket);
		return calculatePrice(basket, percentage);
	}

	private double calculatePrice(final Basket basket, final double percentage)
	{
		double totalPrice = 0;
		for (Product product: basket.getProducts())
		{
			totalPrice += product.calculatePercentageDiscount(percentage);
		}
		totalPrice -= (int)(totalPrice / 100) * 5; 
		return totalPrice;
	}

	private double findFittingPercentage(final Basket basket)
	{
		return basket.getPerson().getBestDiscount();
	}
}
