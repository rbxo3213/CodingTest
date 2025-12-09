import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Double> map = new HashMap<>();
        
        map.put("A+", 4.5);
        map.put("A0", 4.0);
        map.put("B+", 3.5);
        map.put("B0", 3.0);
        map.put("C+", 2.5);
        map.put("C0", 2.0);
        map.put("D+", 1.5);
        map.put("D0", 1.0);
        map.put("F", 0.0);
        
        Double score = 0.0;
        Double grade = 0.0;
        
        for (int i = 0; i < 20; i++) {
            String[] line = br.readLine().split(" ");
            if (line[2].equals("P")) continue;
            score += Double.parseDouble(line[1]);
            grade += Double.parseDouble(line[1]) * map.get(line[2]);
        }

        System.out.println(grade / score);
    }
}
