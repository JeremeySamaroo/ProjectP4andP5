import java.util.Arrays;

public class TwoArrayObjects {

    P5[] one; //
    P5[] two; // what is not in one


    public TwoArrayObjects() {
    }

    public TwoArrayObjects(P5[] one, P5[] two) {
        this.one = one;
        this.two = two;
    }


    public P5[] getOne() {
        return one;
    }

    public void setOne(P5[] one) {
        this.one = one;
    }

    public P5[] getTwo() {
        return two;
    }

    public void setTwo(P5[] two) {
        this.two = two;
    }


    @Override
    public String toString() {
        return "TwoArrayObjects{" +
                "one=" + Arrays.toString(one) +
                ", two=" + Arrays.toString(two) +
                '}';
    }


}
