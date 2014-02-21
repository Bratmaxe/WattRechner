package fiba.rechner;

import android.os.Bundle;
import android.widget.TextView;

public class Tab2Activity extends Tab1Activity {

	private static TextView value_costMaterial;
	private static TextView value_costAssembly;
	private static TextView value_costTotalAmount;
	private static TextView value_powerCostNew;
	private static TextView value_powerCostOld;


	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		TextView textview = new TextView(this);
		textview.setText("Einsparrechner");
		setContentView(R.layout.tab2);
		initialize();
	}

	public void initialize() {
		value_costMaterial = (TextView) findViewById(R.id.value_costMaterial);
		value_costAssembly = (TextView) findViewById(R.id.value_costAssembly);
		value_costTotalAmount = (TextView) findViewById(R.id.value_costTotalAmount);
		value_powerCostNew = (TextView) findViewById(R.id.value_powerCostNew);
		value_powerCostOld = (TextView) findViewById(R.id.value_powerCostOld);
	}

	public static void setcostMaterial() {
		value_costMaterial.setText((Tab1Activity.string_costMaterial));
		setcostTotalAmount();
	}

	public static void setcostAssembly() {
		value_costAssembly.setText(Tab1Activity.string_costAssembly);
		setcostTotalAmount();
	}

	public static void setcostTotalAmount() {

		try {

			if (value_costAssembly.getText().toString() == "Keine Montagekosten") {
				value_costTotalAmount.setText(value_costMaterial.getText()
						.toString());
			} else {

				value_costTotalAmount
						.setText((String.valueOf(Tab1Activity.set_decimalFormat(((Double
								.parseDouble(((value_costMaterial.getText()
										.toString()).replace(" €", "").replace(
										",", "."))))
								+ (Double.parseDouble(((value_costAssembly
										.getText().toString())
										.replace(" €", "").replace(",", ".")))))))
								.replace(".", ",")) + " €");
			}
		} catch (Exception e) {
			value_costTotalAmount.setText("fehler");
		}
	}

	public static void setpowerCostNew() {
		value_powerCostNew.setText(Tab1Activity.string_powerCostNew);
		value_powerCostOld.setText(Tab1Activity.string_powerCostOld);
	}
}
