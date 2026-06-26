package com.mycompany.progpoe;

import java.util.ArrayList;
import java.util.Iterator;

public class Part3MessageManager {

    private ArrayList<Part2Message> sentMessages = new ArrayList<>();
    private ArrayList<Part2Message> storedMessages = new ArrayList<>();
    private ArrayList<Part2Message> disregardedMessages = new ArrayList<>();
    private ArrayList<String> messageHashes = new ArrayList<>();
    private ArrayList<String> messageIDs = new ArrayList<>();

    public void addMessage(Part2Message message, String flag) {
        switch (flag.toLowerCase()) {
            case "sent":

                sentMessages.add(message);
                break;

            case "stored":

                storedMessages.add(message);
                break;

            case "disregarded":

                disregardedMessages.add(message);
                break;

        }//end switch-case

        messageHashes.add(message.createMessageHash());
        messageIDs.add(message.getMessageID());
    }//end addMessage

    public void displayStoredMessages() {
        for (Part2Message msg : storedMessages) {
            System.out.println("Developer -> " + msg.getRecipient());
        }//end for1
    }//end displayStoredMessages

    public String longestStoredMessage() {

        String longest = "";

        for (Part2Message msg : storedMessages) {
            if (msg.getMessage().length() > longest.length()) {
                longest = msg.getMessage();

            }//end if1
        }//end for 1
        return longest;
    }//end longestStoredMessage

    public String searchMessageID(String id) {
        for (Part2Message msg : sentMessages) {
            if (msg.getMessageID().equals(id)) {
                return msg.getMessage();

            }//end if1
        }//end for 1
        return "Message not found.";
    }//end searchMessageID

    public ArrayList<String> searchRecipient(String recipient) {
        ArrayList<String> results = new ArrayList<>();
        for (Part2Message msg : storedMessages) {
            if (msg.getRecipient().equals(recipient)) {
                results.add(msg.getMessage());

            }//end if1
        }//end for1
        return results;
    }//end searchRecipient

    public String deleteMessage(String hash) {
        Iterator<Part2Message> iterator = storedMessages.iterator();
        while (iterator.hasNext()) {
            Part2Message msg = iterator.next();
            if (msg.createMessageHash().equals(hash)) {
                iterator.remove();
                return "Message: \"" + msg.getMessage() + "\" successfully deleted.";

            }//end if1
        }//end while
        return "Message not found.";
    }//end deleteMessage

    public String displayReport() {
        String report = "";
        for (Part2Message msg : sentMessages) {

            report
                    += "Hash: "
                    + msg.createMessageHash()
                    + "\nRecipient: "
                    + msg.getRecipient()
                    + "\nMessage: "
                    + msg.getMessage()
                    + "\n\n";

        }//end for1
        return report;
    }//end displayreport

}//end class
