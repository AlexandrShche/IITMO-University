package clientCommand;

import command.Command;
import io.ClientWriter;
import java.util.ResourceBundle;

public class HelpCommand implements Command {
    ClientWriter clientWriter;
    ResourceBundle bundle;
    public HelpCommand(ClientWriter clientWriter, ResourceBundle bundle){
        this.clientWriter = clientWriter;
        this.bundle = bundle;
    }

    @Override
    public void execute() {
        clientWriter.write(bundle.getString("help_message"));
    }
}
