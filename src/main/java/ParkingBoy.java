import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {

    private ParkingLotChooser chooser;

    private List<ParkingLot> parkingLotList;

    public ParkingBoy(ParkingLotChooser chooser) {
        this.chooser = chooser;
        this.parkingLotList = new ArrayList<ParkingLot>();
    }

    public void manage(ParkingLot parkingLot) {
        parkingLotList.add(parkingLot);
    }

    public void park(MyCar myCar) {
        ParkingLot target = chooser.choose(parkingLotList);
        if (target != null) {
            target.acceptOneCar(myCar);
        }
    }

    public boolean contains(MyCar myCar) {
        for (ParkingLot parkingLot : parkingLotList) {
            if (parkingLot.contain(myCar)) {
                return true;
            }
        }
        return false;
    }

    public MyCar getCar(String token) {
        MyCar myCar = null;
        for (ParkingLot parkingLot : parkingLotList) {
            if (parkingLot.pullOutCar(token) != null) {
                myCar = parkingLot.pullOutCar(token);
            }
        }
        return myCar;
    }
}
