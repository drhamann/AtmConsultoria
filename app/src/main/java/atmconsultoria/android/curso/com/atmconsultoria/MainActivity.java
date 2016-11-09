package atmconsultoria.android.curso.com.atmconsultoria;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private AdView mAdView;
    ImageView imgCompany;
    ImageView imgService;
    ImageView imgClient;
    ImageView imgContact;
    ImageView imgCaraOuCoroa;
    ImageView imgListview;
    AlertDialog.Builder dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        imgCompany = (ImageView) findViewById(R.id.imageViewCompany);
        imgService = (ImageView) findViewById(R.id.imageViewService);
        imgClient = (ImageView) findViewById(R.id.imageViewCustomer);
        imgContact = (ImageView) findViewById(R.id.imageViewContact);
        imgCaraOuCoroa = (ImageView) findViewById(R.id.imageViewCaraOuCoroa);
        imgListview = (ImageView) findViewById(R.id.imageViewListView);

        imgCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),CompanyActivity.class));
            }
        });

        imgService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ServiceActivity.class));
            }
        });

        imgClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ClienteActivity.class));
            }
        });

        imgContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ContactActivity.class));
            }
        });

        imgCaraOuCoroa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random randomico = new Random();
                int result = randomico.nextInt(2);
                Intent intent = new Intent(getApplicationContext(),CaraOuCoroaActivity.class);
                intent.putExtra("Result",result);

                startActivity(intent);
            }
        });

        imgListview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Titulo");
                dialog.setMessage("Mensagem");
                dialog.setCancelable(false);
                dialog.setIcon(android.R.drawable.dialog_frame);

                dialog.setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"no",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"yes",Toast.LENGTH_SHORT).show();
                    }
                });

                dialog.create();
                dialog.show();

                //Intent intent = new Intent(getApplicationContext(),ListViewActivity.class);
                //startActivity(intent);
            }
        });

    }


}
