package com.mycompany.progpoe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class Part3MessageManagerTest {

    @Test
    public void testSentMessagesArray() {
        Part3MessageManager manager = new Part3MessageManager();

        Part2Message msg1 = new Part2Message(
                0, "+27834557896", "Did you get the cake?");
        Part2Message msg2 = new Part2Message(
                1, "0838884567", "It is dinner time!");

        manager.addMessage(msg1, "Sent");
        manager.addMessage(msg2, "Sent");

        String report = manager.displayReport();

        assertTrue(report.contains("Did you get the cake?"));
        assertTrue(report.contains("It is dinner time!"));
    }//end test1

    @Test
    public void testLongestStoredMessage() {
        Part3MessageManager manager = new Part3MessageManager();

        manager.addMessage(new Part2Message(0, "+27838884567", "Where are you? You are late! I have asked you to be on time."),
                "Stored");
        manager.addMessage(new Part2Message(1, "+27838884567", "OK, I am leaving without you."),
                "Stored");

        assertEquals("Where are you? You are late! I have asked you to be on time.", manager.longestStoredMessage());
    }//end test 2

    @Test
    public void testSearchMessageID() {
        Part3MessageManager manager = new Part3MessageManager();

        Part2Message msg = new Part2Message(0, "0838884567", "It is dinner time!");
        manager.addMessage(msg, "Sent");

        assertEquals("It is dinner time!", manager.searchMessageID(msg.getMessageID()));
    }//end test 3

    @Test
    public void testSearchRecipient() {
        Part3MessageManager manager = new Part3MessageManager();

        manager.addMessage(new Part2Message(0, "+27838884567", "Where are you? You are late! I have asked you to be on time."),
                "Stored");

        manager.addMessage(new Part2Message(1, "+27838884567", "Ok, I am leaving without you."),
                "Stored");

        ArrayList<String> results = manager.searchRecipient("+27838884567");

        assertTrue(results.contains("Where are you? You are late! I have asked you to be on time."));
        assertTrue(results.contains("Ok, I am leaving without you."));

    }//end test 4

    @Test
    public void testDeleteMessage() {

        Part3MessageManager manager = new Part3MessageManager();

        Part2Message msg = new Part2Message(0, "+27838884567", "Where are you? You are late! I have asked you to be on time.");

        manager.addMessage(msg, "Stored");

        assertEquals("Message: \"Where are you? You are late! I have asked you to be on time.\" succesfully deleted.",
                manager.deleteMessage(msg.createMessageHash()));
    }//end test 5

    @Test
    public void testDisplayReport() {

        Part3MessageManager manager = new Part3MessageManager();

        Part2Message msg = new Part2Message(0, "+27834557896", "Did you get the cake?");

        manager.addMessage(msg, "Sent");

        String report = manager.displayReport();

        assertTrue(report.contains(msg.createMessageHash()));
        assertTrue(report.contains("+27834557896"));
        assertTrue(report.contains("Did you get the cake?"));
    }//end test 6

}//end class
