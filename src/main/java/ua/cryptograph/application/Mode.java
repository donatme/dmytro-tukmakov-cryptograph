package ua.cryptograph.application;

public enum Mode {
    ENCRYPTED,
    DECRYPTED,
    BRUTEFORCE;

    public static Mode from(String value) {
        return switch (value == null ? null : value.toLowerCase()) {
            case "enc" -> ENCRYPTED;
            case "dec" -> DECRYPTED;
            case "bf" -> BRUTEFORCE;
            case null -> throw new IllegalArgumentException("Mode must not be null. Use enc | dec | bf");
            default -> throw new IllegalArgumentException("Unknown mode: " + value + ". Use enc | dec | bf");
        };
    }
}
