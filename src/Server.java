import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Worker{

    public static void main(String[] args) throws IOException {
        System.out.println("waiting for connections");

        ServerSocket ss= new ServerSocket(1234);
        final Socket soc=ss.accept();
        System.out.println("connection received");

        new Worker().work(soc);
    }

}
