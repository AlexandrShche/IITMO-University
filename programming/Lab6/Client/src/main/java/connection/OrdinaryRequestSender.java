package connection;

import network.Request;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.channels.SocketChannel;

public class OrdinaryRequestSender implements RequestSender {
    private OutputStream stream;
    @Override
    public void SendRequest(Request request, SocketChannel socketChannel) throws IOException {
        stream = socketChannel.socket().getOutputStream();
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteStream);
        objectOutputStream.writeObject(request);
        this.stream.write(byteStream.toByteArray());
        this.stream.flush();
    }
}
