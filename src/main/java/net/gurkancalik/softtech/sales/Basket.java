package net.gurkancalik.softtech.sales;

import java.util.ArrayList;
import java.util.List;

import net.gurkancalik.softtech.person.Person;
import net.gurkancalik.softtech.product.Product;

/**
 * basket for customers
 * @author gurkan.calik
 *
 */
public class Basket
{
	private Person person;
	final private List<Product> products;
	
	
	public Basket(final Person person)
	{
		setPerson(person);
		products = new ArrayList<Product>(); 
	}
	
	public void addProduct(final Product product)
	{
		products.add(product);
	}


	public Person getPerson()
	{
		return person;
	}


	public void setPerson(final Person person)
	{
		this.person = person;
	}


	public List<Product> getProducts() {
		return products;
	}

}
