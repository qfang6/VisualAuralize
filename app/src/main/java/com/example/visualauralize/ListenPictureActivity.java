package com.example.visualauralize;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ListenPictureActivity extends AppCompatActivity {

    Button btnCamera;
    ImageView ivCameraDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listen_picture);

        initWidgets();

        setOnClickListeners();
    }

    private void initWidgets() {
        btnCamera = findViewById(R.id.btn_camera);
        ivCameraDisplay = findViewById(R.id.iv_camera_display);
    }

    private void setOnClickListeners() {
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (null != data && null != data.getExtras()) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            ivCameraDisplay.setImageBitmap(bitmap);
        }
    }
}
