import java.util.List;

class NormalChooser implements ParkingLotChooser {
    @Override
    public ParkingLot choose(List<ParkingLot> parkingLotList) {
        for (ParkingLot parkingLot : parkingLotList) {
            if (parkingLot.getBlankPosition() > 0) {
                return parkingLot;
            }
        }
        return null;
    }

}
