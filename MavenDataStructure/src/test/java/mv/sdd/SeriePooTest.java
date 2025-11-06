package mv.sdd;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class SeriePooTest {

    @Test
    @DisplayName("Convertir une chaine en miniscule")
    void chaineMajToMin() {
        String resultat = SeriePoo.chaineMajToMin("Bonjour!");
        assertEquals("bonjour!", resultat);
    }

    @Test
    @DisplayName("Convertir une chaine en majuscule")
    void chaineMinToMaj() {
        String resultat = SeriePoo.chaineMinToMaj("Bonjour!");
        assertEquals("BONJOUR!", resultat);
    }

    @Test
    @DisplayName("Test avec chaine contient des caractères spéciaux et lettres")
    void chaineAlphabSansCharSpeciaux() {
        String resultat = SeriePoo.chaineSansCharSpeciaux("Bonj@u%r!");
        assertEquals("Bonjur", resultat);
    }

    @Test
    @DisplayName("Test avec chaine contient des caractères spéciaux, des lettres et des chiffres")
    void chaineAlphNumSansCharSpeciaux(){
        String resultat = SeriePoo.chaineSansCharSpeciaux("Bonjour2!");
        assertEquals("Bonjour2", resultat);
    }

    @Test
    @DisplayName("Rejette le calule pour un montant négatif")
    void claculerTaxesVenteMontantNegatif(){
        assertThrows(IllegalArgumentException.class, ()-> SeriePoo.claculerTaxesVente(-100, false, false));
    }

    @Test
    @DisplayName("Montant nul retourne 0")
    void claculerTaxesVenteMontantNull(){
        double resultat = SeriePoo.claculerTaxesVente(0, true, true);
        assertEquals(0, resultat);
    }

    @Test
    @DisplayName("Montant positif sans aucune taxe")
    void claculerTaxesVenteMontantPositifSansTaxes(){
        double resultat = SeriePoo.claculerTaxesVente(100, false, false);
        assertEquals(100, resultat);
    }

    @Test
    @DisplayName("Montant positif avec les 2 taxes")
    void claculerTaxesVenteMontantPositifAvecDeuxTaxes(){
        double resultat = SeriePoo.claculerTaxesVente(100, true, true);
        assertEquals(114.97, resultat, 0.01);
    }

    @Test
    @DisplayName("Montant positif avec taxe provinciale")
    void claculerTaxesVenteMontantPositifAvecTaxeProv(){
        double resultat = SeriePoo.claculerTaxesVente(100, true, false);
        assertEquals(109.97, resultat, 0.01);
    }

    @Test
    @DisplayName("Montant positif avec taxe fédérale")
    void claculerTaxesVenteMontantPositifAvecTaxeFed(){
        double resultat = SeriePoo.claculerTaxesVente(100, false, true);
        assertEquals(105.00, resultat, 0.01);
    }
}