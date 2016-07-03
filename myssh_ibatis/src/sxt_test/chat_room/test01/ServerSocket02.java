/**
 * 
 */
package sxt_test.chat_room.test01;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 多线程开启
 * @author Administrator
 *
 */
public class ServerSocket02 {

	public static void main(String[] args) throws IOException {
		System.out.println("server start");
		ServerSocket serverSocket = new ServerSocket(2016);
		while(true){
			Socket socket = serverSocket.accept();
			ServerSocketRunnable serverSocketRunnable = new ServerSocketRunnable(socket);
			new Thread(serverSocketRunnable).start();
		}
	}
	//线程类
	public static class ServerSocketRunnable implements Runnable{
		private Socket socket;
		public ServerSocketRunnable(Socket socket){
			this.socket = socket;
		}
		@Override
		public void run() {
			System.out.println("socket start:"+Thread.currentThread().getName());
			//客户端请求信息
			PrintWriter printerWriter = null;
			try {
				printerWriter = new PrintWriter(socket.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//客户端请求信息
			InputStreamReader clientRequestIS = null;
			try {
				clientRequestIS = new InputStreamReader(socket.getInputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			BufferedReader bfReader = new BufferedReader(clientRequestIS);
			String clientRequesStr = null;
			try {
				clientRequesStr = bfReader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			try {
//				InputStream iiii = socket.getInputStream();
//				byte[] bytes = readStream(iiii);
//				String sTemp = new String(bytes);
//				System.out.println("流信息："+sTemp);
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			} catch (Exception e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
			
			while(!clientRequesStr.equals("bye")){
				System.out.println("客户端信息:"+clientRequesStr);
				//服务器应答回复
				String serverResponseStr = "我是服务端,已收到你的请求:"+clientRequesStr;
				printerWriter.println(serverResponseStr);
				printerWriter.flush();
				//继续等待客户端信息
				try {
					clientRequesStr = bfReader.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					clientRequesStr = "bye";
				}
			}
			printerWriter.println("我是服务端,已收到你的请求:"+clientRequesStr);
			printerWriter.flush();
			/**
			 * 关闭
			 */
			try {
				bfReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			printerWriter.close();
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("socket shutdown:"+Thread.currentThread().getName());
		}
		 /** 
	     * @功能 读取流 
	     * @param inStream 
	     * @return 字节数组 
	     * @throws Exception 
	     */  
	    public static byte[] readStream(InputStream inStream) throws Exception {  
	        ByteArrayOutputStream outSteam = new ByteArrayOutputStream();  
	        byte[] buffer = new byte[1024];  
	        int len = -1;  
	        while ((len = inStream.read(buffer)) != -1) {  
	            outSteam.write(buffer, 0, len);  
	        }  
	        outSteam.close();  
	        inStream.close();  
	        return outSteam.toByteArray();  
	    }  
		
	}

}
