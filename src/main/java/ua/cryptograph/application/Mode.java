package ua.cryptograph.application;

public enum Mode {
    ENCRYPT,
    DECRYPT,
    BRUTE_FORCE;

    public static Mode from(String value) {
        return switch (value == null ? null :value.toLowerCase()) {
            case "enc" -> ENCRYPT;
            case "dec" -> DECRYPT;
            case "bf" -> BRUTE_FORCE;
            case null -> throw new IllegalArgumentException("Mode must not be null. Use enc | dec | bf");
            default -> throw new IllegalArgumentException("Unknown mode: " + value + ". Use enc | dec | bf");
        };
    }
}
