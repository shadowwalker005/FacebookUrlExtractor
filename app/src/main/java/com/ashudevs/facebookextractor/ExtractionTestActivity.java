package com.ashudevs.facebookextractor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.ashudevs.facebookurlextractor.FacebookExtractor;
import com.ashudevs.facebookurlextractor.FacebookFile;

import java.util.ArrayList;

public class ExtractionTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extraction_test);

        new FacebookExtractor(this,"https://www.facebook.com/MUafridi2/videos/124215325906086",false)
        {
            @Override
            protected void onExtractionComplete(FacebookFile facebookFile) {
                Log.e("TAG","---------------------------------------");
                Log.e("TAG","facebookFile AutherName :: "+facebookFile.getAuthor());
                Log.e("TAG","facebookFile FileName :: "+facebookFile.getFilename());
                Log.e("TAG","facebookFile Ext :: "+facebookFile.getExt());
                Log.e("TAG","facebookFile SD :: "+facebookFile.getSdUrl());
                Log.e("TAG","facebookFile HD :: "+facebookFile.getHdUrl());
                Log.e("TAG","---------------------------------------");
            }

            @Override
            protected void onExtractionFail(Exception error) {
                Log.e("Error","Error :: "+error.getMessage());
                error.printStackTrace();
            }
        };
    }
}
