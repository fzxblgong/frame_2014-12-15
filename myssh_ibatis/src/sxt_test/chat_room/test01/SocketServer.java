/**
 * 
 */
package sxt_test.chat_room.test01;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Administrator
 *
 */
public class SocketServer {

	/**
	 * @Description:
	 * @param @param args
	 * @return void
	 * @author GongXinglin
	 * @date 2016-7-1下午3:41:46
	 */
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(2016);
			while(true){
				System.out.println("服务端启动");
				/**
				 * 侦听并接受到此套接字的连接。此方法在连接传入之前一直阻塞。(1次 request)
				 */
				Socket socket = serverSocket.accept();
				InputStreamReader isr = new InputStreamReader(socket.getInputStream());
				BufferedReader bfReader = new BufferedReader(isr);
				String lineStr = bfReader.readLine();
				System.out.println(lineStr);
				
				/**
				 * 向客户端回复消息(1次 response)
				 */
				PrintWriter printerWriter = new PrintWriter(socket.getOutputStream());
				String serverSayInfo = "我是服务端....";
				printerWriter.print(serverSayInfo);
				printerWriter.flush();
				/**
				 * 关闭
				 */
				bfReader.close();
				printerWriter.close();
				socket.close();
				System.out.println("服务器关闭");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
