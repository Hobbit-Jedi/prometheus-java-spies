package ua.net.hj.prometheus.spies;

/**
 * Класс, описывающий пункт повестки съезда.
 * @author Hobbit Jedi
 */
public class AgendaItem
{
	private final String mName;

	public AgendaItem(String aItemName)
	{
		mName = aItemName;
	}
	
	public String getName()
	{
		return mName;
	}
	
	@Override
	public AgendaItem clone()
	{
		return new AgendaItem(mName);
	}
}
