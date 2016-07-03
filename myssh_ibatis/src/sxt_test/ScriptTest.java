/**
 * 
 */
package sxt_test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @author Administrator
 *
 */
public class ScriptTest {

	/**
	 * java 脚本引擎执行 js
	 * @Description:
	 * @param @param args
	 * @return void
	 * @throws ScriptException 
	 * @throws NoSuchMethodException 
	 * @throws IOException 
	 * @date 2016-7-2下午5:49:33
	 */
	public static void main(String[] args) throws ScriptException, NoSuchMethodException, IOException {
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine se = sem.getEngineByName("js");
		se.put("key1", "value");
		String str = "var user={name:'gxl',age:'18'};";
		str += "println(user.name);";
		se.eval(str);
		se.eval("key1 = 'vvvgxl'");
		System.out.println(se.get("key1"));
		
		se.eval("var x = 1+3+5;");
		System.out.println(se.get("x"));
		
		se.eval("function add(a,b){var sum = a+b;return sum;}");
		Invocable jsIn = (Invocable)se;
		Object res = jsIn.invokeFunction("add", new Object[]{11,12});
		System.out.println(res);
		//js java 
		String jsCode = "importPackage(java.util); var list = Arrays.asList([\"大学1\",\"北京大学xx\"]);";
		se.eval(jsCode);
		List<String> lls = (List<String>)se.get("list");
		for(String temp:lls){
			System.out.println(temp);
		}
		//java执行js
		URL url = ScriptTest.class.getClassLoader().getResource("scripttest.js");
		FileReader fr = new FileReader(url.getPath());
		se.eval(fr);
		fr.close();
		System.out.println(url.getPath());
		
	}

}
