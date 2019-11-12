package vn.poly.toanthptqg.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import vn.poly.toanthptqg.R;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread thread=new Thread(){
            @Override
            public void run() {
                try {
                    sleep(3000);
                    openActivy(LoginActivity.class);


                    finish();
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }
}
