package org.DreamTeam;

import jdk.jshell.execution.Util;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DiscussionTest {
    Discussion testDiscussion = new Discussion();
    Utilisateur testUser = new Utilisateur("Manolo");
    Message testMessage = new Message();

    @Test
    void getTitre() {
        testDiscussion.setTitre("Discussion gaga");
        assertEquals("Discussion gaga", testDiscussion.getTitre());
    }

    @Test
    void getListeMembres() {
        assertEquals(Arrays.asList(), testDiscussion.getListeMembres());
    }

    @Test
    void getFileMessages() {
        assertEquals(Arrays.asList(), testDiscussion.getFileMessages());
    }

    @Test
    void addMembre() {
        assertEquals(true, testDiscussion.addMembre(testUser));
    }

    @Test
    void addMessage() {
        assertEquals(true, testDiscussion.addMessage(testMessage));
    }

    @Test
    void getCouleur() {
        testDiscussion.setCouleur(testUser.getCouleurChat());
        assertEquals("49AA31", testDiscussion.getCouleur());
    }

}