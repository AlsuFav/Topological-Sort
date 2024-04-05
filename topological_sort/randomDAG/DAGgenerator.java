package topological_sort.randomDAG;

import java.util.*;

public class DAGgenerator {
    // Метод для генерации случайного ориентированного ациклического графа (DAG)
    public static Graph generateRandomDAG() {
        Random random = new Random();
        // Генерация случайного количества вершин от 1 до 60
        int vertices = random.nextInt(60) + 1;
        // Генерация случайного количества ребер, которое не противоречит ацикличности направленного графа
        int edges = vertices == 1 ? 0 : (random.nextInt((vertices * (vertices - 1) / 2)) + 1);

        Graph dag = new Graph(vertices);
        int edgesCount = 0; // количество ребер, добавленное в граф

        while (edgesCount < edges) {
            // Выбор случайной вершины from
            int from = random.nextInt(vertices);
            // Выбор случайной вершины to, номер которой больше from
            int to = random.nextInt(vertices - from) + from;

            if (createsCycle(dag, from, to)) {
                continue;
            }

            // Добавление ребра в граф, если не создает цикл
            dag.addEdge(from, to);
            edgesCount++;
        }
        return dag;
    }

    // Метод для проверки, создает ли добавление ребра цикл в графе
    private static boolean createsCycle(Graph dag, int from, int to) {
        // Множество для отслеживания посещенных вершин
        Set<Integer> visited = new HashSet<>();
        // Стек для обхода графа в глубину
        Stack<Integer> stack = new Stack<>();
        stack.push(from);

        while (!stack.isEmpty()) {
            int current = stack.pop();  // Извлечение текущей вершины из стека

            if (current == to) {
                return true; // Найден путь от to к from, значит, добавление ребра создаст цикл
            }

            if (!visited.contains(current)) {
                visited.add(current);
                for (int neighbor : dag.adjacencyList[current]) {
                    stack.push(neighbor); // Добавление всех соседних вершин в стек
                }
            }
        }
        return false;
    }
}
