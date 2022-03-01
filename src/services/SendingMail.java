/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

/**
 *
 * @author sarawahada
 */

import java.util.Properties;

import javax.mail.Session;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage;


public class SendingMail 
{
    

    public static void send(String recepient,int mot) throws MessagingException 
    {
        System.out.println("Preparing Send email");
        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");	
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        String myAccountEmail ="efoodappproject@gmail.com";
        String password ="EfoodAppPiDEV";
        Session session = Session.getDefaultInstance(props,new Authenticator() 
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() 
            {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
            Message message = prepareMessage(session,myAccountEmail,recepient,mot);
            Transport.send(message);
            System.out.println("message sent");
    }

    private static Message prepareMessage(Session session,String myAccountEmail,String recepient,int mot) throws AddressException, MessagingException {
       
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("password reset");
            message.setText(mot+" your verification code");
            return message;
    }
        public static void sendSignUp(String recepient) throws MessagingException 
    {
        System.out.println("Preparing Send email");
        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");	
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        String myAccountEmail ="efoodappproject@gmail.com";
        String password ="EfoodAppPiDEV";
        Session session = Session.getDefaultInstance(props,new Authenticator() 
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() 
            {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
            Message message = prepareMessageSignUp(session,myAccountEmail,recepient);
            Transport.send(message);
            System.out.println("message sent");
    }

    private static Message prepareMessageSignUp(Session session,String myAccountEmail,String recepient) throws AddressException, MessagingException {
       
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Account created");
            message.setText("Welcome to Efood !");
            return message;
    }
         public static void sendPasswordReset(String recepient) throws MessagingException 
    {
        System.out.println("Preparing Send email");
        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");	
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        String myAccountEmail ="efoodappproject@gmail.com";
        String password ="EfoodAppPiDEV";
        Session session = Session.getDefaultInstance(props,new Authenticator() 
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() 
            {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
            Message message = prepareMessagePasswordReset(session,myAccountEmail,recepient);
            Transport.send(message);
            System.out.println("message sent");
    }

    private static Message prepareMessagePasswordReset(Session session,String myAccountEmail,String recepient) throws AddressException, MessagingException {
       
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Password reset");
            message.setText("Your password was reset successfully");
            return message;
    }
            public static void sendAccountModified(String recepient) throws MessagingException 
    {
        System.out.println("Preparing Send email");
        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");	
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        String myAccountEmail ="efoodappproject@gmail.com";
        String password ="EfoodAppPiDEV";
        Session session = Session.getDefaultInstance(props,new Authenticator() 
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() 
            {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
            Message message = prepareMessageAccountModified(session,myAccountEmail,recepient);
            Transport.send(message);
            System.out.println("message sent");
    }

    private static Message prepareMessageAccountModified(Session session,String myAccountEmail,String recepient) throws AddressException, MessagingException {
       
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Account modified ");
            message.setText("Your account was modified successfully");
            return message;
    }
}