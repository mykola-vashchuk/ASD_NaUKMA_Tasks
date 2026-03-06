package HW_5;

public class StreamSource implements MediaSource {
    private final String id;
    private final String type;
    private final int sizeMb;

    public  StreamSource(String id, String type, int sizeMb){
        this.id = id;
        this.type = type;
        this.sizeMb = sizeMb;
    }
    @Override
    public String id(){
        return id;
    }
    public String type(){
        return type;
    }
    public int sizeMb(){
        return sizeMb;
    }
    @Override
    public boolean open(){
        if(sizeMb>300)
            return false;
        System.out.println("Buffering stream data for: " + id);
        return true;
    }
}
