package qa.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import qa.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

    @Parameter(names = "-c", description = "Group count")
    public int count;

    @Parameter(names = "-f", description = "Target file")
    public String file;

    public static void main(String[] args) throws IOException {
        ContactDataGenerator gen = new ContactDataGenerator();
        try {
            JCommander.newBuilder()
                    .addObject(gen)
                    .build()
                    .parse(args);
        } catch (ParameterException pe){
            pe.usage();
        }
        gen.run();
    }

    private void run() throws IOException {
        List<ContactData> groups = generateContacts(count);
        save(groups, new File(file));
    }

    private static void save(List<ContactData> contacts, File file) throws IOException {
        Writer writer = new FileWriter(file);
        for (ContactData contact: contacts){
            writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s\n",
                    contact.getName(), contact.getLastName(), contact.getMobile(), contact.getHomePhone(),
                    contact.getWorkPhone(), contact.getAddress(), contact.getEmail1(), contact.getEmail2(),
                    contact.getEmail3()));
        }
        writer.close();
    }

    private static List<ContactData> generateContacts(int count) {
        List<ContactData> contacts = new ArrayList<>();
        for (int i = 0; i < count; i++){
            contacts.add(new ContactData().withName(String.format("a %s", i)).withLastName(String.format("b %s", i))
                    .withMobile(String.format("c %s", i)).withHomePhone(String.format("d %s", i))
                    .withWorkPhone(String.format("e %s", i)).withAddress(String.format("f %s", i)).
                            withEmail1(String.format("g %s", i)).withEmail2(String.format("h %s", i)).
                            withEmail3(String.format("i %s", i)));
        }
        return contacts;
    }
}
