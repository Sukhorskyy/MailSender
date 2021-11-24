package Mail;

import lombok.Getter;
import java.util.LinkedList;
import java.util.List;

@Getter
public class MailBox {
    private List<MailInfo> infos = new LinkedList<MailInfo>();

    public void addMailInfo(MailInfo info) {
        infos.add(info);
    }
    
    public String sendAll() {
        String receivers = "All messages are sent. Receivers:";
        MailSender sender = new MailSender();
        for (int i = 0; i < infos.size(); i++) {
            sender.sendMail(infos.get(i));
            receivers += "\n" + infos.get(i).getEmail();
        }
        infos.clear();
        return receivers;
    }
}
