package com.mycompany.progpoe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Part2MessageTest {

    @Test
    public void testMessageLengthSuccess() {

        Part2Message msg
                = new Part2Message(
                        0, "+27718693002", "Hi mike, can you join us for dinner tonight?");

        assertEquals(
                "Messge ready to send",
                msg.checkMessageLength());
    }//end test 1

    @Test
    public void testRecipientSuccess() {

        Part2Message msg
                = new Part2Message(
                        0, "+27718693002", "Hi Mike");

        assertEquals(
                "Cell hpone number successfully captured.",
                msg.checkRecipientCell());

    }//end test 2

    @Test
    public void testRecipientFailure() {

        Part2Message msg
                = new Part2Message(
                        0, "08575975889", "Hi Mike");

        assertEquals(
                "Cell phone is incorrectly formatted or does not contain an international code. Please correct the number and try again.",
                msg.checkRecipientCell());

    }//end test 3

    @Test
    public void testMessageIDCreated() {

        Part2Message msg
                = new Part2Message(
                        0, "+27718693002", "Hi Mike");

        assertTrue(msg.checkMessageID());
    }//end test 4

    @Test
    public void testSendMessage() {

        Part2Message msg
                = new Part2Message(
                        0, "+27718693002", "Hi Mike");

        assertEquals(
                "Message successfully sent.",
                msg.sendMessage(1));
    }//end test 5

    @Test
    public void testDisregardedMessage() {

        Part2Message msg
                = new Part2Message(
                        0, "+27718693002", "Hi Mike");

        assertEquals(
                "Press 0 to delete the message.",
                msg.sendMessage(2));
    }//end test 6

    @Test
    public void testStoreMessage() {

        Part2Message msg
                = new Part2Message(
                        0, "+27718693002", "Hi Mike");

        assertEquals(
                "Message successfully stored.",
                msg.sendMessage(3));
    }//end test 7
}//end class
