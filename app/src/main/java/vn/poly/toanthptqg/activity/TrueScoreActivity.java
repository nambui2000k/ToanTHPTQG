package vn.poly.toanthptqg.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import vn.poly.toanthptqg.R;
import vn.poly.toanthptqg.adapter.YearSpinnerAdapter;

public class TrueScoreActivity extends AppCompatActivity {
    private AppCompatSpinner spnYear;
    private WebView wc;
    String linkurl;
    String linkhtml;
    String  nameUniversity;
    private Toolbar toolbarTrueScore;
    private Bundle bundle;
    private String year;
    private String linkHtmlYear;
    private List<String> listYear;
    private YearSpinnerAdapter yearSpinnerAdapter;
    private String endUrl;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_true_score);
        spnYear = (AppCompatSpinner) findViewById(R.id.spnYear);
        wc = (WebView) findViewById(R.id.wc);
        listYear=new ArrayList<>();
        toolbarTrueScore=findViewById(R.id.toolbarTrueScore);
        setSupportActionBar(toolbarTrueScore);
        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        bundle = getIntent().getExtras();
        nameUniversity= bundle.getString("nameUniversity");
        actionBar.setTitle(nameUniversity);

        Log.e("6","6");
        loadWebsite();
        Log.e("1","1");


        spnYear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                year=spnYear.getItemAtPosition(i).toString();
                loadWebsiteHasSpinner();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void loadWebsite() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                final StringBuilder builder = new StringBuilder();


                try {

                    endUrl="?y="+year;
                    bundle= getIntent().getExtras();
                    linkurl= bundle.getString("linkScore")+endUrl;

                    Document doc =Jsoup.connect(linkurl).get();
                    Log.e("4","4");
                    Element links = doc.select(".tab").first();
                    linkhtml=String.valueOf(links.getElementsByTag("table").attr("border","1"));
                    if(linkhtml.equals("")){
                        linkhtml=String.valueOf(links.getElementsByTag("center"));
                    }
                    Element linksYear = doc.select("#year").first();
                    linkHtmlYear=String.valueOf(linksYear.getElementsByTag("option").size());
                    for (int i=linksYear.getElementsByTag("option").size()-1;i>=0;i--){
                        listYear.add(String.valueOf(linksYear.getElementsByTag("option").get(i).val()));
                    }

                    runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            yearSpinnerAdapter =new YearSpinnerAdapter(TrueScoreActivity.this,listYear);
                            spnYear.setAdapter(yearSpinnerAdapter);

                        }
                    });



                    wc.post(new Runnable() {
                        @Override
                        public void run() {
                            wc.getSettings().setJavaScriptEnabled(true);
                            wc.loadData(linkhtml,"text/html", "UTF-8");
                        }
                    });


                } catch (IOException e) {
                    builder.append("Error : ").append(e.getMessage()).append("");
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.e("1",builder.toString());
                    }
                });
            }
        }).start();



    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void loadWebsiteHasSpinner() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                final StringBuilder builder = new StringBuilder();


                try {

                    endUrl="?y="+year;
                    bundle= getIntent().getExtras();
                    linkurl= bundle.getString("linkScore")+endUrl;

                    Document doc =Jsoup.connect(linkurl).get();
                    Log.e("4","4");
                    Element links = doc.select(".tab").first();
                    linkhtml=String.valueOf(links.getElementsByTag("table").attr("border","1"));
                    if(linkhtml.equals("")){
                        linkhtml=String.valueOf(links.getElementsByTag("center"));
                    }


                    wc.post(new Runnable() {
                        @Override
                        public void run() {
                            wc.getSettings().setJavaScriptEnabled(true);
                            wc.loadData(linkhtml,"text/html", "UTF-8");
                        }
                    });


                } catch (IOException e) {
                    builder.append("Error : ").append(e.getMessage()).append("");
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.e("1",builder.toString());
                    }
                });
            }
        }).start();



    }


}
