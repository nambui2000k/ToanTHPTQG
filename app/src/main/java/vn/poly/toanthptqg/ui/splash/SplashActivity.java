package vn.poly.toanthptqg.ui.splash;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import vn.poly.toanthptqg.R;
import vn.poly.toanthptqg.ui.login.LoginActivity;
import vn.poly.toanthptqg.base.BaseActivity;

public class SplashActivity extends BaseActivity implements SplashContract.View {
    private SplashContract.Presenter presenter;
    private ImageView img_logo;
    private Animation animStartLogo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        init();
        presenter.countTime(3000);
        img_logo.startAnimation(animStartLogo);


    }
    private void init(){
        img_logo=findViewById(R.id.img_logo);
        presenter=new SplashPresenter(this);
        animStartLogo = AnimationUtils.loadAnimation(this,R.anim.anim_start_splash);
    }

    @Override
    public void openLoginActivity() {

        openActivy(LoginActivity.class);
        finish();
    }

}
