import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserRegistry registry = new UserRegistry();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n1.Реєстрація");
            System.out.println("2.Аутентифікація");
            System.out.println("3.Вийти з сайту");
            System.out.println("4.Показати користувачів");
            System.out.println("5.Відсортувати користувачів");
            System.out.println("6.Показати відфільтрованих користувачів");
            System.out.println("0.Exit");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Login: ");
                    String login = scanner.nextLine();
                    System.out.print("Password: ");
                    String password = scanner.nextLine();
                    registry.registerUser(login, password);
                    break;
                case 2:
                    System.out.print("Login: ");
                    login = scanner.nextLine();
                    System.out.print("Password: ");
                    password = scanner.nextLine();
                    registry.loginUser(login, password);
                    break;
                case 3:
                    System.out.print("Id: ");
                    int id = scanner.nextInt();
                    registry.logoutUser(id);
                    break;
                case 4:
                    registry.displayAllUsers();
                    break;
                case 5:
                    LinkedList<User> sorted = registry.getInOrder((u1, u2) -> u1.getIdentifier().getId() - u2.getIdentifier().getId());
                    for (User user : sorted) {
                        System.out.println(user);
                    }
                    break;
                case 6:
                    LinkedList<User> filtered = registry.getFiltered(user -> user.isLoggedIn());
                    for (User user : filtered) {
                        System.out.println(user);
                    }
                    break;
                case 7:
                    registry.getUserList();
            }
        } while (choice != 0);
    }
}