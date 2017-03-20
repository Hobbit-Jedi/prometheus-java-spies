package ua.net.hj.prometheus.spies;

/**
 * Класс, описывающий сообщение Шпиона Агентству.
 * @author Hobbit Jedi
 */
public class SpyMessage
{
	private final String mMessage; // Содержание сообщения.

	/**
	 * Создает новое сообщение шпиона агентству.
	 * @param aMessage - Содержание создаваемого сообщения.
	 */
	public SpyMessage(String aMessage)
	{
		mMessage = aMessage;
	}
	
	/**
	 * Получить содержание сообщения.
	 * @return - Содержание сообщения.
	 */
	public String getMessage()
	{
		return mMessage;
	}
	
	/**
	 * Создать копию объекта.
	 * @return - Копия текущего объекта.
	 */
	@Override
	public SpyMessage clone()
	{
		return new SpyMessage(mMessage);
	}
	
	/**
	 * Сравнить сообщения.
	 * @param o - Объект, с которым сравниваем.
	 * @return - Признак того, что объект, с которым сравниваем,
	 *           соответствует текущему объекту.
	 */
	@Override
	public boolean equals(Object o)
	{
		boolean result = false;
		if (o instanceof SpyMessage)
		{
			SpyMessage spyMessage = (SpyMessage)o;
			result = mMessage.equals(spyMessage.getMessage());
		}
		return result;
	}
}
