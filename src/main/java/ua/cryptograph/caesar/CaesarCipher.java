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
        if (input == null || input.isEmpty()) return Alphabet.alphabet_en.length;

        for (char c : input.toCharArray()) {
            if (Alphabet.isInAlphabet(c, Alphabet.alphabet_cyrillic))
                return Alphabet.alphabet_cyrillic.length;
            else if (Alphabet.isInAlphabet(c, Alphabet.alphabet_en))
                return Alphabet.alphabet_en.length;
        }
        return Alphabet.alphabet_cyrillic.length;
    }

    private int normalizeShift(int shift, int alphabetLength) {
        return ((shift % alphabetLength) + alphabetLength) % alphabetLength;
    }
}
