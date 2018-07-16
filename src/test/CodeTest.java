package test;

public class CodeTest {

	public static void main(String[] args) {
		String s = "333";
		String t = "333";
		System.out.println(s.hashCode() + "=" + t.hashCode());
		
		Person p1 = new Person(1,1);
		Person p2 = new Person(1,1);
		Person p3 = p1;
		System.out.println(p1.hashCode() + "=" + p3.hashCode() + "=" + p2.hashCode());
		System.out.println(p1.equals(p2) + "=" + p3.equals(p1));
		
		String st = "2___李秀兰_2018-03-03_LL.JPG";
		System.out.println(st.substring(0, 10) + "=" + st.length());
	}

}
