package commadReader;

import command.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleCommandReader implements CommandReader {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public ConsoleCommandReader(){

    }
    public Command readCommand() throws IOException {
        String input;
        input = reader.readLine().trim();
        return null;
    }
}
