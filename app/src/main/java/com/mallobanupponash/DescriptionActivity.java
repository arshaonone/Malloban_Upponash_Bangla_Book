package com.mallobanupponash;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class DescriptionActivity extends AppCompatActivity {
    private AdRequest adRequest;
    private InterstitialAd interstitialAd;
    private AdView mAdView;


    private WebView simpleWebView;

    private static final String TAG = "DescriptionActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);


        adRequest = new AdRequest.Builder().build();
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-2606660907793468/6672770703");
        interstitialAd.loadAd(adRequest);
        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                dispAd();

            }
        });

        MobileAds.initialize(this, "ca-app-pub-2606660907793468/9117426051");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);




        simpleWebView =(WebView) findViewById(R.id.desWebView);
        simpleWebView.setWebViewClient(new WebViewClient());


        Bundle extras = getIntent().getExtras();

        if (!extras.equals(null)){

            String data = extras.getString("titles");

            Log.e(TAG, "onCreate: the data is "+data);





            String url = "file:///android_asset/"+data+".html";

            simpleWebView.loadUrl(url);

        }

        WebSettings webSettings = simpleWebView.getSettings();

        webSettings.setBuiltInZoomControls(true);

        webSettings.setDisplayZoomControls(false);

        webSettings.setJavaScriptEnabled(true);
    }

    @Override
    public void onBackPressed() {
        if (simpleWebView.canGoBack()){

            simpleWebView.goBack();
        }

        else {

            super.onBackPressed();
        }
    }
    public void dispAd() {
        if (interstitialAd.isLoaded()) {
            interstitialAd.show();
        }
    }
}
