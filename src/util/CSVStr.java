package util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.csvreader.CsvWriter;

/** 
* @author: jan 
* @date: 2018年5月25日 下午5:40:56 
*/
public class CSVStr {

	public static void main(String[] args) {
		String path = "C:\\Users\\CVTE\\Desktop\\img_cut\\data\\user7\\file\\F.眼底图标注.test_img\\001_001";
		List<String[]> list = ReadCSV.readCSV(path);
		for(String[] s : list) {
			System.out.println(s[7]);
		}
		
		JSONObject json = JSON.parseObject(list.get(0)[7]);
		System.out.println(json.getString("label_data"));
		JSONArray arr = json.getJSONArray("label_data");
		System.out.println(arr);
		JSONObject obj = arr.getJSONObject(0);
		JSONObject min = JSON.parseObject(obj.getString("data"));
		System.out.println(min.getString("version"));
		JSONObject obj1 = arr.getJSONObject(1);
		JSONObject obj2 = arr.getJSONObject(2);
		System.out.println(obj1.getString("name"));
		System.out.println(obj2.getString("name"));
		
		updateCSV();
	}
	
	private static void updateCSV() {
		
		String path = "F:\\eclipse-workspace\\LabelDemoNew\\user3\\file\\dir";
		List<String[]> list = ReadCSV.readCSV(path);
		
		String csvPath = "F:\\eclipse-workspace\\LabelDemoNew\\user3\\file\\dir";
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
	    	String[] csvHeaders = { "id", "user", "dir","markedId","total",
	        		 "addTime", "imgAllName", "deleted"};
	        csvWriter.writeRecord(csvHeaders); 
	        
	        // 写内容  
	        for(String[] s : list) {
	        	String[] csvContent = {s[0], s[1], s[2], "" + 201, s[4], s[5], s[6], s[7]};
		        csvWriter.writeRecord(csvContent);
	        }
	        
	        String[] csvContent = {list.get(0)[0], list.get(0)[1], list.get(0)[2], "" + 201, 
	        		list.get(0)[4], list.get(0)[5], list.get(0)[6], "" + 1};
	        csvWriter.writeRecord(csvContent);
	        
	        csvWriter.close();  
	        System.out.println("--------CSV文件已经write写入--------");  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    }  
	}
	
}
