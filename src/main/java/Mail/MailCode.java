package Mail;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public enum MailCode {
    HAPPY_BIRTHDAY("happy_birthday.txt"),
    GREETINGS("greetings.txt");

    private final String filename;

    MailCode(String filename) {
        this.filename = filename;
    }

    public String generateText() {
        String contents = null;
        Path path = Paths.get(filename);
        try {
            contents = Files.readString(path, StandardCharsets.ISO_8859_1);
        } catch (IOException ex) {
            System.out.println("No such template");
        }
        return contents;
    }
}
