import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class ParkingLotTest {
    ParkingLot parkingLot;

    @Before
    public void setUp() throws Exception {
        parkingLot = new ParkingLot(10);
    }

    @Test
    public void should_park_car() throws Exception {
        MyCar myCar = new MyCar();

        parkingLot.acceptOneCar(myCar);

        assertThat(parkingLot.contain(myCar), is(true));
    }

    @Test
    public void should_get_a_car_by_number() throws Exception {
        MyCar myCar1 = new MyCar();
        parkingLot.acceptOneCar(myCar1);

        MyCar myCar = parkingLot.pullOutCar(myCar1.getToken());

        assertThat(myCar, is(myCar1));
    }

    @Test
    public void should_not_get_car_by_wrong_number() throws Exception {
        MyCar car = new MyCar();
        parkingLot.acceptOneCar(car);

        MyCar myCar = parkingLot.pullOutCar(car.getToken() + "dsadasdad");

        assertThat(myCar, nullValue());
    }

    @Test
    public void should_not_park_a_car_when_lot_is_full() throws Exception {
        parkingLot.setLotNumber(0);
        MyCar myCar = new MyCar();

        parkingLot.acceptOneCar(myCar);

        assertThat(parkingLot.contain(myCar), is(false));
    }

    @Test
    public void should_return_right_blank_position() throws Exception {
        ParkingLot parkingLot1 = new ParkingLot(10);
        MyCar myCar1= new MyCar();
        parkingLot1.acceptOneCar(myCar1);
        assertThat(parkingLot1.getBlankPosition(),is(9));

    }

    @Test
    public void should_return_right_blank_rate() throws Exception {
        ParkingLot parkingLot1 = new ParkingLot(10);
        MyCar myCar1= new MyCar();
        parkingLot1.acceptOneCar(myCar1);
        assertThat(parkingLot1.getBlankPositionRate(),is(0.9));
    }
}
