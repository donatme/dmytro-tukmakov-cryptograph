package ua.cryptograph.cli;

public enum Mode {
    ENCRYPT,
    DECRYPT,
    BRUTE_FORCE;

    public static Mode from(String value) {
        switch (value.toLowerCase()) {
            case "enc": return ENCRYPT;
            case "dec": return DECRYPT;
            case "bf": return BRUTE_FORCE;
            default:
                throw new IllegalArgumentException("Unknown mode: " + value + ". Use enc | dec | bf");
        }
    }
}
