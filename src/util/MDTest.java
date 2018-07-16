package util;

import java.io.File;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** 
* @author: jan 
* @date: 2018年5月9日 下午2:11:25 
*/
public class MDTest {

	public static String getMD5Str(String str) throws Exception {  
        try {  
            // 生成一个MD5加密计算摘要  
            MessageDigest md = MessageDigest.getInstance("MD5");  
            // 计算md5函数  
            md.update(str.getBytes());  
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符  
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值  
            return new BigInteger(1, md.digest()).toString(16);  
        } catch (Exception e) {  
            throw new Exception("MD5加密出现错误，"+e.toString());  
        }  
    }  
	
	public static void main(String[] args) throws Exception {
		String md5 = getMD5Str("a123456");
		System.out.println(md5);
		
		Set<String> dirName = new HashSet<String>();
		dirName.add("asd");
		dirName.add("zxc");
		dirName.add("123");
		int len = dirName.size();
		dirName.add("123");
		if(dirName.size() == len) {
			System.out.println("重名");
		}
		
		 List<String> list = new ArrayList<String>();
	        list.add("a");
	        list.add("b");
	        list.add("c");
	        System.out.println("未修改前:");
	        for (String s : list) {
	            System.out.println(s);
	        }
	 
	        list.set(0, "修改之后的元素");//修改对应的元素
	        System.out.println("已修改后:");
	        for (String s : list) {
	            System.out.println(s);
	        }
	        
	        String root = "E:\\BaiduNetdiskDownload\\眼底照";
	        File file = new File(root);
	        File[] files = file.listFiles();
	        System.out.println(files[0].getName());
	        
	        String dir = "E:\\BaiduNetdiskDownload\\眼底照";
	        File[] filess = new File(dir).listFiles();
			for(File fi : filess) {
				if(!fi.isDirectory()) {
					String[] str = fi.getName().split("[.]");
					if("jpg".equals(str[1].toLowerCase()) || "png".equals(str[1].toLowerCase())
							|| "jpeg".equals(str[1].toLowerCase())) {
						System.out.println(dir + "," + fi.getName());
					}
				}else {
					File[] child = new File(dir + "/" + fi.getName()).listFiles();
					String imgname = fi.getName() + "_";
					for(File ffi : child) {
						if(!ffi.isDirectory()) {
							String[] str = ffi.getName().split("[.]");
							if("jpg".equals(str[1].toLowerCase()) || "png".equals(str[1].toLowerCase())
									|| "jpeg".equals(str[1].toLowerCase())) {
								System.out.println(dir + "," + imgname + ffi.getName());
							}
						}
					}
				}
			}
	}
	
}
