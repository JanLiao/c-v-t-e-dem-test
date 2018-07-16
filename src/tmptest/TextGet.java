package tmptest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csvreader.CsvWriter;

public class TextGet {

	public static void main(String[] args) {
		String path = "C:/Users/CVTE/Desktop/融合数据/第一批/2018-05-28214154";
		//textGet(path);
		
		textImg();
	}

	private static void textImg() {
		String path = "C:\\Users\\CVTE\\Desktop\\2018-05-28214154\\admin\\mixlabel";
		List<String[]> list = ReadCSV.readCSV(path + "/avgAllImg");
		File f = new File("F:/eclipse-workspace-new1/LabelViewNew/admin/mixlabel");
		if(!f.exists()) {
			f.mkdirs();
		}
		// || "D:/Work/研究项目/公共数据库/青光眼CD比/标注照片/450,22343_R.jpg".equals(s[1])
		String savepath = "F:\\eclipse-workspace-new1\\LabelViewNew\\admin\\mixlabel\\avgAllImg";
		for(String[] s : list) {
			if("D:/Work/研究项目/公共数据库/青光眼CD比/标注照片/450,22343_R.jpg".equals(s[1])
					) {
				//writeCSVNew1(s, savepath);
				appendCSVNew1(s, savepath);
				break;
			}
		}
	}
	
	private static void appendCSVNew1(String[] s, String csvPath) {
		try {  
	    	 BufferedWriter out = new BufferedWriter(new 

	    	           OutputStreamWriter(new FileOutputStream(csvPath,true),"UTF-8"),1024);
	        // 创建CSV写对象 例如:CsvWriter(文件路径，分隔符，编码格式);  
	        CsvWriter csvWriter = new CsvWriter(out, ',');  
	        csvWriter.writeRecord(s);
	        csvWriter.close();  
	        System.out.println("--------CSV文件已经append写入--------");  
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	}
	
	private static void writeCSVNew1(String[] s, String csvPath) {
		// 定义一个CSV路径  
	    try {  
	    	CsvWriter csvWriter = new CsvWriter(csvPath,',',Charset.forName("UTF-8"));
	        // 创建CSV写对象 例如:CsvWriter(文件路径，分隔符，编码格式);  
	       // CsvWriter csvWriter = new CsvWriter(out, ',');  
	        // 写表头  
	        String[] csvHeaders = { "task_path", "img_name","add_time", "operator"};
	        csvWriter.writeRecord(csvHeaders);  
	        csvWriter.writeRecord(s);
	        
	        csvWriter.close();  
	        System.out.println("--------CSV文件已经write写入--------");  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    } 
	}

	private static void textGet(String path) {
		String savepath = "C:\\Users\\CVTE\\Desktop\\kk";
		File[] files = new File(path).listFiles();
		for(File f : files) {
			String path1 = f.getName();
			List<String[]> list = ReadCSV.readCSV(path + "/" + path1 + "/file/imgAllLabel");
			
			List<String[]> list1 = new ArrayList<String[]>();
			for(String[] s : list) {
				if("3591_R.jpg".equals(s[3])) {
					list1.add(s);
				}
			}
			File tmp = new File(savepath + "/" + path1 + "/file");
			if(!tmp.exists()) {
				tmp.mkdirs();
			}
			
			writeCSVNew(list1, savepath + "/" + path1 + "/file/imgAllLabel");
		}
	}
	
	private static void writeCSVNew(List<String[]> list, String csvPath) {
		// 定义一个CSV路径  
	    try {  
	    	CsvWriter csvWriter = new CsvWriter(csvPath,',',Charset.forName("UTF-8"));
	        // 创建CSV写对象 例如:CsvWriter(文件路径，分隔符，编码格式);  
	       // CsvWriter csvWriter = new CsvWriter(out, ',');  
	        // 写表头  
	        String[] csvHeaders = { "id", "user", "dir","img_name","mark_time","zoom_ratio",
	        		"canvas_data", "label_data", "orign_dir", "img_sole_path"};
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
