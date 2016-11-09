package atmconsultoria.android.curso.com.atmconsultoria;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends Activity {

    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        list = (ListView)findViewById(R.id.listviewid);

        List<String> content = new ArrayList<>();
        for(int i =0; i<20;i++){
            content.add("List " + i);
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this.getApplicationContext(),android.R.layout.simple_list_item_1,android.R.id.text1,content);

        list.setAdapter(arrayAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String valor = list.getItemAtPosition(position).toString();

                Toast.makeText(getApplicationContext(),valor,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
