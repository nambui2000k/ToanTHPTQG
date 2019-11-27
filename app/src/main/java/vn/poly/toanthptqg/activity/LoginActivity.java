package vn.poly.toanthptqg.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

import bolts.Task;
import vn.poly.toanthptqg.R;

public class LoginActivity extends BaseActivity {
    private LinearLayout lnlLoginGoogle;
    private LinearLayout lnlLoginFacebook;
    private List<AuthUI.IdpConfig> configList;
    private static final int MY_REQUEST_CODE = 567;
    private CallbackManager mCallbackManager;
    private FirebaseAuth mAuth;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initActivity();
        checkInforLastLogin();
        // Initialize Facebook Login button
        mAuth = FirebaseAuth.getInstance();
        mCallbackManager = CallbackManager.Factory.create();

    }



    private void initActivity(){
        lnlLoginGoogle = (LinearLayout) findViewById(R.id.lnlLoginGoogle);
        lnlLoginFacebook = (LinearLayout) findViewById(R.id.lnlLoginFacebook);
    }

    public void lnlLoginFacebook(View view) {
        LoginManager.getInstance().logInWithReadPermissions(LoginActivity.this,Arrays.asList("email","public_profile"));
        LoginManager.getInstance().registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d("FACELOG", "facebook:onSuccess:" + loginResult);
                handleFacebookAccessToken(loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {
                Log.d("FACELOG", "facebook:onCancel");

            }

            @Override
            public void onError(FacebookException error) {
                Log.d("FACELOG", "facebook:onError", error);
                // ...
            }
        });
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
        mCallbackManager.onActivityResult(requestCode, resultCode, data);

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


    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if(currentUser!= null){
            updateUI();
        }

    }

    private void updateUI() {
        openActivy(HomeActivity.class);
        finish();

    }

    private void handleFacebookAccessToken(AccessToken token) {
        Log.d("FACEBOOKLOG", "handleFacebookAccessToken:" + token);

        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull com.google.android.gms.tasks.Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("FACEBOOKLOG", "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            saveInforLogin(user.getDisplayName(),user.getEmail(),user.getPhoneNumber(),user.getPhotoUrl()+"",user.getIdToken(true)+"");
                            updateUI();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("FACEBOOKLOG", "signInWithCredential:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI();
                        }
                    }
                    }
                    );
    }
}
