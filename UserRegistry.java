import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class UserRegistry {
    private HashMap<UserIdentifier, User> users;
    private int nextId;
    public UserRegistry() {
        users = new HashMap<>();
        nextId = 1;
    }
    public void registerUser(String login, String password) {
        for (User user : users.values()) {
            if (user.getIdentifier().getName().equals(login)) {
                System.out.println("Користувач вже існує");
                return;
            }
        }
        UserIdentifier identifier =
                new UserIdentifier(nextId, login);
        User newUser = new User(identifier, password);
        users.put(identifier, newUser);
        nextId++;
        System.out.println("Користувач зареєстрований");
    }
    public void loginUser(String login, String password) {
        for (User user : users.values()) {
            if (user.getIdentifier().getName().equals(login) && user.getPassword().equals(password)) {
                user.login();
                System.out.println("Вхід успішний");
                return;
            }
        }
        System.out.println("Неправильний логін або пароль");
    }
    public void logoutUser(int id) {
        for (User user : users.values()) {
            if (user.getIdentifier().getId() == id) {
                user.logout();
                System.out.println("Користувач вийшов");
                return;
            }
        }
    }
    public boolean isUserRegistered(String login) {
        for (User user : users.values()) {
            if (user.getIdentifier().getName().equals(login)) {
                return true;
            }
        }
        return false;
    }
    public void removeUser(int id) {
        UserIdentifier removeKey = null;
        for (Map.Entry<UserIdentifier, User> entry : users.entrySet()) {
            if (entry.getKey().getId() == id) {
                removeKey = entry.getKey();
                break;
            }
        }
        if (removeKey != null) {
            users.remove(removeKey);
            System.out.println("Користувач видалений");
        }
    }
    public void printTotalUniqueUsers() {
        System.out.println("Унікальних користувачів: " + users.size());
    }
    public void displayAllUsers() {
        for (User user : users.values()) {
            System.out.println(user);
        }
    }
    public LinkedList<User> getUserList() {
        return new LinkedList<>(users.values());
    }
    public LinkedList<User> getInOrder(Comparator<User> comparator) {
        LinkedList<User> list = new LinkedList<>(users.values());
        list.sort(comparator);
        return list;
    }
    public LinkedList<User> getFiltered(UserFilter filter) {
        LinkedList<User> filtered = new LinkedList<>();
        for (User user : users.values()) {
            if (filter.check(user)) {
                filtered.add(user);
            }
        }
        return filtered;
    }
}