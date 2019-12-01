package vn.poly.toanthptqg.ui.splash;

public interface SplashContract {
    interface View {
        void openLoginActivity();
    }
    interface Presenter{
        void countTime(int amountTime);
    }
}
