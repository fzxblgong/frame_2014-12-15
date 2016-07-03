/**
 * 
 */
package sxt_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

/**
 * 动态编译执行测试
 * @author Administrator
 *
 */
public class DynamicCompile {
	public static void main(String[] args) {
		JavaCompiler jc = ToolProvider.getSystemJavaCompiler();
		int r = jc.run(null, null, null, "d:/test/User.java");
		
		Runtime run = Runtime.getRuntime();
		try {
			Process pr = run.exec("java -cp d:/test/ User");
			InputStream in = pr.getInputStream();
			BufferedReader bf = new BufferedReader(new InputStreamReader(in));
			String s;
			while((s = bf.readLine()) != null){
				System.out.println(s);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
