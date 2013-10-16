import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {
    private List<ParkingLot> parkingLotList;

    public ParkingBoy() {
        this.parkingLotList = new ArrayList<ParkingLot>();
    }

    public void manage(ParkingLot parkingLot) {
        parkingLotList.add(parkingLot);

    }

    public void park(MyCar myCar) {
        this.parkingLotList.get(0).acceptOneCar(myCar);
    }

    public boolean contains(MyCar myCar) {
       return parkingLotList.get(0).contain(myCar);
    }

    public MyCar getCar(String token) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }
}
