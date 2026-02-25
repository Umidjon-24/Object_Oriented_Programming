public class BoardingPass {
    private String seatNumber;
    private String gate;

    public BoardingPass(String seatNumber, String gate){
        this.seatNumber=seatNumber;
        this.gate=gate;
    }

    public String toString(){
        return "\nSeat Number: " + seatNumber + "\nGate: " + gate;
    }
}

class Flight{
    private String FlightID;
    private String destination;
    private BoardingPass BoardingPass;

    public Flight(String FlightID, String destination, String seatNumber, String gate){
        this.FlightID=FlightID;
        this.destination=destination;
        this.BoardingPass= new BoardingPass(seatNumber, gate);
    }

    public void show(){
        System.out.print("Flight ID: " + FlightID + "\nDestination: " + destination + "\nBoarding Pass: " + BoardingPass);
    }
}
