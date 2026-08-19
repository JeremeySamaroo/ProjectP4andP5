public class PossiblePlayable {
    public int calculatePossiblePlayableLength(P4[] allCombos, int[] lastPlayedNumbersWithoutRepeats) {
        int returnValue = 0;
        for(P4 allCombosValues: allCombos){
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
                }
            }//end value for
            if(counter > 0 && counter < 3){
                returnValue++;
            }
        }// end all combos for
        return returnValue;
    }

    public P4[] generatePosssiblePlayabelArray(P4[] allCombos, int[] lastPlayedNumbersWithoutRepeats, int lengthOfPossiblePlayable) {
        P4 returnValueArray[] = new P4[lengthOfPossiblePlayable];
        int returnValueArrayIndex = 0;


        for(P4 allCombosValues: allCombos){
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
                }
            }//end value for
            if(counter > 0 && counter < 3){
                returnValueArray[returnValueArrayIndex++] = new P4(allCombosValues.getN1(), allCombosValues.getN2(), allCombosValues.getN3(), allCombosValues.getN4());
            }
        }// end all combos for
        return returnValueArray;
    }
}
