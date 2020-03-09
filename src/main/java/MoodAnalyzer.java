public class MoodAnalyzer {
    private String message;

    public MoodAnalyzer() {

    }

    public MoodAnalyzer(String message) {

        this.message = message;
    }

    public String analyseMood() throws MoodAnalysisException {
        try {
            if (message.length() == 0)
                throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_EMPTY, "Please enter proper mood");
            if (message.contains("sad"))
                message = "SAD";
            else
                message = "HAPPY";
            return message;
        } catch (NullPointerException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_NULL, "Please enter proper mood");
        }
    }
}
