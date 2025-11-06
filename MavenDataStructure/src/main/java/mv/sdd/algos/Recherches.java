package mv.sdd.algos;

public class Recherches {
    public static void main(String[] args) {

    }

    public static int rechercheLineaire(int[] tab, int valeur) {
        for (int i = 0; i < tab.length; i++)
            if (tab[i] == valeur) return i;
        return -1;
    }

    /**
     * 
     * @param tab
     * @param valeur
     * @return
     */
    public static int rechercheBinaire(int[] tab, int valeur) {
        int debut = 0;
        int fin = tab.length - 1;
        int milieu;

        while (debut < fin){
            milieu = (debut + fin) / 2;
            if(tab[milieu] == valeur){
                return milieu;
            } else if (tab[milieu] < valeur) {
                debut = milieu + 1;
            } else {
                fin = milieu - 1;
            }
        }
        return -1;
    }
}
