package fiba.rechner;

import android.app.Activity;

public class Lamp extends Activity {
	public int id; // ID der Lampe
	public int size; // Größe der Lampe
	public double price; // Preis der Lampe
	public int consumNew; // Verbrauch der neuen Lampe
	public int consumOld; // Verbrauch der alten Lampe
	public static boolean AssemblyCost; // Montagekosten

	public Lamp(int id, int size, double price, int consumNew, int consumOld) {
		setId(id);
		setSize(size);
		setPrice(price);
		setConsumNew(consumNew);
		setConsumOld(consumOld);
		
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getConsumNew() {
		return consumNew;
	}

	public void setConsumNew(int consumNew) {
		this.consumNew = consumNew;
	}

	public int getConsumOld() {
		return consumOld;
	}

	public void setConsumOld(int consumOld) {
		this.consumOld = consumOld;
	}

	public static boolean isAssemblyCost() {
		return AssemblyCost;
	}

	public static void setAssemblyCost(boolean assemblyCost) {
		AssemblyCost = assemblyCost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
