package vn.poly.toanthptqg.ui.doexam.showquestiondid;

public interface ShowQuestionAndAnswerContract {
    interface View {
        void getExam();
        void checkChoiced(String choice);
        void load();
        void loadImageAndRadioButton(String examAnswer, String linkQs, String asExamDid);
    }
    interface Presenter{

    }
}
