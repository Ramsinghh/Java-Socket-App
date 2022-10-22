import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Worker {

    public void work(Socket soc){

        new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    Scanner psOut=new Scanner(soc.getInputStream());
                    while(psOut.hasNextLine()){
                        System.out.println(psOut.nextLine());
                    }
                } catch (IOException e) {}
            }
        }).start();

        new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    BufferedWriter psIn= new BufferedWriter(new OutputStreamWriter(soc.getOutputStream()));
                    Scanner sc=new Scanner(System.in);

                    while(sc.hasNextLine()){
                        psIn.write(sc.nextLine()+"\n");
                        psIn.flush();
                    }
                } catch (IOException e) {}
            }
        }).start();
    }

}
