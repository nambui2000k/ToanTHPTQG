package vn.poly.toanthptqg.fragment.ui.testday;

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

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
    private String dateTest;
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
    private Toolbar toolbar;
    private DatabaseReference mData;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return setViewFragment(R.layout.fragment_test_day, container, inflater);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvCountDay = (TextView) view.findViewById(R.id.tvCountDay);
        tvDateTest = (TextView) view.findViewById(R.id.tvDateTest);
        tvYearDateTest = (TextView) view.findViewById(R.id.tvYearDateTest);
        tvContent = (TextView) view.findViewById(R.id.tvContent);
        tvAuthor = (TextView) view.findViewById(R.id.tvAuthor);
        toolbar = view.findViewById(R.id.toolbar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        ActionBar actionBar = activity.getSupportActionBar();
        actionBar.setTitle(R.string.title_test_day);
        sentenceList = new ArrayList<>();
        mData = FirebaseDatabase.getInstance().getReference();
        mData.child("DateTest").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                dateTest = dataSnapshot.getValue().toString();
                loadDate();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        mData.child("Sentence").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                sentenceList.add(dataSnapshot.getValue(Sentence.class));
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        mData.child("Sentence").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                loadSentence();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

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

    private void loadSentence() {
        idRandom = (int) Math.round(Math.random() * sentenceList.size()) - 1;
        if (idRandom == -1) {
            idRandom = 0;
        }
        tvContent.setText(sentenceList.get(idRandom).getContent());
        tvAuthor.setText(sentenceList.get(idRandom).getAuthor());
    }

    private void loadDate() {
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Date currentDate = new Date();


        try {
            startDate = simpleDateFormat.format(currentDate);

            getDiff = simpleDateFormat.parse(dateTest).getTime() - simpleDateFormat.parse(startDate).getTime();
            getDaysDiff = getDiff / (24 * 60 * 60 * 1000);

        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            yearDateTest = (simpleDateFormat.parse(dateTest).getYear() + 1900);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (getDaysDiff < 0) {
            tvYearDateTest.setText(yearDateTest + 1 + "");
            tvCountDay.setText("0");
            tvDateTest.setText(R.string.updating);
        } else if (getDaysDiff > 0) {
            tvYearDateTest.setText(yearDateTest + "");
            tvDateTest.setText(dateTest);
            tvCountDay.setText(getDaysDiff + "");
        } else {
            tvYearDateTest.setText(yearDateTest + "");
            tvCountDay.setText("0");
            tvDateTest.setText(R.string.today);
            tvContent.setText(R.string.greeting_sentence);
            tvAuthor.setText("");
        }
    }
}