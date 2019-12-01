package vn.poly.toanthptqg.ui.doexam.listquestiondid;

import android.content.Context;

public class ListQuestionDidContractPresenter implements ListQuestionDidContract.Presenter {
    private ListQuestionDidContract.View view;
    private Context context;

    public ListQuestionDidContractPresenter(ListQuestionDidContract.View view, Context context) {
        this.view = view;
        this.context = context;
    }
}
