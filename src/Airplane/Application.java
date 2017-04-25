package Airplane;

import java.util.*;

public class Application {	
	

	public static void main(String[] args) {		
		
		System.out.print("        A       B       C       D       E       F" + "\n");		
		System.out.print("        -       -       -       -       -       -" + "\n");		
		Matriz tabla = new Matriz();		
		String [][] matrix = tabla.getMatrix();
		for(int i=0; i<matrix.length; i++){		//Imprime la reserva actual del avión
			
			for(int j=0; j<matrix[i].length; j++){				
								
				System.out.print(matrix[i][j] + "       ");
			}
			System.out.println();
		}
		
		Scanner entrada = new Scanner(System.in);		
		System.out.println("Choose your ticket type from the following");
		System.out.println("1-First Class" + "\n" + "2-Business Class" + "\n" + "3-Economic Class");		
		String ticket = entrada.nextLine();
		
		tabla.mostrarFilas(matrix, ticket);		//Verifica el tipo de pasaje ingresado y muestra las filas correspondientes				
		
		///Ingresar método para validar fila
		
		int fila = tabla.validarFila(ticket);			
			
		String Let = entrada.nextLine();		//Captura letra del asiento
		
		String [][] matrixActual = tabla.actualizarTabla(matrix, Let, fila, ticket); //Se ingresa método actualizarTabla	
		
		tabla.mostrarTablaFinal(matrixActual);
		
	}
}



