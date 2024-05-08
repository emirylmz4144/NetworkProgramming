import java.io.*;
import java.net.Socket;

public class Client
{
    private Socket socket=null;
    private DataInputStream inputStream=null;
    private DataOutputStream outputStream=null;

    Client(String address,int port) throws IOException {
        //Bağlantı kurulması(socket'i bu adresteki bu portta aç)
        socket=new Socket(address,port);
        System.out.println("Sunucuya bağlandı");

        //system.in ile terminaldan data girişi alınacak.
        inputStream=new DataInputStream(System.in);

        //Socket' data aktarımı olaağı için socketin //outputStream'ini alıyoruz
        // ve veriyi bir veri çıktısı haline getiriyouruz
        outputStream=new DataOutputStream(socket.getOutputStream());

        String letter="";
        while (!(letter.equals("Bitti")))
        {
            try {
                //Girdiyi alır
                letter=inputStream.readLine();
                //Veriyi outputstream ile aktardı
                outputStream.writeUTF(letter);
            }catch (IOException e)
            {
                System.out.println(e.getMessage());
            }

        }
        //inputlar outputlar ve socket kapatılır.
        inputStream.close();
        outputStream.close();
        socket.close();

    }

    public static void main(String[] args) throws IOException {
        Client client=new Client("127.0.0.1",5000);
    }

}
