package qa.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import qa.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class GroupDataGenerator {

    @Parameter(names = "-c", description = "Group count")
    public int count;

    @Parameter(names = "-f", description = "Target file")
    public String file;

    @Parameter(names = "-d", description = "Data format")
    public String format;

    public static void main(String[] args) throws IOException {
        GroupDataGenerator gen = new GroupDataGenerator();
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
        List<GroupData> groups = generateGroups(count);
        if(format.equals("csv")) {
            saveAsCsv(groups, new File(file));
        }
        else if(format.equals("json")) {
            saveAsJson(groups, new File(file));
        }
        else {
            System.out.println("Unrecognized format " + format);
        }
    }

    private void saveAsCsv(List<GroupData> groups, File file) throws IOException {
        Writer writer = new FileWriter(file);
        for (GroupData groupData: groups){
            writer.write(String.format("%s;%s;%s\n", groupData.getName(), groupData.getHeader(),
                    groupData.getFooter()));
        }
        writer.close();
    }

    private void saveAsJson(List<GroupData> groups, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(groups);
        Writer writer = new FileWriter(file);
        writer.write(json);
        writer.close();
    }

    private List<GroupData> generateGroups(int count) {
        List<GroupData> groups = new ArrayList<>();
        for (int i = 0; i < count; i++){
            groups.add(new GroupData().withName(String.format("test %s", i))
                    .withFooter(String.format("footer %s", i)).withHeader(String.format("header %s", i)));
        }
        return groups;
    }
}
