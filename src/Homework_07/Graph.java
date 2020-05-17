package Homework_07;

import java.util.*;

public class Graph {

    private final List<Vertex> vertexList;
    private final boolean[][] adjMat;

    public Graph(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMat = new boolean[maxVertexCount][maxVertexCount];
    }

    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }

    public void addEdges(String start, String second, String... other) {
        addEdge(start, second);
        for (String another : other) {
            addEdge(start, another);
        }
    }

    private void addEdge(String start, String finish) {
        int startIndex = indexOf(start);
        int finishIndex = indexOf(finish);

        if (startIndex == -1 || finishIndex == -1) {
            throw new IllegalArgumentException("Invalid label for edge");
        }

        adjMat[startIndex][finishIndex] = true;
        adjMat[finishIndex][startIndex] = true;
    }

    private int indexOf(String vertexLabel) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexLabel.equals(vertexList.get(i).getLabel())) {
                return i;
            }
        }

        return -1;
    }

    public int getSize() {
        return vertexList.size();
    }

    private void displayVertex(Vertex vertex) {
        System.out.println(vertex);
    }

    public void display() {
        for (int i = 0; i < getSize(); i++) {
            System.out.print(vertexList.get(i));
            for (int j = 0; j < getSize(); j++) {
                if (adjMat[i][j]) {
                    System.out.print(" -> " + vertexList.get(j));
                }
            }
            System.out.println();
        }
    }

    /**
     * англ. Depth-first search, DFS
     *
     * @param startLabel
     */
    public void dfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid start label");
        }

        Stack<Vertex> stack = new Stack<>();

        Vertex vertex = vertexList.get(startIndex);
        visitVertex(vertex, stack);

        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {

                visitVertex(vertex, stack);
            }
            else {
                stack.pop();
            }
        }

        resetVertexState();

    }

    public void shortestDistance (String startLabel, String finishLabel){

            int startIndex = indexOf(startLabel);
            int endIndex = indexOf(finishLabel);

            if (startIndex == -1) {
                throw new IllegalArgumentException("Invalid start label");
            }

            Queue<Vertex> queue = new LinkedList<>();

            Vertex vertex = vertexList.get(startIndex);
            visitVertex(vertex, queue);

            while (!queue.isEmpty()) {
                vertex = getNearUnvisitedVertex(queue.peek());

                if (vertex != null && vertex.getLabel().equals(finishLabel)) {
                    vertex.setPreviousVertex(queue.peek());
                    break;
                }
                else if (vertex != null) {
                    visitVertex(vertex, queue);
                    vertex.setPreviousVertex(queue.peek());
                }
                else {
                    queue.remove();
                }
            }

            displayShortPath(vertexList.get(endIndex));

            resetVertexState();
    }

    /**
     * англ. breadth-first search, BFS
     *
     * @param startLabel
     */
    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid start label");
        }

        Queue<Vertex> queue = new LinkedList<>();

        Vertex vertex = vertexList.get(startIndex);
        visitVertex(vertex, queue);

        while (!queue.isEmpty()) {
            vertex = getNearUnvisitedVertex(queue.peek());
            // если vertex это финишная точка тогда выходим из цикла
            if (vertex != null) {
                visitVertex(vertex, queue);
            }
            else {
                queue.remove();
            }
        }

        resetVertexState();
    }

    private void displayShortPath(Vertex vertex) {

        Stack<String> stack = new Stack<>();
        StringBuilder SB = new StringBuilder();

        while (vertex != null) {

            stack.add(vertex.getLabel());
            vertex = vertex.getPreviousVertex();
        }

        while (stack.size() != 0) {
            SB.append(stack.pop()+" ");
        }

        System.out.println("Наикратчайший маршрут: "+SB);

    }

    private void resetVertexState() {
        for (Vertex vertex : vertexList) {
            vertex.setVisited(false);
        }
    }

    private Vertex getNearUnvisitedVertex(Vertex peek) {
        int peekIndex = vertexList.indexOf(peek);
        for (int i = 0; i < getSize(); i++) {
            if (adjMat[peekIndex][i] && !vertexList.get(i).isVisited()) {
                return vertexList.get(i);
            }
        }

        return null;
    }

    private void visitVertex(Vertex vertex, Stack<Vertex> stack) {
        displayVertex(vertex);
        stack.push(vertex);
        vertex.setVisited(true);
    }

    private void visitVertex(Vertex vertex, Queue<Vertex> queue) {
        displayVertex(vertex);
        queue.add(vertex);
        vertex.setVisited(true);
    }


}
