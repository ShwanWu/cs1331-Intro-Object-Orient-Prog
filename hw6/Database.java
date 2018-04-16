import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Predicate;

/**
 * Class for a Database!
 *
 * @author ywu672
 * @version 1.0
 */
public class Database {

    /**
     * A list called messages of Message.
     */
    private List<Message> messages;

    /**
     * Define an inner class that will be used to instantiate a Predicate
     * that is used to test a Message contains a keyword or not.
     */
    static class MyPredicate implements Predicate<Message> {

        private String key;

        // constructor for Mypredicate
        MyPredicate(String key) {
            this.key = key;
        }

        // Override the test method
        @Override
        public boolean test(Message t) {
            return t.getBody().contains(key);
        }
    }

    /**
     * Constructor method for a Database.
     * @param messages a list of Message.
     */
    public Database(List<Message> messages) {
        this.messages = messages;
    }

    /**
     * Getter method for Message with specified index.
     * @param n the index of Message.
     * @return the nth message where 0 <= n < size of list.
     */
    public Message getMessage(int n) throws IndexOutOfBoundsException{
        return messages.get(n);
    }

    /**
     * Getter method for the current list of Message.
     * @return current list of Message.
     */
    public List<Message> getMessages() {
        return messages;
    }

    /**
     * filter method that return the messages that satisfy the Predicate
     * ignorant of predicate's test(T t) implementation
     * @param filter user-defined Predicate
     * @return the messages that satisfy the Predicate
     */
    public List<Message> filter(Predicate<Message> filter) {

        List<Message> temp = new ArrayList<>();
        for(Message ele : this.messages) {
            temp.add(ele);
        }
        for(int i=0; i<temp.size(); i++) {
            if(!filter.test(temp.get(i))) {
                temp.remove(temp.get(i));
            }
        }
        return temp;
    }

    /**
     * Getter method that return the messages is sent between the
     * start LocalDateTime and the end LocalDateTime (inclusive）
     * Use Lambda expression.
     * @param start start bound time
     * @param end end bound of time
     * @return a list of the messages that satisfy
     */
    public List<Message> getMessagesBetween(LocalDateTime start, LocalDateTime end) {
        return this.filter((Message t) -> {
                return t.getDate().compareTo(start) >= 0
                      && t.getDate().compareTo(end) <= 0;
         });
    }

    /**
     * Sort method that return a map of messages.
     * Using an anonymous inner class
     * @return a map of messages that is sort by contactName
     */
    public Map<String, List<Message>> sortMessagesByContact() {

        Map<String, List<Message>> tempMap = new IdentityHashMap<>();
        List<Optional<String>> contactNameList1 = new ArrayList<>();
        List<Optional<String>> contactNameList2 = new ArrayList<>();

        // return a contactName list(repeated) of messages.
        for (int i = 0; i < this.messages.size(); i++) {
            contactNameList1.add(this.messages.get(i).getContactName());
        }
        // return a contactName list(unrepeated) of messages.
        // find those Message of first occurrence and add to tempList
        for (int i = 0; i < contactNameList1.size(); i++) {
            Optional<String> name = contactNameList1.get(i);
            if (contactNameList1.indexOf(name) == i) {
                contactNameList2.add(name);
            }
        }
        System.out.println(contactNameList2);
        for (Optional<String> a : contactNameList2) {
            System.out.println(a);
            if (a.toString() != null) {
                tempMap.put(a.toString(), this.filter(new Predicate<Message>() {
                    public boolean test(Message t) {
                        return t.getContactName().toString().equals(a.toString());
                    }
                }));
            }
        }
        return tempMap;
    }

    /**
     * Getter method that return the messages with specified keyword
     * Use inner class
     * @param keyword the word that the Message may contain
     * @return a list of the messages that satisfy
     */
    public List<Message> getMessagesWithKeyword (String keyword) {
        return this.filter(new MyPredicate(keyword));
    }

    /**
     * Getter method that return the messages that is important
     * Use method reference
     * @return a list of the messages that satisfy
     */
    public List<Message> getMessagesWithPriority() {
        return this.filter(Message::getIsImportant);
    }

}