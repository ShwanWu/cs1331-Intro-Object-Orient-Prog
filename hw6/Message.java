import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Class for a Message!
 *
 * @author ywu672
 * @version 1.0
 */
public class Message {

    private Optional<String> contactName;
    private String to;
    private String from;
    private String body;
    private LocalDateTime date;
    private boolean isImportant;

    /**
     * Constructor method for a Message.
     * @param contactName the name of the Message.
     * @param to the target that the Message is sent to.
     * @param from the source that the Message is sent from.
     * @param body the message context.
     * @param date the time that the Message is sent and received.
     * @param isImportant whether the Message is important or not.
     */
    public Message(Optional<String> contactName,
                   String to, String from, String body,
                   LocalDateTime date, boolean isImportant){

        this.contactName = contactName;
        this.to = to;
        this.from = from;
        this.body = body;
        this.date = date;
        this.isImportant = isImportant;
    }

    /**
     * Getter method for contactName of Message .
     * @return contactName of Message.
     */
    public Optional<String> getContactName() {
        return this.contactName;
    }

    /**
     * Getter method for the target of Message .
     * @return target of Message.
     */
    public String getTo() {
        return this.to;
    }

    /**
     * Getter method for the source of Message .
     * @return source of Message.
     */
    public String getFrom() {
        return this.from;
    }

    /**
     * Getter method for the context of Message .
     * @return context of Message.
     */
    public String getBody() {
        return this.body;
    }

    /**
     * Getter method for the date of Message .
     * @return date of Message.
     */
    public LocalDateTime getDate() {
        return this.date;
    }

    /**
     * Getter method for whether the Message is important or not.
     * @return whether the Message is important or not.
     */
    public boolean getIsImportant() {
        return this.isImportant;
    }

}