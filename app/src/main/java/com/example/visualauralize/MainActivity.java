package com.example.visualauralize;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

// Grant Android Studio access on Ubuntu => sudo setfacl -m u:$USER:rwx /dev/kvm
public class MainActivity extends AppCompatActivity {

    private String[] permissions = {
            "android.permission.WRITE_EXTERNAL_STORAGE",
            "android.permission.READ_EXTERNAL_STORAGE",
            "android.permission.CAMERA"};

    private Button btnListenPicture;
    private Button btnSeeSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int requestCode = 200;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode);
        }

        initWidgets();
        setOnClickListeners();
    }

    private void initWidgets() {
        btnListenPicture = findViewById(R.id.btn_listen_picture);
        btnSeeSound = findViewById(R.id.btn_see_sound);
    }

    private void setOnClickListeners() {
        btnListenPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListenPictureActivity.class);
                startActivity(intent);
            }
        });
        btnSeeSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SeeSoundActivity.class);
                startActivity(intent);
            }
        });
    }
}
