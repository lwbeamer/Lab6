package Control;

import Answer.Answer;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.SocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class Receiver {

    private final DatagramChannel channel;
    private final SocketAddress serverAddress;
    private final ByteBuffer buffer;
    private final Outputer outputer;
    private Answer answer;

    public Receiver(DatagramChannel channel, SocketAddress serverAddress, Outputer outputer) {
        this.outputer = outputer;
        this.channel = channel;
        this.serverAddress = serverAddress;
        this.buffer = ByteBuffer.allocate(16384);
    }

    public void run() {

    try {


        ((Buffer)buffer).clear();

        channel.connect(serverAddress);


        channel.receive(buffer);

        ((Buffer)buffer).flip();

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(buffer.array());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        answer = (Answer) objectInputStream.readObject();


        answer.printAnswer();

        objectInputStream.close();
        byteArrayInputStream.close();
        ((Buffer)buffer).clear();
        channel.disconnect();
    } catch (IOException | ClassNotFoundException e){
        outputer.printError("Не удалось получить ответ от сервера");
    }

    }

    public Answer getAnswer() {
        return answer;
    }
}
