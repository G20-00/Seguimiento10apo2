package ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	static int[] torres = new int[3];
	static Scanner entrada = new Scanner(System.in);
	static BufferedReader br;
	static FileOutputStream ou;
	static String output = "";
	private static Scanner numScan = new Scanner(System.in);

	public static void main(String[] args) throws NumberFormatException, IOException {
		boolean run = true;
		int cont=0;
		int n =0;
		while (run) {
			System.out.println("**************************************************\n" + "1.Ejercicio del seguimiento \n"
					+ "2. Ejercicio del archivo\n" + "3. Salir\n"+"**************************************************\n");
			int eleccion = numScan.nextInt();

			switch (eleccion) {
			case 1:
				File r = new File("data/outputExcelSeg.csv");
				br = new BufferedReader(new FileReader("data/inputSeg.txt"));
				ou = new FileOutputStream(r);
				 n = Integer.parseInt(br.readLine());
				 cont = 1;
				repit(n, cont);
				break;
			case 2:
				File f = new File("data/outputExcel.csv");
				br = new BufferedReader(new FileReader("data/input.txt"));
				ou = new FileOutputStream(f);
				 n = Integer.parseInt(br.readLine());
				 cont = 1;
				repit(n, cont);
				break;
			case 3:
					run = false;
					System.out.println("Bye Bye");
				break;
			}
		}

	}

	static void repit(int j, int cont) throws NumberFormatException, IOException {
		if (j > 0) {
			int n = Integer.parseInt(br.readLine());
			torres = new int[3];
			torres[0] = n;
			torresHanoi(n, 1, 3, 2, 1, cont);
			j--;
			cont++;
			repit(j, cont);
		} else {
			ou.close();
		}
	}

	static void torresHanoi(int n, int o, int d, int aux, int cont, int cont2) throws IOException {
		String auxiliar = "";
		if (n > 0) {
			if (cont <= 1) {
				if (cont2 == 1) {
					System.out.println(torres[0] + " " + torres[1] + " " + torres[2]);
					output += (torres[0] + " " + torres[1] + " " + torres[2] + "\n");
					auxiliar = torres[0] + " " + torres[1] + " " + torres[2] + "\n";
					ou.write(auxiliar.getBytes());
					cont2++;
				} else {
					System.out.println("\n" + torres[0] + " " + torres[1] + " " + torres[2]);
					output += "\n" + torres[0] + " " + torres[1] + " " + torres[2] + "\n";
					auxiliar = "\n" + torres[0] + " " + torres[1] + " " + torres[2] + "\n";
					ou.write(auxiliar.getBytes());
				}
			}
			torresHanoi(n - 1, o, aux, d, ++cont, cont2);

			torres[o - 1]--;
			torres[d - 1]++;
			System.out.println(torres[0] + " " + torres[1] + " " + torres[2]);
			output += torres[0] + " " + torres[1] + " " + torres[2] + "\n";
			auxiliar = torres[0] + " " + torres[1] + " " + torres[2] + "\n";
			ou.write(auxiliar.getBytes());
			cont++;
			torresHanoi(n - 1, aux, d, o, cont, cont2);

		}
	}

}
