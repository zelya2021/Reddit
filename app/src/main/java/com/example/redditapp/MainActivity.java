package com.example.redditapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.redditapp.adapters.InformationAdapter;
import com.example.redditapp.models.Information;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvInfo;
    ArrayList<Information> cars = new ArrayList<>();
    {
        for (int i = 1; i <= 10; i++) {
            cars.add(new Information(String.format("author #%s", i), String.format("date #%s", i), String.format("picture #%s", i),String.format("comment #%s", i)));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvInfo=findViewById(R.id.lv_info);

        InformationAdapter carsAdapter = new InformationAdapter(this, R.layout.publication_information, cars);
        lvInfo.setAdapter(carsAdapter);
    }
}
