import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerFactory {
    public static MoodAnalyzer createMoodAnalyserObject() throws MoodAnalysisException {
        try {
            Class<?> moodAnalyze = Class.forName("MoodyAnalyzer");
            Constructor<?> moodAnalysisConstructor = moodAnalyze.getConstructor();
            Object moodObject = moodAnalysisConstructor.newInstance();
            return (MoodAnalyzer) moodObject;
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS, "No class");
        } catch (NoSuchMethodException e) {
           e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}