import org.junit.Assert;
import org.junit.Test;

public class TestMoodAnalyzer {
    MoodAnalyzer analyzer = new MoodAnalyzer();
    //Analyse Mood IS SAD
    @Test
    public void moodAnalyzerclass_WhenMessageIncludeSad_ShouldReturnSad() {
        String result = analyzer.moodAnalyse("I am in sad mood");
        Assert.assertEquals("SAD", result);
    }
    //Analyse Mood IS HAPPY
    @Test
    public void moodAnalyzerclass_WhenMessageIncludeHappy_ShouldReturnHappy(){
        String result = analyzer.moodAnalyse("I am in happy mood");
        Assert.assertEquals("HAPPY", result);
    }
}