package vn.poly.toanthptqg.ui.home;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import vn.poly.toanthptqg.R;
import vn.poly.toanthptqg.base.BaseActivity;

public class HomeActivity extends BaseActivity implements HomeContract.View {
    private int positionSelectNav=0;
    private HomeContract.Presenter presenter;
    private BottomNavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        navView = findViewById(R.id.nav_view);
        presenter=new HomePresenter(this,this);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_test_day, R.id.navigation_do_exam, R.id.navigation_school,R.id.navigation_news,R.id.navigation_account)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(navView, navController);

        positionSelectNav=getIntent().getIntExtra("positionSelectNav",0);
        presenter.setNav(positionSelectNav,navView);
    }

    @Override
    public void setNav(int positionSelectNav, BottomNavigationView navView,int id) {
        navView.setSelectedItemId(id);
    }
}
