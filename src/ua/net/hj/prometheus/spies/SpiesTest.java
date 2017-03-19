package ua.net.hj.prometheus.spies;

import java.util.Observer;

/**
 * Класс тестирования созданных объектов по задаче о Шпионах и Корупционерах.
 * @author Hobbit Jedi
 */
public class SpiesTest {
	public static void main(String[] args) {
		AgendaItem[] agenda = new AgendaItem[10];
		agenda[0] = new AgendaItem("Вступительное слово");
		agenda[1] = new AgendaItem("Отчет о результатах деятельности в прошедшем году");
		agenda[2] = new AgendaItem("Планы на следующий год");
		agenda[3] = new AgendaItem("Расширение наших рядов");
		agenda[4] = new AgendaItem("Способы защиты от отдела по борьбе с коррупцией");
		agenda[5] = new AgendaItem("Известные способы отмывания взяток");
		agenda[6] = new AgendaItem("Новые способы отмывания взяток");
		agenda[7] = new AgendaItem("Известные источники поступления взяток");
		agenda[8] = new AgendaItem("Новые источники поступления взяток");
		agenda[9] = new AgendaItem("Заключительное слово");
		CorruptionersConference conference = new CorruptionersConference(agenda);
		
		AntiCorruptionAgency agency = new AntiCorruptionAgency();
		agency.hireSpies(10);
		agency.injectSpies(conference);
		conference.run();
	}
	
	public static String numToZeroLeadString(int aNum, int aLength)
	{
		String result = "" + aNum;
		while (result.length() < aLength)
		{
			result = "0" + result;
		}
		return result;
	}
}
