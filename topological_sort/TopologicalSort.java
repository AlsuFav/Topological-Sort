package topological_sort;

import java.util.*;

public class TopologicalSort {

    // Метод для выполнения поиска в глубину (Depth First Search) и рекурсивной топологической сортировки
    static void DFS(int vertice, List<Integer>[] adj, boolean[] visited, Stack<Integer> stack) {
        // Отмечаем текущую вершину как посещенную
        visited[vertice] = true;

        // Рекурсивно обходим все смежные вершины
        for (int i : adj[vertice]) {
            if (!visited[i]) {
                DFS(i, adj, visited, stack);
                Test.iterations++;
            }
        }

        // Помещаем текущую вершину в стек, который хранит результат
        stack.push(vertice);
    }

    // Метод для выполнения топологической сортировки
    static int[] topologicalSort(List<Integer>[] adj, int vertices) {
        // Стек для хранения результата
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[vertices];

        // Вызываем рекурсивную вспомогательную функцию для топологической сортировки,
        // начиная с каждой вершины по очереди
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                DFS(i, adj, visited, stack);
                Test.iterations++;
            }
        }

        int[] result =  new int[stack.size()];
        for(int i = 0; i < result.length; i++) {
            result[i] = stack.pop();
            Test.iterations++;
        }

        // Возвращаем отсортированные вершины в виде массива
        return result;
    }
}