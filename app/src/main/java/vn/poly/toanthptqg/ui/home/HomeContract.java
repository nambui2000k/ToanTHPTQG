package vn.poly.toanthptqg.ui.home;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public interface HomeContract {
    interface View {
        void setNav(int positionSelectNav,BottomNavigationView navView,int id);
    }

    interface Presenter{
        void setNav(int positionSelectNav, BottomNavigationView navView);
    }
}
