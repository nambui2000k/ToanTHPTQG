package vn.poly.toanthptqg.ui.doexam.listquestiondid;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import vn.poly.toanthptqg.R;
import vn.poly.toanthptqg.ui.doexam.showquestiondid.ShowQuestionAndAnswerActivity;
import vn.poly.toanthptqg.base.BaseActivity;
import vn.poly.toanthptqg.data.database.DataBaseExamDid;
import vn.poly.toanthptqg.data.model.Exam;
import vn.poly.toanthptqg.data.model.ExamDid;

public class ListQuestionDidActivity extends BaseActivity implements ListQuestionDidContract.View{

    private ListQuestionDidContract.Presenter presenter;
    private Toolbar toolbarListQuestionDid;
    private FrameLayout fl1;
    private TextView tvQuestion1;
    private ImageView imgResult1;
    private FrameLayout fl2;
    private TextView tvQuestion2;
    private ImageView imgResult2;
    private FrameLayout fl3;
    private TextView tvQuestion3;
    private ImageView imgResult3;
    private FrameLayout fl4;
    private TextView tvQuestion4;
    private ImageView imgResult4;
    private FrameLayout fl5;
    private TextView tvQuestion5;
    private ImageView imgResult5;
    private FrameLayout fl6;
    private TextView tvQuestion6;
    private ImageView imgResult6;
    private FrameLayout fl7;
    private TextView tvQuestion7;
    private ImageView imgResult7;
    private FrameLayout fl8;
    private TextView tvQuestion8;
    private ImageView imgResult8;
    private FrameLayout fl9;
    private TextView tvQuestion9;
    private ImageView imgResult9;
    private FrameLayout fl10;
    private TextView tvQuestion10;
    private ImageView imgResult10;
    private FrameLayout fl11;
    private TextView tvQuestion11;
    private ImageView imgResult11;
    private FrameLayout fl12;
    private TextView tvQuestion12;
    private ImageView imgResult12;
    private FrameLayout fl13;
    private TextView tvQuestion13;
    private ImageView imgResult13;
    private FrameLayout fl14;
    private TextView tvQuestion14;
    private ImageView imgResult14;
    private FrameLayout fl15;
    private TextView tvQuestion15;
    private ImageView imgResult15;
    private FrameLayout fl16;
    private TextView tvQuestion16;
    private ImageView imgResult16;
    private FrameLayout fl17;
    private TextView tvQuestion17;
    private ImageView imgResult17;
    private FrameLayout fl18;
    private TextView tvQuestion18;
    private ImageView imgResult18;
    private FrameLayout fl19;
    private TextView tvQuestion19;
    private ImageView imgResult19;
    private FrameLayout fl20;
    private TextView tvQuestion20;
    private ImageView imgResult20;
    private FrameLayout fl21;
    private TextView tvQuestion21;
    private ImageView imgResult21;
    private FrameLayout fl22;
    private TextView tvQuestion22;
    private ImageView imgResult22;
    private FrameLayout fl23;
    private TextView tvQuestion23;
    private ImageView imgResult23;
    private FrameLayout fl24;
    private TextView tvQuestion24;
    private ImageView imgResult24;
    private FrameLayout fl25;
    private TextView tvQuestion25;
    private ImageView imgResult25;
    private FrameLayout fl26;
    private TextView tvQuestion26;
    private ImageView imgResult26;
    private FrameLayout fl27;
    private TextView tvQuestion27;
    private ImageView imgResult27;
    private FrameLayout fl28;
    private TextView tvQuestion28;
    private ImageView imgResult28;
    private FrameLayout fl29;
    private TextView tvQuestion29;
    private ImageView imgResult29;
    private FrameLayout fl30;
    private TextView tvQuestion30;
    private ImageView imgResult30;
    private FrameLayout fl31;
    private TextView tvQuestion31;
    private ImageView imgResult31;
    private FrameLayout fl32;
    private TextView tvQuestion32;
    private ImageView imgResult32;
    private FrameLayout fl33;
    private TextView tvQuestion33;
    private ImageView imgResult33;
    private FrameLayout fl34;
    private TextView tvQuestion34;
    private ImageView imgResult34;
    private FrameLayout fl35;
    private TextView tvQuestion35;
    private ImageView imgResult35;
    private FrameLayout fl36;
    private TextView tvQuestion36;
    private ImageView imgResult36;
    private FrameLayout fl37;
    private TextView tvQuestion37;
    private ImageView imgResult37;
    private FrameLayout fl38;
    private TextView tvQuestion38;
    private ImageView imgResult38;
    private FrameLayout fl39;
    private TextView tvQuestion39;
    private ImageView imgResult39;
    private FrameLayout fl40;
    private TextView tvQuestion40;
    private ImageView imgResult40;
    private FrameLayout fl41;
    private TextView tvQuestion41;
    private ImageView imgResult41;
    private FrameLayout fl42;
    private TextView tvQuestion42;
    private ImageView imgResult42;
    private FrameLayout fl43;
    private TextView tvQuestion43;
    private ImageView imgResult43;
    private FrameLayout fl44;
    private TextView tvQuestion44;
    private ImageView imgResult44;
    private FrameLayout fl45;
    private TextView tvQuestion45;
    private ImageView imgResult45;
    private FrameLayout fl46;
    private TextView tvQuestion46;
    private ImageView imgResult46;
    private FrameLayout fl47;
    private TextView tvQuestion47;
    private ImageView imgResult47;
    private FrameLayout fl48;
    private TextView tvQuestion48;
    private ImageView imgResult48;
    private FrameLayout fl49;
    private TextView tvQuestion49;
    private ImageView imgResult49;
    private FrameLayout fl50;
    private TextView tvQuestion50;
    private ImageView imgResult50;



    private String idExam ;
    private DataBaseExamDid dataBaseExamDid;
    private ExamDid examDid;
    private DatabaseReference mData;
    private Exam exam;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_question_did);
        init();
        examDid= dataBaseExamDid.getAllExamDidByIdExam(idExam).get(0);
        getExam();

        fl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataByBundle(ShowQuestionAndAnswerActivity.class,"position",1,"idExam",idExam);
            }
        });
        fl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataByBundle(ShowQuestionAndAnswerActivity.class,"position",2,"idExam",idExam);
            }
        });

        fl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataByBundle(ShowQuestionAndAnswerActivity.class,"position",3,"idExam",idExam);
            }
        });

        fl4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataByBundle(ShowQuestionAndAnswerActivity.class,"position",4,"idExam",idExam);
            }
        });

        fl5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataByBundle(ShowQuestionAndAnswerActivity.class,"position",5,"idExam",idExam);
            }
        });

        fl6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataByBundle(ShowQuestionAndAnswerActivity.class,"position",6,"idExam",idExam);
            }
        });

        fl7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataByBundle(ShowQuestionAndAnswerActivity.class,"position",7,"idExam",idExam);
            }
        });

        fl8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataByBundle(ShowQuestionAndAnswerActivity.class,"position",8,"idExam",idExam);
            }
        });

        fl9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataByBundle(ShowQuestionAndAnswerActivity.class,"position",9,"idExam",idExam);
            }
        });

        fl10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataByBundle(ShowQuestionAndAnswerActivity.class,"position",10,"idExam",idExam);
            }
        });

        fl11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataByBundle(ShowQuestionAndAnswerActivity.class,"position",11,"idExam",idExam);
            }
        });

        fl12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataByBundle(ShowQuestionAndAnswerActivity.class,"position",12,"idExam",idExam);
            }
        });

        fl13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataByBundle(ShowQuestionAndAnswerActivity.class,"position",13,"idExam",idExam);
            }
        });

        fl14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataByBundle(ShowQuestionAndAnswerActivity.class,"position",14,"idExam",idExam);
            }
        });

        fl15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataByBundle(ShowQuestionAndAnswerActivity.class,"position",15,"idExam",idExam);
            }
        });

        fl16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataByBundle(ShowQuestionAndAnswerActivity.class,"position",16,"idExam",idExam);
            }
        });

        fl17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataByBundle(ShowQuestionAndAnswerActivity.class,"position",17,"idExam",idExam);
            }
        });

        fl18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataByBundle(ShowQuestionAndAnswerActivity.class,"position",18,"idExam",idExam);
            }
        });

        fl19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataByBundle(ShowQuestionAndAnswerActivity.class,"position",19,"idExam",idExam);
            }
        });

        fl20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataByBundle(ShowQuestionAndAnswerActivity.class,"position",20,"idExam",idExam);
            }
        });

        fl21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataByBundle(ShowQuestionAndAnswerActivity.class,"position",21,"idExam",idExam);
            }
        });

        fl22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataByBundle(ShowQuestionAndAnswerActivity.class,"position",22,"idExam",idExam);
            }
        });

        fl23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataByBundle(ShowQuestionAndAnswerActivity.class,"position",23,"idExam",idExam);
            }
        });

        fl24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataByBundle(ShowQuestionAndAnswerActivity.class,"position",24,"idExam",idExam);
            }
        });

        fl25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataByBundle(ShowQuestionAndAnswerActivity.class,"position",25,"idExam",idExam);
            }
        });

        fl26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataByBundle(ShowQuestionAndAnswerActivity.class,"position",26,"idExam",idExam);
            }
        });

        fl27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataByBundle(ShowQuestionAndAnswerActivity.class,"position",27,"idExam",idExam);
            }
        });

        fl28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataByBundle(ShowQuestionAndAnswerActivity.class,"position",28,"idExam",idExam);
            }
        });

        fl29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataByBundle(ShowQuestionAndAnswerActivity.class,"position",29,"idExam",idExam);
            }
        });

        fl30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataByBundle(ShowQuestionAndAnswerActivity.class,"position",30,"idExam",idExam);
            }
        });

        fl31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataByBundle(ShowQuestionAndAnswerActivity.class,"position",31,"idExam",idExam);
            }
        });

        fl32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataByBundle(ShowQuestionAndAnswerActivity.class,"position",32,"idExam",idExam);
            }
        });

        fl33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataByBundle(ShowQuestionAndAnswerActivity.class,"position",33,"idExam",idExam);
            }
        });

        fl34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataByBundle(ShowQuestionAndAnswerActivity.class,"position",34,"idExam",idExam);
            }
        });

        fl35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataByBundle(ShowQuestionAndAnswerActivity.class,"position",35,"idExam",idExam);
            }
        });

        fl36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataByBundle(ShowQuestionAndAnswerActivity.class,"position",36,"idExam",idExam);
            }
        });

        fl37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataByBundle(ShowQuestionAndAnswerActivity.class,"position",37,"idExam",idExam);
            }
        });

        fl38.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataByBundle(ShowQuestionAndAnswerActivity.class,"position",38,"idExam",idExam);
            }
        });

        fl39.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataByBundle(ShowQuestionAndAnswerActivity.class,"position",39,"idExam",idExam);
            }
        });

        fl40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataByBundle(ShowQuestionAndAnswerActivity.class,"position",40,"idExam",idExam);
            }
        });

        fl41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataByBundle(ShowQuestionAndAnswerActivity.class,"position",41,"idExam",idExam);
            }
        });

        fl42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataByBundle(ShowQuestionAndAnswerActivity.class,"position",42,"idExam",idExam);
            }
        });

        fl43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataByBundle(ShowQuestionAndAnswerActivity.class,"position",43,"idExam",idExam);
            }
        });

        fl44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataByBundle(ShowQuestionAndAnswerActivity.class,"position",44,"idExam",idExam);
            }
        });

        fl45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataByBundle(ShowQuestionAndAnswerActivity.class,"position",45,"idExam",idExam);
            }
        });

        fl46.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataByBundle(ShowQuestionAndAnswerActivity.class,"position",46,"idExam",idExam);
            }
        });

        fl47.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataByBundle(ShowQuestionAndAnswerActivity.class,"position",47,"idExam",idExam);
            }
        });

        fl48.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataByBundle(ShowQuestionAndAnswerActivity.class,"position",48,"idExam",idExam);
            }
        });

        fl49.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataByBundle(ShowQuestionAndAnswerActivity.class,"position",49,"idExam",idExam);
            }
        });

        fl50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataByBundle(ShowQuestionAndAnswerActivity.class,"position",50,"idExam",idExam);
            }
        });



    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
    private void init(){
        presenter=new ListQuestionDidContractPresenter(this,this);
        toolbarListQuestionDid=findViewById(R.id.toolbarListQuestionDid);
        setSupportActionBar(toolbarListQuestionDid);
        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        actionBar.setTitle(R.string.title_list_question_did);
        fl1 = (FrameLayout) findViewById(R.id.fl1);
        tvQuestion1 = (TextView) findViewById(R.id.tvQuestion1);
        imgResult1 = (ImageView) findViewById(R.id.imgResult1);
        fl2 = (FrameLayout) findViewById(R.id.fl2);
        tvQuestion2 = (TextView) findViewById(R.id.tvQuestion2);
        imgResult2 = (ImageView) findViewById(R.id.imgResult2);
        fl3 = (FrameLayout) findViewById(R.id.fl3);
        tvQuestion3 = (TextView) findViewById(R.id.tvQuestion3);
        imgResult3 = (ImageView) findViewById(R.id.imgResult3);
        fl4 = (FrameLayout) findViewById(R.id.fl4);
        tvQuestion4 = (TextView) findViewById(R.id.tvQuestion4);
        imgResult4 = (ImageView) findViewById(R.id.imgResult4);
        fl5 = (FrameLayout) findViewById(R.id.fl5);
        tvQuestion5 = (TextView) findViewById(R.id.tvQuestion5);
        imgResult5 = (ImageView) findViewById(R.id.imgResult5);
        fl6 = (FrameLayout) findViewById(R.id.fl6);
        tvQuestion6 = (TextView) findViewById(R.id.tvQuestion6);
        imgResult6 = (ImageView) findViewById(R.id.imgResult6);
        fl7 = (FrameLayout) findViewById(R.id.fl7);
        tvQuestion7 = (TextView) findViewById(R.id.tvQuestion7);
        imgResult7 = (ImageView) findViewById(R.id.imgResult7);
        fl8 = (FrameLayout) findViewById(R.id.fl8);
        tvQuestion8 = (TextView) findViewById(R.id.tvQuestion8);
        imgResult8 = (ImageView) findViewById(R.id.imgResult8);
        fl9 = (FrameLayout) findViewById(R.id.fl9);
        tvQuestion9 = (TextView) findViewById(R.id.tvQuestion9);
        imgResult9 = (ImageView) findViewById(R.id.imgResult9);
        fl10 = (FrameLayout) findViewById(R.id.fl10);
        tvQuestion10 = (TextView) findViewById(R.id.tvQuestion10);
        imgResult10 = (ImageView) findViewById(R.id.imgResult10);
        fl11 = (FrameLayout) findViewById(R.id.fl11);
        tvQuestion11 = (TextView) findViewById(R.id.tvQuestion11);
        imgResult11 = (ImageView) findViewById(R.id.imgResult11);
        fl12 = (FrameLayout) findViewById(R.id.fl12);
        tvQuestion12 = (TextView) findViewById(R.id.tvQuestion12);
        imgResult12 = (ImageView) findViewById(R.id.imgResult12);
        fl13 = (FrameLayout) findViewById(R.id.fl13);
        tvQuestion13 = (TextView) findViewById(R.id.tvQuestion13);
        imgResult13 = (ImageView) findViewById(R.id.imgResult13);
        fl14 = (FrameLayout) findViewById(R.id.fl14);
        tvQuestion14 = (TextView) findViewById(R.id.tvQuestion14);
        imgResult14 = (ImageView) findViewById(R.id.imgResult14);
        fl15 = (FrameLayout) findViewById(R.id.fl15);
        tvQuestion15 = (TextView) findViewById(R.id.tvQuestion15);
        imgResult15 = (ImageView) findViewById(R.id.imgResult15);
        fl16 = (FrameLayout) findViewById(R.id.fl16);
        tvQuestion16 = (TextView) findViewById(R.id.tvQuestion16);
        imgResult16 = (ImageView) findViewById(R.id.imgResult16);
        fl17 = (FrameLayout) findViewById(R.id.fl17);
        tvQuestion17 = (TextView) findViewById(R.id.tvQuestion17);
        imgResult17 = (ImageView) findViewById(R.id.imgResult17);
        fl18 = (FrameLayout) findViewById(R.id.fl18);
        tvQuestion18 = (TextView) findViewById(R.id.tvQuestion18);
        imgResult18 = (ImageView) findViewById(R.id.imgResult18);
        fl19 = (FrameLayout) findViewById(R.id.fl19);
        tvQuestion19 = (TextView) findViewById(R.id.tvQuestion19);
        imgResult19 = (ImageView) findViewById(R.id.imgResult19);
        fl20 = (FrameLayout) findViewById(R.id.fl20);
        tvQuestion20 = (TextView) findViewById(R.id.tvQuestion20);
        imgResult20 = (ImageView) findViewById(R.id.imgResult20);
        fl21 = (FrameLayout) findViewById(R.id.fl21);
        tvQuestion21 = (TextView) findViewById(R.id.tvQuestion21);
        imgResult21 = (ImageView) findViewById(R.id.imgResult21);
        fl22 = (FrameLayout) findViewById(R.id.fl22);
        tvQuestion22 = (TextView) findViewById(R.id.tvQuestion22);
        imgResult22 = (ImageView) findViewById(R.id.imgResult22);
        fl23 = (FrameLayout) findViewById(R.id.fl23);
        tvQuestion23 = (TextView) findViewById(R.id.tvQuestion23);
        imgResult23 = (ImageView) findViewById(R.id.imgResult23);
        fl24 = (FrameLayout) findViewById(R.id.fl24);
        tvQuestion24 = (TextView) findViewById(R.id.tvQuestion24);
        imgResult24 = (ImageView) findViewById(R.id.imgResult24);
        fl25 = (FrameLayout) findViewById(R.id.fl25);
        tvQuestion25 = (TextView) findViewById(R.id.tvQuestion25);
        imgResult25 = (ImageView) findViewById(R.id.imgResult25);
        fl26 = (FrameLayout) findViewById(R.id.fl26);
        tvQuestion26 = (TextView) findViewById(R.id.tvQuestion26);
        imgResult26 = (ImageView) findViewById(R.id.imgResult26);
        fl27 = (FrameLayout) findViewById(R.id.fl27);
        tvQuestion27 = (TextView) findViewById(R.id.tvQuestion27);
        imgResult27 = (ImageView) findViewById(R.id.imgResult27);
        fl28 = (FrameLayout) findViewById(R.id.fl28);
        tvQuestion28 = (TextView) findViewById(R.id.tvQuestion28);
        imgResult28 = (ImageView) findViewById(R.id.imgResult28);
        fl29 = (FrameLayout) findViewById(R.id.fl29);
        tvQuestion29 = (TextView) findViewById(R.id.tvQuestion29);
        imgResult29 = (ImageView) findViewById(R.id.imgResult29);
        fl30 = (FrameLayout) findViewById(R.id.fl30);
        tvQuestion30 = (TextView) findViewById(R.id.tvQuestion30);
        imgResult30 = (ImageView) findViewById(R.id.imgResult30);
        fl31 = (FrameLayout) findViewById(R.id.fl31);
        tvQuestion31 = (TextView) findViewById(R.id.tvQuestion31);
        imgResult31 = (ImageView) findViewById(R.id.imgResult31);
        fl32 = (FrameLayout) findViewById(R.id.fl32);
        tvQuestion32 = (TextView) findViewById(R.id.tvQuestion32);
        imgResult32 = (ImageView) findViewById(R.id.imgResult32);
        fl33 = (FrameLayout) findViewById(R.id.fl33);
        tvQuestion33 = (TextView) findViewById(R.id.tvQuestion33);
        imgResult33 = (ImageView) findViewById(R.id.imgResult33);
        fl34 = (FrameLayout) findViewById(R.id.fl34);
        tvQuestion34 = (TextView) findViewById(R.id.tvQuestion34);
        imgResult34 = (ImageView) findViewById(R.id.imgResult34);
        fl35 = (FrameLayout) findViewById(R.id.fl35);
        tvQuestion35 = (TextView) findViewById(R.id.tvQuestion35);
        imgResult35 = (ImageView) findViewById(R.id.imgResult35);
        fl36 = (FrameLayout) findViewById(R.id.fl36);
        tvQuestion36 = (TextView) findViewById(R.id.tvQuestion36);
        imgResult36 = (ImageView) findViewById(R.id.imgResult36);
        fl37 = (FrameLayout) findViewById(R.id.fl37);
        tvQuestion37 = (TextView) findViewById(R.id.tvQuestion37);
        imgResult37 = (ImageView) findViewById(R.id.imgResult37);
        fl38 = (FrameLayout) findViewById(R.id.fl38);
        tvQuestion38 = (TextView) findViewById(R.id.tvQuestion38);
        imgResult38 = (ImageView) findViewById(R.id.imgResult38);
        fl39 = (FrameLayout) findViewById(R.id.fl39);
        tvQuestion39 = (TextView) findViewById(R.id.tvQuestion39);
        imgResult39 = (ImageView) findViewById(R.id.imgResult39);
        fl40 = (FrameLayout) findViewById(R.id.fl40);
        tvQuestion40 = (TextView) findViewById(R.id.tvQuestion40);
        imgResult40 = (ImageView) findViewById(R.id.imgResult40);
        fl41 = (FrameLayout) findViewById(R.id.fl41);
        tvQuestion41 = (TextView) findViewById(R.id.tvQuestion41);
        imgResult41 = (ImageView) findViewById(R.id.imgResult41);
        fl42 = (FrameLayout) findViewById(R.id.fl42);
        tvQuestion42 = (TextView) findViewById(R.id.tvQuestion42);
        imgResult42 = (ImageView) findViewById(R.id.imgResult42);
        fl43 = (FrameLayout) findViewById(R.id.fl43);
        tvQuestion43 = (TextView) findViewById(R.id.tvQuestion43);
        imgResult43 = (ImageView) findViewById(R.id.imgResult43);
        fl44 = (FrameLayout) findViewById(R.id.fl44);
        tvQuestion44 = (TextView) findViewById(R.id.tvQuestion44);
        imgResult44 = (ImageView) findViewById(R.id.imgResult44);
        fl45 = (FrameLayout) findViewById(R.id.fl45);
        tvQuestion45 = (TextView) findViewById(R.id.tvQuestion45);
        imgResult45 = (ImageView) findViewById(R.id.imgResult45);
        fl46 = (FrameLayout) findViewById(R.id.fl46);
        tvQuestion46 = (TextView) findViewById(R.id.tvQuestion46);
        imgResult46 = (ImageView) findViewById(R.id.imgResult46);
        fl47 = (FrameLayout) findViewById(R.id.fl47);
        tvQuestion47 = (TextView) findViewById(R.id.tvQuestion47);
        imgResult47 = (ImageView) findViewById(R.id.imgResult47);
        fl48 = (FrameLayout) findViewById(R.id.fl48);
        tvQuestion48 = (TextView) findViewById(R.id.tvQuestion48);
        imgResult48 = (ImageView) findViewById(R.id.imgResult48);
        fl49 = (FrameLayout) findViewById(R.id.fl49);
        tvQuestion49 = (TextView) findViewById(R.id.tvQuestion49);
        imgResult49 = (ImageView) findViewById(R.id.imgResult49);
        fl50 = (FrameLayout) findViewById(R.id.fl50);
        tvQuestion50 = (TextView) findViewById(R.id.tvQuestion50);
        imgResult50 = (ImageView) findViewById(R.id.imgResult50);
        dataBaseExamDid =new DataBaseExamDid(ListQuestionDidActivity.this);
        idExam=getIntent().getStringExtra("idExam");

    }
    public void getExam(){
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
                handling();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

    }
    public void handlingTheme(TextView tvQuestion,String AnswerExemDid,String AnswerExam,ImageView imgResult ){
        tvQuestion.setText(AnswerExemDid);
        if(AnswerExemDid.equals("")){
            imgResult.setImageResource(R.drawable.ic_question);
        } else if (AnswerExemDid.equals(AnswerExam)){
            imgResult.setImageResource(R.drawable.ic_true);
        } else {
            imgResult.setImageResource(R.drawable.ic_false);
        }
    }
    public void handling() {

        handlingTheme(tvQuestion1,examDid.getAs1(),exam.getAs1(),imgResult1);
        handlingTheme(tvQuestion2,examDid.getAs2(),exam.getAs2(),imgResult2);
        handlingTheme(tvQuestion3,examDid.getAs3(),exam.getAs3(),imgResult3);
        handlingTheme(tvQuestion4,examDid.getAs4(),exam.getAs4(),imgResult4);
        handlingTheme(tvQuestion5,examDid.getAs5(),exam.getAs5(),imgResult5);
        handlingTheme(tvQuestion6,examDid.getAs6(),exam.getAs6(),imgResult6);
        handlingTheme(tvQuestion7,examDid.getAs7(),exam.getAs7(),imgResult7);
        handlingTheme(tvQuestion8,examDid.getAs8(),exam.getAs8(),imgResult8);
        handlingTheme(tvQuestion9,examDid.getAs9(),exam.getAs9(),imgResult9);
        handlingTheme(tvQuestion10,examDid.getAs10(),exam.getAs10(),imgResult10);
        handlingTheme(tvQuestion11,examDid.getAs11(),exam.getAs11(),imgResult11);
        handlingTheme(tvQuestion12,examDid.getAs12(),exam.getAs12(),imgResult12);
        handlingTheme(tvQuestion13,examDid.getAs13(),exam.getAs13(),imgResult13);
        handlingTheme(tvQuestion14,examDid.getAs14(),exam.getAs14(),imgResult14);
        handlingTheme(tvQuestion15,examDid.getAs15(),exam.getAs15(),imgResult15);
        handlingTheme(tvQuestion16,examDid.getAs16(),exam.getAs16(),imgResult16);
        handlingTheme(tvQuestion17,examDid.getAs17(),exam.getAs17(),imgResult17);
        handlingTheme(tvQuestion18,examDid.getAs18(),exam.getAs18(),imgResult18);
        handlingTheme(tvQuestion19,examDid.getAs19(),exam.getAs19(),imgResult19);
        handlingTheme(tvQuestion20,examDid.getAs20(),exam.getAs20(),imgResult20);
        handlingTheme(tvQuestion21,examDid.getAs21(),exam.getAs21(),imgResult21);
        handlingTheme(tvQuestion22,examDid.getAs22(),exam.getAs22(),imgResult22);
        handlingTheme(tvQuestion23,examDid.getAs23(),exam.getAs23(),imgResult23);
        handlingTheme(tvQuestion24,examDid.getAs24(),exam.getAs24(),imgResult24);
        handlingTheme(tvQuestion25,examDid.getAs25(),exam.getAs25(),imgResult25);
        handlingTheme(tvQuestion26,examDid.getAs26(),exam.getAs26(),imgResult26);
        handlingTheme(tvQuestion27,examDid.getAs27(),exam.getAs27(),imgResult27);
        handlingTheme(tvQuestion28,examDid.getAs28(),exam.getAs28(),imgResult28);
        handlingTheme(tvQuestion29,examDid.getAs29(),exam.getAs29(),imgResult29);
        handlingTheme(tvQuestion30,examDid.getAs30(),exam.getAs30(),imgResult30);
        handlingTheme(tvQuestion31,examDid.getAs31(),exam.getAs31(),imgResult31);
        handlingTheme(tvQuestion32,examDid.getAs32(),exam.getAs32(),imgResult32);
        handlingTheme(tvQuestion33,examDid.getAs33(),exam.getAs33(),imgResult33);
        handlingTheme(tvQuestion34,examDid.getAs34(),exam.getAs34(),imgResult34);
        handlingTheme(tvQuestion35,examDid.getAs35(),exam.getAs35(),imgResult35);
        handlingTheme(tvQuestion36,examDid.getAs36(),exam.getAs36(),imgResult36);
        handlingTheme(tvQuestion37,examDid.getAs37(),exam.getAs37(),imgResult37);
        handlingTheme(tvQuestion38,examDid.getAs38(),exam.getAs38(),imgResult38);
        handlingTheme(tvQuestion39,examDid.getAs39(),exam.getAs39(),imgResult39);
        handlingTheme(tvQuestion40,examDid.getAs40(),exam.getAs40(),imgResult40);
        handlingTheme(tvQuestion41,examDid.getAs41(),exam.getAs41(),imgResult41);
        handlingTheme(tvQuestion42,examDid.getAs42(),exam.getAs42(),imgResult42);
        handlingTheme(tvQuestion43,examDid.getAs43(),exam.getAs43(),imgResult43);
        handlingTheme(tvQuestion44,examDid.getAs44(),exam.getAs44(),imgResult44);
        handlingTheme(tvQuestion45,examDid.getAs45(),exam.getAs45(),imgResult45);
        handlingTheme(tvQuestion46,examDid.getAs46(),exam.getAs46(),imgResult46);
        handlingTheme(tvQuestion47,examDid.getAs47(),exam.getAs47(),imgResult47);
        handlingTheme(tvQuestion48,examDid.getAs48(),exam.getAs48(),imgResult48);
        handlingTheme(tvQuestion49,examDid.getAs49(),exam.getAs49(),imgResult49);
        handlingTheme(tvQuestion50,examDid.getAs50(),exam.getAs50(),imgResult50);



    }
}
