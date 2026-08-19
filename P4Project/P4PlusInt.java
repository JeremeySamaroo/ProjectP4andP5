import java.util.Arrays;

public class P4PlusInt {

    P4[] one; //
    int two; // what is not in one


    public P4PlusInt() {
    }

    public P4PlusInt(P4[] one, int two) {
        this.one = one;
        this.two = two;
    }


    public P4[] getOne() {
        return one;
    }

    public void setOne(P4[] one) {
        this.one = one;
    }

    public int getTwo() {
        return two;
    }

    public void setTwo(int two) {
        this.two = two;
    }


    @Override
    public String toString() {
        return "TwoArrayObjects{" +
                "one=" + Arrays.toString(one) +
                ", two=" + two +
                '}';
    }


}
