package statisticanalyzer.domain;

/**
 * Created by Igor on 24.06.2016.
 */
public class Message {
    String name;
    String text;

    public Message(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }
}
