package vn.poly.toanthptqg.ui.news.readnews;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;

import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;
import com.firebase.ui.auth.AuthUI;

import java.util.Arrays;
import java.util.List;

import vn.poly.toanthptqg.R;

public class ReadNewsPresenter implements ReadNewsContract.Presenter {
    private ReadNewsContract.View view;
    private Context context;

    public ReadNewsPresenter(ReadNewsContract.View view, Context context) {
        this.view = view;
        this.context = context;
    }

    @Override
    public void share(String link) {
        List<AuthUI.IdpConfig> configList=Arrays.asList(
                new AuthUI.IdpConfig.FacebookBuilder().build()
        );
        SharedPreferences sharedPreferences= context.getSharedPreferences("com.facebook.loginManager", Context.MODE_PRIVATE);
        if(sharedPreferences.getBoolean("express_login_allowed",false)){
            showDialogShare(link);
        } else {
           view.startActivityForResult();
        }
    }

    @Override
    public void showDialogShare(String link) {
        ShareLinkContent content = new ShareLinkContent.Builder()
                .setContentUrl(Uri.parse(link))
                .build();
        ShareDialog shareDialog=new ShareDialog((Activity) context);
        shareDialog.show(content,ShareDialog.Mode.AUTOMATIC);
    }
}
