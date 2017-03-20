package ua.net.hj.prometheus.spies;

import java.util.ArrayList;
import static ua.net.hj.prometheus.spies.SpiesTest.numToZeroLeadString;

/**
 * Класс, описывающий Агентство по борьбе с коррупцией.
 * @author Hobbit Jedi
 */
public class AntiCorruptionAgency implements Observer
{
	private final ArrayList<Spy> mSpies;           // Список агентов-шпионов.
	private final ArrayList<SpyMessage> mMessages; // Полученные от агентов сообщения.
	
	/**
	 * Создать новое агентство.
	 */
	public AntiCorruptionAgency()
	{
		mSpies = new ArrayList<>();
		mMessages = new ArrayList<>();
	}
	
	/**
	 * Нанять шпионов.
	 * @param aNumOfSpies - Количество шпионов, которых нужно нанять.
	 */
	public void hireSpies(int aNumOfSpies)
	{
		int agentsNumberingBase = mSpies.size();
		int agentNumberLength = Math.max(("" + (agentsNumberingBase + aNumOfSpies)).length(), 3);
		for (int i = 0; i < aNumOfSpies; i++)
		{
			Spy spy = new Spy("Агент " + numToZeroLeadString(agentsNumberingBase + i, agentNumberLength));
			mSpies.add(spy);
			spy.addObserver(this);
		}
	}
	
	/**
	 * Внедрить агентов.
	 * @param aConference - Съезд, на который нужно внедрить агентов.
	 */
	public void injectSpies(Observable aConference)
	{
		for (Spy spy : mSpies) {
			aConference.addObserver(spy);
		}
	}

	@Override
	public void observerNotificationHandling(Observable aSource, Object aMessage)
	{
		if ((aSource instanceof Spy) && (aMessage instanceof SpyMessage))
		{
			SpyMessage aSpyMessage = (SpyMessage)aMessage;
			boolean isExist = false;
			for (SpyMessage currentMessage: mMessages)
			{
				if (currentMessage.equals(aSpyMessage))
				{
					isExist = true;
					break;
				}
			}
			if (!isExist)
			{
				mMessages.add(aSpyMessage);
				System.out.println("В агенстве зарегистрировано сообщение: " + aSpyMessage.getMessage());
			}
		}
	}
}
