package util;
/** 
* @author: jan 
* @date: 2018年5月27日 下午2:15:22 
*/
public class CoverTest {

	public static void main(String[] args) {
		double radius = 50;
		double left1 = 277;
		double top1 = 135;
		double angle1 = 30;
		double scaleX1 = 0.68;
		double scaleY1 = 0.84;
		
		double left2 = 277.2;
		double top2 = 137.2;
		double angle2 = 145;
		double scaleX2 = 0.7;
		double scaleY2 = 0.84;
		
		double a1 = radius*scaleX1;
		double b1 = radius*scaleY1;
		double a2 = radius*scaleX2;
		double b2 = radius*scaleY2;
		double x1 = left1 + radius*scaleX1;
		double y1 = 530 - top1 - radius*scaleY1;
		double x2 = left2 + radius*scaleX2;
		double y2 = 530 - top2 - radius*scaleY2;
		System.out.println(a2 + " = " + b2);
		System.out.println(x2 + " = " + y2);
		int len1 = 0;
		int len2 = 0;
		for(double i = 100; i < 530; i = i+0.05) {
			for(double j = 100; j < 530; j = j + 0.05) {
				double tmp1 = (i - x1)*(i - x1)/(a1*a1) + (j - y1)*(j - y1)/(b1*b1);
				double tmp2 = (i - x2)*(i - x2)/(a2*a2) + (j - y2)*(j - y2)/(b2*b2);
				if(tmp1 <= 1) {
					len1++;
				}
				if(tmp1 <= 1 && tmp2 <= 1) {
					len2++;
				}
			}
		}
		//System.out.println(len1 + "=" + len2);
		//System.out.println((double)len2/len1);
		
		int len3 = 0;
		int len4 = 0;
		double sin1 = Math.sin(Math.toRadians(angle1));
		double cos1 = Math.cos(Math.toRadians(angle1));
		System.out.println(sin1 + " " + cos1);
		double sin2 = Math.sin(Math.toRadians(angle2));
		double cos2 = Math.cos(Math.toRadians(angle2));
		System.out.println(sin2 + "=" + cos2);
		//斜椭圆
		for(double i = 100; i < 570; i = i + 1) {
			for(double j = 100; j < 570; j = j + 1) {
				
				double xx1 = cos1*i + sin1*j;
				double yy1 = (cos1*j - sin1*i)/(cos1*cos1 - sin1*sin1);
				//double tmp1 = (xx1 - x1)*(xx1 - x1)/(a1*a1) + (yy1 - y1)*(yy1 - y1)/(b1*b1);
				
				double xx2 = cos2*i + sin2*j;
				double yy2 = (cos2*j - sin2*i)/(cos2*cos2 - sin2*sin2);
				//double tmp2 = (xx2 - x2)*(xx2 - x2)/(a2*a2) + (yy2 - y2)*(yy2 - y2)/(b2*b2);
//				double tmp2 = (xx2 - x1)*(xx2 - x1)/(a1*a1) + (yy2 - y1)*(yy2 - y1)/(b1*b1);
				
				
				double tmp1 = ((i - x1)*cos1 - (j - y1)*sin1)*((i - x1)*cos1 - (j - y1)*sin1)/(a1*a1) + 
						((i - x1)*sin1 + (j - y1)*cos1 )*((i - x1)*sin1 + (j - y1)*cos1 )/(b1*b1);
				//double tmp1 = (i*cos1 - j*sin1 - x2)*(i*cos1 - j*sin1 - x2)/(a2*a2) + 
				//		(i*sin1 + j*cos1 - y2)*(i*sin1 + j*cos1 - y2)/(b2*b2);
				//i = i-312.2;
				//j = j-350;
//				double p = i - 312.2;
//				double q = j - 350;
				double m = a2*a2;
				double n = b2*b2;
//				double k = (i*cos2 - j*sin2 - x2);
				double tmp2 = ((i - x2)*cos2 - (j - y2)*sin2 )*((i - x2)*cos2 - (j - y2)*sin2 )/m + 
						((i - x2)*sin2 + (j - y2)*cos2 )*((i - x2)*sin2 + (j - y2)*cos2 )/n;
				System.out.println(tmp1);
				//System.out.println(m + " " + n + " " + k);
				if(tmp1 <= 1) {
					len3++;
					System.out.println(sin1 + " " + cos1);
				}
				//tmp1 <= 1 &&
				//System.out.println(tmp1);
				if(tmp1 <= 1 && tmp2 <= 1) {
					len4++;
					System.out.println(len4);
				}
			}
		}
		System.out.println(len3 + "=" + len4);
		System.out.println((double)len4/len3);
		
	}
	
}
