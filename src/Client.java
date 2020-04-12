//import javax.swing.*;
//import java.io.*;
//import java.net.Socket;
//
//public class Client implements Runnable {
//    private Socket socket;
//    private DataInputStream in;
//    private DataOutputStream out;
//
//
//    public Client(){
//    }
//
//    public void run() {
//        try {
//            openConnection();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    public void openConnection() throws IOException {
//        socket = new Socket("localhost", 3746);
//        in = new DataInputStream(socket.getInputStream());
//        out = new DataOutputStream(socket.getOutputStream());
//
//        BufferedReader br =new BufferedReader(new FileReader("cat.ser"));
//
//
//        String ms = br.readLine();
//        //System.out.println(ms);//неверно считывается изначально.
//        sendMessage(ms);
////        System.out.println("Отправляем сообщение на сервер.");
////        sendMessage("Приувед!!!"); //отправляем сообщение на сервер// сюда кинуть содержимое буффера
////        String str = in.readUTF(); //получаем ответ от сервера
////        System.out.println("Сервер ответил: " + str);
//        br.close();
//    }
//
//
//    public void sendMessage(String mess) {
//        try {
//            out.writeUTF(mess);
//        } catch (IOException e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Ошибка отправки сообщения");
//        }
//    }
//
//}
//
