package ua.cryptograph.caesar;

import ua.cryptograph.alphabets.Alphabet;
import ua.cryptograph.alphabets.Alphabets;

import java.util.Optional;

public class UniversalShifter {

    public String applyShift(String input, int shift) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        StringBuilder result = new StringBuilder();
        for (char ch : input.toCharArray()) {
            Optional<Alphabet> alphabetOpt = Alphabets.detect(ch);
            if (alphabetOpt.isPresent()) {
                result.append(alphabetOpt.get().shift(ch, shift));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}
