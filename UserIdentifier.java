import java.util.Objects;

public class UserIdentifier {
    private int id;
    private String name;

    public UserIdentifier(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof UserIdentifier)) return false;
        UserIdentifier userIdentifier = (UserIdentifier) o;
        return id == userIdentifier.id && Objects.equals(name, userIdentifier.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "ID = " + id +
                ", name = " + name;
    }
}
