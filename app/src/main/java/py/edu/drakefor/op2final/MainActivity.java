package py.edu.drakefor.op2final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {
    ImageView avatarImageView;
    TextView tituloTextView;
    TextView anhoTexView;
    TextView tipoTextView;
    TextView posterTextView;
    ListView batmanListView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        batmanListView = (ListView)findViewById(R.id.listViewBatman);
        avatarImageView = (ImageView) findViewById(R.id.imageViewBatman);

        RestAdapter restAdapter = new RestAdapter
                .Builder()
                .setEndpoint ("http://www.omdbapi.com")
                .build();
        BatmanInteface servicio  = restAdapter.create(BatmanInteface.class);
        servicio.getBatman(new Callback<Result>(){

            @Override
            public void success(Result result, Response response) {

                Log.i("RESULT", result.toString());
                BatmanAdapter adapter = new BatmanAdapter(result.Search, getApplicationContext());
                batmanListView.setAdapter(adapter);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("RESULT", error.getMessage());
                Toast.makeText(getApplicationContext(), error.getLocalizedMessage(), Toast.LENGTH_LONG).show();

            }
        });

        }
    }





