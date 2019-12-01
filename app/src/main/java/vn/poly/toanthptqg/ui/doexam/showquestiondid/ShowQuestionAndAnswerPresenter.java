package vn.poly.toanthptqg.ui.doexam.showquestiondid;

import android.content.Context;

public class ShowQuestionAndAnswerPresenter implements ShowQuestionAndAnswerContract.Presenter {
    private ShowQuestionAndAnswerContract.View view;
    private Context context;

    public ShowQuestionAndAnswerPresenter(ShowQuestionAndAnswerContract.View view, Context context) {
        this.view = view;
        this.context = context;
    }
}
