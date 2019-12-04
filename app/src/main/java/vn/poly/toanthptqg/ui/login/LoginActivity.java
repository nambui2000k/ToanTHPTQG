package vn.poly.toanthptqg.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

import vn.poly.toanthptqg.R;
import vn.poly.toanthptqg.ui.home.HomeActivity;
import vn.poly.toanthptqg.base.BaseActivity;
import vn.poly.toanthptqg.data.database.DataBaseExamDid;

public class LoginActivity extends BaseActivity implements LoginContract.View {
    private LoginContract.Presenter presenter;
    private LinearLayout lnlLoginGoogle;
    private LinearLayout lnlLoginFacebook;
    private List<AuthUI.IdpConfig> configList;
    private static final int MY_REQUEST_CODE = 567;
    private CallbackManager mCallbackManager;
    private FirebaseAuth mAuth;
    private DataBaseExamDid dataBaseExamDid;
    private Animation anim_logo_login;
    private Animation anim_logo_with_gmail;
    private Animation anim_logo_with_facebook;
    private LinearLayout lnlLogo;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initActivity();
        mAuth = FirebaseAuth.getInstance();
        mCallbackManager = CallbackManager.Factory.create();
        presenter=new LoginPresenter(this,LoginActivity.this);

        lnlLoginFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onFacebookLoginClicked(mCallbackManager,mAuth);
            }
        });

        lnlLoginGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onGmailLoginClicked();
            }
        });
    }



    private void initActivity(){
        anim_logo_login= AnimationUtils.loadAnimation(this,R.anim.anim_logo_login);
        anim_logo_with_gmail= AnimationUtils.loadAnimation(this,R.anim.anim_login_with_gmail);
        anim_logo_with_facebook= AnimationUtils.loadAnimation(this,R.anim.anim_login_with_facebook);

        lnlLoginGoogle = (LinearLayout) findViewById(R.id.lnlLoginGoogle);
        lnlLoginFacebook = (LinearLayout) findViewById(R.id.lnlLoginFacebook);
        lnlLogo = (LinearLayout) findViewById(R.id.lnlLogo);
        lnlLogo.startAnimation(anim_logo_login);
        lnlLoginGoogle.startAnimation(anim_logo_with_gmail);
        lnlLoginFacebook.startAnimation(anim_logo_with_facebook);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mCallbackManager.onActivityResult(requestCode, resultCode, data);

        if (requestCode == MY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                presenter.saveInforLogin(user.getDisplayName(),user.getEmail(),user.getPhoneNumber(),user.getPhotoUrl()+"",user.getIdToken(true)+"");
            } else if(resultCode == RESULT_CANCELED){
                Toast.makeText(this,"You canceled",Toast.LENGTH_LONG).show();
            } else if(resultCode == RESULT_FIRST_USER){
                Toast.makeText(this,"first user",Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.createDataBaseExamDid(dataBaseExamDid);
        presenter.checkInforLastLogin(mAuth);

    }

    @Override
    public void openHomeActivity() {
        openActivy(HomeActivity.class);
        finish();
    }

    @Override
    public void showLoginWithGmail() {
        configList = Arrays.asList(new AuthUI.IdpConfig.GoogleBuilder().build()
        );
        startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders(configList).setTheme(R.style.NoActionbar).build(), MY_REQUEST_CODE);
    }


    @Override
    public void showLoginWithFacebook() {
        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("email","public_profile"));
        LoginManager.getInstance().registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d("FACELOG", "facebook:onSuccess:" + loginResult);
                presenter.handleFacebookAccessToken(loginResult.getAccessToken(),mAuth);
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


}
