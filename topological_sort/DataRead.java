package topological_sort;

import topological_sort.randomDAG.Graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static topological_sort.TopologicalSort.topologicalSort;
import static topological_sort.randomDAG.DAGgenerator.generateRandomDAG;

public class DataRead {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("Data.txt"))) {
            String s;
            Pattern pattern = Pattern.compile(" \\d+ \\W"); //\W
            Pattern pattern2 = Pattern.compile("\\d+");
            Matcher matcher;

            try(FileWriter writer = new FileWriter("DataForTable.txt")) {
                while((s = br.readLine()) != null){
                    System.out.println(s);
                    matcher = pattern.matcher(s);
                    if (matcher.find()) {
                        matcher = pattern2.matcher(matcher.group());;
                        if (matcher.find()) {
                            writer.write(matcher.group() + "\r\n");
                        }
                    }
                }
                for(int i = 1; i <= 102; i++){
                    writer.write(i + "\r\n");
                }
                writer.flush();
            }
        }

        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
