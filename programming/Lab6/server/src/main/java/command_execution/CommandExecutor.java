package connection;

import command.Command;

public interface CommandExecutor {
    String executeCommand(Command command);
}
