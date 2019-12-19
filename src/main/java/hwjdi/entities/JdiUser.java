package hwjdi.entities;

public class JdiUser {

    private final String login;
    private final String password;
    private final String expectedUserName;

    public JdiUser(String login, String password, String expectedUserName) {
        this.login = login;
        this.password = password;
        this.expectedUserName = expectedUserName;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getExpectedUserName() {
        return expectedUserName;
    }
}
