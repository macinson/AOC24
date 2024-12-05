import util.Edge;
import util.Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day5 implements AOCDay {
    @Override
    public void first() {
        long res = 0L;

        Map<Integer, Set<Integer>> rules = new HashMap<>();

        try {
            Scanner sc = new Scanner(new File("resources/day5_1"));
            while (sc.hasNextLine()) {
                String[] line = sc.nextLine().split(",");
                int val = Integer.parseInt(line[0]);
                int key = Integer.parseInt(line[1]);

                Set<Integer> vals = rules.getOrDefault(key, new HashSet<>());
                vals.add(val);
                rules.put(key, vals);
            }

            Scanner pagesSc = new Scanner(new File("resources/day5_2"));
            while (pagesSc.hasNextLine()) {
                String[] line = pagesSc.nextLine().split(",");
                boolean valid = true;
                for (int i = 0; i < line.length - 1; i++) {
                    for (int j = i + 1; j < line.length; j++) {
                        if (rules.get(Integer.parseInt(line[i])) != null && rules.get(Integer.parseInt(line[i])).contains(Integer.parseInt(line[j]))) {
                            valid = false;
                            break;
                        }
                    }
                    if(!valid) break;
                }
                if (valid) res += Integer.parseInt(line[line.length / 2]);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found!!");
        }


        System.out.println(res);

    }

    @Override
    public void second() {
        long res = 0L;

        Map<Integer, Set<Integer>> rules = new HashMap<>();

        try {
            Scanner sc = new Scanner(new File("resources/day5_1"));
            while (sc.hasNextLine()) {
                String[] line = sc.nextLine().split(",");
                int val = Integer.parseInt(line[0]);
                int key = Integer.parseInt(line[1]);

                Set<Integer> vals = rules.getOrDefault(key, new HashSet<>());
                vals.add(val);
                rules.put(key, vals);
            }

            Scanner pagesSc = new Scanner(new File("resources/day5_2"));
            while (pagesSc.hasNextLine()) {
                String[] line = pagesSc.nextLine().split(",");
                boolean valid = true;
                for (int i = 0; i < line.length - 1; i++) {
                    for (int j = i + 1; j < line.length; j++) {
                        if (rules.get(Integer.parseInt(line[i])) != null && rules.get(Integer.parseInt(line[i])).contains(Integer.parseInt(line[j]))) {
                            valid = false;
                            break;
                        }
                    }
                    if(!valid) break;
                }
                if(!valid){
                    List<Edge<Integer>> edges = new ArrayList<>();
                    for (int i = 0; i < line.length - 1; i++) {
                        for (int j = i + 1; j < line.length; j++) {
                            int x = Integer.parseInt(line[i]);
                            int y = Integer.parseInt(line[j]);
                            if(rules.containsKey(x) && rules.get(x).contains(y)) edges.add(new Edge<>(y,x));
                            if(rules.containsKey(y) && rules.get(y).contains(x)) edges.add(new Edge<>(x,y));
                        }


                    }
                    Graph<Integer> graph = new Graph<>(edges);
                    List<Integer> topo = graph.topo();
                    res += topo.get(topo.size()/2);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found!!");
        }


        System.out.println(res);
    }
}
