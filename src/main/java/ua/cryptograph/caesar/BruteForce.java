package ua.cryptograph.caesar;

public class BruteForce {
    private final CaesarCipher cipher;

    public int getBestShift() {
        return bestShift;
    }

    private int bestShift = 0;


    public BruteForce(CaesarCipher cipher) {
        this.cipher = cipher;
    }

    public String crack(String encryptedText) {
        int maxShift = 40;
        String bestText = encryptedText;
        int bestScore = Integer.MIN_VALUE;

        for (int shift = 0; shift < maxShift; shift++) {
            String candidate = cipher.caesarDecrypt(encryptedText, shift);
            int score = score(candidate);

            if (score > bestScore) {
                bestScore = score;
                bestText = candidate;
                bestShift = shift;
            }
        }
        return  bestText;
    }

    private int score(String text) {
        int score = 0;

        score += count(text, ' ') * 3;

        if (text.length() < 20) return 0;
        if (text.contains(" the ")) score += 200;
        if (text.contains(" and ")) score += 150;

        if (text.contains(" що ")) score += 100;
        if (text.contains(" не ")) score += 80;
        if (text.contains(" і ")) score += 50;

        score -= count(text, '@') * 6;
        score -= count(text, '#') * 6;
        score -= count(text, '$') * 6;

        return score;
    }

    private int count(String text, char ch) {
        int c = 0;
        for (char t : text.toCharArray()) {
            if (t == ch) c++;
        }
        return c;
    }
}
