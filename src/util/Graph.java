package util;

import java.util.*;

public class Graph<A> {
    Map<A,List<A>> graph = new HashMap<>();
    public Graph(List<Edge<A>> edges){
        for(Edge<A> e : edges){
            List<A> out = graph.getOrDefault(e.x, new ArrayList<>());
            out.add(e.y);
            graph.put(e.x,out);
        }
    }

    public List<A> topo(){
        //we should also check if a graph contains a topological ordering!!!
        //for now it's not needed
        List<A> res = new ArrayList<>();
        while(!graph.isEmpty()) {
            Set<A> nodesWithIncoming = new HashSet<>(graph.values().stream().flatMap(Collection::stream).toList());
            for (A k : graph.keySet()){
                if(!nodesWithIncoming.contains(k)){
                    res.add(k);
                    graph.remove(k);
                    break;
                }
            }
        }
        return res;
    }
}
