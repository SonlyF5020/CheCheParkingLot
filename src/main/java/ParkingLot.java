import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int lotNumber;
    private int currentCarNumber;
    private Map<Integer,MyCar> carMap;
    private Map<String,MyCar> carMap1;

    public ParkingLot(int lotNumber) {
        this.lotNumber = lotNumber;
        setCarMap(new HashMap());
    }




    public void setLotNumber(int lotNumber) {
        this.lotNumber = lotNumber;
    }

    public void acceptOneCar(MyCar myCar) {
        if (getCarMap().entrySet().size() != lotNumber) {
        getCarMap().put(myCar.getToken(), myCar);}
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
}
