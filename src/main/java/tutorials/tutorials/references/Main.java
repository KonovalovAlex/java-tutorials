package tutorials.references;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

public class Main {
    Object o = new Object();
    //если потеряли ссылку weakReference - вернёт нам ту же самую ссылку
    // но она удаляется при первом GC
    WeakReference<Object> weakReference = new WeakReference<Object>(o);

    //будет удалено только когда будет проблемы с памятью
    SoftReference< Object> softReference =  new SoftReference<Object>(o);

    ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
    //как только пройдет GC объект поместиться в referenceQueue
    PhantomReference<Object> phantomReference = new PhantomReference<>(o,referenceQueue);


    //практическое применение WeakReference - если много строк и они могут повторяться рассмотрим пример
    private static Map<String, WeakReference<String>> stringPool = new WeakHashMap<>();

    public String getFromPool(String value) {
        WeakReference<String> stringRef = stringPool.get(value);
        if (stringRef == null || stringRef.get() == null ) {
            stringRef = new WeakReference<String>(value);
            stringPool.put(value, stringRef);
        }

        return stringRef.get();
    }

    public static void main(String[] args) {

    }

}
