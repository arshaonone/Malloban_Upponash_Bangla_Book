package com.mallobanupponash;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private AdRequest adRequest;
    private InterstitialAd interstitialAd;
    private AdView mAdView;

    private Context mContext;

    private ArrayList<String> titleText;

    private RecyclerView mRecyclerView;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MobileAds.initialize(this, "ca-app-pub-2606660907793468/2743589395");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        mContext = MainActivity.this;

        titleText = new ArrayList<String>();

        titleText.add(Constants.অফিস_থেকে_ফিরে_উৎপলার_কাছে);
        titleText.add(Constants.ওপরের_ঘরটায়_পলা_আর_মনু_শোয়);
        titleText.add(Constants.কিছুই_ভালো_লাগছিল_না);
        titleText.add(Constants.চা_জলখাবার_খেয়ে);
        titleText.add(Constants.দোতলার_ঘরটার_লাগাও_বাথরুম_ছিল);
        titleText.add(Constants.পরদিন_সিনেমায়);
        titleText.add(Constants.পাথুরেঘাটার_বাড়িটা);
        titleText.add(Constants.পাশের_বাড়ির_ছোট্ট_মেয়েটি);
        titleText.add(Constants.প্রাণধারণের_ব্যাপারে_খারিজ);
        titleText.add(Constants.ব্যবস্থা_আবার_আগের_মতন);
        titleText.add(Constants.বড়_বৌঠানের_সংবাদ);
        titleText.add(Constants.মাইনে_তো_আড়াই_শো_টাকা_হল);
        titleText.add(Constants.মাল্যবান_গোলদীঘিতে_গেল);
        titleText.add(Constants.মাল্যবানকে_মেসে_থাকতেই_হল);
        titleText.add(Constants.মেজদার_পরিবার_এল);
        titleText.add(Constants.মেজদারা_তো_থাকবেন_অনেক_দিন);
        titleText.add(Constants.মেসের_বিছানায়_শুয়ে);
        titleText.add(Constants.মড়া_পুড়িয়ে_বেলা_দুটোর_সময়ে);
        titleText.add(Constants.রাত_দুটোর_সময়);
        titleText.add(Constants.শীতের_রাত);
        titleText.add(Constants.সরস্বতী_পূজোর_দিন);
        titleText.add(Constants.সারাদিন_মাল্যবানের_মনেও_ছিল_না);
        titleText.add(Constants.সেলাইয়ের_কল);
        titleText.add(Constants.স্ত্রী_সন্তানের_পাট_চুকিয়ে_দিয়ে);






        mRecyclerView = (RecyclerView) findViewById(R.id.title_layout_recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mRecyclerView.setHasFixedSize(true);


        TitleAdapter adapter = new TitleAdapter(mContext, titleText, new MyCustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

                Toast.makeText(mContext, "clicked - "+String.valueOf(titleText.get(position)), Toast.LENGTH_SHORT).show();

                Intent desIntent = new Intent(mContext,DescriptionActivity.class);

                desIntent.putExtra("titles",String.valueOf(titleText.get(position)));

                startActivity(desIntent);

            }
        });

        mRecyclerView.setAdapter(adapter);

    }
}