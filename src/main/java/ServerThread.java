import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;

public class ServerThread extends Thread{
    Socket serverClient;
    int clientNo;

    ServerThread(Socket inSocket,int counter){
        serverClient = inSocket;
        clientNo=counter;
    }
    public void run(){
        try{
//            os.write("Date: Fri, 31 Dec 1999 23:59:59 GMT\r\n".getBytes());
//            os.write("Server: Apache/0.8.4\r\n".getBytes());
//            os.write("Content-Type: text/html\r\n".getBytes());

//            os.write("Expires: Sat, 01 Jan 2000 00:59:59 GMT\r\n".getBytes());
//            os.write("Last-modified: Fri, 09 Aug 1996 14:21:40 GMT\r\n".getBytes());
//            os.write("\r\n".getBytes());
//            os.write("<TITLE>CSWeb</TITLE>".getBytes());
            FileInputStream input = new FileInputStream("D:\\Projects\\csweb\\index.html");
            System.out.println(input);

            DataOutputStream os = new DataOutputStream(serverClient.getOutputStream());

            os.write("HTTP/1.0 200 OK\r\n".getBytes());
            os.write("\r\n".getBytes());
            os.write(input.readAllBytes());
            os.flush();

            byte[] data = new byte[1024];
            int totRead = 0, numRead;
            while ((numRead = input.read(data)) != -1) {
                totRead += numRead;
                os.write(data, 0, numRead);
            }
//            os.write(("Content-Length: " + totRead + "\r\n").getBytes());
//            serverClient.close();
        }catch(Exception ex){
            System.out.println(ex);
        }finally{
            System.out.println("Client -" + clientNo + " exit!! ");
        }
    }
}
