package connection;

import network.Request;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;

public interface RequestReader {
    Request readRequest(SelectionKey selectionKey) throws IOException, ClassNotFoundException;
}
