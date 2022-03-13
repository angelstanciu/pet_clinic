import console.Console;
import utils.SessionManager;

public class Main {
    public static void main(String[] args) {
        Console.startApp();
        SessionManager.shutdown();
    }
}
