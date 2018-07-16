package test;

public class TestMsg {

	public static void main(String[] args) {
		ObjectMsg sub = new ObjectMsg();
		
		Observer o1 = new Observer1(sub);
		Observer o2 = new Observer2(sub);
		
		sub.setMsg("专业实践终于搞完了");
		sub.setMsg("论文中期检查表终于签完字了");
	}

}
