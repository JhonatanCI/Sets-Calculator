package ui;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class Main {
	
	
	
	Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		Main m = new Main();
		System.out.println("Bienvenido a la calculadora de conjuntos!");
		System.out.println("Elige una de las siguientes opciones:");
		int operation = m.showMenu();
		Set<String> a = m.askSet(1);
		Set<String> b = m.askSet(2);
		m.calculate(operation, a, b);
	}
	
	public int showMenu() {
		System.out.println("1)Union."+"\n"+"2)Interseccion"+"\n"+"3)Diferencia simetrica");
		int op = 0;
		try {
			op = sc.nextInt();
			while(op>3 || op<1) {
				System.out.print("No es una opcion valida, pruba de nuevo");
				op = sc.nextInt();
			}
		}catch(InputMismatchException ex) {
			System.out.println("No has digitado numero, pruba de nuevo");
			sc.nextLine();
			showMenu();
			
		}
		return op;
	}
	
	public Set<String> askSet(int num) {
		int quantity = 0;
		try {
			System.out.println("Digita la cantidad de objetos que tendra el conjunto "+num);
			quantity = sc.nextInt();
			while(quantity<0) {
				System.out.print("No es una opcion valida, pruba de nuevo");
				quantity = sc.nextInt();
			}
		}catch(InputMismatchException ex) {
				System.out.println("No has digitado numero, pruba de nuevo");
				sc.nextLine();
				askSet(num);
				
		}
		String element;
		Set<String> s = new HashSet<String>(); 
		
		for (int i = 0; i<quantity;i++) {
			System.out.println("Digita el "+(i+1)+" elemento del conjunto");
			element = sc.next();
			s.add(element);
		}
		return s;
		
	}
	
	public void calculate(int op, Set<String> set1, Set<String> set2) {
		
		
		
		switch (op) {
		case 1:
			union(set1,set2);
			break;
		case 2:
			interseccion(set1,set2);
			break;
		case 3:
			diferencia(set1,set2);
			break;
		}
		
	}
	
	public void union(Set<String> set1, Set<String> set2) {
		Set<String> union = new HashSet<String >(set1); 
		union.addAll(set2);
		System.out.print("La union de ambos conjutos es la siguiente ");
		System.out.println(union+"\n");
	}
	
	public void interseccion(Set<String> set1, Set<String> set2) {
		Set<String> interseccion = new HashSet<String >(set1); 
		set1.removeAll(set2);
		interseccion.removeAll(set1);
		if (interseccion.size()!=0) {
			System.out.print("La interseccion de ambos conjutos es la siguiente ");
			System.out.println(interseccion+"\n");
		}else{
			System.out.println("la interseccion es vacio");
		}
		
	}
	
	public void diferencia(Set<String> set1, Set<String> set2) {
		set1.removeAll(set2);
		if (set1.size()!=0) {
			System.out.print("La diferencia c1-c2 es la siguiente ");
			System.out.println(set1+"\n");
		}else{
			System.out.println("la resta es vacia");
		}
	}

}
