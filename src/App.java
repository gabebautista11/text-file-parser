import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.print("hello world");
        Scanner scanner = new Scanner(new FileReader(new File("C:\\Users\\gabeb\\Documents\\Projects\\text-file-parser\\text-file-parser\\src\\temp.txt")));
        System.out.println(scanner.hasNextLine());
        String jsonString = "";
        while(scanner.hasNextLine()){
            String currentLine = scanner.nextLine();
            String[] splitString = currentLine.split("[\\t]+");
                jsonString += ("{ \"institution\": \"" + splitString[1] + "\" }, \n");
            System.out.println("Working....");
        }
        scanner.close();
        writeToFile(jsonString);
    }
    
    private static void writeToFile(String s){
        Path fileName = Path.of("json.txt");
        try{
        Files.writeString(fileName, s);
        System.out.print("Wrote to File");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}