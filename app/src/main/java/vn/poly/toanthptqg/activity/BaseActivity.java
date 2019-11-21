package vn.poly.toanthptqg.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    public void openActivy(Class target){
        Intent intent=new Intent(this, target);
        startActivity(intent);
    }

    public void openActivitySendData(Class target,String tag,int intData){
        Intent intent=new Intent(this, target);
        intent.putExtra(tag,intData);
        startActivity(intent);

    }
    public void openActivitySendData(Class target,String tag,String stringData){
        Intent intent=new Intent(this, target);
        intent.putExtra(tag,stringData);
        startActivity(intent);

    }

    public void sendDataByBundle(Class target,String tag1,String stringData1,String tag2,String stringData2){
        Intent intent = new Intent(this,target);
        Bundle bundle = new Bundle();
        bundle.putString(tag1, stringData1);
        bundle.putString(tag2, stringData2);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void getDataFromBundle(){
        Bundle bundle = getIntent().getExtras();
        String title = bundle.getString("key_1");
        boolean b = bundle.getBoolean("key_2");
    }





}
