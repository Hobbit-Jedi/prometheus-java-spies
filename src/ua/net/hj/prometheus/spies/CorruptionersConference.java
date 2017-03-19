package ua.net.hj.prometheus.spies;

import java.util.Observable;
import java.util.Random;

/**
 * Класс, описывающий съезд корупционеров.
 * @author Hobbit Jedi
 */
public class CorruptionersConference extends Observable
{
	private final AgendaItem[] mAgenda;
	private final Random mRND;
	
	public CorruptionersConference(AgendaItem[] aAgenda)
	{
		mRND = new Random();
		mAgenda = new AgendaItem[aAgenda.length];
		for (int i = 0; i < aAgenda.length; i++)
		{
			mAgenda[i] = aAgenda[i].clone();
		}
	}
	
	public void run()
	{
		for (AgendaItem agendaItem : mAgenda)
		{
			searchSpies();
			setChanged();
			notifyObservers(agendaItem);
		}
	}
	
	private void searchSpies()
	{
		if (countObservers()>0)
		{
			int dice = mRND.nextInt(100);
			if (dice < 30)
			{
				//TODO: Добавить удаление одного шпиона.
				System.out.println("На съезде обнаружен и удален шпион: ");
			}
		}
	}
}
