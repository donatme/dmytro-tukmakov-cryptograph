package ua.cryptograph.caesar;

import ua.cryptograph.alphabets.Alphabet;
import ua.cryptograph.alphabets.Alphabets;

public class UniversalShifter {

    public String applyShift(String input, int shift) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        StringBuilder result = new StringBuilder();

        for (char ch : input.toCharArray()) {
            Alphabet alphabet = Alphabets.detect(ch);
            if (alphabet == null) {
                result.append(ch);
            } else {
                result.append(alphabet.shift(ch, shift));
            }
        }
        return result.toString();
    }
}
