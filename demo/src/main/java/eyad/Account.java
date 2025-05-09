package eyad;

import java.io.Serializable;

public class Account implements Serializable {
    private String website;
    private String email;
    private String password;
    private final static String FILENAME = "accounts.txt";

    public Account() {
    }

    public Account(String website, String email, String password) {
        this.website = website;
        this.email = email;
        this.password = password;
    }

    public static String getFILENAME() {
        return FILENAME;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "\nwebsite: " + website + "\nemail: " + email + "\t\t\npassword: " + password + "\n";
    }
}
