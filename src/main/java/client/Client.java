package client;

public class Client {
    private final Long id;
    private final String name;

    public Client(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Client name = " + name + ", id = " + id;
    }
}
