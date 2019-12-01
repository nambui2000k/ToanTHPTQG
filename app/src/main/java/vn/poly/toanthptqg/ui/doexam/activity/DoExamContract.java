package vn.poly.toanthptqg.ui.doexam.activity;

public interface DoExamContract {
    interface View{
        void setValueDefaulAnswer();
        void setCountDownTime();
        void getDataFromFirebase();
        void finish();
        void loadImageAndRadioButton(int positionListAnswer, String linkQs);
        void confirmChange(int positionConfirmChange);
        void checkChoiced(String choice);
        String checkChoice(int idRadioButton);
        void load();
    }

    interface Presenter{

    }
}
