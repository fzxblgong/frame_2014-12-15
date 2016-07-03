/**
 * 
 */
package sxt_test.chat_room.test01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author Administrator
 *
 */
public class SocketUrl {
	public static void main(String[] args) {
		try {
			URL url = new URL("http://127.0.0.1:2016");
            try {
				URLConnection connection = url.openConnection();
				 InputStream inInfo = connection.getInputStream();
				 BufferedReader bf = new BufferedReader(new InputStreamReader(inInfo));
					String s;
					while((s = bf.readLine()) != null){
						System.out.println(s);
					}
	                /*int n = 512;  
	                byte buffer[] = new byte[n];  
	                int temp;
	                while ((temp = inInfo.read(buffer, 0, n)) != -1 && (n > 0)) {  
	                   System.out.println(temp);
	                }  */
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
