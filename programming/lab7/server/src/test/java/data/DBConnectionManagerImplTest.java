package data;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.SQLException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class DBConnectionManagerImplTest {

    Properties config = new Properties();
    String url;
    String userName;
    String password;

    DBConnectionManagerImpl dbConnectionManager = new DBConnectionManagerImpl();

    @Test
    void connect() throws SQLException, ClassNotFoundException {
        try {
            readConfigFile("src/main/resources/config.properties");
        } catch (IOException e){
            e.printStackTrace();
        }
        try {
            System.out.println("ку");
            dbConnectionManager.connect(url, userName, password);
            System.out.println("SUCCESSFUL connection");
        } catch (Exception e) {
            System.out.println("UNSUCCESSFUL connection");

            e.printStackTrace();

            ClassLoader cl = ClassLoader.getSystemClassLoader();

            URL[] urls = ((URLClassLoader) cl).getURLs();

            for (URL url : urls) {
                System.out.println(url.getFile());
            }

            fail();
        }
    }

    private void readConfigFile(String fileName) throws IOException {
        FileInputStream fis;
        fis = new FileInputStream(fileName);
        config.load(fis);
        url = config.getProperty("db.url");
        userName = config.getProperty("db.username");
        password = config.getProperty("db.password");
    }

    @Test
    void testConnect() {
    }
}