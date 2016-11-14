package beer;

public class Beer {

    private final long id;
    private final String type;

    public Beer(long id, String type) {
        this.id = id;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}
