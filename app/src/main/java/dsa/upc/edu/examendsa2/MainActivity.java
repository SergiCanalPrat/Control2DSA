package dsa.upc.edu.examendsa2;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity {

    private DibaAPI dibaAPI;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclercities);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));



    }

    private void cities() {
        dibaAPI = RetrofitFactory.getDibaApi(DibaAPI.BASE_URL).create(DibaAPI.class);
        //showProgress(true);
        Call<Cities> callCitiesList = dibaAPI.cities("1", "11");
        callCitiesList.enqueue(new Callback<Cities>() {
            @Override
            public void onResponse(Call<Cities> call, Response<Cities> response) {
                if (response.isSuccessful()) {
                    Cities cities = response.body();
                    recyclerView.setAdapter(new CitiesRecyclerViewAdapter(cities.getElements()));
                    //showProgress(false);

                } else {
                    Log.d("CitiesCallBack", "Cannot get Cities");
                }
            }

            @Override
            public void onFailure(Call<Cities> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }
}


