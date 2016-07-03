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
public class ServerSocket01 {

	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(2016);
			while(true){
				System.out.println("Server start");
				Socket socket = serverSocket.accept();
				PrintWriter printerWriter = new PrintWriter(socket.getOutputStream());
				//客户端请求信息
				InputStreamReader clientRequestIS = new InputStreamReader(socket.getInputStream());
				BufferedReader bfReader = new BufferedReader(clientRequestIS);
				String clientRequesStr = bfReader.readLine();
				while(!clientRequesStr.equals("bye")){
					System.out.println("客户端信息:"+clientRequesStr);
					//服务器应答回复
					String serverResponseStr = "我是服务端,已收到你的请求:"+clientRequesStr;
					printerWriter.println(serverResponseStr);
					printerWriter.flush();
					//继续等待客户端信息
					clientRequesStr = bfReader.readLine();
				}
				printerWriter.println("我是服务端,已收到你的请求:"+clientRequesStr);
				printerWriter.flush();
				/**
				 * 关闭
				 */
				bfReader.close();
				printerWriter.close();
				socket.close();
				System.out.println("Server shutdown");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
