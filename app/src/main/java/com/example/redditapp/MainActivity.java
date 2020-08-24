package com.example.redditapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.redditapp.adapters.InformationAdapter;
import com.example.redditapp.models.Information;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvInfo;
    private InformationAdapter adapter;
    private List<Information> arrayList;

    private Document doc;
    private Thread secThread;
    private Runnable runnable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        lvInfo.setAdapter(adapter);


    }
    private void init()
    {
        lvInfo=findViewById(R.id.lv_info);
        runnable=new Runnable() {
            @Override
            public void run() {
                getWeb();
            }
        };
        secThread=new Thread((runnable));
        secThread.start();
    }

    private void getWeb()
    {
        try {
            doc= Jsoup.connect("https://www.reddit.com/top").get();
            Elements getAllPublications = doc.getElementsByClass("rpBJOHq2PR60pnwJlUyP0").get(0).children();
            arrayList= new ArrayList<>();
            for (int i =0; i<getAllPublications.size();i++){
                String getDate=getAllPublications.get(i).getElementsByClass("_3jOxDPIQ0KaOWpzvSQo-1s").text();
                String getComment=getAllPublications.get(i).getElementsByClass("_1rZYMD_4xY3gRcSS3p8ODO").text();
                String getData=getAllPublications.get(i).getElementsByClass("_eYtD2XCVieq6emjKBH3m").text();
                String getimg=getAllPublications.get(i).getElementsByClass("_3Oa0THmZ3f5iZXAQ0hBJ0k ").select("img").attr("src");
                Information info=new Information(getData,getDate,getimg,getComment);
                if(getComment!="")
                    arrayList.add(info);
            }
            adapter = new InformationAdapter(this, R.layout.publication_information, arrayList);



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
