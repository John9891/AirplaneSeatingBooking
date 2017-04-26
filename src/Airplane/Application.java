package Airplane;

import java.util.*;

public class Application {	
	

	public static void main(String[] args) {		
		
		System.out.print("        A       B       C       D       E       F" + "\n");		
		System.out.print("        -       -       -       -       -       -" + "\n");		
		Matriz tabla = new Matriz();		
		String [][] matrix = tabla.getMatrix();
		for(int i=0; i<matrix.length; i++){
			
			for(int j=0; j<matrix[i].length; j++){				
								
				System.out.print(matrix[i][j] + "       ");
			}
			System.out.println();
		}
		
		Scanner entrada = new Scanner(System.in);		
		System.out.println("Choose your ticket type from the following");
		System.out.println("1-First Class" + "\n" + "2-Business Class" + "\n" + "3-Economic Class");		
		String ticket = entrada.nextLine();
		
		String mensaje = tabla.mostrarFilas(matrix, ticket);
		System.out.println(mensaje);
		
		int fila = tabla.validarFila(ticket);			
			
		String Let = entrada.nextLine();		
		String [][] matrixActual = tabla.actualizarTabla(matrix, Let, fila, ticket);	
		entrada.close();
		tabla.mostrarTablaFinal(matrixActual);
		
	}
}



