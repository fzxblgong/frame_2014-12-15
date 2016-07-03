/**
 * 
 */
package sxt_test.chat_room.test01;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 文件发送客户端
 * @author Administrator
 *
 */
public class SocketFileClient01 {
	public static void main(String[] args) {
		System.out.println("客户端启动");
		int port = 2016;
		try {
			Socket socket = new Socket("127.0.0.1",port);
			File file = new File("d:/star.rmvb");
			FileInputStream fis = new FileInputStream(file);
			
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(file.getName());
			dos.flush();
			dos.writeLong(file.length());
			dos.flush();
			
			byte[] fileBytes = new byte[1024];
			int len = 0;
			while((len = fis.read(fileBytes,0,fileBytes.length)) != -1){
				dos.write(fileBytes,0,len);
				dos.flush();
			}
			fis.close();
			/**
			 * 关闭套接
			 */
			dos.close();
			 socket.close();
			 System.out.println("文件已发送完毕,源路径："+file.getAbsolutePath());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
