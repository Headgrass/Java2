import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Server {


    public static void main(String[] args) {
        Server server = new Server();
    }

    public Server() {

        // розетка сервера
        ServerSocket server = null; // иницилизация локальной перемннной, так что пишу нолик
        // розетка клиента, это некий поток, который будет подключаться к серверу
        Socket socket = null;

        try {
            // порт, который будет прослушивать наш сервер
            server = new ServerSocket(8189);
            System.out.println("Server is working...");
            socket = server.accept();
            System.out.println("New Client");
            // входящий поток
            Scanner in =  new Scanner(socket.getInputStream());
            // исходящий поток
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true); //или пишем внизу метод
            // с консоли
            Scanner sc = new Scanner(System.in);

            // отправляем в этом потоке сообщение от сервера
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        System.out.println("Server, write you message");
                        String msg = sc.nextLine();
                        System.out.println("The message was send");
                        out.println(msg);
                    }
                }
            }).start();
            // в главном потоке получаем сообщение и шлем эхо
            while (true) {
                String msg = in.nextLine();
                if (msg.equals("/end")) break;
                System.out.println("Client: " + msg);
                //               out.flush(); // это автоматический/принудительный сброс буфера вывода
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close(); // закрываем розетку сервера
                server.close(); // закрываем розетку клиента
                System.out.println("Server closed");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}