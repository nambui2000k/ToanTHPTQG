package vn.poly.toanthptqg.ui.doexam.listquestiondid;

import android.widget.ImageView;
import android.widget.TextView;

public interface ListQuestionDidContract {
    interface View{
        void getExam();
        void handlingTheme(TextView tvQuestion, String AnswerExemDid, String AnswerExam, ImageView imgResult );
        void handling();

    }

    interface Presenter{

    }
}
