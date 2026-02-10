package ua.cryptograph.caesar;

import ua.cryptograph.alphabets.Alphabet;
import ua.cryptograph.alphabets.Alphabets;

import java.util.Optional;

public class CaesarCipher {
    private final UniversalShifter universalShifter;

    public CaesarCipher(UniversalShifter universalShifter) {
        this.universalShifter = universalShifter;
    }

    public String caesarEncrypt(String input, int shift) {
        int alphabetLength = detectAlphabetLength(input);
        shift = normalizeShift(shift, alphabetLength);
        return universalShifter.applyShift(input, -shift);
    }

    public String caesarDecrypt(String input, int shift) {
        int alphabetLength = detectAlphabetLength(input);
        shift = normalizeShift(shift, alphabetLength);
        return universalShifter.applyShift(input, shift);
    }

    private int detectAlphabetLength(String input) {
        for (char ch : input.toCharArray()) {
            Optional<Alphabet> alphabetOpt = Alphabets.detect(ch);
            if (alphabetOpt.isPresent()) {
                return alphabetOpt.get().length();
            }
        }
        return Alphabets.EN.length();
    }


    private int normalizeShift(int shift, int alphabetLength) {
        return ((shift % alphabetLength) + alphabetLength) % alphabetLength;
    }
}
