import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopoSortBFS {
    public static ArrayList<Integer> tpbfs(ArrayList<Integer>[] adj, int[] indegree) {
        ArrayList<Integer> order = new ArrayList<Integer>();
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0)
                q.add(i);

        }
        while(!q.isEmpty()) {
            int tmp = q.poll();
            order.add(tmp);
            for(int v : adj[tmp]) {
                indegree[v]--;
                if(indegree[v] == 0)
                    q.add(v);
            }

        }
        return order;
    }
    public static void topobfsprint(ArrayList<Integer> order, ArrayList<Integer>[] adj, char[] character) {
        if(order.size() != adj.length)
            System.out.println("This graph exists a cycle");
        else {
            for (int x : order) {
                System.out.print(character[x] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[] indegree = new int[8];
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[8];
        for (int i = 0; i < 8; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        //i-1
        adj[0].add(1);
        indegree[1]++;
        adj[0].add(4);
        indegree[4]++;
        adj[0].add(5);
        indegree[5]++;
        adj[1].add(2);
        indegree[2]++;
        adj[1].add(4);
        indegree[4]++;
        adj[1].add(6);
        indegree[6]++;
        adj[2].add(3);
        indegree[3]++;
        adj[3].add(4);
        indegree[4]++;
        adj[4].add(6);
        indegree[6]++;
        adj[4].add(7);
        indegree[7]++;
        adj[5].add(4);
        indegree[4]++;
        adj[5].add(7);
        indegree[7]++;
        adj[6].add(7);
        indegree[7]++;
        adj[6].add(3);
        indegree[3]++;
        ArrayList<Integer> order = tpbfs(adj, indegree);
        char[] character1 = {'1', '2', '3', '4', '5', '6', '7', '8'};
        System.out.print("Image1 ");
        topobfsprint(order, adj, character1);


        ArrayList<Integer>[] adj2 = (ArrayList<Integer>[]) new ArrayList[14];
        int[] indegree1 = new int[14];
        for (int i = 0; i < 14; i++) {
            adj2[i] = new ArrayList<Integer>();
        }
        adj2[0].add(11);
        indegree1[11]++;
        adj2[0].add(4);
        indegree1[4]++;
        adj2[0].add(5);
        indegree1[5]++;
        adj2[1].add(4);
        indegree1[4]++;
        adj2[1].add(8);
        indegree1[8]++;
        adj2[1].add(2);
        indegree1[2]++;
        adj2[2].add(5);
        indegree1[5]++;
        adj2[2].add(9);
        indegree1[9]++;
        adj2[2].add(6);
        indegree1[6]++;
        adj2[3].add(6);
        indegree1[6]++;
        adj2[3].add(2);
        indegree1[2]++;
        adj2[3].add(13);
        indegree1[13]++;
        adj2[4].add(7);
        indegree1[7]++;
        adj2[5].add(8);
        indegree1[8]++;
        adj2[5].add(12);
        indegree1[12]++;
        adj2[6].add(5);
        indegree1[5]++;
        adj2[8].add(7);
        indegree1[7]++;
        adj2[9].add(11);
        indegree1[11]++;
        adj2[9].add(10);
        indegree1[10]++;
        adj2[10].add(13);
        indegree1[13]++;
        adj2[12].add(9);
        indegree1[9]++;
        ArrayList<Integer> order2 = tpbfs(adj2, indegree1);
        char[] character2 = {'m', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        System.out.print("Image2 ");
        topobfsprint(order2, adj2, character2);



    }
}
