package by.darashchonak.mentoring.deadlock;

public class Deadlocker {

	private String name;

	public Deadlocker(String name) {

		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public synchronized void setValue(Deadlocker locker) {
		System.out.println("Trying to set value form " + locker.getName() + " to " + this.name);
		locker.setValue(this);
	}

	public synchronized void syncValueWith(Deadlocker locker) {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Synchronize value of " + locker.getName() + " with " + this.name);
		locker.setValue(this);
	}
}
