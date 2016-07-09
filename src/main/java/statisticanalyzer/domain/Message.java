package statisticanalyzer.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Igor on 24.06.2016.
 */
public class Message {
    @Getter
    @Setter
    String name;
    String text;

    public Message(String name, String text) {
        this.name = name;
        this.text = text;
    }
}
