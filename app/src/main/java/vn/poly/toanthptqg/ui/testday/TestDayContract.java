package vn.poly.toanthptqg.ui.testday;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.TextView;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.database.DatabaseReference;

import java.util.List;

import vn.poly.toanthptqg.data.model.Sentence;

public interface TestDayContract {
    interface View{
        void loadSentence();
        void loadDate();
        void startActivityForResult();
    }

    interface Presenter{
        void logOut();
        void clearInforLogin();
        Bitmap takescreenshot(android.view.View v);
        Bitmap takescreenshotOfRootView(android.view.View v);
        void share(List<AuthUI.IdpConfig> configList,TextView textView);
        void getImageShowShareDialog(TextView textView);
    }
}
