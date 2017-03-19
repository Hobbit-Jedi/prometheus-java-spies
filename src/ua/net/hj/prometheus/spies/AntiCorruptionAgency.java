package ua.net.hj.prometheus.spies;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import static ua.net.hj.prometheus.spies.SpiesTest.numToZeroLeadString;

/**
 * Класс, описывающий Агентство по борьбе с коррупцией.
 * @author Hobbit Jedi
 */
public class AntiCorruptionAgency implements Observer
{
	private final ArrayList<Spy> mSpies;
	private final ArrayList<SpyMessage> mMessages;
	
	public AntiCorruptionAgency()
	{
		mSpies = new ArrayList<>();
		mMessages = new ArrayList<>();
	}
	
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
	
	public void injectSpies(Observable aConference)
	{
		for (Spy spy : mSpies) {
			aConference.addObserver(spy);
		}
	}

	@Override
	public void update(Observable aSpy, Object aMessage)
	{
		SpyMessage aSpyMessage = (SpyMessage) aMessage;
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
