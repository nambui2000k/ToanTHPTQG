package vn.poly.toanthptqg.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import vn.poly.toanthptqg.R;

public class ReadNewsActivity extends AppCompatActivity {
    private WebView wvNews;
    private Toolbar toolbarReadNews;
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
        String link=bundle.getString("link").trim();
        String title=bundle.getString("title");
        wvNews.getSettings().setJavaScriptEnabled(true);
        wvNews.setWebViewClient(new WebViewClient());
        wvNews.loadUrl(link);
        actionBar.setTitle(title);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
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
                Toast.makeText(ReadNewsActivity.this, "Share Link News", Toast.LENGTH_LONG).show();
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);

    }
}
