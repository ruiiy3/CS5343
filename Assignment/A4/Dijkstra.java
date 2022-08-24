import java.util.PriorityQueue;

public class Dijkstra {
    public static void distance(int[][] adjM, int source) {


        int[] distance = new int[adjM.length]; // vertice number
        boolean[] visited = new boolean[adjM.length]; // vertice number 1 as vistied, 0 not visited
        for(int i = 0; i < adjM.length; i++) {
            if(i == source)
                distance[i] = 0;
            else
                distance[i] = Integer.MAX_VALUE;
            visited[i] = true;
        }
        int check = adjM.length - 1;

        System.out.println("Shortest path from source " + source + " to different node is: " );
        while(check >= 0) {
            int index = removeMin(visited, distance);
            System.out.println("Veretx is " + index + " distance is " + distance[index]);
            relax(adjM, visited, distance, index);
            check--;
        }



        /*
        for(int i = 0; i < distance.length; i++)
            System.out.println("Veretx is " + i + " distance is " + distance[i]);
        */


    }
    public static int removeMin(boolean[] check, int[] distance) {
        int min = Integer.MAX_VALUE;
        int index = 0;

        for(int i = 0; i < distance.length; i++) {
            if(distance[i] < min && check[i]) {
                min =  distance[i];
                index = i;
            }
        }
        check[index] = false;
        return index;
    }

    public static void relax(int[][] adjM, boolean[] visited, int[] distance, int index) {
        for(int i = 0; i < adjM[0].length; i++) {
            if(adjM[index][i] != 0 && visited[i]) {
                if( adjM[index][i] + distance[index] < distance[i] )
                    distance[i] = adjM[index][i] + distance[index];
                //System.out.println(i + " " + distance[i]);
                //System.out.println("distance is ");
            }
        }
    }

    public static void main(String[] args) {

        int vertex = 10;
        int edge = 20;
        //vertex1 vertex2 edge distance
        int[][] graph = {
                {0,1,4},
                {0,2,8},
                {0,7,2},
                {1,2,4},
                {1,3,5},
                {1,5,6},
                {1,7,2},
                {2,3,5},
                {2,4,9},
                {2,6,3},
                {2,8,9},
                {3,4,4},
                {3,5,3},
                {4,6,2},
                {4,9,5},
                {5,7,7},
                {6,8,2},
                {6,9,1},
                {7,8,5},
                {8,9,5},
        };

        System.out.println("The original graph(V= Vertex, W = Weight)");
        System.out.println("V V W");
        for (int[] ints : graph) System.out.println(ints[0] + " " + ints[1] + " " + ints[2]);

        int[][] adjMatrix = new int[vertex][vertex];

        for(int i = 0; i < vertex; i++) {

            for(int j = 0; j < vertex; j++) {
                adjMatrix[i][j] = 0;
            }
        }

        for(int i = 0; i < edge; i++) {
            int row = graph[i][0];
            int col = graph[i][1];
            int weight = graph[i][2];
            adjMatrix[row][col] = weight;
            adjMatrix[col][row] = weight;
        }
        //distance(matrix, source node)
        distance(adjMatrix, 2);
    }
}
