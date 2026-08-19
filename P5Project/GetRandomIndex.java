import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class GetRandomIndex {


    public int[] GRI(P5[] ppArray, int[] arrayOfRandomIndex) {

        Random random = new Random();

        //int randomIntInRange = random.nextInt(ppArray.length); // 0 to 99

        for(int i = 0; i < arrayOfRandomIndex.length; i++){
            int randomIntInRange = random.nextInt(ppArray.length);
            if(i==0){
                arrayOfRandomIndex[i] = randomIntInRange;
            }else{
                // Sort the array in ascending order
                Arrays.sort(arrayOfRandomIndex);
                if(randomIntInRange > arrayOfRandomIndex[i-1]){
                    arrayOfRandomIndex[i] = randomIntInRange;
                }else{
                    boolean addToArray = true;
                    for(int j = 0; j < i; j++){
                        if(randomIntInRange == arrayOfRandomIndex[j] ){
                            addToArray = false;
                            break;
                        }
                    }
                    if(addToArray == true){
                        arrayOfRandomIndex[i] = randomIntInRange;
                    }else{
                        i = i - 1;
                    }
                }
            }
        }


        return  arrayOfRandomIndex;
    }


    public int[] GRI1(ArrayList<P5[]> ppArray, int[] arrayOfRandomIndex) {

        Random random = new Random();

        //int randomIntInRange = random.nextInt(ppArray.length); // 0 to 99

        for(int i = 0; i < arrayOfRandomIndex.length; i++){
            int randomIntInRange = random.nextInt(ppArray.size());
            if(i==0){
                arrayOfRandomIndex[i] = randomIntInRange;
                System.out.println("Entering if at: "+i+" previous value: "+arrayOfRandomIndex[i]+ " current value: "+randomIntInRange);

            }else{
                // Sort the array in ascending order
                System.out.println("Entering if at: "+i+" previous value: "+arrayOfRandomIndex[i-1]+ " current value: "+randomIntInRange);
                Arrays.sort(arrayOfRandomIndex);
                if(randomIntInRange > arrayOfRandomIndex[i-1]){
                    arrayOfRandomIndex[i] = randomIntInRange;
                }else{
                    boolean addToArray = true;
                    for(int j = 0; j < i; j++){
                        if(randomIntInRange == arrayOfRandomIndex[j] ){
                            addToArray = false;
                            break;
                        }
                    }
                    if(addToArray == true){
                        arrayOfRandomIndex[i] = randomIntInRange;
                    }else{
                        i = i - 1;
                    }
                }
            }//end else
        }


        return  arrayOfRandomIndex;
    }

    public int[] GRI_HashSet(ArrayList<P5[]> ppArray, int[] arrayOfRandomIndex) {
        Random random = new Random();
        HashSet<Integer> uniqueIndices = new HashSet<>();

        for (int i = 0; i < arrayOfRandomIndex.length; i++) {
            int randomIntInRange;

            // Keep generating until we find a unique random index
            do {
                randomIntInRange = random.nextInt(ppArray.size());
            } while (uniqueIndices.contains(randomIntInRange));

            // Add the unique random index to the array and the set
            arrayOfRandomIndex[i] = randomIntInRange;
            uniqueIndices.add(randomIntInRange);

            //System.out.println("Generated unique index at: " + i + " value: " + randomIntInRange);
        }

        return arrayOfRandomIndex;
    }

    public int[] GRI_HashSet1(P5[] ppArray, int[] arrayOfRandomIndex) {
        Random random = new Random();
        HashSet<Integer> uniqueIndices = new HashSet<>();

        for (int i = 0; i < arrayOfRandomIndex.length; i++) {
            int randomIntInRange;

            // Keep generating until we find a unique random index
            do {
                randomIntInRange = random.nextInt(ppArray.length);
            } while (uniqueIndices.contains(randomIntInRange));

            // Add the unique random index to the array and the set
            arrayOfRandomIndex[i] = randomIntInRange;
            uniqueIndices.add(randomIntInRange);

            //System.out.println("Generated unique index at: " + i + " value: " + randomIntInRange);
        }

        return arrayOfRandomIndex;
    }

    public int[] GRI_1(int[] arrayOfRandomIndex1, int arrayOfRandomIndexLength2) {
        // Create a new array of the specified length
        int[] newArray = new int[arrayOfRandomIndexLength2];

        // Create a Random object for generating random indices
        Random random = new Random();

        // Fill the new array with random values from the source array
        for (int i = 0; i < newArray.length; i++) {
            int randomIndex = random.nextInt(arrayOfRandomIndex1.length);
            // Get a random index
            if(i==0){
                newArray[i] = arrayOfRandomIndex1[randomIndex];
               // newArray[i] = 30;
            }else{
                boolean found = false;
                for(int j = 0; j < i; j++){
                    if(newArray[j] == arrayOfRandomIndex1[randomIndex] ){
                        found = true;
                        break;
                    }
                }
                if(found ==false){
                    newArray[i] = arrayOfRandomIndex1[randomIndex];
                }else{
                    i = i -1;
                }
            }

        }
        Arrays.sort(newArray);
        //System.out.println(Arrays.toString(newArray));

        return newArray;
    }
}
