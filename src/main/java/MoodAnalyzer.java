import java.util.Scanner;

public class MoodAnalyzer {
    public static void main(String[] args) {
        System.out.println("Welcome to mood analyzer");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your mood");
        String mood=sc.nextLine();
        sc.close();
        System.out.println(moodAnalyse(mood));
    }
    public static String moodAnalyse(String message) {
        if (message.length() == 0) {
            System.out.println("Enter mood");
        }
        if (message.contains("sad"))
            return "SAD";
        else
            return "HAPPY";
    }
}
