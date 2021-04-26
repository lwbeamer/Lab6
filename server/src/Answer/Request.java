package Answer;

import java.io.Serializable;

public class Request implements Serializable {

    private String command;
    private Object arg;

    public Request(String command) {
        this.command = command;
    }

    public Request(String command, Object arg) {
        this.command = command;
        this.arg = arg;
    }

    public Request(Object arg) {
        this.arg = arg;
    }

    public String getCommand() {
        return command;
    }

    public Object getArg() {
        return arg;
    }
}
