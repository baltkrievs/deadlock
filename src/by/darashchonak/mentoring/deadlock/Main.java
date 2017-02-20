package by.darashchonak.mentoring.deadlock;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		Deadlocker d1 = new Deadlocker("d1");
		Deadlocker d2 = new Deadlocker("d2");

		Deadlocker d3 = new Deadlocker("d3");
		Deadlocker d4 = new Deadlocker("d4");

		Runnable task1 = () -> {
			d1.syncValueWith(d2);
		};
		Runnable task2 = () -> {
			d2.syncValueWith(d1);
		};

		Runnable task3 = () -> {
			d1.setValue(d3);
		};
		Runnable task4 = () -> {
			d2.setValue(d4);
		};

		Thread thread1 = new Thread(task1);
		Thread thread2 = new Thread(task2);
		Thread thread3 = new Thread(task3);
		Thread thread4 = new Thread(task4);

		thread1.start();
		thread2.start();

		Thread.sleep(1000);

		thread3.start();
		thread4.start();

	}

}
