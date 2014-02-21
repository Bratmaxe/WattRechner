package fiba.rechner;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class Tab1Activity extends Activity {

	public static String string_costMaterial;
	public static String string_costAssembly;
	public static String string_costTotalAmount;
	public static String string_powerCostNew;
	public static String string_powerCostOld;
	public static Switch switch_costAssemblypLamp;

	public static int sizeLamp;
	public static int consumLampNew;
	public static EditText test;
	public Spinner spinner_sizeLamp;
	public Spinner spinner_Test;
	public Button btnSubmit;
	public EditText edit_countLamp;
	public EditText countLamp;
	public EditText costLamp;
	public EditText consumLamp;
	public EditText co2ConsumNew;
	public EditText consumOld;
	public EditText consumNew;
	public EditText hourspDay;
	public EditText dayspWeek;
	public EditText weekspYear;
	public EditText hourspYear;
	public String test_value;
	public int costAssemblypLamp;
	public boolean switch_Assembly = false;
	private List<Lamp> lamps = new ArrayList<Lamp>();

	public void onCreate(Bundle savedInstanceState) {

		// (int id, int size, double price, int consumNew, int consumOld)
		lamps.add(new Lamp(0, 600, 24.99, 9, 18));
		lamps.add(new Lamp(1, 1200, 34.99, 18, 36));
		lamps.add(new Lamp(2, 1500, 44.99, 26, 58));

		super.onCreate(savedInstanceState);

		// for(int i = 0; i<lamps.size();i++)
		// spin.announceForAccessibility((CharSequence) lamps);

		TextView textview = new TextView(this);
		textview.setText("Bestandsaufnahme");
		setContentView(R.layout.tab1);
		initializeViews();
		initializeListener();
	}

	public void initializeListener() {
		addItemsonTestSpinner();
		// addListenerOnSpinnerItemSelection();
		countLamp.addTextChangedListener(countLampchanged);
		costLamp.addTextChangedListener(costLampchanged);

		switch_costAssemblypLamp
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {
					public void onCheckedChanged(CompoundButton buttonView,
							boolean on) {
						if (on) {
							get_costAssembly();
							Tab2Activity.setcostAssembly();
							switch_Assembly = true;
						} else {
							string_costAssembly = "Keine Montagekosten";
							Tab2Activity.setcostAssembly();
							switch_Assembly = false;
						}
					}
				});

	}

	public void addItemsonTestSpinner() {

		spinner_Test = (Spinner) findViewById(R.id.spinner_Test);
		List<Integer> list = new ArrayList<Integer>();

		// for (Iterator<Lamp> iterator = lamps.iterator(); iterator.hasNext();)
		// {
		// Lamp lamp = iterator.next();
		// list.add(lamp.getSize());
		// }

		for (Lamp Lamp : lamps) {
			list.add(Lamp.size);
		}

		ArrayAdapter<Integer> dataAdapter = new ArrayAdapter<Integer>(this,
				android.R.layout.simple_spinner_item, list);
		dataAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner_Test.setAdapter(dataAdapter);
		spinner_Test
				.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> arg0, View view,
							int pos, long id) {

						int sizeLamp = (Integer) spinner_Test
								.getItemAtPosition(pos);
						set_Lampvalues2(sizeLamp);

					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {

					}
				});

	}

	public void initializeViews() {

		countLamp = (EditText) findViewById(R.id.edit_countLamp);
		costLamp = (EditText) findViewById(R.id.edit_costLamp);
		hourspDay = (EditText) findViewById(R.id.edit_hourspDay);
		dayspWeek = (EditText) findViewById(R.id.edit_dayspWeek);
		// weekspYear = (EditText) findViewById(R.id.edit_weekspYear);
		hourspYear = (EditText) findViewById(R.id.edit_hourspYearr);
		consumOld = (EditText) findViewById(R.id.edit_consumLampOld);
		consumNew = (EditText) findViewById(R.id.edit_consumLampNew);
		switch_costAssemblypLamp = (Switch) findViewById(R.id.switch_costAssemblypLamp);

	}

	TextWatcher countLampchanged = new TextWatcher() {

		@Override
		public void afterTextChanged(Editable s) {
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			set_costAssembly(switch_Assembly);
			calculatecostMaterial();
		}

	};

	private void set_costAssembly(boolean switch_Assembly) {
		if (switch_Assembly == false)
			string_costAssembly = "Keine Montagekosten";
		else
			get_costAssembly();
		Tab2Activity.setcostAssembly();
	}

	TextWatcher costLampchanged = new TextWatcher() {

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			if (countLamp.getText().length() > 0
					&& costLamp.getText().length() > 0) {
				calculatecostMaterial();
			}
		}

		@Override
		public void afterTextChanged(Editable s) {
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
		}

	};

	// public void addListenerOnSpinnerItemSelection() {
	// spinner_sizeLamp = (Spinner) findViewById(R.id.spinner_sizeLamp);
	// spinner_sizeLamp
	// .setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
	//
	// @Override
	// public void onItemSelected(AdapterView<?> arg0, View view,
	// int pos, long id) {
	//
	// int sizeLamp = (Integer) Integer
	// .parseInt((String) spinner_sizeLamp
	// .getItemAtPosition(pos));
	// set_Lampvalues(sizeLamp);
	//
	// }
	//
	// @Override
	// public void onNothingSelected(AdapterView<?> arg0) {
	//
	// }
	// });
	//
	// }

	public void calculatecostMaterial() {
		try {
//			double temp = 0;
			string_costMaterial = (String.valueOf(set_decimalFormat((Double.parseDouble(countLamp
					.getText().toString()))
					* (Double.parseDouble((costLamp.getText().toString()
							.replace(" €", "")).replace(",", ".")))))).replace(
					".", ",")
					+ " €";

			Tab2Activity.setcostMaterial();
		} catch (Exception e) {
			string_costAssembly = "Werte fehlen";
		}
	}

	public String get_costAssembly() {

		try {
			string_costAssembly = ((String.valueOf(set_decimalFormat(5 * Double
					.parseDouble(countLamp.getText().toString()))).replace(".",
					",")) + " €");
		} catch (Exception e) {
			string_costAssembly = "Keine Montagekosten";
//			testdingens("fehler bei cost Assembly");
		}
		return string_costAssembly;
	}

	public void testdingens(String blub) {
		Toast.makeText(Tab1Activity.this, blub, Toast.LENGTH_SHORT).show();
	}

	public String filterEuro(String input) {
		String output = input.replaceAll("[0-9.,]", "");
		return output;
	}

	public String filteraddEuro(Double input) {

		String output = (String.valueOf(input).replace(".", ",") + " €");
		return output;
	}

	// public void set_Lampvalues(Integer value) {
	// try {
	//
	// if (value == 60) {
	// costLamp.setText("20,50 €");
	// consumOld.setText("18 Watt");
	// consumNew.setText("9 Watt");
	// } else if (value == 120) {
	// costLamp.setText("35,00 €");
	// consumOld.setText("36 Watt");
	// consumNew.setText("18 Watt");
	// } else if (value == 150) {
	// costLamp.setText("45,00 €");
	// consumOld.setText("58 Watt");
	// consumNew.setText("26 Watt");
	// }
	// } catch (Exception e) {
	// testdingens("fehler bei costLamp!");
	// }
	//
	// }

	public void set_Lampvalues2(Integer value) {
		// testdingens(String.valueOf("Läuft" + " " +value));
		try {

			for (Lamp Lamp : lamps) {
				if (value == Lamp.size) {
					Lamp lamp = lamps.get(Lamp.id);
					costLamp.setText(String.valueOf((((set_decimalFormat(lamp.price)).replace(".", ",")) + " €")));
//					costLamp.setText(String.valueOf(lamp.price));
					consumOld.setText(String.valueOf(lamp.consumOld + " Watt"));
					consumNew.setText(String.valueOf(lamp.consumNew + " Watt"));
				}

			}

		} catch (Exception e) {
//			testdingens("Fehler bei Schleife");
		}

	}

	public static String set_decimalFormat(double temp) {
		DecimalFormat decimalFormat = new DecimalFormat("#########.00");
		String output = decimalFormat.format(temp);
		return output;
	}

}
