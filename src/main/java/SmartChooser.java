import java.util.List;

class SmartChooser implements ParkingLotChooser {
    public  ParkingLot choose(List<ParkingLot> parkingLotList) {
        if (parkingLotList.size() == 0) {
            return null;
        }
        ParkingLot result = parkingLotList.get(0);
        for (ParkingLot parkingLot : parkingLotList) {
            if (parkingLot.getBlankPositionRate() > result.getBlankPositionRate()) {
                result = parkingLot;
            }
        }
        return result;
    }
}
