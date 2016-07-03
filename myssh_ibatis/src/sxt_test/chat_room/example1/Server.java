/**
 * 
 */
package sxt_test.chat_room.example1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
public class Server {
    boolean started = false;
    ServerSocket ss = null;
    List<ChatClient> clients = new ArrayList<ChatClient>(); //保存客户端线程类
    public static void main(String[] args) {
        new Server().start();
    }
    void start() {
        try {
            ss = new ServerSocket(9999); //建立服务端对象
            started = true;
        } catch (BindException e) {
            System.out.println("端口使用中");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            while (started) {
                Socket s = ss.accept(); //接收客户端
                ChatClient c = new ChatClient(s);
                System.out.println("客戶端接收成功");
                new Thread(c).start(); //启动线程
                clients.add(c); //添加线程类
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                ss.close();
            } catch (IOException e) {
                // TODO 自动生成 catch 块
                e.printStackTrace();
            }
        }
    }
    class ChatClient implements Runnable { //建立客户端线程接收，发送数据
        private Socket s;
        DataInputStream dis = null;
        DataOutputStream dos = null;
        boolean bConnected = false;
        public ChatClient(Socket s) {
            this.s = s;
            try {
                dis = new DataInputStream(s.getInputStream());
                dos = new DataOutputStream(s.getOutputStream());
                bConnected = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        void send(String str) {
            try {
                dos.writeUTF(str);
            } catch (SocketException e) {
                System.out.println("對方退出了");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public void run() {
            try {
                while (bConnected) {
                    String str = dis.readUTF();
                     System.out.println(str);
                    for (int i = 0; i < clients.size(); i++) {
                        ChatClient c = clients.get(i);
                        c.send(str);
                    }
                }
            } catch (EOFException e) {
                System.out.println("客戶端退出了");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (dis != null)
                    if (s != null)
                        try {
                            dis.close();
                            s.close();
                            dos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
            }
        }
    }
}
