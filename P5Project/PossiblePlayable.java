public class PossiblePlayable {
    public int calculatePossiblePlayableLength(P5[] allCombos, int[] lastPlayedNumbersWithoutRepeats) {
        int returnValue = 0;
        for(P5 allCombosValues: allCombos){
            int counter = 0;
            for(int value: lastPlayedNumbersWithoutRepeats){
                if(allCombosValues.getN1() == value){
                    counter++;
                } else if (allCombosValues.getN2() == value) {
                    counter++;
                }else if (allCombosValues.getN3() == value) {
                    counter++;
                }else if (allCombosValues.getN4() == value) {
                    counter++;
                }else if (allCombosValues.getN5() == value) {
                    counter++;
                }
            }//end value for
            if(counter > 0 && counter < 3){
                returnValue++;
            }
        }// end all combos for
        return returnValue;
    }

    public P5[] generatePosssiblePlayabelArray(P5[] allCombos, int[] lastPlayedNumbersWithoutRepeats, int lengthOfPossiblePlayable) {
        P5 returnValueArray[] = new P5[lengthOfPossiblePlayable];
        int returnValueArrayIndex = 0;


        for(P5 allCombosValues: allCombos){
            int counter = 0;
            for(int value: lastPlayedNumbersWithoutRepeats){
                if(allCombosValues.getN1() == value){
                    counter++;
                } else if (allCombosValues.getN2() == value) {
                    counter++;
                }else if (allCombosValues.getN3() == value) {
                    counter++;
                }else if (allCombosValues.getN4() == value) {
                    counter++;
                }else if (allCombosValues.getN5() == value) {
                    counter++;
                }
            }//end value for
            if(counter > 0 && counter < 3){
                returnValueArray[returnValueArrayIndex++] = new P5(allCombosValues.getN1(), allCombosValues.getN2(), allCombosValues.getN3(), allCombosValues.getN4(), allCombosValues.getN5());
            }
        }// end all combos for
        return returnValueArray;
    }
}
