package ui;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Main{

	static int [] torres = new int [3];
	static Scanner entrada = new Scanner(System.in);
	static BufferedReader br ;
	static PrintWriter pw ;
	public static void main(String[] args) throws NumberFormatException, IOException{
		 br = new BufferedReader(new FileReader("C:\\Users\\Pc\\Desktop\\ejemplo\\hola.txt"));
		 pw = new PrintWriter("C:\\Users\\Pc\\Desktop\\ejemplo\\output.txt");
		int n = Integer.parseInt(br.readLine());
		repit(n);
		
	}
	static void repit(int j) throws NumberFormatException, IOException {
		if(j>0) {
			int n = Integer.parseInt(br.readLine());
			torres = new int [3];
			torres[0]=n;
			torresHanoi(n,1,3,2,1);
			j--;
			repit(j);
		}
	}
	static void torresHanoi(int n,int o,int d,int aux,int cont){
		if(n>0){
			if(cont<=1) {
				System.out.println("\n"+torres[0]+ " " + torres[1] + " "+torres[2]);
				pw.println("\n"+torres[0]+ " " + torres[1] + " "+torres[2]);
			}
			torresHanoi(n-1,o,aux,d,++cont);
			
			torres[o-1]--;
			torres[d-1]++;
			pw.println(torres[0]+ " " + torres[1] + " "+torres[2]);
			System.out.println(torres[0]+ " " + torres[1] + " "+torres[2]);
			
			cont++;
			torresHanoi(n-1,aux,d,o,cont);
		
		}
	}
	

}

