
package kalkulator;

public class Calculator {
	public static void main(String args[]){
		Calculator calc = new Calculator();
		calc.add(2);
		System.out.println(calc.getState());
		calc.mult(3);
		System.out.println(calc.getState());
		calc.add(2147483646);
		System.out.println(calc.getState());
	}
	private int state = 0;

	public int getState() {
		return state;
	}

    public void setState(int state) {
        this.state = state;
    }

    public void add(int value){
        if (state > Integer.MAX_VALUE - value) {
            System.out.println("Za duza wartosc"); // jesli wartosc jest za duza to wypisuje komunikat i zostaje przy poprzedniej wartosci
        } else {
            state += value;
        }
    }

    public void mult(int value){
        if (state > Integer.MAX_VALUE / value) {
            System.out.println("Za duza wartosc");
        } else {
            state *= value;
        }
    }

	public void div(int value){
		if (value == 0) {
			System.out.println("Nie mozna dzielic przez 0");
		} else {
			state /= value;
		}
	}

	public void sub(int value){
		if (state < Integer.MIN_VALUE + value) {
			System.out.println("Za mala wartosc");
		} else {
			state -= value;
		}
	}
	
	private int memory = 0;

	public void storeInMemory() {
		memory = state;
	}

	public void recallFromMemory() {
		state = memory;
	}

	public void addFromMemory() {
		add(memory);
	}

	public void subFromMemory() {
		sub(memory);
	}

	public void multFromMemory() {
		mult(memory);
	}

	public void divFromMemory() {
		div(memory);
	}
	
}
