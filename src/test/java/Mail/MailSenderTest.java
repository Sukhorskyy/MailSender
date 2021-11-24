package Mail;

import Client.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MailSenderTest {
    MailInfo mailInfo;
    Client client;
    MailSender mailSender;

    @BeforeEach
    void setUp() {
        mailInfo = new MailInfo();
        client = new Client("arman@ucu.edu.ua", "Arman");
        mailInfo.setClient(client);
        mailSender = new MailSender();
    }

    @Test
    void testSendGreeting() {
        mailInfo.setMailCode(MailCode.GREETINGS);
        String expected = ("Message is sent:\n" +
                "---\n" +
                "Dear Arman,\n" +
                "I hope you're doing well.\n" +
                "Sorry I haven't been in touch for such a long time but\n" +
                "I've had exams so I've been studying every free minute.\n" +
                "Anyway, I'd love to hear all your news and I'm hoping we\n" +
                "can get together soon to catch up.\n" +
                "\n" +
                "All the best,\n" +
                "---\n" +
                "Receiver: arman@ucu.edu.ua").replaceAll("\n", "");
        String actual = mailSender.sendMail(mailInfo).replaceAll("\n", "").replaceAll("\r", "");
        assertEquals(expected, actual);
    }

    @Test
    void testSendHappyBirthday() {
        mailInfo.setMailCode(MailCode.HAPPY_BIRTHDAY);
        String expected = ("Message is sent:\n" +
                "---\n" +
                "Dear Arman,\n" +
                "Happy Birthday!\n" +
                "\n" +
                "Wishing you a day filled with happiness and a year filled with joy.\n" +
                "I can not believe how lucky I am to have found a friend like you!\n" +
                "---\n" +
                "Receiver: arman@ucu.edu.ua").replaceAll("\n", "");
        String actual = mailSender.sendMail(mailInfo).replaceAll("\n", "").replaceAll("\r", "");
        assertEquals(expected, actual);
    }

}