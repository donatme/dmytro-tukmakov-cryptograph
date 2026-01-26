package ua.cryptograph.caesar;

import ua.cryptograph.alphabets.Alphabet;
import ua.cryptograph.alphabets.Alphabets;

public class CaesarCipher {
    private final UniversalShifter universalShifter = new UniversalShifter();

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
            Alphabet alphabet = Alphabets.detect(ch);
            if (alphabet != null) {
                return alphabet.length();
            }
        }
        return Alphabets.EN.length();
    }

    private int normalizeShift(int shift, int alphabetLength) {
        return ((shift % alphabetLength) + alphabetLength) % alphabetLength;
    }
}
