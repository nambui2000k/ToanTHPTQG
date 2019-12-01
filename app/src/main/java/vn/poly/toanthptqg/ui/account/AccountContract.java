package vn.poly.toanthptqg.ui.account;

public interface AccountContract {
    interface View{
        void setInforLogin();
        void setExam();
        void setUIForAmountExam();
    }
    interface Presenter{
        void logOut();
        void clearInforLogin();
        void getInforLogin();
        void getExam();
    }
}
