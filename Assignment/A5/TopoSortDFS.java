import java.util.ArrayList;

public class TopoSortDFS {
    public static ArrayList<Integer> toposort(ArrayList<Integer>[] adj) {
        int visited[] = new int[adj.length];  // visited = 1 means visited
        int done[] = new int[adj.length]; // done = 1 means finished
        ArrayList<Integer> order = new ArrayList<Integer>();
        boolean check = true;
        for(int i = 0; i < visited.length; i++)
            visited[i] = 0;
        for(int i = 0; i < done.length; i++)
            done[i] = 0;
        int test = 0;
        for(int i = 0; i < visited.length; i++) {

            if(visited[i] == 0) {
                dfs(adj, visited, done,order, i);
            }
        }

        return order;
    }
    private static void dfs(ArrayList<Integer>[] adj, int[] visited, int[] done, ArrayList<Integer> order, int s){
        visited[s] = 1;

        for(int i = 0; i < adj[s].size(); i++) {
            if(done[adj[s].get(i)] == 0 && visited[adj[s].get(i)] == 1) {
                return;
            }
            else if (done[adj[s].get(i)] == 0)
                dfs(adj, visited, done, order, adj[s].get(i));

        }
        done[s] = 1;
        order.add(0,s);

    }
    public static void topodfsprint(ArrayList<Integer> order, ArrayList<Integer>[] adj, char[] character) {
        if(order.size() != adj.length)
            System.out.println("This graph exists a cycle");
        else {
            for (int x : order) {
                System.out.print(character[x] + " ");
            }
        }
    }
    public static void main(String[] args) {

        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[8];
        for (int i = 0; i < 8; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        //i-1
        adj[0].add(1);
        adj[0].add(4);
        adj[0].add(5);
        adj[1].add(2);
        adj[1].add(4);
        adj[1].add(6);
        adj[2].add(3);
        adj[3].add(4);
        adj[4].add(6);
        adj[4].add(7);
        adj[5].add(4);
        adj[5].add(7);
        adj[6].add(7);
        adj[6].add(3);

        ArrayList<Integer> order = toposort(adj);
        char[] character1 = {'1', '2', '3', '4', '5', '6', '7', '8'};
        System.out.print("Image1 ");
        topodfsprint(order, adj, character1);

        ArrayList<Integer>[] adj2 = (ArrayList<Integer>[]) new ArrayList[14];
        for (int i = 0; i < 14; i++) {
            adj2[i] = new ArrayList<Integer>();
        }


        adj2[0].add(11);
        adj2[0].add(4);
        adj2[0].add(5);
        adj2[1].add(4);
        adj2[1].add(8);
        adj2[1].add(2);
        adj2[2].add(5);
        adj2[2].add(9);
        adj2[2].add(6);
        adj2[3].add(6);
        adj2[3].add(2);
        adj2[3].add(13);
        adj2[4].add(7);
        adj2[5].add(8);
        adj2[5].add(12);
        adj2[6].add(5);
        adj2[8].add(7);
        adj2[9].add(11);
        adj2[9].add(10);
        adj2[10].add(13);
        adj2[12].add(9);
        ArrayList<Integer> order2 = toposort(adj2);
        char[] character2 = {'m', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        System.out.print("Image2 ");
        topodfsprint(order2, adj2, character2);



    }
}