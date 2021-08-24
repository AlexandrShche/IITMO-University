package command_execution;

import command.*;
import exceptions.UnknownCommandException;
import worker.OrdinaryOrganization;
import worker.OrdinaryWorker;
import worker.Organization;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class ScriptReaderImpl implements ScriptReader{
    private final Map<String, Command> commandMap;
    LinkedList<String> script;

    public ScriptReaderImpl(Map<String, Command> commandMap){
        this.commandMap = commandMap;
    }

    @Override
    public List<Command> getScript(String scriptFileName) throws IOException {
        List<Command> commands = new LinkedList<>();
        script = readFile(scriptFileName);

        for (String str:script) {
            if(str.equals("")){
                continue;
            }
            String[] words = str.split("\\s+");
            Command command = commandMap.get(words[0]);
            if (command != null) {
                if (command instanceof SimpleCommandWithArg) {
                    ((SimpleCommandWithArg) command).setSimpleArg(words[1]);
                }
                if (command instanceof CommandWithArg) {
                    if (command instanceof CommandWithWorkerArg) {
                        ((CommandWithWorkerArg) command).setArg(readWorkerFromThisLine());
                    }
                    if (command instanceof CommandWithOrganizationArg) {
                        ((CommandWithOrganizationArg) command).setArg(readOrganizationFromThisLine());
                    }
                }
                commands.add(command);
            } else {
                throw new UnknownCommandException(str);
            }
        }

        return commands;
    }

    private LinkedList<String> readFile(String scriptFileName) throws IOException {
        LinkedList<String> result = new LinkedList<>();
        BufferedReader reader = new BufferedReader(new FileReader(scriptFileName));

        String line = reader.readLine();
        while(line != null) {
            result.add(line.trim().toLowerCase(Locale.ROOT));
            line = reader.readLine();
        }

        return result;
    }

    private Organization readOrganizationFromThisLine() {
        Organization result = new OrdinaryOrganization();

        return result;
    }

    private OrdinaryWorker readWorkerFromThisLine() {
        OrdinaryWorker result = new OrdinaryWorker();

        return result;
    }
}
