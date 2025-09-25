package mv.sdd;

import mv.sdd.facturation.Client;
import mv.sdd.facturation.NomCoparator;
import mv.sdd.facturation.SoldeComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<Client> clients = new ArrayList<>();

        Client client1 = new Client(100, "Giles", "Brade", 985000.0);
        Client client2 = new Client(200, "Alain", "Alain", 87000.0);
        Client client3 = new Client(400, "Martin", "Martin", 500);
        Client client4 = new Client(300, "Bob", "Bob", 12650);

        clients.add(client1);
        clients.add(client2);
        clients.add(client3);
        clients.add(client4);

        System.out.println(clients);

        Collections.sort(clients);
        System.out.println(clients);

        Collections.sort((clients), new NomCoparator());
        System.out.println(clients);
        Collections.sort((clients), new SoldeComparator());
        System.out.println(clients);

        Collections.reverse(clients);
        System.out.println(clients);
    }
}
