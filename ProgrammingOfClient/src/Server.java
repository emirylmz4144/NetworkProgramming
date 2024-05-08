import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
    //Bizim ana soketimiz
    private Socket socket=null;

    //Server için bağlanılacak socket
    private ServerSocket serverSocket=null;
    private DataInputStream inputStream=null;

    Server(int port) throws IOException {
        //Server bir porta bağlanarak soket oluşturur
        serverSocket=new ServerSocket(port);
        System.out.println("Sunucu başlatıldı ");

        //bağlanılan soket ana sokete atanıyor
        System.out.println("Bir client (istemci) bekleniyor...");
        socket=serverSocket.accept();

        //Client(İstemci)'nin soketinden girdi alınıyor
        inputStream=new DataInputStream(new DataInputStream(socket.getInputStream()));

        String letter="";
        while (!(letter.equals("Bitti")))
        {
            letter=inputStream.readUTF();
            System.out.println(letter);
        }

        inputStream.close();
        serverSocket.close();
    }

    public static void main(String[] args) throws IOException {
        Server server=new Server(5000);
    }
}
