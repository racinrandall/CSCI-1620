import java.util.ArrayList;
import java.util.List;

public class LinearSearch {

    public static boolean contains(int x, int[] xs) {
        for (int i = 0; i < xs.length; i++) {
            if (x == xs[i]) {
                return true;
            }
        }
        return false;
    }

    public static <T extends Comparable<T>>
    boolean contains(T x, T[] xs) {
        for (int i = 0; i < xs.length; i++) {
            if (x.compareTo(xs[i]) == 0) {
                return true;
            }
        }
        return false;
    }

    public static <T extends Comparable<T>>
    boolean contains(T x, List<T> xs) {
        for (int i = 0; i < xs.size(); i++) {
            if (x == xs.get(i)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] xs = {1, 2, 3, 4, 5, 6};
        String[] strs = {"hello", "world", "foo", "bar"};
        List<String> f = new ArrayList<>();

        for (String s : strs) {
            f.add(s);
        }

        if (contains(3, xs)) {
            System.out.println("Found 3");
        } else {
            System.out.println("Didn't find 3");
        }

        if (contains("foo", f)) {
            System.out.println("Found foo");
        } else {
            System.out.println("Didn't find foo");
        }
    }
}
