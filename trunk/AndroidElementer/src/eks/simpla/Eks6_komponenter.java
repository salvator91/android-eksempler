package eks.simpla;

import android.view.View;
import android.view.View.OnClickListener;
import org.simpla.SimplaView;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import org.simpla.SimplaActivity;



/**
 * 
 * @author Jacob Nordfalk
 */
public class Eks6_komponenter extends SimplaActivity implements OnClickListener {

  String teksten="GrafikView";
  Button okKnap;
  EditText postnrEditText;
  GrafikView minGrafik;

  public void onClick(View hvadBlevDerKlikketPå) {
      System.out.println("Der blev klikket på "+hvadBlevDerKlikketPå);
      if (hvadBlevDerKlikketPå == okKnap) {
        teksten=postnrEditText.getText().toString();
        minGrafik.postInvalidate();
      } else {
        simpla.showToast("Denne knap er ikke implementeret endnu");
      }
  }

class MinKnapLytter implements OnClickListener {
    public void onClick(View hvadBlevDerKlikketPå) {
      System.out.println("Der blev klikket på "+hvadBlevDerKlikketPå);
      if (hvadBlevDerKlikketPå == okKnap) {
        teksten=postnrEditText.getText().toString();
        minGrafik.postInvalidate();
      } else {
        simpla.showToast("Denne knap er ikke implementeret endnu");
      }
    }
  }

  public class GrafikView extends SimplaView {

    @Override
    protected void onDraw(Canvas canvas) {
      Paint tekstStregtype=new Paint();
      tekstStregtype.setColor(Color.GREEN);
      tekstStregtype.setTextSize(24);
      canvas.drawText(teksten, 0, 20, tekstStregtype);
    }
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);


    
    // Opret grafik-view
    minGrafik=new GrafikView();

    TableLayout tableLayout=new TableLayout(this);

    tableLayout.addView(minGrafik);
    minGrafik.getLayoutParams().height=200;

    // Lav en række med teksten "Vejret for 2500 Valby" (det sidste blåt)
    TableRow tableRow=new TableRow(this);
    TextView textView=new TextView(this);
    textView.setText("Vejret for ");
    tableRow.addView(textView);

    postnrEditText=new EditText(this);
    postnrEditText.setText("2500");
    postnrEditText.setSingleLine(true);
    postnrEditText.setTextColor(Color.BLUE);
    //postnrEditText.setSelection(0, 4);  // postnrEditText.getText().length() giver 4
    tableRow.addView(postnrEditText);


    tableLayout.addView(tableRow);

    okKnap=new Button(this);
    okKnap.setText("OK");
    tableLayout.addView(okKnap);



    Button annullerKnap=new Button(this);
    annullerKnap.setText("Annuller!");
    tableLayout.addView(annullerKnap);


    WebView webView = new WebView(this);
    webView.loadUrl("http://javabog.dk");
    tableLayout.addView(webView);
    webView.getLayoutParams().height=300;

    //simpla.setContentView(tableLayout);

    ScrollView scrollView = new ScrollView(this);
    scrollView.addView(tableLayout);

    simpla.setContentView(scrollView);


    MinKnapLytter minKnapLytter = new MinKnapLytter();
    //okKnap.setOnClickListener(minKnapLytter);
    annullerKnap.setOnClickListener(minKnapLytter);

    okKnap.setOnClickListener(this);
    //annullerKnap.setOnClickListener(this);

  }

  public void simplaMain() {
    //  tom - initialisering bør lægges i onCreate()
  }

}
