package net.gurkancalik.softtech.person;

import java.util.Calendar;
import java.util.Date;

import net.gurkancalik.softtech.property.Affiliation;

/**
 * Customer Info
 * @author gurkan.calik
 *
 */
public class Customer extends Person
{
	private Affiliation affilation;
	
	private static Calendar calendar = Calendar.getInstance();
	
	/**
	 * Create Customer
	 * @param personId
	 * @param name
	 * @param surName
	 * @param birthDate
	 */
	public Customer(final int personId,final String name, final String surName, final Date birthDate) {
		super(personId, name, surName, birthDate);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Add Affilation to Customer
	 * @param finishDate
	 */
	public void addAffilation(final Date finishDate)
	{
		setAffilation(new Affiliation(calendar.getTime(), finishDate));
	}
	
	/**
	 * check Customer got valid Affilation
	 * @return
	 */
	public boolean isValidAffilation()
	{
		return affilation != null && affilation.isValid();
	}
	
	/**
	 * check Customer got valid Affilation for currentDate
	 * @param currentDate
	 * @return
	 */
	public boolean isValidAffilation(final Date currentDate)
	{
		return affilation.isValid(currentDate);
	}

	public Affiliation getAffilation()
	{
		return affilation;
	}

	public void setAffilation(final Affiliation affilation)
	{
		this.affilation = affilation;
	}

	public boolean checkLoyaltyYear(final int year)
	{
		final Calendar computedDate = Calendar.getInstance();
		computedDate.setTime(getCreateDate());
		computedDate.add(Calendar.YEAR, 2);
		return computedDate.getTime().before(calendar.getTime());
	}
	
	@Override
	public double getBestDiscount()
	{
		double discountPerc;
		if (isValidAffilation())
		{
			discountPerc = 10;
		}else if(checkLoyaltyYear(2))
		{
			discountPerc = 5;
		}else
		{
			discountPerc = 0 ;
		}
		return discountPerc;
	}

}
