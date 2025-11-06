package mv.sdd;

public class SeriePoo {
    public static final float TAUX_TAXE_PROV = 9.975f;
    public static final float TAUX_TAXE_FED = 5.0f;

    public static void main(String[] args) {
        exercice1();
    }

    public static void exercice1(){
        String chaine = "A-b-C-d-E-f-1234-***///->";
        System.out.println(chaineMajToMin(chaine));
        System.out.println(chaineMinToMaj(chaine));
    }

    public static String chaineMajToMin(String chaine){
        String chaineTrans = "";

        for (int i = 0; i < chaine.length(); i++) {
            char caract = chaine.charAt(i);
            if(Character.isUpperCase(caract)){
                caract = Character.toLowerCase(caract);
            }
            chaineTrans += caract;
        }

        return chaineTrans;
    }

    public static String chaineMinToMaj(String chaine){
        String chaineTrans = "";

        for (int i = 0; i < chaine.length(); i++) {
            char caract = chaine.charAt(i);
            if(Character.isLowerCase(caract)){
                caract = Character.toUpperCase(caract);
            }
            chaineTrans += caract;
        }

        return chaineTrans;
    }

    public static String chaineSansCharSpeciaux(String chaine){
        String chaineTrans = "";

        for (int i = 0; i < chaine.length(); i++) {
            if(Character.isAlphabetic(chaine.charAt(i))
                    || Character.isDigit(chaine.charAt(i))){
                chaineTrans += chaine.charAt(i);
            }
        }

        return chaineTrans;
    }

    public static double claculerTaxesVente(double montant, boolean appliqueTaxeProv, boolean appliqueTaxeFed){
        if(montant < 0)
            throw new IllegalArgumentException();
        if (montant == 0)
            return 0;
        float taux = 0f;
        if(appliqueTaxeProv)
            taux += TAUX_TAXE_PROV;
        if(appliqueTaxeFed)
            taux += TAUX_TAXE_FED;
        montant *= (1 + taux / 100);
        return montant;
    }
}
