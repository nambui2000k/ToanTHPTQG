package vn.poly.toanthptqg.ui.news.news;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;

import vn.poly.toanthptqg.R;
import vn.poly.toanthptqg.ui.login.LoginActivity;

public class NewPresenter implements NewsContract.Presenter {
    private NewsContract.View view;
    private Context context;

    public NewPresenter(NewsContract.View view, Context context) {
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
}
