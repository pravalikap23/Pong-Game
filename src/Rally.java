package src;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Rally {
    public static void main(String[] args){
        int highrally = getHighrally();

        System.out.println("Current High Rally: " + highrally);

    }
    private static int getHighrally(){
        try {
            File highrallyFile = new File("resources/highrally.txt");

            Scanner fileScanner = new Scanner(highrallyFile);
            int highrally = fileScanner.nextInt();
            fileScanner.close();
            return highrally;
        } catch (IOException e){
            System.err.println("Error getting high rally.");
            return 0;
        }
    }

    private static int getNewRally(){
        System.out.print("Enter new rally: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static void writeNewHighRally(int newHighrally){
        try{
            FileWriter fileWriter = new FileWriter("resources/highrally.txt");
            fileWriter.write(Integer.toString(newHighrally));
            fileWriter.close();
        } catch (IOException e){
            System.err.println("Error writing high rally.");
        }
    }
}