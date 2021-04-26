import Control.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.DatagramChannel;
import java.util.Scanner;

public class ClientApp {
    public static void main(String[] args) throws IOException{

        Outputer outputer = new Outputer();

        SocketAddress address = new InetSocketAddress("localhost",1337);

        DatagramChannel channel = DatagramChannel.open();

        Receiver receiver = new Receiver(channel,address,outputer);

        Sender sender = new Sender(channel,address);

        Scanner scanner = new Scanner(System.in);

        UserDataReceiver userDataReceiver = new UserDataReceiver(scanner,outputer);

        CommandManager commandManager = new CommandManager(sender,receiver,userDataReceiver,outputer);

        CommandReader commandReader = new CommandReader(scanner,commandManager, userDataReceiver,outputer);

        commandReader.readCommand();

        sender.close();
    }
}
