public class MoodAnalyzer {
    private String message;

    public MoodAnalyzer() {

    }

    public MoodAnalyzer(String message) {
        this.message = message;
    }

    public String analyseMood() {
        try {
            if (message.length() == 0)
                System.out.println("Enter mood");
            if (message.contains("sad"))
                message = "SAD";
            else
                message = "HAPPY";
            return message;
        }
        catch(NullPointerException e){
            message="HAPPY";
        }
        return message;
    }
}
