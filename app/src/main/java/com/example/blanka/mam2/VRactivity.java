package com.example.blanka.mam2;
import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import com.google.vr.sdk.widgets.pano.VrPanoramaView;
import java.io.IOException;
import java.io.InputStream;


public class VRactivity extends Activity {

    private VrPanoramaView mVrPanoramaView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vractivity);
        mVrPanoramaView = (VrPanoramaView) findViewById(R.id.pano_view);
        loadPhotoSphere();
    }

    private void loadPhotoSphere() {
        VrPanoramaView.Options options = new VrPanoramaView.Options();
        InputStream inputStream = null;
        AssetManager assetManager = getAssets();

        try {
            inputStream = assetManager.open("fiord.jpg");
            options.inputType = VrPanoramaView.Options.TYPE_STEREO_OVER_UNDER;
            mVrPanoramaView.loadImageFromBitmap(BitmapFactory.decodeStream(inputStream), options);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPause() {
        mVrPanoramaView.pauseRendering();
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mVrPanoramaView.resumeRendering();
    }

    @Override
    protected void onDestroy() {
        mVrPanoramaView.shutdown();
        super.onDestroy();
    }
}
