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

        /**
         * Global Variables Section
         *
         */

        boolean testMode = false;
//        boolean testModeSingleForLoop = false;
        boolean testModeSingleForLoop = true;
        int choices[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35};
        int lastPlayedLast[] = {7, 16, 26, 29, 35};
        int lastPlayedPBeforLast[] = {10, 23, 27, 28, 31};
        int nextPlayed[] = {5, 10, 13, 26, 34};
        String notIn1 = "10";
        String notIn2 = "26";

        List<ArrayList<P5[]>> listOfP5PossiblePlayableWithOutLastPlayedRemovedPairsGlobal = new ArrayList<>();
        List<P5[]> ppArrayListGlobal = new ArrayList<>();
        List<P5[]> allCombosListGlobal = new ArrayList<>();
        int globalRunIndex = 0;
        if(testMode == false && testModeSingleForLoop == false){
            globalRunIndex = 10;
        }else
        {
            globalRunIndex=1;
        }

        int endWhile = 6000;

        CheckP5In checkP5In = new CheckP5In();
        GetRandomIndex getRandomIndex = new GetRandomIndex();
          /**End Global variables**/
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE dd'th' MMM YYYY 'at' HH:mm:ss z");

        Runtime runtime = Runtime.getRuntime();

        P5 uniqueListArray[] = new P5[0];

        P5[] uniqueListArrayGlobal = new P5[0];


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

        /**Starting Logical Code**/
        System.out.println("Starting Code!");


        P5 p5 = new P5();

        ArrayList<P5> listAllComboP5 = new ArrayList<>();


        for(int globalRun = 0; globalRun < globalRunIndex; globalRun++) {

        /**calculate total amount of combinations*/
        now = ZonedDateTime.now(ZoneId.systemDefault());
        System.out.println("\tStarting Calculations at amt of combinations Now: " + now.format(formatter));
        int amtCombinations = p5.calculateAmtCombinations(choices);
        now = ZonedDateTime.now(ZoneId.systemDefault());
        System.out.println("\tFinished Calculations at amt of combinations Now: " + now.format(formatter) + " amt of combinations: " + amtCombinations);
        minutes = ChronoUnit.MINUTES.between(nowStart, now);
        hours = minutes / 60;
        remainingMinutes = minutes % 60;
        totalSeconds = ChronoUnit.SECONDS.between(nowStart, now); // convert minutes to seconds
        seconds = totalSeconds % 60;
        totalMillis = ChronoUnit.MILLIS.between(nowStart, now); // get total milliseconds
        millis = totalMillis % 1000; // calculate remaining milliseconds
        System.out.println("\tElapased time from start time: " + hours + " hours and " + remainingMinutes + " minutes " + " " + seconds + " seconds" + " " + millis + " ms\n");
        /**Finished calculate total amount of combinations*/

        /**Generating total amount of combinations as and array*/
        now = ZonedDateTime.now(ZoneId.systemDefault());
        System.out.println("\tStarting Generating combinations Now: " + now.format(formatter));
        P5 allCombos[] = new P5[amtCombinations];
        allCombos = p5.generateAllCombinations(choices, allCombos);
        allCombosListGlobal.add(allCombos);
        now = ZonedDateTime.now(ZoneId.systemDefault());
        System.out.println("\tFinished Generating combinations Now: " + now.format(formatter) + " length of all combos array: " + allCombos.length);
        minutes = ChronoUnit.MINUTES.between(nowStart, now);
        hours = minutes / 60;
        remainingMinutes = minutes % 60;
        totalSeconds = ChronoUnit.SECONDS.between(nowStart, now);  // convert minutes to seconds
        seconds = totalSeconds % 60;
        totalMillis = ChronoUnit.MILLIS.between(nowStart, now); // get total milliseconds
        millis = totalMillis % 1000; // calculate remaining milliseconds
        System.out.println("\tElapased time from start time: " + hours + " hours and " + remainingMinutes + " minutes " + " " + seconds + " seconds" + " " + millis + " ms\n");
        /**Finished Generating total amount of combinations as and array*/

        /**Sorting last played numbers to remove repeats from lastPlayedlast and lastPlayedPBeforelast */
        now = ZonedDateTime.now(ZoneId.systemDefault());
        System.out.println("Starting Sorting last played numbers to remove repeats  Now: " + now.format(formatter));
        SortLastPlayed slp = new SortLastPlayed();
        int lastPlayedNumbersWithoutRepeats[] = slp.calculateLengthOfLastPlayedWithOutRepeats(lastPlayedLast, lastPlayedPBeforLast);
        now = ZonedDateTime.now(ZoneId.systemDefault());
        System.out.println("Finished Sorting last played numbers to remove repeats  Now: " + now.format(formatter) + " length of lastPlayedNumbersWithoutRepeats array: " + lastPlayedNumbersWithoutRepeats.length);
        minutes = ChronoUnit.MINUTES.between(nowStart, now);
        hours = minutes / 60;
        remainingMinutes = minutes % 60;
        totalSeconds = ChronoUnit.SECONDS.between(nowStart, now);  // convert minutes to seconds
        seconds = totalSeconds % 60;
        totalMillis = ChronoUnit.MILLIS.between(nowStart, now); // get total milliseconds
        millis = totalMillis % 1000; // calculate remaining milliseconds
        System.out.println("Elapased time from start time: " + hours + " hours and " + remainingMinutes + " minutes " + " " + seconds + " seconds" + " " + millis + " ms\n");
        /**Sorting last played numbers to remove repeats*/


        /**Calculating the length of possible playable combos */
        now = ZonedDateTime.now(ZoneId.systemDefault());
        System.out.println("\tStarting Calculating the length of possible playable combos  Now: " + now.format(formatter));
        PossiblePlayable pp = new PossiblePlayable();
        int lengthOfPossiblePlayable = pp.calculatePossiblePlayableLength(allCombos, lastPlayedNumbersWithoutRepeats);
        now = ZonedDateTime.now(ZoneId.systemDefault());
        System.out.println("\tFinished Calculating the length of possible playable combos  Now: " + now.format(formatter) + " the legth is: " + lengthOfPossiblePlayable);
        minutes = ChronoUnit.MINUTES.between(nowStart, now);
        hours = minutes / 60;
        remainingMinutes = minutes % 60;
        totalSeconds = ChronoUnit.SECONDS.between(nowStart, now); // convert minutes to seconds
        seconds = totalSeconds % 60;
        totalMillis = ChronoUnit.MILLIS.between(nowStart, now); // get total milliseconds
        millis = totalMillis % 1000; // calculate remaining milliseconds
        System.out.println("\tElapased time from start time: " + hours + " hours and " + remainingMinutes + " minutes " + " " + seconds + " seconds" + " " + millis + " ms\n");
        /**Sorting last played numbers to remove repeats*/

        /**Generating all possible playable combos */
        now = ZonedDateTime.now(ZoneId.systemDefault());
        System.out.println("Starting Generating all possible playable combos Now: " + now.format(formatter));
        P5 ppArray[] = new P5[lengthOfPossiblePlayable];
        ppArray = pp.generatePosssiblePlayabelArray(allCombos, lastPlayedNumbersWithoutRepeats, lengthOfPossiblePlayable);
        System.out.println("Finished Calculating the length of possible playable combos  Now: " + now.format(formatter) + " length of all combos array: " + allCombos.length);
        System.out.println("FinishedGenerating all possible playable combos  Now: " + now.format(formatter) + " length of ppArray: " + ppArray.length);
        ppArrayListGlobal.add(ppArray);
        minutes = ChronoUnit.MINUTES.between(nowStart, now);
        hours = minutes / 60;
        remainingMinutes = minutes % 60;
        totalSeconds = ChronoUnit.SECONDS.between(nowStart, now); // convert minutes to seconds
        seconds = totalSeconds % 60;
        totalMillis = ChronoUnit.MILLIS.between(nowStart, now); // get total milliseconds
        millis = totalMillis % 1000; // calculate remaining milliseconds
        System.out.println("Elapased time from start time: " + hours + " hours and " + remainingMinutes + " minutes " + " " + seconds + " seconds" + " " + millis + " ms\n");
        /**Sorting last played numbers to remove repeats*/

        /**Calculate the amount of combination pair in the array lastPlayedNumbersWithoutRepeats*/
        now = ZonedDateTime.now(ZoneId.systemDefault());
        System.out.println("Starting Generating of pairs from lastPlayedNumbersWithoutRepeats now: " + now.format(formatter));
        ArrayList<int[]> pairCombinations = slp.getPairCombinations1(lastPlayedNumbersWithoutRepeats);
        System.out.println("Finished Generating of pairs from lastPlayedNumbersWithoutRepeats  Now: " + now.format(formatter) + " size of pairs of combinations: " + pairCombinations.size());
        minutes = ChronoUnit.MINUTES.between(nowStart, now);
        hours = minutes / 60;
        remainingMinutes = minutes % 60;
        totalSeconds = ChronoUnit.SECONDS.between(nowStart, now);  // convert minutes to seconds
        seconds = totalSeconds % 60;
        totalMillis = ChronoUnit.MILLIS.between(nowStart, now); // get total milliseconds
        millis = totalMillis % 1000; // calculate remaining milliseconds
        System.out.println("Elapased time from start time: " + hours + " hours and " + remainingMinutes + " minutes " + " " + seconds + " seconds" + " " + millis + " ms\n");
        /**Sorting last played numbers to remove repeats*/

        /**Sorting the int[] in the array list pairCombinations in ascending order*/
        now = ZonedDateTime.now(ZoneId.systemDefault());
        System.out.println("Starting Sorting the int[] in the array list pairCombinations in ascending order now: " + now.format(formatter));
        // Sort each int[] in ascending order
        for (int[] array : pairCombinations) {
            Arrays.sort(array);
        }
        System.out.println("FinishedSorting the int[] in the array list pairCombinations in ascending order  Now: " + now.format(formatter) + " size of pairs of combinations: " + pairCombinations.size());
        minutes = ChronoUnit.MINUTES.between(nowStart, now);
        hours = minutes / 60;
        remainingMinutes = minutes % 60;
        totalSeconds = ChronoUnit.SECONDS.between(nowStart, now);  // convert minutes to seconds
        seconds = totalSeconds % 60;
        totalMillis = ChronoUnit.MILLIS.between(nowStart, now); // get total milliseconds
        millis = totalMillis % 1000; // calculate remaining milliseconds
        System.out.println("Elapased time from start time: " + hours + " hours and " + remainingMinutes + " minutes " + " " + seconds + " seconds" + " " + millis + " ms\n");
        /**Sorting last played numbers to remove repeats*/


        /**Making pairCombinations contian unique int[] pairCombinations*/
        now = ZonedDateTime.now(ZoneId.systemDefault());
        System.out.println("Starting Making pairCombinations contian unique int[] pairCombinations now: " + now.format(formatter));
        // Sort each int[] in ascending order
        for (int i = 0; i < pairCombinations.size(); i++) {
            String arrayString = Arrays.toString(pairCombinations.get(i));
            for (int j = 0; j < pairCombinations.size(); j++) {
                if (i != j) {
                    String arrayString1 = Arrays.toString(pairCombinations.get(j));
                    if (arrayString.equals(arrayString1)) {
                        pairCombinations.remove(j);
                    }
                }
            }
        }
        System.out.println("FinishedS Making pairCombinations contian unique int[] pairCombinations Now: " + now.format(formatter) + " size of pairs of combinations: " + pairCombinations.size());
        minutes = ChronoUnit.MINUTES.between(nowStart, now);
        hours = minutes / 60;
        remainingMinutes = minutes % 60;
        totalSeconds = ChronoUnit.SECONDS.between(nowStart, now);// convert minutes to seconds
        seconds = totalSeconds % 60;
        totalMillis = ChronoUnit.MILLIS.between(nowStart, now); // get total milliseconds
        millis = totalMillis % 1000; // calculate remaining milliseconds
        System.out.println("Elapased time from start time: " + hours + " hours and " + remainingMinutes + " minutes " + " " + seconds + " seconds" + " " + millis + " ms\n");
        /**Sorting last played numbers to remove repeats*/

        /**Creating and arraylist lastPlayedNumbersWithoutRepeats without the pairCombinations*/
        now = ZonedDateTime.now(ZoneId.systemDefault());
        System.out.println("Starting Making pairCombinations contian unique int[] pairCombinations now: " + now.format(formatter));
        // Sort each int[] in ascending order
        ArrayList<int[]> listLastPlayedNumbersWithoutRepeats = new ArrayList<>();

        for (int[] pair : pairCombinations) {
            int[] tempArrayLastPlayedNumbersWithoutRepeats = new int[lastPlayedNumbersWithoutRepeats.length - 2];
            int index = 0;

            for (int num : lastPlayedNumbersWithoutRepeats) {
                if (num != pair[0] && num != pair[1]) {
                    tempArrayLastPlayedNumbersWithoutRepeats[index++] = num;
                }
            }
//            String tempStringTempArrayLastPlayedNumbersWithoutRepeats = Arrays.toString(tempArrayLastPlayedNumbersWithoutRepeats);
//            System.out.println(tempStringTempArrayLastPlayedNumbersWithoutRepeats);
//            if (!tempStringTempArrayLastPlayedNumbersWithoutRepeats.contains(notIn1) && !tempStringTempArrayLastPlayedNumbersWithoutRepeats.contains(notIn2)) {
//                System.out.println();
//                System.out.println(")---Found--(");
//                System.out.println(tempStringTempArrayLastPlayedNumbersWithoutRepeats);
//                System.out.println(")---Found--(");
//                System.out.println();
//
//            }

            listLastPlayedNumbersWithoutRepeats.add(tempArrayLastPlayedNumbersWithoutRepeats);

        }
        System.out.println("FinishedS Making pairCombinations contian unique int[] pairCombinations Now: " + now.format(formatter) + " size of pairs of combinations: " + listLastPlayedNumbersWithoutRepeats.size());
        minutes = ChronoUnit.MINUTES.between(nowStart, now);
        hours = minutes / 60;
        remainingMinutes = minutes % 60;
        totalSeconds = ChronoUnit.SECONDS.between(nowStart, now);  // convert minutes to seconds
        seconds = totalSeconds % 60;
        totalMillis = ChronoUnit.MILLIS.between(nowStart, now); // get total milliseconds
        millis = totalMillis % 1000; // calculate remaining milliseconds
        System.out.println("Elapased time from start time: " + hours + " hours and " + remainingMinutes + " minutes " + " " + seconds + " seconds" + " " + millis + " ms\n");
        /**Sorting last played numbers to remove repeats*/

        /**Create and array list of p5 arrays which utilize last played without possible playble pairs to get and array which is dh */
        now = ZonedDateTime.now(ZoneId.systemDefault());
        System.out.println("Create and array list of p5 arrays which utilize last played without possible playble pairs to get and array which is dh now: " + now.format(formatter));

        ArrayList<P5[]> listOfP5PossiblePlayableWithOutLastPlayedRemovedPairs = new ArrayList<>();
        for (int[] arrayInListLastPlayedNumbersWithoutRepeats : listLastPlayedNumbersWithoutRepeats) {
            int lengthOfPossiblePlayableWithOutLastPlayedRemovedPairs = pp.calculatePossiblePlayableLength(allCombos, arrayInListLastPlayedNumbersWithoutRepeats);

            P5 ppArrayWithOutLastPlayedRemovedPairs[] = new P5[lengthOfPossiblePlayableWithOutLastPlayedRemovedPairs];
            ppArrayWithOutLastPlayedRemovedPairs = pp.generatePosssiblePlayabelArray(allCombos, arrayInListLastPlayedNumbersWithoutRepeats, lengthOfPossiblePlayableWithOutLastPlayedRemovedPairs);
            int diffBetween_ppArray_and_ppArrayWithOutLastPlayedRemovedPairs = allCombos.length - ppArrayWithOutLastPlayedRemovedPairs.length;
            //System.out.println("Adding ppArrayWithOutLastPlayedRemovedPairs of length :"+ppArrayWithOutLastPlayedRemovedPairs.length+" to listOfP5PossiblePlayableWithOutLastPlayedRemovedPairs with a difference ppArray.length - ppArrayWithOutLastPlayedRemovedPairs.length: "+diffBetween_ppArray_and_ppArrayWithOutLastPlayedRemovedPairs);
            listOfP5PossiblePlayableWithOutLastPlayedRemovedPairs.add(ppArrayWithOutLastPlayedRemovedPairs);
        }


        System.out.println("Finished Create and array list of p5 arrays which utilize last played without possible playble pairs to get and array which is dh Now: " + now.format(formatter) + " size of pairs of combinations: " + listOfP5PossiblePlayableWithOutLastPlayedRemovedPairs.size() + " and length of array is " + listOfP5PossiblePlayableWithOutLastPlayedRemovedPairs.get(0).length);
        minutes = ChronoUnit.MINUTES.between(nowStart, now);
        hours = minutes / 60;
        remainingMinutes = minutes % 60;
        totalSeconds = ChronoUnit.SECONDS.between(nowStart, now);  // convert minutes to seconds
        seconds = totalSeconds % 60;
        totalMillis = ChronoUnit.MILLIS.between(nowStart, now); // get total milliseconds
        millis = totalMillis % 1000; // calculate remaining milliseconds
        System.out.println("Elapased time from start time: " + hours + " hours and " + remainingMinutes + " minutes " + " " + seconds + " seconds" + " " + millis + " ms\n");


        /**Sorting last played numbers to remove repeats*/


        /**
         * Generated
         * All Combos
         * All Possible playable combos with nextPlayed value
         * All possible playable numbers from lastplayed as pairs.
         * All possible playable list which contain one or more values from possible playable number as pairs
         */

        System.out.println();
        System.out.println();
        System.out.println("Entering section to take half of list  ");

//        GetRandomIndex getRandomIndex = new GetRandomIndex();

        now = ZonedDateTime.now(ZoneId.systemDefault());
        System.out.println("starting get random index: " + now.format(formatter));
        int arrayOfRandomIndexLength1 = listOfP5PossiblePlayableWithOutLastPlayedRemovedPairs.size();
        while (arrayOfRandomIndexLength1 % 2 != 0 || arrayOfRandomIndexLength1 == listOfP5PossiblePlayableWithOutLastPlayedRemovedPairs.size()) {
            if (arrayOfRandomIndexLength1 % 2 != 0) {
                arrayOfRandomIndexLength1 = arrayOfRandomIndexLength1 - 1;
                arrayOfRandomIndexLength1 = arrayOfRandomIndexLength1 / 2;
            } else {
                arrayOfRandomIndexLength1 = arrayOfRandomIndexLength1 / 2;
            }
        }

//            CheckP5In checkP5In = new CheckP5In();

        int arrayOfRandomIndex1[] = new int[arrayOfRandomIndexLength1];


        arrayOfRandomIndex1 = getRandomIndex.GRI_HashSet(listOfP5PossiblePlayableWithOutLastPlayedRemovedPairs, arrayOfRandomIndex1);

        Arrays.sort(arrayOfRandomIndex1);
        now = ZonedDateTime.now(ZoneId.systemDefault());
        System.out.println("Finishing getting random array of indexs  now: " + now.format(formatter) + " arrayOfRandomIndex length :" + arrayOfRandomIndex1.length);

        ArrayList<P5[]> listOfP5PossiblePlayableWithOutLastPlayedRemovedPairsTemp = new ArrayList<>();

        for (int i = 0; i < arrayOfRandomIndex1.length; i++) {
            System.out.println("#: " + i + " value: " + arrayOfRandomIndex1[i] + " Found: " + checkP5In.hasValue(listOfP5PossiblePlayableWithOutLastPlayedRemovedPairs.get(arrayOfRandomIndex1[i]), nextPlayed));
            for (int j = 0; j < listOfP5PossiblePlayableWithOutLastPlayedRemovedPairs.get(arrayOfRandomIndex1[i]).length; j++) {
                listOfP5PossiblePlayableWithOutLastPlayedRemovedPairs.get(arrayOfRandomIndex1[i])[j].setValue(arrayOfRandomIndex1[i]);
                //listOfP5PossiblePlayableWithOutLastPlayedRemovedPairs.get(arrayOfRandomIndex1[i])[j].setValue(100);
                //System.out.println(listOfP5PossiblePlayableWithOutLastPlayedRemovedPairs.get(arrayOfRandomIndex1[i])[j].toString());
            }
            listOfP5PossiblePlayableWithOutLastPlayedRemovedPairsTemp.add(listOfP5PossiblePlayableWithOutLastPlayedRemovedPairs.get(arrayOfRandomIndex1[i]));
        }

        listOfP5PossiblePlayableWithOutLastPlayedRemovedPairs = new ArrayList<>();
        listOfP5PossiblePlayableWithOutLastPlayedRemovedPairs = listOfP5PossiblePlayableWithOutLastPlayedRemovedPairsTemp;
        listOfP5PossiblePlayableWithOutLastPlayedRemovedPairsGlobal.add(listOfP5PossiblePlayableWithOutLastPlayedRemovedPairs);
        listOfP5PossiblePlayableWithOutLastPlayedRemovedPairsTemp = null;
        System.gc();

        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Finished halfing list of arrays new size: " + listOfP5PossiblePlayableWithOutLastPlayedRemovedPairs.size());

    }//end of globalRun affter create List of 10 Create Step.

        System.out.println("listOfP5PossiblePlayableWithOutLastPlayedRemovedPairsGlobal.size: "+listOfP5PossiblePlayableWithOutLastPlayedRemovedPairsGlobal.size());
        System.out.println("listOfP5PossiblePlayableWithOutLastPlayedRemovedPairsGlobal.getFirst().size(): "+listOfP5PossiblePlayableWithOutLastPlayedRemovedPairsGlobal.getFirst().size());
        System.out.println("listOfP5PossiblePlayableWithOutLastPlayedRemovedPairsGlobal.getFirst().getFirst().length: "+listOfP5PossiblePlayableWithOutLastPlayedRemovedPairsGlobal.getFirst().getFirst().length);


        int checkAmountofFalseInRun = 0;

        for(List<P5[]> a:listOfP5PossiblePlayableWithOutLastPlayedRemovedPairsGlobal ){
            for(P5[]b:  a){
                if(checkP5In.hasValue(b, nextPlayed) == false){
                    checkAmountofFalseInRun++;
                    break;
                }
            }
        }

        System.out.println("Amount of false in List of List Array: "+ checkAmountofFalseInRun);

        for(int globalRun = 0; globalRun < listOfP5PossiblePlayableWithOutLastPlayedRemovedPairsGlobal.size(); globalRun++) {

            ArrayList<P5[]> listOfP5PossiblePlayableWithOutLastPlayedRemovedPairs = listOfP5PossiblePlayableWithOutLastPlayedRemovedPairsGlobal.get(globalRun);
            P5[] ppArray = ppArrayListGlobal.get(globalRun);
            P5[] allCombos = allCombosListGlobal.get(globalRun);

            /**
             * Step01..
             * Use each array listOfP5PossiblePlayableWithOutLastPlayedRemovedPairs to calculate what is not in listOfP5PossiblePlayableWithOutLastPlayedRemovedPairs
             * Then take the value that is not in and the array from listOfP5PossiblePlayableWithOutLastPlayedRemovedPairs and place in a TwoArrayObject
             * Then add the two array object to a list
             */

            now = ZonedDateTime.now(ZoneId.systemDefault());
            System.out.println("starting step01 now: " + now.format(formatter)+ " globalRun: "+globalRun);


            //P5[] checkingForNotIn1 = checkP5In.notInPParrayStrings(null, null,nextPlayed);

            //create a object which has the two arrays in it
            List<TwoArrayObjects> tao = new ArrayList<>();

            for (int i = 0; i < listOfP5PossiblePlayableWithOutLastPlayedRemovedPairs.size(); i++) {
                P5[] notInTemp = checkP5In.notInPParray1(ppArray, listOfP5PossiblePlayableWithOutLastPlayedRemovedPairs.get(i));
                now = ZonedDateTime.now(ZoneId.systemDefault());
                System.out.println("\tSize of notInTemp array at #" + i + " is: " + notInTemp.length + " execution time: " + now.format(formatter));
                TwoArrayObjects taoTemp = new TwoArrayObjects(listOfP5PossiblePlayableWithOutLastPlayedRemovedPairs.get(i), notInTemp);
                tao.add(taoTemp);
                System.out.println("\t\ttao.get(" + i + ").getOne().length: " + tao.get(i).getOne().length + "tao.get(" + i + ").getTwo().length: " + tao.get(i).getTwo().length);
            }

            now = ZonedDateTime.now(ZoneId.systemDefault());
            System.out.println("Finishing step01 now: " + now.format(formatter));
            minutes = ChronoUnit.MINUTES.between(nowStart, now);
            hours = minutes / 60;
            remainingMinutes = minutes % 60;
            totalSeconds = ChronoUnit.SECONDS.between(nowStart, now);  // convert minutes to seconds
            seconds = totalSeconds % 60;
            totalMillis = ChronoUnit.MILLIS.between(nowStart, now); // get total milliseconds
            millis = totalMillis % 1000; // calculate remaining milliseconds
            System.out.println("Elapased time from start time: " + hours + " hours and " + remainingMinutes + " minutes " + " " + seconds + " seconds" + " " + millis + " ms\n");

            List<String> uniqueList = new ArrayList<>();
            P5[] globalUniqueListArrayArray = new P5[0];
            P5[] dohHaveForSureArray = new P5[0];
            P5[] halfUniqueListArray = new P5[0];
            List<TwoArrayObjects> tempTaoFinal = new ArrayList<>();
            List<TwoArrayObjects> tempTaoFinalEnd = new ArrayList<>();
            List<P5[]> dohHaveList = new ArrayList<>();
            int countWhile = 0;

            //variable holders.
            List<TwoArrayObjects> taoHolder = new ArrayList<>();
            taoHolder = tao;
            P5[] globalUniqueListArrayArrayHolder = new P5[0];

            List<TwoArrayObjects> tempTaoFinalEndHolder = new ArrayList<>();

            List<List<P5[]>> listOfP5ArrayNotInList = new ArrayList<>();
            for (int finalRunTest = 0; finalRunTest < globalRunIndex; finalRunTest++) {
                System.out.println("Staring FinalRunTest at: "+finalRunTest);
                boolean whileRun = true;
                P5 arraysOfRandFromPPArrayToCheckHolder[] = new P5[0];
                List<P5[]> p5ArrayNotInList = new ArrayList<>();
                //while (whileRun == true) {
                    tao = taoHolder;
                    if (finalRunTest != 0) {
                        globalUniqueListArrayArray = globalUniqueListArrayArrayHolder;
                    }

                   // while ((uniqueList.size() == 0 || uniqueList.size() > endWhile) && countWhile < 1) {
                        if (uniqueList.size() != 0) {
                            tao = new ArrayList<>();
                            tao = tempTaoFinal;
                        }

                        /**
                         * Step1.5
                         */
                        now = ZonedDateTime.now(ZoneId.systemDefault());
                        System.out.println("starting step1.5 now: " + now.format(formatter));
                        //CheckP5In checkP5In= new CheckP5In();
                        //create a object which has the two arrays in it
                        // List<TwoArrayObjects> tao = new ArrayList<>();

                        boolean taoOneNotNull = false;
                        for (int i = 0; i < tao.size(); i++) {

                            for (int j = 0; j < tao.get(i).getTwo().length; j++) {
                                if (tao.get(i).getTwo()[j] != null) {
                                    tao.get(i).getTwo()[j].setValue(i);
                                    taoOneNotNull = true;
                                }

                            }

                            boolean taoTwoNotNull = false;
                            for (int j = 0; j < tao.get(i).getOne().length; j++) {
                                if (tao.get(i).getOne()[j] != null) {
                                    tao.get(i).getOne()[j].setValue(i);
                                    taoTwoNotNull = true;
                                }

                            }

                            if (taoOneNotNull == true && taoTwoNotNull == true) {
                                P5[] notInTemp = checkP5In.notInPParray1(tao.get(i).getTwo(), tao.get(i).getOne(), allCombos, countWhile, nextPlayed);
//                if(countWhile > 0){
//                    notInTemp = new P5[0];
//                    notInTemp = tao.get(i).getTwo();
//                }
                                P5[] notInTempMerged = checkP5In.mergeP5Arrays(tao.get(i).getOne(), notInTemp);
                                if (countWhile > 0) {
                                    notInTempMerged = new P5[0];
                                    notInTempMerged = tao.get(i).getOne();
                                }
                                now = ZonedDateTime.now(ZoneId.systemDefault());
                                System.out.println("\tSize of notInTemp array at #" + i + " of " + tao.size() + " is: " + notInTemp.length + " and has value: " + checkP5In.hasValue(notInTempMerged, nextPlayed) + " execution time: " + now.format(formatter) + " slow");

                                //TwoArrayObjects taoTemp = new TwoArrayObjects(listOfP5PossiblePlayableWithOutLastPlayedRemovedPairs.get(i), notInTemp);
                                //tao.add(taoTemp);
                                tao.get(i).setOne(notInTempMerged);
                            }
                        }

                        now = ZonedDateTime.now(ZoneId.systemDefault());
                        System.out.println("Finishing step01.5 now: " + now.format(formatter));
                        minutes = ChronoUnit.MINUTES.between(nowStart, now);
                        hours = minutes / 60;
                        remainingMinutes = minutes % 60;
                        totalSeconds = ChronoUnit.SECONDS.between(nowStart, now);  // convert minutes to seconds
                        seconds = totalSeconds % 60;
                        totalMillis = ChronoUnit.MILLIS.between(nowStart, now); // get total milliseconds
                        millis = totalMillis % 1000; // calculate remaining milliseconds
                        System.out.println("Elapased time from start time: " + hours + " hours and " + remainingMinutes + " minutes " + " " + seconds + " seconds" + " " + millis + " ms\n");

                System.out.println();
                System.out.println();

                /**
                 * Step 02
                 */

                long step02Start = System.nanoTime();

                now = ZonedDateTime.now(ZoneId.systemDefault());

                System.out.println(
                        "Starting step02 now: " +
                                now.format(formatter)
                );

                Step02 st02 = new Step02();

                boolean tempTaoRun = true;

                List<TwoArrayObjects> flatList = new ArrayList<>();

                /*
                 * Determine threshold once.
                 */
                final int greaterThanValue;

                if (uniqueList.isEmpty() && countWhile == 0) {
                    greaterThanValue = 800;
                } else if (countWhile == 1) {
                    greaterThanValue = 100;
                } else if (countWhile == 2) {
                    greaterThanValue = 50;
                } else {
                    greaterThanValue = 800;
                }


                /*
                 * STEP 02 LOOP
                 */
                while (tempTaoRun) {

                    /*
                     * We no longer need listOfTaos.
                     * Build flatList directly.
                     */
                    flatList = new ArrayList<>();

                    /*
                     * If you know approximately how many objects
                     * will be generated, you can optionally give
                     * the ArrayList an initial capacity.
                     *
                     * flatList = new ArrayList<>(tao.size());
                     */

                    boolean allGreaterThanThreshold = true;

                    final int taoSize = tao.size();

                    for (int i = 0; i < taoSize; i++) {

                        TwoArrayObjects tempTao = tao.get(i);

                        List<TwoArrayObjects> tempListTao =
                                st02.getNewTaoList(tempTao);

                        /*
                         * DEBUG ONLY
                         */
                        if (countWhile > 0) {

                            for (int j = 0; j < tempListTao.size(); j++) {

                                TwoArrayObjects taoObject =
                                        tempListTao.get(j);

                                System.out.println(
                                        "i:" + i +
                                                " j:" + j +
                                                " One length:" +
                                                taoObject.getOne().length +
                                                " found next:" +
                                                checkP5In.hasValue(
                                                        taoObject.getOne(),
                                                        nextPlayed
                                                ) +
                                                " Two length:" +
                                                taoObject.getTwo().length +
                                                " found next:" +
                                                checkP5In.hasValue(
                                                        taoObject.getTwo(),
                                                        nextPlayed
                                                )
                                );
                            }
                        }

                        /*
                         * Add directly to flatList.
                         */
                        flatList.addAll(tempListTao);
                    }

                    System.out.println(
                            "Created flatList. Size: " +
                                    flatList.size()
                    );


                    /*
                     * Determine whether another iteration is required.
                     */
                    for (TwoArrayObjects taoObject : flatList) {

                        if (taoObject.getTwo().length <= greaterThanValue) {

                            allGreaterThanThreshold = false;

                            break;
                        }
                    }


                    /*
                     * Next iteration uses flatList.
                     */
                    tao = flatList;


                    /*
                     * Stop once at least one item is
                     * <= greaterThanValue.
                     */
                    if (!allGreaterThanThreshold) {
                        tempTaoRun = false;
                    }
                }


                /*
                 * SAFETY CHECK
                 */
                if (flatList.isEmpty()) {

                    System.out.println(
                            "Step02 finished with empty flatList."
                    );

                } else {

                    /*
                     * The original code uses the last object's
                     * Two array length as the comparison value.
                     */
                    int compareValue =
                            flatList.get(flatList.size() - 1)
                                    .getTwo()
                                    .length;


                    /*
                     * Filter in O(n).
                     *
                     * Do NOT remove elements from ArrayList
                     * while iterating forward.
                     */
                    List<TwoArrayObjects> filteredList =
                            new ArrayList<>(flatList.size());

                    for (TwoArrayObjects taoObject : flatList) {

                        if (taoObject.getTwo().length == compareValue) {

                            filteredList.add(taoObject);
                        }
                    }

                    flatList = filteredList;
                }


                /*
                 * STEP 02 FINISHED
                 */
                now = ZonedDateTime.now(ZoneId.systemDefault());

                System.out.println(
                        "Finishing step02 now: " +
                                now.format(formatter)
                );

                System.out.println(
                        "Final flatListSize: " +
                                flatList.size()
                );

                long step02ElapsedMillis =
                        (System.nanoTime() - step02Start) / 1_000_000;

                System.out.println(
                        "Step02 elapsed time: " +
                                step02ElapsedMillis +
                                " ms"
                );

                for(TwoArrayObjects a : flatList){
                    if(checkP5In.hasValue(a.getOne(), nextPlayed) == false){
//                        System.out.println("a.getOne().length: " +a.getOne().length+" "+checkP5In.hasValue(a.getOne(), nextPlayed));
                        System.out.println("Flat list of twoArrayObject has a combination is that is false: "+checkP5In.hasValue(a.getOne(), nextPlayed)+" a.getOne().length: " +a.getOne().length );
                    }
                }

                String fileName = "uniqueValueFile_P5_" + finalRunTest + ".txt";
                File file = new File(fileName);
                //begin foe test mode
                for(int testIndex = 0; testIndex < globalRunIndex; testIndex++) {


                    if (testMode == false || testIndex == 0) {

                        try {
                            if (file.exists()) {
                                if (!testMode) {
                                    // overwrite with empty file
                                    if (!file.delete()) {
                                        throw new IOException("Could not delete existing file");
                                    }
                                    file.createNewFile();
                                }
                            } else {
                                file.createNewFile();
                            }
                        } catch (IOException e) {
                            System.err.println("File creation error: " + e.getMessage());
                        }

                        // ============================================================
// REFACTORED STEP
// ============================================================
//
// Main performance improvements:
//
// 1. Minimal console output inside loops.
// 2. Removed System.gc().
// 3. Removed unnecessary 10-second Thread.sleep().
// 4. Reuse P5 objects from ppArray instead of creating copies.
// 5. Cache flatList.size(), allCombos.length and minusValue.
// 6. Avoid repeated flatList.get(i).
// 7. Build an index of allCombos once.
// 8. Avoid scanning allCombos for every unique P5.
// 9. Avoid repeated replaceAll() where possible.
// 10. Pre-size ArrayLists/HashMaps.
// 11. Keep existing checkP5In methods and algorithm.
// ============================================================


// ------------------------------------------------------------
// DEBUG
// ------------------------------------------------------------
//
// Set this to true only when you need detailed output.
//
// KEEP FALSE during normal execution.
//
                        final boolean DEBUG_STEP02 = false;


// ------------------------------------------------------------
// START TIMER
// ------------------------------------------------------------
//
// nanoTime() is much cheaper and more appropriate for measuring
// elapsed execution time than repeatedly creating ZonedDateTime.
//
                        final long step02StartNanos = System.nanoTime();


// ============================================================
// CACHE VALUES THAT DO NOT CHANGE DURING THIS SECTION
// ============================================================

                        final int flatListSize = flatList.size();
                        final int allCombosLength = allCombos.length;

                        final int minusValue =
                                uniqueList.size() > 0
                                        ? 1000
                                        : 250;


// ============================================================
// BUILD INDEX FOR allCombos
// ============================================================
//
// ORIGINAL CODE:
//
// for every uniqueList entry
//     for every allCombos entry
//         allCombos[j].toString()
//         replaceAll(...)
//         compare
//
// That can be extremely slow.
//
// We build the lookup ONCE.
//
// IMPORTANT:
// Your original comparison removes:
//
//     , value=123
//
// Therefore the "value" portion is deliberately ignored.
//
                        Map<String, P5> allCombosIndex =
                                new HashMap<>(
                                        Math.max(
                                                16,
                                                (int) (allCombosLength / 0.75f) + 1
                                        )
                                );


                        for (P5 p5AllCombos : allCombos) {

                            String p5String = p5AllCombos.toString();

                            int valuePosition =
                                    p5String.lastIndexOf(", value=");

                            String key;

                            if (valuePosition >= 0) {

                                key = p5String.substring(
                                        0,
                                        valuePosition
                                );

                            } else {

                                key = p5String;
                            }

                            /*
                             * Keep the first P5 having this combination.
                             */
                            allCombosIndex.putIfAbsent(
                                    key,
                                    p5
                            );
                        }


                        if (DEBUG_STEP02) {

                            System.out.println(
                                    "allCombos index size: "
                                            + allCombosIndex.size()
                            );
                        }


// ============================================================
// GENERATE TWO RUNS
// ============================================================

                        int runCounter = 0;

                        List<List<P5[]>> llP5 =
                                new ArrayList<>(2);


                        while (runCounter < 2) {


                            // ========================================================
                            // FIND RANDOM ARRAY CONTAINING nextPlayed
                            // ========================================================

                            boolean checkIfTrue = false;

                            P5[] arraysOfRandFromPPArrayToCheck =
                                    new P5[0];


                            while (!checkIfTrue) {


                                // ----------------------------------------------------
                                // CALCULATE RANDOM ARRAY LENGTH
                                // ----------------------------------------------------
                                //
                                // Keep your existing algorithm.
                                //
                                int arrayOfRandomIndexLength =
                                        ppArray.length;


                                while (
                                        arrayOfRandomIndexLength % 2 != 0
                                                ||
                                                arrayOfRandomIndexLength == ppArray.length
                                ) {

                                    if (
                                            arrayOfRandomIndexLength % 2 != 0
                                    ) {

                                        arrayOfRandomIndexLength--;

                                    } else {

                                        arrayOfRandomIndexLength /=
                                                2;
                                    }
                                }


                                // ----------------------------------------------------
                                // CREATE RANDOM INDEX ARRAY
                                // ----------------------------------------------------

                                int[] arrayOfRandomIndex =
                                        new int[arrayOfRandomIndexLength];


                                arrayOfRandomIndex =
                                        getRandomIndex.GRI_HashSet1(
                                                ppArray,
                                                arrayOfRandomIndex
                                        );


                                // ----------------------------------------------------
                                // IMPORTANT PERFORMANCE CHANGE
                                // ----------------------------------------------------
                                //
                                // ORIGINAL:
                                //
                                // new P5(
                                //     ppArray[index].getN1(),
                                //     ppArray[index].getN2(),
                                //     ...
                                // )
                                //
                                // This creates a new P5 object for every element.
                                //
                                // Instead, reuse the P5 object already in ppArray.
                                //
                                // This is safe provided your methods do not modify
                                // these P5 objects.
                                // ----------------------------------------------------

                                arraysOfRandFromPPArrayToCheck =
                                        new P5[arrayOfRandomIndex.length];


                                for (
                                        int i = 0;
                                        i < arrayOfRandomIndex.length;
                                        i++
                                ) {

                                    arraysOfRandFromPPArrayToCheck[i] =
                                            ppArray[arrayOfRandomIndex[i]];
                                }


                                // ----------------------------------------------------
                                // CHECK WHETHER nextPlayed EXISTS
                                // ----------------------------------------------------

                                checkIfTrue =
                                        checkP5In.hasValue(
                                                arraysOfRandFromPPArrayToCheck,
                                                nextPlayed
                                        );


                                if (DEBUG_STEP02) {

                                    System.out.println(
                                            "Random array length: "
                                                    + arraysOfRandFromPPArrayToCheck.length
                                                    + " found nextPlayed: "
                                                    + checkIfTrue
                                    );
                                }
                            }


                            // ========================================================
                            // PROCESS flatList
                            // ========================================================

                            List<P5[]> listCheckingForNotIn =
                                    new ArrayList<>();


                            int nullCounter = 0;

                            int notNullCounter = 0;

                            int tempArrayListCounter324000Counter = 0;


                            if (DEBUG_STEP02) {

                                System.out.println(
                                        "Starting flatList processing. "
                                                + "flatList size: "
                                                + flatListSize
                                                + " run: "
                                                + runCounter
                                );
                            }


                            // --------------------------------------------------------
                            // LOOP flatList
                            // --------------------------------------------------------

                            for (
                                    int i = 0;
                                    i < flatListSize;
                                    i++
                            ) {


                                // ----------------------------------------------------
                                // GET OBJECT ONCE
                                // ----------------------------------------------------

                                TwoArrayObjects currentFlatObject =
                                        flatList.get(i);


                                P5[] tempFlatListArray =
                                        currentFlatObject.getOne();


                                // ----------------------------------------------------
                                // SKIP UNNECESSARY ENTRIES
                                // ----------------------------------------------------

                                if (
                                        tempFlatListArray.length
                                                <=
                                                (allCombosLength - minusValue)
                                ) {

                                    continue;
                                }


                                // ----------------------------------------------------
                                // WHEN countWhile > 0
                                // USE tao ARRAY
                                // ----------------------------------------------------

                                if (countWhile > 0) {

                                    P5[] taoOne =
                                            tao.get(0).getOne();

                                    P5[] taoTwo =
                                            tao.get(0).getTwo();


                                    if (
                                            taoOne.length > taoTwo.length
                                    ) {

                                        arraysOfRandFromPPArrayToCheck =
                                                taoTwo;

                                    } else {

                                        arraysOfRandFromPPArrayToCheck =
                                                taoOne;
                                    }
                                }


                                // ----------------------------------------------------
                                // CALCULATE NOT-IN
                                // ----------------------------------------------------

                                P5[] checkingForNotIn;


                                if (countWhile == 0) {

                                    checkingForNotIn =
                                            checkP5In.notInPParrayStringsOptimized3(
                                                    arraysOfRandFromPPArrayToCheck,
                                                    tempFlatListArray,
                                                    nextPlayed,
                                                    i,
                                                    flatListSize,
                                                    countWhile
                                            );

                                } else {

                                    checkingForNotIn =
                                            checkP5In.notInPParrayStringsOptimized4(
                                                    arraysOfRandFromPPArrayToCheck,
                                                    tempFlatListArray,
                                                    nextPlayed,
                                                    i,
                                                    flatListSize,
                                                    countWhile
                                            );
                                }


                                // ----------------------------------------------------
                                // NULL RESULT
                                // ----------------------------------------------------

                                if (checkingForNotIn == null) {

                                    nullCounter++;

                                    continue;
                                }


                                int checkingLength =
                                        checkingForNotIn.length;


                                // ====================================================
                                // FIRST RUN
                                // ====================================================

                                if (
                                        countWhile == 0
                                                &&
                                                checkingLength > 0
                                                &&
                                                checkingLength < 131
                                ) {

                                    notNullCounter++;


                                    listCheckingForNotIn.add(
                                            checkingForNotIn
                                    );


                                    tempArrayListCounter324000Counter++;


                                    // ------------------------------------------------
                                    // ONLY CREATE tempTao DURING FIRST RUN
                                    // ------------------------------------------------

                                    if (runCounter == 0) {

                                        tempTaoFinal.add(
                                                new TwoArrayObjects(
                                                        tempFlatListArray,
                                                        null
                                                )
                                        );
                                    }


                                } else {


                                    // =================================================
                                    // countWhile > 0
                                    // =================================================

                                    if (
                                            countWhile > 0
                                                    &&
                                                    checkingLength > 0
                                    ) {

                                        listCheckingForNotIn.add(
                                                checkingForNotIn
                                        );


                                        tempArrayListCounter324000Counter++;


                                        // --------------------------------------------
                                        // ONLY FIRST RUN
                                        // --------------------------------------------

                                        if (runCounter == 0) {

                                            tempTaoFinal.add(
                                                    new TwoArrayObjects(
                                                            tempFlatListArray,
                                                            null
                                                    )
                                            );
                                        }
                                    }


                                    nullCounter++;
                                }
                            }


                            // ========================================================
                            // SAVE THIS RUN
                            // ========================================================

                            llP5.add(
                                    listCheckingForNotIn
                            );


                            if (DEBUG_STEP02) {

                                System.out.println(
                                        "Run "
                                                + runCounter
                                                + " complete."
                                );

                                System.out.println(
                                        "Null Counter: "
                                                + nullCounter
                                );

                                System.out.println(
                                        "Not Null Counter: "
                                                + notNullCounter
                                );

                                System.out.println(
                                        "tempArrayListCounter324000 Counter: "
                                                + tempArrayListCounter324000Counter
                                );

                                System.out.println(
                                        "listCheckingForNotIn size: "
                                                + listCheckingForNotIn.size()
                                );
                            }


                            runCounter++;


                            arraysOfRandFromPPArrayToCheckHolder =
                                    arraysOfRandFromPPArrayToCheck;
                        }


// ============================================================
// DO NOT DO THIS:
//
// Thread.sleep(10000);
//
// It adds 10 seconds to every execution.
//
// If you intentionally need it for synchronization, keep it.
// Otherwise remove it.
//
// ============================================================


// ============================================================
// INSPECT llP5
// ============================================================
//
// This section is diagnostic only.
//
// It does not appear to alter llP5.
//
// Therefore it should NOT execute during normal processing.
//
                        if (DEBUG_STEP02) {

                            for (
                                    int i = 0;
                                    i < llP5.size();
                                    i++
                            ) {

                                List<P5[]> currentList =
                                        llP5.get(i);


                                for (
                                        int j = 0;
                                        j < currentList.size();
                                        j++
                                ) {

                                    P5[] currentArray =
                                            currentList.get(j);


                                    if (currentArray.length == 0) {
                                        continue;
                                    }


                                    int value =
                                            currentArray[0].getValue();


                                    for (
                                            int k = 0;
                                            k < currentArray.length;
                                            k++
                                    ) {

                                        P5 currentP5 =
                                                currentArray[k];


                                        if (
                                                currentP5.getValue()
                                                        != value
                                        ) {

                                            value =
                                                    currentP5.getValue();
                                        }


                                        if (
                                                currentP5.getN1()
                                                        == nextPlayed[0]
                                                        &&
                                                        currentP5.getN2()
                                                                == nextPlayed[1]
                                                        &&
                                                        currentP5.getN3()
                                                                == nextPlayed[2]
                                                        &&
                                                        currentP5.getN4()
                                                                == nextPlayed[3]
                                                        &&
                                                        currentP5.getN5()
                                                                == nextPlayed[4]
                                        ) {

                                            System.out.println(
                                                    "FOUND at K="
                                                            + k
                                                            + " J="
                                                            + j
                                                            + " I="
                                                            + i
                                                            + " : "
                                                            + currentP5
                                            );
                                        }
                                    }
                                }
                            }
                        }


// ============================================================
// CREATE finalList
// ============================================================
//
// IMPORTANT:
//
// This is potentially the largest remaining computational
// section.
//
// It performs:
//
//     list1.size() x list2.size()
//
// calls to getListOfP5Final().
//
// We cannot safely eliminate this nested loop without changing
// the algorithm inside getListOfP5Final().
//
// We CAN however eliminate all diagnostic output from it.
//
                        List<P5> finalList =
                                new ArrayList<>();


                        for (
                                int i = 0;
                                i + 1 < llP5.size();
                                i++
                        ) {

                            List<P5[]> list1 =
                                    llP5.get(i);

                            List<P5[]> list2 =
                                    llP5.get(i + 1);


                            if (DEBUG_STEP02) {

                                System.out.println(
                                        "List "
                                                + i
                                                + " size: "
                                                + list1.size()
                                                + " | List "
                                                + (i + 1)
                                                + " size: "
                                                + list2.size()
                                );
                            }


                            for (P5[] listOneArray : list1) {

                                for (P5[] listTwoArray : list2) {

                                    List<P5> finalListTemp =
                                            checkP5In.getListOfP5Final(
                                                    listOneArray,
                                                    listTwoArray,
                                                    nextPlayed
                                            );


                                    if (
                                            finalListTemp != null
                                                    &&
                                                    !finalListTemp.isEmpty()
                                    ) {

                                        finalList.addAll(
                                                finalListTemp
                                        );
                                    }
                                }
                            }
                        }


// ============================================================
// COUNT P5 OCCURRENCES
// ============================================================
//
// Your original code:
//
// finalList
//     ↓
// Stream
//     ↓
// P5.toString()
//     ↓
// List<String>
//     ↓
// HashMap<String,Integer>
//
// We still need strings here because your existing
// uniqueList is a List<String>.
//
// But we only create each P5 string once.
//
// ============================================================

                        System.out.println(
                                "Size of finalList: "
                                        + finalList.size()
                        );


                        List<String> stringListP5 =
                                new ArrayList<>(
                                        finalList.size()
                                );


                        for (P5 p5FinalList : finalList) {

                            stringListP5.add(
                                    p5FinalList.toString()
                            );
                        }


                        System.out.println(
                                "Size of stringListP5: "
                                        + stringListP5.size()
                        );


// ============================================================
// COUNT OCCURRENCES
// ============================================================

                        Map<String, Integer> countMap =
                                new HashMap<>(
                                        Math.max(
                                                16,
                                                (int) (stringListP5.size() / 0.75f)
                                                        + 1
                                        )
                                );


                        for (String value : stringListP5) {

                            Integer currentCount =
                                    countMap.get(value);


                            if (currentCount == null) {

                                countMap.put(
                                        value,
                                        1
                                );

                            } else {

                                countMap.put(
                                        value,
                                        currentCount + 1
                                );
                            }
                        }


// ============================================================
// BUILD uniqueList
// ============================================================
//
// A major optimization:
//
// Instead of looping over stringListP5 and looking up every
// value again, use countMap.entrySet().
//
// This means each unique String is processed once.
//
                        uniqueList =
                                new ArrayList<>(
                                        countMap.size()
                                );


                        for (
                                Map.Entry<String, Integer> entry
                                : countMap.entrySet()
                        ) {

                            if (
                                    entry.getValue() == 1
                            ) {

                                uniqueList.add(
                                        entry.getKey()
                                );
                            }
                        }


                        System.out.println(
                                "Size of uniqueList: "
                                        + uniqueList.size()
                        );


// ============================================================
// FIND uniqueList IN allCombos
// ============================================================
//
// THIS IS ONE OF THE BIGGEST IMPROVEMENTS.
//
// Original:
//
// for uniqueList
//     for allCombos
//         toString()
//         replaceAll()
//         equals()
//
// New:
//
// for uniqueList
//     HashMap.get()
//
// ============================================================

                        P5[] uniqueListArray2 =
                                new P5[uniqueList.size()];


                        for (
                                int i = 0;
                                i < uniqueList.size();
                                i++
                        ) {

                            String relevantPart =
                                    uniqueList.get(i);


                            P5 foundP5 =
                                    allCombosIndex.get(
                                            relevantPart
                                    );


                            if (foundP5 != null) {

                                /*
                                 * Preserve your original behavior of creating a new
                                 * P5 without the value.
                                 */
                                uniqueListArray2[i] =
                                        new P5(
                                                foundP5.getN1(),
                                                foundP5.getN2(),
                                                foundP5.getN3(),
                                                foundP5.getN4(),
                                                foundP5.getN5()
                                        );
                            }
                        }


                        uniqueListArray =
                                uniqueListArray2;


                        System.out.println(
                                "Found in unique List here : "
                                        + checkP5In.hasValue(
                                        uniqueListArray,
                                        nextPlayed
                                )
                        );


                        globalUniqueListArrayArray =
                                uniqueListArray;

                        uniqueListArrayGlobal = uniqueListArray;


                        if (finalRunTest == 0) {

                            globalUniqueListArrayArrayHolder =
                                    globalUniqueListArrayArray;
                        }


// ============================================================
// UNIQUE VALUES WHEN countWhile > 0
// ============================================================
//
// Original code:
//
// Set<String> set = new HashSet<>(stringListP5);
//
// Convert Set back to List.
//
// We can avoid creating the Set AND then copying it into a
// second List by using the HashMap keys.
//
                        if (countWhile > 0) {

                            List<String> uniqueList1 =
                                    new ArrayList<>(
                                            countMap.size()
                                    );


                            for (
                                    String value
                                    : countMap.keySet()
                            ) {

                                uniqueList1.add(
                                        value
                                );
                            }


                            System.out.println(
                                    "Size of uniqueList1: "
                                            + uniqueList1.size()
                            );


                            P5[] uniqueListArray1 =
                                    new P5[uniqueList1.size()];


                            for (
                                    int i = 0;
                                    i < uniqueList1.size();
                                    i++
                            ) {

                                String relevantPart =
                                        uniqueList1.get(i);


                                P5 foundP5 =
                                        allCombosIndex.get(
                                                relevantPart
                                        );


                                if (foundP5 != null) {

                                    uniqueListArray1[i] =
                                            new P5(
                                                    foundP5.getN1(),
                                                    foundP5.getN2(),
                                                    foundP5.getN3(),
                                                    foundP5.getN4(),
                                                    foundP5.getN5()
                                            );
                                }
                            }


                            System.out.println(
                                    "Found in unique List1: "
                                            + checkP5In.hasValue(
                                            uniqueListArray1,
                                            nextPlayed
                                    )
                            );


                            if (
                                    uniqueList.size() == 0
                            ) {

                                System.out.println(
                                        "Setting uniqueListArray to uniqueListArray1"
                                );


                                uniqueListArray =
                                        uniqueListArray1;

                                uniqueListArrayGlobal = uniqueListArray;
                            }
                        }


// ============================================================
// FINAL TIMING
// ============================================================

                        step02ElapsedMillis =
                                (
                                        System.nanoTime()
                                                - step02StartNanos
                                )
                                        / 1_000_000L;


                        System.out.println(
                                "Step02 execution time: "
                                        + step02ElapsedMillis
                                        + " ms"
                        );





                    }
//                    else {
//
//
//                        int runCounter = 0;
//                        List<List<P5[]>> llP5 = new ArrayList<>();
//
//                        while (runCounter < 2) {
//
//                            boolean checkIfTrue = false;
//                            P5 arraysOfRandFromPPArrayToCheck[] = new P5[0];
//                            while (checkIfTrue == false) {
//                                now = ZonedDateTime.now(ZoneId.systemDefault());
//                                System.out.println("starting get random index: " + now.format(formatter));
//                                int arrayOfRandomIndexLength = ppArray.length;
//                                while (arrayOfRandomIndexLength % 2 != 0 || arrayOfRandomIndexLength == ppArray.length) {
//                                    if (arrayOfRandomIndexLength % 2 != 0) {
//                                        arrayOfRandomIndexLength = arrayOfRandomIndexLength - 1;
//                                    } else {
//                                        arrayOfRandomIndexLength = arrayOfRandomIndexLength / 2;
//                                    }
//                                }
//
//
//                                int arrayOfRandomIndex[] = new int[arrayOfRandomIndexLength];
//
//
//                                arrayOfRandomIndex = getRandomIndex.GRI_HashSet1(ppArray, arrayOfRandomIndex);
//
//                                now = ZonedDateTime.now(ZoneId.systemDefault());
//                                System.out.println("Finishing getting random array of indexs  now: " + now.format(formatter) + " arrayOfRandomIndex length :" + arrayOfRandomIndex.length + " of ppArray of length:" + ppArray.length);
//
//                                minutes = ChronoUnit.MINUTES.between(nowStart, now);
//                                hours = minutes / 60;
//                                remainingMinutes = minutes % 60;
//                                totalSeconds = ChronoUnit.SECONDS.between(nowStart, now);  // convert minutes to seconds
//                                seconds = totalSeconds % 60;
//                                totalMillis = ChronoUnit.MILLIS.between(nowStart, now); // get total milliseconds
//                                millis = totalMillis % 1000; // calculate remaining milliseconds
//                                System.out.println("Elapased time from start time: " + hours + " hours and " + remainingMinutes + " minutes " + " " + seconds + " seconds" + " " + millis + " ms\n");
//
//
//                                now = ZonedDateTime.now(ZoneId.systemDefault());
//                                System.out.println("starting get random half array: " + now.format(formatter));
//                                arraysOfRandFromPPArrayToCheck = new P5[arrayOfRandomIndex.length];
//                                for (int i = 0; i < arrayOfRandomIndex.length; i++) {
//                                    int arrayOfRandomIndexValue = arrayOfRandomIndex[i];
//                                    arraysOfRandFromPPArrayToCheck[i] = new P5(ppArray[arrayOfRandomIndexValue].getN1(), ppArray[arrayOfRandomIndexValue].getN2(), ppArray[arrayOfRandomIndexValue].getN3(), ppArray[arrayOfRandomIndexValue].getN4(), ppArray[arrayOfRandomIndexValue].getN5());
//                                }
//                                now = ZonedDateTime.now(ZoneId.systemDefault());
//                                checkIfTrue = checkP5In.hasValue(arraysOfRandFromPPArrayToCheck, nextPlayed);
//                                minutes = ChronoUnit.MINUTES.between(nowStart, now);
//                                System.out.println("Finishing get random half array: " + now.format(formatter) + " arraysOfRandFromPPArrayToCheck length :" + arraysOfRandFromPPArrayToCheck.length + " step02 arraysOfRandFromPPArrayToCheck Found in: " + checkIfTrue);
//                                minutes = ChronoUnit.MINUTES.between(nowStart, now);
//                                hours = minutes / 60;
//                                remainingMinutes = minutes % 60;
//                                totalSeconds = ChronoUnit.SECONDS.between(nowStart, now);  // convert minutes to seconds
//                                seconds = totalSeconds % 60;
//                                totalMillis = ChronoUnit.MILLIS.between(nowStart, now); // get total milliseconds
//                                millis = totalMillis % 1000; // calculate remaining milliseconds
//                                System.out.println("Elapased time from start time: " + hours + " hours and " + remainingMinutes + " minutes " + " " + seconds + " seconds" + " " + millis + " ms\n");
//                            }
//
//                            List<P5[]> listCheckingForNotIn = new ArrayList<>();
//                            now = ZonedDateTime.now(ZoneId.systemDefault());
//                            System.out.println("starting CHECKING get random half array with uniqueList.size: " + uniqueList.size() + " at: " + now.format(formatter));
//                            int nullCounter = 0;
//                            int notNullCounter = 0;
//                            int tempArrayListCounter324000Counter = 0;
//
//                            System.out.println();
//                            for (int i = 0; i < flatList.size(); i++) {
//                                P5[] tempFlatListArray = flatList.get(i).getOne();
//                                if (countWhile > 0) {
//                                    System.out.println("\ni: " + i + " flat list found flatList.get(i).getOne(): " + checkP5In.hasValue(flatList.get(i).getOne(), nextPlayed) + " with length of: " + flatList.get(i).getOne().length);
//                                    System.out.println("i: " + i + " flat list found flatList.get(i).getTwo(): " + checkP5In.hasValue(flatList.get(i).getTwo(), nextPlayed) + " with length of: " + flatList.get(i).getTwo().length);
//                                }
//                                int minusValue = 250;
//                                if (uniqueList.size() > 0) {
//                                    minusValue = 1000;
//                                }
//
//                                if (tempFlatListArray.length > (allCombos.length - minusValue)) {
//                                    //System.out.println();
//                                    //here is where we get
//                                    if (countWhile > 0) {
//                                        arraysOfRandFromPPArrayToCheck = new P5[0];
//                                        if (tao.get(0).getOne().length > tao.get(0).getTwo().length) {
////                                arraysOfRandFromPPArrayToCheck = tao.get(0).getOne();
//                                            arraysOfRandFromPPArrayToCheck = tao.get(0).getTwo();
//                                            System.out.println("#:" + i + " in if arrays of random index for flatList.get(i) found: " + checkP5In.hasValue(arraysOfRandFromPPArrayToCheck, nextPlayed) + " of length: " + arraysOfRandFromPPArrayToCheck.length);
//                                        } else {
//                                            arraysOfRandFromPPArrayToCheck = tao.get(0).getOne();
//                                            System.out.println("#:" + i + " in else arrays of random index for flatList.get(i) found: " + checkP5In.hasValue(arraysOfRandFromPPArrayToCheck, nextPlayed) + " of length: " + arraysOfRandFromPPArrayToCheck.length);
//
//                                        }
//                                    }
//
//                                    P5[] checkingForNotIn = new P5[0];
//                                    if (countWhile == 0) {
//                                        checkingForNotIn = checkP5In.notInPParrayStringsOptimized3(arraysOfRandFromPPArrayToCheck, tempFlatListArray, nextPlayed, i, flatList.size(), countWhile);
//                                    } else {
//                                        checkingForNotIn = checkP5In.notInPParrayStringsOptimized4(arraysOfRandFromPPArrayToCheck, tempFlatListArray, nextPlayed, i, flatList.size(), countWhile);
//                                    }
//                                    //P5[] checkingForNotIn = checkP5In.notInPParrayStrings(tempFlatListArray,arraysOfRandFromPPArrayToCheck,nextPlayed);
//
////                        if(checkingForNotIn != null){
////                            System.out.println("entering if checkingfornotin. "+checkingForNotIn.length);
////                        }
//
//
//                                    now = ZonedDateTime.now(ZoneId.systemDefault());
//                                    if (checkingForNotIn != null) {
//                                        System.out.println("Checking for not in length:" + checkingForNotIn.length);
//                                        if (/*checkingForNotIn.length > 90 && */checkingForNotIn.length > 0 && checkingForNotIn.length < 131 && countWhile < 1) {
//                                            System.out.println("in if checkingfornotin. has value: " + checkP5In.hasValue(checkingForNotIn, nextPlayed));
//                                            // System.out.println("\t#" + i + " notNullCounter checkingForNotIn length: " + checkingForNotIn.length + " at: " + now.format(formatter));
//                                            notNullCounter++;
//                                            if (tempFlatListArray.length > (allCombos.length - minusValue)) {
//                                                System.out.println("in if if checkingfornotin.");
//                                                listCheckingForNotIn.add(checkingForNotIn);
//                                                tempArrayListCounter324000Counter++;
//                                                if (runCounter < 1) {
//                                                    System.out.println("in if if if checkingfornotin.");
//                                                    TwoArrayObjects tempTao = new TwoArrayObjects(tempFlatListArray, null);
//                                                    tempTaoFinal.add(tempTao);
//                                                    tempTao = null;
//                                                    System.gc();
//                                                }
//
//                                            }
//
//                                        } else {
//                                            System.out.println("Found in else checking for not in : " + checkP5In.hasValue(checkingForNotIn, nextPlayed));
//                                            System.out.println("Checking for not in else length :" + checkingForNotIn.length);
//                                            System.out.println("in else checkingfornotin is null");
//                                            nullCounter++;
//                                            if (countWhile > 0) {
//
//                                                System.out.println("in else if with a countWhile: " + countWhile);
//                                                if (tempFlatListArray.length > (allCombos.length - minusValue)) {
//                                                    System.out.println("in else if if checkingfornotin.");
//                                                    if (checkingForNotIn != null) {
//                                                        if (checkingForNotIn.length > 0) {
//                                                            System.out.println("in else if if if if checkingfornotin > 0.");
//                                                            listCheckingForNotIn.add(checkingForNotIn);
//                                                            tempArrayListCounter324000Counter++;
//                                                            if (runCounter < 1) {
//                                                                System.out.println("in else if if if checkingfornotin.");
//                                                                TwoArrayObjects tempTao = new TwoArrayObjects(tempFlatListArray, null);
//                                                                tempTaoFinal.add(tempTao);
//                                                                tempTao = null;
//                                                                System.gc();
//                                                            }
//                                                        }
//                                                    }
//                                                }
//                                            }
//
//                                            //System.out.println("\t#" + i + " nullCounter checkingForNotIn length: " + checkingForNotIn.length + " at: " + now.format(formatter));
//
//                                            //System.out.println("\t#"+i+" null at: "+ now.format(formatter));
//                                        }
//
//                                        // checkingForNotIn = null;
//                                        // System.gc();
//                                    }
//                                }
//                                //System.out.println("\t#"+i+" checkingForNotIn length: "+checkingForNotIn.length+" at: "+ now.format(formatter));
//                            }//end for
//
//                            System.out.println("Null Counter: " + nullCounter);
//                            System.out.println("Not Null Counter: " + notNullCounter);
//                            System.out.println("tempArrayListCounter324000 Counter: " + tempArrayListCounter324000Counter);
//
//                            System.out.println("Size of listCheckingForNotIn: " + listCheckingForNotIn.size());
//                            llP5.add(listCheckingForNotIn);
//                            listCheckingForNotIn = null;
//                            System.gc();
//                            now = ZonedDateTime.now(ZoneId.systemDefault());
//                            System.out.println("Finishing CHECKING get random half array: " + now.format(formatter));
//                            minutes = ChronoUnit.MINUTES.between(nowStart, now);
//                            hours = minutes / 60;
//                            remainingMinutes = minutes % 60;
//                            totalSeconds = ChronoUnit.SECONDS.between(nowStart, now);  // convert minutes to seconds
//                            seconds = totalSeconds % 60;
//                            totalMillis = ChronoUnit.MILLIS.between(nowStart, now); // get total milliseconds
//                            millis = totalMillis % 1000; // calculate remaining milliseconds
//                            System.out.println("Elapased time from start time: " + hours + " hours and " + remainingMinutes + " minutes " + " " + seconds + " seconds" + " " + millis + " ms\n");
//
//                            runCounter++;
//                            arraysOfRandFromPPArrayToCheckHolder = arraysOfRandFromPPArrayToCheck;
//
//                        }
//
//                        try {
//                            Thread.sleep(10000);
//                        } catch (InterruptedException e) {
//                            throw new RuntimeException(e);
//                        }
//
//                        now = ZonedDateTime.now(ZoneId.systemDefault());
//                        System.out.println("starting llP5 get random half array: " + now.format(formatter));
//
////issue point here potential could be in from 648 - 734 line
//                        for (int i = 0; i < llP5.size(); i++) {
//                            for (int j = 0; j < llP5.get(i).size(); j++) {
//                                // System.out.println(llP5.get(i).get(j).length);
//                                int value = llP5.get(i).get(j)[0].getValue();
//                                // boolean isOnlyOneValue = true;
//                                // System.out.println("\tValue :"+value);
//                                for (int k = 0; k < llP5.get(i).get(j).length; k++) {
//                                    if (llP5.get(i).get(j)[k].getValue() != value) {
//                                        value = llP5.get(i).get(j)[k].getValue();
//                                        //isOnlyOneValue = false;
//                                        //   System.out.println("\tValue :"+value);
//                                    }
//                                    if (llP5.get(i).get(j)[k].getN1() == nextPlayed[0] && llP5.get(i).get(j)[k].getN2() == nextPlayed[1] && llP5.get(i).get(j)[k].getN3() == nextPlayed[2] && llP5.get(i).get(j)[k].getN4() == nextPlayed[3] && llP5.get(i).get(j)[k].getN5() == nextPlayed[4]) {
//                                        //issue point not finding after second run of
//                                        System.out.println("\t\tFound at K:" + k + " of j: " + j + " of i:" + i + " : " + llP5.get(i).get(j)[k].toString());
//                                    }
//
//                                }
//
//                            }
//                        }
//
//                        now = ZonedDateTime.now(ZoneId.systemDefault());
//                        System.out.println("Finishing llp5 get random half array: " + now.format(formatter));
//                        minutes = ChronoUnit.MINUTES.between(nowStart, now);
//                        hours = minutes / 60;
//                        remainingMinutes = minutes % 60;
//                        totalSeconds = ChronoUnit.SECONDS.between(nowStart, now);  // convert minutes to seconds
//                        seconds = totalSeconds % 60;
//                        totalMillis = ChronoUnit.MILLIS.between(nowStart, now); // get total milliseconds
//                        millis = totalMillis % 1000; // calculate remaining milliseconds
//                        System.out.println("Elapased time from start time: " + hours + " hours and " + remainingMinutes + " minutes " + " " + seconds + " seconds" + " " + millis + " ms\n");
//
//
//                        int counter = 0;
//
//                        List<P5> finalList = new ArrayList<>();
//                        List<P5> finalList1 = new ArrayList<>();
//
//                        for (int i = 0; i < llP5.size() - 1; i++) {
//                            List<P5[]> list1 = llP5.get(i);
//                            List<P5[]> list2 = llP5.get(i + 1);
//                            System.out.println("List One: " + i + " list one size: " + list1.size() + " List Two: " + i + 1 + " list two size: " + list2.size());
//                            for (int j = 0; j < list1.size(); j++) {
//                                P5[] listOneArray = list1.get(j);
//                                System.out.println("\tList One Array at: " + j + "/" + list1.size() + " listOneArray length: " + listOneArray.length);
//                                for (int k = 0; k < list2.size(); k++) {
//                                    P5[] listTwoArray = list2.get(k);
//                                    System.out.println("\tList Two Array at: " + k + "/" + list2.size() + " listOneArray length: " + listTwoArray.length);
//                                    List<P5> finalListTemp = checkP5In.getListOfP5Final(listOneArray, listTwoArray, nextPlayed);
////                        if(countWhile < 1){
//                                    finalList.addAll(finalListTemp);
////                        }else{
////                            if(finalList.size()<)
////                        }
//
////                        if (countWhile > 0) {
////                            System.out.println("Size of list: " + finalList.size());
////                            List<String> stringListP5 = finalList.stream()
////                                    .map(P5::toString) // or use p5 -> p5.getName() if you prefer
////                                    .collect(Collectors.toList());
////
////                            System.out.println("Size of stringListP5: " + stringListP5.size());
////
////                            // Create a map to count occurrences
////                            Map<String, Integer> countMap = new HashMap<>();
////                            for (String str : stringListP5) {
////                                countMap.put(str, countMap.getOrDefault(str, 0) + 1);
////                            }
////
////                            uniqueList = new ArrayList<>();
////                            for (String str : stringListP5) {
////                                //System.out.println(str);
////                                if (countMap.get(str) == 1) {
////                                    uniqueList.add(str);
////                                }
////                            }
////                        }
//                                }
//                            }
//                            System.out.println("Finished llp5 i: " + i);
//                        }
//
//                        // System.out.println("Amount of arrays in lists that have same value is :"+counter);
//
//                        List<String> stringListP5 = new ArrayList<>();
////            if(countWhile == 0){
////
//                        System.out.println("Size of list: " + finalList.size());
//                        stringListP5 = finalList.stream()
//                                .map(P5::toString) // or use p5 -> p5.getName() if you prefer
//                                .collect(Collectors.toList());
//
//                        System.out.println("Size of stringListP5: " + stringListP5.size());
//
//                        // Create a map to count occurrences
//                        Map<String, Integer> countMap = new HashMap<>();
//                        for (String str : stringListP5) {
//                            countMap.put(str, countMap.getOrDefault(str, 0) + 1);
//                        }
//
//                        //         Create a list to store unique strings
//                        // List<String> uniqueList = new ArrayList<>();
//                        uniqueList = new ArrayList<>();
//                        for (String str : stringListP5) {
//                            //System.out.println(str);
//                            if (countMap.get(str) == 1) {
//                                uniqueList.add(str);
//                            }
//                        }
////            }
//
//
//                        System.out.println("Size of uniqueList: " + uniqueList.size());
//                        P5 uniqueListArray2[] = new P5[uniqueList.size()];
//                        for (int i = 0; i < uniqueList.size(); i++) {
//                            boolean found = false;
//                            String relevantPart = uniqueList.get(i).toString().replaceAll(", value=\\d+", "");
//                            for (int j = 0; j < allCombos.length; j++) {
//                                String relevantPart1 = allCombos[j].toString().replaceAll(", value=\\d+", "");
//                                if (relevantPart.equals(relevantPart1)) {
//                                    uniqueListArray2[i] = new P5(allCombos[j].getN1(), allCombos[j].getN2(), allCombos[j].getN3(), allCombos[j].getN4(), allCombos[j].getN5());
//                                    found = true;
//                                }
//                                if (found == true) {
//                                    break;
//                                }
//                            }
//                        }
//                        uniqueListArray = uniqueListArray2;
//                        System.out.println("Found in unique List: " + checkP5In.hasValue(uniqueListArray, nextPlayed));
//                        globalUniqueListArrayArray = uniqueListArray;
//                        if (finalRunTest == 0) {
//                            globalUniqueListArrayArrayHolder = globalUniqueListArrayArray;
//                        }
//                        //for(String value: uniqueList){
//                        //   System.out.println(value.toString());
//                        // }
//                        // Create a Set to remove duplicates
//                        Set<String> set = new HashSet<>(stringListP5);
//
//                        // Convert the Set back to a List if needed
//                        List<String> uniqueList1 = new ArrayList<>(set);
//                        P5 uniqueListArray1[] = new P5[uniqueList1.size()];
//                        // Print the result
//                        if (countWhile > 0) {
//                            System.out.println("Size of uniqueList1: " + uniqueList1.size());
//
//                            for (int i = 0; i < uniqueList1.size(); i++) {
//                                boolean found = false;
//                                String relevantPart = uniqueList1.get(i).toString().replaceAll(", value=\\d+", "");
//                                for (int j = 0; j < allCombos.length; j++) {
//                                    String relevantPart1 = allCombos[j].toString().replaceAll(", value=\\d+", "");
//                                    if (relevantPart.equals(relevantPart1)) {
//                                        uniqueListArray1[i] = new P5(allCombos[j].getN1(), allCombos[j].getN2(), allCombos[j].getN3(), allCombos[j].getN4(), allCombos[j].getN5());
//                                        found = true;
//                                    }
//                                    if (found == true) {
//                                        break;
//                                    }
//                                }
//                            }
//                            System.out.println("Found in unique List1: " + checkP5In.hasValue(uniqueListArray1, nextPlayed));
//
//                        }
//
//
//                        if (uniqueList.size() == 0 && countWhile > 0) {
//                            System.out.println("Setting uniqueListArray to uniqueListArray1");
//                            uniqueListArray = uniqueListArray1;
//                        }
//                        //end else
//                    }//end for testIndex

                    if (testMode == false && testIndex != 0) {
                        List<P5> listTempUniqueListArray = new ArrayList<>();

                        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                            String line;

                            while ((line = reader.readLine()) != null) {
                                String[] parts = line.split(",");

                                int n1 = Integer.parseInt(parts[0]);
                                int n2 = Integer.parseInt(parts[1]);
                                int n3 = Integer.parseInt(parts[2]);
                                int n4 = Integer.parseInt(parts[3]);
                                int n5 = Integer.parseInt(parts[4]);
                                int value = Integer.parseInt(parts[5]);

                                listTempUniqueListArray.add(new P5(n1, n2, n3, n4, n5, value));
                            }

                        } catch (IOException | NumberFormatException e) {
                            System.err.println("Read error: " + e.getMessage());
                        }

                        uniqueListArray = listTempUniqueListArray.toArray(new P5[0]);
                        globalUniqueListArrayArrayHolder = uniqueListArray;

                    }//end if
                    else {
                        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

                            for (P5 p : uniqueListArrayGlobal) {
                                writer.write(
                                        p.n1 + "," +
                                                p.n2 + "," +
                                                p.n3 + "," +
                                                p.n4 + "," +
                                                p.n5 + "," +
                                                p.value
                                );
                                writer.newLine();
                            }

                        } catch (IOException e) {
                            System.err.println("Write error: " + e.getMessage());
                        }
                    }//end else

                    P5 dohHave[] = new P5[0];
                    P5 dohHave1[] = new P5[0];
                    if (uniqueListArrayGlobal.length > 0) {
                        dohHave = checkP5In.notInPParray1(allCombos, uniqueListArrayGlobal);
                        dohHave1 = checkP5In.notInPParray1(ppArray, uniqueListArrayGlobal);
                    }

                    dohHaveList.add(dohHave);


                    System.out.println("length of doh have: " + dohHave.length + " found: " + checkP5In.hasValue(dohHave, nextPlayed));
                    System.out.println("length of doh have1: " + dohHave1.length + " found: " + checkP5In.hasValue(dohHave1, nextPlayed));
                    System.out.println("length of uniqueListArray: " + uniqueListArrayGlobal.length + " found: " + checkP5In.hasValue(uniqueListArrayGlobal, nextPlayed));

                }//end for test index.
//                   }//end while uniqueList and end While
             //   }//end while whileRun
            }// end for finalRunTest
        }//end of globalRun affter create List of 10 Logic Step

        /**End of code Timing Section **/
        now = ZonedDateTime.now(ZoneId.systemDefault());
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
