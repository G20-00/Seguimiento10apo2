package ui;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;


public class Main{

	static int [] torres = new int [3];
	static Scanner entrada = new Scanner(System.in);
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException{
		
		//BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		repit(n);
		
	}
	static void repit(int j) throws NumberFormatException, IOException {
		if(j>0) {
			System.out.println("\n" );
			int n = Integer.parseInt(br.readLine());
			torres = new int [3];
			torres[0]=n;
			torresHanoi(n,1,3,2,1);
			j--;
			System.out.println(j);
			repit(j);
		}
	}
	static void torresHanoi(int n,int o,int d,int aux,int cont){
		
		if(n>0){
			if(cont<=1) {
				System.out.println(torres[0]+ " " + torres[1] + " "+torres[2]);
			}
			torresHanoi(n-1,o,aux,d,++cont);
			
			torres[o-1]--;
			torres[d-1]++;
			System.out.println(torres[0]+ " " + torres[1] + " "+torres[2]);
			cont++;
			torresHanoi(n-1,aux,d,o,cont);
		
		}
	}
	

}

