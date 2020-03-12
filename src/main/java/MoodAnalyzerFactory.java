import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerFactory {
    public static MoodAnalyzer createMoodAnalyserObject() throws MoodAnalysisException {
        try {
            Class<?> moodAnalyze = Class.forName("MoodAnalyzer");
            Constructor<?> moodAnalysisConstructor = moodAnalyze.getConstructor(Integer.class);
            Object moodObject = moodAnalysisConstructor.newInstance();
            return (MoodAnalyzer) moodObject;
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS, "Class not found");
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, "Method not found");
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