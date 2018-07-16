package test;

public interface Subject {

	public void registObserver(Observer observer);
	
	public void removeObserver(Observer observer);
	
	public void notifyObservers();
}
