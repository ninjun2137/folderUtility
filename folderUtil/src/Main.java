import java.util.Scanner;

public class Main {
    public static void Main(String[] args) {
        while(true){
            Scanner reader = new Scanner(System.in);
            System.out.println("JAVA FOLDER UTILITY TOOL:");
            System.out.println("1 - Flatten COPY (Specify ROOT folder. Program will copy all files from underlying folder to root DIR)");
            System.out.println("2 - Flatten CUT (Specify ROOT folder. Program will cut all files from underlying folder to root DIR)");
            String input = reader.nextLine();
            switch(input){
                case "1":
                case "2":{
                    System.out.println("Please input path");

                    break;
                }
                default:{
                    break;
                }
            }



        }
    }
}
