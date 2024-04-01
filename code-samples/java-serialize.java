// Json

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;

public class SerializationExample {
    public static void main(String[] args) {
        // Oggetto da serializzare in formato JSON
        Person person = new Person("Alice", 30);

        // Creazione di un oggetto Gson
        Gson gson = new Gson();

        try (FileWriter writer = new FileWriter("person.json")) {
            // Serializza l'oggetto in formato JSON e 
            //      lo scrive sul file "person.json"
            gson.toJson(person, writer);
            System.out.println("Serializzazione JSON completata.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;

public class DeserializationExample {
    public static void main(String[] args) {
        // Creazione di un oggetto Gson
        Gson gson = new Gson();

        try (FileReader reader = new FileReader("person.json")) {
            // Deserializza l'oggetto da JSON 
            //      e ricostruiscilo come un oggetto Java
            Person person = gson.fromJson(reader, Person.class);

            System.out.println("Deserializzazione JSON completata.");
            System.out.println("Nome: " + person.getName());
            System.out.println("Età: " + person.getAge());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


mvn archetype:generate \
    -DarchetypeGroupId=org.apache.maven.archetypes 
    -DarchetypeArtifactId=maven-archetype-quickstart 
    -DarchetypeVersion=1.4





