/**
 * 
 */
package sxt_test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 反射功能测试类
 * 测试java.lang.Class类的获取方式
 * @author Administrator
 *
 */
public class Demo01 {
	public static void main(String[] args) throws MalformedURLException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchMethodException{
		//图纸一张
		String className = "sxt_test.User";
		try {
			Class<?> clazz = Class.forName(className);
			Class<?> clazz2 = Class.forName(className);
			System.out.println(clazz.hashCode() + "--" + clazz2.hashCode());
			
			Class sc = String.class;
			Class s = className.getClass();
			System.out.println(sc == s);
			
			Class i = int.class;
			
			int[] a = new int[10];
			int[] ar1 = new int[30];
			double[] d = new double[1];
			System.out.println(a.getClass().hashCode());
			System.out.println(ar1.getClass().hashCode());
			System.out.println(d.getClass().hashCode());
			//动态加载类执行
			URL[] urls = new URL[]{new URL("file:/d:/test/")};
			URLClassLoader uc = new URLClassLoader(urls);
			Class c = uc.loadClass("User");
			Method m = c.getMethod("main", String[].class);
			m.invoke(null, (Object)new String[]{"aa,bb"});
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
