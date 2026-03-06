package HW_5;

public class ConsoleMetrics implements Metrics{
    @Override
    public void record(String event){
        if(Metrics.isValidEvent(event)){
            System.out.println("[METRIC] Event recorded: " + event);
        } else {
            recordError("Error in record. Event invalid or empty!");
        }
    }
}
