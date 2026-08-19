import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Step02 {


    public List<TwoArrayObjects> getNewTaoList(TwoArrayObjects tempTao) {

        //call a method which takes the second entity of the abject divides into its combinations
        System.out.println("\t\tSize of tempTao1:"+tempTao.getOne().length+" Size of tempTao2:"+tempTao.getTwo().length);

        List<TwoArrayObjects> dividedList = dividedObject1(tempTao);

        return dividedList;
    }



    private List<TwoArrayObjects> dividedObject(TwoArrayObjects tempTao) {

        List<TwoArrayObjects> returnAbleCombine = new ArrayList<>();
        P4[] arrayTwo = tempTao.getTwo();

        int length = arrayTwo.length;
        if (length % 5 != 0) {
            length -= length % 5; // Adjust to the nearest lower multiple of 5
        }

        // Create a temporary array of the adjusted length
        P4[] tempArray = new P4[length];
        System.arraycopy(arrayTwo, 0, tempArray, 0, length);

        // Calculate the size of each sub-array
        int subArraySize = length / 5;
        List<P4[]> listOfArrays = new ArrayList<>();

        // Divide the tempArray into 5 equal parts
        for (int i = 0; i < 5; i++) {
            P4[] subArray = new P4[subArraySize];
            System.arraycopy(tempArray, i * subArraySize, subArray, 0, subArraySize);
            System.out.println("\t\t#:"+i+" copied array into subarray of size:"+subArray.length);

            listOfArrays.add(subArray);
        }

        System.out.println("\tFished copying subarray and adding yo listOffArrays of size:"+listOfArrays.size());


        //now combine each


        List<TwoArrayObjects> combined = combineListOfArrays(listOfArrays);

        System.out.println("\tFinished Combing the arrays into list combined: "+combined.size());

        for(int i = 0; i < combined.size(); i++){
            P4[] toBeCombined1 = tempTao.getOne();
            P4[] toBeCombined2 = combined.get(i).getOne();

            System.out.println("\t\t#:"+i+" toBeCombined1: "+toBeCombined1.length+" toBeCombined2: "+toBeCombined2.length);

            P4[] combinedArray1and2 = new P4[ toBeCombined1.length+ toBeCombined2.length];
            System.arraycopy(toBeCombined1, 0, combinedArray1and2, 0, toBeCombined1.length);
            // Copy the second array
            System.arraycopy(toBeCombined2, 0, combinedArray1and2, toBeCombined1.length, toBeCombined2.length);
            System.out.println("\t\t#:"+i+" combinedArray1and2:  "+combinedArray1and2.length+" combined.get(i).getTwo(): "+combined.get(i).getTwo().length);

            TwoArrayObjects tempTao1 = new TwoArrayObjects(combinedArray1and2, combined.get(i).getTwo());
            returnAbleCombine.add(tempTao1);
        }

        System.out.println("\tFished Overall combining");

        return returnAbleCombine;
    }

    private List<TwoArrayObjects> dividedObject1(TwoArrayObjects tempTao) {

        List<TwoArrayObjects> returnAbleCombine = new ArrayList<>();
        P4[] arrayTwo = tempTao.getTwo();

        int length = arrayTwo.length;

// Calculate the number of elements in the last sub-array
        int remainder = length % 5;
        int adjustedLength = (remainder == 0) ? length : length + (5 - remainder);

// Create a temporary array of the adjusted length
        P4[] tempArray = new P4[adjustedLength];
        System.arraycopy(arrayTwo, 0, tempArray, 0, length);

// Calculate the size of each sub-array
        int subArraySize = adjustedLength / 5;
        List<P4[]> listOfArrays = new ArrayList<>();

// Divide the tempArray into 5 equal parts
        for (int i = 0; i < 5; i++) {
            P4[] subArray;
            if (i < 4) {
                // For the first four sub-arrays, take the standard size
                subArray = new P4[subArraySize];
                System.arraycopy(tempArray, i * subArraySize, subArray, 0, subArraySize);
            } else {
                // For the last sub-array, take the remaining elements
                int remainingElements = adjustedLength - (i * subArraySize);
                subArray = new P4[remainingElements];
                System.arraycopy(tempArray, i * subArraySize, subArray, 0, remainingElements);
            }
            System.out.println("\t\t#:" + i + " copied array into subarray of size:" + subArray.length);
            listOfArrays.add(subArray);
        }

        System.out.println("\tFinished copying subarray and adding to listOfArrays of size:" + listOfArrays.size());

// Now combine each
        List<TwoArrayObjects> combined = combineListOfArrays(listOfArrays);

        System.out.println("\tFinished combining the arrays into list combined: " + combined.size());

        for (int i = 0; i < combined.size(); i++) {
            P4[] toBeCombined1 = tempTao.getOne();
            P4[] toBeCombined2 = combined.get(i).getOne();

            System.out.println("\t\t#:" + i + " toBeCombined1: " + toBeCombined1.length + " toBeCombined2: " + toBeCombined2.length);

            P4[] combinedArray1and2 = new P4[toBeCombined1.length + toBeCombined2.length];
            System.arraycopy(toBeCombined1, 0, combinedArray1and2, 0, toBeCombined1.length);
            // Copy the second array
            System.arraycopy(toBeCombined2, 0, combinedArray1and2, toBeCombined1.length, toBeCombined2.length);
            System.out.println("\t\t#:" + i + " combinedArray1and2:  " + combinedArray1and2.length + " combined.get(i).getTwo(): " + combined.get(i).getTwo().length);

            TwoArrayObjects tempTao1 = new TwoArrayObjects(combinedArray1and2, combined.get(i).getTwo());
            returnAbleCombine.add(tempTao1);
        }

        System.out.println("\tFinished Overall combining");

        return returnAbleCombine;
    }

    private List<TwoArrayObjects> combineListOfArrays(List<P4[]> listOfArrays) {

        System.out.println("\tStarting Combing the arrays from listOfArrays");


        List<TwoArrayObjects> combinedWithMissing = new ArrayList<>();

        for(int i =0; i < listOfArrays.size(); i++){
            P4[] temp1 = new P4[listOfArrays.get(0).length * 4];
            P4[] temp2 = new P4[listOfArrays.get(0).length];
            int index = 0;
            System.out.println("\tStarting Combing the arrays from listOfArrays #:"+i);
            for(int j =0; j < listOfArrays.size(); j++){
                if(i != j){
                    System.arraycopy(listOfArrays.get(j), 0, temp1, index, listOfArrays.get(j).length);
                    index += listOfArrays.get(j).length;
                    System.out.println("\t\tCopy array #: "+j);
                }else{
                    temp2 = listOfArrays.get(j);
                }
            }
            System.out.println("\tFinished Combing the arrays from listOfArrays #:"+i);
            TwoArrayObjects tempTwoArrayObject = new TwoArrayObjects(temp1, temp2);
            combinedWithMissing.add(tempTwoArrayObject);

        }



        return combinedWithMissing;
    }







//private List<TwoArrayObjects> dividedObject1(TwoArrayObjects tempTao) {
//    List<TwoArrayObjects> returnAbleCombine = new ArrayList<>();
//    P5[] arrayTwo = tempTao.getTwo();
//
//    int length = arrayTwo.length;
//    // Adjust to the nearest lower multiple of 5
//    length -= length % 5;
//
//    // Calculate the size of each sub-array
//    int subArraySize = length / 5;
//
//    // Create a temporary array of the adjusted length
//    P5[] tempArray = new P5[length];
//    System.arraycopy(arrayTwo, 0, tempArray, 0, length);
//
//    // Combine sub-arrays directly into returnAbleCombine
//    for (int i = 0; i < 5; i++) {
//        P5[] subArray = new P5[subArraySize];
//        System.arraycopy(tempArray, i * subArraySize, subArray, 0, subArraySize);
//
//        // Combine with tempTao.getOne() and add to returnAbleCombine
//        P5[] toBeCombined1 = tempTao.getOne();
//        TwoArrayObjects combinedObject = new TwoArrayObjects(combineArrays1(toBeCombined1, subArray), subArray);
//        returnAbleCombine.add(combinedObject);
//    }
//
//    return returnAbleCombine;
//}

//private P5[] combineArrays1(P5[] array1, P5[] array2) {
//    P5[] combinedArray = new P5[array1.length + array2.length];
//    System.arraycopy(array1, 0, combinedArray, 0, array1.length);
//    System.arraycopy(array2, 0, combinedArray, array1.length, array2.length);
//    return combinedArray;
//}
//
//private List<TwoArrayObjects> combineListOfArrays1(List<P5[]> listOfArrays) {
//    List<TwoArrayObjects> combinedWithMissing = new ArrayList<>();
//    int size = listOfArrays.size();
//    int subArrayLength = listOfArrays.get(0).length;
//
//    for (int i = 0; i < size; i++) {
//        P5[] temp1 = new P5[subArrayLength * (size - 1)];
//        P5[] temp2 = listOfArrays.get(i); // This is the sub-array to be excluded
//        int index = 0;
//
//        for (int j = 0; j < size; j++) {
//            if (i != j) {
//                System.arraycopy(listOfArrays.get(j), 0, temp1, index, listOfArrays.get(j).length);
//                index += listOfArrays.get(j).length;
//            }
//        }
//
//        TwoArrayObjects tempTwoArrayObject = new TwoArrayObjects(temp1, temp2);
//        combinedWithMissing.add(tempTwoArrayObject);
//    }
//
//    return combinedWithMissing;
//}

    public static ArrayList<P4[]> divideIntoFive(P4[] array) {
        ArrayList<P4[]> result = new ArrayList<>();

        int totalLength = array.length;
        int baseSize = totalLength / 5;
        int remainder = totalLength % 5;

        int start = 0;

        for (int i = 0; i < 5; i++) {
            int currentSize = baseSize + (i == 0 ? remainder : 0); // First array gets the extra items if not divisible
            P4[] subArray = Arrays.copyOfRange(array, start, start + currentSize);
            result.add(subArray);
            start += currentSize;
        }

        return result;
    }

}
