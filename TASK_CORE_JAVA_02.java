import java.util.*;
public class TASK_CORE_JAVA_02 {
    static class TicketingSystem{
        int ticketid;
        String passengername;
        String departurecity;
        String arrivalcity;
        String traveldate;
        TicketingSystem(int ticketid,String passengername,String departurecity,String arrivalcity,String traveldate){
            this.ticketid = ticketid;
            this.passengername = passengername;
            this.departurecity = departurecity;
            this.arrivalcity = arrivalcity;
            this.traveldate = traveldate;
        }
        public String displaydetails(){
            return "ticketid: " + ticketid + ", passengername: " + passengername + ", departurecity: " + departurecity + ", arrivalcity: " + arrivalcity+ ", traveldate: "+ traveldate;
        }
    }
    public static void main(String args[]){
        Scanner obj = new Scanner(System.in);
        HashMap<Integer, TicketingSystem> passengerdetails = new HashMap<>();
        while(true){
            System.out.println("1.Book Ticket\n2.View ticket by id\n 3.View all tickets\n4.Update Ticket details\n5.Cancel Ticket\n6.Exit");
            System.out.print("Enter your choice: ");
            int choice  = obj.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Enter ticket id: ");
                    int ticketid = obj.nextInt();
                    obj.nextLine();
                    System.out.print("Enter passenger name: ");
                    String passengername = obj.nextLine();
                    System.out.print("Enter departure city: ");
                    String departurecity= obj.nextLine();
                    System.out.print("Enter arrival city: ");
                    String arrivalcity =  obj.nextLine();
                    System.out.print("Enter travel date: ");
                    String traveldate = obj.nextLine();
                    passengerdetails.put(ticketid,new TicketingSystem(ticketid,passengername,departurecity,arrivalcity,traveldate));
                    System.out.println("Passenger details added");
                    break;
                case 2:
                    System.out.print("Enter passenger id: ");
                    ticketid = obj.nextInt();
                    TicketingSystem ticket = passengerdetails.get(ticketid);
                    if (ticket!=null) {
                        System.out.println("\n" + ticket.displaydetails());
                    } else {
                        System.out.println("No passenger found with ticket ID " + ticketid);
                    }


                    break;
                case 3:
                    if(passengerdetails.isEmpty()){
                        System.out.print("No data found");
                    }
                    else {

                        System.out.println("All Tickets:");
                        for (TicketingSystem t : passengerdetails.values()) {
                            System.out.println(t.displaydetails());
                        }
                    }
                    break;
                case 4:
                    System.out.print("Enter the passenger ID to be updated: ");
                    ticketid = obj.nextInt();
                    obj.nextLine();
                    ticket = passengerdetails.get(ticketid);
                    if (ticket != null){
                            System.out.print("Enter Passenger name: ");
                            passengername = obj.nextLine();
                            System.out.print("Enter departure city: ");
                            departurecity = obj.nextLine();
                            System.out.print("Enter arrivalcity: ");
                            arrivalcity = obj.nextLine();
                            System.out.print("Enter travel date: ");
                            traveldate = obj.nextLine();
                            ticket.passengername = passengername;
                            ticket.departurecity = departurecity;
                            ticket.arrivalcity = arrivalcity;
                            System.out.println("Passenger details updated");

                        } else {
                            System.out.println("no data found");
                        }

                    break;
                case 5:
                    System.out.print("Enter Ticket id to cancel ticket: ");
                    ticketid = obj.nextInt();
                    if (passengerdetails.remove(ticketid) != null) {
                        System.out.println("Ticket canceled successfully");
                    } else {
                        System.out.println("No ticket found with ticket ID " + ticketid);
                    }
                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
