package vn.poly.toanthptqg.ui.account;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import vn.poly.toanthptqg.R;
import vn.poly.toanthptqg.data.database.DataBaseExamDid;
import vn.poly.toanthptqg.base.BaseFragment;
import vn.poly.toanthptqg.data.model.Exam;
import vn.poly.toanthptqg.data.model.ExamDid;

public class AccountFragment extends BaseFragment implements AccountContract.View {
    private AccountContract.Presenter presenter;

    private CircleImageView imageAvatar;
    private TextView tvEmail;
    private TextView tvPhoneNumber;
    private TextView tvNameDisplay;
    private LinearLayout lnlLogout;
    private String  name, email, phone, linkImage;
    private TextView tvAmountExamDid;
    private TextView tvAmountExam;
    private DatabaseReference mData;
    private List<Exam> examList;
    private List<ExamDid> examDidList;
    private DataBaseExamDid dataBaseExamDid;







    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return setViewFragment(R.layout.fragment_account,container,inflater);
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        presenter.getInforLogin();

        lnlLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.logOut();
            }
        });
        tvNameDisplay.setText(name);
        tvEmail.setText(email);
        tvPhoneNumber.setText(phone);
        Picasso.with(getContext()).load(linkImage).into(imageAvatar);
        presenter.getExam();





    }
    private void init(View view){
        presenter=new AccountPresenter(this,getContext());
        imageAvatar = (CircleImageView) view.findViewById(R.id.imageAvatar);
        tvEmail = (TextView) view.findViewById(R.id.tvEmail);
        tvNameDisplay = (TextView) view.findViewById(R.id.tvNameDisplay);
        tvPhoneNumber = (TextView) view.findViewById(R.id.tvPhoneNumber);
        lnlLogout = (LinearLayout) view.findViewById(R.id.lnlLogout);
        tvAmountExamDid = (TextView) view.findViewById(R.id.tvAmountExamDid);
        tvAmountExam = (TextView) view.findViewById(R.id.tvAmountExam);
        examList=new ArrayList<>();
        examDidList=new ArrayList<>();
        dataBaseExamDid=new DataBaseExamDid(getContext());
        examDidList=dataBaseExamDid.getAllexamDid();
    }
    public void setInforLogin(){
        SharedPreferences sharedPreferences= getActivity().getSharedPreferences(getActivity().getResources().getString(R.string.key_save_inforLogin), Context.MODE_PRIVATE);
        name=sharedPreferences.getString(getActivity().getResources().getString(R.string.name_display),getActivity().getResources().getString(R.string.updating));
        email=sharedPreferences.getString(getActivity().getResources().getString(R.string.email),getActivity().getResources().getString(R.string.updating));
        phone=sharedPreferences.getString(getActivity().getResources().getString(R.string.phone),getActivity().getResources().getString(R.string.updating));
        linkImage=sharedPreferences.getString(getActivity().getResources().getString(R.string.url_avatar),"https://firebasestorage.googleapis.com/v0/b/luyen-thi-toan-thptabc.appspot.com/o/updating.png?alt=media&token=aaa77d65-6069-465e-960f-c08a25b0274a");
    }
    public void setExam(){
        mData = FirebaseDatabase.getInstance().getReference();
        mData.child("Exam").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    examList.add(dataSnapshot.getValue(Exam.class)) ;

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
                setUIForAmountExam();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

    }
    public void setUIForAmountExam(){
        tvAmountExamDid.setText(examDidList.size()+"");
        tvAmountExam.setText(examList.size()+"");
    }
}