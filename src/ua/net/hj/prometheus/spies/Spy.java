package ua.net.hj.prometheus.spies;

import java.util.ArrayList;

/**
 * Класс, реализующий Шпиона.
 * @author Hobbit Jedi
 */
public class Spy implements Observable, Observer
{
	private final String mName;                  // Имя шпиона.
	private final ArrayList<Observer> mAgencies; // Агентства, в которых состоит шпион.

	/**
	 * Создать Шпиона.
	 * @param aName - Имя создаваемого шпиона.
	 */
	public Spy(String aName)
	{
		mName = aName;
		mAgencies = new ArrayList<>();
	}
	
	@Override
	public boolean addObserver(Observer aObserver)
	{
		boolean result = false;
		if (!mAgencies.contains(aObserver))
		{
			result = mAgencies.add(aObserver);
		}
		return result;
	}

	@Override
	public boolean deleteObserver(Observer aObserver) {
		return mAgencies.remove(aObserver);
	}

	@Override
	public void notifyObservers(Object aMessage)
	{
		for (Observer agency: mAgencies)
		{
			agency.observerNotificationHandling(this, aMessage);
		}
	}

	@Override
	public void observerNotificationHandling(Observable aSource, Object aMessage)
	{
		if ((aSource instanceof CorruptionersConference) && (aMessage instanceof AgendaItem))
		{
			AgendaItem agendaItem = (AgendaItem)aMessage;
			if (agendaItem.getName().matches("Расширение.*рядов")
				|| agendaItem.getName().matches(".*способы отмывания.*")
				|| agendaItem.getName().matches(".*источники поступления.*")
				)
			{
				String message = agendaItem.getName();
				System.out.println("Агент " + mName + " перехватил сообщение: " + message);
				notifyObservers(new SpyMessage(message));
			}
		}
	}
	
	@Override
	public String toString()
	{
		return mName;
	}
	
}
