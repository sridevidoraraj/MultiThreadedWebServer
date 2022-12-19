import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Properties;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.asList(args).toString());
        try {

            Properties properties = new Properties();
            FileReader fr = new FileReader("src/main/resources/application.properties");


            properties.load(fr);
            int number = Integer.parseInt(properties.getProperty("server.port"));
            ServerSocket server = new ServerSocket(number);
            int counter = 0;
            System.out.println("Server Started ....");
            while (true) {
                counter++;
                Socket serverClient = server.accept();
                System.out.println(" >> " + "Client No:" + counter + " started!");
                ServerThread sct = new ServerThread(serverClient, counter);
                sct.start();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
