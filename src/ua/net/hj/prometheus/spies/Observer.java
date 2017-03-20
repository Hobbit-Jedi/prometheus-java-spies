package ua.net.hj.prometheus.spies;

/**
 * Интерфейс, описывающий наблюдателя.
 * @author Hobbit Jedi
 */
public interface Observer
{

	/**
	 * Обработчик, оповещений об изменениях в наблюдаемом объекте.
	 * @param aSource - Источник оповещений (наблюдаемый объект).
	 * @param aMessage - Сообщение, отправляемое наблюдаемым объектом своим наблюдателям.
	 */
	public void observerNotificationHandling(Observable aSource, Object aMessage);
}
