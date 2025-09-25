package mv.sdd.io.json.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import mv.sdd.facturation.Client;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ClientJsonService {

    public void writeObjet(Client client, String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        // Conversion Objet → JSON
        mapper.writeValue(new FileOutputStream(path), client);
    }

    public void writeList(List<Client> clients, String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        mapper.writeValue(new FileOutputStream(path),
                clients);
    }

    // TODO: Add readObjet

    // TODO: Add readList

}
