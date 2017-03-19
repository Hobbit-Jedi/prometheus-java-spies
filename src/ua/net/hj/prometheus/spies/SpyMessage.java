package ua.net.hj.prometheus.spies;

import java.util.Objects;

/**
 * Класс, описывающий сообщение Шпиона Агентству.
 * @author Hobbit Jedi
 */
public class SpyMessage
{
	private final String mMessage;

	public SpyMessage(String aMessage)
	{
		mMessage = aMessage;
	}
	
	public String getMessage()
	{
		return mMessage;
	}
	
	@Override
	public SpyMessage clone()
	{
		return new SpyMessage(mMessage);
	}
	
	@Override
	public boolean equals(Object o)
	{
		SpyMessage spyMessage = (SpyMessage)o;
		return mMessage.equals(spyMessage.getMessage());
	}
}
