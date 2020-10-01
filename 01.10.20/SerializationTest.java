import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

class SerializationTest {
    public static void main(String[] args) {





    }
}
/*
enum cacheEnum {FILE, IN_MEMORY}

//public enum Color {RED, GREEN, BLUE}

@interface Cache {
    cacheEnum cacheType();
    String fileNamePrefix();
    boolean zip();
    int listList();
    Class<?>[] identityBy();
}
*/




class Service implements Serializable {

    public enum cacheEnum {
        FILE, IN_MEMORY
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ ElementType.METHOD })
    public @interface Cache {
        cacheEnum cacheType();
        String fileNamePrefix();
        boolean zip();
        int listList();
        Class<?>[] identityBy();
    }




    public double doHardWork(String name, int value){


        double result = 0;



    @Cache(cacheType = FILE, fileNamePrefix = "data", zip = true, identityBy = {String.class, double.class})
    List<String> run(String item, double value, Date date);

    @Cache(cacheType = IN_MEMORY, listList = 100_000)
    List<String> work(String item);
    @Cache(cacheType = FILE, fileNamePrefix = "data", zip = true, identityBy = {String.class, double.class})
    List<String> run(String item, double value, Date date);

    @Cache(cacheType = IN_MEMORY, listList = 100_000)
    List<String> work(String item);

        return result;

    }
}