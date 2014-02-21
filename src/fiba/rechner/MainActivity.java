package fiba.rechner;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Resources ressources = getResources();
		TabHost tabHost = getTabHost();

		// Bestandsaufnahme
		Intent intentAndroid = new Intent().setClass(this, Tab1Activity.class);
		TabSpec tabSpecTab1 = tabHost
				.newTabSpec("Bestandsaufnahme")
				.setIndicator("",
						ressources.getDrawable(R.drawable.icon_tab1_config))
				.setContent(intentAndroid);

		// Einsparrechner
		Intent intentApple = new Intent().setClass(this, Tab2Activity.class);
		TabSpec tabSpecTab2 = tabHost
				.newTabSpec("Einsparrechner")
				.setIndicator("",
						ressources.getDrawable(R.drawable.icon_tab2_config))
				.setContent(intentApple);

		// Auswertung
		Intent intentWindows = new Intent().setClass(this, Tab3Activity.class);
		TabSpec tabSpecTab3 = tabHost
				.newTabSpec("Auswertung")
				.setIndicator("",
						ressources.getDrawable(R.drawable.icon_tab3_config))
				.setContent(intentWindows);

		// add all tabs
		tabHost.addTab(tabSpecTab1);
		tabHost.addTab(tabSpecTab2);
		tabHost.addTab(tabSpecTab3);

		// set Windows tab as default (zero based)
		tabHost.setCurrentTab(1);
	}

//	private int countLamp; // Anzahl der Lampen
//	private int costLamp; // Kosten einer Lampe
//	@SuppressWarnings("unused")
//	private int sizeLamp; // Größe der Lampen
//	private double consumLampNew; // Verbrauch der Lampen neu
//	private double consumLampOld; // Verbrauch der Lampen alt
//	private double costAssembly; // Montagekosten
//	private double costAssemblypLamp; // Montagekosten pro Lampe
//	private double costMaterial; // Materialkosten
//	private double costTotalAmount; // Gesamtkosten
//	private double costBalanceInWeeks; // Zeitraum ( in Wochen ), in dem die Ersparnisse die Gesamtkosten ausgleichen
//	private double costBalanceInMonths; // Zeitraum ( in Monaten ), in dem die Ersparnisse die Gesamtkosten ausgleichen
//	private double costBalanceInYears; // Zeitraum ( in Monaten ), in dem die Ersparnisse die Gesamtkosten ausgleichen
//	private double costpKwh; // Stromkosten in kWh
//	private double costOld; // Stromkosten alt
//	private double costNew; // Stromkosten neu
//	private double costDifference; // Ersparnis
//	private int hourspDay = 12; // Stunden pro Tag
//	private int dayspWeek = 6; // Tage pro Woche
//	private int weekspYear = 52; // Wochen pro Jahr
//	private int hourspYear; // Stunden pro Jahr
//	private double co2ConsumpkWh;	// CO2 Verbrauch pro kWh
//	private double co2ConsumOld;	// Alter CO2 Verbrauch
//	private double co2ConsumNew;	// Neuer CO2 Verbrauch
//	private double co2ConsumpYear;	// CO2 Einsparung pro Jahr

//	// Stromkosten neu pro Jahr
//	public double calcCostNew() {
//
//		setCostNew(hourspYear * consumLampNew * costpKwh * countLamp);
//		return getCostNew();
//	}
//
//	// Stromkosten alt pro Jahr
//	public double calcCostOld() {
//
//		setCostOld(hourspYear * consumLampOld * costpKwh * countLamp);
//		return getCostOld();
//
//	}

	// Ersparnis Stromkosten pro Jahr
//	public double getDifference() {
//
//		costDifference = costOld - costNew;
//		return costDifference;
//
//	}

//	// Montagekosten
//	public double getAssembly() {
//
//		costAssembly = countLamp * costAssemblypLamp;
//		return costAssembly;
//	}
//
//	// Kosten der Lampen Gesamt
//	public double getCostLamp() {
//		costMaterial = countLamp * costLamp;
//		return costMaterial;
//
//	}
//
//	// Gesamtkosten (Montage+Lampen)
//	public double getTotalAmount() {
//		costTotalAmount = costAssembly + costMaterial;
//		return costTotalAmount;
//	}
//
//	// Zeitraum ( in Monaten ), indem die Ersparnisse die Gesamtkosten
//	// ausgleichen
//	public double getBalanceInMonths() {
//		costBalanceInMonths = costTotalAmount / (getCostDifference() / 12);
//		return costBalanceInMonths;
//	}
//
//	// Zeitraum ( in Wochen ), indem die Ersparnisse die Gesamtkosten
//	// ausgleichen
//	public double getBalanceInWeeks() {
//		costBalanceInWeeks = costTotalAmount / (getCostDifference() / 52);
//		return costBalanceInWeeks;
//	}
//
//	// Zeitraum ( in Wochen ), indem die Ersparnisse die Gesamtkosten
//	// ausgleichen
//	public double getBalanceInYears() {
//		costBalanceInWeeks = costTotalAmount / getCostDifference();
//		return costBalanceInYears;
//	}
//
//	// Stunden pro Jahr
//	public int getHourspYear() {
//		hourspYear = hourspDay * dayspWeek * weekspYear;
//		return hourspYear;
//	}
//
//	// Setzen der Stunden pro Tag
//	public int setHourspDay(Integer temp) {
//		hourspDay = temp;
//		return hourspDay;
//	}
//
//	// Setzen der Tage pro Woche
//	public int setDayspWeek(Integer temp) {
//		dayspWeek = temp;
//		return dayspWeek;
//	}
//
//	// Setzen der Woche pro Jahr
//	public int setWeekspYear(Integer temp) {
//		weekspYear = temp;
//		return weekspYear;
//	}
//
//	// Setzen der Montagekosten pro Lampe
//	public double costAssemblypLamp(Double temp) {
//		costAssemblypLamp = temp;
//		return costAssemblypLamp;
//	}
//
//	public double getCostDifference() {
//		return costDifference;
//	}
//
//	public void setCostDifference(double costDifference) {
//		this.costDifference = costDifference;
//	}
//
//	public double getCostOld() {
//		return costOld;
//	}
//
//	public void setCostOld(double costOld) {
//		this.costOld = costOld;
//	}
//
//	public double getCostNew() {
//		return costNew;
//	}
//
//	public void setCostNew(double costNew) {
//		this.costNew = costNew;
//	}
	
//	private void getCO2ConsumOld(){
//		co2ConsumOld = co2ConsumpkWh * costOld;
//	}
//	
//	private void getCO2ConsumNew(){
//		co2ConsumNew = co2ConsumpkWh * costNew;
//	}
//	
//	public void getCO2ConsumpYear();
//	co2ConsumYear = 
	
}
