package vn.poly.toanthptqg.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

import vn.poly.toanthptqg.R;

public class LoginActivity extends BaseActivity {
    private LinearLayout lnlLoginGoogle;
    private LinearLayout lnlLoginFacebook;
    private List<AuthUI.IdpConfig> configList;
    private static final int MY_REQUEST_CODE = 567;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initActivity();
        checkInforLastLogin();

    }
    private void initActivity(){
        lnlLoginGoogle = (LinearLayout) findViewById(R.id.lnlLoginGoogle);
        lnlLoginFacebook = (LinearLayout) findViewById(R.id.lnlLoginFacebook);
    }

    public void lnlLoginFacebook(View view) {
        configList = Arrays.asList(
                new AuthUI.IdpConfig.FacebookBuilder().build()
        );
        showSignOptions();

    }

    public void lnlLoginGoogle(View view) {
        configList = Arrays.asList(new AuthUI.IdpConfig.GoogleBuilder().build()
        );
        showSignOptions();
    }

    private void showSignOptions() {
        startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders(configList).setTheme(R.style.NoActionbar).build(), MY_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                saveInforLogin(user.getDisplayName(),user.getEmail(),user.getPhoneNumber(),user.getPhotoUrl()+"",user.getIdToken(true)+"");
                openActivy(HomeActivity.class);
            } else if(resultCode == RESULT_CANCELED){
                Toast.makeText(this,"You canceled",Toast.LENGTH_LONG).show();
            } else if(resultCode == RESULT_FIRST_USER){
                Toast.makeText(this,"first user",Toast.LENGTH_LONG).show();
            }
        }
    }

    private void checkInforLastLogin(){
        SharedPreferences sharedPreferences= this.getSharedPreferences(this.getResources().getString(R.string.key_save_inforLogin), Context.MODE_PRIVATE);
        if(sharedPreferences!= null) {
            if(!sharedPreferences.getString(this.getResources().getString(R.string.token),this.getResources().getString(R.string.no_token)).equals(this.getResources().getString(R.string.no_token))){
                openActivy(HomeActivity.class);
            }
        }
    }

    private void saveInforLogin(String nameDisplay,String email,String phone,String linkAvatar,String token){
        SharedPreferences sharedPreferences= this.getSharedPreferences(this.getResources().getString(R.string.key_save_inforLogin), Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(this.getResources().getString(R.string.name_display), nameDisplay);
        editor.putString(this.getResources().getString(R.string.email), email);
        editor.putString(this.getResources().getString(R.string.phone), phone);
        editor.putString(this.getResources().getString(R.string.url_avatar), linkAvatar);
        editor.putString(this.getResources().getString(R.string.token), token);
        editor.apply();

    }
}
