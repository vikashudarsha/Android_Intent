package com.vu.android_intent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {

    private Button homeBtn, browserBtn, dialBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
       this.homeBtn = findViewById(R.id.homeBtn);
       this.browserBtn = findViewById(R.id.browserBtn);
       this.dialBtn = findViewById(R.id.dialBtn);

    }

    @Override
    protected void onResume() {
        super.onResume();
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        browserBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
              dialANumber();

            }

        });
    }

    private void dialANumber(){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:0771234567"));
        startActivity(intent);
    }
    private void openWebPage(){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.google.com"));// Uri ==> android.net.Uri
    }

    private void moveToSetting(){
        Intent intent = new Intent(HomeActivity.this, SettingActivity.class);
        intent.putExtra("username", "Vikash");
        startActivity(intent);

    }
}