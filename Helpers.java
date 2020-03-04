import java.util.Scanner;

public class Helpers{

    static String getInput(){
        
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();

        //in.close();

        return s;
    }

    static void print(String msg){
        System.out.println(msg);
    }
}