package CommandsOnServer;

import Answer.Answer;
import Answer.AnswerStatus;
import Control.CollectionOperator;
import Control.Sender;

import WorkerData.Worker;



/**
 * Команда "add". Добавляет элемент в коллекцию, узнав у пользователя все нужные данные
 */
public class Add implements Executable{


    private final CollectionOperator collectionOperator;
    private final Sender sender;


    public Add(CollectionOperator collectionOperator, Sender sender) {
        this.collectionOperator = collectionOperator;
        this.sender = sender;
    }

    /**
     * Описание команды
     * @return Строка - описание
     */
    public static String description() {
        return "add {element} : добавить новый элемент в коллекцию";
    }


    @Override
    public void execute(Object argument) {
        Worker workerToAdd = (Worker) argument;
        long checkNew = workerToAdd.getId();
        if (checkNew == 0) workerToAdd.setId(collectionOperator.generateId());
        collectionOperator.addToCollection(workerToAdd);
        collectionOperator.sortCollection();
        if (checkNew == 0) {
            sender.send(new Answer("Рабочий успешно добавлен!", AnswerStatus.OK));
        } else {
            sender.send(new Answer("Рабочий успешно обновлён!", AnswerStatus.OK));
        }
    }
}
