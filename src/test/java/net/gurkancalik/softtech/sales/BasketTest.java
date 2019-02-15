package net.gurkancalik.softtech.sales;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import net.gurkancalik.softtech.person.Customer;
import net.gurkancalik.softtech.person.Employee;
import net.gurkancalik.softtech.product.Apple;
import net.gurkancalik.softtech.product.Notebook;
import net.gurkancalik.softtech.product.Product;

public class BasketTest
{
	@Test
	public void productNameTest()
	{
		Product p = new Apple(1, "Green Apple", 5);
		Assert.assertEquals("Product Name Control ", "Green Apple", p.getProductName());
	}

	@Test
	public void productPriceTest()
	{
		Product p = new Apple(1, "Green Apple", 5);
		Assert.assertEquals("Product Price Control ", 5, p.getPrice(), 0.0);
	}
	
	@Test
	public void productIdTest()
	{
		Product p = new Apple(88, "Green Apple", 5);
		Assert.assertEquals("Product Id Control ", 88, p.getProductId());
	}
	
	@Test
	public void AffilationTest()
	{
		Customer customer = new Customer(1, "Gürkan", "Çalýk", new Date("1983/10/17"));
		customer.addAffilation(new Date("2020/02/15"));
		Assert.assertEquals("Affilation Start control", new Date("2020/02/15"), customer.getAffilation().getFinishDate());
	}
	
	@Test
	public void AffilationCustomDateTest()
	{
		Customer customer = new Customer(1, "Gürkan", "Çalýk", new Date("1983/10/17"));
		customer.addAffilation(new Date("2020/02/15"));
		Assert.assertEquals("Affilation Start control", true, customer.isValidAffilation(new Date("2019/12/15")));
	}

	@Test
	public void testCustomerBasketAdd()
	{
		Customer customer = new Customer(1, "Gürkan", "Çalýk", new Date("1983/10/17"));
		Basket basket = new Basket(customer);
		basket.addProduct(new Apple(1, "Green Apple", 5));
		basket.addProduct(new Apple(2, "Red Apple", 10));
		basket.addProduct(new Apple(3, "Yellow Apple", 20));
		basket.addProduct(new Notebook(6, "toshiba", 200));
		DiscountController dc = new DiscountController();
		double evaluatedPrice = dc.evalueatePrice(basket);
		Assert.assertEquals("New Customer without affinty ", 225, evaluatedPrice,  0.0);
	}

	@Test
	public void testTwoYearCustomerBasketAdd()
	{
		Customer customer = new Customer(1, "Gürkan", "Çalýk", new Date("1983/10/17"));
		customer.setCreateDate(new Date("2017/02/15"));
		Basket basket = new Basket(customer);
		basket.addProduct(new Apple(1, "Green Apple", 5));
		basket.addProduct(new Apple(2, "Red Apple", 10));
		basket.addProduct(new Apple(3, "Yellow Apple", 20));
		basket.addProduct(new Notebook(6, "toshiba", 200));
		DiscountController dc = new DiscountController();
		double evaluatedPrice = dc.evalueatePrice(basket);
		Assert.assertEquals("2 yeaar Customer without affinty ", 215, evaluatedPrice,  0.0);
	}

	@Test
	public void testCustomerAffinityBasketAdd()
	{
		Customer customer = new Customer(1, "Gürkan", "Çalýk", new Date("1983/10/17"));
		customer.setCreateDate(new Date("2017/02/15"));
		customer.addAffilation(new Date("2020/02/15"));
		Basket basket = new Basket(customer);
		basket.addProduct(new Apple(1, "Green Apple", 5));
		basket.addProduct(new Apple(2, "Red Apple", 10));
		basket.addProduct(new Apple(3, "Yellow Apple", 20));
		basket.addProduct(new Notebook(6, "toshiba", 200));
		DiscountController dc = new DiscountController();
		double evaluatedPrice = dc.evalueatePrice(basket);
		Assert.assertEquals("New Customer with affinty ", 205, evaluatedPrice,  0.0);
	}

	@Test
	public void testTwoYearCustomerAffinityBasketAdd()
	{
		Customer customer = new Customer(1, "Gürkan", "Çalýk", new Date(1983,11,17));
		customer.setCreateDate(new Date("2017/02/15"));
		customer.addAffilation(new Date("2020/02/15"));
		Basket basket = new Basket(customer);
		basket.addProduct(new Apple(1, "Green Apple", 5));
		basket.addProduct(new Apple(2, "Red Apple", 10));
		basket.addProduct(new Apple(3, "Yellow Apple", 20));
		basket.addProduct(new Notebook(6, "toshiba", 200));
		DiscountController dc = new DiscountController();
		double evaluatedPrice = dc.evalueatePrice(basket);
		Assert.assertEquals("2 year old Customer with affinty ", 205, evaluatedPrice,  0.0);
	}

	@Test
	public void testEmployeeBasketAdd()
	{
		Employee employee = new Employee(1, "Gürkan", "Çalýk", new Date(1983,11,17));
		Basket basket = new Basket(employee);
		basket.addProduct(new Apple(1, "Green Apple", 5));
		basket.addProduct(new Apple(2, "Red Apple", 10));
		basket.addProduct(new Apple(3, "Yellow Apple", 20));
		basket.addProduct(new Notebook(6, "toshiba", 200));
		DiscountController dc = new DiscountController();
		double evaluatedPrice = dc.evalueatePrice(basket);
		Assert.assertEquals("New Customer without affinty ", 170, evaluatedPrice,  0.0);
	}
}
