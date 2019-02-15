package net.gurkancalik.softtech.property;

import java.util.Calendar;
import java.util.Date;

/**
 * Customer Affiliation
 * @author gurkan.calik
 *
 */
public class Affiliation
{
	private Date startDate;
	private Date finishDate;
	
	private static Calendar calendar = Calendar.getInstance();
	
	public Affiliation(final Date startDate, final Date finishDate)
	{
		setStartDate(startDate);
		setFinishDate(finishDate);
	}
	
	/**
	 * check for vald affilation
	 * @return
	 */
	public boolean isValid()
	{
		return isValid(calendar.getTime());
	}
	
	public boolean isValid(final Date currentDate)
	{
		return (startDate != null && finishDate!= null) && (currentDate.after(startDate) && currentDate.before(finishDate));
	}

	public Date getStartDate()
	{
		return startDate;
	}

	public void setStartDate(final Date startDate)
	{
		this.startDate = startDate;
	}

	public Date getFinishDate()
	{
		return finishDate;
	}

	public void setFinishDate(final Date finishDate)
	{
		this.finishDate = finishDate;
	}

}
