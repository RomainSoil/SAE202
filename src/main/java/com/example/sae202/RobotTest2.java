package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class RobotTest2 {
	protected Robot rob;
	protected static Mine mine;
	
	@BeforeAll
	static void initAll() {
	mine = new Mine(2,3,1,150,"or",150,1);
	}
	
	@AfterAll
	static void closeF() {
	mine = null;
	}
	
	@Test
	void testRecolter1() throws DepassementStockage_Exception, DepassementCapaciteExtraction, CapaciteDeMine {
		rob= new Robot(2,3,1,5,5,5,5,"or");
		rob.recolter(mine);
		assertEquals(4,rob.getExtraction());
		assertEquals(4,rob.getStockage());

	}
	
	@Test
	void testRecolter2() throws DepassementStockage_Exception, DepassementCapaciteExtraction, CapaciteDeMine {
		rob= new Robot(2,3,1,5,5,3,3,"or");
		rob.recolter(mine);
		assertThrows(Exception.class, () -> {rob.recolter(mine);});

	}
	
	@Test
	void testRecolter3() throws DepassementStockage_Exception, DepassementCapaciteExtraction, CapaciteDeMine {
		rob= new Robot(2,3,1,0,0,2,2,"or");
		mine.setNbMinerais(-2);
		rob.setNatureExtrac("or");
		rob.recolter(mine);
		assertThrows(Exception.class, () -> {rob.recolter(mine);});
	}
	
	@Test
	void testRecolter4() throws DepassementStockage_Exception, DepassementCapaciteExtraction, CapaciteDeMine {
		rob= new Robot(2,3,1,5,5,0,0,"or");
		rob.recolter(mine);
		assertThrows(Exception.class, () -> {rob.recolter(mine);});

	}
	
	@Test
	void testRecolter5() throws DepassementStockage_Exception, DepassementCapaciteExtraction, CapaciteDeMine {
		rob= new Robot(2,3,1,5,5,5,5,"nickel");
		rob.recolter(mine);
		assertThrows(Exception.class, () -> {rob.recolter(mine);});

	}

}
