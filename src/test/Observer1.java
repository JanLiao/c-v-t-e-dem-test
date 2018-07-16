package test;

public class Observer1 implements Observer {
	
	private Subject subject;

	@Override
	public void update(String msg) {
		System.out.println("observer1 得到信息 ----> " + msg);
	}
	
	public Observer1(Subject subject) {
		this.subject = subject;
		subject.registObserver(this);
	}

}
