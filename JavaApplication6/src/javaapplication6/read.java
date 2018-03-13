/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;

/**
 *
 * @author chandan
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chandan
 */
import java.util.*;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
 
/**
 *
 * @author BUDDHIMA
 */
 
public class read{
 
    private String userName;
    private String password;
    private String sendingHost;
    private int sendingPort;
    private String from;
    private String to;
    private String subject;
    private String text;
    private String receivingHost;
//    private int receivingPort;
 
    read()
    {
        this.userName="bluepearl273@gmail.com";
        this.password="bluepearl123";
    }
 
    public void sendGmail(String from, String to, String subject, String text){
 
         // This will send mail from -->sender@gmail.com to -->receiver@gmail.com
 
        this.from=from;
        this.to=to;
        this.subject=subject;
        this.text=text;
 
        // For a Gmail account--sending mails-- host and port shold be as follows
 
        this.sendingHost="smtp.gmail.com";
        this.sendingPort=465;
 
        Properties props = new Properties();
 
        props.put("mail.smtp.host", this.sendingHost);
        props.put("mail.smtp.port", String.valueOf(this.sendingPort));
        props.put("mail.smtp.user", this.userName);
        props.put("mail.smtp.password", this.password);
 
        props.put("mail.smtp.auth", "true");
 
         Session session1 = Session.getDefaultInstance(props);
 
         Message simpleMessage = new MimeMessage(session1);
 
        //MIME stands for Multipurpose Internet Mail Extensions
 
        InternetAddress fromAddress = null;
        InternetAddress toAddress = null;
 
        try {
 
            fromAddress = new InternetAddress(this.from);
            toAddress = new InternetAddress(this.to);
 
        } catch (AddressException e) {
 
            e.printStackTrace();
 
                       JOptionPane.showMessageDialog(null, "Sending email to: " + to + " failed !!!", "Falied to Send!!!", JOptionPane.ERROR_MESSAGE);
 
        }
 
        try {
 
            simpleMessage.setFrom(fromAddress);
 
            simpleMessage.setRecipient(RecipientType.TO, toAddress);
 
                        // to add CC or BCC use
                        // simpleMessage.setRecipient(RecipientType.CC, new InternetAddress("CC_Recipient@any_mail.com"));
                        // simpleMessage.setRecipient(RecipientType.BCC, new InternetAddress("CBC_Recipient@any_mail.com"));
 
            simpleMessage.setSubject(this.subject);
 
            simpleMessage.setText(this.text);
 
        //sometimes Transport.send(simpleMessage); is used, but for gmail it's different
 
            Transport transport = session1.getTransport("smtps");
 
            transport.connect (this.sendingHost,sendingPort, this.userName, this.password);
 
            transport.sendMessage(simpleMessage, simpleMessage.getAllRecipients());
 
            transport.close();
 
            JOptionPane.showMessageDialog(null, "Mail sent successfully ...","Mail sent",JOptionPane.PLAIN_MESSAGE);
 
        } catch (MessagingException e) {
 
            e.printStackTrace();
 
                       JOptionPane.showMessageDialog(null, "Sending email to: " + to + " failed !!!", "Falied to Send!!!", JOptionPane.ERROR_MESSAGE);
 
        }
 
    }

 
}