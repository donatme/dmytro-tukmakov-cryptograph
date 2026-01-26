package ua.cryptograph.caesar;

import ua.cryptograph.alphabets.Alphabet;

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
        if (input == null || input.isBlank()) {
            return Alphabet.ALPHABET_EN.length;
        }

        for (char c : input.toCharArray()) {
            if (Alphabet.isInAlphabet(c, Alphabet.ALPHABET_CYRILLIC)) {
                return Alphabet.ALPHABET_CYRILLIC.length;
            } else if (Alphabet.isInAlphabet(c, Alphabet.ALPHABET_EN)) {
                return Alphabet.ALPHABET_EN.length;
            }
        }
        return Alphabet.ALPHABET_CYRILLIC.length;
    }

    private int normalizeShift(int shift, int alphabetLength) {
        return ((shift % alphabetLength) + alphabetLength) % alphabetLength;
    }
}
