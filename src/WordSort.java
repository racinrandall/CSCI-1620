import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WordSort {

    public static class StringComparator implements Comparator<String> {
        public int compare(String s1, String s2) {
            return s1.compareToIgnoreCase(s2);
        }
    }

    public static List<String> wordsInfFile(String fileName) throws IOException{
        try (BufferedReader input = new BufferedReader(new FileReader(fileName))){
            List<String> results = new ArrayList<>();

            String line;
            while ((line = input.readLine()) != null) {
                String[] words = line.split("\\W+");
                for (String word : words) {
                    results.add(word);
                }
            }

            return results;
        }
    }
    public static void main(String[] args) {
        for (String fileName : args) {
            try {
                List<String> words = wordsInfFile(fileName);

                words.sort(new StringComparator());

                System.out.println(words);
            } catch (IOException error) {
                System.out.printf("unable tp process %s\n", fileName);
            }
        }
    }
}
