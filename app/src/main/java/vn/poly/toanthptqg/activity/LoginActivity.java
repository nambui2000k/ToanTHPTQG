package vn.poly.toanthptqg.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import vn.poly.toanthptqg.R;

public class LoginActivity extends BaseActivity {
    private LinearLayout lnlLoginGoogle;
    private LinearLayout lnlLoginFacebook;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initActivity();

    }
    private void initActivity(){
        lnlLoginGoogle = (LinearLayout) findViewById(R.id.lnlLoginGoogle);
        lnlLoginFacebook = (LinearLayout) findViewById(R.id.lnlLoginFacebook);
    }

    public void lnlLoginFacebook(View view) {
        openActivy(HomeActivity.class);
        Toast.makeText(LoginActivity.this,"FB",Toast.LENGTH_LONG).show();

    }

    public void lnlLoginGoogle(View view) {
        openActivy(HomeActivity.class);
        Toast.makeText(LoginActivity.this,"GG",Toast.LENGTH_LONG).show();
    }
}
