import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;

public class Day1 implements AOCDay{

    public void first(){
        long res = 0L;

        try{
            Scanner sc = new Scanner(new File("resources/day1_1.txt"));
            List<Long> first = new ArrayList<>();
            List<Long> second = new ArrayList<>();

            while(sc.hasNextLine()){
                String line = sc.nextLine();
                first.add(Long.parseLong(line.split("   ")[0]));
                second.add(Long.parseLong(line.split("   ")[1]));
            }
            first.sort(Long::compare);
            second.sort(Long::compare);
            for(int i = 0; i < first.size() && i < second.size(); i++){
                res += Math.abs(first.get(i) - second.get(i));
            }
        }catch(FileNotFoundException e){
            System.out.println("File not found!!");
        }


        System.out.println(res);
    }

    public void second(){
        long res = 0L;

        try{
            Scanner sc = new Scanner(new File("resources/day1_1.txt"));
            List<Long> first = new ArrayList<>();
            List<Long> second = new ArrayList<>();

            while(sc.hasNextLine()){
                String line = sc.nextLine();
                first.add(Long.parseLong(line.split("   ")[0]));
                second.add(Long.parseLong(line.split("   ")[1]));
            }

            Map<Long,Long> map = new HashMap<>();
            for(long l : second){
                if(map.get(l) == null){
                    map.put(l,0L);
                }
                map.put(l,1 + map.get(l));
            }

            for(long l : first){
                res += l * map.getOrDefault(l,0L);
            }

        }catch(FileNotFoundException e){
            System.out.println("File not found!!");
        }



        System.out.println(res);
    }

}
