package command;

import org.junit.jupiter.api.Test;
import worker.OrdinaryWorker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class AddCommandTest {

    @Test
    void testEquals() {
        CommandWithWorkerArg command = new AddCommand();
        command.setArg(new OrdinaryWorker());
        CommandWithWorkerArg addCommandWithOrdinaryWorker = new AddCommand();
        addCommandWithOrdinaryWorker.setArg(new OrdinaryWorker());

        assertEquals(command, addCommandWithOrdinaryWorker);

        OrdinaryWorker worker = new OrdinaryWorker();
        worker.setName("test");
        worker.setSalary(100.0);
        command.setArg(worker);

        assertNotEquals(command, addCommandWithOrdinaryWorker);

        addCommandWithOrdinaryWorker.setArg(new OrdinaryWorker(worker));

        assertEquals(command, addCommandWithOrdinaryWorker);
    }
}