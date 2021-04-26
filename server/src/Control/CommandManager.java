package Control;


import Answer.Request;
import CommandsOnServer.Executable;
import WorkerData.Worker;

public class CommandManager {

    private final Executable helpCommand;
    private final Executable addCommand;
    private final Executable addIfMaxCommand;
    private final Executable addIfMinCommand;
    private final Executable clearCommand;
    private final Executable exitCommand;
    private final Executable filterByStatusCommand;
    private final Executable infoCommand;
    private final Executable printFieldDescendingStatusCommand;
    private final Executable removeAllByPersonCommand;
    private final Executable removeByIdCommand;
    private final Executable removeHeadCommand;
    private final Executable saveCommand;
    private final Executable showCommand;
    private final Executable updateCommand;

    public CommandManager(Executable helpCommand, Executable addCommand, Executable addIfMaxCommand, Executable addIfMinCommand,
                          Executable clearCommand, Executable exitCommand, Executable filterByStatusCommand,
                          Executable infoCommand, Executable printFieldDescendingStatusCommand, Executable removeAllByPersonCommand,
                          Executable removeByIdCommand, Executable removeHeadCommand, Executable saveCommand, Executable showCommand, Executable updateCommand) {
        this.helpCommand = helpCommand;
        this.addCommand = addCommand;
        this.addIfMaxCommand = addIfMaxCommand;
        this.addIfMinCommand = addIfMinCommand;
        this.clearCommand = clearCommand;
        this.exitCommand = exitCommand;
        this.filterByStatusCommand = filterByStatusCommand;
        this.infoCommand = infoCommand;
        this.printFieldDescendingStatusCommand = printFieldDescendingStatusCommand;
        this.removeAllByPersonCommand = removeAllByPersonCommand;
        this.removeByIdCommand = removeByIdCommand;
        this.removeHeadCommand = removeHeadCommand;
        this.saveCommand = saveCommand;
        this.showCommand = showCommand;
        this.updateCommand = updateCommand;
    }

    private String userCommand;
    private Object argument;


    public void executeCommand(Request request){
        userCommand = request.getCommand();
        argument = request.getArg();

        switch (userCommand){
            case ("help"):
                help();
                break;
            case ("show"):
                show();
                break;
            case ("info"):
                info();
                break;
            case ("add"):
                add((Worker) argument);
                break;
            case ("update"):
                update(argument);
                break;
            case ("add_if_max"):
                addIfMax((Worker) argument);
                break;
            case ("add_if_min"):
                addIfMin((Worker) argument);
                break;
            case ("clear"):
                clear();
                break;
            case ("filter_by_status"):
                filterByStatus(argument);
                break;
            case ("print_field_descending_status"):
                printFieldDescendingStatus();
                break;
            case ("remove_all_by_person"):
                removeAllByPerson(argument);
                break;
            case ("remove_by_id"):
                removeById(argument);
                break;
            case ("remove_head"):
                removeHead();
                break;
            case ("exit"):
                exit();
                break;
        }

    }

    public void help(){
        helpCommand.execute("");
    }

    public void show(){
        showCommand.execute("");
    }

    public void info(){
        infoCommand.execute("");
    }

    public void add(Worker argument){
        addCommand.execute(argument);
    }

    public void addIfMax(Worker argument){
        addIfMaxCommand.execute(argument);
    }

    public void addIfMin(Worker argument){
        addIfMinCommand.execute(argument);
    }

    public void update(Object argument){
        updateCommand.execute(argument);
    }

    public void clear(){
        clearCommand.execute("");
    }

    public void filterByStatus(Object argument){
        filterByStatusCommand.execute(argument);
    }

    public void printFieldDescendingStatus(){
        printFieldDescendingStatusCommand.execute("");
    }

    public void removeAllByPerson(Object argument){
        removeAllByPersonCommand.execute(argument);
    }

    public void removeById(Object argument){
        removeByIdCommand.execute(argument);
    }

    public void removeHead(){
        removeHeadCommand.execute("");
    }

    public void save(){
        saveCommand.execute("");
    }

    public void exit(){
        exitCommand.execute("");
    }

}
