package ua.net.hj.prometheus.spies;

import java.util.ArrayList;
import java.util.Random;

/**
 * Класс, описывающий съезд корупционеров.
 * @author Hobbit Jedi
 */
public class CorruptionersConference implements Observable
{
	private final AgendaItem[] mAgenda;              // Повестка дня съезда.
	private final Random mRND;                       // Генератор случайных чисел.
	private final ArrayList<Observer> mParticipants; // Участники съезда.
	
	/**
	 * Создать съезд с указанной повесткой дня.
	 * @param aAgenda - Повестка дня создаваемого съезда.
	 */
	public CorruptionersConference(AgendaItem[] aAgenda)
	{
		mRND = new Random();
		mParticipants = new ArrayList<>();
		mAgenda = new AgendaItem[aAgenda.length];
		for (int i = 0; i < aAgenda.length; i++)
		{
			mAgenda[i] = aAgenda[i].clone();
		}
	}

	@Override
	public boolean addObserver(Observer aObserver)
	{
		boolean result = false;
		if (!mParticipants.contains(aObserver))
		{
			result = mParticipants.add(aObserver);
		}
		return result;
	}

	@Override
	public boolean deleteObserver(Observer aObserver)
	{
		return mParticipants.remove(aObserver);
	}
	
	@Override
	public void notifyObservers(Object aMessage)
	{
		for (Observer participant: mParticipants)
		{
			participant.observerNotificationHandling(this, aMessage);
		}
	}
	
	/**
	 * Провести съезд.
	 * Выполняет проведение съезда, в рамках которого рассматривается повестка дня.
	 * Каждый рассмотренный пункт повестки дня рассылается всем участникам съезда.
	 * Перед рассмотрением каждого пункта повестки дня выполняется поиск шпионов.
	 */
	public void run()
	{
		for (AgendaItem agendaItem : mAgenda)
		{
			searchSpies();
			notifyObservers(agendaItem);
		}
	}
	
	private void searchSpies()
	{
		Observer spy = null;
		for (Observer participant: mParticipants)
		{
			int dice = mRND.nextInt(100);
			if (dice < 10)
			{
				spy = participant;
				break;
			}
		}
		if (spy != null)
		{
			mParticipants.remove(spy);
			System.out.println("На съезде обнаружен и удален шпион: " + spy.toString());
		}
	}

}
