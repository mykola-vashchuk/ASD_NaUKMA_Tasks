package PW_5;

abstract class ReportGenerator {
    public final void generate(){
        fetchData();
        format();
    }
    protected abstract void fetchData();
    protected abstract void format();
}

class DailyReport extends ReportGenerator {
    @Override
        protected void fetchData() { System.out.println("Fetch DATA..."); }
    @Override
        protected void format() { System.out.println("Format ALL DATA..."); }

}
