package vn.poly.toanthptqg.activity;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    public void openActivy(Class target){
        Intent intent=new Intent(this, target);
        startActivity(intent);
    }

    public void openActivitySendData(Class target,String tag,String stringdata){
        Intent intent=new Intent(this, target);
        intent.putExtra(tag,stringdata);
        startActivity(intent);

    }





}
