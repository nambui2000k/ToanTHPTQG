package vn.poly.toanthptqg.ui.school.school;

public interface SchoolContract {
    interface View {
        void loadDataToRecylerView();
        void loadDataFromSearch(final String text);
    }

    interface Presenter{
        void logOut();
        void clearInforLogin();
    }
}
