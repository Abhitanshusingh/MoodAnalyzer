import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerFactory
{
    public static MoodAnalyzer createMoodAnalyserObject() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class <?> moodAnalyze=Class.forName("MoodAnalyzer");
        Constructor<?> moodAnalysisConstructor = moodAnalyze.getConstructor();
        Object moodObject = moodAnalysisConstructor.newInstance();
         return  (MoodAnalyzer) moodObject;
    }
}