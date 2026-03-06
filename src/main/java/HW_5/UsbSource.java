package HW_5;

public class UsbSource implements MediaSource{
    private final String id;
    private final String type;
    private final int sizeMb;

    public  UsbSource(String id, String type, int sizeMb){
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
        if(sizeMb>1000)
            return false;
        System.out.println("Opening through Usb Source: "+ id);
        return true;
    }
}
