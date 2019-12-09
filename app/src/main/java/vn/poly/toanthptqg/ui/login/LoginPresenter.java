package vn.poly.toanthptqg.ui.login;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import vn.poly.toanthptqg.R;
import vn.poly.toanthptqg.data.database.DataBaseExamDid;

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View view;
    private Context context;

    public LoginPresenter(LoginContract.View view, Context context) {
        this.view = view;
        this.context = context;
    }

    @Override
    public void checkInforLastLogin(FirebaseAuth mAuth) {
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if(currentUser!= null){
            view.openHomeActivity();
        }

    }

    @Override
    public void saveInforLogin(String nameDisplay,String email,String phone,String linkAvatar,String token) {
        SharedPreferences sharedPreferences= context.getSharedPreferences(context.getResources().getString(R.string.key_save_inforLogin), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(context.getResources().getString(R.string.name_display), nameDisplay);
        editor.putString(context.getResources().getString(R.string.email), email);
        editor.putString(context.getResources().getString(R.string.phone), phone);
        editor.putString(context.getResources().getString(R.string.url_avatar), linkAvatar);
        editor.putString(context.getResources().getString(R.string.token), token);
        editor.apply();
        view.openHomeActivity();

    }

    @Override
    public void createDataBaseExamDid(DataBaseExamDid dataBaseExamDid) {
        dataBaseExamDid=new DataBaseExamDid(context);
        dataBaseExamDid.createDataBase();
        dataBaseExamDid.close();
    }

    @Override
    public void handleFacebookAccessToken(AccessToken token, final FirebaseAuth mAuth) {
        Log.d("FACEBOOKLOG", "handleFacebookAccessToken:" + token);

        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener((Activity) context, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull com.google.android.gms.tasks.Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d("FACEBOOKLOG", "signInWithCredential:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    saveInforLogin(user.getDisplayName(),user.getEmail(),user.getPhoneNumber(),user.getPhotoUrl()+"?height=500",user.getIdToken(true)+"");
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w("FACEBOOKLOG", "signInWithCredential:failure", task.getException());
                                    view.openHomeActivity();
                                }
                            }
                        }
                );
    }

    @Override
    public void onFacebookLoginClicked(CallbackManager mCallbackManager, final FirebaseAuth mAuth) {

        view.showLoginWithFacebook();
    }

    @Override
    public void onGmailLoginClicked() {
             view.showLoginWithGmail();
    }



}
