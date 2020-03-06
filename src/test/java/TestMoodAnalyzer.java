import org.junit.Assert;
import org.junit.Test;

public class TestMoodAnalyzer {
    MoodAnalyzer analyzer = new MoodAnalyzer();
    //Analyse Mood
    @Test
    public void givenMoodAnalyzerClass_whenProper_ShouldRrturnObject() {
        String result = analyzer.moodAnalyse("I am in sad mood");
        Assert.assertEquals("SAD", result);
    }
}