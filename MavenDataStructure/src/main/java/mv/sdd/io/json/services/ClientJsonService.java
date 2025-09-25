package mv.sdd.io.json.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import mv.sdd.facturation.Client;

import java.io.FileInputStream;
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

    public Client readObjet(String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(new FileInputStream(path), Client.class);
    }

    public List<Client> readList(String path) throws IOException{
        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(new FileInputStream(path), new TypeReference<List<Client>>(){});
    }
}
