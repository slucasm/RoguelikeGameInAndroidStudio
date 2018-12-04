package dsa.eetac.upc.edu.applicationroguelike;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

import dsa.eetac.upc.edu.applicationroguelike.APIGame.LevelService;
import dsa.eetac.upc.edu.applicationroguelike.models.Level;
import dsa.eetac.upc.edu.applicationroguelike.models.LevelResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG  = "LEVEL";

    private Button button;

    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080/APIGame/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        obtenerDatos();


        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGameActivity();
            }
        });
    }

    public void openGameActivity(){
        Intent intent = new Intent(this,GameActivity.class);
        startActivity(intent);
    }


    private void obtenerDatos(){
        LevelService service = retrofit.create(LevelService.class);
        Call<LevelResponse> levelResponseCall = service.getLevels();

        levelResponseCall.enqueue(new Callback<LevelResponse>() {
            @Override
            public void onResponse(Call<LevelResponse> call, Response<LevelResponse> response) {
                if (response.isSuccessful()){

                    LevelResponse levelResponse = response.body();
                    List<Level> levels = levelResponse.getResults();
                    /**
                     * Aquí obtenim els nivells!!!
                     */

                }else{
                    Log.e(TAG, "onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<LevelResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}
