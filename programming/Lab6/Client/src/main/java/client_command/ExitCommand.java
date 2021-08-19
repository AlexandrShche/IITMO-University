package clientCommand;
import application.Application;
import command.Command;

public class ExitCommand implements Command {
    Application application;
    public ExitCommand(Application application){
        this.application = application;
    }
    @Override
    public void execute() {
        application.exit();
    }
}
