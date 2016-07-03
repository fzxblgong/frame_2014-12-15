/**
 * 
 */
package sxt_test.chat_room.test01;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 文件接收服务端
 * @author Administrator
 *
 */
public class SocketFileServer01 {

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
			System.out.println("服务端启动");
			/**
			 * 侦听并接受到此套接字的连接。此方法在连接传入之前一直阻塞。(1次 request)
			 */
			Socket socket = serverSocket.accept();
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			String fileName = dis.readUTF();
			long fileLen = dis.readLong();
			//文件传输
			String filePath = "d:/test/"+fileName;
			FileOutputStream fos = new FileOutputStream(new File(filePath));
			byte[] sendBytes = new byte[1024];
			int tranlen = 0;
			System.out.println("文件开始传输...");
			long s = System.currentTimeMillis();
			while(true){
				int read = 0;
				read = dis.read(sendBytes);
				if(read == -1){
					break;
				}
				tranlen += read;
				fos.write(sendBytes,0,read);
				fos.flush();
				System.out.println("file per is："+Double.parseDouble(tranlen+"")/Double.parseDouble(fileLen+""));
			}
			long e = System.currentTimeMillis();
			System.out.println("文件传输完毕:"+filePath+" 耗时："+(e-s)+" 大小："+Double.parseDouble(fileLen+"")/1024+"kb");
			/**
			 * 关闭
			 */
			fos.close();
			dis.close();
			socket.close();
			serverSocket.close();
			System.out.println("服务器关闭");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
