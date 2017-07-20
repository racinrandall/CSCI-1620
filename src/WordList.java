import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.SortedSet;
import java.util.TreeSet;

public class WordList {

    private static final String DELIMITER = "\\W+";

    private static SortedSet<String> wordsInFile(String fileName) throws IOException {
        SortedSet<String> results = new TreeSet<>();

        try (BufferedReader input = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = input.readLine()) != null) {
                String[] words = line.split(DELIMITER);
                for (String word : words) {
                    if (!word.isEmpty()) {
                        results.add(word.toLowerCase());
                    }
                }
            }
        }
        return results;
    }


    public static void main(String[] args) {

        if (args.length != 0) {
            for (String fileName : args) {
                try {
                    SortedSet<String> words = wordsInFile(fileName);
                    System.out.printf("file: %s\nwords: %s\n", fileName, words);
                } catch (IOException error) {
                    System.err.printf("%s: unable to process file\n", fileName);
                }
            }
        }
    }
}
