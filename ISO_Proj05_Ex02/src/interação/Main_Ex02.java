package interação;

import java.util.concurrent.Semaphore;
import controle.Ex02;

public class Main_Ex02 {

	public static void main(String[] args) {

		Semaphore semaforo = new Semaphore(1);
		for (int i = 1; i <= 5; i++) {
			Thread cozinha = new Ex02(i, semaforo);
			cozinha.start();
		}
	}

}
