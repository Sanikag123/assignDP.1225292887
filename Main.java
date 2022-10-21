public class Main {
    public static void main(String[] args) {
/**
 * This façade object provides a single interface to the more general facilities of other subsystems.
 * Through facade the internal details of the subsystems are hidden and only essentials details are shown.
 */
        Facade facade = new Facade();
        boolean flag = facade.login();


    }
}