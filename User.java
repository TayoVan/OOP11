import java.time.LocalDateTime;

public class User {
    private UserIdentifier identifier;
    private String password;
    private LocalDateTime lastLoginDate;
    private boolean isLoggedIn;

    public User(UserIdentifier identifier, String password) {
        this.identifier = identifier;
        this.password = password;
    }

    public UserIdentifier getIdentifier() {
        return identifier;
    }

    public String getPassword() {
        return password;
    }

    public LocalDateTime getLastLoginDate() {
        return lastLoginDate;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void login() {
        isLoggedIn = true;
        lastLoginDate = LocalDateTime.now();
    }

    public void logout() {
        isLoggedIn = false;
    }

    @Override
    public String toString() {
        return "User{" +
                "identifier = " + identifier +
                ", lastLoginDate = " + lastLoginDate +
                ", isLoggedIn = " + isLoggedIn +
                '}';
    }
}