package tema2JasperReports;

/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: CustomBean.java 5876 2013-01-07 19:05:05Z teodord $
 */
public class CustomBean
{


	/**
	 *
	 */
	private String city;
	private Integer id;
	private String name;
	private String street;


	/**
	 *
	 */
	public CustomBean(
		String pcity,
		Integer pid,
		String pname,
		String pstreet
		)
	{
		city = pcity;
		id = pid;
		name = pname;
		street = pstreet;
	}


	/**
	 *
	 */
	public CustomBean getMe()
	{
		return this;
	}


	/**
	 *
	 */
	public String getCity()
	{
		return city;
	}


	/**
	 *
	 */
	public Integer getId()
	{
		return id;
	}


	/**
	 *
	 */
	public String getName()
	{
		return name;
	}


	/**
	 *
	 */
	public String getStreet()
	{
		return street;
	}


}
