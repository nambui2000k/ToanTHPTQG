package vn.poly.toanthptqg.ui.home;

import android.app.Activity;
import android.content.Context;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import vn.poly.toanthptqg.R;

public class HomePresenter implements HomeContract.Presenter {
    private HomeContract.View view;
    private Context context;


    public HomePresenter(HomeContract.View view, Context context) {
        this.view = view;
        this.context = context;
    }




    @Override
    public void setNav(int positionSelectNav, BottomNavigationView navView) {
        switch (((Activity) context).getIntent().getIntExtra("positionSelectNav",0)){
            case 0:
                view.setNav(positionSelectNav,navView,R.id.navigation_test_day);
                break;
            case 1:
                view.setNav(positionSelectNav,navView,R.id.navigation_do_exam);
                break;
            case 2:
                view.setNav(positionSelectNav,navView,R.id.navigation_school);
                break;
            case 3:
                view.setNav(positionSelectNav,navView,R.id.navigation_news);
                break;
            case 4:
                view.setNav(positionSelectNav,navView,R.id.navigation_account);
                break;
        }

    }
}
