package ua.net.hj.prometheus.spies;

import java.util.Observable;

/**
 * Класс, описывающий съезд корупционеров.
 * @author Hobbit Jedi
 */
public class CorruptionersConference extends Observable
{
	private final AgendaItem[] mAgenda;
	
	public CorruptionersConference(AgendaItem[] aAgenda)
	{
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
			setChanged();
			notifyObservers(agendaItem);
		}
	}
}
