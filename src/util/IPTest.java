package util;

import java.net.InetAddress;
import java.net.UnknownHostException;

/** 
* @author: jan 
* @date: 2018年4月28日 上午10:16:20 
*/
public class IPTest {

	public static void main(String[] args) throws UnknownHostException {
		InetAddress address = InetAddress.getLocalHost();
		String ipname = address.getHostName();
		String ip = address.getHostAddress();
		System.out.println(ip);
	}
	
}
