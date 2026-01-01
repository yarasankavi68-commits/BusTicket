import java.io.*;
import java.util.Scanner;

public class BusTicket {

    static String FILE = "ticket.txt";

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Book Ticket");
        System.out.println("2. View Ticket");
        System.out.println("3. Cancel Ticket");
        System.out.print("Enter choice: ");
        int ch = sc.nextInt();
        sc.nextLine();

        if (ch == 1) {
            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Seat No: ");
            String seat = sc.nextLine();

            FileWriter fw = new FileWriter(FILE, true);
            fw.write(name + "," + seat + "\n");
            fw.close();

            System.out.println("Ticket Booked");
        }

        else if (ch == 2) {
            BufferedReader br = new BufferedReader(new FileReader(FILE));
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                System.out.println("Name: " + d[0] + " Seat: " + d[1]);
            }
            br.close();
        }

        else if (ch == 3) {
            System.out.print("Enter name to cancel: ");
            String name = sc.nextLine();

            File input = new File(FILE);
            File temp = new File("temp.txt");

            BufferedReader br = new BufferedReader(new FileReader(input));
            BufferedWriter bw = new BufferedWriter(new FileWriter(temp));

            String line;
            while ((line = br.readLine()) != null) {
                if (!line.startsWith(name + ",")) {
                    bw.write(line + "\n");
                }
            }
            br.close();
            bw.close();

            input.delete();
            temp.renameTo(input);

            System.out.println("Ticket Cancelled");
        }

        sc.close();
    }
}
