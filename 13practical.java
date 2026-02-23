//Joshua Scholtz 4397173
import java.lang.Math;
import java.io.*;
import java.text.*;

public class Practical_13 {
    public static void main(String[] args) {

        System.out.print("Hey");

        long start, finish;
        double runTime = 0, runTime2 = 0, time;
        double totalTime = 0.0;
        int n = N;
        int repetition, repetitions = 30;
         runTime = 0;

        for(repetition = 0; repetition < repetitions; repetition++) {
             start = System.currentTimeMillis();
             // call the procedures to time here:
             //linearsearch (...);
             //binarysearch (...);
            finish = System.currentTimeMillis();

             time = (double)(finish - start);
             runTime += time;
             runTime2 += (time * time); }

         double aveRuntime = runTime/repetitions;
         double stdDeviation = Math.sqrt(runTime2 - (repetitions * aveRuntime * aveRuntime))/(repetitions - 1);

    }
}
