//task-10
import java.util.ArrayList;
import java.util.List;

class NewsletterPublisher {
    private List<Subscriber> subscribers = new ArrayList<>();

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void publishNewsletter(String content) {
        for (Subscriber subscriber : subscribers) {
            subscriber.receiveNewsletter(content);
        }
    }
}

interface Subscriber {
    void receiveNewsletter(String content);
}

class EmailSubscriber implements Subscriber {
    private String email;

    public EmailSubscriber(String email) {
        this.email = email;
    }

    @Override
    public void receiveNewsletter(String content) {
        System.out.println("Email sent to " + email + ": " + content);
    }
}

public class ObserveMain {
    public static void main(String[] args) {
        NewsletterPublisher publisher = new NewsletterPublisher();

        Subscriber subscriber1 = new EmailSubscriber("subscriber1@example.com");
        Subscriber subscriber2 = new EmailSubscriber("subscriber2@example.com");

        publisher.subscribe(subscriber1);
        publisher.subscribe(subscriber2);

        publisher.publishNewsletter("New newsletter is out!");
    }
}
