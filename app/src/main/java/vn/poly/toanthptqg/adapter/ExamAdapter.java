package vn.poly.toanthptqg.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import vn.poly.toanthptqg.activity.DataBaseExamDid;
import vn.poly.toanthptqg.activity.DoExamActivity;
import vn.poly.toanthptqg.activity.ListQuestionDidActivity;
import vn.poly.toanthptqg.adapter.holder.ExamHolder;
import vn.poly.toanthptqg.model.Exam;
import vn.poly.toanthptqg.model.ExamDid;

public class ExamAdapter extends RecyclerView.Adapter<ExamHolder> {
    private Context context;
    private List<Exam> examList;
    private AlertDialog.Builder builder;
    private AlertDialog alertDialog;
    private TextView tvNameExamDialog;
    private TextView tvNameSchoolDialog;
    private TextView tvYearDialog;
    private TextView tvTimeDialog;
    private TextView tvAmountDialog;
    private LinearLayout lnlAmountCorrect;
    private TextView tvAmountCorrectDialog;
    private LinearLayout lnlAmountIncorrect;
    private TextView tvAmountIncorrectDialog;
    private LinearLayout lnlAmountNotDo;
    private TextView tvAmountNotDoDialog;
    private TextView tvScoreDialog;
    private TextView tvDoExamDialog;
    private LinearLayout lnlReDo;
    private TextView tvReDoExamDialog;
    private ImageView imgShare;
    private ImageView imgClose;
    private DataBaseExamDid dataBaseExamDid;
    private List<ExamDid> examDidList;
    private ExamDid examDid;
    private int correct=0,inCorrect=0,doNot=0;
    private Exam examFromFireBase;
    private DatabaseReference mData;


    public ExamAdapter(Context context, List<Exam> examList) {
        this.context = context;
        this.examList = examList;
    }

    @NonNull
    @Override
    public ExamHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_exam, parent, false);
        ExamHolder examHolder = new ExamHolder(view);
        return examHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExamHolder holder, int position) {

        final Exam exam = examList.get(position);
        holder.tvNameExam.setText(exam.getNameExam());
        holder.tvNameSchool.setText(exam.getNameSchool());
        dataBaseExamDid = new DataBaseExamDid(context);
        examDidList = new ArrayList<>();
        examDidList = dataBaseExamDid.getAllexamDid();

        if (checkHaveExamDid(exam.getIdExam()) > 0) {
            holder.tvStatus.setText(R.string.done);
            holder.tvStatus.setTextColor(context.getResources().getColor(R.color.colorGreen));
        } else {
            holder.tvStatus.setText(R.string.no_done);
            holder.tvStatus.setTextColor(context.getResources().getColor(R.color.colorBolderAccount));
        }


        holder.tvYear.setText(exam.getYear());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                builder = new AlertDialog.Builder(context);
                View view1 = LayoutInflater.from(context).inflate(R.layout.dialog_exam, null);
                builder.setView(view1);
                alertDialog = builder.show();
                initDialog();
                if(dataBaseExamDid.getAllExamDidByIdExam(exam.getIdExam()).size()>0){
                    examDid=dataBaseExamDid.getAllExamDidByIdExam(exam.getIdExam()).get(0);
                    getDataFromFirebase();
                }


                tvNameExamDialog.setText(exam.getNameExam());
                tvNameSchoolDialog.setText(exam.getNameSchool());
                tvYearDialog.setText(exam.getYear());

                if (checkHaveExamDid(exam.getIdExam())==0) {
                    tvScoreDialog.setVisibility(View.GONE);
                    lnlReDo.setVisibility(View.GONE);
                    lnlAmountCorrect.setVisibility(View.GONE);
                    lnlAmountIncorrect.setVisibility(View.GONE);
                    lnlAmountNotDo.setVisibility(View.GONE);

                } else {
                    imgShare.setVisibility(View.GONE);
                    tvDoExamDialog.setVisibility(View.GONE);
                }



                tvScoreDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(context, ListQuestionDidActivity.class);
                        intent.putExtra("idExam",exam.getIdExam());
                        context.startActivity(intent);
                    }
                });
                imgClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.dismiss();
                    }
                });

                tvDoExamDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, DoExamActivity.class);
                        intent.putExtra("idExam",exam.getIdExam());
                        context.startActivity(intent);

                    }
                });

                tvReDoExamDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, DoExamActivity.class);
                        intent.putExtra("idExam",exam.getIdExam());
                        context.startActivity(intent);
                    }
                });


                builder.create();
            }
        });

    }

    @Override
    public int getItemCount() {
        return examList.size();
    }
    private void initDialog(){
        correct=0;
        inCorrect=0;
        doNot=0;
        tvNameExamDialog = (TextView) alertDialog.findViewById(R.id.tvNameExamDialog);
        tvNameSchoolDialog = (TextView) alertDialog.findViewById(R.id.tvNameSchoolDialog);
        tvYearDialog = (TextView) alertDialog.findViewById(R.id.tvYearDialog);
        tvTimeDialog = (TextView) alertDialog.findViewById(R.id.tvTimeDialog);
        tvAmountDialog = (TextView) alertDialog.findViewById(R.id.tvAmountDialog);
        lnlAmountCorrect = (LinearLayout) alertDialog.findViewById(R.id.lnlAmountCorrect);
        tvAmountCorrectDialog = (TextView) alertDialog.findViewById(R.id.tvAmountCorrectDialog);
        lnlAmountIncorrect = (LinearLayout) alertDialog.findViewById(R.id.lnlAmountIncorrect);
        tvAmountIncorrectDialog = (TextView) alertDialog.findViewById(R.id.tvAmountIncorrectDialog);
        lnlAmountNotDo = (LinearLayout) alertDialog.findViewById(R.id.lnlAmountNotDo);
        tvAmountNotDoDialog = (TextView) alertDialog.findViewById(R.id.tvAmountNotDoDialog);
        tvScoreDialog = (TextView) alertDialog.findViewById(R.id.tvScoreDialog);
        tvDoExamDialog = (TextView) alertDialog.findViewById(R.id.tvDoExamDialog);
        lnlReDo = (LinearLayout) alertDialog.findViewById(R.id.lnlReDo);
        tvReDoExamDialog = (TextView) alertDialog.findViewById(R.id.tvReDoExamDialog);
        imgShare = (ImageView) alertDialog.findViewById(R.id.imgShare);
        imgClose = (ImageView) alertDialog.findViewById(R.id.imgClose);

    }
    private int checkHaveExamDid(String idExam){
        int checkHaveExamDid= 0;
        for (int i = 0; i < examDidList.size(); i++) {
            if (idExam.equals(examDidList.get(i).getIdExam())) {
                checkHaveExamDid++;
            }
        }
        return checkHaveExamDid;
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
        countSentence(examDid.getAs1(),examFromFireBase.getAs1());
        countSentence(examDid.getAs2(),examFromFireBase.getAs2());
        countSentence(examDid.getAs3(),examFromFireBase.getAs3());
        countSentence(examDid.getAs4(),examFromFireBase.getAs4());
        countSentence(examDid.getAs5(),examFromFireBase.getAs5());
        countSentence(examDid.getAs6(),examFromFireBase.getAs6());
        countSentence(examDid.getAs7(),examFromFireBase.getAs7());
        countSentence(examDid.getAs8(),examFromFireBase.getAs8());
        countSentence(examDid.getAs9(),examFromFireBase.getAs9());
        countSentence(examDid.getAs10(),examFromFireBase.getAs10());
        countSentence(examDid.getAs11(),examFromFireBase.getAs11());
        countSentence(examDid.getAs12(),examFromFireBase.getAs12());
        countSentence(examDid.getAs13(),examFromFireBase.getAs13());
        countSentence(examDid.getAs14(),examFromFireBase.getAs14());
        countSentence(examDid.getAs15(),examFromFireBase.getAs15());
        countSentence(examDid.getAs16(),examFromFireBase.getAs16());
        countSentence(examDid.getAs17(),examFromFireBase.getAs17());
        countSentence(examDid.getAs18(),examFromFireBase.getAs18());
        countSentence(examDid.getAs19(),examFromFireBase.getAs19());
        countSentence(examDid.getAs20(),examFromFireBase.getAs20());
        countSentence(examDid.getAs21(),examFromFireBase.getAs21());
        countSentence(examDid.getAs22(),examFromFireBase.getAs22());
        countSentence(examDid.getAs23(),examFromFireBase.getAs23());
        countSentence(examDid.getAs24(),examFromFireBase.getAs24());
        countSentence(examDid.getAs25(),examFromFireBase.getAs25());
        countSentence(examDid.getAs26(),examFromFireBase.getAs26());
        countSentence(examDid.getAs27(),examFromFireBase.getAs27());
        countSentence(examDid.getAs28(),examFromFireBase.getAs28());
        countSentence(examDid.getAs29(),examFromFireBase.getAs29());
        countSentence(examDid.getAs30(),examFromFireBase.getAs30());
        countSentence(examDid.getAs31(),examFromFireBase.getAs31());
        countSentence(examDid.getAs32(),examFromFireBase.getAs32());
        countSentence(examDid.getAs33(),examFromFireBase.getAs33());
        countSentence(examDid.getAs34(),examFromFireBase.getAs34());
        countSentence(examDid.getAs35(),examFromFireBase.getAs35());
        countSentence(examDid.getAs36(),examFromFireBase.getAs36());
        countSentence(examDid.getAs37(),examFromFireBase.getAs37());
        countSentence(examDid.getAs38(),examFromFireBase.getAs38());
        countSentence(examDid.getAs39(),examFromFireBase.getAs39());
        countSentence(examDid.getAs40(),examFromFireBase.getAs40());
        countSentence(examDid.getAs41(),examFromFireBase.getAs41());
        countSentence(examDid.getAs42(),examFromFireBase.getAs42());
        countSentence(examDid.getAs43(),examFromFireBase.getAs43());
        countSentence(examDid.getAs44(),examFromFireBase.getAs44());
        countSentence(examDid.getAs45(),examFromFireBase.getAs45());
        countSentence(examDid.getAs46(),examFromFireBase.getAs46());
        countSentence(examDid.getAs47(),examFromFireBase.getAs47());
        countSentence(examDid.getAs48(),examFromFireBase.getAs48());
        countSentence(examDid.getAs49(),examFromFireBase.getAs49());
        countSentence(examDid.getAs50(),examFromFireBase.getAs50());
    }

    private void getDataFromFirebase(){
        mData = FirebaseDatabase.getInstance().getReference();
        mData.child("Exam").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Log.e("examDid.getIdExam()",examDid.getIdExam());
                if (dataSnapshot.getValue(Exam.class).getIdExam().equals(examDid.getIdExam())) {
                    examFromFireBase = dataSnapshot.getValue(Exam.class);

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
                checkResult();
                tvAmountCorrectDialog.setText(String.valueOf(correct)+" "+context.getResources().getString(R.string.sentence));
                tvAmountIncorrectDialog.setText(String.valueOf(inCorrect)+" "+context.getResources().getString(R.string.sentence));
                tvAmountNotDoDialog.setText(String.valueOf(doNot)+" "+context.getResources().getString(R.string.sentence));
                tvScoreDialog.setText((double) Math.round((correct*0.2) * 100) / 100+" "+context.getResources().getString(R.string.score));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }


}
