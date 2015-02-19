package com.pmi.brick.utils;
 
import java.util.Properties;
 
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class Sender {
 
    private String username;
    private String password;
    private Properties props;
 
    public Sender(String username, String password) {
        this.username = username;
        this.password = password;
 
        props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
    }
 
    public void send(String subject, String text, String fromEmail, String toEmail){
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
 
        try {
            MimeMessage message = new MimeMessage(session);
            //�� ����
            message.setFrom(new InternetAddress(username));
            //����
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            //���������
            message.setSubject(subject);
            //��� ����, ����� setContent ���� ������ ���������� � html
            message.setContent(text,"text/html; charset=utf-8");
 
            //³���������
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}