package controle;

import java.util.concurrent.Semaphore;
import java.util.Random;

public class Ex02 extends Thread {

	int ThreadID;
	Semaphore semaforoEntrega;

	public Ex02(int ID, Semaphore semaforoEntrega) {

		this.semaforoEntrega = semaforoEntrega;
		ThreadID = ID;

	}

	public void run() {
		cozimento();
		try {
			semaforoEntrega.acquire();
			entrega();
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		} finally {
			semaforoEntrega.release();
		}
	}

	private void cozimento() {
		Random rand = new Random();
		int tempo = 0;
		int progress = 0;
		switch (ThreadID % 2) {
		case 0:
			System.out.println("cozinhando lasanha a bolonhesa");
			tempo = rand.nextInt(600 + 1) + 600;
			while (progress < 100) {
				progress = tempo / 100 + progress;
				System.out.println("lasanha " + progress + "% pronta");
				try {
					sleep(100);
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
			}
			break;
		default:
			System.out.println("cozinhando sopa de cebola");
			tempo = rand.nextInt(500 + 1) + 300;
			while (progress < 100) {
				progress = tempo / 100 + progress;
				System.out.println("sopa de cebola " + progress + "% pronta");
				try {
					sleep(100);
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
			}
			break;
		}
	}

	private void entrega() {
		System.out.println("realizando entrega de ");
		switch (ThreadID % 2) {
		case 0:
			System.out.println("lasanha a bolonhesa");
			break;
		default:
			System.out.println("sopa de cebola");
			break;
		}
		try {
			sleep(500);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
