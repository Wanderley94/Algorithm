package Homework_07;

public class Main7 {

    public static void main(String[] args) {
//        testGraph();
//        testDfs();
        testBfs();
    }

    private static void testBfs() {
        Graph graph = new Graph(10);
        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Липецк");
        graph.addVertex("Воронеж");
        graph.addVertex("Рязань");
        graph.addVertex("Тамбов");
        graph.addVertex("Саратов");
        graph.addVertex("Калуга");
        graph.addVertex("Орел");
        graph.addVertex("Курск");

        graph.addEdges("Москва", "Тула", "Рязань", "Калуга");
        graph.addEdges("Тула", "Липецк");
        graph.addEdges("Липецк", "Воронеж");
        graph.addEdges("Рязань", "Тамбов");
        graph.addEdges("Тамбов", "Саратов");
        graph.addEdges("Саратов", "Воронеж");
        graph.addEdges("Калуга", "Орел");
        graph.addEdges("Орел", "Курск");
        graph.addEdges("Курск", "Воронеж");


        graph.shortestDistance("Москва", "Воронеж");
        graph.bfs("Москва");
    }

    private static void testDfs() {
        Graph graph = new Graph(7);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");

        graph.addEdges("A", "B", "C", "D");
        graph.addEdges("B", "E");
        graph.addEdges("D", "F");
        graph.addEdges("F", "G");

        graph.dfs("A");
        //A B E C D F G
    }

    private static void testGraph() {
        Graph graph = new Graph(4);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        graph.addEdges("A", "B", "C");
        graph.addEdges("B", "A", "C", "D");
        graph.addEdges("C", "A", "B", "D");
        graph.addEdges("D", "B", "C");

        System.out.println("Size of graph is " + graph.getSize());
        graph.display();
    }
}
