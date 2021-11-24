package Mail;

import Client.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MailBoxTest {
    MailInfo mailInfo1;
    MailInfo mailInfo2;
    Client client1;
    Client client2;
    MailBox mailBox;

    @BeforeEach
    void setUp() {
        mailInfo1 = new MailInfo();
        client1 = new Client("arman@ucu.edu.ua", "Arman");
        mailInfo1.setClient(client1);
        mailInfo1.setMailCode(MailCode.GREETINGS);
        mailInfo2 = new MailInfo();
        client2 = new Client("alice@ucu.edu.ua", "Alice");
        mailInfo2.setClient(client2);
        mailInfo2.setMailCode(MailCode.HAPPY_BIRTHDAY);
    }

    @Test
    void testBoxSender() {
        mailBox = new MailBox();
        mailBox.addMailInfo(mailInfo1);
        mailBox.addMailInfo(mailInfo2);
        String expected = "All messages are sent. Receivers:\n" +
                "arman@ucu.edu.ua\n" +
                "alice@ucu.edu.ua";
        String actual = mailBox.sendAll();
        assertEquals(expected, actual);
    }
}