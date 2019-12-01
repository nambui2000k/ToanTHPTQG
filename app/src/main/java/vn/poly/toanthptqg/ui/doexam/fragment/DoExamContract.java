package vn.poly.toanthptqg.ui.doexam.fragment;

public interface DoExamContract {
    interface View {

        void setRecyclerView();
    }

    interface Presenter{
        void clearInforLogin();
        void logOut();
    }
}
