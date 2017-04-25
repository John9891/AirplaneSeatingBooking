package Airplane;

import java.util.Scanner;

public class Matriz {
	
	private String pasaje;
	private String [][] tabla;
	private Scanner entrada = new Scanner(System.in);
	public Matriz(){		
		
		tabla = new String [12][7];		
		
		tabla[0][0]="1";tabla[0][1]="*";tabla[0][2]="*";tabla[0][3]="F";tabla[0][4]="*";tabla[0][5]="F";tabla[0][6]="F";
		tabla[1][0]="2";tabla[1][1]="*";tabla[1][2]="F";tabla[1][3]="*";tabla[1][4]="F";tabla[1][5]="*";tabla[1][6]="*";
		tabla[2][0]="3";tabla[2][1]="*";tabla[2][2]="*";tabla[2][3]="B";tabla[2][4]="B";tabla[2][5]="*";tabla[2][6]="B";
		tabla[3][0]="4";tabla[3][1]="B";tabla[3][2]="*";tabla[3][3]="B";tabla[3][4]="*";tabla[3][5]="B";tabla[3][6]="B";
		tabla[4][0]="5";tabla[4][1]="*";tabla[4][2]="B";tabla[4][3]="*";tabla[4][4]="B";tabla[4][5]="*";tabla[4][6]="B";
		tabla[5][0]="6";tabla[5][1]="*";tabla[5][2]="E";tabla[5][3]="*";tabla[5][4]="*";tabla[5][5]="*";tabla[5][6]="E";
		tabla[6][0]="7";tabla[6][1]="E";tabla[6][2]="*";tabla[6][3]="*";tabla[6][4]="*";tabla[6][5]="E";tabla[6][6]="E";
		tabla[7][0]="8";tabla[7][1]="E";tabla[7][2]="*";tabla[7][3]="*";tabla[7][4]="*";tabla[7][5]="E";tabla[7][6]="E";
		tabla[8][0]="9";tabla[8][1]="E";tabla[8][2]="*";tabla[8][3]="E";tabla[8][4]="E";tabla[8][5]="*";tabla[8][6]="E";
		tabla[9][0]="10";tabla[9][1]="*";tabla[9][2]="E";tabla[9][3]="*";tabla[9][4]="E";tabla[9][5]="E";tabla[9][6]="E";
		tabla[10][0]="11";tabla[10][1]="*";tabla[10][2]="*";tabla[10][3]="E";tabla[10][4]="*";tabla[10][5]="E";tabla[10][6]="*";
		tabla[11][0]="12";tabla[11][1]="*";tabla[11][2]="*";tabla[11][3]="E";tabla[11][4]="E";tabla[11][5]="*";tabla[11][6]="E";		
	}
	
	public String[][] getMatrix(){		
		return tabla;		
	}
	
	public void mostrarTablaFinal(String[][] matrixActual){
		
		int total_taken=0, seats_F=0, seats_B=0, seats_E=0, avail_tot=0, avail_F=0, avail_B=0, avail_E=0;
		
		System.out.print("        A       B       C       D       E       F" + "\n");				
		System.out.print("        -       -       -       -       -       -" + "\n");				
		
		for(int i=0; i<matrixActual.length; i++){
			
			for(int j=0; j<matrixActual[i].length; j++){				
								
				System.out.print(matrixActual[i][j] + "       ");
				
				switch(matrixActual[i][j]){
				case "F":
					total_taken++;
					seats_F++;
					break;
				case "B":
					total_taken++;
					seats_B++;
					break;
				case "E":
					total_taken++;
					seats_E++;
					break;
				case "*":
					avail_tot++;
					break;
				}
			}
			System.out.println();			
			avail_F = 12 - seats_F;
			avail_B = 18 - seats_B;
			avail_E = 42 - seats_E;
		}
			System.out.println("Total seats Taken: " + total_taken);
			System.out.println("    First class: " + seats_F);
			System.out.println("    Business class: " + seats_B);
			System.out.println("    Economy class: " + seats_E);
			System.out.println("------------------------------");
			System.out.println("Total seats available: " + avail_tot);
			System.out.println("    First class: " + avail_F);
			System.out.println("    Business class: " + avail_B);
			System.out.println("    Economy class: " + avail_E + "\n");
			System.out.println("Total seats in the airplane: " + (avail_tot+total_taken));
			System.out.println("Thank you, see you soon...");
			
	}
	
	public int validarFila(String ticket){
		
		pasaje = ticket;		
		String numFila = entrada.nextLine();
		
		switch(pasaje){
		case "1":			
			while(!numFila.equals("1") && !numFila.equals("2")){
				
				System.out.println("Please, enter a valid row");
				numFila = entrada.nextLine();}
			break;
		case "2":
			while(!numFila.equals("3") && !numFila.equals("4") && !numFila.equals("5")){
				
				System.out.println("Please, enter a valid row");
				numFila = entrada.nextLine();}
			break;
		case "3":
			while(!numFila.equals("6") && !numFila.equals("7") && !numFila.equals("8") && 
					!numFila.equals("9") && !numFila.equals("10") && !numFila.equals("11") && !numFila.equals("12")){
				
				System.out.println("Please, enter a valid row");
				numFila = entrada.nextLine();}
			break;
		default:
			System.out.println("Error");		
		}
		int filaSel = Integer.parseInt(numFila);
		System.out.println("You have entered a valid row" + "\n" + "Please, choose your seat letter");	
		return filaSel;	
	}
	
	
	public String[][] actualizarTabla(String[][] matrix, String Letra, int fil, String ticket){
		
		Scanner entradaLet = new Scanner(System.in);		
		String tipoClase = "";				
		if(ticket.equals("1")){tipoClase="F";}
		else if(ticket.equals("2")){tipoClase="B";}
		else if(ticket.equals("3")){tipoClase="E";}		
		
		while (!Letra.equals("A") && !Letra.equals("B") && !Letra.equals("C") &&
				!Letra.equals("D") && !Letra.equals("E") && !Letra.equals("F")) {
			
			System.out.println("Please, enter a valid seat letter");
			Letra = entradaLet.nextLine();			
		}		
		System.out.println("La letra es " + Letra);
		System.out.println("La matriz tiene" + matrix[fil-1][2]);
		System.out.println("El tipo de clase es " + tipoClase);
		while (Letra.equals("A") && matrix[fil-1][1].equals(tipoClase) || Letra.equals("B") && matrix[fil-1][2].equals(tipoClase) ||
				Letra.equals("C") && matrix[fil-1][3].equals(tipoClase) || Letra.equals("D") && matrix[fil-1][4].equals(tipoClase) ||
				Letra.equals("E") && matrix[fil-1][5].equals(tipoClase) || Letra.equals("F") && matrix[fil-1][6].equals(tipoClase)){
			
			System.out.println("The selected seat is booked, select other letter:");
			Letra = entradaLet.nextLine();
		}
		
		System.out.println("You have entered a valid seat letter");			
			
		switch (Letra){
		
		case "A":	matrix[fil-1][1]=tipoClase;
			break;
		case "B":	matrix[fil-1][2]=tipoClase;
			break;
		case "C":	matrix[fil-1][3]=tipoClase;
			break;
		case "D":	matrix[fil-1][4]=tipoClase;
			break;
		case "E":	matrix[fil-1][5]=tipoClase;
			break;
		case "F":	matrix[fil-1][6]=tipoClase;
			break;
		default:
			System.out.println("Error");					
		}
		return matrix;
	}
	
	public void mostrarFilas(String[][] matrix, String ticket){		
		
		String [][] matrixNueva;
		matrixNueva = matrix;
		Scanner entradaTipo = new Scanner(System.in);
		
		while (!ticket.equals("1") && !ticket.equals("2") && !ticket.equals("3")) {			
			System.out.println("Please, enter a valid ticket type");
			ticket = entradaTipo.nextLine();}
		
		if(ticket.equals("1")){						
			
			for(int x = 0; x<2; x++){				
				System.out.print("Row0" + (x+1) + ": ");
				
				for(int i = 1; i < 7; i++){
					System.out.print(matrix[x][i]);
				}
				System.out.println();}
			System.out.println("These are first class seats." + "\n" + "Please, choose your row number");
		}
		if(ticket.equals("2")){					
			
			for(int x = 2; x<5; x++){				
				System.out.print("Row0" + (x+1) + ": ");
				
				for(int i = 1; i < 7; i++){
					System.out.print(matrix[x][i]);
				}
				System.out.println();}
			System.out.println("These are Business class seats." + "\n" + "Please, choose your row number");
		}
		if(ticket.equals("3")){						
			
			for(int x = 5; x<12; x++){				
				System.out.print("Row0" + (x+1) + ": ");
				
				for(int i = 1; i < 7; i++){
					System.out.print(matrix[x][i]);
				}
				System.out.println();}
			System.out.println("These are Economy class seats." + "\n" + "Please, choose your row number");
		}		
		
	}

}
