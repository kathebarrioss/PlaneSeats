import java.util.Scanner;

public class PlaneSeats {

    public static char[][] createPlaneSeats(int rows, int cols) {
        char[][] seats = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                seats[row][col] = (char)('A' + col);
            }
        }
        return seats;
    }

    public static void planeSeats(char[][] seats){
        for(int row = 0; row < seats.length; row++){
            System.out.print((row + 1));
            for(int col = 0; col < seats[row].length; col++){
                System.out.printf("%4s", seats[row][col]);
            }
            System.out.println();
        }
    }

    public static boolean seatsOccupied (char[][] seats, String seat) {
        int row = Character.getNumericValue(seat.charAt(0)) - 1;
        int col = seat.charAt(1) - 'A';

        if (seats[row][col] == 'X') {
            return false;
        } else {
            seats[row][col] = 'X';
            return true;
        }
    }

    public static boolean fullPlane(char[][] seats) {
        for (int row = 0; row < seats.length; row++) {
            for (int col = 0; col < seats[row].length; col++) {
                if (seats[row][col] != 'X') {
                    return false;
                }
            }
        }
        return true;
    }

    public static char[][] chooseSeat(char[][] seats, Scanner scanner) {
        while (true) {
            if (fullPlane(seats)) {
                System.out.println("All seats are occupied");
                break;
            }

            System.out.print("Please enter the seat number (ex - 3B) or Q to quit:\t");
            String input = scanner.nextLine().toUpperCase();

            if (input.equals("Q")) {
                System.out.println("Your seat has been selected. You exited the selection.");
                break;
            }

            if (input.matches("[1-7][A-D]")) {
                if (seatsOccupied(seats, input)) {
                    planeSeats(seats);
                } else {
                    System.out.println("The seat selected is already occupied");
                }
            } else {
                System.out.println("Invalid input. Please select a valid seat (ex - 3B) or type Q to quit.");
            }
        }
        return seats;
    }





    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = 7;
        int cols = 4;

        char[][] plane1 = createPlaneSeats(rows, cols);
        planeSeats(plane1);
        chooseSeat(plane1, scanner);

    }








}
