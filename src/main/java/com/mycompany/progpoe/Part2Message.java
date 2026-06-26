package com.mycompany.progpoe;

import java.util.Random;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class Part2Message {

    private String messageID;
    private int messageNumber;
    private String recipient;
    private String message;
    private static int totalMessages = 0;
    private static ArrayList<String> sentMessages = new ArrayList<>();

    public Part2Message(int messageNumber, String recipient, String message) {
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.message = message;

        Random rand = new Random();

        long id = 1000000000L + (long) (rand.nextDouble() * 9000000000L);

        this.messageID = String.valueOf(id);
    }//end constructor

    public boolean checkMessageID() {
        return messageID.length() <= 10;

    }//end checkMessageID

    public String checkRecipientCell() {
        if (recipient.matches("^\\+27\\d{9}$")) {
            return "Cell phone number successfully captured.";
        }//end if1

        return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
    }//end checkRecipientCell

    public String checkMessageLength() {
        if (message.length() <= 250) {
            return "Message ready to send";

        }//end if1
        int excess = message.length() - 250;
        return "Message exceeds 250 characters by " + excess + "; please reduce the size.";
    }//end checkMessageLength

    public String createMessageHash() {
        String[] words = message.split(" ");

        String firstWord = words[0];
        String lastWord = words[words.length - 1];

        return messageID.substring(0, 2)
                + ":"
                + messageNumber
                + ":"
                + (firstWord + lastWord).toUpperCase();
    }//end createMessageHash

    public String sendMessage(int option) {
        switch (option) {
            case 1:
                totalMessages++;
                sentMessages.add(printMessages());
                return "Message successfully sent.";

            case 2:
                return "Press 0 to delete the message.";

            case 3:
                storeMessage();
                return "Message successfully stored.";

            default:
                return "Invalid option.";

        }//end switch case
    }//end SendMessage

    public String printMessages() {
        return "Message ID: "
                + messageID
                + "\nMessage Hash: "
                + createMessageHash()
                + "\nRecipient: "
                + recipient
                + "\nMessage: "
                + message;

    }//end printMessages

    public int returnTotalMessages() {
        return totalMessages;
    }//end returnTotalMesssages

    public void storeMessage() {

        try {

            FileWriter writer = new FileWriter("storedMessages.json", true);

            writer.write(
                    "{\"MessageID\":\"" + messageID
                    + "\",\"Recipient\":\"" + recipient
                    + "\",\"Message\":\"" + message
                    + "\"}\n"
            );

            writer.close();

        } catch (IOException e) {
            System.out.println("Error storing message. ");

        }//end try-catch

    }//end storeMessage

    public String getMessageID() {
        return messageID;
    }//end getMessageID

    public String getRecipient() {
        return recipient;
    }//end getRecipient

    public String getMessage() {
        return message;
    }//end getMessage

}//end class
