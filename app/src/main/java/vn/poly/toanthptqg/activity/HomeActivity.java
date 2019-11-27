package vn.poly.toanthptqg.activity;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import vn.poly.toanthptqg.R;

public class HomeActivity extends BaseActivity {
    private int positionSelectNav=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_test_day, R.id.navigation_do_exam, R.id.navigation_school,R.id.navigation_news,R.id.navigation_account)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(navView, navController);

        positionSelectNav=getIntent().getIntExtra("positionSelectNav",0);
        switch (positionSelectNav){
            case 0:
                navView.setSelectedItemId(R.id.navigation_test_day);
                break;
            case 1:
                navView.setSelectedItemId(R.id.navigation_do_exam);
                break;
            case 2:
                navView.setSelectedItemId(R.id.navigation_school);
                break;
            case 3:
                navView.setSelectedItemId(R.id.navigation_news);
                break;
            case 4:
                navView.setSelectedItemId(R.id.navigation_account);
                break;
        }
    }

}
