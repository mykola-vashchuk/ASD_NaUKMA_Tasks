package PW_8;

import java.util.List;

public class Task2 {

    public static <T> T firstOrNull(List<T> list) {
        if (list == null || list.isEmpty()) { return null; }
        return list.get(0);
    }

    public static double sum(List<? extends Number> list) {
        double total = 0;
        if (list != null) {
            for (Number n : list) {
                total += n.doubleValue();
            }
        }
        return total;
    }

    public static void addDefaultIds(List<? super Integer> list) {
            list.add(1);
            list.add(2);
            list.add(3);
        for(Object i : list){
            System.out.println(i);
        }
    }
}
