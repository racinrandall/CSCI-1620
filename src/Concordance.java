import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Concordance {

    private static final String DELIMITER = "\\W+";

    static class Entry {
        private int numberOfOccurrences;
        private SortedSet<Integer> lineNumbers;

        public Entry(int line) {
            setNumberOfOccurrences(1);
            setLineNumbers(new TreeSet<>());
            updateLineNumbers(line);
        }

        public void updateLineNumbers(int line) {
            this.lineNumbers.add(line);
        }

        public void incrementNumberOfOccurrences() {
            this.numberOfOccurrences++;
        }

        public void setNumberOfOccurrences(int x) {
            this.numberOfOccurrences = x;
        }

        public void setLineNumbers(SortedSet<Integer> lines) {
            this.lineNumbers = lines;
        }

        public int getNumberOfOccurrences() {
            return numberOfOccurrences;
        }

        public SortedSet<Integer> getLineNumbers() {
            return lineNumbers;
        }

        public String toString() {
            return String.format("\nnumber: %d\nlines: %s\n\n", getNumberOfOccurrences(), getLineNumbers());
        }
    }

    private static Map<String, Entry> generateConcordanceForFile(String fileName) throws IOException {

        Map<String, Entry> results = new TreeMap<>();
        int lineNumber = 0;

        try (BufferedReader input = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = input.readLine()) != null) {
                lineNumber++;
                String[] words = line.split(DELIMITER);
                for (String word : words) {
                    if (!word.isEmpty()) {
                        // if word is in results, update the entry

                        if (results.containsKey(word)) {
                            Entry entry = results.get(word);
                            entry.updateLineNumbers(lineNumber);
                            entry.incrementNumberOfOccurrences();// figure out how to set the entry

                        }
                        // else add new entry
                        else {
                            Entry entry = new Entry(lineNumber);
                            results.put(word, entry);
                        }
                    }
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        for (String fileName : args) {
            try {
                System.out.printf("%s:\n", fileName);
                System.out.printf("%s\n", generateConcordanceForFile(fileName).toString());

            } catch (IOException error) {
                System.out.printf("unable tp process %s\n", fileName);
            }

        }
    }
}
