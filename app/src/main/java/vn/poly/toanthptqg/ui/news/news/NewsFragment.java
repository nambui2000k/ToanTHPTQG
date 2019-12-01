package vn.poly.toanthptqg.ui.news.news;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import vn.poly.toanthptqg.R;
import vn.poly.toanthptqg.base.BaseFragment;
import vn.poly.toanthptqg.adapter.NewsAdapter;
import vn.poly.toanthptqg.data.model.News;

public class NewsFragment extends BaseFragment implements NewsContract.View {
    private NewsContract.Presenter presenter;
    private Toolbar toolbar;
    private RecyclerView rcvListNews;
    private NewsAdapter newsAdapter;
    private SearchView searchView;
    private List<News> newsList;
    private String textQuery="";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return setViewFragment(R.layout.fragment_news,container,inflater);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toolbar= view.findViewById(R.id.toolbar);
        rcvListNews=view.findViewById(R.id.rcvListNews);
        presenter=new NewPresenter(this,getContext());
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        ActionBar actionBar = activity.getSupportActionBar();
        actionBar.setTitle(R.string.title_news);
        GetData getData=new GetData();
        getData.execute("https://vnexpress.net/rss/giao-duc.rss");




    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
        MenuItem searchItem = menu.findItem(R.id.search);
        MenuItem shareItem = menu.findItem(R.id.share);
        shareItem.setVisible(false);
        searchView= (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setQueryHint(getString(R.string.search));
        searchView.setIconifiedByDefault(true);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(final String newText) {
                textQuery=newText;
                GetData getData=new GetData();
                getData.execute("https://vnexpress.net/rss/giao-duc.rss");
                return false;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.share:
                Toast.makeText(getActivity(), "Share News", Toast.LENGTH_LONG).show();
                return true;
            case R.id.logout:
                presenter.logOut();
                break;
            case R.id.exit:
                getActivity().moveTaskToBack(true);
                getActivity().finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    class GetData extends AsyncTask<String,Long, ArrayList<News>> {

        @Override
        protected ArrayList<News> doInBackground(String... strings) {
            ArrayList<News> newsArrayList=new ArrayList<>();
            String link=strings[0];

            try {
                URL url=new URL(link);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                // du lieu
                InputStream inputStream=httpURLConnection.getInputStream();
                //khoi tao xml parser
                XmlPullParserFactory xmlPullParserFactory=XmlPullParserFactory.newInstance();
                //xmlPullParserFactory.setNamespaceAware(false);
                XmlPullParser xmlPullParser=xmlPullParserFactory.newPullParser();
                xmlPullParser.setInput(inputStream,"utf-8");
                int eventType=xmlPullParser.getEventType();
                News news=null;
                String text="";

                while (eventType!=XmlPullParser.END_DOCUMENT){
                    String tag=xmlPullParser.getName();
                    eventType=xmlPullParser.getEventType();

                    switch (eventType){
                        case XmlPullParser.START_TAG:
                            if (tag.equalsIgnoreCase("item")){
                                news=new News();
                            }
                            break;
                        case XmlPullParser.TEXT:
                            text=xmlPullParser.getText();
                            break;
                        case XmlPullParser.END_TAG:
                            if (news!=null){
                                if(tag.equalsIgnoreCase("title")){
                                    news.setTitle(text);
                                } else if (tag.equalsIgnoreCase("pubDate")){
                                    news.setTime(text);
                                } else if (tag.equalsIgnoreCase("description")){
                                    news.setDescription(text);
                                }else if (tag.equalsIgnoreCase("link")){
                                    news.setLink(text);
                                } else if (tag.equalsIgnoreCase("item")){
                                    newsArrayList.add(news);
                                }
                            }
                            break;
                    }
                    xmlPullParser.next();
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }

            return newsArrayList ;
        }

        // ket thuc xu ly va tuong tac voi giao dien

        @Override
        protected void onPostExecute(ArrayList<News> newsArrayList) {
            super.onPostExecute(newsArrayList);
            newsList=new ArrayList<>();
            if(textQuery.equals("")){
                newsAdapter=new NewsAdapter(getContext(),newsArrayList);
            } else {
                for(int i=0;i<newsArrayList.size();i++){
                    if(newsArrayList.get(i).getTitle().contains(textQuery)){
                        News news=newsArrayList.get(i);
                        newsList.add(new News(news.getTitle(),news.getDescription(),news.getTime(),news.getImage(),news.getLink()));
                    }
                }
                newsAdapter=new NewsAdapter(getContext(),newsList);
            }

            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
            rcvListNews.setHasFixedSize(true);
            rcvListNews.setLayoutManager(linearLayoutManager);
            rcvListNews.setAdapter(newsAdapter);




        }
    }

}