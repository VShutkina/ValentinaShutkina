package hwjdi.entities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class JdiUser {

    private final String login;
    private final String password;
    private final String expectedUserName;

    public JdiUser(String login, String password, String expectedUserName) {
        this.login = login;
        this.password = password;
        this.expectedUserName = expectedUserName;
    }

    public static final JdiUser USER = new JdiUser(
            UserProperties.getUserProperties().getProperty("username"),
            UserProperties.getUserProperties().getProperty("password"),
            UserProperties.getUserProperties().getProperty("expectedUserName"));

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getExpectedUserName() {
        return expectedUserName;
    }

    private static class UserProperties extends Properties {

        protected static UserProperties userProperties;

        static UserProperties getUserProperties() {
            if (userProperties == null) {
                userProperties = new UserProperties();
                try {
                    userProperties.load(new FileInputStream(
                            "src/main/resources/jdiUser.properties"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return userProperties;
        }
    }
}
