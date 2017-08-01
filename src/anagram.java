
import java.util.SortedSet;
import java.util.TreeSet;

public class anagram {

    SortedSet<String> results = new TreeSet<>();

    public SortedSet<String> anag(String s1, String s2) {

        if (s1.length() == 0) {
            results.add(s2);
        }
        for (int i = 0; i < s1.length(); i++) {
            anag(s1.substring(0, i) + s1.substring(i + 1, s1.length()), s1.charAt(i) + s2);
        }
        return results;
    }

    public static void main(String[] args) {
        anagram ana = new anagram();
        for (String arg : args) {
            System.out.println(arg.toLowerCase());
            SortedSet<String> gram = ana.anag(arg.toLowerCase(), "");
            System.out.printf("%s\n\n", gram);
            gram.clear();
        }
    }
}



