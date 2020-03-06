public class MoodAnalyzer {
    private String message;

    public MoodAnalyzer() {

    }
    public MoodAnalyzer(String message) {
        this.message = message;
    }
    public String analyseMood() {
        if (message.length() == 0) {
            System.out.println("Enter mood");
        }
        if (message.contains("sad"))
            message = "SAD";
        else if (message.contains("happy"))
            message = "HAPPY";
        return message;
    }
}
