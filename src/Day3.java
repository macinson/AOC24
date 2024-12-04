import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day3 implements AOCDay{
    @Override
    public void first() {
        long res = 0L;

        try{
            //input transformed by a unix pipeline
            //cat AOC24Day3 | egrep "mul\([0-9]*,[0-9]*\)" -o | grep [0-9]*,[0-9]* -o
            Scanner sc = new Scanner(new File("resources/day3_2"));

            while(sc.hasNextLine()){
                Scanner lineSc = new Scanner(sc.nextLine());
                lineSc.useDelimiter(",");
                res += lineSc.nextLong() * lineSc.nextLong();
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
            //input transformed by a unix pipeline
            //cat AOC24Day3 |tr -d '\n' |grep -P "(?<=do\(\)).*?(?=don't\(\))|(?<=do\(\)).*?$|^.*?(?=don't\(\))" -o | egrep "mul\([0-9]*,[0-9]*\)" -o | grep "[0-9]*,[0-9]*" -o
            Scanner sc = new Scanner(new File("resources/day3_3"));

            while(sc.hasNextLine()){
                Scanner lineSc = new Scanner(sc.nextLine());
                lineSc.useDelimiter(",");
                res += lineSc.nextLong() * lineSc.nextLong();
            }

        }catch(FileNotFoundException e){
            System.out.println("File not found!!");
        }


        System.out.println(res);
    }
}
