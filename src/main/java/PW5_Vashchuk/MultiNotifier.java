package PW5_Vashchuk;

class MultiNotifier implements  SmsNotifier, EmailNotifier{
    @Override
    public void send(String message){
        EmailNotifier.super.send(message);
        SmsNotifier.super.send(message);
    }
}
