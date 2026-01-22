package ua.cryptograph.caesarCipherService;

import ua.cryptograph.alphabets.AlphabetEnglish;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CaesarCipher {
    private final AlphabetEnglish alphabetEnglish = new AlphabetEnglish();

    public String caesarEncrypt(String input, int shift) {
        if (shift > 0) {
            shift = -shift;
        }
        return applyShift(input, shift);
    }

    public String caesarDecrypt(String input, int shift) {
        return applyShift(input, shift);
    }

    public String applyShift(String input, int shift) {
        List<Character> shifted = new ArrayList<>(alphabetEnglish.getAlphabet());
        Collections.rotate(shifted, shift);

        StringBuilder sb = new StringBuilder();
        for (char ch : input.toCharArray()) {
            if (alphabetEnglish.getAlphabet().contains(ch)) {
                int index = alphabetEnglish.getAlphabet().indexOf(ch);
                sb.append(shifted.get(index));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}