package ua.cryptograph.cli;

public final class CliCommand {

    private final Mode mode;
    private final String filePath;
    private final Integer shift;

    public CliCommand(Mode mode, String filePath, Integer shift) {
        this.mode = mode;
        this.filePath = filePath;
        this.shift = shift;
    }

    public Mode mode() {
        return mode;
    }

    public String filePath() {
        return filePath;
    }

    public Integer shift() {
        return shift;
    }
}

