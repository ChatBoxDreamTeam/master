package org.DreamTeam;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilisateurTest {
    Utilisateur testUser = new Utilisateur("Manolo");
    @Test
    void getPseudo() {
        assertEquals("Manolo", testUser.getPseudo());
    }


    @Test
    void getCouleurChat() {
        assertEquals("49AA31", testUser.getCouleurChat());
    }


    @Test
    void isValidHexaCode() {
        assertEquals(true, testUser.isValidHexaCode("22BABA"));
    }
}