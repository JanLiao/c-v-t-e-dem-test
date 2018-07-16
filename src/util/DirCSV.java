package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.*;

import com.csvreader.CsvWriter;
import com.cvte.cons.Constant;
import com.cvte.entity.TaskDir;

/** 
* @author: jan 
* @date: 2018年5月24日 下午2:44:38 
*/
public class DirCSV {

	public static void saveDir(TaskDir dir) {
		String rootPath = System.getProperty("user.dir").replace("\\", "/");
		System.out.println(rootPath);
		File file = new File(rootPath + "/" + Constant.User + "/mixlabel/");
		if(!file.exists()) {
			file.mkdirs();
		}
		String csvPath = rootPath + "/" + Constant.User + "/mixlabel/dir";
		File f = new File(csvPath);
		if(!f.exists()) {
			try {
				f.createNewFile();
				writeCSV(dir);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			appendCSV(dir);
		}
	}

	private static void appendCSV(TaskDir dir) {
		String rootPath = System.getProperty("user.dir").replace("\\", "/");
		String csvPath = rootPath + "/" + Constant.User + "/mixlabel/dir";
		try {  
	    	 BufferedWriter out = new BufferedWriter(new 

	    	           OutputStreamWriter(new FileOutputStream(csvPath,true),"UTF-8"),1024);
	        // 创建CSV写对象 例如:CsvWriter(文件路径，分隔符，编码格式);  
	        CsvWriter csvWriter = new CsvWriter(out, ',');  
	        // 写表头  
	        //String[] csvHeaders = { "编号", "姓名", "年龄" };  
	        //csvWriter.writeRecord(csvHeaders);  
	        // 写内容  
	        //String
	        String[] csvContent = {dir.getId(), dir.getPath(), dir.getNums(), dir.getImgNums(), dir.getAddTime(), "0", Constant.User};
	        csvWriter.writeRecord(csvContent);
	        csvWriter.close();  
	        System.out.println("--------CSV文件已经append写入--------");  
	    } catch (IOException e) {
	        e.printStackTrace();
	    }  
	}

	private static void writeCSV(TaskDir dir) {
		String rootPath = System.getProperty("user.dir").replace("\\", "/");
		String csvPath = rootPath + "/" + Constant.User + "/mixlabel/dir";
		// 定义一个CSV路径  
	    try {  
	    	CsvWriter csvWriter = new CsvWriter(csvPath,',',Charset.forName("UTF-8"));
	        // 创建CSV写对象 例如:CsvWriter(文件路径，分隔符，编码格式);  
	       // CsvWriter csvWriter = new CsvWriter(out, ',');  
	        // 写表头  
	        String[] csvHeaders = { "id", "task_path", "nums","img_nums","add_time",
	        		 "deleted", "operator"};
	        csvWriter.writeRecord(csvHeaders);  
	        // 写内容  
	        String[] csvContent = {dir.getId(), dir.getPath(), dir.getNums(), dir.getImgNums(), dir.getAddTime(), "0", dir.getOperator()};
	        
	        csvWriter.writeRecord(csvContent);
	        csvWriter.close();  
	        System.out.println("--------CSV文件已经write写入--------");  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    } 
	}

	public static void updateDir(TaskDir task, int deleted) {
		String rootPath = System.getProperty("user.dir").replace("\\", "/");
		String csvPath = rootPath + "/" + Constant.User + "/mixlabel/dir";
		List<String[]> list = ReadCSV.readCSV(csvPath);
		for(int i = 0; i < list.size(); i++) {
			if(task.getPath().equals(list.get(i)[1])) {
				list.get(i)[5] = "" + deleted;
				break;
			}
		}
		//重新写回文件
		updateCSV(list);
	}

	private static void updateCSV(List<String[]> list) {
		String rootPath = System.getProperty("user.dir").replace("\\", "/");
		System.out.println(rootPath);
		File file = new File(rootPath + "/" + Constant.User + "/mixlabel/");
		if(!file.exists()) {
			file.mkdirs();
		}
		String csvPath = rootPath + "/" + Constant.User + "/mixlabel/dir";
		File f = new File(csvPath);
		if(!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	    try {  
	    	CsvWriter csvWriter = new CsvWriter(csvPath,',',Charset.forName("UTF-8"));
	        // 创建CSV写对象 例如:CsvWriter(文件路径，分隔符，编码格式);  
	       // CsvWriter csvWriter = new CsvWriter(out, ',');  
	        // 写表头  
	    	String[] csvHeaders = { "id", "task_path", "nums","img_nums","add_time",
	        		 "deleted", "operator"};
	        csvWriter.writeRecord(csvHeaders);  
	        // 写内容  
	        for(String[] s : list) {
	        	csvWriter.writeRecord(s);
	        }
	        
	        csvWriter.close();  
	        System.out.println("--------CSV文件已经write写入--------");  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    }  
	}

	
	
}
