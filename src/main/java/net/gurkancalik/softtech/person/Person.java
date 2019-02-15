package net.gurkancalik.softtech.person;

import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author gurkan.calik
 * base person class
 */
public class Person
{
	private int personId;
	private String name;
	private String surName;
	private Date birthDate;
	private Date createDate;
	
	/**
	 * create person with base data
	 */
	public Person(final int personId, final String name, final String surName, final Date birthDate)
	{
		setPersonId(personId);
		setName(name);
		setSurName(surName);
		setBirthDate(birthDate);
		setCreateDate(Calendar.getInstance().getTime());
	}
	
	public double getBestDiscount()
	{
		return 0;
		
	}
	
	public String getName()
	{
		return name;
	}

	public void setName(final String name)
	{
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(final Date birthDate) {
		this.birthDate = birthDate;
	}

	public int getPersonId()
	{
		return personId;
	}

	public void setPersonId(final int personId)
	{
		this.personId = personId;
	}

	public String getSurName()
	{
		return surName;
	}

	public void setSurName(final String surName)
	{
		this.surName = surName;
	}


	public Date getCreateDate()
	{
		return createDate;
	}


	public void setCreateDate(final Date createDate)
	{
		this.createDate = createDate;
	} 
}
