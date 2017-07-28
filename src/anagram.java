import java.util.ArrayList;
import java.util.List;

public class anagram {

    List<String> results = new ArrayList<>();

    public List<String> anag(String s1, String s2) {

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
        for (String fileName : args) {
            System.out.println(fileName);
            List<String> gram = ana.anag(fileName, "");
            System.out.printf("%s\n\n", gram);
            gram.clear();
        }
    }
}



