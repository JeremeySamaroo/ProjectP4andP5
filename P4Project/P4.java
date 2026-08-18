public class P4 {

    int n1, n2, n3, n4, value;
    String p4String;

    public P4() {
    }

    public P4(int n1, int n2, int n3, int n4) {
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
        this.n4 = n4;
    }

    public P4(int n1, int n2, int n3, int n4, int value) {
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
        this.n4 = n4;
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

    public String getP4String() {
        return p4String;
    }

    public void setP4String(String p4String) {
        this.p4String = p4String;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "P4{" +
                "n1=" + n1 +
                ", n2=" + n2 +
                ", n3=" + n3 +
                ", n4=" + n4 +
                ", value=" + value +
                '}';
    }

    public int calculateAmtCombinations(int[] choices) {

        int count = 0;

        for (int i = 0; i < choices.length - 3; i++) {
            for (int j = i + 1; j < choices.length - 2; j++) {
                for (int k = j + 1; k < choices.length - 1; k++) {
                    for (int l = k + 1; l < choices.length; l++) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public P4[] generateAllCombinations(int[] choices, P4[] allCombos) {

        int count = 0;

        for (int i = 0; i < choices.length - 3; i++) {
            for (int j = i + 1; j < choices.length - 2; j++) {
                for (int k = j + 1; k < choices.length - 1; k++) {
                    for (int l = k + 1; l < choices.length; l++) {

                        allCombos[count] =
                                new P4(choices[i], choices[j], choices[k], choices[l]);

                        count++;
                    }
                }
            }
        }

        return allCombos;
    }

    // Method to get the relevant string representation
    public String getRelevantString() {
        // Return a string representation excluding the value
        return String.format(
                "P4[n1=%d, n2=%d, n3=%d, n4=%d]",
                n1, n2, n3, n4
        );
    }
}
