/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.AdminRole;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
/**
 *
 * @author Harshitha
 */
public class JavaApplication14 {

    /**
     * @param args the command line arguments
     */
    private static String USER_NAME = "medexsystem";  // GMail user name (just the part before "@gmail.com")
    private static String PASSWORD =  "AEDhuskies"; // GMail password
    private static String RECIPIENT = "***";
   // private String email;
    
    public JavaApplication14(String email,String user,String password) {
        // TODO code application logic here
   
        String from = USER_NAME;
        String pass = PASSWORD;
       // this.email=email;
       // String[] to = { "harshuss94@gmail.com","harshithasomasundar@gmail.com" }; 
        String[] to = {email};
        String subject = "Registration has been approved !! Happy Shopping ";
        String body = "Welcome to Doctor's \n The admin has approved ur registration \n You can login to view the best produts \n your USERNAME : "+ user+ "  PASSWORD : "+ password+ "\n please use the following to login";

        sendFromGMail(from, pass, to, subject, body);
    }
    
    public JavaApplication14(String email,String type) {
        // TODO code application logic here
   
        String from = USER_NAME;
        String pass = PASSWORD;
       // this.email=email;
       // String[] to = { "harshuss94@gmail.com","harshithasomasundar@gmail.com" }; 
        String[] to = {email};
        if(type.equals("Supplier"))
             {
                 
                 String subject = "Order has been Shipped !!";
        String body = "Your order has been sent to ThirdParty \n You will recieve a mail once it has been dispatched \n Thank you!!";
        sendFromGMail(from, pass, to, subject, body);
       
        }
        else
        {
              String subject = "Order has been Dispatched !!";
        String body = "Your order has been dispatched and picked by or delivery system in   In few days should be near your doorStep \n Till then Happy Shooping \n Thank you!!";
        sendFromGMail(from, pass, to, subject, body);
        }
    }

    private static void sendFromGMail(String from, String pass, String[] to, String subject, String body) {
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for( int i = 0; i < to.length; i++ ) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }
}
    
    

