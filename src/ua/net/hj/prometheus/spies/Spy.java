package ua.net.hj.prometheus.spies;

import java.util.Observable;
import java.util.Observer;

/**
 * Класс, реализующий Шпиона.
 * @author Hobbit Jedi
 */
public class Spy extends Observable implements Observer
{
	private final String mName;

	public Spy(String aName)
	{
		mName = aName;
	}
	
	@Override
	public void update(Observable aSource, Object aMessage)
	{
		AgendaItem agendaItem = (AgendaItem)aMessage;
		if (agendaItem.getName().matches("Расширение.*рядов")
			|| agendaItem.getName().matches(".*способы отмывания.*")
			|| agendaItem.getName().matches(".*источники поступления.*")
			)
		{
			String message = agendaItem.getName();
			System.out.println("Агент " + mName + " перехватил сообщение: " + message);
			setChanged();
			notifyObservers(new SpyMessage(message));
		}
	}
	
}
