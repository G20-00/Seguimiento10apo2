package ui;
	import java.util.Scanner;


	public class Main{
		
		static int [] torres = new int [3];
		static Scanner entrada = new Scanner(System.in);
		static void torresHanoi(int n,int o,int d,int aux){
			 

			if(n>0){
				torresHanoi(n-1,o,aux,d);
				System.out.println(torres[0]+ " " + torres[1] + " "+torres[2]);
				torres[o-1]--;
				torres[d-1]++;	
				torresHanoi(n-1,aux,d,o);
				if(n==1) {
					System.out.println(torres[0]+ " " + torres[1] + " "+torres[2]);
				}

			}
			
			
		}
		public static void main(String[] args){
			int n;
			
			
			//while (en.hasMoreElements()) {
				//type type = (type) en.nextElement();
				
			//}
			n=entrada.nextInt();
			torres = new int [3];
			torres[0]=n;
			torresHanoi(n,1,3,2);
		}
	}

