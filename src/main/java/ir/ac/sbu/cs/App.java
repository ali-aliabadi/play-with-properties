package ir.ac.sbu.cs;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class App {
    public static void main( String[] args ) throws IOException, BadPropertiesFile {

        Properties prob = new Properties();
        prob.load(new FileInputStream(Objects.requireNonNull(Thread.currentThread().getContextClassLoader()
                .getResource("test.properties")).getPath()));

        prob.entrySet().forEach(System.out::println);

        System.out.println(prob.getProperty("db[one, two]"));

        HashSet<String> oops = new HashSet<>(Arrays.asList("one", "two"));

        int[] flag = {0};

        oops.forEach(s -> {
            if (prob.containsKey(s)) {
                ++ flag[0];
            }
        });

        if (flag[0] == 2) {
            throw new BadPropertiesFile("database properties missing in properties file");
        }



        System.out.println("now adding three properties &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

        prob.setProperty("testAdd", "ad   d1");
        prob.setProperty("testAdd2", "add2 2222222");
        prob.setProperty("hellllo baby", "hi");

        prob.entrySet().forEach(System.out::println);

        // to now its added but its not saved

        prob.store(new FileOutputStream("src/main/resources/test.properties"), null);

        System.out.println("******************************************");

        prob.entrySet().forEach(System.out::println);


    }
}
