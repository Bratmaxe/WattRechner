package fiba.rechner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Tab3Activity extends Activity {

	Button buttonSend;
	EditText textTo;
	EditText textSubject;
	EditText textMessage;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		TextView textview = new TextView(this);
		textview.setText("Auswertung");
		setContentView(R.layout.tab3);

		buttonSend = (Button) findViewById(R.id.buttonSend);
		textTo = (EditText) findViewById(R.id.editTextTo);
		textSubject = (EditText) findViewById(R.id.editTextSubject);
		textMessage = (EditText) findViewById(R.id.editTextMessage);

		buttonSend.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				String to = textTo.getText().toString();
				String subject = textSubject.getText().toString();
				String bemerkung = ("Bemerkungen: \n\n\n" + (textMessage.getText().toString()));

				Intent email = new Intent(Intent.ACTION_SEND);
				email.putExtra(Intent.EXTRA_EMAIL, new String[] { to });
				// email.putExtra(Intent.EXTRA_CC, new String[]{ to});
				// email.putExtra(Intent.EXTRA_BCC, new String[]{to});
				email.putExtra(Intent.EXTRA_SUBJECT, subject);
				
//				String bestellung = ("Anzahl der Lampen: " +(Tab1Activity.edit_countLamp.getText().toString())+
//						"\nKosten pro Lampe: " +(Tab1Activity.edit_countLamp.getText().toString())+
//						"\nBestellnummer: 123"+
//						"\nAnschrift: "+
//						"\nName: Max Mustermann"+
//						"\nStraﬂe: Neue Straﬂe 43"+
//						"\n69696 Daheim");
//				String message = (bestellung+bemerkung);
//				email.putExtra(Intent.EXTRA_TEXT, message);

				// need this to prompts email client only
				email.setType("message/rfc822");

				startActivity(Intent.createChooser(email,
						"Choose an Email client :"));

			}

		});
	}

}
