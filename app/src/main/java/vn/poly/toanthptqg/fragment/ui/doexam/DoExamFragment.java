package vn.poly.toanthptqg.fragment.ui.doexam;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
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

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import vn.poly.toanthptqg.R;
import vn.poly.toanthptqg.activity.BaseFragment;
import vn.poly.toanthptqg.activity.DataBaseExamDid;
import vn.poly.toanthptqg.activity.LoginActivity;
import vn.poly.toanthptqg.adapter.ExamAdapter;
import vn.poly.toanthptqg.adapter.NewsAdapter;
import vn.poly.toanthptqg.model.Exam;


public class DoExamFragment extends BaseFragment {
    private Toolbar toolbar;
    private RecyclerView rcvListExam;
    private ExamAdapter examAdapter;
    private List<Exam> examList;
    private DatabaseReference mData;
    private DataBaseExamDid dataBaseExamDid;

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
        dataBaseExamDid=new DataBaseExamDid(getContext());
        dataBaseExamDid.createDataBase();
        dataBaseExamDid.close();

        // get Exam from database
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
                logOut();
                break;
            case R.id.exit:
                Toast.makeText(getActivity(), "Exit Do Exam", Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    public void logOut() {
        AuthUI.getInstance().signOut(getActivity()).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                clearInforLogin();
                Intent intent=new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);


            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }
    private void clearInforLogin(){
        SharedPreferences sharedPreferences= getActivity().getSharedPreferences(getActivity().getResources().getString(R.string.key_save_inforLogin), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
    private void setRecyclerView(){
        examAdapter=new ExamAdapter(getActivity(),examList);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        rcvListExam.setHasFixedSize(true);
        rcvListExam.setLayoutManager(linearLayoutManager);
        rcvListExam.setAdapter(examAdapter);
    }
}