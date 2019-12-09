package vn.poly.toanthptqg.ui.login;

import android.content.Context;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

import vn.poly.toanthptqg.data.database.DataBaseExamDid;

public interface LoginContract {
    interface View {
        void openHomeActivity();
        void showLoginWithGmail();
        void showLoginWithFacebook();
        void firebaseAuthWithGoogle(GoogleSignInAccount acct);
    }

    interface Presenter{
        void checkInforLastLogin(FirebaseAuth mAuth);
        void saveInforLogin(String nameDisplay,String email,String phone,String linkAvatar,String token);
        void createDataBaseExamDid(DataBaseExamDid dataBaseExamDid);
        void handleFacebookAccessToken(AccessToken token, FirebaseAuth mAuth);
        void onFacebookLoginClicked(CallbackManager mCallbackManager,FirebaseAuth mAuth);
        void onGmailLoginClicked();

    }
}
