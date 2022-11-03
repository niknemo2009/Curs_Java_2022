package lection5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

/*
12)Implement a program that counts all equal words in a text file. The program should
output a list of all found words and their count (such a list is called "histogram")
 */

// !!!!!!!!!!!!!!!!!!!!!!!!!! NO COMPLETE
public class Exercise12 {
    public static void main(String[] args) {
        analiseText("qwerrt");
    }

    static Map<String, Integer> analiseText(String path33) {
        Map<String, Integer> result = new TreeMap<>();
        Path path = Paths.get(System.getProperty("user.dir") + "/1.txt");
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(x -> {
                String[] words = x.replaceAll("[a-zA-Z0-9]*[\\.\\-:;=,]([a-zA-Z0-9]*)", " ").split(" ");
                for (String temp : words) {
                    if (result.containsKey(temp)) {
                        int count = result.get(temp);
                        result.put(temp, count + 1);
                    } else {
                        result.put(temp, 1);
                    }
                }

            });
        } catch (IOException e) {
            e.printStackTrace();

        }
        System.out.println(result);
        return result;
    }
}
