package com.extra;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.*;
import java.util.stream.Collectors;

public class MailTest {

    static final String senderName = "sender";
    static Map<String, String> people = new HashMap<>();
    static Map<String, String> allocated_sender = new HashMap<>();
    static Map<String, String> allocated_recipient = new HashMap<>();

    static {
        people.put("person_email", "person name");
    }

    public static void main(String[] args) {

        final String username = "email";
        final String password = "password";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        for (Map.Entry<String, String> currentSanta : people.entrySet()) {
            try {

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(username));
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(currentSanta.getKey()));
                message.setSubject("Secret Santa - 2017");
                message.setText(generateSecretSantaRecipient(currentSanta).toString());
                Transport.send(message);
                System.out.println("Done");

            } catch (MessagingException e) {
                throw new RuntimeException(e);

            }
        }
    }

    private static StringBuilder generateSecretSantaRecipient(Map.Entry<String, String> entry) {

        System.out.print(entry.getValue() + " -> ");
        allocated_sender.put(entry.getKey(), entry.getValue());

        Map<String, String> tempRecipient = people.entrySet().stream().filter(s -> !s.getKey().equals(entry.getKey())).collect(
                Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b)
        );

        List<String> recipients = tempRecipient.entrySet().stream().filter(entry1 -> !allocated_recipient.containsKey(entry1.getKey()))
                .map(entry1 -> entry1.getValue()).collect(Collectors.toList());

        Optional<Map.Entry<String, String>> recipient_to_exclude_next;
        int random = (int) (recipients.size() * Math.random());

        String realRecipient = recipients.get(random);

        recipient_to_exclude_next = people.entrySet().stream().filter(s -> s.getValue().equals(realRecipient))
                .findFirst();

        allocated_recipient.put(recipient_to_exclude_next.get().getKey(), recipient_to_exclude_next.get().getValue());

        StringBuilder sb = new StringBuilder("Hello ").append(entry.getValue()).append(",\n");
        sb.append(" You need to send your gift to ");
        sb.append(recipient_to_exclude_next.get().getValue());
        System.out.println(recipient_to_exclude_next.get().getValue());
        sb.append(".\n");
        sb.append("Regards,\n");
        sb.append(senderName);
        return sb;
    }
}
