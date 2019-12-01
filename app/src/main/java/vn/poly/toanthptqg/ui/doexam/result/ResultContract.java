package vn.poly.toanthptqg.ui.doexam.result;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

public interface ResultContract {
    interface View {
        void setText();
        void getDataFromFirebase();
        void countSentence(String examDidAnswer,String examAnswer);
        void checkResult();
        void startActivityForResult();
    }

    interface Presenter{
        void share(ImageView imageView);
        void getImageShowShareDialog(ImageView imageView);
        Bitmap takescreenshot(android.view.View v);
        Bitmap takescreenshotOfRootView(android.view.View v);

    }
}
