package PW_5;

class MultiNotifier implements  SmsNotifier, EmailNotifier{
    @Override
    public void send(String message){
        EmailNotifier.super.send(message);//чітко визначений порядок повідомлень перевизначених методів
        SmsNotifier.super.send(message);
    }
}
