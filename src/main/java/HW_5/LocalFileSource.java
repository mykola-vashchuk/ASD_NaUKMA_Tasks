package HW_5;

public class LocalFileSource implements MediaSource {
    private final String id;
    private final String type;
    private final int sizeMb;

    public LocalFileSource(String id, String type, int sizeMb) {
        this.id = id;
        this.type = type;
        this.sizeMb = sizeMb;
    }

    @Override
    public String id() {
        return id;
    }

    @Override
    public String type() {
        return type;
    }

    @Override
    public int sizeMb() {
        return sizeMb;
    }

    @Override
    public boolean open() {
        if (sizeMb > 700)
            return false;
        System.out.println("Opening local file: " + id);
        return true;
    }
}