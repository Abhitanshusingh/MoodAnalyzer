import java.util.Objects;

public class MoodAnalyzer {
    private String message;
    //DEFAULT CONSTRUCTOR
    public MoodAnalyzer() {

    }
    //PARAMETERIZED CONSTRUCTOR
    public MoodAnalyzer(String message) {
        this.message = message;
    }
    //LOGIC TO ANALYSE MOOD OF USER
    public String analyseMood() throws MoodAnalysisException {
        try {
            if (message.length() == 0)
                throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_EMPTY, "Please enter proper mood");
            if (message.contains("sad"))
                message = "SAD";
            else if (message.contains("happy"))
                message = "HAPPY";
            return message;
        } catch (NullPointerException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_NULL, "Please enter proper mood");
        }
    }
    //LOGIC TO CHECK OBJECT ARE EQUAL OR NOT
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoodAnalyzer that = (MoodAnalyzer) o;
        return Objects.equals(message, that.message);
    }
}
