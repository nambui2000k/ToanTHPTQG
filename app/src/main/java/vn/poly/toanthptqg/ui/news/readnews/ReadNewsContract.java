package vn.poly.toanthptqg.ui.news.readnews;

import com.firebase.ui.auth.AuthUI;

import java.util.List;

public interface ReadNewsContract {
    interface View {
        void startActivityForResult();
    }

    interface Presenter{
        void share(String link);
        void showDialogShare(String link);
    }
}

