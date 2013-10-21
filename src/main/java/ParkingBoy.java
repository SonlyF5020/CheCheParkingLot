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
        for (ParkingLot parkingLot:parkingLotList){
            if (parkingLot.contain(myCar)){
                return true;
            }
        }
        return false;
    }

    public MyCar getCar(String token) {
        MyCar myCar = null;
        for (ParkingLot parkingLot:parkingLotList){
            if(parkingLot.pullOutCar(token) !=null){
                myCar = parkingLot.pullOutCar(token);
            }
        }
        return myCar;
    }
}
