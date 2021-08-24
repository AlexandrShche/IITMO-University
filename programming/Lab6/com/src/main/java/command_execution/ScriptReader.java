package command_execution;

import command.Command;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface ScriptReader {
    List<Command> getScript(String scriptFileName) throws IOException;
}
