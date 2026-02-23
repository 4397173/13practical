//Joshua Scholtz
import java.lang.Math;
import java.io.*;
import java.text.*;
import java.util.Random;
import java.util.Scanner;

public class Practical_13 {

   public static int N = 30;
    public static void main(String[] args) {

        DecimalFormat twoD = new DecimalFormat("0.00");
        DecimalFormat fourD = new DecimalFormat("0.0000");
        DecimalFormat fiveD = new DecimalFormat("0.00000");


        int[] array = new int[32654];
        
        for (int i = 0; i < 32654; i++) {
            array[i] = i + 1;
        }

        Random rand = new Random();


        long start, finish;
        double runTime = 0, runTime2 = 0, time;
        double totalTime = 0.0;
        int n = N;
        int repetition, repetitions = 30;
         runTime = 0;

        for(repetition = 0; repetition < repetitions; repetition++) {
            int key = rand.nextInt(32654) + 1;
             start = System.currentTimeMillis();
            // call the procedures to time here:
            //linearsearch (...);
            linearSearch(array, key);


             //binarysearch (...);
            binarySearch(array, key);

           // int index = binarySearch(array, target);
            finish = System.currentTimeMillis();

             time = (double)(finish - start);
             runTime += time;
             runTime2 += (time * time); }

         double aveRuntime = runTime/repetitions;
         double stdDeviation = Math.sqrt(runTime2 - (repetitions * aveRuntime * aveRuntime))/(repetitions - 1);

        System.out.printf("Statistics\n");
        System.out.println("________________________________________________");
        System.out.println("Total time = " + runTime/1000 + "s.");
        System.out.println("Total time\u00b2 = " + runTime2);
        System.out.println("Average time = " + fiveD.format(aveRuntime/1000) + "s. " + "\u00B1" + " " + fourD.format(stdDeviation) + "ms.");
        System.out.println("Standard deviation = " + fourD.format(stdDeviation));
        System.out.println("n = " + n);
        System.out.println("Average time / run = " + fiveD.format(aveRuntime/(n * 1000)) + "\u00B5" + "s. ");
        System.out.println("Repetitions = " + repetitions);
        System.out.println("________________________________________________");
        System.out.println();
        System.out.println();

}
    private static int linearSearch(int[] array, int value) {

        for(int i = 0; i < array.length; i++) {
            if(array[i] == value) {
                return i;
            }
        }

        return -1;
    }

    private static int binarySearch(int[] array, int target) {

        int low = 0;
        int high = array.length - 1;

        while(low <= high) {

            int middle = low + (high - low) / 2;
            int value = array[middle];

            System.out.println("middle: " + value);

            if(value < target)
                low = middle + 1;
            else if (value > target)
                high = middle - 1;
            else
                return middle;
        }

        return -1;


}  private static double average(double[] values) {
        double sum = 0;
        for (double v : values) sum += v;
        return sum / values.length;
    }

    private static double stddev(double[] values, double mean) {
        double sum = 0;
        for (double v : values) sum += Math.pow(v - mean, 2);
        return Math.sqrt(sum / values.length);
    }
}
