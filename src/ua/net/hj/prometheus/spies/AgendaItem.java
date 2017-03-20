package ua.net.hj.prometheus.spies;

/**
 * Класс, описывающий пункт повестки съезда.
 * @author Hobbit Jedi
 */
public class AgendaItem
{
	private final String mName; // Название пункта повестки дня.

	/**
	 * Создает новый пункт повестки дня.
	 * @param aItemName - Название создаваемого пункта повестки дня.
	 */
	public AgendaItem(String aItemName)
	{
		mName = aItemName;
	}
	
	/**
	 * Получить название пункта повестки дня.
	 * @return - Название пункта текущей повестки дня.
	 */
	public String getName()
	{
		return mName;
	}
	
	/**
	 * Создать копию текущего объекта.
	 * @return - копия текущего объекта.
	 */
	@Override
	public AgendaItem clone()
	{
		return new AgendaItem(mName);
	}
}
