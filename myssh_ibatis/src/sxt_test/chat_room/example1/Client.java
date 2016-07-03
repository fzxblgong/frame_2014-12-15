/**
 * 
 */
package sxt_test.chat_room.example1;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
public class Client extends Frame { 
	private static final long serialVersionUID = 1L;
	TextField tf = new TextField(); //输入框对象
    TextArea ta = new TextArea(); //显示框对象
    Socket s = null;
    DataOutputStream dos = null;
    DataInputStream dis = null;
    boolean bConnected = false;
    recvThread r = new  recvThread(); //线程类
    public void creatFrame() { //产生图形界面     
        this.setBounds(300, 300, 300, 300);
        ta.setEditable(false);
        this.add(tf, BorderLayout.SOUTH);
        this.add(ta, BorderLayout.NORTH);
        this.addWindowListener(new WindowAdapter() { //响应关闭窗口事件
                    public void windowClosing(WindowEvent e) {
                        disconnect();
                        System.exit(0);
                    }
                });
        tf.addActionListener(new tfListener()); //响应输入事件
        this.pack();
        this.setVisible(true);
        connect();
        new Thread(r).start();
    }
    public void connect() {
        try {
            s = new Socket("127.0.0.1", 9999); //建立客户端对象
            dos = new DataOutputStream(s.getOutputStream());
            dis = new DataInputStream(s.getInputStream());
            bConnected = true;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void disconnect() { //窗口关闭时关闭客户端，输入，输出
        try {
            dos.close();
            dis.close();
            s.close();
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }
    class tfListener implements ActionListener { //输入框实现的接口，响应输入事件
        public void actionPerformed(ActionEvent e) {
            String str = tf.getText();
            //ta.setText(str);
            tf.setText("");
            try {
                dos.writeUTF(str);
                dos.flush();
                //dos.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
    class recvThread implements Runnable { //客户端线程接收数据
        public void run() {
            try {
                while (bConnected) {
                    String str;
                    str = dis.readUTF(); //拿到数据
                    ta.setText(ta.getText() + str + "/n");//显示到显示框中
                }
            } catch (SocketException e) {
                System.out.println("退出了");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
    //启动
    public static void main(String[] args) {
        new Client().creatFrame();
    }
}