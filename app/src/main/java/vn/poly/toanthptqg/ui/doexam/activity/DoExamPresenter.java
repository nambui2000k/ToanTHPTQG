package vn.poly.toanthptqg.ui.doexam.activity;

import android.content.Context;

public class DoExamPresenter implements DoExamContract.Presenter {
    private DoExamContract.View view;
    private Context context;

    public DoExamPresenter(DoExamContract.View view, Context context) {
        this.view = view;
        this.context = context;
    }
}
