package PW2_Vashchuk;

import java.util.Arrays;

public class ArrayStat {
    public static int findMin(int[] array){
        validateArray(array);
        int min = array[0];
        for (int i = 1; i < array.length; i++){
            if(array[i] < min){
                min = array[i];
            }
        }
        return min;
    }

    public static int findMax(int[] array){
        validateArray(array);
        int max = array[0];
        for (int i = 1; i < array.length;i++){
            if (array[i] > max)
                max = array[i];
        }
        return  max;
    }

    public static double findAvg(int[] array) {
        validateArray(array);
        double sum = 0;
        for (int num : array) {
            sum += num;
        }
        if(sum == 0)
            return 0;
        return sum / array.length;
    }

    private static void validateArray(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Cannot be null or empty!");
        }
    }
}
