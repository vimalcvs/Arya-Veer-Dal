package com.bindesh.aryaveerdalchattisgarh;


import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Dastavez extends AppCompatActivity {

  public CardView cardView1, cardView2, cardView3, cardView4, cardView5,cardView6;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_dastavez);

    cardView1 = (CardView) findViewById(R.id.card1);
    cardView2 = (CardView) findViewById(R.id.card2);
    cardView3 = (CardView) findViewById(R.id.card3);
    cardView4 = (CardView) findViewById(R.id.card4);
    cardView5 = (CardView) findViewById(R.id.card5);
    cardView6 = (CardView) findViewById(R.id.card6);


   /* cardView1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent i = new Intent(Dastavez.this, Webview.class);
        i.putExtra("keyHTML", "http://untoldtruth.in/aryaveerdal/Ek_Ladki_Ko_Dekha_Toh_Aisa_Laga__Lyrical__Anil__Sonam__Rajkummar__Juhi__Darshan__Rochak.mp3");
        String message = "Arya veer dal boudhik";
        i.putExtra("key", message);
        startActivity(i);

      }
    });


    cardView2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent i = new Intent(Dastavez.this, Webview.class);
        i.putExtra("keyHTML", "https://drive.google.com/file/d/1ubmyENHBEfhvm9fnPThrWZcTeLYtOLj1/view?usp=sharing");
        String message = "Arya veer dal boudhik";
        i.putExtra("key", message);
        startActivity(i);

      }
    });*/
  }
}
