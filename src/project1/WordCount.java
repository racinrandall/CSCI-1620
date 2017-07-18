package project1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

enum State {
    START,
    WORD,
    DELIMITER,
}

/**
 * The {@code WordCount} class is a re-creation of the traditional UNIX command wc.
 * It takes one or more filename as arguments and counts the number of lines, words
 * and characters in the file and outputs them to standard output.  If more than
 * one file is passed, it also gives the total for all files passed.
 * <p>
 * This uses the {@code BufferedReader} class, exception handling, and the for-each loop.
 *
 * @author Charles D. Randall
 * @version 1.00
 */

public class WordCount {

    static class FileInfo {
        String fileName;
        int charCount;
        int wordCount;
        int lineCount;

        FileInfo(String fileName, int charCount, int wordCount, int lineCount) { // Constructor
            this.fileName = fileName;
            this.charCount = charCount;
            this.wordCount = wordCount;
            this.lineCount = lineCount;
        }

        public String toString() {
            return String.format("%d %d %d %s", lineCount, wordCount, charCount, fileName);
        }
    }

    public static FileInfo getDataForFile(String fileName) throws IOException {
        int wc = 0;
        int lc = 0;
        int cc = 0;
        int ch;

        State state = State.START;
        try (BufferedReader input = new BufferedReader(new FileReader(fileName))) {
            while ((ch = input.read()) != -1) {
                cc++;
                switch (state) {
                    case START:
                        if (!Character.isWhitespace(ch)) {
                            state = State.WORD;
                            wc++;
                        } else {
                            state = State.DELIMITER;
                            if (ch == '\n') {
                                lc++;
                            }
                        }
                        break;
                    case WORD:
                        if (Character.isWhitespace(ch)) {
                            state = State.DELIMITER;
                            if (ch == '\n') {
                                lc++;
                            }
                        }
                        break;
                    case DELIMITER:
                        if (!Character.isWhitespace(ch)) {
                            state = State.WORD;
                            wc++;
                        } else if (ch == '\n') {
                            lc++;
                        }
                        break;
                }
            }

            return new FileInfo(fileName, cc, wc, lc);

        }
    }

    public static void main(String[] args) {
        int twc, tlc, tcc;
        twc = 0;
        tlc = 0;
        tcc = 0;

        for (String fileName : args) {
            try {
                FileInfo data = getDataForFile(fileName);

                twc += data.wordCount;
                tlc += data.lineCount;
                tcc += data.charCount;

                System.out.println(data);
            } catch (IOException error) {
                System.err.println("unable to process" + fileName);
            }
        }
        if (args.length > 1) {
            System.out.printf("%d %d %d total", tlc, twc, tcc);
        }
    }
}



