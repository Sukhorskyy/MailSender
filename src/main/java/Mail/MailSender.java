package Mail;


public class MailSender {
    public String sendMail(MailInfo info) {
        return "Message is sent:\n---\n" + info.getMailText() + "\n---\nReceiver: " + info.getEmail();
    }
}
