package S6EP3;

import java.util.Iterator;

public class ArregloTemperaturas {
	private double[] temperatura;
	private int indice;

	public ArregloTemperaturas() {
		temperatura = new double[10];
		indice = 0;
	}

	public int tamaño() {
		return indice;
	}

	public double obtener(int pos) {
		return temperatura[pos];
	}

	private void ampliarArreglo() {
		double[] aux = temperatura;
		temperatura = new double[indice + 10];
		for(int i=0; i<indice;i++) {
			aux[i]=temperatura[i];
		}
	}

	public void adicionar(double x) {
		if (indice == temperatura.length) {
			ampliarArreglo();
		}
		temperatura[indice] = x;
		indice++;
	}

	public void eliminarAlFinal() {
		indice--;
	}

	public void eliminarTodo() {
		indice = 0;
	}

	public double temperaturaMenor() {
		double menor = temperatura[0];
		for (int i = 0; i < tamaño(); i++) {
			if (temperatura[i] < menor) {
				menor = temperatura[i];
			}
		}
		return menor;
	}

	public int buscarPrimeraTemperaturaNormal() {
		for (int i = 0; i < tamaño(); i++) {
			if (temperatura[i] > 36.1 && temperatura[i] < 37.2) {
				return i;
			}
		}
		return -1;
	}

	public void remplazarPrimeraTemperaturaNormal() {
		if (tamaño() != 0) {
			temperatura[buscarPrimeraTemperaturaNormal()] = temperaturaMenor();
		}
	}

	public void incrementarTemperaturas() {

		for (int i = 0; i < tamaño(); i++) {
			temperatura[i] = temperatura[i] + 0.2;

		}
	}
}
