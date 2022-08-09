package com.example.pankajverma.croptec_ver10;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class GalleryActivity extends AppCompatActivity {

    String results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        final ProgressBar progressBar = findViewById(R.id.progressBar);
        Button processButton = findViewById(R.id.btnProcess);
        ImageView imageView = findViewById(R.id.ImageGallery);
        Intent intent = getIntent();
        results = "Imfection, fungal, wilting, senescence";
        String tokens[] = results.split(",");
        //results = "{ disease: 'CANCER!!!'; type: 'fungal'}";

        if(intent.hasExtra("ImageUri")) {
            Uri imageUri = intent.getParcelableExtra("ImageUri");
            imageView.setImageURI(imageUri);
        }
        else if(intent.hasExtra("ImageBitmap")) {
            Bitmap imageBitmap = intent.getParcelableExtra("ImageBitmap");
            imageView.setImageBitmap(imageBitmap);
        }

        processButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 ResultsActivity();
            }
        });
    }
    public void ResultsActivity() {
        Intent intent = new Intent(this, ResultsActivity.class);
        startActivity(intent);
    }
}


