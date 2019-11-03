package pl.coderslab.model;

import pl.coderslab.utils.PasswordUtil;

public class User {
    private int id;
    private String login;
    private String password;
    private boolean admin;

    public User() {
    }

    public User(String login, String password, boolean admin) {
        this.login = login;
        this.password = PasswordUtil.createHash(password);
        this.admin = admin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
