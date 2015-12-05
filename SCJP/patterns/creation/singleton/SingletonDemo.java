package creation.singleton;

public class SingletonDemo {
    private static volatile SingletonDemo instance = null;
    private SingletonDemo() { }

    public static synchronized SingletonDemo getInstance() {
        if (instance == null) {
            instance = new SingletonDemo();
        }

        return instance;
    }
}

