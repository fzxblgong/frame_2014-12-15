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
public class SocketClient {
	public static void main(String[] args) {
		System.out.println("客户端启动");
		int port = 2016;
		try {
			Socket socket = new Socket("127.0.0.1",port);
			socket.setSoTimeout(60000);
			/**
			 * 向服务器写信息
			 */
			PrintWriter printerWriter = new PrintWriter(socket.getOutputStream());
			//控制台读取信息，完成后关闭
			BufferedReader sysBuff = new BufferedReader(new InputStreamReader(System.in));
			String clientSayInfo = sysBuff.readLine();
			printerWriter.println(clientSayInfo);
			printerWriter.flush();
			/**
			 * 从服务器获得信息
			 */
			 BufferedReader bufferReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			 String lineStr = bufferReader.readLine();
			 System.out.println(lineStr);
			/**
			 * 关闭套接
			 */
			 printerWriter.close();
			 bufferReader.close();
			 socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
