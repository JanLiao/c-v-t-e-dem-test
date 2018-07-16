package test;

public class Observer2 implements Observer {
	
	private Subject subject;
	
	public Observer2(Subject subject) {
		this.subject = subject;
		subject.registObserver(this);
	}

	@Override
	public void update(String msg) {
		System.out.println("observer2 收到信息  -----> " + msg);
	}

}
