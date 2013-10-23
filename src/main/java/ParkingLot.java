import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int lotNumber;
    private String lotName;
    private Map<String, MyCar> carMap1;
    private String name;

    public ParkingLot(int lotNumber) {
        this.lotNumber = lotNumber;
        setCarMap(new HashMap());
    }

    public ParkingLot(int lotNumber, String lotName) {
        this.lotNumber = lotNumber;
        this.lotName = lotName;
    }

    public void setLotNumber(int lotNumber) {
        this.lotNumber = lotNumber;
    }

    public void acceptOneCar(MyCar myCar) {
        if (getCarMap().entrySet().size() != lotNumber) {
            getCarMap().put(myCar.getToken(), myCar);
        }
    }

    public Boolean contain(MyCar myCar) {
        return getCarMap().containsValue(myCar);
    }

    public MyCar pullOutCar(String parkNum) {
        return getCarMap().get(parkNum);
    }

    public Map<String, MyCar> getCarMap() {
        return carMap1;
    }

    public void setCarMap(Map<String, MyCar> carMap) {
        this.carMap1 = carMap;
    }

    public Integer getBlankPosition() {
        return lotNumber-carMap1.size();
    }

    public String getName() {
        return name;
    }

    public Double getBlankPositionRate() {
        return (double)getBlankPosition()/(double)lotNumber;
    }
}
