/**
 * 
 */
package sxt_test.chat_room.test01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Administrator
 *
 */
public class ClientSocket01 {
	public static void main(String[] args) {
		System.out.println("Client start");
		int port = 2016;
		try {
			Socket socket = new Socket("127.0.0.1",port);
			socket.setSoTimeout(60000);
			
			PrintWriter printerWriter = new PrintWriter(socket.getOutputStream());
			BufferedReader bufferReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String serverRequestStr = "I am online.";
			/**
			 * 向服务器写发送信息
			 */
			
			BufferedReader sysBuff = null;
			while(!serverRequestStr.equals("bye")){
				//读取键盘输入
				sysBuff = new BufferedReader(new InputStreamReader(System.in));
				serverRequestStr = sysBuff.readLine();
				printerWriter.println(serverRequestStr);
				printerWriter.flush();
				//服务器应答信息
				String serverResponseStr = bufferReader.readLine();
				System.out.println(serverResponseStr);
			}
			/**
			 * 关闭套接
			 */
			 printerWriter.close();
			 bufferReader.close();
			 socket.close();
			 System.out.println("Client finish");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
