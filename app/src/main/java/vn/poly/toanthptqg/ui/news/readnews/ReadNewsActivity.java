package vn.poly.toanthptqg.ui.news.readnews;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;
import com.firebase.ui.auth.AuthUI;

import java.util.Arrays;
import java.util.List;

import vn.poly.toanthptqg.R;

public class ReadNewsActivity extends AppCompatActivity implements ReadNewsContract.View {
    private ReadNewsContract.Presenter presenter;
    private WebView wvNews;
    private Toolbar toolbarReadNews;
    private static final int MY_REQUEST_CODE = 567;
    private List<AuthUI.IdpConfig> configList;
    private String link;
    private String title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_news);
        toolbarReadNews=findViewById(R.id.toolbarReadNews);
        wvNews=findViewById(R.id.wvNews);
        setSupportActionBar(toolbarReadNews);
        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Bundle bundle=getIntent().getExtras();
        link=bundle.getString("link").trim();
        title=bundle.getString("title");
        wvNews.getSettings().setJavaScriptEnabled(true);
        wvNews.setWebViewClient(new WebViewClient());
        wvNews.loadUrl(link);
        actionBar.setTitle(title);
        presenter=new ReadNewsPresenter(this,this);


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.anim_exit_map_activity,R.anim.anim_enter_map_activity);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem searchItem = menu.findItem(R.id.search);
        searchItem.setVisible(false);
        MenuItem logoutItem = menu.findItem(R.id.logout);
        logoutItem.setVisible(false);
        MenuItem exitItem = menu.findItem(R.id.exit);
        exitItem.setVisible(false);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.share:
                presenter.share(link);
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                presenter.showDialogShare(link);
            }
        }
    }
    @Override
    public void startActivityForResult() {
        configList = Arrays.asList(
                new AuthUI.IdpConfig.FacebookBuilder().build()
        );
        startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders(configList).setTheme(R.style.NoActionbar).build(), MY_REQUEST_CODE);

    }
}
