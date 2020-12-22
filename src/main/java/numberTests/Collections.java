package numberTests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {
    public static void main (String [] args) {
//        String [] langs = new String [4];
//        langs [0] = "Java";
        String [] langs = {"Java", "C#", "Python", "PHP"};
        List<String> languages = Arrays.asList("Java", "C#", "Python", "PHP");
//        languages.add("Java");

//        for (String l : languages)
        for (int i=0; i<languages.size(); i++)
//            System.out.println("Я хочу выучить язык "+ l);
            System.out.println("Я хочу выучить язык "+ languages.get(i));
    }
}
