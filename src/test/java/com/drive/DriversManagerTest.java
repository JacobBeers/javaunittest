package com.drive;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;


public class DriversManagerTest
{

    private final DriversManager driversManager = new DriversManager();

    @Before
    public void setup(){
        driversManager.addPassenger( new Passenger( "Carlos", "44234", 100 ) );
        driversManager.addPassenger( new Passenger( "Elise", "533434", 100 ) );
        driversManager.addPassenger( new Passenger( "Ian", "5343433", 100 ) );
        driversManager.addPassenger( new Passenger( "Debbie", "44555521", 100 ) );
        driversManager.addPassenger( new Passenger( "Cleon", "559988", 100 ) );
        driversManager.addPassenger( new Passenger( "Santiago", "1203123", 100 ) );

        driversManager.addDriver( new Driver( "Emilio", "1234990", 10f ) );
        driversManager.addDriver( new Driver( "Pedro", "12312440", 12f ) );
        driversManager.addDriver( new Driver( "Constanza", "9824990", 11f ) );
    }

    @Test
    public void driverAdded() {
        Driver bob = new Driver("Bob", "111111", 13f);
        driversManager.addDriver(bob);        
        Driver actual = driversManager.getDriver(bob.getId());
        assertEquals(bob, actual);
    }


    @Test
    public void passengerAdded() {
        Passenger dale = new Passenger("Dale", "124233", 100);
        driversManager.addPassenger(dale);
        Passenger actual = driversManager.getPassenger(dale.getId());
        assertEquals(dale, actual);
    }

    @Test
    public void startTripTest(){
        String passengerId = "44234";
        String driverId = "1234990";

        driversManager.startTrip(passengerId, driverId);

        Passenger pass = driversManager.getPassenger(passengerId);
        Driver drive = driversManager.getDriver(driverId);

        assertEquals(true, pass.isOnTrip());
        assertEquals(false, drive.isAvailable());

    }

    @Test
    public void endTripTest(){
        String passengerId = "44234";
        String driverId = "1234990";

        driversManager.startTrip(passengerId, driverId);        

        Passenger pass = driversManager.getPassenger(passengerId);
        Driver drive = driversManager.getDriver(driverId);

        assertEquals(true, pass.isOnTrip());
        assertEquals(false, drive.isAvailable());

        driversManager.endTrip(passengerId, driverId);

        pass = driversManager.getPassenger(passengerId);
        drive = driversManager.getDriver(driverId);        

        assertEquals(false, pass.isOnTrip());
        assertEquals(true, drive.isAvailable());
        assertEquals(10f, drive.getBalance(), .01) ;
    }

    // @Test
    // public void nextAvailableDriverTest(){
    //     String driverId = "1234990";
    //     String actual = driversManager.findNextAvailableDriver();

    //     assertEquals(driverId, actual);
    // }
}
