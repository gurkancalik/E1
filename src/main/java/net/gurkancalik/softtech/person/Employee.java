package net.gurkancalik.softtech.person;

import java.util.Date;

public class Employee extends Person
{

	public Employee(final int personId, final String name, final String surName, final Date birthDate)
	{
		super(personId, name, surName, birthDate);
	}

	@Override
	public double getBestDiscount()
	{
		return 30;
	}
}
