import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MoodAnalyzerFactory {
    public static Constructor<?> getConstructor(String moodAnalyzer, Class<?>... param) throws MoodAnalysisException {
        try {
            Class<?> moodAnalyzeClass = Class.forName(moodAnalyzer);
            return moodAnalyzeClass.getConstructor(param);
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS, e.getMessage());
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, e.getMessage());
        }
    }

    public static Object createMoodAnalyserObject(Constructor<?> constructor, Object... message) throws MoodAnalysisException {
        try {
            return constructor.newInstance(message);
        } catch (IllegalAccessException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.OBJECT_CREATION_ISSUE, e.getMessage());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object invokeMethod(Object moodObject, String analyseMood) throws MoodAnalysisException {
        try {
            Method callMethod = moodObject.getClass().getMethod(analyseMood);
            Object result = callMethod.invoke(moodObject);
            return result;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(e, MoodAnalysisException.ExceptionType.NO_SUCH_METHOD);
        }
        return null;
    }

    public static void SetFieldValue(Object moodObject, String fieldName, String fieldValue) {
        Class<?> className = moodObject.getClass();
        try {
            Field field = className.getDeclaredField(fieldName);
            field.set(moodObject, fieldValue);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}