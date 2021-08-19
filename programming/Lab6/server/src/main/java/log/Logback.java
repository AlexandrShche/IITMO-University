package log;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

public class Logback {
    private static final Logger LOGGER = LoggerFactory.getLogger(Logback.class);

    public static void main(String[] args) {
        LOGGER.warn("This is an WARN level log message!");
        LOGGER.error("This is an ERROR level log message!");
    }
}
