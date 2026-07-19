 /**
  Practical 2 (Part A) - 1.2 : Toll Booth
  (a) Define a record Vehicle(String number, String type).
  (b) In main, keep a running toll total and three counters (bike, car, truck).
  (c) Loop until the user types “done” for the number: build a Vehicle, use a switch
  expression on its type for the toll (bike→20, car→50, truck→150), add to the total,
  and increment that type’s counter.
  (d) After the loop, print the total toll and the type with the highest count.
  Expected output: two cars + one bike → “Total toll: 120”, “Most frequent: car”.
  */

 //CODE :

    import java.util.Scanner;
    public class Para1TollBooth {
        record Vehicle(String number, String type) { }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int totalToll = 0;
            int bikes = 0, cars = 0, trucks = 0;

            System.out.println("Enter vehicles. Type 'done' for the number to stop.");

            while (true) {
                System.out.print("Vehicle number (or 'done'): ");
                String number = sc.next();
                if (number.equalsIgnoreCase("done")) break;

                System.out.print("Type (bike/car/truck): ");
                String type = sc.next().toLowerCase();

                Vehicle v = new Vehicle(number, type);

                int toll;

                switch(v.type()) {
                    case "bike":
                        bikes++;
                        toll = 20;
                        break;

                    case "car":
                        cars++;
                        toll = 50;
                        break;

                    case "truck":
                        trucks++;
                        toll = 150;
                        break;

                    default:
                        toll = 0;
                }

                totalToll += toll;
                System.out.println("  " + v.number() + " (" + v.type() + ") pays " + toll);
            }

            System.out.println("Total toll collected: " + totalToll);

            String mostFrequent;
            if (bikes >= cars && bikes >= trucks)      mostFrequent = "bike";
            else if (cars >= bikes && cars >= trucks)  mostFrequent = "car";
            else                                       mostFrequent = "truck";
            System.out.println("Most frequent: " + mostFrequent);
            sc.close();
        }
    }

