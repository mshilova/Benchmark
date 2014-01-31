import java.util.*;
import java.lang.Math;

/**
 * Filename: TimeList
 * This application measures how much time it takes to add elements to
 * the front and back of a linked list and an array.
 * Takes two command line arguments, first linked or array, which specifies 
 * whether List12 is a singly list or array list, and the second back or front,
 * specifying whether adding elements to the front or the back of the list.
 *
 * @date 04/26/2013
 */ 
public class TimeList  {

  /**
   * Driver method.
   *
   */ 
  public static void main(String [] args)  {
     
      // taking two command line arguments
      String dataType = args[0];
      String frontOrBack = args[1];
      
      // number of elements ranges from 2000-50000 
      for( int I = 2000; I <= 50000; I+= 1000 )  {

         int R = 100000/I;  // init number of trials
         double totalTime = 0;   // init totals time
         double totalSquaredTime = 0; // init total squared time 
         double seconds = 0;   // init time in seconds 

         // trials 
         for(int j = 0; j < R; j++)  {
         // create the list or array depending on the option
         List<String> theL = new List12<String>();
         List<String> theA = new ArrayList<String>();
          // clear and start timing
          System.gc();
          double start = System.nanoTime();
           // adding elements to list or array
           // adding to front or back
           // all choices depend on comman line arguments
           for(int k = 0; k < I; k++)  {
            if(frontOrBack.equals("front"))  {
              if(dataType.equals("linked")) {
                // add to the front of the linked list
                theL.add(0, null);
             }
              if(dataType.equals("array"))  {
                // add to the front of the array list
                theA.add(0, null);
              }
           }
            if(frontOrBack.equals("back"))  {
              if(dataType.equals("linked")) {
                // add to the back of the linked list
                theL.add(k, null);
              }
              if(dataType.equals("array"))  {
                // add to the back of the array list
                theA.add(k, null);
              }
            }
           }
           // finish timing
           double end = System.nanoTime();
           System.gc();
           // get how much time it took from start to end
           seconds = (end - start)/ 1.0e9;
           // calculate total time
           totalTime += seconds;
           // calculate total squared time
           totalSquaredTime += seconds*seconds; 
        } 
        // calculate average
        double mean = totalTime / R ;
        // calculate standard deviation
        double stanDev = Math.sqrt( totalSquaredTime / R - mean*mean);
        // display N, then mean, standard deviation
        System.out.format("%5d\t%.6f\t%.6f\n", I,  mean, stanDev);
    }
  }
}
