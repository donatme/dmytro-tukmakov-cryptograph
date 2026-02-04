package ua.cryptograph.application;

import ua.cryptograph.caesar.BruteForce;
import ua.cryptograph.caesar.CaesarCipher;
import ua.cryptograph.cli.CliCommand;
import ua.cryptograph.io.FileReader;
import ua.cryptograph.io.FileWriter;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CryptographApplication {
    private final FileReader fileReader;
    private final FileWriter fileWriter;
    private final CaesarCipher cipher;
    private final BruteForce bruteForce;
    private final static String OUTPUT_FILE_REGEX = "\\[(ENCRYPTED|DECRYPTED|BRUTEFORCE)(\\[KEY=\\d+])?]";

    public CryptographApplication(FileReader fileReader, FileWriter fileWriter, CaesarCipher cipher, BruteForce bruteForce) {
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
        this.cipher = cipher;
        this.bruteForce = bruteForce;
    }

    private void deleteOldBruteForceFiles(Path inputPath) {
        Path dir = inputPath.getParent();

        if (dir == null) {
            return;
        }

        String fileName = inputPath.getFileName().toString();
        int dotIndex = fileName.lastIndexOf('.');
        String baseName = dotIndex == -1 ? fileName : fileName.substring(0, dotIndex);
        String ext = dotIndex == -1 ? "" : fileName.substring(dotIndex);
        baseName = baseName.replaceAll(OUTPUT_FILE_REGEX, "");

        try {
            File dirFile = dir.toFile();
            File[] files = dirFile.listFiles();
            if (files == null) {
                return;
            }
            for (File file : files) {
                fileName = file.getName();
                boolean isBruteforceFile =
                        fileName.startsWith(baseName + "[" + Mode.BRUTEFORCE + "][KEY=") && fileName.endsWith(ext);
                if (isBruteforceFile) {
                    Files.deleteIfExists(file.toPath());
                    System.err.println("Deleted old brute file: " + fileName);
                }
            }
        } catch (Exception e) {
            System.out.println("Error deleting old brute file: " + e.getMessage());
        }
    }

    public void run(CliCommand cmd) {
        Path inputPath = Path.of(cmd.filePath());
        if (cmd.mode() == Mode.BRUTEFORCE) {
            deleteOldBruteForceFiles(inputPath);
        }
        if (!Files.exists(inputPath)) {
            System.err.println("ERROR: for using BRUTEFORCE must exists: " + inputPath.getFileName());
            return;
        }
        String inputText = fileReader.read(inputPath.toString());
        String result = switch (cmd.mode()) {
            case ENCRYPTED -> cipher.caesarEncrypt(inputText, cmd.shift());
            case DECRYPTED -> cipher.caesarDecrypt(inputText, cmd.shift());
            case BRUTEFORCE -> bruteForce.crack(inputText);
        };

        String outputPath = buildOutputPath(cmd.filePath(), cmd.mode());
        fileWriter.write(outputPath, result);
        System.out.println("Result saved to: " + Paths.get(outputPath).getFileName());
    }

    private String buildOutputPath(String inputPath, Mode mode) {
        int dotIndex = inputPath.lastIndexOf('.');

        if (dotIndex == -1) {
            dotIndex = inputPath.length();
        }

        String name = inputPath.substring(0, dotIndex);
        String ext = dotIndex < inputPath.length() ? inputPath.substring(dotIndex) : "";
        name = name.replaceAll(OUTPUT_FILE_REGEX, "");

        return (mode == Mode.BRUTEFORCE) ?
                (name + "[" + mode + "][KEY=" + bruteForce.getBestShift() + "]" + ext) :
                name + "[" + mode + "]" + ext;
    }
}
