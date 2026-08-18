public class P5 {

    int n1, n2, n3, n4, n5, value;
    String p5String;

    public P5() {
    }

    public P5(int n1, int n2, int n3, int n4, int n5) {
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
        this.n4 = n4;
        this.n5 = n5;
    }

    public P5(int n1, int n2, int n3, int n4, int n5, int value) {
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
        this.n4 = n4;
        this.n5 = n5;
        this.value = value;
    }




    public int getN1() {
        return n1;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public int getN2() {
        return n2;
    }

    public void setN2(int n2) {
        this.n2 = n2;
    }

    public int getN3() {
        return n3;
    }

    public void setN3(int n3) {
        this.n3 = n3;
    }

    public int getN4() {
        return n4;
    }

    public void setN4(int n4) {
        this.n4 = n4;
    }

    public int getN5() {
        return n5;
    }

    public void setN5(int n5) {
        this.n5 = n5;
    }

    public String getP5String() {
        return p5String;
    }

    public void setP5String(String p5String) {
        this.p5String = p5String;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "P5{" +
                "n1=" + n1 +
                ", n2=" + n2 +
                ", n3=" + n3 +
                ", n4=" + n4 +
                ", n5=" + n5 +
                ", value="+value+
                '}';
    }

    public int calculateAmtCombinations(int[] choices) {

        int count =0;
        for(int i =0; i < choices.length-4; i++){
            for(int j =i+1; j < choices.length-3; j++){
                for(int k =j+1; k < choices.length-2; k++){
                    for(int l =k+1; l < choices.length-1; l++){
                        for(int m =l+1; m < choices.length; m++){
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public P5[] generateAllCombinations(int[] choices, P5[] allCombos) {

        int count =0;
        for(int i =0; i < choices.length-4; i++){
            for(int j =i+1; j < choices.length-3; j++){
                for(int k =j+1; k < choices.length-2; k++){
                    for(int l =k+1; l < choices.length-1; l++){
                        for(int m =l+1; m < choices.length; m++){

                            allCombos[count] =new P5(choices[i],choices[j],choices[k],choices[l],choices[m]);
//                          allCombos[count].setN1(choices[i]);
//                          allCombos[count].setN2(choices[j]);
//                          allCombos[count].setN3(choices[k]);
//                          allCombos[count].setN4(choices[l]);
//                          allCombos[count].setN5(choices[m]);

                            count++;


                        }
                    }
                }
            }
        }
        return allCombos;
    }


    // Method to get the relevant string representation
    public String getRelevantString() {
        // Return a string representation excluding the values
        return String.format("P5[n1=%d, n2=%d, n3=%d, n4=%d, n5=%d]", n1, n2, n3, n4, n5);
    }


}
