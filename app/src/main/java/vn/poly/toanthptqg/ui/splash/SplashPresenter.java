package vn.poly.toanthptqg.ui.splash;

public class SplashPresenter implements SplashContract.Presenter {
    private SplashContract.View view;

    public SplashPresenter(SplashContract.View view) {
        this.view = view;
    }

    @Override
    public void countTime(final int amountTime) {


        Thread thread=new Thread(){
            @Override
            public void run() {
                try {
                    sleep(amountTime);
                    view.openLoginActivity();

                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        thread.start();

    }


}
