package ua.cryptograph;

import ua.cryptograph.cli.CliCommand;
import ua.cryptograph.cli.CliParser;
import ua.cryptograph.cli.CryptographApplication;

public class ConsoleRunnerCryptograph {
    public static void main(String[] args) {

        /*CaesarCipher caesarCipher = new CaesarCipher();

        String text = "My testing test text ! Один два три 1 2 3" +
                " ҐґЄєІіЇї Українська література (повні тексти творів)";
        System.out.println("Original: " + text);

        String encText = caesarCipher.caesarEncrypt(text, 518);
        System.out.println("Encrypt : " + encText);

        String decText = caesarCipher.caesarDecrypt(encText, 518);
        System.out.println("Decrypt : " + decText);*/

        CliCommand command = new CliParser().parse(args);
        new CryptographApplication().run(command);

    }
}