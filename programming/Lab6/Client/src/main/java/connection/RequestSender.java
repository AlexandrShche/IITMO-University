package connection;
import network.Request;

import java.io.IOException;
import java.nio.channels.SocketChannel;

public interface RequestSender {
    void SendRequest(Request request, SocketChannel socketChannel) throws IOException;
}
