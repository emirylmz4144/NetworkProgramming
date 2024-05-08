import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client
{
    public static final String SERVER_IP = "127.0.0.1";
    public static final int SERVER_PORT = 4545;

    static Socket socket=null;


    public static void main(String[] args) throws IOException {
        socket=new Socket(SERVER_IP,SERVER_PORT);
        BufferedReader input=new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String answerOfServer=input.readLine();

        JOptionPane.showMessageDialog(null,answerOfServer);

        socket.close();

    }
}
