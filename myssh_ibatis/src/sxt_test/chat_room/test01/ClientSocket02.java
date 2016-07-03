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
 * 并发聊天室客户端
 * @author Administrator
 *
 */
public class ClientSocket02 {
	public static void main(String[] args) {
		System.out.println("Client start");
		int port = 2016;
		try {
			Socket socket = new Socket("127.0.0.1",port);
//			socket.setSoTimeout(60000);
			//启动服务器消息监听线程
			SocketReceiveRunnable socketRunnable = new SocketReceiveRunnable(socket);
			Thread sT = new Thread(socketRunnable);
			sT.start();
			
			PrintWriter printerWriter = new PrintWriter(socket.getOutputStream());
			String serverRequestStr = "";
			BufferedReader sysBuff = null;
			while(!serverRequestStr.equals("bye")){
				//读取键盘输入
				sysBuff = new BufferedReader(new InputStreamReader(System.in));
				serverRequestStr = sysBuff.readLine();
				printerWriter.println(serverRequestStr);
				printerWriter.flush();
			}
			/**
			 * 关闭套接
			 */
			 try {
				Thread.sleep(2000);//等待消息线程关闭
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 printerWriter.close();
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
	/**
	 * 阻塞等待服务器消息
	 * @author Administrator
	 *
	 */
	public static class SocketReceiveRunnable implements Runnable{
		private Socket socket; 
		private BufferedReader bufferReader;
		public SocketReceiveRunnable(Socket socket) throws IOException{
			this.socket = socket;
			this.bufferReader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
		}
		/* 
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
			System.out.println("客户端消息监听 start.");
			//服务器应答信息
			String serverResponseStr = "";
			while(!serverResponseStr.equals("bye")){
				try {
					serverResponseStr = this.bufferReader.readLine();
					System.out.println("收到服务器信息："+serverResponseStr);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					break;
				}
			}
			System.out.println("客户端消息监听 end.");
		}
		
	}
}
