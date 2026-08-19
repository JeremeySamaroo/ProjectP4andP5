import java.util.Arrays;

public class P5PlusInt {

    P5[] one; //
    int two; // what is not in one


    public P5PlusInt() {
    }

    public P5PlusInt(P5[] one, int two) {
        this.one = one;
        this.two = two;
    }


    public P5[] getOne() {
        return one;
    }

    public void setOne(P5[] one) {
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
