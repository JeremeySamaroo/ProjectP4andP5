import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CheckP4In {
    public boolean hasValue(P4[] tempP4, int[] nextPlayed) {
        boolean found = false;
        for(int i = 0; i < tempP4.length; i++){
            if(tempP4[i] != null){
                if(tempP4[i].getN1() ==  nextPlayed[0] &&tempP4[i].getN2() ==  nextPlayed[1] && tempP4[i].getN3() ==  nextPlayed[2] && tempP4[i].getN4() ==  nextPlayed[3]){
                    found = true;
                    break;
                }
            }

        }

        return found;
    }

    public boolean hasValueList(List<P4> tempP4, int[] nextPlayed) {
        P4[] array = tempP4.toArray(new P4[0]);
        return hasValue(array, nextPlayed);
    }



    public P4[] notInPParray(P4[] ppArray, P4[] tempP4) {

        String ppArrayString[] = new String[ppArray.length];
        String tempP4String[] = new String[tempP4.length];

           for (int i = 0; i < ppArray.length; i++) {
               if(ppArray != null) {
                   ppArrayString[i] = ppArray[i].toString();
                }
            }


            for (int i = 0; i < tempP4.length; i++) {
                tempP4[i].setValue(ppArray[0].getValue());
                if(tempP4[i] != null) {
                    tempP4String[i] = tempP4[i].toString();
                }
            }

        List<String> listPParrayString = new ArrayList<>(Arrays.asList(ppArrayString));
        List<String> listTemp4String = new ArrayList<>(Arrays.asList(tempP4String));

        List<String> returnList1 = listPParrayString.stream()
                .filter(e -> !listTemp4String.contains(e))
                .collect(Collectors.toList());




        P4 returnArray[] = new P4[returnList1.size()];
        int counter=0;
        for(int i = 0; i < returnList1.size(); i++){
            for(int j = 0; j < ppArray.length; j++){
                if(returnList1.get(i).equals(ppArray[j].toString())){
                    returnArray[counter++] = ppArray[j];
                    break;
                }
            }
        }




        return returnArray;

    }

    public P4[] notInPParray1(P4[] ppArray, P4[] tempP4) {
        // Use a HashSet for fast lookups
        Set<String> tempP4Set = new HashSet<>();

        // Populate the HashSet with the string representations of tempP4
        for (P4 temp : tempP4) {

            //System.out.println(temp.toString());
            if (temp != null) {
                tempP4Set.add(temp.toString());
            }
        }

        // Use a list to collect the results
        List<P4> resultList = new ArrayList<>();

        // Iterate through ppArray and add to resultList if not in tempP4Set
        for (P4 pp : ppArray) {
            if( tempP4[0].getValue() > 0){
                pp.setValue(tempP4[0].getValue());
            }
            if (pp != null && !tempP4Set.contains(pp.toString())) {
                resultList.add(pp);
            }
        }

        // Convert the resultList to an array
        return resultList.toArray(new P4[0]);
    }
    public P4[] notInPParray1RelevantString(P4[] ppArray, P4[] tempP4) {
        // Use a HashSet for fast lookups
        Set<String> tempP4Set = new HashSet<>();

        // Populate the HashSet with the string representations of tempP4
        for (P4 temp : tempP4) {

            //System.out.println(temp.toString());
            if (temp != null) {
                tempP4Set.add(temp.getRelevantString());
            }
        }

        // Use a list to collect the results
        List<P4> resultList = new ArrayList<>();

        // Iterate through ppArray and add to resultList if not in tempP4Set
        for (P4 pp : ppArray) {
            if( tempP4[0].getValue() > 0){
                pp.setValue(tempP4[0].getValue());
            }
            if (pp != null && !tempP4Set.contains(pp.getRelevantString())) {
                resultList.add(pp);
            }
        }

        // Convert the resultList to an array
        return resultList.toArray(new P4[0]);
    }

    public P4[] notInPParray2(P4[] ppArray, P4[] tempP4) {
        // Use a HashSet for fast lookups
        Set<String> tempP4Set = new HashSet<>();

        // Populate the HashSet with the string representations of tempP4
        for (P4 temp : tempP4) {

            //System.out.println(temp.toString());
            if (temp != null) {
                tempP4Set.add(temp.toString());
            }
        }

        // Use a list to collect the results
        List<P4> resultList = new ArrayList<>();

        // Iterate through ppArray and add to resultList if not in tempP4Set
        for (P4 pp : ppArray) {

            if (pp != null && !tempP4Set.contains(pp.toString())) {
                resultList.add(pp);
            }
        }

        // Convert the resultList to an array
        return resultList.toArray(new P4[0]);
    }

    public P4[] notInPParray(P4[] ppArray, P4[] tempP4, P4[] allCombos) {

        System.out.println("ppArray: "+ppArray.length);
        System.out.println("tempP4: "+tempP4.length);
        System.out.println("allCombos: "+allCombos.length);        


        String ppArrayString[] = new String[ppArray.length];
        String tempP4String[] = new String[tempP4.length];
        String allComboString[] = new String[allCombos.length];

        for(int i =0; i < ppArray.length; i++){
            //System.out.println(ppArray[i].toString());
            ppArrayString[i] = ppArray[i].toString();


        }
        //System.out.println(ppArrayString[0].toString());

        for(int i =0; i < tempP4.length; i++){
           // System.out.println(tempP4[i].toString());
            tempP4String[i] = tempP4[i].toString();

        }
        //System.out.println( tempP4String[0].toString());

        for(int i =0; i < allCombos.length; i++){
            //System.out.println( allCombos[i].toString().substring(0, 38)+" value=0}");
            allComboString[i] = allCombos[i].toString();

        }
        //System.out.println( allCombos[0].toString());

        List<String> listPParrayString = new ArrayList<>(Arrays.asList(ppArrayString));
        List<String> listTemp4String = new ArrayList<>(Arrays.asList(tempP4String));
        List<String> listMergedPPWithP4 = new ArrayList<>();
        listMergedPPWithP4.addAll(listTemp4String);
        listMergedPPWithP4.addAll(listPParrayString);
//        for(int i =0; i < listMergedPPWithP4.size(); i++){
//            //System.out.println(listMergedPPWithP4.get(i).toString().substring(0, 38)+"value=0}");
//            System.out.println(listMergedPPWithP4.get(i).toString());//.substring(0, 38)+"value=0}");
//        }

        List<String> listAllComboString = new ArrayList<>(Arrays.asList(allComboString));

//        for(int i =0; i < listAllComboString.size(); i++){
//            //System.out.println(listAllComboString.get(i).toString().substring(0, 38)+"value=0}");
//            System.out.println(listAllComboString.get(i).toString());//.substring(0, 38)+"value=0}");
//
//        }


        List<String> returnList1 = listAllComboString.stream()
                .filter(e -> !listMergedPPWithP4.contains(e))
                .collect(Collectors.toList());


        System.out.println(returnList1.size());

        P4 returnArray[] = new P4[returnList1.size()];
        int counter=0;
        for(int i = 0; i < returnList1.size(); i++){
            //System.out.println(returnList1.get(i).toString());
            for(int j = 0; j < ppArray.length; j++){
                if(returnList1.get(i).equals(ppArray[j].toString().substring(0, 38)+"value=0}")){
                    returnArray[counter++] = ppArray[j];
                    break;
                }
            }
        }


        return returnArray;

    }

    public P4[] notInPParray1(P4[] ppArray, P4[] tempP4, P4[] allCombos, int countWhile, int[] nextPlayed) {

        boolean hasValuePParray = false;
        boolean hasValueTempP4 = false;
//        if(countWhile > 0){
            hasValuePParray= hasValue(ppArray, nextPlayed);
            hasValueTempP4=hasValue(tempP4, nextPlayed);
//        }

        System.out.println("\t\tppArray: "+ppArray.length+ " has value: "+hasValuePParray);
        System.out.println("\t\ttempP4: "+tempP4.length+ " has value: "+hasValueTempP4);
        System.out.println("\t\tallCombos: "+allCombos.length);

        // Use HashSet for fast lookups
        Set<String> mergedSet = new HashSet<>();

        // Populate the HashSet with the string representations of ppArray and tempP4
        if(countWhile < 1){
            for (P4 pp : ppArray) {
                if (pp != null) {
                    mergedSet.add(pp.toString());
                }
            }
        }


        for (P4 temp : tempP4) {
            if (temp != null) {
                mergedSet.add(temp.toString());
            }
        }

        // Use a list to collect the results
        List<P4> resultList = new ArrayList<>();

        // Create a Set to store the relevant parts of mergedSet for comparison
        Set<String> mergedRelevantParts = mergedSet.stream()
                .map(e -> e.replaceAll(", value=\\d+", "")) // Remove the value part
                .collect(Collectors.toSet());

        // Iterate through allCombos and add to resultList if not in mergedRelevantParts
        for (P4 combo : allCombos) {
            if (combo != null) {
                String comboString = combo.toString();
                String relevantPart = comboString.replaceAll(", value=\\d+", ""); // Remove the value part
                if (!mergedRelevantParts.contains(relevantPart)) {
                    resultList.add(combo);
                }
            }
        }

        // Convert the resultList to an array
        return resultList.toArray(new P4[0]);



    }

    public P4[] mergeP4Arrays(P4[] one, P4[] notInTemp) {
        // Calculate the length of the new merged array
        int totalLength = one.length + notInTemp.length;

        // Create a new array to hold the merged results
        P4[] mergedArray = new P4[totalLength];

        // Copy the elements from the first array
        System.arraycopy(one, 0, mergedArray, 0, one.length);

        // Copy the elements from the second array
        System.arraycopy(notInTemp, 0, mergedArray, one.length, notInTemp.length);

        return mergedArray;
    }



    public P4[] notInPParrayStrings(P4[] ppArray, P4[] tempP4, int[] nextPlayed) {

        System.out.println("arraysOfRandFromPPArrayToCheck.length: "+ppArray.length);
        System.out.println("tempFlatListArray.length: "+tempP4.length);


        String ppArrayString[] = new String[ppArray.length];
        String tempP4String[] = new String[tempP4.length];
//        String n1 = ""+nextPlayed[0];
//        String n2 = ""+nextPlayed[1];
//        String n3 = ""+nextPlayed[2];
//        String n4 = ""+nextPlayed[3];

        for (int i = 0; i < ppArray.length; i++) {
            if(ppArray != null) {
                ppArrayString[i] = ppArray[i].toString();
            }
        }


        for (int i = 0; i < tempP4.length; i++) {
            if(tempP4[i] != null) {
                tempP4String[i] = tempP4[i].toString();
            }
        }

        List<String> listPParrayString = new ArrayList<>(Arrays.asList(ppArrayString));
        List<String> listTemp4String = new ArrayList<>(Arrays.asList(tempP4String));



        List<String> returnList1 = listPParrayString.stream()
                .filter(e -> !listTemp4String.contains(e))
                .collect(Collectors.toList());


//        List<String> returnList1 = new ArrayList<>();
//        // Loop through listPParrayString and check conditions
//        for (String e : listPParrayString) {
//            if (!listTemp4String.contains(e)) {
//                returnList1.add(e);
//            }
//            // Stop checking if the size exceeds 56
//            if (returnList1.size() > 55) {
//                break;
//            }
//        }

//
//        for(int i = 0; i < returnList1.size(); i++){
//            //System.out.println();
//                System.out.println("Found: "+returnList1.get(i).toString());
//            }
//        }

        List<P4> ppArrayList = new ArrayList<>(Arrays.asList(ppArray));


        P4 returnArray[] = new P4[returnList1.size()];
        int counter=0;
        if(returnList1.size()<56) {
            for (int i = 0; i < returnList1.size(); i++) {
                //for (int j = 0; j < ppArray.length; j++) {
                for (int j = 0; j < ppArrayList.size(); j++) {
//                    if (returnList1.get(i).equals(ppArray[j].toString())) {
                    if (returnList1.get(i).equals(ppArrayList.get(j).toString())) {
                        returnArray[counter++] = ppArrayList.get(j);
                        ppArrayList.remove(j);
                        //ppArrayList.remove(ppArrayList.get(j));
                        break;
                    }
                }
            }

            for (int i = 0; i < returnArray.length; i++){
                if(returnArray[i].getN1() == nextPlayed[0] && returnArray[i].getN2() == nextPlayed[1] && returnArray[i].getN3() == nextPlayed[2] && returnArray[i].getN4() == nextPlayed[3]){
                    System.out.println("Found: "+returnArray[i].toString());
                }
            }


            return returnArray;
        }else {
            return null;
        }

    }


    public P4[] notInPParrayStrings1(P4[] ppArray, P4[] tempP4, int[] nextPlayed) {
        System.out.println("arraysOfRandFromPPArrayToCheck.length: " + ppArray.length);
        System.out.println("tempFlatListArray.length: " + tempP4.length);

        Set<String> tempP4Set = new HashSet<>();
        for (P4 temp : tempP4) {
            if (temp != null) {
                tempP4Set.add(temp.toString());
            }
        }

        P4[] returnArray = new P4[56]; // Preallocate for maximum size
        int counter = 0;

        for (P4 pp : ppArray) {
            if (pp != null && !tempP4Set.contains(pp.toString())) {
                returnArray[counter++] = pp;
                if (counter >= 56) {
                    break; // Stop if we have reached the limit
                }
            }
        }

        // Resize returnArray if we found fewer than 56
        if (counter < 56) {
            P4[] result = new P4[counter];
            System.arraycopy(returnArray, 0, result, 0, counter);
            returnArray = result;
        } else {
            // If we hit the limit, we can return the full array
            returnArray = returnArray; // No change needed, already full
        }

        // Check for matches with nextPlayed
        for (P4 p4 : returnArray) {
            if (p4 != null && p4.getN1() == nextPlayed[0] && p4.getN2() == nextPlayed[1] &&
                    p4.getN3() == nextPlayed[2] && p4.getN4() == nextPlayed[3]) {
                System.out.println("Found: " + p4.toString());
            }
        }

        return returnArray.length > 0 ? returnArray : null; // Return null if no valid results
    }


    public P4[] notInPParrayStringsOptimized(P4[] ppArray, P4[] tempP4, int[] nextPlayed, int i, int ofSize) {
        System.out.println("#:"+i+" of "+ofSize);
        System.out.println("\tarraysOfRandFromPPArrayToCheck.length: " + ppArray.length);
        System.out.println("\ttempFlatListArray.length: " + tempP4.length);

        int value = tempP4[0].getValue();
        // Use a HashSet for faster lookups
//        Set<String> tempP4Set = new HashSet<>();
//        for (P4 temp : tempP4) {
//
//            if (temp != null) {
//                tempP4Set.add(temp.toString());
//            }
//        }
//
//        System.out.println(tempP4[0].toString());
//
//        List<P4> returnList = new ArrayList<>();
//
//        // Filter ppArray based on tempP4Set
//        for (P4 pp : ppArray) {
//            //pp.setValue(i);
//            if (pp != null && !tempP4Set.contains(pp.toString())) {
//                returnList.add(pp);
////                if (returnList.size() >= 56) {
////                    break; // Stop if we have reached the limit
////                }
//            }
//        }
//        System.out.println(ppArray[0].toString());

        Set<String> tempP4Set = new HashSet<>();
        for (P4 temp : tempP4) {
            if (temp != null) {
                // Add only the relevant part (excluding the value)
                //System.out.println("temp value: "+temp.getValue()+" as part of "+temp.getP4String());
                tempP4Set.add(temp.toString().replaceAll(", value=\\d+", ""));
            }
        }

       // System.out.println(tempP4[0].toString());

        List<P4> returnList = new ArrayList<>();

        // Filter ppArray based on tempP4Set
        for (P4 pp : ppArray) {

            if (pp != null) {
                //System.out.println("pp value: "+pp.getValue()+" as part of "+pp.getP4String());
                // Extract the relevant part of pp
                String relevantPart = pp.toString().replaceAll(", value=\\d+", "");
                if (!tempP4Set.contains(relevantPart)) {
                    returnList.add(pp);
                }
            }
        }


        // Convert List<P4> to P4[] for the return value
        P4[] returnArray = returnList.toArray(new P4[0]);

        //int counter = 1;
        // Check for matches with nextPlayed
        System.out.println("Started Final for at i: "+i+" returnArray length: "+returnArray.length);
        for (P4 p4 : returnArray) {
            p4.setValue(value);
            if (p4 != null && p4.getN1() == nextPlayed[0] && p4.getN2() == nextPlayed[1] &&
                    p4.getN3() == nextPlayed[2] && p4.getN4() == nextPlayed[3]) {
                System.out.println("\t\tFound: " + p4.toString()+ " of size: "+returnArray.length+" "+i);
            }
            //counter++;
        }
        System.out.println("Finished Final for at i: "+i);

        System.out.println();
        return returnArray.length > 0 ? returnArray : null; // Return null if no valid results
    }


   /*  public P4[] notInPParrayStringsOptimized1(P4[] ppArray, P4[] tempP4, int[] nextPlayed, int i, int ofSize) {
        System.out.println("#:" + i + " of " + ofSize);
        System.out.println("\tarraysOfRandFromPPArrayToCheck.length: " + ppArray.length);
        System.out.println("\ttempFlatListArray.length: " + tempP4.length);
    
        int value = tempP4[0].getValue();
        Set<String> tempP4Set = new HashSet<>();
    
        // Populate the HashSet with relevant parts of tempP4
        for (P4 temp : tempP4) {
            if (temp != null) {
                tempP4Set.add(temp.getRelevantString()); // Assuming getRelevantString() returns the relevant part
            }
        }
    
        // Use a dynamic list to collect results
        List<P4> returnList = new ArrayList<>();
    
        // Filter ppArray based on tempP4Set
        for (P4 pp : ppArray) {
            if (pp != null) {
                String relevantPart = pp.getRelevantString(); // Assuming getRelevantString() returns the relevant part
                if (!tempP4Set.contains(relevantPart)) {
                    returnList.add(pp);
                }
            }
        }
    
        // Convert List<P4> to P4[] for the return value
        P4[] returnArray = returnList.toArray(new P4[0]);
    
        // Check for matches with nextPlayed
        System.out.println("Started Final for at i: " + i + " returnArray length: " + returnArray.length);
        for (P4 p4 : returnArray) {
            p4.setValue(value);
            if (p4.getN1() == nextPlayed[0] && p4.getN2() == nextPlayed[1] &&
                p4.getN3() == nextPlayed[2] && p4.getN4() == nextPlayed[3]) {
                System.out.println("\t\tFound notInPParrayStringsOptimized1 process: " + p4.toString() + " of size: " + returnArray.length + " " + i);
            }
        }
        System.out.println("Finished Final for at i: " + i);
        System.out.println();
    
        return returnArray.length > 0 ? returnArray : null; // Return null if no valid results
    }*/



    public P4[] notInPParrayStringsOptimized1(P4[] ppArray, P4[] tempP4, int[] nextPlayed, int i, int ofSize) {
        System.out.println("#:" + i + " of " + ofSize);
        System.out.println("\tarraysOfRandFromPPArrayToCheck.length: " + ppArray.length);
        System.out.println("\ttempFlatListArray.length: " + tempP4.length);
    
        int value = tempP4[0].getValue();
        Set<String> tempP4Set = new HashSet<>();
    
        // Populate the HashSet with relevant parts of tempP4
        for (P4 temp : tempP4) {
            if (temp != null) {
                tempP4Set.add(temp.getRelevantString());
            }
        }
    
        // Use an array to collect results
        P4[] returnArray = new P4[ppArray.length]; // Preallocate array
        int returnCount = 0; // Counter for valid P4 objects
    
        // Filter ppArray based on tempP4Set
        for (P4 pp : ppArray) {
            if (pp != null) {
                String relevantPart = pp.getRelevantString();
                if (!tempP4Set.contains(relevantPart)) {
                    returnArray[returnCount++] = pp; // Store directly in the array
                }
            }
        }
    
        // Resize the returnArray to the actual number of valid P4 objects
        if (returnCount < returnArray.length) {
            P4[] resizedArray = new P4[returnCount];
            System.arraycopy(returnArray, 0, resizedArray, 0, returnCount);
            returnArray = resizedArray;
        }
    
        // Check for matches with nextPlayed
        System.out.println("Started Final for at i: " + i + " returnArray length: " + returnArray.length);
        for (P4 p4 : returnArray) {
            p4.setValue(value);
            if (p4.getN1() == nextPlayed[0] && p4.getN2() == nextPlayed[1] &&
                p4.getN3() == nextPlayed[2] && p4.getN4() == nextPlayed[3]) {
                System.out.println("\t\tFound notInPParrayStringsOptimized1 process: " + p4.toString() + " of size: " + returnArray.length + " " + i);
            }
        }
        System.out.println("Finished Final for at i: " + i);
        System.out.println();
    
        return returnArray.length > 0 ? returnArray : null; // Return null if no valid results
    }

    public P4[] notInPParrayStringsOptimized2(P4[] ppArray, P4[] tempP4, int[] nextPlayed, int i, int ofSize) {
        // Use a HashSet to store relevant strings from tempP4 for fast lookup
        System.out.println("#:" + i + " of " + ofSize);
        System.out.println("\tarraysOfRandFromPPArrayToCheck.length: " + ppArray.length);
        System.out.println("\ttempFlatListArray.length: " + tempP4.length);
        Set<String> tempP4Set = new HashSet<>(tempP4.length);

        // Populate the HashSet with relevant parts of tempP4
        for (P4 temp : tempP4) {
            if (temp != null) {
                tempP4Set.add(temp.getRelevantString());
            }
        }

        // Use a List to collect results dynamically
        List<P4> resultList = new ArrayList<>(ppArray.length); // Initial capacity set to ppArray length

        // Filter ppArray based on tempP4Set
        for (P4 pp : ppArray) {
            if (pp != null && !tempP4Set.contains(pp.getRelevantString())) {
                resultList.add(pp); // Store directly in the list
            }
        }

        // Convert the result list to an array
        P4[] returnArray = resultList.toArray(new P4[0]);

        // Set the value for each P4 object in the return array and check for matches with nextPlayed
        int value = tempP4[0].getValue();
        System.out.println("Started Final for at i: " + i + " returnArray length: " + returnArray.length);
        for (P4 p4 : returnArray) {
            p4.setValue(value);
            if (p4.getN1() == nextPlayed[0] && p4.getN2() == nextPlayed[1] &&
                    p4.getN3() == nextPlayed[2] && p4.getN4() == nextPlayed[3]) {
                // Consider logging only if necessary
                System.out.println("\t\tFound notInPParrayStringsOptimized1 process: " + p4.toString() + " of size: " + returnArray.length + " " + i);
            }
        }

        return returnArray.length > 0 ? returnArray : null; // Return null if no valid results
    }

    public P4[] notInPParrayStringsOptimized3(P4[] ppArray, P4[] tempP4, int[] nextPlayed, int i, int ofSize, int countWhile) {
        // Start timing the method execution
        long startTime = System.nanoTime();

        System.out.println("#:" + i + " of " + ofSize);
        System.out.println("\tarraysOfRandFromPPArrayToCheck.length: " + ppArray.length+ " found: "+hasValue(ppArray, nextPlayed));
        System.out.println("\ttempFlatListArray.length: " + tempP4.length+ " found: "+hasValue(tempP4, nextPlayed));

        // Use a HashSet to store relevant strings from tempP4 for fast lookup
        Set<String> tempP4Set = new HashSet<>(tempP4.length);

        // Populate the HashSet with relevant parts of tempP4
        long hashSetStartTime = System.nanoTime();
        for (P4 temp : tempP4) {
            if (temp != null) {
                tempP4Set.add(temp.getRelevantString());
            }
        }
        long hashSetEndTime = System.nanoTime();
        System.out.println("Time to populate HashSet: " + (hashSetEndTime - hashSetStartTime) / 1_000_000.0 + " ms" );

        // Use a List to collect results dynamically
        List<P4> resultList = new ArrayList<>(ppArray.length); // Initial capacity set to ppArray length

        // Filter ppArray based on tempP4Set
        long filterStartTime = System.nanoTime();
        int counter = 0;
        for (P4 pp : ppArray) {
//            if(counter ==0 && pp != null){
//                System.out.println(pp.getRelevantString()+ "found in tempP4Set: "+tempP4Set.contains(pp.getRelevantString()));
//                counter++;
//            }
            if (pp != null && !tempP4Set.contains(pp.getRelevantString())) {
                //System.out.println("Not in tempSet: "+pp.getRelevantString());
                resultList.add(pp); // Store directly in the list
                counter++;
            }
        }
        long filterEndTime = System.nanoTime();
        System.out.println("Time to filter ppArray: " + (filterEndTime - filterStartTime) / 1_000_000.0 + " ms");

        // Convert the result list to an array
        long conversionStartTime = System.nanoTime();
        P4[] returnArray = resultList.toArray(new P4[0]);
        long conversionEndTime = System.nanoTime();
        System.out.println("Time to convert result list to array: " + (conversionEndTime - conversionStartTime) / 1_000_000.0 + " ms");

        // Set the value for each P4 object in the return array and check for matches with nextPlayed
        int value = tempP4[0].getValue();
        System.out.println("Started Final for at i: " + i + " returnArray length: " + returnArray.length+ " with value of: "+value+ " resultList.size(): "+resultList.size()+" counter: "+counter);

        long finalCheckStartTime = System.nanoTime();
        System.out.println("in return array setting value");

        for (P4 p4 : returnArray) {

            p4.setValue(value);
            if (p4.getN1() == nextPlayed[0] && p4.getN2() == nextPlayed[1] &&
                    p4.getN3() == nextPlayed[2] && p4.getN4() == nextPlayed[3]) {
                // Consider logging only if necessary
                System.out.println("\t\tFound notInPParrayStringsOptimized2 process: " + p4.toString() + " of size: " + returnArray.length + " " + i);
            }
        }
        long finalCheckEndTime = System.nanoTime();
        System.out.println("Time for final check: " + (finalCheckEndTime - finalCheckStartTime) / 1_000_000.0 + " ms");

        // Total execution time
        long endTime = System.nanoTime();
        System.out.println("Total execution time: " + (endTime - startTime) / 1_000_000.0 + " ms with a return array length off: "+returnArray.length);

        System.out.println();
        System.out.println("\nBeforeReturn\nStarted Final for at i: " + i + "\nreturnArray length: " + returnArray.length+ " with value of: "+value+ "\nresultList.size(): "+resultList.size()+"\ncounter: "+counter);

        P4 newReturnArray[] = new P4[0];

        if(countWhile == 0){
//            return returnArray.length > 0 ? returnArray : null; // Return null if no valid results
            newReturnArray = returnArray.length > 0 ? returnArray : null;
        }
        else{
            if(counter > 0){
                //return returnArray;
                newReturnArray = returnArray;
            }
        }

        return newReturnArray.length > 0 ? returnArray:null;
    }


    public P4[] notInPParrayStringsOptimized4(P4[] ppArray, P4[] tempP4, int[] nextPlayed, int i, int ofSize, int countWhile) {
        // Start timing the method execution
        long startTime = System.nanoTime();

        System.out.println("#:" + i + " of " + ofSize);
        System.out.println("\tarraysOfRandFromPPArrayToCheck.length: " + ppArray.length + " found: " + hasValue(ppArray, nextPlayed));
        System.out.println("\ttempFlatListArray.length: " + tempP4.length + " found: " + hasValue(tempP4, nextPlayed));

        // Use a Set for fast lookups
        Set<String> tempP4Set = new HashSet<>();
        for (P4 temp : tempP4) {
            if (temp != null) {
                tempP4Set.add(temp.getN1() + "," + temp.getN2() + "," + temp.getN3() + "," + temp.getN4() + ",");
            }
        }

        List<P4> returnList = new ArrayList<>();
        int ppCounter = 0;

        for (P4 pp : ppArray) {
            ppCounter++;
//            if(ppCounter %10000 == 0){
//                System.out.println("TempP4:  " + tempP4[ppCounter].getRelevantString() + " with value of: "+ tempP4[ppCounter].getValue());
//            }
            if (pp != null) {
                String ppKey = "P4[n1="+pp.getN1() + ", n2=" + pp.getN2() + ", n3=" + pp.getN3() + ", n4=" + pp.getN4() + ""+"]";
                if (!tempP4Set.contains(ppKey)) {
                    //System.out.println("Found pp: false with pp of " + pp.getRelevantString()+ " with value: "+pp.getValue());
                    returnList.add(pp);
                }// else {
//                    System.out.println("Found pp: true with pp value of " + pp.getRelevantString() + " in tempP4");
//                }
            }
        }

        System.out.println("Return List Size: "+returnList.size());

        // Convert List<P4> to P4[] without creating new objects
        return returnList.toArray(new P4[0]);
    }



        public List<P4> getListOfP4Final(P4[] listOneArray, P4[] listTwoArray, int[] nextPlayed) {

        List<P4> returnList = new ArrayList<>();

        for(int i = 0; i < listOneArray.length; i++){
            if(listOneArray[i].getN1()==nextPlayed[0] && listOneArray[i].getN2()==nextPlayed[1] && listOneArray[i].getN3()==nextPlayed[2] && listOneArray[i].getN4()==nextPlayed[3]){
                System.out.println("\tFound matching P4 in i:"+i+" next played: "+listOneArray[i].toString());
            }
            boolean matchFound = false;
            for (int j = 0; j < listTwoArray.length; j++){
                if(listOneArray[i].getN1() == listTwoArray[j].getN1() && listOneArray[i].getN2() == listTwoArray[j].getN2() && listOneArray[i].getN3() == listTwoArray[j].getN3() && listOneArray[i].getN4() == listTwoArray[j].getN4()){
//                    System.out.println("\t\tFound matching P4 for i: "+i+ " at j: "+j);
//                    System.out.println("\t\t\tlistOneArray: "+listOneArray[i].toString());
//                    System.out.println("\t\t\tlistTwoArray: "+listTwoArray[j].toString());
                    matchFound=true;
                    if(listOneArray[i].getValue() == listTwoArray[j].getValue()){
//                        System.out.println("\t\t\tlistOneArray["+i+"].getValue(): "+listOneArray[i].getValue()+" == listTwoArray["+j+"].getValue(): "+listTwoArray[j].getValue());
                        returnList.add(listOneArray[i]);
                    }
                    if(listTwoArray[j].getN1()==nextPlayed[0] && listTwoArray[j].getN2()==nextPlayed[1] && listTwoArray[j].getN3()==nextPlayed[2] && listTwoArray[j].getN4()==nextPlayed[3]){
                        System.out.println("\tFound matching P4 in j at:"+j+" next played: "+listTwoArray[j].toString());
                        System.out.println();
                    }
                    if(matchFound == true){
                        break;
                    }
                }
                //System.out.println();
            }
           // 
        }
        

        return  returnList;
    }


    public P4[] getP4ArrayFromString(List<String> result, P4[] allCombos) {
        P4[] arrayToReturn = new P4[result.size()];

        int count =0;
        for(String str: result){
            boolean found = false;
            for(int i = 0; i< allCombos.length; i++){
                if(str.equals(allCombos[i].toString())){
                    arrayToReturn[count++] = allCombos[i];
                    break;
                }
            }
        }

        return arrayToReturn;
    }



    public Set<Integer> getPossibleNumbers(int groupABLength, boolean randomKnown, int randomIndex, int groupC ){
        Random random = new Random();

        int x = 3; // factor between 2 and 5
        int rounds = 2; // number of reshuffle rounds

        // Create group A and B (1–1000)
        Set<Integer> A = new HashSet<>();
        Set<Integer> B = new HashSet<>();
        for (int i = 0; i <groupABLength; i++) {
            A.add(i);
            B.add(i);
        }

        if(randomKnown == true){
            System.out.println("Unknown ball is: " + randomIndex);
        }else{
            System.out.println("Unknown ball is: unknown");
        }

        Set<Integer> possibleCandidates = new HashSet<>(B);

        for (int r = 1; r <= rounds; r++) {

            // Create C
            Set<Integer> C = new HashSet<>();
            int start = 1001;
            for (int i = 1; i < 1000 * x; i++) {
                C.add(start + i + r * 10000); // ensure uniqueness per round
            }

            // Add all B balls
            C.addAll(B);

            // Shuffle and split into 10 subgroups
            List<Integer> listC = new ArrayList<>(C);
            Collections.shuffle(listC);

            List<Set<Integer>> subgroups = new ArrayList<>();
            int subgroupSize = listC.size() / 10;

            for (int i = 0; i < 10; i++) {
                Set<Integer> subgroup = new HashSet<>();
                for (int j = i * subgroupSize;
                     j < (i + 1) * subgroupSize && j < listC.size(); j++) {
                    subgroup.add(listC.get(j));
                }
                subgroups.add(subgroup);
            }

            // Determine which subgroup contains unknown
            int missingIndex = -1;
            for (int i = 0; i < 10; i++) {
                if (subgroups.get(i).contains(randomIndex)) {
                    missingIndex = i;
                    break;
                }
            }

            // The subgroup that contains unknown is excluded
            Set<Integer> roundCandidates = new HashSet<>(subgroups.get(missingIndex));
            roundCandidates.retainAll(B); // only consider balls from B

            System.out.println("Round " + r + " candidates: " + roundCandidates.size());

            // Intersect with previous candidates
            possibleCandidates.retainAll(roundCandidates);

            System.out.println("After round " + r + " remaining: "
                    + possibleCandidates.size());
        }

        System.out.println("\nFinal candidate set size: " + possibleCandidates.size());
        System.out.println("Candidates: " + possibleCandidates);

        if (possibleCandidates.contains(randomIndex)) {
            System.out.println("SUCCESS: Unknown ball retained.");
            return possibleCandidates;
        } else {
            System.out.println("ERROR: Unknown ball lost.");
            Set<Integer> possibleCandidates1 = new HashSet<>(B);
            return possibleCandidates1;
        }

    }


    public Set<Integer> getPossibleNumbers1(int groupABLength,
                                           boolean randomKnown,
                                           int randomIndex,
                                           int groupC) {

        int x = 3;
        int rounds = 2;

        // Create group B
        Set<Integer> B = new HashSet<>();
        for (int i = 0; i < groupABLength; i++) {
            B.add(i);
        }

        if (randomKnown) {
            System.out.println("Unknown ball is: " + randomIndex);
        } else {
            System.out.println("Unknown ball is: unknown");
        }

        Set<Integer> possibleCandidates = new HashSet<>(B);

        for (int r = 1; r <= rounds; r++) {

            // Create C
            Set<Integer> C = new HashSet<>();
            int start = 1001;
            for (int i = 1; i < 1000 * x; i++) {
                C.add(start + i + r * 10000);
            }

            C.addAll(B);

            // Shuffle and split
            List<Integer> listC = new ArrayList<>(C);
            Collections.shuffle(listC);

            List<Set<Integer>> subgroups = new ArrayList<>();
            int subgroupSize = listC.size() / 10;

            for (int i = 0; i < 10; i++) {
                Set<Integer> subgroup = new HashSet<>();
                for (int j = i * subgroupSize;
                     j < (i + 1) * subgroupSize && j < listC.size(); j++) {
                    subgroup.add(listC.get(j));
                }
                subgroups.add(subgroup);
            }

            int missingIndex = -1;

            // Only search if randomIndex is valid
            if (randomIndex >= 0 && B.contains(randomIndex)) {
                for (int i = 0; i < 10; i++) {
                    if (subgroups.get(i).contains(randomIndex)) {
                        missingIndex = i;
                        break;
                    }
                }
            }

            Set<Integer> roundCandidates;

            if (missingIndex != -1) {
                // Normal elimination
                roundCandidates = new HashSet<>(subgroups.get(missingIndex));
                roundCandidates.retainAll(B);
            } else {
                // randomIndex == -1 or not found
                // Do not eliminate anything this round
                roundCandidates = new HashSet<>(possibleCandidates);
                System.out.println("Round " + r + ": No valid unknown, skipping elimination.");
            }

            System.out.println("Round " + r + " candidates: " + roundCandidates.size());

            possibleCandidates.retainAll(roundCandidates);

            System.out.println("After round " + r + " remaining: "
                    + possibleCandidates.size());
        }

        System.out.println("\nFinal candidate set size: " + possibleCandidates.size());
        System.out.println("Candidates: " + possibleCandidates);

        return possibleCandidates;
    }

    public Set<Integer> getPossibleNumbers2(int groupABLength,
                                            int groupC) {

        int x = 3;
        int rounds = 2;
        Random random = new Random();

        // Create group B
        Set<Integer> B = new HashSet<>();
        for (int i = 0; i < groupABLength; i++) {
            B.add(i);
        }

        System.out.println("Unknown ball is: unknown");

        Set<Integer> possibleCandidates = new HashSet<>(B);

        for (int r = 1; r <= rounds; r++) {

            // Create C (noise values)
            Set<Integer> C = new HashSet<>();
            int start = 1001;

            for (int i = 1; i < 1000 * x; i++) {
                C.add(start + i + r * 10000);
            }

            C.addAll(B);

            // Shuffle and split
            List<Integer> listC = new ArrayList<>(C);
            Collections.shuffle(listC);

            List<Set<Integer>> subgroups = new ArrayList<>();
            int subgroupSize = listC.size() / 10;

            for (int i = 0; i < 10; i++) {
                Set<Integer> subgroup = new HashSet<>();
                for (int j = i * subgroupSize;
                     j < (i + 1) * subgroupSize && j < listC.size(); j++) {
                    subgroup.add(listC.get(j));
                }
                subgroups.add(subgroup);
            }

            // Randomly choose one subgroup (since unknown is unknown)
            int chosenGroup = random.nextInt(10);

            Set<Integer> roundCandidates = new HashSet<>(subgroups.get(chosenGroup));
            roundCandidates.retainAll(B);  // only B elements matter

            System.out.println("Round " + r + " chosen group: " + chosenGroup);
            System.out.println("Round " + r + " candidates: " + roundCandidates.size());

            possibleCandidates.retainAll(roundCandidates);

            System.out.println("After round " + r + " remaining: "
                    + possibleCandidates.size());
        }

        System.out.println("\nFinal candidate set size: " + possibleCandidates.size());
        System.out.println("Candidates: " + possibleCandidates);

        return possibleCandidates;
    }

    public static List<P4> shuffleAndKeepSixtyPercent(List<P4> inputList) {
        if (inputList == null || inputList.isEmpty()) {
            return new ArrayList<>();
        }

        // Create a copy so we don't modify the original list
        List<P4> shuffledList = new ArrayList<>(inputList);

        // Shuffle randomly
        Collections.shuffle(shuffledList);

        // Calculate 60% size
        int newSize = (int) Math.ceil(shuffledList.size() * 0.6);

        // Return first 60% of shuffled list
        return new ArrayList<>(shuffledList.subList(0, newSize));
    }


    public static  List<P4[]> generateTenC9Combinations(P4[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            return new ArrayList<>();
        }

        // Convert array to list
        List<P4> list = new ArrayList<>();
        Collections.addAll(list, inputArray);

        // Shuffle the list
        Collections.shuffle(list);

        int totalSize = list.size();
        int baseSize = totalSize / 10;
        int remainder = totalSize % 10;

        // Create 10 groups
        List<List<P4>> groups = new ArrayList<>();

        int currentIndex = 0;

        for (int i = 0; i < 10; i++) {
            int currentGroupSize = baseSize;

            // 10th group takes remainder
            if (i == 9) {
                currentGroupSize += remainder;
            }

            List<P4> group = new ArrayList<>();

            for (int j = 0; j < currentGroupSize && !list.isEmpty(); j++) {
                // Pick random index from remaining list
                int randomIndex = (int) (Math.random() * list.size());
                group.add(list.remove(randomIndex));
            }

            groups.add(group);
        }

        // Generate 10C9 combinations (leave one group out each time)
        List<P4[]> result = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            List<P4> combined = new ArrayList<>();

            for (int j = 0; j < 10; j++) {
                if (j != i) {
                    combined.addAll(groups.get(j));
                }
            }

            // Convert combined list back to array
            @SuppressWarnings("unchecked")
            P4[] combinationArray = (P4[]) java.lang.reflect.Array.newInstance(
                    inputArray.getClass().getComponentType(),
                    combined.size()
            );

            result.add(combined.toArray(combinationArray));
        }

        return result;
    }

        public List<P4[]> findContainingArrays(P4[] baseArray, List<P4[]> listOfArrays, int[] nextPlayed) {
            List<P4[]> result = new ArrayList<>();

            if (baseArray == null || listOfArrays == null) {
                return result;
            }

            // Convert base array to Set for fast lookup
            Set<P4> baseSet = new HashSet<>();
            for (P4 element : baseArray) {
                baseSet.add(element);
            }

            int count=0;
            // Check each array in the list
            for (P4[] candidateArray : listOfArrays) {
                count++;
                System.out.println("\t\t#: "+count+" array in list of arrays has value "+hasValue(candidateArray,nextPlayed));
                if (candidateArray == null) continue;

                Set<P4> candidateSet = new HashSet<>();
                for (P4 element : candidateArray) {
                    candidateSet.add(element);
                }

                // If candidate contains all base elements
                if (candidateSet.containsAll(baseSet)) {
                    result.add(candidateArray);
                }
            }

            return result;
        }

    public List<P4[]> findContainingArrays1(P4[] baseArray,
                                           List<P4[]> listOfArrays,
                                           int[] nextPlayed) {

        List<P4[]> result = new ArrayList<>();

        if (baseArray == null || listOfArrays == null) {
            return result;
        }

        int count = 0;

        // For each candidate array
        for (P4[] candidateArray : listOfArrays) {
            count++;
            System.out.println("\t\t#: " + count +
                    " array in list of arrays has value " +
                    hasValue(candidateArray, nextPlayed));

            if (candidateArray == null) {
                continue;
            }

            boolean containsAll = true;

            // For each element in baseArray
            for (P4 baseElement : baseArray) {

                boolean found = false;

                // Search manually inside candidateArray
                for (P4 candidateElement : candidateArray) {
                    if (baseElement == null && candidateElement == null) {
                        found = true;
                        break;
                    }

                    if (baseElement != null && baseElement.getRelevantString().equals(candidateElement.getRelevantString())) {
                        found = true;
                        break;
                    }
                }

                // If any base element not found → stop checking
                if (!found) {
                    containsAll = false;
                    break;
                }
            }

            if (containsAll) {
                result.add(candidateArray);
            }
        }

        return result;
    }

    public List<P4[]> findContainingArrays2(P4[] baseArray,
                                            P4[] originalArrayForListOfArrays,
                                            List<P4[]> listOfArrays,
                                            int[] nextPlayed) {

        List<P4[]> result = new ArrayList<>();

        if (baseArray == null || listOfArrays == null || baseArray.length == 0) {
            return result;
        }

        int count = 0;

        for (P4[] candidateArray : listOfArrays) {
            count++;

            System.out.println("\t\t#: " + count +
                    " array in list of arrays has value " +
                    hasValue(candidateArray, nextPlayed));

            if (candidateArray == null) {
                continue;
            }

            int notFoundCount = 0;

            // Check each element of baseArray
            for (P4 baseElement : baseArray) {

                boolean found = false;

                for (P4 candidateElement : candidateArray) {

                    if (baseElement == null && candidateElement == null) {
                        found = true;
                        break;
                    }

                    if (baseElement != null &&
                            candidateElement != null &&
                            baseElement.getRelevantString()
                                    .equals(candidateElement.getRelevantString())) {
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    notFoundCount++;
                }
            }

            // Calculate percentage of base elements NOT found
            double missingPercentage = (double) notFoundCount / baseArray.length;

            if (missingPercentage > 0.60) {
                result.add(candidateArray);
            }
        }

        return result;
    }

    public List<P4[]> findContainingArrays3(P4[] baseArray,
                                            P4[] originalArrayForListOfArrays,
                                            List<P4[]> listOfArrays,
                                            int[] nextPlayed) {

        List<P4[]> result = new ArrayList<>();

        if (baseArray == null || listOfArrays == null || baseArray.length == 0) {
            return result;
        }

        int count = 0;

        for (P4[] candidateArray : listOfArrays) {
            count++;

//            System.out.println();

            if (candidateArray == null) {
                continue;
            }

            // Step 1: get tempArray from your method
            P4[] tempArray = notInPParray1(originalArrayForListOfArrays, candidateArray);

            if (tempArray == null || tempArray.length == 0) {
                continue;
            }

            boolean allFoundInBase = true;

            // Step 2: Check if every element in tempArray exists in baseArray
            for (P4 tempElement : tempArray) {

                boolean found = false;

                for (P4 baseElement : baseArray) {

                    if (tempElement == null && baseElement == null) {
                        found = true;
                        break;
                    }

                    if (tempElement != null &&
                            baseElement != null &&
                            tempElement.getRelevantString()
                                    .equals(baseElement.getRelevantString())) {
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    allFoundInBase = false;
                    break;
                }
            }

            // Step 3: If all tempArray values are in baseArray → add candidateArray
            if (allFoundInBase) {
                result.add(candidateArray);
            }

            System.out.println("\t\t#: " + count +
                    " array in list of arrays has value " +
                    hasValue(candidateArray, nextPlayed)+" tempArray.length: "+tempArray.length+" has value: "+hasValue(tempArray, nextPlayed)+" allFoundInBase: " +allFoundInBase+" candidateArray.length: "+candidateArray.length+" has value: "+hasValue(candidateArray, nextPlayed) );
        }

        return result;
    }

    public List<P4[]> findContainingArrays4(
            P4[] baseArray,
            P4[] originalArrayForListOfArrays,
            List<P4[]> listOfArrays,
            int[] nextPlayed) {

        List<P4[]> result = new ArrayList<>();
        int count = 0;


        if (baseArray == null || originalArrayForListOfArrays == null || listOfArrays == null) {
            return result;
        }

        // Convert baseArray to Set for fast lookup
        Set<String> baseSet = new HashSet<>();
        for (P4 p : baseArray) {
            if (p != null) {
                baseSet.add(p.getRelevantString());
            }
        }

        // Convert original to Set
        Set<String> originalSet = new HashSet<>();
        for (P4 p : originalArrayForListOfArrays) {
            if (p != null) {
                originalSet.add(p.getRelevantString());
            }
        }

        for (P4[] candidateArray : listOfArrays) {
            count++;
            System.out.println("\t\t#: " + count +" array in list of arrays has value " + hasValue(candidateArray, nextPlayed));
            if (candidateArray == null) {
                continue;
            }

            // Build candidate set
            Set<String> candidateSet = new HashSet<>();
            for (P4 p : candidateArray) {
                if (p != null) {
                    candidateSet.add(p.getRelevantString());
                }
            }

            // Compute missing elements (original - candidate)
            Set<String> missing = new HashSet<>(originalSet);
            missing.removeAll(candidateSet);

            // Check if missing ⊆ baseSet
            if (baseSet.containsAll(missing)) {
                result.add(candidateArray);
            }
        }

        return result;
    }


    public List<P4[]> findContainingArrays5(
            P4[] baseArray,
            P4[] originalArrayForListOfArrays,
            List<P4[]> listOfArrays,
            int[] nextPlayed) {

        List<P4[]> result = new ArrayList<>();
        int count = 0;

        if (baseArray == null || originalArrayForListOfArrays == null || listOfArrays == null) {
            return result;
        }


                for(P4[] p5Array : listOfArrays){
                    P4[] tempArray = notInPParray1(originalArrayForListOfArrays, p5Array);
                    count++;
                    System.out.println("\t\t#: "+count+" tempArray: "+tempArray.length+ " has value: "+hasValue(tempArray, nextPlayed));
                    int countP4ValuesIn = 0;int countP4ValuesNotIn = 0;
                    for(P4 p5Value: tempArray){
                        boolean p5ValueFound = false;
                        for(P4 baseArrayValue: baseArray){
                            if(p5Value.getRelevantString().equals(baseArrayValue.getRelevantString())){
                                p5ValueFound = true;
                                break;
                            }
                        }
                        if (p5ValueFound){
                            countP4ValuesIn++;
                            if(p5Value.getN1() == nextPlayed[0] && p5Value.getN2() == nextPlayed[1] && p5Value.getN3() ==  nextPlayed[2] && p5Value.getN4() == nextPlayed[3]){
                                System.out.println("\t\t\tFound value: "+p5Value.getRelevantString());
                            }
                        }else{
                           countP4ValuesNotIn++;
                        }
                    }
                    System.out.println("\t\t\tcountP4ValuesIn: "+countP4ValuesIn+" countP4ValuesNotIn: "+countP4ValuesNotIn);
                    if(countP4ValuesIn == tempArray.length){
                        result.add(tempArray);
                    }
                }

        return result;
    }

    public P4[] findLeastSimilar(List<P4[]> arrays) {
        int n = arrays.size();
        int[] similarityScores = new int[n];

        for (int i = 0; i < n; i++) {
            P4[] a = arrays.get(i);

            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                P4[] b = arrays.get(j);

                for (int k = 0; k < a.length; k++) {
                    if (a[k].getRelevantString()
                            .equals(b[k].getRelevantString())) {
                        similarityScores[i]++;
                    }
                }
            }
        }

        int minIndex = 0;
        for (int i = 1; i < similarityScores.length; i++) {
            if (similarityScores[i] < similarityScores[minIndex]) {
                minIndex = i;
            }
        }

        return arrays.get(minIndex);
    }

    public P4[] findLeastSimilar1(List<P4[]> arrays) {
        int n = arrays.size();
        int[] similarityScores = new int[n];

        for (int i = 0; i < n; i++) {
            P4[] a = arrays.get(i);

            for (int j = i + 1; j < n; j++) {  // start after i
                P4[] b = arrays.get(j);

                for (int k = 0; k < a.length; k++) {
                    if (a[k].getRelevantString()
                            .equals(b[k].getRelevantString())) {

                        similarityScores[i]++;
                        similarityScores[j]++; // update both arrays
                    }
                }
            }
        }

        int minIndex = 0;
        for (int i = 1; i < similarityScores.length; i++) {
            if (similarityScores[i] < similarityScores[minIndex]) {
                minIndex = i;
            }
        }

        return arrays.get(minIndex);
    }

    public P4[] findLeastSimilar2(List<P4[]> arrays) {
        int n = arrays.size();
        int[] similarityScores = new int[n];

        for (int i = 0; i < n; i++) {
            P4[] a = arrays.get(i);

            for (int j = i + 1; j < n; j++) {
                P4[] b = arrays.get(j);

                int len = Math.min(a.length, b.length); // prevent index error

                for (int k = 0; k < len; k++) {
                    if (a[k].getRelevantString()
                            .equals(b[k].getRelevantString())) {

                        similarityScores[i]++;
                        similarityScores[j]++;
                    }
                }
            }
        }

        int minIndex = 0;
        for (int i = 1; i < similarityScores.length; i++) {
            if (similarityScores[i] < similarityScores[minIndex]) {
                minIndex = i;
            }
        }

        return arrays.get(minIndex);
    }

    public P4[] findMostSimilar3(List<P4[]> arrays) {
        int n = arrays.size();
        int[] similarityScores = new int[n];

        for (int i = 0; i < n; i++) {
            P4[] a = arrays.get(i);

            for (int j = i + 1; j < n; j++) {
                P4[] b = arrays.get(j);

                int len = Math.min(a.length, b.length);

                for (int k = 0; k < len; k++) {
                    if (a[k].getRelevantString()
                            .equals(b[k].getRelevantString())) {

                        similarityScores[i]++;
                        similarityScores[j]++;
                    }
                }
            }
        }

        int maxIndex = 0;
        for (int i = 1; i < similarityScores.length; i++) {
            if (similarityScores[i] > similarityScores[maxIndex]) {
                maxIndex = i;
            }
        }

        return arrays.get(maxIndex);
    }

    public void checkLeastArraysAreInEachOther(List<P4[]> leastArraysList) {

        for(int i =0; i < leastArraysList.size(); i++){
            P4[] leastArrayChecking = leastArraysList.get(i);
            for(int j = 0; j < leastArraysList.size(); j++){
                if(i==j)continue;
                P4[] tempLeastArray = leastArraysList.get(j);
                int countFound = 0;
                for(P4 valueChecking : leastArrayChecking){
                    for (P4 valueToCheck:  tempLeastArray){
                        if(valueChecking.getRelevantString().equals(valueToCheck.getRelevantString())){
                            countFound++;
                            break;
                        }
                    }
                }
                System.out.println();
                System.out.println("\t\tRun i:"+i);
                System.out.println("\t\t\tj:"+j+" Amount of i in j: "+countFound);

            }
        }

    }

    public List<P4> filterP4(List<P4[]> notInMergedArrays) {

        // Step 1: Count occurrences of each string
        Map<String, Integer> countMap = new HashMap<>();

        for (P4[] array : notInMergedArrays) {
            for (P4 p : array) {
                String key = p.getRelevantString();
                countMap.put(key, countMap.getOrDefault(key, 0) + 1);
            }
        }

        // Step 2: Collect only those with count <= 3
        List<P4> result = new ArrayList<>();

        for (P4[] array : notInMergedArrays) {
            for (P4 p : array) {
                String key = p.getRelevantString();
                if (countMap.get(key) <= 3) {
                    result.add(p);
                }
            }
        }

        return result;
    }

    public  List<P4> filterP4Global(List<List<P4[]>> notInMergedArrays) {

        // Step 1: Count occurrences globally
        Map<String, Integer> countMap = new HashMap<>();

        for (List<P4[]> innerList : notInMergedArrays) {
            for (P4[] array : innerList) {
                for (P4 p : array) {
                    String key = p.getRelevantString();
                    countMap.put(key, countMap.getOrDefault(key, 0) + 1);
                }
            }
        }

        // Step 2: Filter results
        List<P4> result = new ArrayList<>();

        for (List<P4[]> innerList : notInMergedArrays) {
            for (P4[] array : innerList) {
                for (P4 p : array) {
                    String key = p.getRelevantString();
                    if (countMap.get(key) <= 3) {
                        result.add(p);
                    }
                }
            }
        }

        return result;
    }

    public List<List<P4[]>> process(List<TwoArrayObjects> t) {
        List<List<P4[]>> result = new ArrayList<>();

        for (int n = 0; n < t.size(); n++) {
            P4[] temp = t.get(n).getOne();

            // Step 1: divide into 5 parts
            List<P4[]> firstSplit = splitIntoFive(temp);

            // Step 2: get 5C4 combinations
            List<CombinationResult> firstComb = combine5C4WithLeftover(firstSplit);

            List<P4[]> dividedBy5AndCombinedBy4 = new ArrayList<>();

            for (CombinationResult comb1 : firstComb) {

                // leftover array from first combination
                P4[] leftover = comb1.leftover;

                // Step 3: split leftover again into 5
                List<P4[]> secondSplit = splitIntoFive(leftover);

                // Step 4: second 5C4
                List<CombinationResult> secondComb = combine5C4WithLeftover(secondSplit);

                for (CombinationResult comb2 : secondComb) {

                    // Step 5: merge first combination + second combination
                    P4[] merged = mergeArrays(comb1.combined, comb2.combined);
                    dividedBy5AndCombinedBy4.add(merged);
                }
            }

            result.add(dividedBy5AndCombinedBy4);
        }

        return result;
    }

    // Helper class to track combination + leftover
    static class CombinationResult {
        P4[] combined;
        P4[] leftover;

        CombinationResult(P4[] combined, P4[] leftover) {
            this.combined = combined;
            this.leftover = leftover;
        }
    }

    // Split array into 5 parts
    private static List<P4[]> splitIntoFive(P4[] array) {
        List<P4[]> parts = new ArrayList<>();

        int total = array.length;
        int baseSize = total / 5;
        int remainder = total % 5;

        int index = 0;

        for (int i = 0; i < 5; i++) {
            int size = baseSize + (i == 4 ? remainder : 0);
            P4[] part = new P4[size];

            for (int j = 0; j < size; j++) {
                part[j] = array[index++];
            }

            parts.add(part);
        }

        return parts;
    }

    // Generate 5C4 combinations + track leftover
    private static List<CombinationResult> combine5C4WithLeftover(List<P4[]> parts) {
        List<CombinationResult> results = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            List<P4[]> selected = new ArrayList<>();

            for (int j = 0; j < 5; j++) {
                if (j != i) {
                    selected.add(parts.get(j));
                }
            }

            P4[] combined = mergeMultiple(selected);
            P4[] leftover = parts.get(i);

            results.add(new CombinationResult(combined, leftover));
        }

        return results;
    }

    // Merge multiple arrays
    private static P4[] mergeMultiple(List<P4[]> arrays) {
        int totalLength = 0;

        for (P4[] arr : arrays) {
            totalLength += arr.length;
        }

        P4[] result = new P4[totalLength];
        int index = 0;

        for (P4[] arr : arrays) {
            for (P4 p : arr) {
                result[index++] = p;
            }
        }

        return result;
    }
    // Merge multiple arrays
    private static P4[] mergeMultipleList(List<List<P4[]>> arrays) {
        int totalLength = 0;

        List<P4[]> tempArrays = new ArrayList<>();
        for(List<P4[]> P: arrays){
            tempArrays.add(mergeMultiple(P));
        }

        for (P4[] arr : tempArrays) {
            totalLength += arr.length;
        }

        P4[] result = new P4[totalLength];
        int index = 0;

        for (P4[] arr : tempArrays) {
            for (P4 p : arr) {
                result[index++] = p;
            }
        }

        return result;
    }

    // Merge two arrays
    private static P4[] mergeArrays(P4[] a, P4[] b) {
        P4[] result = new P4[a.length + b.length];

        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);

        return result;
    }


        public List<P4> processAfterDivBy5Combine4(P4[] a, List<List<P4[]>> b) {

            // Final structure: List of groups → each group has list of arrays
            List<List<P4[]>> groupedMissingArrays = new ArrayList<>();

            // ===== Phase 1 =====
            for (List<P4[]> group : b) {

                List<P4[]> tempNotInBArrayList = new ArrayList<>();

                for (P4[] arrayInGroup : group) {

                    // Build set of values in current array
                    Set<String> set = new HashSet<>();
                    for (P4 p : arrayInGroup) {
                        set.add(p.getRelevantString());
                    }

                    // Find values from 'a' NOT in this array
                    List<P4> tempNotInB = new ArrayList<>();

                    for (P4 p : a) {
                        if (!set.contains(p.getRelevantString())) {
                            tempNotInB.add(p);
                        }
                    }

                    // Convert to array
                    P4[] tempNotInBArray = tempNotInB.toArray(new P4[0]);

                    // Add to group list
                    tempNotInBArrayList.add(tempNotInBArray);
                }

                // Add this group's result
                groupedMissingArrays.add(tempNotInBArrayList);
            }

            // ===== Phase 2 =====
            // Count in how many groups each value appears
            Map<String, Integer> groupFrequency = new HashMap<>();

            int totalGroups = groupedMissingArrays.size();

            for (List<P4[]> group : groupedMissingArrays) {

                // Track unique values per group (important!)
                Set<String> seenInGroup = new HashSet<>();

                for (P4[] arr : group) {
                    for (P4 p : arr) {
                        seenInGroup.add(p.getRelevantString());
                    }
                }

                // Increment count once per group
                for (String val : seenInGroup) {
                    groupFrequency.put(val, groupFrequency.getOrDefault(val, 0) + 1);
                }
            }

            // ===== Phase 3 =====
            List<P4> result = new ArrayList<>();

            for (P4 p : a) {
                String val = p.getRelevantString();

                int count = groupFrequency.getOrDefault(val, 0);

                double percentage = (double) count / totalGroups;

                if (percentage >= 0.80) {
                    result.add(p);
                }
            }

            return result;
        }

    public List<P4[]> generateDivBy5CombineBy4Array(P4[] A1A) {
        List<P4[]> returnList = new ArrayList<>();

        // Step 1: Split into 5 parts
        List<List<P4>> parts = splitIntoFiveA1A(A1A);

        // Step 2: 5C4 combinations (exclude one part each time)
        for (int i = 0; i < 5; i++) {

            List<P4> baseCombined = new ArrayList<>();

            // Combine 4 parts (excluding i)
            for (int j = 0; j < 5; j++) {
                if (j != i) {
                    baseCombined.addAll(parts.get(j));
                }
            }

            // Step 3: Take unused part and split again into 5
            List<List<P4>> subParts = splitIntoFiveA1A(
                    parts.get(i).toArray(new P4[0])
            );

            // Step 4: Merge each subpart with baseCombined
            for (List<P4> sub : subParts) {
                List<P4> finalCombined = new ArrayList<>(baseCombined);
                finalCombined.addAll(sub);

                // Convert to array and add to return list
                returnList.add(finalCombined.toArray(new P4[0]));
            }
        }

        return returnList; // should contain 25 arrays
    }

    // Helper: split into 5 parts, last gets remainder
    private List<List<P4>> splitIntoFiveA1A(P4[] arr) {
        List<List<P4>> parts = new ArrayList<>();

        int n = arr.length;
        int baseSize = n / 5;
        int index = 0;

        // First 4 equal parts
        for (int i = 0; i < 4; i++) {
            List<P4> part = new ArrayList<>();
            for (int j = 0; j < baseSize; j++) {
                part.add(arr[index++]);
            }
            parts.add(part);
        }

        // Last part gets remainder
        List<P4> last = new ArrayList<>();
        while (index < n) {
            last.add(arr[index++]);
        }
        parts.add(last);

        return parts;
    }

    public static P4[] findCommon(P4[] a, P4[] b) {
        List<P4> commonList = new ArrayList<>();

        // Store all strings from B for fast lookup
        Set<String> setB = new HashSet<>();
        for (P4 p : b) {
            if (p != null && p.getRelevantString() != null) {
                setB.add(p.getRelevantString());
            }
        }

        // Compare elements from A with B
        for (P4 p : a) {
            if (p != null) {
                String str = p.getRelevantString();
                if (str != null && setB.contains(str)) {
                    commonList.add(p);
                }
            }
        }

        // Convert List<P4> to P4[]
        return commonList.toArray(new P4[0]);
    }

    public static P4[] findCommonAcrossAll(List<P4[]> A) {
        if (A == null || A.isEmpty()) {
            return new P4[0];
        }

        List<P4> A1 = new ArrayList<>();

        // Step 1: Initialize with first array
        Map<String, P4> commonMap = new HashMap<>();
        for (P4 p : A.get(0)) {
            if (p != null && p.getRelevantString() != null) {
                commonMap.put(p.getRelevantString(), p);
            }
        }

        // Step 2: Intersect with remaining arrays
        for (int i = 1; i < A.size(); i++) {
            Set<String> currentSet = new HashSet<>();

            for (P4 p : A.get(i)) {
                if (p != null && p.getRelevantString() != null) {
                    currentSet.add(p.getRelevantString());
                }
            }

            // Remove anything not in current array
            commonMap.keySet().retainAll(currentSet);

            // Early exit if empty
            if (commonMap.isEmpty()) {
                return new P4[0];
            }
        }

        // Step 3: Collect results
        A1.addAll(commonMap.values());

        // Step 4: Convert to array
        return A1.toArray(new P4[0]);
    }

    public P4[] findRepeatedAcrossArrays(List<P4[]> list) {
        List<P4> result = new ArrayList<>();

        // Map: string -> set of array indices where it appears
        Map<String, Set<Integer>> occurrenceMap = new HashMap<>();

        // Map to store one representative P4 object per string
        Map<String, P4> valueMap = new HashMap<>();

        // Step 1: Traverse all arrays
        for (int i = 0; i < list.size(); i++) {
            P4[] arr = list.get(i);

            // To avoid counting duplicates within the same array
            Set<String> seenInThisArray = new HashSet<>();

            for (P4 p : arr) {
                if (p == null) continue;

                String key = p.getRelevantString();
                if (key == null) continue;

                // Avoid duplicate counting in same array
                if (seenInThisArray.contains(key)) continue;
                seenInThisArray.add(key);

                occurrenceMap
                        .computeIfAbsent(key, k -> new HashSet<>())
                        .add(i);

                // Store representative object
                valueMap.putIfAbsent(key, p);
            }
        }

        // Step 2: Collect values appearing in more than one array
        for (Map.Entry<String, Set<Integer>> entry : occurrenceMap.entrySet()) {
            if (entry.getValue().size() > 1) {
                result.add(valueMap.get(entry.getKey()));
            }
        }

        return result.toArray(new P4[0]);
    }


//    public List<P4[]> selectRandomFromGroupsFive(List<P4[]> A) {
//        if (A == null || A.size() % 5 != 0) {
//            throw new IllegalArgumentException("List size must be divisible by 5.");
//        }
//
//        List<P4[]> result = new ArrayList<>();
//        int groupCount = A.size() / 5;
//
//        for (int group = 0; group < groupCount; group++) {
//            int start = group * 5;
//
//            // pick random index within this group (0–4 offset)
//            int randomIndex = start + ThreadLocalRandom.current().nextInt(5);
//
//            result.add(A.get(randomIndex));
//        }
//
//        return result;
//    }

    public List<P4[]> selectRandomFromGroupsFive(List<P4[]> A) {
        if (A == null || A.isEmpty()) {
            throw new IllegalArgumentException("List cannot be null or empty.");
        }

        List<P4[]> result = new ArrayList<>();

        for (int i = 0; i < A.size(); i += 5) {
            int end = Math.min(i + 5, A.size());

            // Create sublist [i, end)
            List<P4[]> subList = A.subList(i, end);

            // Pick random element from this sublist
            int randomIndex = ThreadLocalRandom.current().nextInt(subList.size());

            result.add(subList.get(randomIndex));
        }

        return result;
    }

    public List<P4[]> selectRandomHalfOfList(List<P4[]> A) {
        if (A == null || A.size() % 5 != 0) {
            throw new IllegalArgumentException("List size must be divisible by 5.");
        }

        // Make a copy so we don’t modify the original list
        List<P4[]> copy = new ArrayList<>(A);

        // Shuffle the list randomly
        Collections.shuffle(copy);

        // Take the first half
        int halfSize = copy.size() / 2;
        return new ArrayList<>(copy.subList(0, halfSize));
    }

    public List<P4PlusInt> selectRandomHalfOfListNoFive(List<P4PlusInt> A) {

        // Make a copy so we don’t modify the original list
        List<P4PlusInt> copy = new ArrayList<>(A);

        // Shuffle the list randomly
        Collections.shuffle(copy);

        // Take the first half
        int halfSize = copy.size() / 2;
        return new ArrayList<>(copy.subList(0, halfSize));
    }


    public P4[][] splitRandomlyArrayInHalf(P4[] original) {
        if (original == null || original.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty.");
        }

        // Convert array to list for shuffling
        List<P4> list = new ArrayList<>(Arrays.asList(original));
        Collections.shuffle(list);

        int mid = list.size() / 2; // floor division

        // If odd, second half gets the extra element
        List<P4> firstHalf = list.subList(0, mid);
        List<P4> secondHalf = list.subList(mid, list.size());

        // Convert back to arrays
        P4[] arr1 = firstHalf.toArray(new P4[0]);
        P4[] arr2 = secondHalf.toArray(new P4[0]);

        return new P4[][] { arr1, arr2 };
    }

    public List<List<List<P4>>> processListOfDivBy5(
            List<P4[]> tempDohHavePossiblePlayAfterDiv5Array,
            List<P4[]> arrayToCheckNotInTempDohHaveForSurePPListOfRandomHalfMergedWithNotIn,
            P4[] halfingNotInTempDohHaveForSurePP) {

        List<List<List<P4>>> result = new ArrayList<>();

        // Outer loop
        for (P4[] tempArrayDohHavePossiblePlayAfterDiv5Array : tempDohHavePossiblePlayAfterDiv5Array) {

            List<List<P4>> outerList = new ArrayList<>();

            // Inner loop
            for (P4[] tempArrayToCheckNotInTempDohHaveForSurePPListOfRandomHalfMergedWithNotIn
                    : arrayToCheckNotInTempDohHaveForSurePPListOfRandomHalfMergedWithNotIn) {

                // Call your method
                P4[] tempNotInPossiblePlayable = notInPParray1(halfingNotInTempDohHaveForSurePP, tempArrayToCheckNotInTempDohHaveForSurePPListOfRandomHalfMergedWithNotIn);

                List<P4> matches = new ArrayList<>();

                // Compare elements
                for (P4 p1 : tempNotInPossiblePlayable) {
                    for (P4 p2 : tempArrayDohHavePossiblePlayAfterDiv5Array) {

                        if (p1.getRelevantString().equals(p2.getRelevantString())) {
                            matches.add(p1);
                        }
                    }
                }

                outerList.add(matches);
            }

            result.add(outerList);
        }

        return result;
    }


    public List<int[]> getHalfRandomizedPairs(
            List<int[]> pairCombinations,
            String notIn1,
            String notIn2,
            boolean testMode) {

        if (pairCombinations == null || pairCombinations.isEmpty()) {
            return Collections.emptyList();
        }

        // Create a copy so we don't mutate the original list
        List<int[]> shuffledList = new ArrayList<>(pairCombinations);

        // Shuffle the list randomly
        Collections.shuffle(shuffledList);

        // Calculate half size (round up if odd)
        int halfSize = (shuffledList.size() + 1) / 2;

        // Get approximately half
        List<int[]> halfList = new ArrayList<>(shuffledList.subList(0, halfSize));

        // Test mode logic
        boolean found = false;
        if (testMode) {
            for (int[] pair : halfList) {
                if (pair != null && pair.length == 2) {
                    String val1 = String.valueOf(pair[0]);
                    String val2 = String.valueOf(pair[1]);

                    if ((val1.equals(notIn1) && val2.equals(notIn2)) ||
                            (val1.equals(notIn2) && val2.equals(notIn1))) {
//                        System.out.println("Has pair");
                        found=true;
                    } else {
//                        System.out.println("Does Not have pair");
                    }
                } else {
                    System.out.println("Invalid pair");
                }
            }
        }


        if(found){
            System.out.println("Has pair");
        }else{
            System.out.println("Does Not have pair");
        }
        return halfList;
    }

    public static boolean containsAllValues(String combinedString, int[] nextPlayed) {

        for (int value : nextPlayed) {
            String token = "=" + value;

            if (!combinedString.contains(token)) {
                return false; // as soon as one value is missing, fail
            }
        }

        return true; // all values found
    }


    public void countMatches(
            List<int[]> halfPairCombinationsList_Array,
            List<P4[]> tempDohHavePossiblePlayAfterDiv5Array,
            int[] nextPlayed) {

        for (P4[] p5Array : tempDohHavePossiblePlayAfterDiv5Array) {

            int counter = 0;

            // Build combined string of all P4 objects
            StringBuilder sb = new StringBuilder();
            for (P4 p : p5Array) {
                sb.append(p.getRelevantString()).append("|"); // extra delimiter between objects
            }
            String combinedString = sb.toString();

            boolean allMatch2=false;
            // Check each int[] combination
            for (int[] combo : halfPairCombinationsList_Array) {

                boolean allMatch = true;
                boolean allMatch1 = false;
                for (int value : combo) {
                    // Match exact value using "=" delimiter to avoid partial matches
                    String token = "=" + value;

                    if (!combinedString.contains(token)) {
                        allMatch = false;
                        break;
                    }
                }

                if (allMatch) {
                    counter++;
                    //System.out.println(combinedString);
                    allMatch1 = containsAllValues(combinedString, nextPlayed);
                    if(allMatch1){
                        allMatch2=true;
                    }
                }
            }

            System.out.println("Count for current P4[]: " + counter+ " has value: "+allMatch2);
        }
    }

    public void countMatches1(
            List<int[]> halfPairCombinationsList_Array,
            List<P4[]> tempDohHavePossiblePlayAfterDiv5Array,
            int[] nextPlayed) {

        for (P4[] p5Array : tempDohHavePossiblePlayAfterDiv5Array) {

            int counter = 0;
            boolean allMatch2 = false;

            // Now evaluate EACH P4 individually
            for (P4 p : p5Array) {

                String p5String = p.getRelevantString();

                // Check each int[] combination
                for (int[] combo : halfPairCombinationsList_Array) {

                    boolean allMatch = true;

                    for (int value : combo) {
                        String token = "=" + value;

                        if (!p5String.contains(token)) {
                            allMatch = false;
                            break;
                        }
                    }

                    if (allMatch) {
                        counter++;
                        System.out.println(p5String);
                        // Check nextPlayed against THIS SAME P4 (not combined)
                        if (containsAllValues(p5String, nextPlayed)) {
                            allMatch2 = true;
                        }
                    }
                }
            }

            System.out.println("Count for current P4[]: " + counter + " has value: " + allMatch2);
        }
    }


    public void countMatches2(
            List<int[]> halfPairCombinationsList_Array,
            List<P4[]> tempDohHavePossiblePlayAfterDiv5Array,
            int[] nextPlayed) {

        P4 nextPlayedP4 = new P4(nextPlayed[0], nextPlayed[1], nextPlayed[2], nextPlayed[3], nextPlayed[4]);

        int counter1 =0;
        for (P4[] p5Array : tempDohHavePossiblePlayAfterDiv5Array) {
            counter1++;
            int counter = 0;
            boolean allMatch2 = false;

            System.out.println("Starting...."+counter1);
            // Now evaluate EACH P4 individually
            for (P4 p : p5Array) {
                boolean allMatch1 = false;
                String p5String = p.getRelevantString();
                //System.out.println("\t"+p5String+ " has value: "+p5String.equals(nextPlayedP4.getRelevantString()));

                // Check each int[] combination
                for (int[] combo : halfPairCombinationsList_Array) {

                    boolean allMatch = false;


                    String token1 = "=" + combo[0];
                    String token2 = "=" + combo[1];
//                    System.out.println("\tTesting tokens:["+token1+","+token2+"]");

                    if(p5String.contains(token1) && p5String.contains(token2)){
                        allMatch = true;
                    }


                    if (allMatch) {
                        counter++;
                      //  System.out.println("#:"+counter+" " +p5String+" with tokens:["+token1+", "+token2 + "] has value: "+p5String.equals(nextPlayedP4.getRelevantString()));
                        // Check nextPlayed against THIS SAME P4 (not combined)
//                        if (containsAllValues(p5String, nextPlayed)) {
                        if (p5String.equals(nextPlayedP4.getRelevantString())) {
                            allMatch2 = true;
                        }
                    }
                }
            }

            System.out.println("Count for current P4[]: " + counter + " has value: " + allMatch2);
        }
    }

    public void countMatches3(List<int[]> halfPairCombinationsList_Array,
                              List<P4[]> tempDohHavePossiblePlayAfterDiv5Array,
                              int[] nextPlayed) {

        P4 nextPlayedP4 = new P4(nextPlayed[0], nextPlayed[1], nextPlayed[2], nextPlayed[3], nextPlayed[4]);

        int counter1 = 0;

        for (P4[] p5Array : tempDohHavePossiblePlayAfterDiv5Array) {
            counter1++;
            int counter = 0;
            boolean allMatch2 = false;

            System.out.println("Starting...." + counter1);

            for (P4 p : p5Array) {

                String p5String = p.getRelevantString();

                int matchCount = 0;          // <-- track how many combos match
                int[] matchedCombo = null;  // <-- optional, if you still need it

                // Check each int[] combination
                for (int[] combo : halfPairCombinationsList_Array) {

                    String token1 = "=" + combo[0];
                    String token2 = "=" + combo[1];

                    if (p5String.contains(token1) && p5String.contains(token2)) {
                        matchCount++;
                        matchedCombo = combo;

                        // Early exit if more than one match found
                        if (matchCount > 1) {
                            break;
                        }
                    }
                }

                // ✅ Only accept strings that match EXACTLY ONE combo
                if (matchCount == 1) {
                    counter++;

                    if (p5String.equals(nextPlayedP4.getRelevantString())) {
                        allMatch2 = true;
                    }
                }
                // ❌ If matchCount == 0 or >1 → ignore this p5String completely
            }

            System.out.println("Count for current P4[]: " + counter + " has value: " + allMatch2);
        }
    }

    public void countMatches4(List<int[]> halfPairCombinationsList_Array,
                              List<P4[]> tempDohHavePossiblePlayAfterDiv5Array,
                              int[] nextPlayed) {

        P4 nextPlayedP4 = new P4(nextPlayed[0], nextPlayed[1], nextPlayed[2], nextPlayed[3], nextPlayed[4]);

        int counter1 = 0;

        for (P4[] p5Array : tempDohHavePossiblePlayAfterDiv5Array) {
            counter1++;

            // ✅ Track UNIQUE valid matches
            Set<String> countedStrings = new HashSet<>();

            boolean allMatch2 = false;

            System.out.println("Starting...." + counter1);

            for (P4 p : p5Array) {

                String p5String = p.getRelevantString();

                // ✅ Skip if already counted
                if (countedStrings.contains(p5String)) {
                    continue;
                }

                int matchCount = 0;

                for (int[] combo : halfPairCombinationsList_Array) {

                    String token1 = "=" + combo[0];
                    String token2 = "=" + combo[1];

                    // ✅ Safer matching (prevents "=1" matching "=10")
                    boolean hasToken1 = p5String.matches(".*\\b" + token1 + "\\b.*");
                    boolean hasToken2 = p5String.matches(".*\\b" + token2 + "\\b.*");

                    if (hasToken1 && hasToken2) {
                        matchCount++;

                        if (matchCount > 1) {
                            break;
                        }
                    }
                }

                // ✅ Only count STRICTLY one combo match
                if (matchCount == 1) {
                    countedStrings.add(p5String);

                    if (p5String.equals(nextPlayedP4.getRelevantString())) {
                        allMatch2 = true;
                    }
                }
            }

            // ✅ Now count reflects UNIQUE valid strings only
            int counter = countedStrings.size();

            System.out.println("Count for current P4[]: " + counter + "for p5Array of length:"+ p5Array.length+ " has value: " + allMatch2);
        }
    }

    public List<int[]> countMatches5(
            List<int[]> halfPairCombinationsList_Array,
            List<P4[]> tempDohHavePossiblePlayAfterDiv5Array,
            int[] nextPlayed) {

        P4 nextPlayedP4 = new P4(nextPlayed[0], nextPlayed[1], nextPlayed[2], nextPlayed[3], nextPlayed[4]);

        // Track match counts per combo
        Map<String, Integer> comboMatchCount = new HashMap<>();
        Map<String, int[]> comboLookup = new HashMap<>();

        // Initialize maps
        for (int[] combo : halfPairCombinationsList_Array) {
            String key = combo[0] + "," + combo[1];
            comboMatchCount.put(key, 0);
            comboLookup.put(key, combo);
        }

        int counter1 = 0;

        for (P4[] p5Array : tempDohHavePossiblePlayAfterDiv5Array) {
            counter1++;

            Set<String> countedStrings = new HashSet<>();
            boolean allMatch2 = false;

            System.out.println("Starting...." + counter1);

            for (P4 p : p5Array) {

                String p5String = p.getRelevantString();

                if (countedStrings.contains(p5String)) {
                    continue;
                }

                for (int[] combo : halfPairCombinationsList_Array) {

                    String key = combo[0] + "," + combo[1];

                    String token1 = "=" + combo[0];
                    String token2 = "=" + combo[1];

                    boolean hasToken1 = p5String.matches(".*\\b" + token1 + "\\b.*");
                    boolean hasToken2 = p5String.matches(".*\\b" + token2 + "\\b.*");

                    if (hasToken1 && hasToken2) {
                        // increment combo match count
                        comboMatchCount.put(key, comboMatchCount.get(key) + 1);

                        countedStrings.add(p5String);

                        if (p5String.equals(nextPlayedP4.getRelevantString())) {
                            allMatch2 = true;
                        }
                    }
                }
            }

            int counter = countedStrings.size();
            System.out.println("Count for current P4[]: " + counter +
                    " for p5Array length: " + p5Array.length +
                    " has value: " + allMatch2);
        }

        // ✅ Filter combos that matched at least once
        List<int[]> matchedCombos = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : comboMatchCount.entrySet()) {
            if (entry.getValue() > 0) {
                matchedCombos.add(comboLookup.get(entry.getKey()));
            }
        }

        return matchedCombos;
    }

    public List<int[]> countMatches6(
            List<int[]> halfPairCombinationsList_Array,
            List<P4[]> tempDohHavePossiblePlayAfterDiv5Array,
            int[] nextPlayed) {

        P4 nextPlayedP4 = new P4(nextPlayed[0], nextPlayed[1], nextPlayed[2], nextPlayed[3], nextPlayed[4]);
        String nextPlayedString = nextPlayedP4.getRelevantString();

        Map<String, Integer> comboMatchCount = new HashMap<>();
        Map<String, int[]> comboLookup = new HashMap<>();

        for (int[] combo : halfPairCombinationsList_Array) {
            String key = combo[0] + "," + combo[1];
            comboMatchCount.put(key, 0);
            comboLookup.put(key, combo);
        }

        Random random = new Random();
        int counter1 = 0;

        for (P4[] p5Array : tempDohHavePossiblePlayAfterDiv5Array) {
            counter1++;
            System.out.println("Starting...." + counter1);

            // ✅ Create a shuffled copy
            List<P4> shuffled = new ArrayList<>(Arrays.asList(p5Array));
            Collections.shuffle(shuffled, random);

            // ✅ Take HALF randomly
            int halfSize = p5Array.length / 2;
            List<P4> halfRandom = shuffled.subList(0, halfSize);

            Set<String> countedStrings = new HashSet<>();
            boolean containsNextPlayed = false;

            // ✅ Check if random half contains nextPlayed
            for (P4 p : halfRandom) {
                if (p.getRelevantString().equals(nextPlayedString)) {
                    containsNextPlayed = true;
                    break;
                }
            }

            // ✅ Process matching on the random half
            for (P4 p : halfRandom) {

                String p5String = p.getRelevantString();

                if (countedStrings.contains(p5String)) {
                    continue;
                }

                for (int[] combo : halfPairCombinationsList_Array) {

                    String key = combo[0] + "," + combo[1];

                    String token1 = "=" + combo[0];
                    String token2 = "=" + combo[1];

                    boolean hasToken1 = p5String.matches(".*\\b" + token1 + "\\b.*");
                    boolean hasToken2 = p5String.matches(".*\\b" + token2 + "\\b.*");

                    if (hasToken1 && hasToken2) {
                        comboMatchCount.put(key, comboMatchCount.get(key) + 1);
                        countedStrings.add(p5String);
                    }
                }
            }

            int counter = countedStrings.size();

            System.out.println("Random half size: " + halfRandom.size() +
                    " | Count: " + counter +
                    " | contains nextPlayed: " + containsNextPlayed);
        }

        List<int[]> matchedCombos = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : comboMatchCount.entrySet()) {
            if (entry.getValue() > 0) {
                matchedCombos.add(comboLookup.get(entry.getKey()));
            }
        }

        return matchedCombos;
    }

        public  List<int[]> removeDuplicateIntArrays(List<int[]> arrays) {
            List<int[]> result = new ArrayList<>();
            Set<String> seen = new HashSet<>();

            for (int[] arr : arrays) {
                String key = Arrays.toString(arr);

                if (!seen.contains(key)) {
                    seen.add(key);
                    result.add(arr);
                }
            }

            return result;
        }


    public List<P4> filterP4ByIntArrayPairs(P4[] p5Array, List<int[]> pairs) {

        List<P4> result = new ArrayList<>();

        for (P4 p4 : p5Array) {

            int matchCount = 0;

            for (int[] pair : pairs) {

                if (pair.length != 2) {
                    continue;
                }

                boolean containsFirst = contains(p4, pair[0]);
                boolean containsSecond = contains(p4, pair[1]);

                if (containsFirst && containsSecond) {
                    matchCount++;

                    // Matches more than one pair -> reject
                    if (matchCount > 1) {
                        break;
                    }
                }
            }

            // Keep only P4s matching exactly one pair
            if (matchCount == 1) {
                result.add(p4);
            }
        }

        return result;
    }

    private static boolean contains(P4 p4, int value) {
        return p4.n1 == value
                || p4.n2 == value
                || p4.n3 == value
                || p4.n4 == value;
    }

    public List<int[]> filterOnceOrTwice(List<int[]> intArrayList) {
        Map<String, Integer> countMap = new HashMap<>();

        // Count occurrences
        for (int[] arr : intArrayList) {
            String key = arr[0] + "," + arr[1];
            countMap.put(key, countMap.getOrDefault(key, 0) + 1);
        }

        // Collect arrays that appear once or twice
        List<int[]> result = new ArrayList<>();
        for (int[] arr : intArrayList) {
            String key = arr[0] + "," + arr[1];
            int count = countMap.get(key);
            if (count == 1 || count == 2) {
                result.add(arr);
            }
        }

        return result;
    }


    public List<P4[]> splitAndCombineByChunkSize(P4[] array, int chunkSize) {
        List<P4[]> chunks = new ArrayList<>();

        int fullChunks = array.length / chunkSize;
        int remainder = array.length % chunkSize;

        int index = 0;

        // If remainder exists, reduce one chunk to merge later
        int limit = (remainder == 0) ? fullChunks : fullChunks - 1;

        // Step 1: Create normal chunks
        for (int i = 0; i < limit; i++) {
            chunks.add(Arrays.copyOfRange(array, index, index + chunkSize));
            index += chunkSize;
        }

        // Step 2: Handle last chunk
        if (remainder == 0) {
            while (index < array.length) {
                int end = Math.min(index + chunkSize, array.length);
                chunks.add(Arrays.copyOfRange(array, index, end));
                index = end;
            }
        } else {
            // Merge last full chunk + remainder
            int lastSize = chunkSize + remainder;
            chunks.add(Arrays.copyOfRange(array, index, index + lastSize));
        }

        // Step 3: Generate combinations (kC(k-1))
        int k = chunks.size();
        List<P4[]> results = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            int totalLength = 0;

            // Calculate total length excluding chunk i
            for (int j = 0; j < k; j++) {
                if (j != i) {
                    totalLength += chunks.get(j).length;
                }
            }

            P4[] combined = new P4[totalLength];
            int pos = 0;

            // Copy all chunks except i
            for (int j = 0; j < k; j++) {
                if (j != i) {
                    P4[] chunk = chunks.get(j);
                    System.arraycopy(chunk, 0, combined, pos, chunk.length);
                    pos += chunk.length;
                }
            }

            results.add(combined);
        }

        return results;
    }


    public static List<P4PlusInt> splitCombineAndDetectByChunkSize(P4[] array, int chunkSize, int[] target) {

        System.out.println("p5ArrayPossibleNotInArrayP4Array.length: "+array.length+ " to be split into "+ chunkSize+ " chunk sizes");
        List<P4[]> chunks = splitIntoChunks(array, chunkSize);

        int k = chunks.size();
        List<P4PlusInt> results = new ArrayList<>();

        for (int i = 0; i < k; i++) {

            // Check if excluded chunk contains the target
            boolean excludedHasTarget = contains(chunks.get(i), target);

            int totalLength = 0;

            // Calculate size of combination (excluding chunk i)
            for (int j = 0; j < k; j++) {
                if (j != i) {
                    totalLength += chunks.get(j).length;
                }
            }

            P4[] combined = new P4[totalLength];
            int pos = 0;

            // Build combination
            for (int j = 0; j < k; j++) {
                if (j != i) {
                    P4[] chunk = chunks.get(j);
                    System.arraycopy(chunk, 0, combined, pos, chunk.length);
                    pos += chunk.length;
                }
            }

            boolean combinedHasTarget = contains(combined, target);

            // 🔍 Key logic:
            // If excluded chunk HAS target, but combined DOES NOT,
            // then that chunk was the ONLY one containing it
            if (excludedHasTarget && !combinedHasTarget) {
                System.out.println("Target isolated in chunk index: " + i);
            }

            P4PlusInt p5pi = new P4PlusInt(combined, i);
            results.add(p5pi);
        }

        return results;
    }

    private static boolean contains(P4[] arr, int[] target) {
        for (P4 p : arr) {
            if (p.getN1() == target[0] && p.getN2() == target[1] && p.getN3() == target[2] && p.getN4() == target[3]) {
                return true;
            }
        }
        return false;
    }

    private static List<P4[]> splitIntoChunks(P4[] array, int chunkSize) {
        List<P4[]> chunks = new ArrayList<>();

        int fullChunks = array.length / chunkSize;
        int remainder = array.length % chunkSize;

        int index = 0;
        int limit = (remainder == 0) ? fullChunks : fullChunks - 1;

        for (int i = 0; i < limit; i++) {
            chunks.add(Arrays.copyOfRange(array, index, index + chunkSize));
            index += chunkSize;
        }

        if (remainder == 0) {
            while (index < array.length) {
                int end = Math.min(index + chunkSize, array.length);
                chunks.add(Arrays.copyOfRange(array, index, end));
                index = end;
            }
        } else {
            int lastSize = chunkSize + remainder;
            chunks.add(Arrays.copyOfRange(array, index, index + lastSize));
        }

        return chunks;
    }

    public static List<P4PlusInt> getRandomHalfRandom1To3(List<P4PlusInt> A) {
        // Shuffle the list
        Collections.shuffle(A);

        int size = A.size();
        int halfSize = size / 2;

        List<P4PlusInt> result = new ArrayList<>();

        // Generate random number between 1 and 3
        Random rand = new Random();
        int choice = rand.nextInt(3) + 1;

        switch (choice) {
            case 1:
                // First half
                for (int i = 0; i < halfSize; i++) {
                    P4PlusInt p5PlusInt = new P4PlusInt(A.get(i).getOne(), A.get(i).getTwo());
                    result.add(p5PlusInt);
                }
                break;

            case 2:
                // Middle half
                int startMid = (size - halfSize) / 2;
                for (int i = startMid; i < startMid + halfSize; i++) {
                    P4PlusInt p5PlusInt = new P4PlusInt(A.get(i).getOne(), A.get(i).getTwo());
                    result.add(p5PlusInt);
                }
                break;

            case 3:
                // Last half
                for (int i = size - halfSize; i < size; i++) {
                    P4PlusInt p5PlusInt = new P4PlusInt(A.get(i).getOne(), A.get(i).getTwo());
                    result.add(p5PlusInt);
                }
                break;
        }

        return result;
    }

    public static List<P4> flattenP4ArrayList(List<P4[]> A) {
        List<P4> result = new ArrayList<>();

        for (P4[] array : A) {
            if (array != null) { // safety check
                for (P4 item : array) {
                    result.add(item);
                }
            }
        }

        return result;
    }

    public List<P4> getFilteredP4List(List<P4> A, List<P4> B) {
        List<P4> resultsA = new ArrayList<>();

        // Store all relevant strings from B for fast lookup
        Set<String> bValues = new HashSet<>();
        for (P4 b : B) {
            if (b != null) {
                bValues.add(b.getRelevantString());
            }
        }

        // Add to result only if not present in B
        for (P4 a : A) {
            if (a != null && !bValues.contains(a.getRelevantString())) {
                resultsA.add(a);
            }
        }

        return resultsA;
    }

    public void checkListForValue(List<P4PlusInt> list, int[] nextPlayed) {

        for (int i = 0; i < list.size(); i++) {

            // Pass P4[] to hasValue()
            if (hasValue(list.get(i).getOne(), nextPlayed)) {

                System.out.println("Size of List:" +list.size() +" has value true");
                return; // stop once true is found
            }
        }

        // If no match found
        System.out.println("Size of List:" +list.size() +"  has value false");
    }

    public  List<P4PlusInt> removeMatchingInts(
            List<P4PlusInt> A,
            List<P4PlusInt> B) {

        List<P4PlusInt> result = new ArrayList<>();

        // Store all int values from B
        Set<Integer> bValues = new HashSet<>();

        for (P4PlusInt item : B) {
            bValues.add(item.getTwo());
        }

        // Check A against B
        for (P4PlusInt item : A) {

            // If int is NOT in B, keep it
            if (!bValues.contains(item.getTwo())) {
                result.add(item);
            }
        }

        return result;
    }

    public List<P4PlusInt> getNonMatching(
            List<P4PlusInt> listA,
            List<P4PlusInt> listB) {

        // Store all values from listB for fast lookup
        Set<Integer> valuesInB = new HashSet<>();

        for (P4PlusInt itemB : listB) {
            valuesInB.add(itemB.getTwo());
        }

        // Add only items from A not found in B
        List<P4PlusInt> result = new ArrayList<>();

        for (P4PlusInt itemA : listA) {
            if (!valuesInB.contains(itemA.getTwo())) {
                result.add(itemA);
            }
        }

        return result;
    }

    public String checkListForValue1(List<P4PlusInt> list, int[] nextPlayed) {

        // Get all getTwo() values as an int array
        int[] values = extractTwoValues(list);

        int fullLength = 0;
        for(P4PlusInt value: list){
            fullLength += value.getOne().length;
        }

        for (int i = 0; i < list.size(); i++) {

            // Pass P4[] to hasValue()
            if (hasValue(list.get(i).getOne(), nextPlayed)) {
                String str  =  "Size of List: " + list.size() +
                        " has value true | Values: " + Arrays.toString(values) + " full length: "+fullLength;

                System.out.println(str
                       );
                return str; // stop once true is found
            }
        }

        // If no match found
        String str1  =  "Size of List: " + list.size() +
                " has value false | Values: " + Arrays.toString(values) + " full length: "+fullLength;

        System.out.println(
               str1);
        return str1;
    }

    public int[] checkListForValue1IntArray(List<P4PlusInt> list, int[] nextPlayed) {

        // Get all getTwo() values as an int array
        int[] values = extractTwoValues(list);
        return values;
    }


    /**
     * Extracts all getTwo() values into an int array
     */
    private int[] extractTwoValues(List<P4PlusInt> list) {

        int[] values = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            values[i] = list.get(i).getTwo();
        }

        Arrays.sort(values);
        return values;

    }

    public List<int[]> removeDuplicatesIntArrays(List<int[]> list) {

        List<int[]> result = new ArrayList<>();
        Set<String> seen = new HashSet<>();

        for (int[] arr : list) {
            String key = Arrays.toString(arr);

            if (!seen.contains(key)) {
                seen.add(key);
                result.add(arr);
            }
        }

        return result;
    }



        public List<List<P4PlusInt>> checkListForValue2(List<List<P4PlusInt>> list, int[] nextPlayed) {

            //Holds all sorted int[] arrays
            List<int[]> tempIntArrayList = new ArrayList<>();

            for(int i = 0;  i < list.size(); i++){
                tempIntArrayList.add(extractTwoValues2(list.get(i)));
            }

//            List<P4PlusInt> matchedItems = new ArrayList<>();

            System.out.println("tempIntArrayList.size(): "+tempIntArrayList.size());

//            List<Integer> listOfInts = new ArrayList<>();

            Set<Integer> listOfInts = new HashSet<>();

            for(int i= 0; i < tempIntArrayList.size(); i++){
             for(int j= 0; j < tempIntArrayList.size(); j++){
                 if(i != j){
                     String A = Arrays.toString(tempIntArrayList.get(i));
                     String B = Arrays.toString(tempIntArrayList.get(j));
                     if(A.equals(B)){
                         listOfInts.add(i);
//                         listOfInts.add(j);
                     }
                 }
             }
            }

            List<Integer> indexesToRemove = new ArrayList<>(listOfInts);

            Collections.sort(indexesToRemove, Collections.reverseOrder());

            for (int index : indexesToRemove) {

                System.out.println(index);

                list.remove(index);
            }

//            for(int i =0; i < listOfInts.size(); i++){
//                int value  = listOfInts.
//                System.out.println(value);
//                list.remove(value);
//            }


//            for(int i = 0; i < list.size(); i++){
//                matchedItems.add(list.get(i));
//                for(int j = 0; j< list.get(i).size(); j++){
//                    matchedItems.add(list.get(i).get(j));
//                    if (hasValue(list.get(i).get(j).getOne(), nextPlayed)) {
//                        System.out.println(
//                                "Size of List: " + list.size() +
//                                        " has value true | Values: " + Arrays.toString(tempIntArrayList.get(i)));
//                    }else{
//                        System.out.println(
//                                "Size of List: " + list.size() +
//                                        " has value false | Values: " + Arrays.toString(tempIntArrayList.get(i)));
//                    }
//                }
//            }

//            return removeMatchingArrays(list, tempIntArrayList);
            return list;
        }






    /**
     * Extracts values from ONE P4PlusInt object
     * and returns a sorted int[]
     */

    private int[] extractTwoValues2(List<P4PlusInt> list) {

        int[] values = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            values[i] = list.get(i).getTwo();
        }

        Arrays.sort(values);
        return values;
    }


    /**
     * Removes ALL entries where arrays match 90% or more
     */
    private List<P4PlusInt> removeMatchingArrays(
            List<List<P4PlusInt>> originalList,
            List<int[]> arrayList
    ) {

        // ALL indexes involved in matches
        Set<Integer> removeIndexes = new HashSet<>();

        for (int i = 0; i < arrayList.size(); i++) {

            for (int j = i + 1; j < arrayList.size(); j++) {

                if (is90PercentMatch(arrayList.get(i), arrayList.get(j))) {

                    // REMOVE BOTH MATCHES
                    removeIndexes.add(i);
                    removeIndexes.add(j);
                }
            }
        }

        // Build filtered list
        List<P4PlusInt> filteredList = new ArrayList<>();

        for (int i = 0; i < originalList.size(); i++) {

//            if (!removeIndexes.contains(i)) {
//                filteredList.add(originalList.get(i));
//            }
            if(removeIndexes.contains(i)){
                originalList.remove(i);
            }
        }

        for(int i = 0; i < originalList.size(); i++){
            for(int j = 0; j < originalList.get(i).size(); j++){
                filteredList.add(originalList.get(i).get(j));
            }
        }

        return filteredList;
    }


    /**
     * Returns true if arrays match 90% or more
     */
    private boolean is90PercentMatch(int[] arr1, int[] arr2) {

        if (arr1.length == 0 || arr2.length == 0) {
            return false;
        }

        int matches = 0;

        // Fast lookup
        Set<Integer> set = new HashSet<>();

        for (int value : arr2) {
            set.add(value);
        }

        for (int value : arr1) {

            if (set.contains(value)) {
                matches++;
            }
        }

        int maxLength = Math.max(arr1.length, arr2.length);

        double matchPercent = (matches * 100.0) / maxLength;

        return matchPercent >= 90.0;
    }

    public static List<List<P4PlusInt>> matchAndRemoveListByInt(
            List<List<P4PlusInt>> A,
            List<List<P4PlusInt>> B) {

        List<List<P4PlusInt>> result = new ArrayList<>();

        for (List<P4PlusInt> listA : A) {

            Iterator<P4PlusInt> iteratorA = listA.iterator();

            while (iteratorA.hasNext()) {

                P4PlusInt itemA = iteratorA.next();
                boolean matched = false;

                for (List<P4PlusInt> listB : B) {

                    Iterator<P4PlusInt> iteratorB = listB.iterator();

                    while (iteratorB.hasNext()) {

                        P4PlusInt itemB = iteratorB.next();

                        if (itemA.getTwo() == itemB.getTwo()) {

                            // Remove from A and B
                            iteratorA.remove();
                            iteratorB.remove();

                            // Store matched pair
                            List<P4PlusInt> matchedList = new ArrayList<>();
                            matchedList.add(itemA);
                            matchedList.add(itemB);

                            result.add(matchedList);

                            matched = true;
                            break;
                        }
                    }

                    if (matched) {
                        break;
                    }
                }
            }
        }

        return result;
    }


    public static List<List<P4PlusInt>> removeMatchesFromListByInt(
            List<List<P4PlusInt>> A,
            List<List<P4PlusInt>> B) {

        // Collect all values from B
        Set<Integer> valuesInB = new HashSet<>();

        for (List<P4PlusInt> listB : B) {
            for (P4PlusInt itemB : listB) {
                valuesInB.add(itemB.getTwo());
            }
        }

        // Remove matches from B also
        for (List<P4PlusInt> listB : B) {
            Iterator<P4PlusInt> iteratorB = listB.iterator();

            while (iteratorB.hasNext()) {
                P4PlusInt itemB = iteratorB.next();

                // check if exists in A
                boolean existsInA = false;

                for (List<P4PlusInt> listA : A) {
                    for (P4PlusInt itemA : listA) {
                        if (itemA.getTwo() == itemB.getTwo()) {
                            existsInA = true;
                            break;
                        }
                    }

                    if (existsInA) {
                        break;
                    }
                }

                if (existsInA) {
                    iteratorB.remove();
                }
            }
        }

        // Build return list from remaining items in A
        List<List<P4PlusInt>> returnableList = new ArrayList<>();

        for (List<P4PlusInt> listA : A) {

            List<P4PlusInt> remaining = new ArrayList<>();

            Iterator<P4PlusInt> iteratorA = listA.iterator();

            while (iteratorA.hasNext()) {

                P4PlusInt itemA = iteratorA.next();

                if (valuesInB.contains(itemA.getTwo())) {
                    // remove matching value from A
                    iteratorA.remove();
                } else {
                    remaining.add(itemA);
                }
            }

            returnableList.add(remaining);
        }

        return returnableList;
    }

    public static List<List<P4PlusInt>> removeMatchesFromListByInt1(
            List<List<P4PlusInt>> A,
            List<List<P4PlusInt>> B) {

        int counter1 = 0;
        for(List<P4PlusInt> A1: A){
            int counter2 = 0;
            for(List<P4PlusInt> B1: B){
                if(A1.get(counter1).getTwo() == B1.get(counter2).getTwo()){
                    A1.remove(counter1);
                    B1.remove(counter2);
                    counter1=0;
                    counter2=0;
                    break;
                }
                counter2++;
            }
            counter1++;
        }

        return A;
    }

    public List<String> removeDuplicateStringFromList(List<String> A) {
        // LinkedHashSet removes duplicates while keeping insertion order
        Set<String> unique = new LinkedHashSet<>(A);

        return new ArrayList<>(unique);
    }

    public List<int[]> randomHalfOfIntArrayList(List<int[]> input) {
        if (input == null || input.isEmpty()) {
            return Collections.emptyList();
        }

        // Make a copy so we don't modify the original list
        List<int[]> shuffled = new ArrayList<>(input);

        // Randomize the order
        Collections.shuffle(shuffled);

        int halfSize = shuffled.size() / 2;

        // If odd-sized list, randomly choose whether the extra item
        // belongs to the returned half
        if (shuffled.size() % 2 == 1 &&
                ThreadLocalRandom.current().nextBoolean()) {
            halfSize++;
        }

        return new ArrayList<>(shuffled.subList(0, halfSize));
    }

    public List<P4[]> getPossiblePlayableWinningCombos(
            List<P4PlusInt> preChunkRunArrayNotInChunkCombinationsOfP4ArrayPossibleNotInArrayP4ArrayList1,
            List<int[]> listOfStrArrays1,
            P4[] checkingMostLikelyDOhHave1a,
            int[] nextPlayed) {


        List<P4[]> possiblePlayableWinningCombos = new ArrayList<>();

        for (int[] currentIntArray : listOfStrArrays1) {

            // Process each value in the current int[]
            for (int index = 0; index < currentIntArray.length; index++) {

                // Get the value at the current index
                int intValueForIndex = currentIntArray[index];

                P4[] oneAttribute = findOneAttributeByTwo(
                        intValueForIndex,
                        preChunkRunArrayNotInChunkCombinationsOfP4ArrayPossibleNotInArrayP4ArrayList1);



                if (oneAttribute == null) {
                    continue;
                }
//
//                // Split the array into chunks of 10
                List<P4PlusInt> splitBy10 =
                        splitCombineAndDetectByChunkSize(
                                oneAttribute,
                                10,
                                nextPlayed);

                List<P4[]> splitAndMergedArrays =
                        makeArraysOf10by10(splitBy10, nextPlayed, oneAttribute, preChunkRunArrayNotInChunkCombinationsOfP4ArrayPossibleNotInArrayP4ArrayList1, intValueForIndex);

                System.out.println("splitAndMergedArrays.size(): "+splitAndMergedArrays.size()+" splitAndMergedArrays.getFirst().length: "+splitAndMergedArrays.getFirst().length+"");
//                System.out.println("checkingMostLikelyDOhHave1a.length: "+ checkingMostLikelyDOhHave1a.length+ " a.length: "+ splitAndMergedArrays.getFirst().length);
//
//                int count =0;
//                for(P4[] a : splitAndMergedArrays){
//                    P4[] tempArray = notInPParray1(checkingMostLikelyDOhHave1a, a);
//                    count++;
//                    System.out.println("#"+count+" tempArray.length: "+tempArray.length+ " has value: "+hasValue(tempArray,nextPlayed) +" checkingMostLikelyDOhHave1a.length: "+ checkingMostLikelyDOhHave1a.length+ " a.length: "+ a.length);
//                }
//
                List<P4[]> arraysToBeUsedList = new ArrayList<>();

                for (int value : currentIntArray) {

                    for (P4PlusInt obj :
                            preChunkRunArrayNotInChunkCombinationsOfP4ArrayPossibleNotInArrayP4ArrayList1) {

                        if (obj.getTwo() == value) {

                            arraysToBeUsedList.add(obj.getOne());
                            break;
                        }
                    }
                }
//
//
                P4[] mergedUseableArray = getUseAbleArrays(arraysToBeUsedList);
                System.out.println("mergedUseableArray.length: "+mergedUseableArray.length+" has value: "+hasValue(mergedUseableArray, nextPlayed));
                List<P4PlusInt> mergedSplitBy10 =
                        splitCombineAndDetectByChunkSize(
                                mergedUseableArray,
                                10,
                                nextPlayed);

                System.out.println("mergedSplitBy10.size(): "+mergedSplitBy10.size()+" mergedSplitBy10.getFirst().getOne().length: "+mergedSplitBy10.getFirst().getOne().length+" has value: "+hasValue(mergedSplitBy10.getFirst().getOne(),nextPlayed));

                System.out.println("List of mergedSplitBy10 has value: "+hasValueP4PlusIntList(mergedSplitBy10, nextPlayed));

                removeHalfP4PlusIntList(mergedSplitBy10);

                System.out.println("mergedSplitBy10.size(): "+mergedSplitBy10.size()+" List of mergedSplitBy10 has value: "+hasValueP4PlusIntList(mergedSplitBy10, nextPlayed));
//----------------------------------------------------------
// Process the merged split exactly the same way as before.
//
// Example:
// merged array length = 300
// splitBy10 = 30 arrays of length 10
//
// For each array:
//   - split again into 10 arrays of length 1
//   - create the 10 choose 9 combinations
//   - merge with all remaining arrays
//
// Result:
// secondMergedArrays contains arrays of length 297
//----------------------------------------------------------
//                List<P4[]> secondMergedArrays =
//                        makeArraysOf10by10(
//                                mergedSplitBy10,
//                                mergedUseableArray,
//                                nextPlayed);
////
//
//                List<P4> playableResults =
//                        getP4CombOfPlayables(
//                                splitAndMergedArrays,
//                                secondMergedArrays,
//                                checkingMostLikelyDOhHave1a);
//
//                possiblePlayableWinningCombos.addAll(playableResults);

                // TODO:
                // Use intValueForIndex to find the matching object in
                // preChunkRunArrayNotInChunkCombinationsOfP4ArrayPossibleNotInArrayP4ArrayList1
//
                List<P4[]> notInSplitAndMergedArrays = new ArrayList<>();
                for(P4[] a: splitAndMergedArrays){
                    P4[] tempArray = notInPParray1(checkingMostLikelyDOhHave1a, a);
//                    System.out.println("tempArray.length:"+tempArray.length);
                   // notInSplitAndMergedArrays.add(tempArray);
                    for(P4PlusInt b: mergedSplitBy10){
                        P4[] tempArray1 = notInPParray1(mergedUseableArray, b.getOne());
//                        System.out.println("tempArray.length:"+tempArray.length);
                        for(P4 c : tempArray1){
                            if(c.getRelevantString().equals(tempArray[0].getRelevantString()) ){
                                notInSplitAndMergedArrays.add(tempArray);
                            }
                        }
                    }
                }

                List<P4> possibleP4PlayableList = new ArrayList<>();
                for(P4[] a: notInSplitAndMergedArrays){
                    for(P4 b : a){
                        possibleP4PlayableList.add(b);
                    }
                }

                System.out.println("notInSplitAndMergedArrays.size(): "+notInSplitAndMergedArrays.size()+" has value: "+hasValueList(possibleP4PlayableList, nextPlayed)+" possibleP4PlayableList.size() " +possibleP4PlayableList.size());

//                if(notInSplitAndMergedArrays.size()>0){
//                    for(P4[] a : notInSplitAndMergedArrays){
//                        System.out.println("notInSplitAndMergedArrays.lenght: "+a.length+" has value: "+hasValue(a, nextPlayed)+" a.length: "+a.length);
//                       P4[] aRemovedDuplicates = removeDuplicates(a);
//                        System.out.println("aRemovedDuplicates.lenght: "+aRemovedDuplicates.length+" has value: "+hasValue(aRemovedDuplicates, nextPlayed));
//                    }
//                }

                if(possibleP4PlayableList.size()>0){
                    P4[] array = possibleP4PlayableList.toArray(P4[]::new);
                    System.out.println("Before Duplicate remove Array.length: "+array.length);
                    P4[] aRemovedDuplicates = removeDuplicates(array);
                    System.out.println("After Duplicate remove aRemovedDuplicates.length: "+aRemovedDuplicates.length);
                    possiblePlayableWinningCombos.add(array);
                }

            }

        }

        removeDuplicatesAcrossArrays(possiblePlayableWinningCombos);

        for(P4[] a: possiblePlayableWinningCombos){
            System.out.println("possiblePlayableWinningCombos a.lenght: "+ a.length+" has value: "+hasValue(a,nextPlayed));
//            for(int b[]: listOfStrArrays1){
                for(int b = 0; b < preChunkRunArrayNotInChunkCombinationsOfP4ArrayPossibleNotInArrayP4ArrayList1.size(); b++ ){
//                    P4[] notInA = notInPParray1(preChunkRunArrayNotInChunkCombinationsOfP4ArrayPossibleNotInArrayP4ArrayList1.get(bValue).getOne(), a);
//                    System.out.println("\t notInA.length: "+notInA.length+" using preChunkRunArrayNotInChunkCombinationsOfP4ArrayPossibleNotInArrayP4ArrayList1.get("+bValue+").getOne().lenght: "+preChunkRunArrayNotInChunkCombinationsOfP4ArrayPossibleNotInArrayP4ArrayList1.get(bValue).getOne().length+ " hasValue: "+hasValue(notInA, nextPlayed));
                    P4[] notInA = notInPParray1(preChunkRunArrayNotInChunkCombinationsOfP4ArrayPossibleNotInArrayP4ArrayList1.get(b).getOne(), a);
                    System.out.println("\t notInA.length: "+notInA.length+" using preChunkRunArrayNotInChunkCombinationsOfP4ArrayPossibleNotInArrayP4ArrayList1.get("+b+").getOne().lenght: "+preChunkRunArrayNotInChunkCombinationsOfP4ArrayPossibleNotInArrayP4ArrayList1.get(b).getOne().length+ " hasValue: "+hasValue(notInA, nextPlayed));
                }
                System.out.println();
//            }
        }



        return possiblePlayableWinningCombos;
    }

    public static void removeDuplicatesAcrossArrays(List<P4[]> arrays) {
        Map<String, Integer> counts = new HashMap<>();

        // Count occurrences of each relevant string across all arrays
        for (P4[] array : arrays) {
            for (P4 p : array) {
                counts.merge(p.getRelevantString(), 1, Integer::sum);
            }
        }

        // Remove every occurrence of duplicates
        ListIterator<P4[]> iterator = arrays.listIterator();

        while (iterator.hasNext()) {
            P4[] array = iterator.next();

            List<P4> unique = new ArrayList<>();

            for (P4 p : array) {
                if (counts.get(p.getRelevantString()) == 1) {
                    unique.add(p);
                }
            }

            iterator.set(unique.toArray(new P4[0]));
        }
    }


    public static P4[] removeDuplicates(P4[] array) {
        if (array == null) {
            return null;
        }

        Set<String> seen = new HashSet<>();
        List<P4> unique = new ArrayList<>();

        for (P4 p : array) {
            if (seen.add(p.getRelevantString())) {
                unique.add(p);
            }
        }

        return unique.toArray(new P4[0]);
    }

    public static void removeHalfP4PlusIntList(List<P4PlusInt> list) {
        if (list == null || list.isEmpty()) {
            return;
        }

        int half = list.size() / 2;

        // Removes everything from index 'half' to the end.
        Collections.shuffle(list);
        list.subList(half, list.size()).clear();
    }

    private boolean hasValueP4PlusIntList(List<P4PlusInt> mergedSplitBy10, int[] nextPlayed) {

        boolean hasValueInList = false;
        for(P4PlusInt a : mergedSplitBy10){
            boolean hasValueInListTemp = hasValue(a.getOne(), nextPlayed);
            if(hasValueInListTemp == true){
                hasValueInList = hasValueInListTemp;
            }
        }

        return hasValueInList;
    }

    private P4[] findOneAttributeByTwo(
            int intValueForIndex,
            List<P4PlusInt> objectList) {

        for (P4PlusInt obj : objectList) {

            if (obj.getTwo() == intValueForIndex) {
                System.out.println("\nObjects:[Object.one.length: "+obj.getOne().length+", Object.two: "+obj.getTwo()+", intValueForIndex: "+intValueForIndex+"]");
                return obj.getOne();
            }
        }

        return null;
    }

    private List<P4[]> makeArraysOf10by10(
            List<P4PlusInt> splitBy10, int[] nextPlayed, P4[] oneAttribute, List<P4PlusInt> preChunkRunArrayNotInChunkCombinationsOfP4ArrayPossibleNotInArrayP4ArrayList1, int intValueForIndex) {

        List<P4[]> splitAndMergedArrays = new ArrayList<>();

        // Process every array returned in splitBy10
        for (int currentIndex = 0; currentIndex < splitBy10.size(); currentIndex++) {

            //-------------------------------------------------------
            // Current array of length 10
            //-------------------------------------------------------
            P4[] splitBy10OneAttribute =
                    splitBy10.get(currentIndex).getOne();

//            System.out.println("#"+currentIndex+": splitBy10OneAttribute.length: "+splitBy10OneAttribute.length);

//            P4[] secondSplitBy10OneAttribute = notInPParray1(splitBy10.get(currentIndex).getOne(), splitBy10OneAttribute);
            P4[] secondSplitBy10OneAttribute = notInPParray1(oneAttribute, splitBy10OneAttribute);


//            System.out.println("#"+currentIndex+": secondSplitBy10OneAttribute.length: "+secondSplitBy10OneAttribute.length);
            //-------------------------------------------------------
            // Split the current array into arrays of length 1
            //-------------------------------------------------------
//            List<P4PlusInt> secondSplitBy10 =
//                    splitCombineAndDetectByChunkSize(
//                            secondSplitBy10OneAttribute,
//                            10,
//                            nextPlayed);
            List<P4PlusInt> secondSplitBy10 =
                    generate9Combinations(
                            secondSplitBy10OneAttribute, splitBy10OneAttribute);
//problem
//            System.out.println("\t secondSplitBy10.size(): "+secondSplitBy10.size()+" secondSplitBy10.getFirst().getOne().length: "+secondSplitBy10.getFirst().getOne().length);


            //-------------------------------------------------------
            // Generate all 10 choose 9 combinations
            //-------------------------------------------------------
            List<P4[]> returnableListOfSecondSplitBy10 =
                    generate9From10Combinations(secondSplitBy10);

//            System.out.println("\t returnableListOfSecondSplitBy10.size(): "+returnableListOfSecondSplitBy10.size()+" returnableListOfSecondSplitBy10.getFirst().length: "+returnableListOfSecondSplitBy10.getFirst().length);

            List<P4[]> mergeSplitBy10Arrays = new ArrayList<>();
            for(int index = 0; index < returnableListOfSecondSplitBy10.size(); index++){
                P4[] tempSplitMergeArray = mergeArrays1(splitBy10.get(currentIndex).getOne(), returnableListOfSecondSplitBy10.get(index));
                mergeSplitBy10Arrays.add(tempSplitMergeArray);
            }

            //-------------------------------------------------------
            // Merge every other array from splitBy10 that was NOT
            // used to produce secondSplitBy10
            //-------------------------------------------------------
            P4[] tempPossibleNotHave = new P4[0];

//            for (int otherIndex = 0; otherIndex < splitBy10.size(); otherIndex++) {
            for (int otherIndex = 0; otherIndex < preChunkRunArrayNotInChunkCombinationsOfP4ArrayPossibleNotInArrayP4ArrayList1.size(); otherIndex++) {

//                if (otherIndex == currentIndex) {
//                    continue;
//                }

                if (preChunkRunArrayNotInChunkCombinationsOfP4ArrayPossibleNotInArrayP4ArrayList1.get(otherIndex).getTwo() == intValueForIndex) {
                    continue;
                }

//                tempPossibleNotHave =
//                        mergeArrays1(
//                                tempPossibleNotHave,
//                                splitBy10.get(otherIndex).getOne());
                tempPossibleNotHave =
                        mergeArrays1(
                                tempPossibleNotHave, preChunkRunArrayNotInChunkCombinationsOfP4ArrayPossibleNotInArrayP4ArrayList1.get(otherIndex).getOne());
//                System.out.println("\t\ttempPossibleNotHave.length: "+tempPossibleNotHave.length +" has value: " + hasValue(tempPossibleNotHave, nextPlayed));
            }


            //-------------------------------------------------------
            // Merge tempPossibleNotHave with each 9-element array
            //-------------------------------------------------------
//            List<P4[]> returnableListOfSecondSplitBy10Merged =
//                    new ArrayList<>();

//            for (P4[] currentCombination : mergeSplitBy10Arrays) {
            for (P4PlusInt currentCombination : secondSplitBy10) {

                P4[] merged =
                        mergeArrays(
                                tempPossibleNotHave,
                                currentCombination.getOne());


//                System.out.println("\t\tcurrentCombination: "+currentCombination.getOne().length);
//                System.out.println("\t\ttempPossibleNotHave: "+tempPossibleNotHave.length);
//                System.out.println("\t\t# "+currentIndex+": merged .length: "+merged .length +" has value: " + hasValue(merged , nextPlayed));
//                returnableListOfSecondSplitBy10Merged.add(merged);
                splitAndMergedArrays.add(merged);
            }
        }

        return splitAndMergedArrays;
    }

    private List<P4[]> generate9From10Combinations(
            List<P4PlusInt> secondSplitBy10) {

        List<P4[]> combinations = new ArrayList<>();

        int size = secondSplitBy10.size();

        // Remove one element at a time
        for (int skipIndex = 0; skipIndex < size; skipIndex++) {

            List<P4> temp = new ArrayList<>();

            for (int currentIndex = 0; currentIndex < size; currentIndex++) {

                if (currentIndex == skipIndex) {
                    continue;
                }

                P4[] currentArray = secondSplitBy10.get(currentIndex).getOne();

                if (currentArray != null) {
                    Collections.addAll(temp, currentArray);
                }
            }

            combinations.add(temp.toArray(new P4[0]));
        }

        return combinations;
    }

    private P4[] mergeArrays1(
            P4[] first,
            P4[] second) {

        if (first == null || first.length == 0) {
            return second == null ? new P4[0] : Arrays.copyOf(second, second.length);
        }

        if (second == null || second.length == 0) {
            return Arrays.copyOf(first, first.length);
        }

        P4[] merged = new P4[first.length + second.length];

        System.arraycopy(first, 0, merged, 0, first.length);

        System.arraycopy(second, 0, merged, first.length, second.length);

        return merged;
    }

    private P4[] getUseAbleArrays(List<P4[]> arraysToBeUsedList) {

        if (arraysToBeUsedList == null || arraysToBeUsedList.isEmpty()) {
            return new P4[0];
        }

        // Calculate total size
        int totalLength = 0;

        for (P4[] array : arraysToBeUsedList) {
            if (array != null) {
                totalLength += array.length;
            }
        }

        // Create merged array
        P4[] mergedArray = new P4[totalLength];

        int position = 0;

        for (P4[] array : arraysToBeUsedList) {

            if (array == null) {
                continue;
            }

            System.arraycopy(
                    array,
                    0,
                    mergedArray,
                    position,
                    array.length);

            position += array.length;
        }

        return mergedArray;
    }

    private List<P4> getP4CombOfPlayables(
            List<P4[]> firstMergedList,
            List<P4[]> secondMergedList,
            P4[] checkingMostLikelyDOhHave1a) {

        List<P4> p5ValuesToReturn = new ArrayList<>();

        //----------------------------------------------------------
        // Store all missing values from second merged arrays
        //----------------------------------------------------------
        List<P4[]> toBeCheckedBynotInFirstMerged = new ArrayList<>();


        //----------------------------------------------------------
        // Process every array in second merged list
        //----------------------------------------------------------
        for (P4[] eachArrayInSecondMerged : secondMergedList) {


            P4[] notInSecondMerged =
                    notInPParray1(
                            checkingMostLikelyDOhHave1a,
                            eachArrayInSecondMerged);


            //------------------------------------------------------
            // Store each returned missing array
            //------------------------------------------------------
            toBeCheckedBynotInFirstMerged.add(notInSecondMerged);
        }


        //----------------------------------------------------------
        // Randomly remove half of the second merged results
        //----------------------------------------------------------
        randomlyRemoveHalf(toBeCheckedBynotInFirstMerged);


        //----------------------------------------------------------
        // Process every array in first merged list
        //----------------------------------------------------------
        for (P4[] eachArrayInFirstMerged : firstMergedList) {


            P4[] notInFirstMerged =
                    notInPParray1(
                            checkingMostLikelyDOhHave1a,
                            eachArrayInFirstMerged);


            //------------------------------------------------------
            // Compare notInFirstMerged against remaining
            // notInSecondMerged arrays
            //------------------------------------------------------
            for (P4[] possibleMatches :
                    toBeCheckedBynotInFirstMerged) {


                for (P4 valueFromFirst :
                        notInFirstMerged) {


                    for (P4 valueFromSecond :
                            possibleMatches) {


                        //--------------------------------------------------
                        // Matching P4 value found
                        //--------------------------------------------------
                        if (valueFromFirst.equals(valueFromSecond)) {

                            p5ValuesToReturn.add(valueFromFirst);

                        }

                    }
                }
            }
        }


        return p5ValuesToReturn;
    }

    private void randomlyRemoveHalf(
            List<P4[]> list) {


        if (list == null || list.isEmpty()) {
            return;
        }


        Collections.shuffle(list);


        int removeCount = list.size() / 2;


        for (int i = 0; i < removeCount; i++) {

            list.remove(list.size() - 1);

        }
    }

    public static List<P4PlusInt> generate9Combinations(P4[] secondSplitBy10OneAttribute, P4[] second) {
//        if (secondSplitBy10OneAttribute == null || secondSplitBy10OneAttribute.length != 10) {
//            throw new IllegalArgumentException("Input array must have length 10.");
//        }

        List<P4PlusInt> result = new ArrayList<>();
        List<P4PlusInt> result1 = new ArrayList<>();



        for (int omitted = 0; omitted < 10; omitted++) {
            P4[] combination = new P4[9];
            int index = 0;

            for (int i = 0; i < 10; i++) {
                if (i != omitted) {
                    combination[index++] = secondSplitBy10OneAttribute[i];
                }
            }

            result.add(new P4PlusInt(combination, omitted));
        }

        for(int i = 0; i < result.size(); i++){
            P4[] combination = mergeArrays(result.get(i).getOne(), second);
            result1.add(new P4PlusInt(combination, i));
        }

        return result1;
    }

    public void createXlolFiles(
            List<List<P4[]>> possiblePlayableWinningCombosListOfArraysList) {

        // Root folder
        Path rootFolder = Paths.get("Xlol");

        try {

            // =========================================================
            // Create Xlol folder
            // =========================================================

            Files.createDirectories(rootFolder);

            // =========================================================
            // Loop through each List<P4[]>
            //
            // First List  -> folder 1
            // Second List -> folder 2
            // Third List  -> folder 3
            // ...
            // =========================================================

            for (int listIndex = 0;
                 listIndex < possiblePlayableWinningCombosListOfArraysList.size();
                 listIndex++) {

                List<P4[]> possibleWinningCombos =
                        possiblePlayableWinningCombosListOfArraysList.get(listIndex);

                // Folder number starts at 1
                int folderNumber = listIndex + 1;

                Path folder = rootFolder.resolve(
                        String.valueOf(folderNumber)
                );

                // Create folder
                Files.createDirectories(folder);

                // =====================================================
                // Each P4[] becomes a separate text file
                //
                // First array  -> 1.txt
                // Second array -> 2.txt
                // Third array  -> 3.txt
                // ...
                // =====================================================

                for (int arrayIndex = 0;
                     arrayIndex < possibleWinningCombos.size();
                     arrayIndex++) {

                    P4[] winningCombo =
                            possibleWinningCombos.get(arrayIndex);

                    // File number starts at 1
                    int fileNumber = arrayIndex + 1;

                    Path file = folder.resolve(
                            fileNumber + ".txt"
                    );

                    // =================================================
                    // Write the P4 values to the file
                    // =================================================

                    try (BufferedWriter writer =
                                 Files.newBufferedWriter(file)) {

                        if (winningCombo == null) {
                            continue;
                        }

                        for (P4 p4 : winningCombo) {

                            if (p4 == null) {
                                continue;
                            }

                            String value = p4.getRelevantString();

                            if (value == null) {
                                continue;
                            }

                            // Write value
                            writer.write(value);

                            // Move to next line
                            writer.newLine();
                        }
                    }
                }
            }

        } catch (IOException e) {

            throw new RuntimeException(
                    "Failed to create Xlol files",
                    e
            );
        }
    }

    public List<P4> getPossibleWinningHave(List<P4[]> winningCommbos, List<P4PlusInt> chunksOf100, int[] nextPlayed){

        System.out.println("Entering getPossibleWinningHave");
        System.out.println("\tWinning Combos of Arrays List Size: "+winningCommbos.size());
        System.out.println("\tchunksOf100 arrays List Size: "+chunksOf100.size());

        P4[] winningCombosMergedArray = mergeMultiple(winningCommbos);
        System.out.println("\twinningCombosMergedArray.length: "+winningCombosMergedArray.length+" has value: "+hasValue(winningCombosMergedArray, nextPlayed));
        List<P4[]> chunksOf100P4ArrayList = new ArrayList<>();
        for(P4PlusInt a : chunksOf100){
            chunksOf100P4ArrayList.add(a.getOne());
        }
        P4[] chunksOf100MergedArray = mergeMultiple(chunksOf100P4ArrayList);
        System.out.println("\tchunksOf100MergedArray.length: "+chunksOf100MergedArray.length+" has value: "+hasValue(chunksOf100MergedArray, nextPlayed));

        P4[] doNotHaveArray = notInPParray1(chunksOf100MergedArray, winningCombosMergedArray);
        System.out.println("\tdoNotHaveArray.length: "+doNotHaveArray.length+ " has value: "+hasValue(doNotHaveArray, nextPlayed));

        List<P4[]> divBy5WinningCombosList = new ArrayList<>();
        divBy5WinningCombosList = splitIntoFive(winningCombosMergedArray);

        System.out.println("\tdivBy5WinningCombosList.size(): "+divBy5WinningCombosList.size());

        List<P4[]> divBy5WinningCombosMergedArrayList = new ArrayList<>();
        for(int i = 0; i < divBy5WinningCombosList.size(); i++ ){
//            List<P4[]> tempList = new ArrayList<>();
//            tempList = divBy5WinningCombosList;

            List<P4[]> tempList = new ArrayList<>(divBy5WinningCombosList);
            tempList.remove(i);
            divBy5WinningCombosMergedArrayList.add(mergeMultiple(tempList));
        }
        List<List<P4[]>> Pool1 = new ArrayList<>();
        //List<List<P4[]>> Pool2 = new ArrayList<>();



        for(int i =0; i < winningCommbos.size(); i++){
            System.out.println();
            List<P4[]> tempList = new ArrayList<>(winningCommbos);
            tempList.remove(i);

            P4[] tempListMergedArray = mergeMultiple(tempList);

            System.out.println("\tdivBy5WinningCombosMergedArray.size(): "+divBy5WinningCombosMergedArrayList.size());
            List<P4[]> tempPool1 = new ArrayList<>();
            //List<P4[]> tempPool2 = new ArrayList<>();

            for(P4[] divBy5WinningCombosMergedArray : divBy5WinningCombosMergedArrayList ){
                System.out.println();
                System.out.println("\t\tdivBy5WinningCombosMergedArray.length: "+divBy5WinningCombosMergedArray.length+" has value: "+hasValue(divBy5WinningCombosMergedArray, nextPlayed));
                P4[] doNotHaveArrayMergedDivBy5WinningCombosMergedArray = mergeP4Arrays(doNotHaveArray, divBy5WinningCombosMergedArray);
                System.out.println("\t\t\tdoNotHaveArrayMergedDivBy5WinningCombosMergedArray.length: "+doNotHaveArrayMergedDivBy5WinningCombosMergedArray.length+" has value: "+hasValue(doNotHaveArrayMergedDivBy5WinningCombosMergedArray, nextPlayed));
                P4[] tempListMergedNotInDoNotHaveArrayMergedDivBy5WinningCombosMergedArray =  notInPParray1(tempListMergedArray, doNotHaveArrayMergedDivBy5WinningCombosMergedArray);
                System.out.println("tempListMergedNotInDoNotHaveArrayMergedDivBy5WinningCombosMergedArray.length: "+tempListMergedNotInDoNotHaveArrayMergedDivBy5WinningCombosMergedArray.length+" has value: "+hasValue(tempListMergedNotInDoNotHaveArrayMergedDivBy5WinningCombosMergedArray, nextPlayed));
                tempPool1.add(tempListMergedNotInDoNotHaveArrayMergedDivBy5WinningCombosMergedArray);

            }
            Pool1.add(tempPool1);
            System.out.println();
        }

        int mostPopularLength = getMostPopularLength(Pool1);


        List<List<P4[]>> Pool2 =  getNonPopularArrays(Pool1,mostPopularLength);

        for(List<P4[]> P1 : Pool1){
            System.out.println("P1.Size(): "+P1.size());
        }
        for(List<P4[]> P2 : Pool2){
            System.out.println("P2.Size(): "+P2.size());
        }

        P4[] pool2Merged = mergeMultipleList(Pool2);

        System.out.println("pool2Merged: "+pool2Merged.length+"  has value: "+hasValue(pool2Merged, nextPlayed));

        P4[] pool2MergedDuplicateRemoved = removeDuplicates(pool2Merged );

        System.out.println("pool2MergedDuplicateRemoved: "+pool2MergedDuplicateRemoved.length+"  has value: "+hasValue(pool2MergedDuplicateRemoved, nextPlayed));


//        System.out.println("Entering Processing Calculations");
//        for(P4[] winningCombo: winningCommbos){
//            for(P4PlusInt chunksOf100Array : chunksOf100){
//
//               P4[] winningComboNotInChunks100 = notInPParray1(chunksOf100Array.getOne(), winningCombo);
//               if((chunksOf100Array.getOne().length - winningCombo.length == winningComboNotInChunks100.length ){
//
//                }
//            }
//        }

        return null;
    }

    public static int getMostPopularLength(List<List<P4[]>> pool1) {
        Map<Integer, Integer> frequency = new HashMap<>();

        for (List<P4[]> list : pool1) {
            for (P4[] array : list) {
                int length = array.length;
                frequency.put(length, frequency.getOrDefault(length, 0) + 1);
            }
        }

        return frequency.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(0); // return 0 if Pool1 is empty
    }

    public static List<List<P4[]>> getNonPopularArrays(
            List<List<P4[]>> pool1,
            int mostPopularLength) {


        List<List<P4[]>> pool2 = new ArrayList<>();


        for (List<P4[]> list : pool1) {


            List<P4[]> filteredList = new ArrayList<>();


            for (P4[] array : list) {
                if (array.length != mostPopularLength) {
                    filteredList.add(array);
                }
            }


            pool2.add(filteredList);
        }


        return pool2;
    }

}//end class.


