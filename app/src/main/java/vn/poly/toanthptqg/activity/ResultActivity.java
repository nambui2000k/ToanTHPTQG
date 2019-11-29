package vn.poly.toanthptqg.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareDialog;
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Arrays;
import java.util.List;

import vn.poly.toanthptqg.R;
import vn.poly.toanthptqg.model.Exam;
import vn.poly.toanthptqg.model.ExamDid;

public class ResultActivity extends BaseActivity {
    private TextView tvNameExamResult;
    private TextView tvNameSchoolResult;
    private TextView tvYearResult;
    private TextView tvTimeResult;
    private TextView tvAmountResult;
    private TextView tvAmountCorrectResult;
    private TextView tvAmountIncorrectResult;
    private TextView tvAmountNotDoResult;
    private TextView tvScoreResult;
    private TextView tvReDoExamResult;
    private ImageView imgShareResult;
    private ImageView imgCloseResult;
    private String idExam;
    private DataBaseExamDid dataBaseExamDid;
    private ExamDid examDid;
    private DatabaseReference mData;
    private Exam exam;
    private int correct=0,inCorrect=0,doNot=0;
    private static final int MY_REQUEST_CODE = 567;
    private List<AuthUI.IdpConfig> configList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        init();
        getDataFromFirebase();


        tvScoreResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivitySendData(ListQuestionDidActivity.class,"idExam",idExam);
            }
        });
        imgCloseResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivitySendData(HomeActivity.class,"positionSelectNav",1);
            }
        });

        tvReDoExamResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivitySendData(DoExamActivity.class,"idExam",idExam);
            }
        });
        imgShareResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                share();
            }
        });
    }
    private void init(){
        tvNameExamResult = (TextView) findViewById(R.id.tvNameExamResult);
        tvNameSchoolResult = (TextView) findViewById(R.id.tvNameSchoolResult);
        tvYearResult = (TextView) findViewById(R.id.tvYearResult);
        tvTimeResult = (TextView) findViewById(R.id.tvTimeResult);
        tvAmountResult = (TextView) findViewById(R.id.tvAmountResult);
        tvAmountCorrectResult = (TextView) findViewById(R.id.tvAmountCorrectResult);
        tvAmountIncorrectResult = (TextView) findViewById(R.id.tvAmountIncorrectResult);
        tvAmountNotDoResult = (TextView) findViewById(R.id.tvAmountNotDoResult);
        tvScoreResult = (TextView) findViewById(R.id.tvScoreResult);
        tvReDoExamResult = (TextView) findViewById(R.id.tvReDoExamResult);
        imgShareResult = (ImageView) findViewById(R.id.imgShareResult);
        imgCloseResult = (ImageView) findViewById(R.id.imgCloseResult);
        idExam=getIntent().getStringExtra("idExam");
        dataBaseExamDid=new DataBaseExamDid(ResultActivity.this);
        examDid=dataBaseExamDid.getAllExamDidByIdExam(idExam).get(0);
    }
    private void setText(){
        tvNameExamResult.setText(exam.getNameExam());
        tvNameSchoolResult.setText(exam.getNameSchool());
        tvYearResult.setText(exam.getYear());
        checkResult();
        tvAmountCorrectResult.setText(String.valueOf(correct)+" "+this.getResources().getString(R.string.sentence));
        tvAmountIncorrectResult.setText(String.valueOf(inCorrect)+" "+this.getResources().getString(R.string.sentence));
        tvAmountNotDoResult.setText(String.valueOf(doNot)+" "+this.getResources().getString(R.string.sentence));
        tvScoreResult.setText((double) Math.round((correct*0.2) * 100) / 100+" "+this.getResources().getString(R.string.score));

    }
    private void getDataFromFirebase(){
        mData = FirebaseDatabase.getInstance().getReference();
        mData.child("Exam").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                if (dataSnapshot.getValue(Exam.class).getIdExam().equals(idExam)) {
                    exam = dataSnapshot.getValue(Exam.class);

                }

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
                setText();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    private void countSentence(String examDidAnswer,String examAnswer){
        if(examDidAnswer.equals("")){
            doNot++;
        } else if (examDidAnswer.equals(examAnswer)){
            correct++;
        } else {
            inCorrect++;
        }
    }

    private void checkResult() {
        countSentence(examDid.getAs1(),exam.getAs1());
        countSentence(examDid.getAs2(),exam.getAs2());
        countSentence(examDid.getAs3(),exam.getAs3());
        countSentence(examDid.getAs4(),exam.getAs4());
        countSentence(examDid.getAs5(),exam.getAs5());
        countSentence(examDid.getAs6(),exam.getAs6());
        countSentence(examDid.getAs7(),exam.getAs7());
        countSentence(examDid.getAs8(),exam.getAs8());
        countSentence(examDid.getAs9(),exam.getAs9());
        countSentence(examDid.getAs10(),exam.getAs10());
        countSentence(examDid.getAs11(),exam.getAs11());
        countSentence(examDid.getAs12(),exam.getAs12());
        countSentence(examDid.getAs13(),exam.getAs13());
        countSentence(examDid.getAs14(),exam.getAs14());
        countSentence(examDid.getAs15(),exam.getAs15());
        countSentence(examDid.getAs16(),exam.getAs16());
        countSentence(examDid.getAs17(),exam.getAs17());
        countSentence(examDid.getAs18(),exam.getAs18());
        countSentence(examDid.getAs19(),exam.getAs19());
        countSentence(examDid.getAs20(),exam.getAs20());
        countSentence(examDid.getAs21(),exam.getAs21());
        countSentence(examDid.getAs22(),exam.getAs22());
        countSentence(examDid.getAs23(),exam.getAs23());
        countSentence(examDid.getAs24(),exam.getAs24());
        countSentence(examDid.getAs25(),exam.getAs25());
        countSentence(examDid.getAs26(),exam.getAs26());
        countSentence(examDid.getAs27(),exam.getAs27());
        countSentence(examDid.getAs28(),exam.getAs28());
        countSentence(examDid.getAs29(),exam.getAs29());
        countSentence(examDid.getAs30(),exam.getAs30());
        countSentence(examDid.getAs31(),exam.getAs31());
        countSentence(examDid.getAs32(),exam.getAs32());
        countSentence(examDid.getAs33(),exam.getAs33());
        countSentence(examDid.getAs34(),exam.getAs34());
        countSentence(examDid.getAs35(),exam.getAs35());
        countSentence(examDid.getAs36(),exam.getAs36());
        countSentence(examDid.getAs37(),exam.getAs37());
        countSentence(examDid.getAs38(),exam.getAs38());
        countSentence(examDid.getAs39(),exam.getAs39());
        countSentence(examDid.getAs40(),exam.getAs40());
        countSentence(examDid.getAs41(),exam.getAs41());
        countSentence(examDid.getAs42(),exam.getAs42());
        countSentence(examDid.getAs43(),exam.getAs43());
        countSentence(examDid.getAs44(),exam.getAs44());
        countSentence(examDid.getAs45(),exam.getAs45());
        countSentence(examDid.getAs46(),exam.getAs46());
        countSentence(examDid.getAs47(),exam.getAs47());
        countSentence(examDid.getAs48(),exam.getAs48());
        countSentence(examDid.getAs49(),exam.getAs49());
        countSentence(examDid.getAs50(),exam.getAs50());
    }
    public void share() {

        SharedPreferences sharedPreferences= this.getSharedPreferences("com.facebook.loginManager", Context.MODE_PRIVATE);
        if(sharedPreferences.getBoolean("express_login_allowed",false)){
            getImageShowShareDialog();
        } else {
            configList = Arrays.asList(
                    new AuthUI.IdpConfig.FacebookBuilder().build()
            );
            startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders(configList).setTheme(R.style.NoActionbar).build(), MY_REQUEST_CODE);

        }


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                getImageShowShareDialog();
            }
        }
    }
    private void getImageShowShareDialog(){
        Bitmap bitmap=takescreenshotOfRootView(imgShareResult);
        SharePhoto photo=new SharePhoto.Builder().setBitmap(bitmap).build();
        SharePhotoContent content=new SharePhotoContent.Builder().addPhoto(photo).build();
        ShareDialog shareDialog=new ShareDialog(this);
        shareDialog.show(content,ShareDialog.Mode.AUTOMATIC);
    }
    private Bitmap takescreenshot(View v){
        v.setDrawingCacheEnabled(true);
        v.buildDrawingCache(true);
        Bitmap b=Bitmap.createBitmap(v.getDrawingCache());
        v.setDrawingCacheEnabled(false);
        return b;
    }

    private Bitmap takescreenshotOfRootView(View v){
        return takescreenshot(v.getRootView());
    }
}
