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
import java.util.*;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Multipart;
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
 
public class inboxopen {
 
    private String userName;
    private String password;
    private String sendingHost;
    private int sendingPort;
   String[] from;
   String to;
   String[] subject;
    String[] text;
 int x;

    private String receivingHost;
//    private int receivingPort;
    inboxopen()
    {
          
      this.userName="bluepearl273@gmail.com";//sender's email can also use as User Name
        this.password="bluepearl123";   
    }
 
    
    
    public void readGmail(){

        /*this will print subject of all messages in the inbox of sender@gmail.com*/
 
        this.receivingHost="imap.gmail.com";//for imap protocol
 
        Properties props2=System.getProperties();
 
        props2.setProperty("mail.store.protocol", "imaps");
        // I used imaps protocol here
 
        Session session2=Session.getDefaultInstance(props2, null);

            try {
 
                    Store store=session2.getStore("imaps");
 
                    store.connect(this.receivingHost,this.userName, this.password);
 
                    Folder folder=store.getFolder("INBOX");//get inbox
 
                    folder.open(Folder.READ_ONLY);//open folder only to read
 
                    Message message[]=folder.getMessages();
                     x=message.length;
                     System.out.println(x);
                    for(int i=0;i<message.length;i++){
 
                        //print subjects of all mails in the inbox
                       
                         
                        
                       
 Object content = message[i].getContent();
    String contentReturn = null;
    Multipart multipart = (Multipart) content;
        BodyPart part = multipart.getBodyPart(0);
        part.toString();
        contentReturn = part.getContent().toString();
                        
                        
                    }
 
                    //close connections
 
                    folder.close(true);
 
                    store.close();
 
            } catch (Exception e) {
 
                    System.out.println(e.toString());
 
            }

    }
 public static void main(String[] args) 
 {
     inboxopen i=new inboxopen();
     i.readGmail();
 }

} 
    
