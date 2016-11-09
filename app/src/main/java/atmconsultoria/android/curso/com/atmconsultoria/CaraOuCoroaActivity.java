package atmconsultoria.android.curso.com.atmconsultoria;

import android.media.Image;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class CaraOuCoroaActivity extends AppCompatActivity {

    ImageView moeda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cara_ou_coroa);

        moeda = (ImageView) findViewById(R.id.imageViewMoeda);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            int result = extras.getInt("Result");

            if(result == 0){
                moeda.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.moeda_cara));
            }else{

                moeda.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.moeda_coroa));
            }
        }
    }
}
