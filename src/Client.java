import java.io.IOException;
import java.net.Socket;

public class Client extends Worker {

    public static void main(String[] args) throws IOException {

        System.out.println("Initiating connections");
        Socket soc = new Socket("localhost", 1234);
        System.out.println("connection succeed");
        new Worker().work(soc);
    }
}
