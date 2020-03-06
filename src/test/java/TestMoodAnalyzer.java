import org.junit.Assert;
import org.junit.Test;

public class TestMoodAnalyzer {
    MoodAnalyzer analyzer;

    //Analyse Mood IS SAD
    @Test
    public void moodAnalyzerclass_WhenMessageIncludeSad_ShouldReturnSad() {
        analyzer = new MoodAnalyzer("I am in sad mood");
        Assert.assertEquals("SAD", analyzer.analyseMood());
    }

    //Analyse Mood IS HAPPY
    @Test
    public void moodAnalyzerclass_WhenMessageIncludeHappy_ShouldReturnHappy() {
        analyzer = new MoodAnalyzer("I am in happy mood");
        Assert.assertEquals("HAPPY", analyzer.analyseMood());
    }
}