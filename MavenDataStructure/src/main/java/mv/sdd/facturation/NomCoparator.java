package mv.sdd.facturation;

import java.util.Comparator;

public class NomCoparator implements Comparator<Client> {

    @Override
    public int compare(Client o1, Client o2) {
        return (o1.getNom() + " " + o1.getPrenom()).compareTo(o2.getNom() + " " + o2.getPrenom());
    }
}
