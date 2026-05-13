import java.util.Objects;

public class UserIdentifier {
    private int id;
    public String name;

    public UserIdentifier(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof UserIdentifier that)) return false;

        return id == that.id &&
                Objects.equals(name, that.name);
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
