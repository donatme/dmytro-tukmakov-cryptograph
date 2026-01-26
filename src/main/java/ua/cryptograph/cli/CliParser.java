package ua.cryptograph.cli;

import ua.cryptograph.application.Mode;

public class CliParser {

    public CliCommand parse(String[] args) {
        if (args.length < 2) {
            throw usageError();
        }

        Mode mode = Mode.from(args[0]);
        String filePath = args[1];

        switch (mode) {
            case ENCRYPTED, DECRYPTED:
                return parseWithShift(mode, filePath, args);
            case BRUTEFORCE:
                return parseBruteforce(mode, filePath, args);
        }
        throw usageError();
    }

    private CliCommand parseWithShift(Mode mode, String filePath, String[] args) {
        if (args.length != 3) {
            throw new IllegalArgumentException(mode + " requires <file> <shift>");
        }
        return new CliCommand(mode, filePath, parseShift(args[2]));
    }

    private CliCommand parseBruteforce(
            Mode mode,
            String filePath,
            String[] args
    ) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Bruteforce requires <file>");
        }
        return new CliCommand(mode, filePath, null);
    }

    private int parseShift(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Shift must be a number");
        }
    }

    private IllegalArgumentException usageError() {
        return new IllegalArgumentException("""
                Usage:
                  enc <file> <shift>
                  dec <file> <shift>
                  bf  <file>
                """);
    }
}
