package HW_4;

public class EmailNotifier extends BaseNotifier{
    @Override
    public void notifyUser(String msg){
        System.out.println("Email message: "+msg);
    }
}
