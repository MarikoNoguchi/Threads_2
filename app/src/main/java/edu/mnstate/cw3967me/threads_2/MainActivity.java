package edu.mnstate.cw3967me.threads_2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.graphics.BitmapCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Threading Ex Problem";
    private Bitmap mBitmap;
    private ImageView mImgView;
    int mDelay = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImgView = (ImageView) findViewById(R.id.imgView);
    }
    public void onClick(View v){
        Toast.makeText(this, "Hello There!", Toast.LENGTH_SHORT).show();
    }
    public void handleLoadPic(){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(mDelay);
                }catch (InterruptedException e){
                    Log.e(TAG, e.toString());
                }
                mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dragon);
                mImgView.setImageBitmap(mBitmap);
            }
        });
        t.start();
    }
}
