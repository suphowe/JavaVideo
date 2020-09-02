package com.video_template.video;


import android.app.Activity;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.video_template.R;

import java.io.IOException;

public class VideoActivity extends Activity {
    private final static String TAG = "StreamingByCameraActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video);

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.CAMERA}, 1);
        }


        initSurfaceView();
    }

    private void initSurfaceView() {
        SurfaceView surfaceView = (SurfaceView) findViewById(R.id.surface_view);
        SurfaceHolder surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            private final Camera camera = Camera.open(0);

            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                this.surfaceChanged(holder, 0, 0, 0);
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
                try {
                    camera.setPreviewDisplay(holder);
                    camera.setDisplayOrientation(90);
                    camera.startPreview();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                camera.stopPreview();
                camera.release();
            }
        });
    }


}