package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());   // --> pode haver uma exceção aqui (conversão de data). Será tratada no 1º catch (abaixo).
			
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());	// --> pode haver uma exceção aqui (conversão de data). Será tratada no 1º catch (abaixo).
	
			Reservation reservation = new Reservation(number, checkIn, checkOut); // --> pode haver uma exceção aqui (data checkOut < data checkin). Será tratada no 2º catch (abaixo).
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			reservation.updateDates(checkIn, checkOut); // --> pode haver uma exceção aqui (data checkOut < data checkin OU datas menores que hoje). Será tratada no 2º catch (abaixo).
			System.out.println("Reservation: " + reservation);
		}
		catch(ParseException e) {  // tratando a "ParseException" que pode acontecer na hora de converter a data
			System.out.println("Invalid date format"); // msg pra dizer pro usuário que ele digitou uma data inválida.
		}
		catch(DomainException e) { // tratando a exceção de datas menores que hoje OU checkOut < checkin.
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch(RuntimeException e) { // colocando um catch (com RuntimeException) para qualquer outra exceção inesperada...
			System.out.println("Unexpected error.");
		}
		sc.close();
	}
}
