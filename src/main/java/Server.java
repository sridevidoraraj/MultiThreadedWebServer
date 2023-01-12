import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Properties;
import java.util.logging.Logger;

public class Server {
    static Logger logger = Logger.getLogger(Server.class.getName());

    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.asList(args).toString());

        logger.info("\u001B[32m"+"Displaying file name : "+logger.getName()+ "\u001B[0m");
        try {

            Properties properties = new Properties();
            FileReader fr = new FileReader("src/main/resources/application.properties");

            properties.load(fr);
            int number = Integer.parseInt(properties.getProperty("server.port"));
            ServerSocket server = new ServerSocket(number);
            int counter = 0;
            logger.info("\u001B[32m" +"server started"+ "\u001B[0m");
//            System.out.println("Server Started ....");
            while (true) {
                counter++;
                Socket serverClient = server.accept();
                logger.config("configuration started");
//                System.out.println(" >> " + "Client No:" + counter + " started!");
                logger.info("\u001B[34m"+"Client No : " +counter+ " started"+ "\u001B[0m");
                ServerThread sct = new ServerThread(serverClient, counter);
                sct.start();
            }

        } catch (Exception e) {
            logger.severe("Error loading client request" +e);
//            System.out.println(e);
        }

    }
}
