package com.deloitte.demo.nativedemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NativeDemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(NativeDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		long startTime = System.currentTimeMillis(); // (caso 8: Prueba de tiempo de inicio)

		// Caso 1: Creación intensiva de objetos para generar presión en el GC
		for (int i = 0; i < 1000000000; i++) {
			Object obj = new Object(); // Objeto creado y descartado inmediatamente
		}

		// Caso 6: Cálculos matemáticos pesados
		double result = 0;
		for (int i = 0; i < 1000000000; i++) {
			result += Math.sin(i) * Math.cos(i); // Operaciones trigonométricas intensivas
		}
		System.out.println("Resultado cálculo pesado: " + result);

		long endTime = System.currentTimeMillis();
		System.out.println("Tiempo de ejecución: " + (endTime - startTime) + " ms"); // (caso 8: Medir tiempo de inicio)
	}
}
