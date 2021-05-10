package Control;

import Answer.Answer;

import Exceptions.ServerIsNotAvailableException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.concurrent.TimeUnit;

public class Receiver{

    private final DatagramChannel channel;
    private final ByteBuffer buffer;
    private Answer answer;

    public Receiver(DatagramChannel channel) {
        this.channel = channel;
        this.buffer = ByteBuffer.allocate(16384);
    }

    public void receive()  {

    try {

        channel.configureBlocking(false);

        ((Buffer)buffer).clear();

        TimeUnit.MILLISECONDS.sleep(500);

        if (channel.receive(buffer)==null) throw new ServerIsNotAvailableException();

        ((Buffer)buffer).flip();

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(buffer.array());

        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);

        answer = (Answer) objectInputStream.readObject();

        answer.printStringAnswer();

        objectInputStream.close();
        byteArrayInputStream.close();

        ((Buffer)buffer).clear();

        } catch (InterruptedException e) {
            Outputer.printError("Ошибка прерывания!");
        } catch (ServerIsNotAvailableException e) {
            Outputer.printError("Сервер недоступен!");
        } catch (IOException | ClassNotFoundException e) {
            Outputer.printError("Сериализуемый класс не найден!");
        }
    }

    public Answer getAnswer() {
        return answer;
    }
}
