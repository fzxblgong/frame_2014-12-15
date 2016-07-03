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
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 并发聊天室服务端
 * @author Administrator
 *
 */
public class ServerSocket03 {
	public static Map<String,Object> synMap = new HashMap<String,Object>();
	
	public static void main(String[] args) throws IOException {
		System.out.println("server start");
		ServerSocket serverSocket = new ServerSocket(2016);
		while(true){
			Socket socket = serverSocket.accept();
			ServerSocketRunnable serverSocketRunnable = new ServerSocketRunnable(socket);
			Thread socketThread = new Thread(serverSocketRunnable);
			socketThread.start();
		}
	}
	//线程类
	public static class ServerSocketRunnable implements Runnable{
		private Socket socket;
		private PrintWriter printerWriter;
		private InputStreamReader clientRequestIS;
		
		private BufferedReader bfReader;
		private String clientRequesStr;
		
		public ServerSocketRunnable(Socket socket) throws IOException{
			this.socket = socket;
			this.clientRequestIS = new InputStreamReader(socket.getInputStream());
			this.printerWriter = new PrintWriter(this.socket.getOutputStream());
			this.bfReader = new BufferedReader(clientRequestIS);
			this.clientRequesStr = this.bfReader.readLine();
		}
		@Override
		public void run() {
			System.out.println("socket start:"+Thread.currentThread().getName());
			String thisThreadId = Thread.currentThread().getId()+"";//线程标记
			ServerSocket03.synMap.put(thisThreadId, this.printerWriter);
			
			while(!this.clientRequesStr.equals("bye")){
				System.out.println("客户端信息:"+clientRequesStr);
				//服务器应答回复
				broadcastToClient(clientRequesStr);
				//继续等待客户端信息
				try {
					clientRequesStr = bfReader.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					clientRequesStr = "bye";
					ServerSocket03.synMap.remove(thisThreadId);
				}
			}
			printerWriter = (PrintWriter) ServerSocket03.synMap.get(thisThreadId);
			if(null != printerWriter){
				ServerSocket03.synMap.remove(thisThreadId);
				printerWriter.println(clientRequesStr);
				printerWriter.flush();
			}
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
		//广播
		private void broadcastToClient(String serverResponseStr){
		  PrintWriter printWriterTemp = null;
	      for (Map.Entry<String, Object> entry : ServerSocket03.synMap.entrySet()) {
	    	  System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
	    	  printWriterTemp = (PrintWriter) entry.getValue();
	    	  printWriterTemp.println("广播信息->"+serverResponseStr);
			  printWriterTemp.flush();
		  }
		}
	}

}
