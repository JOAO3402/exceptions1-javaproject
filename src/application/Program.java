package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


        try {
            System.out.print("Digite o numero do quarto: ");
            int roomNumber = Integer.parseInt(sc.nextLine());
            System.out.print("Data de check-in (dd/MM/yyyy): ");
            Date checkin = sdf.parse(sc.nextLine());
            System.out.print("Data de check-out (dd/MM/yyyy): ");
            Date checkout = sdf.parse(sc.nextLine());

            Reservation reservation = new Reservation(roomNumber, checkin, checkout);
            System.out.println(reservation);

            System.out.println("Digite os dados para atualizar a reserva:");
            System.out.print("Data de check-in (dd/MM/yyyy): ");
            checkin = sdf.parse(sc.nextLine());
            System.out.print("Data de check-out (dd/MM/yyyy): ");
            checkout = sdf.parse(sc.nextLine());

            reservation.updateDates(checkin, checkout);
            System.out.println(reservation);
        }
        catch (ParseException e) {
            System.out.println("Formato de data inválido.");
        }
        catch (DomainException e){
            System.out.println("Erro na reserva: " + e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println("Erro inesperado.");
        }
    }
}
