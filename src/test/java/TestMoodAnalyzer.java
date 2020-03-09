import org.junit.Assert;
import org.junit.Test;

public class TestMoodAnalyzer {
    MoodAnalyzer analyzer;

    @Test
    public void moodAnalyzerclass_WhenMessageIncludeSad_ShouldReturnSad() throws MoodAnalysisException {
        analyzer = new MoodAnalyzer("I am in sad mood");
        Assert.assertEquals("SAD", analyzer.analyseMood());
    }

    @Test
    public void moodAnalyzerclass_WhenMessageIncludeHappy_ShouldReturnHappy() throws MoodAnalysisException {
        analyzer = new MoodAnalyzer("I am in happy mood");
        Assert.assertEquals("HAPPY", analyzer.analyseMood());
    }

    @Test
    public void moodAnalyzerclass_WhenMessageIncludeNull_ShouldThrowException(){
        analyzer = new MoodAnalyzer(null);
        try {
            analyzer.analyseMood();
        }
        catch (MoodAnalysisException e){
            Assert.assertEquals("Please enter proper mood",e.getMessage());
        }
    }
}