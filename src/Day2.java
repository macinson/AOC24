import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Day2 implements AOCDay{
    @Override
    public void first() {
        long res = 0L;

        try{
            Scanner sc = new Scanner(new File("resources/day2_1"));

            while(sc.hasNextLine()){
                Scanner lineSc = new Scanner(sc.nextLine());
                lineSc.useDelimiter(" ");
                List<Integer> list = new ArrayList<>();
                while(lineSc.hasNextInt()){
                    list.add(lineSc.nextInt());
                }
                if (Objects.equals(list.getFirst(), list.getLast())) continue;
                boolean increasing = list.getFirst() < list.getLast();
                res++;
                for(int i = 1; i < list.size(); i++){
                    if(Math.abs(list.get(i-1) - list.get(i)) > 3 || Math.abs(list.get(i-1) - list.get(i)) == 0 || (list.get(i-1) < list.get(i)) != increasing){
                        res--;
                        break;
                    }
                }
            }

        }catch(FileNotFoundException e){
            System.out.println("File not found!!");
        }


        System.out.println(res);
    }

    @Override
    public void second() {
        long res = 0L;

        try{
            Scanner sc = new Scanner(new File("resources/day2_1"));

            while(sc.hasNextLine()){
                Scanner lineSc = new Scanner(sc.nextLine());
                lineSc.useDelimiter(" ");
                List<Integer> list = new ArrayList<>();
                while(lineSc.hasNextInt()){
                    list.add(lineSc.nextInt());
                }
                if(list.size() <= 2) {
                    res++;
                    continue;
                }
                boolean anySafe = false;
                for(int j = -1; j < list.size(); j++){
                    boolean safe =true;
                    int min = (j==0) ? 1:0;
                    int max = (j==list.size()-1) ? list.size()-2:list.size()-1;
                    if (Objects.equals(list.get(min), list.get(max))) continue;
                    boolean increasing = list.get(min) < list.get(max);
                    for(int i = 1; i < list.size(); i++){
                        int a = Math.max(0,(i-1 == j) ? j-1 : i-1);
                        if(a == j) continue;
                        int b = Math.min(list.size()-1,(i == j) ? j+1 : i);
                        if(b == j) continue;
                        if(Math.abs(list.get(a) - list.get(b)) > 3 || Math.abs(list.get(a) - list.get(b)) == 0 || (list.get(a) < list.get(b)) != increasing){
                            safe = false;
                            break;
                        }
                    }
                    if(safe){
                        anySafe = true;
                        break;
                    }
                }
                if(anySafe) res++;

            }

        }catch(FileNotFoundException e){
            System.out.println("File not found!!");
        }


        System.out.println(res);
    }
}
