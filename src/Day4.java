import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class Day4 implements AOCDay{
    int n = 140;
    int m = 140;
    @Override
    public void first() {
        String[][] c = new String[n][m];
        long res = 0L;

        try{
            Scanner sc = new Scanner(new File("resources/day4_1"));
            int i = 0;

            while(sc.hasNextLine()){
                int j = 0;
                Scanner lineSc = new Scanner(sc.nextLine());
                lineSc.useDelimiter("");
                while(lineSc.hasNext()){
                    c[i][j] = lineSc.next();
                    j++;
                }
                i++;
            }

            i=0;
            String[] ref1 = new String[]{"X","M","A","S"};
            String[] ref2 = new String[]{"S","A","M","X"};
            while(i < n){
                for(int j = 0; j < m; j++){
                    res += right(i,j,0,c,ref1) +
//                            left(i,j,0,c,ref1)+
                            dLeft(i,j,0,c,ref1)+
                            dRight(i,j,0,c,ref1) +
                            down(i,j,0,c,ref1)+
                            right(i,j,0,c,ref2) +
//                            left(i,j,0,c,ref2)+
                            dLeft(i,j,0,c,ref2)+
                            dRight(i,j,0,c,ref2)+
                            down(i,j,0,c,ref2);
                }
                i++;
            }

        }catch(FileNotFoundException e){
            System.out.println("File not found!!");
        }


        System.out.println(res);
    }

    int right (int x, int y, int d, String[][] arr, String[] ref){
        if(d == 4) return 1;
        if(x < 0 || x >=n || y < 0 || y >=m) return 0;
        if(ref[d].equals(arr[x][y])) return right(x+1,y,d+1,arr,ref);
        return 0;
    }

//    int left (int x, int y, int d, String[][] arr,String[] ref){
//        if(d == 4) return 1;
//        if(x < 0 || x >=n || y < 0 || y >=m) return 0;
//        if(ref[d].equals(arr[x][y])) return left(x-1,y,d+1,arr,ref);
//        return 0;
//    }

    int dLeft (int x, int y, int d, String[][] arr,String[] ref){
        if(d == 4) return 1;
        if(x < 0 || x >=n || y < 0 || y >=m) return 0;
        if(ref[d].equals(arr[x][y])) return dLeft(x-1,y+1,d+1,arr,ref);
        return 0;
    }

    int dRight (int x, int y, int d, String[][] arr,String[] ref){
        if(d == 4) return 1;
        if(x < 0 || x >=n || y < 0 || y >=m) return 0;
        if(ref[d].equals(arr[x][y])) return dRight(x+1,y+1,d+1,arr,ref);
        return 0;
    }

    int down (int x, int y, int d, String[][] arr,String[] ref){
        if(d == 4) return 1;
        if(x < 0 || x >=n || y < 0 || y >=m) return 0;
        if(ref[d].equals(arr[x][y])) return down(x,y+1,d+1,arr,ref);
        return 0;
    }
//finds all XMAS (even words changing directions)
//    int helper1(int d, String[][] arr, int x, int y){
//        if(d==4) return 1;
//        if(x < 0 || x >=n || y < 0 || y >=m) return 0;
//        String[] ref = new String[]{"X","M","A","S"};
//        if(ref[d].equals(arr[x][y])){
//            return helper1(d+1,arr,x-1,y-1) +
//                    helper1(d+1,arr,x-1,y) +
//                    helper1(d+1,arr,x-1,y+1) +
//                    helper1(d+1,arr,x,y+1) +
//                    helper1(d+1,arr,x+1,y+1) +
//                    helper1(d+1,arr,x+1,y) +
//                    helper1(d+1,arr,x+1,y-1) +
//                    helper1(d+1,arr,x,y-1);
//        }
//        return 0;
//    }


    @Override
    public void second() {
        String[][] c = new String[n][m];
        long res = 0L;

        try{
            Scanner sc = new Scanner(new File("resources/day4_1"));
            int i = 0;

            while(sc.hasNextLine()){
                int j = 0;
                Scanner lineSc = new Scanner(sc.nextLine());
                lineSc.useDelimiter("");
                while(lineSc.hasNext()){
                    c[i][j] = lineSc.next();
                    j++;
                }
                i++;
            }

            i=0;
            String[] ref1 = new String[]{"X","M","A","S"};
            String[] ref2 = new String[]{"S","A","M","X"};
            while(i < n){
                for(int j = 0; j < m; j++){
                    res += findX(i,j,c);
                }
                i++;
            }

        }catch(FileNotFoundException e){
            System.out.println("File not found!!");
        }


        System.out.println(res);
    }

    private long findX(int x, int y, String[][] c) {
        if(x < 1 || x >=n-1 || y < 1 || y >=m-1) return 0;
        if(Objects.equals(c[x][y], "A") && Objects.equals(c[x-1][y-1], "S")
        && Objects.equals(c[x+1][y+1], "M") && Objects.equals(c[x-1][y+1], "M")
        && Objects.equals(c[x+1][y-1], "S")) return 1;
        if(Objects.equals(c[x][y], "A") && Objects.equals(c[x-1][y-1], "M")
                && Objects.equals(c[x+1][y+1], "S") && Objects.equals(c[x-1][y+1], "M")
                && Objects.equals(c[x+1][y-1], "S")) return 1;
        if(Objects.equals(c[x][y], "A") && Objects.equals(c[x-1][y-1], "S")
                && Objects.equals(c[x+1][y+1], "M") && Objects.equals(c[x-1][y+1], "S")
                && Objects.equals(c[x+1][y-1], "M")) return 1;
        if(Objects.equals(c[x][y], "A") && Objects.equals(c[x-1][y-1], "M")
                && Objects.equals(c[x+1][y+1], "S") && Objects.equals(c[x-1][y+1], "S")
                && Objects.equals(c[x+1][y-1], "M")) return 1;
        return 0;
    }
}
