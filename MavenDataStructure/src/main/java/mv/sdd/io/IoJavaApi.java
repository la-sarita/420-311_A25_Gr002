package mv.sdd.io;

import java.io.*;
import java.util.ArrayList;

public class IoJavaApi {
    public static void main(String[] args) {
        lireFichier("data/test.txt");
        ecrireFichier("data/sortie.txt");
        serialiserObjets("data/data.ser");

    }

    public static void lireFichier(String fileName){
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                System.out.println(ligne);
            }
            br.close();
        } catch (IOException e) {
//            e.printStackTrace();
            System.err.println(e.getMessage());
        }
    }

    public static void serialiserObjets(String fileName){
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(fileName))) {
            ArrayList<String> liste = new ArrayList<>();
            liste.add("Alice");
            liste.add("Bob");
            out.writeObject(liste);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ecrireFichier(String fileName){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write("Bonjour, monde !");
            bw.newLine();
            bw.write("Deuxième ligne.");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testClientJsonService(){
        // test writeObjet
        // test writeList
        // test readObjet
        // test readList
    }
}
