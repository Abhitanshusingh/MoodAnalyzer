import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MoodAnalyzerFactory {
    //LOGIC FOR TO GET CONSTRUCTOR
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

    //LOGIC FOR TO CREATE OBJECT
    public static Object createMoodAnalyserObject(Constructor<?> constructor, Object... message) throws MoodAnalysisException {
        try {
            return constructor.newInstance(message);
        } catch (IllegalAccessException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_ACCESS, e.getMessage());
        } catch (InstantiationException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.OBJECT_CREATION_ISSUE, e.getMessage());
        } catch (InvocationTargetException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, e.getMessage());

        }
    }

    //LOGIC FOR TO INVOKE MOODANALYZER OBJECT
    public static Object invokeMethod(Object moodObject, String analyseMood) throws MoodAnalysisException {
        try {
            Method callMethod = moodObject.getClass().getMethod(analyseMood);
            Object result = callMethod.invoke(moodObject);
            return result;
        } catch (IllegalAccessException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_ACCESS, e.getMessage());
        } catch (InvocationTargetException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.METHOD_INVOCATION_ISSUE, e.getMessage());
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, e.getMessage());
        }
    }

    //LOGIC FOR TO SET VALUE IN MOODANALYZER FIELD
    public static void setFieldValue(Object moodObject, String fieldName, String fieldValue) throws MoodAnalysisException {
        Class<?> className = moodObject.getClass();
        try {
            Field field = className.getDeclaredField(fieldName);
            field.set(moodObject, fieldValue);
        } catch (NoSuchFieldException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_FIELD, e.getMessage());
        } catch (IllegalAccessException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_ACCESS, e.getMessage());
        }
    }
}