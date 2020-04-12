import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {

    public Server () /*throws IOException*/{
    }

    public void run(){
        Socket socket = null;

        try (ServerSocket serverSocket = new ServerSocket(3746)) {
            System.out.println("Сервер запущен, ожидаем подключения...");
            socket = serverSocket.accept(); //ждем клиента
            System.out.println("Клиент подключился");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            String str = in.readUTF(); //получение сообщения от клиента
            FileWriter wr = new FileWriter("cat1.ser");
            wr.write(str);
            //System.out.println("Сервер получил: " + str);
            //out.writeUTF("Привет-привет..."); //ответ сервера
            wr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

