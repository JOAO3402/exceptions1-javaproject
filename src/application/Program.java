package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Digite o numero do quarto: ");
        int roomNumber = Integer.parseInt(sc.nextLine());
        System.out.print("Data de check-in (dd/MM/yyyy): ");
        Date checkin = sdf.parse(sc.nextLine());
        System.out.print("Data de check-out (dd/MM/yyyy): ");
        Date checkout = sdf.parse(sc.nextLine());

        while(!checkout.after(checkin)) {
            System.out.println("Erro na reserva: A data de check-out deve ser depois da data de check-in");
            System.out.print("Data de check-in (dd/MM/yyyy): ");
            checkin = sdf.parse(sc.nextLine());
            System.out.print("Data de check-out (dd/MM/yyyy): ");
            checkout = sdf.parse(sc.nextLine());
        }

        Reservation reservation = new Reservation(roomNumber, checkin, checkout);
        System.out.println(reservation);

        System.out.println("Digite os dados para atualizar a reserva:");
        System.out.print("Data de check-in (dd/MM/yyyy): ");
        checkin = sdf.parse(sc.nextLine());
        System.out.print("Data de check-out (dd/MM/yyyy): ");
        checkout = sdf.parse(sc.nextLine());

        String error = reservation.updateDates(checkin, checkout);
        if (error != null){
            System.out.println(error);
        } else {
            System.out.println(reservation);
        }
    }
}
