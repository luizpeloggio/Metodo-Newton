package metodo_NewtonRapson;

import java.util.Scanner;

public class Metodo_NewtonRapson {
	
public static double pontoMedio(double x, double y) {
	
	double pM = (x + y)/2;
	return pM;
	
}
public static double funcao(double x) {
	double res = Math.exp(x)- 3 * Math.pow(x, 2);
	return res;
}
public static double funcaoDerivada(double x) {
	double res = Math.exp(x)- 6*x ;
	return res;
}

public static double funcaoNewton(double x) {
	double fx = funcao(x);
	double fdx = funcaoDerivada(x);
	
	if(Math.abs(fdx)< 1e-10) {
		return x;
	}
	return x - (fx/fdx);
}

	public static void main(String[] args) {
		double e = 0.0001;
		double a, b, pM, xK, fxk, cp;
		int i =0;
		
		Scanner sc = new Scanner(System.in);
		 
			System.out.println("Informe o valor de a");
			a = sc.nextDouble();
			System.out.println("Informe o valor de b");
			b = sc.nextDouble();
			
			pM = pontoMedio(a,b);
			
			
			System.out.printf("O Ponto Médio é: %.2f \n", pM);
			
			xK = funcaoNewton(pM);
			System.out.printf("Na função de Newton: %.2f \n", xK);

			
			if (Math.abs(xK-pM) < e) {
				
				System.out.printf("Está é a raiz %.3f", xK);
			}
			
			//problema é a partir daqui kkkk 
			
			while(i < 100) {
				
				fxk = funcaoNewton(xK);
				cp = Math.abs(fxk-xK);
				
				System.out.printf("%d º Interação | \t X%d %.3f |\t Função Newton-Rapson %.3f \n",i,i,xK, fxk);
				
				
				
				if(cp < e) {
					
					System.out.printf("Convergiu! na %dº Interação", i);
					
				break;
				}
				
				xK = fxk;
				
				i++;
			}
			
		sc.close();
	}

}
