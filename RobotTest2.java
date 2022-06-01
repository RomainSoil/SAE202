package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RobotTest2 {
	protected Robot rob;
	protected Mine mine;

	@Test
	void testRecolter1() throws DepassementStockage_Exception, DepassementCapaciteExtraction, CapaciteDeMine {
		rob.setNumRobot(1);
		rob.setCapStokage(5);
		rob.setCapExtraction(5);
		rob.setNbMinAct(0);
		rob.setStockage(5);
		rob.setExtraction(5);
		mine.setCapaciteInit(150);
		mine.setNatureMinerais("or");
		mine.setNbMinerais(150);
		mine.setNumMine(1);
		rob.setNatureExtrac("or");
		rob.recolter(mine);
		assertEquals(4,rob.getExtraction());
		assertEquals(4,rob.getStockage());

	}
	
	@Test
	void testRecolter2() throws DepassementStockage_Exception, DepassementCapaciteExtraction, CapaciteDeMine {
		rob.setNumRobot(1);
		rob.setCapStokage(5);
		rob.setCapExtraction(5);
		rob.setNbMinAct(0);
		rob.setStockage(3);
		rob.setExtraction(3);
		mine.setCapaciteInit(150);
		mine.setNatureMinerais("or");
		mine.setNbMinerais(150);
		mine.setNumMine(1);
		rob.setNatureExtrac("or");
		rob.recolter(mine);
		assertThrows(Exception.class, () -> {rob.recolter(mine);});

	}
	
	@Test
	void testRecolter3() throws DepassementStockage_Exception, DepassementCapaciteExtraction, CapaciteDeMine {
		rob.setNumRobot(1);
		rob.setCapStokage(0);
		rob.setCapExtraction(0);
		rob.setNbMinAct(0);
		rob.setStockage(2);
		rob.setExtraction(2);
		mine.setCapaciteInit(150);
		mine.setNatureMinerais("or");
		mine.setNbMinerais(-2);
		mine.setNumMine(1);
		rob.setNatureExtrac("or");
		rob.recolter(mine);
		assertThrows(Exception.class, () -> {rob.recolter(mine);});
	}
	
	@Test
	void testRecolter4() throws DepassementStockage_Exception, DepassementCapaciteExtraction, CapaciteDeMine {
		rob.setNumRobot(1);
		rob.setCapStokage(5);
		rob.setCapExtraction(5);
		rob.setNbMinAct(0);
		rob.setStockage(0);
		rob.setExtraction(0);
		mine.setCapaciteInit(150);
		mine.setNatureMinerais("or");
		mine.setNbMinerais(150);
		mine.setNumMine(1);
		rob.setNatureExtrac("or");
		rob.recolter(mine);
		assertThrows(Exception.class, () -> {rob.recolter(mine);});

	}
	
	@Test
	void testRecolter5() throws DepassementStockage_Exception, DepassementCapaciteExtraction, CapaciteDeMine {
		rob.setNumRobot(1);
		rob.setCapStokage(5);
		rob.setCapExtraction(5);
		rob.setNbMinAct(0);
		rob.setStockage(5);
		rob.setExtraction(5);
		mine.setCapaciteInit(150);
		mine.setNatureMinerais("or");
		mine.setNbMinerais(150);
		mine.setNumMine(1);
		rob.setNatureExtrac("nickel");
		rob.recolter(mine);
		assertThrows(Exception.class, () -> {rob.recolter(mine);});

	}

}
