package connection;

import network.Response;

public class ResponseWriterImpl implements ResponseWriter {
    @Override
    public Response writeResponse(String s) {
        return new Response(s, true);
    }
}
