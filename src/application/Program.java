package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner input = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room Number: ");
		int number = input.nextInt();
		System.out.print("Check-in date (DD/MM/YYYY): ");
		Date checkIn = sdf.parse(input.next());
		System.out.print("Check-out date (DD/MM/YYYY): ");
		Date checkOut = sdf.parse(input.next());

		System.out.println(checkIn);
		System.out.println(checkOut);
			
		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: check-out date muste be after check-in date.");
		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation.toString());
			System.out.println();

			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (DD/MM/YYYY): ");
			checkIn = sdf.parse(input.next());
			System.out.print("Check-out date (DD/MM/YYYY): ");
			checkOut = sdf.parse(input.next());

			System.out.println(checkIn);
			System.out.println(checkOut);
			
			String error = reservation.updateDates(checkIn, checkOut);
			System.out.println(error);
			if (error != null) {
				System.out.println("Error in reservation, " + error);
			} else {
				System.out.println("Reservation: " + reservation.toString());
			}
		}
		input.close();
	}
}
