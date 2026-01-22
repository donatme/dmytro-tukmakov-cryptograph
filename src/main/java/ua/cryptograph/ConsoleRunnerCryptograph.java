package ua.cryptograph;

import ua.cryptograph.caesarCipherService.CaesarCipher;

public class ConsoleRunnerCryptograph {
    public static void main(String[] args) {

        CaesarCipher caesarCipher = new CaesarCipher();

        String text = "My testing test text !";
        System.out.println("Original: " + text);

        String encText = caesarCipher.caesarEncrypt(text, 5);
        System.out.println("Encrypt : " + encText);

    }
}