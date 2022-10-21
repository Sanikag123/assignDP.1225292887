import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
/**
 * This façade object provides a single interface to the more general facilities of other subsystems.
 * Through facade the internal details of the subsystems are hidden and only essentials details are shown.
 */
        Facade facade = new Facade();
        boolean flag = facade.login();

        BufferedWriter writer = null;
        try {
            writer = Files.newBufferedWriter(Paths.get("BuyerProductCart"));
            writer.write("");
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}