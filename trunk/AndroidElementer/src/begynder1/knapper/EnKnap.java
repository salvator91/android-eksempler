package begynder1.knapper;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 *
 * @author Jacob Nordfalk
 */
public class EnKnap extends Activity implements OnClickListener {
	// Vi erklærer variabler herude så de huskes fra metode til metode
	Button enKnap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Programmatisk layout
		enKnap = new Button(this);
		enKnap.setText("Tryk på mig");
		setContentView(enKnap);
		// Havde vi brugt deklarativt layout i XML havde vi i stedet skrevet
		//setContentView(R.layout.mit_layout);
		//enKnap = (Button) findViewById(R.id.enKnap);

		enKnap.setOnClickListener(this);
	}

	public void onClick(View v) {
		System.out.println("Der blev trykket på knappen");

		// Vis et tal der skifter så vi kan se hver gang der trykkes
		long etTal = System.currentTimeMillis();

		enKnap.setText("Du trykkede på mig. Tak! \n"+etTal);
	}
}