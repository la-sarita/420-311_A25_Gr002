package mv.sdd.io.json.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class JsonService<T> {

    public void writeObjet(T element, String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        // Conversion Objet → JSON
        mapper.writeValue(new FileOutputStream(path), element);
    }

    public void writeList(List<T> elements, String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        mapper.writeValue(new FileOutputStream(path),
                elements);
    }

    public T readObjet(String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(new FileInputStream(path), new  TypeReference<T>() {});
    }

    public List<T> readList(String path) throws IOException{
        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(new FileInputStream(path), new TypeReference<List<T>>(){});
    }
}
