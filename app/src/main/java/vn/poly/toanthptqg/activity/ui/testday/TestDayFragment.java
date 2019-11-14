package vn.poly.toanthptqg.activity.ui.testday;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import vn.poly.toanthptqg.R;
import vn.poly.toanthptqg.activity.BaseFragment;
import vn.poly.toanthptqg.model.Sentence;

public class TestDayFragment extends BaseFragment {

    private SimpleDateFormat simpleDateFormat;
    private String dateTest = "15/11/2019";
    private String startDate;
    private TextView tvCountDay;
    private TextView tvDateTest;
    private TextView tvContent;
    private TextView tvAuthor;
    private long getDiff;
    private long getDaysDiff;
    private long yearDateTest;
    private TextView tvYearDateTest;
    private List<Sentence> sentenceList;
    private int idRandom;





    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return setViewFragment(R.layout.fragment_test_day, container, inflater);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        tvCountDay = (TextView) view.findViewById(R.id.tvCountDay);
        tvDateTest = (TextView) view.findViewById(R.id.tvDateTest);
        tvYearDateTest = (TextView) view.findViewById(R.id.tvYearDateTest);
        tvContent = (TextView) view.findViewById(R.id.tvContent);
        tvAuthor = (TextView) view.findViewById(R.id.tvAuthor);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        ActionBar actionBar = activity.getSupportActionBar();
        actionBar.setTitle(R.string.title_test_day);

        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Date currentDate = new Date();


        try {
            startDate = simpleDateFormat.format(currentDate);

            getDiff= simpleDateFormat.parse(dateTest).getTime() - simpleDateFormat.parse(startDate).getTime();
            getDaysDiff= getDiff / (24 * 60 * 60 * 1000);

        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            yearDateTest=(simpleDateFormat.parse(dateTest).getYear()+1900);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if(getDaysDiff<0){
            tvYearDateTest.setText(yearDateTest+1+"");
            tvCountDay.setText("0");
            tvDateTest.setText(R.string.updating);
        } else if(getDaysDiff>0){
            tvYearDateTest.setText(yearDateTest+"");
            tvDateTest.setText(dateTest);
            tvCountDay.setText(getDaysDiff+"");
        } else {
            tvYearDateTest.setText(yearDateTest+"");
            tvCountDay.setText("0");
            tvDateTest.setText(R.string.today);
            tvContent.setText(R.string.greeting_sentence);
            tvAuthor.setText("");
        }

        sentenceList=new ArrayList<>();
        sentenceList.add(new Sentence(1,getActivity().getString(R.string.sentence1),getActivity().getString(R.string.author1)));
        sentenceList.add(new Sentence(2,getActivity().getString(R.string.sentence2),getActivity().getString(R.string.author2)));
        sentenceList.add(new Sentence(3,getActivity().getString(R.string.sentence3),getActivity().getString(R.string.author3)));
        sentenceList.add(new Sentence(4,getActivity().getString(R.string.sentence4),getActivity().getString(R.string.author4)));
        sentenceList.add(new Sentence(5,getActivity().getString(R.string.sentence5),getActivity().getString(R.string.author5)));
        sentenceList.add(new Sentence(6,getActivity().getString(R.string.sentence6),getActivity().getString(R.string.author6)));
        sentenceList.add(new Sentence(7,getActivity().getString(R.string.sentence7),getActivity().getString(R.string.author7)));
        sentenceList.add(new Sentence(8,getActivity().getString(R.string.sentence8),getActivity().getString(R.string.author8)));
        sentenceList.add(new Sentence(9,getActivity().getString(R.string.sentence9),getActivity().getString(R.string.author9)));
        sentenceList.add(new Sentence(10,getActivity().getString(R.string.sentence10),getActivity().getString(R.string.author10)));
        sentenceList.add(new Sentence(11,getActivity().getString(R.string.sentence11),getActivity().getString(R.string.author11)));
        sentenceList.add(new Sentence(12,getActivity().getString(R.string.sentence12),getActivity().getString(R.string.author12)));
        sentenceList.add(new Sentence(13,getActivity().getString(R.string.sentence13),getActivity().getString(R.string.author13)));
        sentenceList.add(new Sentence(14,getActivity().getString(R.string.sentence14),getActivity().getString(R.string.author14)));


        idRandom=(int)Math.round(Math.random()*sentenceList.size())-1;
        tvContent.setText(sentenceList.get(idRandom).getContent());
        tvAuthor.setText(sentenceList.get(idRandom).getAuthor());




    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
        MenuItem searchItem = menu.findItem(R.id.search);
        searchItem.setVisible(false);


        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.share:
                Toast.makeText(getActivity(), "Share Test Day", Toast.LENGTH_LONG).show();
                return true;
            case R.id.logout:
                Toast.makeText(getActivity(), "Logout Test Day", Toast.LENGTH_LONG).show();
                break;
            case R.id.exit:
                Toast.makeText(getActivity(), "Exit Test Day", Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);

    }
}