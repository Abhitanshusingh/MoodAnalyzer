import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class TestMoodAnalyzer {
    MoodAnalyzer analyzer;

    @Test
    public void moodAnalyzer_WhenMessageIncludeSad_ShouldReturnSad() throws MoodAnalysisException {
        analyzer = new MoodAnalyzer("I am in sad mood");
        Assert.assertEquals("SAD", analyzer.analyseMood());
    }

    @Test
    public void moodAnalyzer_WhenMessageIncludeHappy_ShouldReturnHappy() throws MoodAnalysisException {
        analyzer = new MoodAnalyzer("I am in happy mood");
        Assert.assertEquals("HAPPY", analyzer.analyseMood());
    }

    @Test
    public void moodAnalyzer_WhenMessageIncludeNull_ShouldThrowException() {
        analyzer = new MoodAnalyzer(null);
        try {
            analyzer.analyseMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals("Please enter proper mood", e.getMessage());
        }
    }

    @Test
    public void moodAnalyzer_WhenMessageIncludeEmpty_ShouldThrowException() {
        analyzer = new MoodAnalyzer("");
        try {
            analyzer.analyseMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals("Please enter proper mood", e.getMessage());
        }
    }

    @Test
    public void givenMoodAnalyzer_WhenProper_ShouldReturnObject() throws MoodAnalysisException {
        analyzer = new MoodAnalyzer();
        MoodAnalyzer moodAnalyzerObject = MoodAnalyzerFactory.createMoodAnalyserObject();
        boolean result = analyzer.equals(moodAnalyzerObject);
        Assert.assertEquals(true, result);
    }

    @Test
    public void givenClassName_WhenImproper_ShouldThrowMoodAnalysisException() {
        analyzer = new MoodAnalyzer();
        try {
            MoodAnalyzer moodAnalyzerObject = MoodAnalyzerFactory.createMoodAnalyserObject();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS, e.type);
        }
    }
}