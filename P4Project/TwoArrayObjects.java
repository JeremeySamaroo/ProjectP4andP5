import java.util.Arrays;

public class TwoArrayObjects {

    P4[] one; //
    P4[] two; // what is not in one


    public TwoArrayObjects() {
    }

    public TwoArrayObjects(P4[] one, P4[] two) {
        this.one = one;
        this.two = two;
    }


    public P4[] getOne() {
        return one;
    }

    public void setOne(P4[] one) {
        this.one = one;
    }

    public P4[] getTwo() {
        return two;
    }

    public void setTwo(P4[] two) {
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
