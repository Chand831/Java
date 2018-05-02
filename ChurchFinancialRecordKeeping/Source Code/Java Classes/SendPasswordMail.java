/*
 Class Name  : SendPasswordMail
 Description : It will send password to the user in case of user click on forgot password.
 */


package church.finance;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

public class SendPasswordMail {    
    String d_email = "tokalanandakishore@gmail.com";
    String d_password = "08647213139"; //your email password
    String d_host = "smtp.gmail.com";
    String d_port = "465";
    String m_to; // Target email address
    String  m_subject = " Password ";
    String m_text;
    
    public SendPasswordMail(String m_to,String m_text) {
    	this.m_to = m_to;
    	this.m_text = m_text;
        Properties props = new Properties();
        props.put("mail.smtp.user", d_email);
        props.put("mail.smtp.host", d_host);
        props.put("mail.smtp.port", d_port);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        //props.put("mail.smtp.debug", "true");
        props.put("mail.smtp.socketFactory.port", d_port);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        try {
            Authenticator auth = new SMTPAuthenticator();
            Session session = Session.getInstance(props, auth);     
            MimeMessage msg = new MimeMessage(session);
            m_text = "Hi, Your password is : " + m_text;
            msg.setText(m_text);
            msg.setSubject(m_subject);
            msg.setFrom(new InternetAddress(d_email));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(m_to));
            Transport.send(msg);
        } catch (Exception mex) {
            mex.printStackTrace();
        }
    }
   
    /*public static void main(String[] args) {
        JavaMail blah = new JavaMail();
    }*/
  
    private class SMTPAuthenticator extends javax.mail.Authenticator {
        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(d_email, d_password);
        }
    }
}

