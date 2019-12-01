package vn.poly.toanthptqg.ui.testday;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareDialog;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import vn.poly.toanthptqg.R;
import vn.poly.toanthptqg.data.model.Sentence;
import vn.poly.toanthptqg.ui.login.LoginActivity;

public class TestDayPresenter implements TestDayContract.Presenter {
    private TestDayContract.View view;
    private Context context;

    public TestDayPresenter(TestDayContract.View view, Context context) {
        this.view = view;
        this.context = context;
    }


    @Override
    public void logOut() {
        AuthUI.getInstance().signOut(context).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                clearInforLogin();
                Intent intent=new Intent(context, LoginActivity.class);
                context.startActivity(intent);


            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }

    @Override
    public void clearInforLogin() {
        SharedPreferences sharedPreferences= context.getSharedPreferences(context.getResources().getString(R.string.key_save_inforLogin), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

    @Override
    public Bitmap takescreenshot(View v) {
        v.setDrawingCacheEnabled(true);
        v.buildDrawingCache(true);
        Bitmap b=Bitmap.createBitmap(v.getDrawingCache());
        v.setDrawingCacheEnabled(false);
        return b;
    }

    @Override
    public Bitmap takescreenshotOfRootView(View v) {
        return takescreenshot(v.getRootView());
    }

    @Override
    public void share(List<AuthUI.IdpConfig> configList,TextView textView) {
        SharedPreferences sharedPreferences= context.getSharedPreferences("com.facebook.loginManager", Context.MODE_PRIVATE);
        if(sharedPreferences.getBoolean("express_login_allowed",false)){
            getImageShowShareDialog(textView);
        } else {

            view.startActivityForResult();

        }
    }

    @Override
    public void getImageShowShareDialog(TextView textView) {
        Bitmap bitmap=takescreenshotOfRootView(textView);
        SharePhoto photo=new SharePhoto.Builder().setBitmap(bitmap).build();
        SharePhotoContent content=new SharePhotoContent.Builder().addPhoto(photo).build();
        ShareDialog shareDialog=new ShareDialog((Activity) context);
        shareDialog.show(content,ShareDialog.Mode.AUTOMATIC);
    }


}
