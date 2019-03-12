import io.github.bonigarcia.wdm.WebDriverManager;

import static io.github.bonigarcia.wdm.DriverManagerType.IEXPLORER;

public class ThreadSafeSingleton {

    private static volatile ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {
    }

    public static ThreadSafeSingleton getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }

    public void getInternetExplorerDriver() {
        WebDriverManager.getInstance(IEXPLORER).setup();
    }
}
