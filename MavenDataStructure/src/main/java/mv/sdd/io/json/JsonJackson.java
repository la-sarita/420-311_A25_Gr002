package mv.sdd.io.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import mv.sdd.facturation.Client;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonJackson {
    public static void main(String[] args) {
        try {
            convertObjToString();
            convertObjToJsonFile();
            deserialiserJsonObject();
            deserialiserJsonObjectFile();
            serDeserJsonArray();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void convertObjToString() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        Client client = new Client(12345, "Dupont", "Alice", 2500.75);

        // Conversion Objet → JSON
        String objetSer = mapper.writeValueAsString(client);
        System.out.println(objetSer);
    }

    public static void convertObjToJsonFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        Client client = new Client(12345, "Dupont", "Alice", 2500.75);

        // Conversion Objet → JSON
        mapper.writeValue(new FileOutputStream("data/objetSer.json"), client);
    }

    public static void deserialiserJsonObject() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String donnees = "{\"numCompte\":98765,\"nom\":\"Martin\",\"prenom\":\"Bob\",\"solde\":1500.0}";

        // Conversion JSON → Objet
        Client client1 = mapper.readValue(donnees, Client.class);
        System.out.println(client1);
    }

    public static void deserialiserJsonObjectFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        // Conversion JSON → Objet
        Client client1 = mapper.readValue(new FileInputStream("data/objetSer.json"), Client.class);
        System.out.println(client1);
    }

    public static void serDeserJsonArray() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonArray = "[{\"numCompte\":111,\"nom\":\"Durand\",\"prenom\":\"Paul\",\"solde\":3000.0},"
                + "{\"numCompte\":222,\"nom\":\"Moreau\",\"prenom\":\"Sophie\",\"solde\":4500.5}]";

        Client[] clientsDeser = mapper.readValue(jsonArray, Client[].class);

        List<Client> clients = Arrays.asList(clientsDeser);

        mapper.writeValue(new FileOutputStream("data/listeClients.json"),
                clients);

        ArrayList<Client> clients2 = mapper.readValue(new FileInputStream("data/listeClients.json"), new TypeReference<ArrayList<Client>>() {
        });
        System.out.println(clients2.size());
    }
}
