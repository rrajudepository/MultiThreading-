package DSAPractice.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class BFS_DFS {

    public static void dfsVisit(List<List<Integer>> nodes, List<Integer> graphNodes, boolean visit[], int currnode){
        
        visit[currnode] = true;
        graphNodes.add(currnode);

        for(int curr : nodes.get(currnode)){
            if(!visit[curr]){
                dfsVisit(nodes, graphNodes, visit, curr);
            }
        }

        
    }
    public static void DFS(List<List<Integer>> nodes){
        List<Integer> graphNodes = new ArrayList<>();
        boolean visit[] = new boolean[nodes.size()];

        dfsVisit(nodes, graphNodes, visit, 0);
        System.out.println("DFS visit of graph: ");
        for(int curr : graphNodes){
            System.out.print(curr+" ");
        }

        System.out.println();


    }

    public static void BFS(List<List<Integer>> nodes){
        Queue<Integer> q = new LinkedList<>();
        int row = nodes.size();
        boolean visit[] = new boolean[row];
        Arrays.fill(visit, false);
        q.add(0);
        q.add(-1);
        visit[0] = true;
        System.out.println("BFS visit of graph: ");
        while(!q.isEmpty()){
            int currNode = q.poll();
            if(currNode==-1){
                if(q.isEmpty()){
                    break;
                }else{
                    System.out.println();
                    q.add(-1);
                }
            }else{
                System.out.print(currNode+" ");
                for(int curr : nodes.get(currNode)){
                    if(!visit[curr]){
                        q.add(curr);
                        visit[curr] = true;
                    }
                }
            }

        }
        System.out.println();

    }
     public static void main(String[] args) {
        /*
         *  0
         * / \ \
         * 2 3  1
         * | |  |
         * 4 7  5
         * |\/  |
         * 8 9  6
         * | |  |
        * 10 14 11
         * |     |
         * 12    13
         */
        List<List<Integer>> nodes = new ArrayList<>();
        Collections.addAll(nodes, 
        new ArrayList<>(Arrays.asList(2,3,1)),
        new ArrayList<>(Arrays.asList(0,5)),
        new ArrayList<>(Arrays.asList(0,4)),
        new ArrayList<>(Arrays.asList(0,7)),
        new ArrayList<>(Arrays.asList(2,8,9)),
        new ArrayList<>(Arrays.asList(1,6)),
        new ArrayList<>(Arrays.asList(5,11)),
        new ArrayList<>(Arrays.asList(3,9)),
        new ArrayList<>(Arrays.asList(4,10)),
        new ArrayList<>(Arrays.asList(4,7,14)),
        new ArrayList<>(Arrays.asList(8,12)),
        new ArrayList<>(Arrays.asList(6,13)),
        new ArrayList<>(Arrays.asList(10)),
        new ArrayList<>(Arrays.asList(11)),
        new ArrayList<>(Arrays.asList(9)));
        //nodes.add(new ArrayList<>(Arrays.asList(0,7)));
        int row = nodes.size();
        int col = nodes.get(0).size();

        //BFS visit
        BFS(nodes);
        //DFS visit
        DFS(nodes);



     }
}
