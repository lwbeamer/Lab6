package CommandsOnServer;


import Answer.Answer;
import Answer.AnswerStatus;
import Control.CollectionOperator;
import Control.Sender;
import Exceptions.EmptyCollectionException;
import Exceptions.WorkerNotFoundException;
import WorkerData.Worker;

/**
 * Команда "remove_by_id". Удаляет выбранный по ID элемент коллекции
 */
public class RemoveById implements Executable{



    private final CollectionOperator collectionOperator;
    private final Sender sender;


    public RemoveById(CollectionOperator collectionOperator, Sender sender) {
        this.collectionOperator = collectionOperator;
        this.sender = sender;
    }

    /**
     * Описание команды
     * @return Строка - описание
     */
    public static String description(){
        return "remove_by_id id : удалить элемент из коллекции по его id";
    }


    /**
     * Выполнение команды
     * @param argument - аргумент команды
     * @return Статус выполнения команды
     */
    @Override
    public void execute(Object argument) {
        try {
            if (collectionOperator.collectionSize() == 0) throw new EmptyCollectionException();
            long id = Long.parseLong((String) argument);
            Worker workerToRemove = collectionOperator.getById(id);
            if (workerToRemove == null) throw new WorkerNotFoundException();
            collectionOperator.removeFromCollection(workerToRemove);
            sender.send(new Answer("Рабочий успешно удален!", AnswerStatus.OK));
        } catch (EmptyCollectionException e) {
            sender.send(new Answer("Коллекция пуста!", AnswerStatus.ERROR));
        } catch (NumberFormatException e) {
            sender.send(new Answer("ID должен быть представлен числом!", AnswerStatus.ERROR));
        } catch (WorkerNotFoundException e) {
            sender.send(new Answer("Рабочего с таким ID в коллекции нет!", AnswerStatus.ERROR));
        }
    }
}
