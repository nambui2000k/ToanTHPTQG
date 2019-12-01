package vn.poly.toanthptqg.ui.doexam.result;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareDialog;
import com.firebase.ui.auth.AuthUI;

import java.util.Arrays;

import vn.poly.toanthptqg.R;
import vn.poly.toanthptqg.ui.news.readnews.ReadNewsContract;

public class ResultPresenter implements ResultContract.Presenter {
    private ResultContract.View view;
    private Context context;

    public ResultPresenter(ResultContract.View view, Context context) {
        this.view = view;
        this.context = context;
    }

    @Override
    public void share(ImageView imageView) {
        SharedPreferences sharedPreferences= context.getSharedPreferences("com.facebook.loginManager", Context.MODE_PRIVATE);
        if(sharedPreferences.getBoolean("express_login_allowed",false)){
            getImageShowShareDialog(imageView);
        } else {
           view.startActivityForResult();
        }
    }

    @Override
    public void getImageShowShareDialog(ImageView imageView) {
        Bitmap bitmap=takescreenshotOfRootView(imageView);
        SharePhoto photo=new SharePhoto.Builder().setBitmap(bitmap).build();
        SharePhotoContent content=new SharePhotoContent.Builder().addPhoto(photo).build();
        ShareDialog shareDialog=new ShareDialog((Activity) context);
        shareDialog.show(content,ShareDialog.Mode.AUTOMATIC);
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
}
