package exceptions;

/**
 * сигнализирует о попытке исполнить несуществующую команду
 */
public class UnknownCommandException extends RuntimeException{
    public UnknownCommandException() {
        super("Error. Unknown command.command has been entered.");
    }
}
