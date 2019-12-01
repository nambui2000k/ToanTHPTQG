package vn.poly.toanthptqg.ui.splash;

import android.os.Bundle;

import vn.poly.toanthptqg.R;
import vn.poly.toanthptqg.ui.login.LoginActivity;
import vn.poly.toanthptqg.base.BaseActivity;

public class SplashActivity extends BaseActivity implements SplashContract.View {
    private SplashContract.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        presenter=new SplashPresenter(this);
        presenter.countTime(3000);

    }

    @Override
    public void openLoginActivity() {
        openActivy(LoginActivity.class);
        finish();
    }
}
