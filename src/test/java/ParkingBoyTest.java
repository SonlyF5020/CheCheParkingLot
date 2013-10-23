import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class ParkingBoyTest {

    private ParkingBoy parkingBoy;
    private ParkingLot parkingLot2;
    private ParkingLot parkingLot1;

    @Before
    public void setUp() throws Exception {
        parkingBoy = new ParkingBoy(new NormalChooser());
        parkingLot1 = new ParkingLot(1);
        parkingLot2 = new ParkingLot(1);
        parkingBoy.manage(parkingLot1);
        parkingBoy.manage(parkingLot2);
    }

    @Test
    public void boy_can_part_car() throws Exception {
        MyCar myCar = new MyCar();

        parkingBoy.park(myCar);

        assertThat(parkingBoy.contains(myCar),is(true));
    }

    @Test
    public void boy_can_not_part_car_when_boy_is_full() throws Exception {
        MyCar myCarOne = new MyCar("00001");
        MyCar myCarTwo = new MyCar("00002");
        MyCar myCarThree = new MyCar("00003");

        parkingBoy.park(myCarOne);
        parkingBoy.park(myCarTwo);
        parkingBoy.park(myCarThree);

        assertThat(parkingBoy.contains(myCarOne),is(true));
        assertThat(parkingBoy.contains(myCarTwo),is(true));
        assertThat(parkingBoy.contains(myCarThree),is(false));
    }

    @Test
    public void boy_can_get_car() throws Exception {
        MyCar myCar = new MyCar();
        parkingBoy.park(myCar);
        assertThat(parkingBoy.getCar(myCar.getToken()),is(myCar));
    }

    @Test
    public void boy_can_part_car_to_right_parking_lot() throws Exception {
        ParkingBoy smartBoy = new ParkingBoy(new SmartChooser());

        ParkingLot badParkingLot = new ParkingLot(5);
        badParkingLot.acceptOneCar(new MyCar());
        badParkingLot.acceptOneCar(new MyCar());
        badParkingLot.acceptOneCar(new MyCar());

        ParkingLot rightParkingLot = new ParkingLot(3);
        smartBoy.manage(badParkingLot);
        smartBoy.manage(rightParkingLot);

        MyCar myCar = new MyCar("00001");

        smartBoy.park(myCar);

        assertThat(rightParkingLot.contain(myCar), is(true));
        assertThat(badParkingLot.contain(myCar), is(false));
    }

    @Test
    public void clever_boy_can_choose_right_parking_lot() throws Exception {
        ParkingBoy cleverBoy = new ParkingBoy(new CleverChooser());
        ParkingLot bigParkingLot = new ParkingLot(5);
        ParkingLot smallParkingLot = new ParkingLot(3);
        cleverBoy.manage(bigParkingLot);
        cleverBoy.manage(smallParkingLot);
        MyCar myCar = new MyCar("00001");

        cleverBoy.park(myCar);

        assertThat(bigParkingLot.contain(myCar),is(true));
        assertThat(smallParkingLot.contain(myCar),is(false));
    }

    @Test
    public void boy_can_not_get_car_with_wrong_token() throws Exception {
        MyCar myCar = new MyCar();
        parkingBoy.park(myCar);
        assertThat(parkingBoy.getCar(myCar.getToken() + "somethingError"), nullValue());
    }
}
