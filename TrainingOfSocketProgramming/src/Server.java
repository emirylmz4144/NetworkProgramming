import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server
{
    public static final  int PORT=4545;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(PORT);

        Socket socket=serverSocket.accept();




        while (true)
        {
            PrintWriter output=new PrintWriter(socket.getOutputStream(),true);
            output.println("Emir");
            socket=serverSocket.accept();
        }




        //serverSocket.close();
        //socket.close();



    }
}
