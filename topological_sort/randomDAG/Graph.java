package topological_sort.randomDAG;

import java.util.*;

public class Graph {
    protected int vertices; // Количество вершин в графе
    protected int edges; // Количество вершин в графе
    protected List<Integer>[] adjacencyList; // Список смежности

    // Конструктор класса Graph, инициализирует нумерованный граф с заданным количеством вершин,
    // вершины пронумерованы от 0 до vertices - 1 включительно
    public Graph(int vertices) {
        this.vertices = vertices;
        this.edges = 0;
        adjacencyList = new ArrayList[vertices]; // Создание списка смежности для каждой вершины
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new ArrayList<>(); // Инициализация пустого списка смежности для каждой вершины
        }
    }

    // Метод для добавления ребра ориентированного от вершины from к вершине to
    public void addEdge(int from, int to) {
        adjacencyList[from].add(to);
        edges ++;
    }


    // метод для получения количества вершин
    public int getVertices() {
        return vertices;
    }

    // метод для получения количества ребер
    public int getEdges() {
        return edges;
    }

    // Метод для получения списка смежности графа
    public List<Integer>[] getAdjacencyList() {
        return adjacencyList;
    }
}