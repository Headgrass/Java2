package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    Socket socket = null;
    DataInputStream in;
    DataOutputStream out;
    Server server;
    private String nick;
    private String login;
    private String clientName;

    public ClientHandler(Socket socket, Server server) {

        try {
            this.socket = socket;
            this.server = server;
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            new Thread(() ->{
                try {
                    //цикл аутентификации
                    while (true){
                        String str = in.readUTF();
                        if(str.startsWith("/auth")){
                            String[] token = str.split(" ");
                            String newnick = server.getAuthService()
                                    .getNicknameByLoginAndPassword(token[1], token[2]);
                            if(newnick != null){
                                sendMsg("/authok " + newnick);
                                nick = newnick;
                                login = token[1];
                                server.subscribe(this);
                                System.out.println("Клиент " + nick + " подключился");
                                break;
                            }else {
                                sendMsg("Неверный логин / пароль");
                            }
                        }
                        break;
                    }


                    //цикл работы
                    while (true) {
                        String str = in.readUTF();
                        if (str.startsWith("/")) {
                            if (str.equals("/end")) {
                                out.writeUTF("/end");
                                break;
                            }
                            if (str.startsWith("/w ")){
                                String[] msg = str.split(" ", 3);
                                if(msg.length==3){
                                    server.privMsg(this, msg [1], msg[2]);
                                }
                            }
                            }else
                                server.broadcastMsg(nick, str);
                        }

                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    server.unsubscribe(this);
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Клиент отключился");
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public String getnickname() {
        return nick;
    }
    
    
    public void sendMsg(String msg){
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getNick(){
        return nick;
    }
    public String getLogin(){
        return login;
    }
}
