package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/** 
* @author: jan 
* @date: 2018年4月20日 下午5:09:51 
*/
public class DateTest {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		Date now = new Date();
		c.setTime(now);
		c.add(Calendar.MONDAY, -1);
		c.add(Calendar.DATE, 0);
		Date m = c.getTime();
		String mon = format.format(m);
		System.out.println(mon);
		
		boolean flag = now.after(format.parse("2018-3-20"));
		System.out.println(flag);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
        Calendar cal = Calendar.getInstance();    
        cal.setTime(sdf.parse("2018-03-20"));    
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(sdf.parse("2018-03-22"));    
        long time2 = cal.getTimeInMillis();         
        long between_days=(time2-time1)/(1000*3600*24);  
        int sub = Integer.parseInt(String.valueOf(between_days));
        System.out.println(sub);
        
        String str = DateTest.class.getResource("help.html").toExternalForm();
        System.out.println(str);
	}
	
}
