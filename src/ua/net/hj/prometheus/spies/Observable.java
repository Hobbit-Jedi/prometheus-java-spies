package ua.net.hj.prometheus.spies;

/**
 * Интерфейс, описывающий наблюдаемый объект.
 * @author Hobbit Jedi
 */
public interface Observable
{

	/**
	 * Добавить наблюдателя в список оповещаемых.
	 * @param aObserver - Наблюдатель, которого нужно оповещать
	 *                    об изменениях в наблюдаемом объекте.
	 * @return - Признак того, что добавление наблюдателя выполнено успешно.
	 */
	public boolean addObserver(Observer aObserver);

	/**
	 * Удалить наблюдателя из списка оповещаемых.
	 * @param aObserver - Наблюдатель, которого больше не нужно оповещать
	 *                    об изменениях в наблюдаемом объекте.
	 * @return - Признак того, что удаление наблюдателя выполнено успешно.
	 */
	public boolean deleteObserver(Observer aObserver);
	
	/**
	 * Оповестить подписчиков об изменениях в наблюдаемом объекте.
	 * @param aMessage - Рассылаемое подписчикам сообщение.
	 */
	public void notifyObservers(Object aMessage);
}
