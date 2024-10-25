package kalkulator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

	@Test
	public void testAddOne(){
		// Arrange
		// sut = System Under Test
		Calculator sut = new Calculator();
		// Act
		sut.add(1);
		// Assert
		assertEquals("0+1 = 1", 1, sut.getState());
	}

	@Test
	public void testMultOneByTwo(){
		Calculator sut = new Calculator();
		sut.setState(1);
		sut.mult(2);
		assertEquals("1*2 = 2", 2, sut.getState());
	}

	@Test
	public void testAddTwoMultThree(){
		Calculator sut = new Calculator();
		sut.add(2);
		sut.mult(3);
		assertEquals("(0+2)*3 = 6", 6, sut.getState());
	}

	@Test
	public void testDivTwoByTwo(){
		Calculator sut = new Calculator();
		sut.setState(2);
		sut.div(2);
		assertEquals("2/2 = 1", 1, sut.getState());
	}

	@Test
	public void testSubFiveByTwo(){
		Calculator sut = new Calculator();
		sut.setState(5);
		sut.sub(2);
		assertEquals("5-2 = 3", 3, sut.getState());
	}

	@Test
	public void testAddMaxValues(){
		Calculator sut = new Calculator();
		sut.setState(2147483640);
		sut.add(100);
		assertEquals("2147483640+100 = Za duza wartosc", 2147483640, sut.getState()); 
		// 2147483640 + 100 = 2147483740 > max int, wiec zostaje przy poprzedniej wartosci
	}

	@Test
	public void testMultMaxValues(){
		Calculator sut = new Calculator();
		sut.setState(2147483640);
		sut.mult(3);
		assertEquals("2147483640*3 = Za duza wartosc", 2147483640, sut.getState());
		// 2147483640 * 3 = 6442450920 > max int, wiec zostaje przy poprzedniej wartosci
	}

	@Test
	public void testDivByZero(){
		Calculator sut = new Calculator();
		sut.setState(2);
		sut.div(0);
		assertEquals("2/0 = Nie mozna dzielic przez 0", 2, sut.getState());
		// 2/0 = Nie mozna dzielic przez 0, wiec zostaje przy poprzedniej wartosci
	}

	@Test
	public void testSubMinValues(){
		Calculator sut = new Calculator();
		sut.setState(-2147483640);
		sut.sub(100);
		assertEquals("-2147483640-100 = Za mala wartosc", -2147483640, sut.getState());
		// -2147483640 - 100 = -2147483740 < min int, wiec zostaje przy poprzedniej wartosci
	}

	@Test
	public void testStoreInMemory() {
		Calculator sut = new Calculator();
		sut.add(10);
		sut.storeInMemory();
		assertEquals("W pamieci powinno byc 10", 10, sut.getState());
	}

	@Test
	public void testRecallFromMemory() {
		Calculator sut = new Calculator();
		sut.add(10);
		sut.storeInMemory();
		sut.add(5);
		sut.recallFromMemory();
		assertEquals("Pamiec powinna przywrocic wartosc 10", 10, sut.getState());
	}

	@Test
	public void testAddFromMemory() {
		Calculator sut = new Calculator();
		sut.add(10);
		sut.storeInMemory();
		sut.add(5);
		sut.addFromMemory();
		assertEquals("Powinno zwrocic 15 + 10 = 25", 25, sut.getState());
	}

	@Test
	public void testDivFromMemory() {
		Calculator sut = new Calculator();
		sut.add(10);
		sut.storeInMemory();
		sut.add(20);
		sut.divFromMemory();
		assertEquals("Powinno zwrocic 30 / 10 = 3", 3, sut.getState());
	}
}
