package command_execution;

import command.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import worker.OrdinaryWorker;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ScriptReaderImplTest {

    @Test
    void getScript() {
        ScriptReaderImpl scriptReader = new ScriptReaderImpl(getCommands());
        try {
            List<Command> commands = scriptReader.getScript("/home/alexander/HomeWorks/programming/Lab6/server/src/test/java/command_execution/TestScript");
            List<Command> expectedList = getExpectedList();
            Command com, expectedCom;
            for (int i = 0; i < commands.size(); i++) {
                com = commands.get(i);
                expectedCom = expectedList.get(i);
                assertEquals(expectedCom, com);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private List<Command> getExpectedList() {
        List<Command> result = new LinkedList<>();



        result.add(new InfoCommand());
        result.add(new InfoCommand());
        result.add(new InfoCommand());
        result.add(new InfoCommand());
        result.add(new InfoCommand());

        result.add(new ShowCommand());
        result.add(new ShowCommand());
        result.add(new ShowCommand());

        result.add(new ClearCommand());


        result.add(new HeadCommand());

        result.add(new RemoveHeadCommand());

        result.add(new PrintAscendingCommand());

        result.add(new PrintFieldDescendingSalaryCommand());

        RemoveByIdCommand removeByIdCommand = new RemoveByIdCommand();
        removeByIdCommand.setSimpleArg("1");
        result.add(removeByIdCommand);


        return result;
    }


    Map<String, Command> getCommands(){
        HashMap<String, Command> commands = new HashMap<>();
        commands.put("add", new AddCommand());
        commands.put("add_if_min", new AddIfMinCommand());
        commands.put("clear", new ClearCommand());
        commands.put("count_less_than_organization", new CountLessThanOrganizationCommand());
        commands.put("execute_script", new ExecuteScriptCommand());
        commands.put("head", new HeadCommand());
        commands.put("info", new InfoCommand());
        commands.put("print_ascending", new PrintAscendingCommand());
        commands.put("print_field_descending_salary", new PrintFieldDescendingSalaryCommand());
        commands.put("remove_by_id", new RemoveByIdCommand());
        commands.put("remove_head", new RemoveHeadCommand());
        commands.put("show", new ShowCommand());
        commands.put("update", new UpdateCommand());
        return commands;
    }
}