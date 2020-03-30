/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barjieras;

public class MyThread extends Thread {
	private Barjieras barrier;
	
	public MyThread(Barjieras barrier) {
		this.barrier = barrier;
	}

	public static void main(String[] args) {
		int n = 3;
		Barjieras barrier = new Barjieras(n);
		MyThread thread1 = new MyThread(barrier);
		MyThread thread2 = new MyThread(barrier);
		MyThread thread3 = new MyThread(barrier);
		thread1.start();
		thread2.start();
		thread3.start();
		try {
			thread1.join();
			thread2.join();
			thread3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			for(int i=0; i<10; i++){
			this.barrier.waitbarrier();
                        System.out.println( "ciklo numeris :" + i + " threado numeris: " + this );
                        }
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}