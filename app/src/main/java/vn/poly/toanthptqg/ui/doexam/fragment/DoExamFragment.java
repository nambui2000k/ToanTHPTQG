package vn.poly.toanthptqg.ui.doexam.fragment;

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
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import vn.poly.toanthptqg.R;
import vn.poly.toanthptqg.base.BaseFragment;
import vn.poly.toanthptqg.adapter.ExamAdapter;
import vn.poly.toanthptqg.data.model.Exam;


public class DoExamFragment extends BaseFragment implements DoExamContract.View {
    private DoExamContract.Presenter presenter;
    private Toolbar toolbar;
    private RecyclerView rcvListExam;
    private ExamAdapter examAdapter;
    private List<Exam> examList;
    private DatabaseReference mData;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return setViewFragment(R.layout.fragment_do_exam, container, inflater);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toolbar= view.findViewById(R.id.toolbar);
        rcvListExam=view.findViewById(R.id.rcvListExam);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        ActionBar actionBar = activity.getSupportActionBar();
        actionBar.setTitle(R.string.list_exam);
        examList=new ArrayList<>();
        presenter=new DoExamPresenter(this,getContext());
        mData = FirebaseDatabase.getInstance().getReference();

        mData.child("Exam").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                examList.add(dataSnapshot.getValue(Exam.class));

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
        mData.child("Exam").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                setRecyclerView();
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
        MenuItem shareItem = menu.findItem(R.id.share);
        searchItem.setVisible(false);
        shareItem.setVisible(false);

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.share:
                Toast.makeText(getActivity(), "Share Do Exam", Toast.LENGTH_LONG).show();
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

    public void setRecyclerView(){
        examAdapter=new ExamAdapter(getActivity(),examList);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        rcvListExam.setHasFixedSize(true);
        rcvListExam.setLayoutManager(linearLayoutManager);
        rcvListExam.setAdapter(examAdapter);
    }
}