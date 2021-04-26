package CommandsOnServer;


import Answer.Answer;
import Answer.AnswerStatus;
import Control.CollectionOperator;
import Control.Sender;
import Exceptions.EmptyCollectionException;

/**
 * Команда "remove_head". Удаляет первый элемент коллекции, перед этим выводит его в консоль.
 */
public class RemoveHead implements Executable{



    private final CollectionOperator collectionOperator;
    private final Sender sender;


    public RemoveHead(CollectionOperator collectionOperator, Sender sender) {
        this.collectionOperator = collectionOperator;
        this.sender = sender;
    }

    /**
     * Описание команды
     * @return Строка - описание
     */
    public static String description(){
        return "remove_head : вывести первый элемент коллекции и удалить его";
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
            sender.send(new Answer(collectionOperator.getWorkersCollection().getFirst().description(), AnswerStatus.OK));
            collectionOperator.removeFromCollection(collectionOperator.getWorkersCollection().getFirst());
        }  catch (EmptyCollectionException e){
            sender.send(new Answer("Коллекция пуста!",AnswerStatus.ERROR));
        }
    }
}
