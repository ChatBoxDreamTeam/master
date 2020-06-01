package org.DreamTeam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MessageTest {
    Message testMessage = new Message();
    Utilisateur testUser = new Utilisateur("Manolo");

    @BeforeEach
    void setUp() {
        testMessage.setAuthor(testUser);
        testMessage.setContent("Radio Gaga est ma chanson préférée de Queen");
        testMessage.setId(12);
        testMessage.setDate("2020-06-01");
    }

    @Test
    void testGetId() {
        assertEquals(12, testMessage.getId());
    }

    @Test
    void testGetContent() {
        assertEquals("Radio Gaga est ma chanson préférée de Queen", testMessage.getContent());
    }

    @Test
    void testGetDate() {
        assertEquals("2020-06-01", testMessage.getDate());
    }

    @Test
    void testGetAuthor() {
        assertEquals(testUser, testMessage.getAuthor());
    }
}