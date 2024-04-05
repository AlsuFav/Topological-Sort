package topological_sort;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import topological_sort.randomDAG.Graph;
import static topological_sort.TopologicalSort.topologicalSort;
import static topological_sort.randomDAG.DAGgenerator.generateRandomDAG;

public class Test {
    public static int iterations;

    public static void main(String[] args) {
        try(FileWriter writer = new FileWriter("Data.txt", true)) {
            for(int i = 0; i < 165; i++){
                iterations = 0;

                Graph randomDAG = generateRandomDAG(); // генерация случайного графа
                List<Integer>[] adjacencyList = randomDAG.getAdjacencyList();

                int vertices = randomDAG.getVertices();
                int edges = randomDAG.getEdges();
                int VandE = vertices + edges;

                long start = System.nanoTime(); // время начала сортировки
                int[] sortedVertices = topologicalSort(adjacencyList, vertices);
                long end = System.nanoTime(); // время окончания сортировки

                writer.write(VandE + " "); // сумма вершин и ребер графа
                writer.write((end - start) + " "); // время выполнения сортировки
                writer.write(iterations + " "); // количество итераций
                writer.write(Arrays.toString(adjacencyList) + " "); // список смежности графа
                writer.write(Arrays.toString(sortedVertices) + "\r\n"); // отсортированные вершины

            }
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
