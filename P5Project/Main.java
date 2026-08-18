import java.io.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static  void main (String args[]) {
        System.out.println("Welcome to the suck!");

        System.out.println("Welcome to the suck!");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE dd'th' MMM YYYY 'at' HH:mm:ss z");

        Runtime runtime = Runtime.getRuntime();

        boolean testMode = true;
        P5 uniqueListArray[] = new P5[0];


        runtime.gc(); // Run the garbage collector to free up memory
        long memoryNeeded = 1024 * 1024 * 8192; // 512 MB


        // Get the current heap size
        long heapSize = Runtime.getRuntime().totalMemory();

        // Increase the heap size to 1024 MB
        System.out.println("Max memroy used: " + (Runtime.getRuntime().maxMemory() / (1024.0 * 1024.0 * 1024.0)) + " ");

        // Print the new heap size
        System.out.println("New heap size: " + (Runtime.getRuntime().totalMemory() / (1024.0 * 1024.0 * 1024.0)) + " ");


        if (runtime.freeMemory() < memoryNeeded) {
            try {
                runtime.exec("java -Xmx" + (memoryNeeded + runtime.maxMemory()) + "m YourProgram");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.exit(0);
        }

        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long maxMemory = runtime.maxMemory();

        System.out.println("Total Memory: " + totalMemory / (1024 * 1024 * 1024) + " MB ");
        System.out.println("Free Memory: " + freeMemory / (1024 * 1024 * 1024) + " MB ");
        System.out.println("Max Memory: " + maxMemory / (1024 * 1024 * 1024) + " MB \n");


        // Set the timezone using the JAVA_TOOL_OPTIONS environment variable
        System.setProperty("user.timezone", "America/Port_of_Spain");

        // Print the current time
        ZonedDateTime nowStart = ZonedDateTime.now(ZoneId.systemDefault());
        System.out.println("Started time: " + nowStart.format(formatter));
        ZonedDateTime now = ZonedDateTime.now(ZoneId.systemDefault());
        now = ZonedDateTime.now(ZoneId.systemDefault());
        long minutes = ChronoUnit.MINUTES.between(nowStart, now);
        long hours = minutes / 60;
        long remainingMinutes = minutes % 60;
        long totalSeconds = ChronoUnit.SECONDS.between(nowStart, now);

        long seconds = totalSeconds % 60;
        long totalMillis = ChronoUnit.MILLIS.between(nowStart, now); // get total milliseconds
        long millis = totalMillis % 1000; // calculate remaining milliseconds



        /**End of code Timing Section **/
        minutes = ChronoUnit.MINUTES.between(nowStart, now);
        hours = minutes / 60;
        remainingMinutes = minutes % 60;
        totalSeconds = ChronoUnit.SECONDS.between(nowStart, now);  // convert minutes to seconds
        seconds = totalSeconds % 60;
        totalMillis = ChronoUnit.MILLIS.between(nowStart, now); // get total milliseconds
        millis = totalMillis % 1000; // calculate remaining milliseconds
        System.out.println("Elapased time from start time: " + hours + " hours and " + remainingMinutes + " minutes " + " " + seconds + " seconds" + " " + millis + " ms\n");
    }//end Main
}//end main clas
