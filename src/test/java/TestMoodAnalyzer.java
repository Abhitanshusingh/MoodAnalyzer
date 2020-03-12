import org.junit.Assert;
import org.junit.Test;
import java.lang.reflect.Constructor;

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
        Constructor<?> moodAnalyzerObject = MoodAnalyzerFactory.getConstructor("MoodAnalyzer");
        Object myObject = MoodAnalyzerFactory.createMoodAnalyserObject(moodAnalyzerObject);
        boolean result = analyzer.equals(myObject);
        Assert.assertTrue(result);
    }

    @Test
    public void givenClassName_WhenImproper_ShouldThrowMoodAnalysisException() {
        analyzer = new MoodAnalyzer();
        try {
            Constructor<?> moodAnalyzerObject = MoodAnalyzerFactory.getConstructor("MoodyAnalyzer");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS, e.type);
        }
    }

    @Test
    public void givenClass_WhenConstructorNotProper_ShouldThrowMoodAnalysisException() {
        analyzer = new MoodAnalyzer();
        try {
            Constructor<?> moodAnalyzerObject = MoodAnalyzerFactory.getConstructor("MoodAnalyzer", Integer.class);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, e.type);
        }
    }

    @Test
    public void givenMoodAnalyzerClass_WhenProper_ShouldReturnObject() {
        try {
            analyzer = new MoodAnalyzer("Happy");
            Constructor<?> constructor = MoodAnalyzerFactory.getConstructor("MoodAnalyzer",String.class);
            Object moodObject =  MoodAnalyzerFactory.createMoodAnalyserObject(constructor,"Happy");
            boolean equal = analyzer.equals(moodObject);
            Assert.assertTrue(equal);
        } catch (MoodAnalysisException e) {
        }
    }
}