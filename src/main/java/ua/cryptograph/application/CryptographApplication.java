package ua.cryptograph.application;

import ua.cryptograph.caesar.BruteForce;
import ua.cryptograph.caesar.CaesarCipher;
import ua.cryptograph.cli.CliCommand;
import ua.cryptograph.io.FileReader;
import ua.cryptograph.io.FileWriter;

import java.nio.file.Files;
import java.nio.file.Path;
public class CryptographApplication {

    private final FileReader fileReader;
    private final FileWriter fileWriter;
    private final CaesarCipher cipher;
    private final BruteForce bruteForce;

    public CryptographApplication(
            FileReader fileReader,
            FileWriter fileWriter,
            CaesarCipher cipher,
            BruteForce bruteForce
    ) {
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
        this.cipher = cipher;
        this.bruteForce = bruteForce;
    }

    public void run(CliCommand cmd) {
        Path inputPath = Path.of(cmd.filePath());

        if (!Files.exists(inputPath)) {
            System.out.println("ERROR: input file does not exist: " + inputPath);
            return;
        }

        String inputText = fileReader.read(inputPath.toString());

        String result = switch (cmd.mode()) {
            case ENCRYPT -> cipher.caesarEncrypt(inputText, cmd.shift());
            case DECRYPT -> cipher.caesarDecrypt(inputText, cmd.shift());
            case BRUTE_FORCE -> bruteForce.crack(inputText);
        };

        String outputPath = buildOutputPath(cmd.filePath(), cmd.mode());
        fileWriter.write(outputPath, result);

        System.out.println("Result saved to: " + outputPath);
    }

    private String buildOutputPath(String inputPath, Mode mode) {
        int dotIndex = inputPath.lastIndexOf('.');
        if (dotIndex == -1) dotIndex = inputPath.length();

        String name = inputPath.substring(0, dotIndex);
        String ext = dotIndex < inputPath.length() ? inputPath.substring(dotIndex) : "";

        name = name.replaceAll("\\[(ENCRYPT|DECRYPT|BRUTFORCE)\\]$", "");
        return name + "[" + mode + "]" + ext;
    }
}
