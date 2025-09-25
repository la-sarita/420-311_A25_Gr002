package mv.sdd.io.json.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import mv.sdd.facturation.Item;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ItemJsonService {

    public void writeObjet(Item item, String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        // Conversion Objet → JSON
        mapper.writeValue(new FileOutputStream(path), item);
    }

    public void writeList(List<Item> items, String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        mapper.writeValue(new FileOutputStream(path),
                items);
    }

    public Item readObjet(String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(new FileInputStream(path), Item.class);
    }

    public List<Item> readList(String path) throws IOException{
        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(new FileInputStream(path), new TypeReference<List<Item>>(){});
    }
}
