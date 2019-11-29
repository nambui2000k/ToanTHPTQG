package vn.poly.toanthptqg.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import vn.poly.toanthptqg.R;
import vn.poly.toanthptqg.model.Exam;
import vn.poly.toanthptqg.model.ExamDid;

public class ShowQuestionAndAnswerActivity extends AppCompatActivity {
    private TextView tvAnswer;
    private TextView tvExit;
    private ImageView imgQuestion;
    private RadioGroup rgAnser;
    private RadioButton rdbA;
    private RadioButton rdbB;
    private RadioButton rdbC;
    private RadioButton rdbD;
    private TextView tvPositionSentence;

    private String idExam;
    private DataBaseExamDid dataBaseExamDid;
    private ExamDid examDid;
    private DatabaseReference mData;
    private Exam exam;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_question_and_answer);
        init();
        getExam();

        tvExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


    }

    private void init() {
        Bundle bundle = getIntent().getExtras();
        position = bundle.getInt("position", 1);
        idExam = bundle.getString("idExam");
        dataBaseExamDid = new DataBaseExamDid(ShowQuestionAndAnswerActivity.this);
        examDid = dataBaseExamDid.getAllExamDidByIdExam(idExam).get(0);
        tvAnswer = (TextView) findViewById(R.id.tvAnswer);
        tvExit = (TextView) findViewById(R.id.tvExit);
        imgQuestion = (ImageView) findViewById(R.id.imgQuestion);
        rgAnser = (RadioGroup) findViewById(R.id.rgAnser);
        rdbA = (RadioButton) findViewById(R.id.rdbA);
        rdbB = (RadioButton) findViewById(R.id.rdbB);
        rdbC = (RadioButton) findViewById(R.id.rdbC);
        rdbD = (RadioButton) findViewById(R.id.rdbD);
        tvPositionSentence = (TextView) findViewById(R.id.tvPositionSentence);
        rgAnser.getChildAt(0).setEnabled(false);
        rgAnser.getChildAt(1).setEnabled(false);
        rgAnser.getChildAt(2).setEnabled(false);
        rgAnser.getChildAt(3).setEnabled(false);

    }

    private void getExam() {
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
                load();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

    }

    private void checkChoiced(String choice) {
        rgAnser.clearCheck();
        if (choice.equals("A")) {
            rdbA.setChecked(true);

        } else if (choice.equals("B")) {

            rdbB.setChecked(true);

        } else if (choice.equals("C")) {

            rdbC.setChecked(true);

        } else if (choice.equals("D")) {

            rdbD.setChecked(true);
        } else {
            rdbA.setChecked(false);
            rdbB.setChecked(false);
            rdbC.setChecked(false);
            rdbD.setChecked(false);
        }
    }

    private void load() {
        switch (position) {
            case 1:
                loadImageAndRadioButton(exam.getAs1(), exam.getQs1(), examDid.getAs1());

                break;
            case 2:

                loadImageAndRadioButton(exam.getAs2(), exam.getQs2(), examDid.getAs2());
                break;
            case 3:
                loadImageAndRadioButton(exam.getAs3(), exam.getQs3(), examDid.getAs3());
                break;
            case 4:
                loadImageAndRadioButton(exam.getAs4(), exam.getQs4(), examDid.getAs4());
                break;
            case 5:
                loadImageAndRadioButton(exam.getAs5(), exam.getQs5(), examDid.getAs5());
                break;
            case 6:
                loadImageAndRadioButton(exam.getAs6(), exam.getQs6(), examDid.getAs6());
                break;
            case 7:
                loadImageAndRadioButton(exam.getAs7(), exam.getQs7(), examDid.getAs7());
                break;
            case 8:
                loadImageAndRadioButton(exam.getAs8(), exam.getQs8(), examDid.getAs8());
                break;
            case 9:
                loadImageAndRadioButton(exam.getAs9(), exam.getQs9(), examDid.getAs9());
                break;
            case 10:
                loadImageAndRadioButton(exam.getAs10(), exam.getQs10(), examDid.getAs10());
                break;
            case 11:
                loadImageAndRadioButton(exam.getAs11(), exam.getQs11(), examDid.getAs11());
                break;
            case 12:
                loadImageAndRadioButton(exam.getAs12(), exam.getQs12(), examDid.getAs12());
                break;
            case 103:
                loadImageAndRadioButton(exam.getAs13(), exam.getQs13(), examDid.getAs13());
                break;
            case 14:
                loadImageAndRadioButton(exam.getAs14(), exam.getQs14(), examDid.getAs14());
                break;
            case 15:
                loadImageAndRadioButton(exam.getAs15(), exam.getQs15(), examDid.getAs15());
                break;
            case 16:
                loadImageAndRadioButton(exam.getAs16(), exam.getQs16(), examDid.getAs16());
                break;
            case 17:
                loadImageAndRadioButton(exam.getAs17(), exam.getQs17(), examDid.getAs17());
                break;
            case 18:
                loadImageAndRadioButton(exam.getAs18(), exam.getQs18(), examDid.getAs18());
                break;
            case 19:
                loadImageAndRadioButton(exam.getAs19(), exam.getQs19(), examDid.getAs19());
                break;
            case 20:
                loadImageAndRadioButton(exam.getAs20(), exam.getQs20(), examDid.getAs20());
                break;
            case 21:
                loadImageAndRadioButton(exam.getAs21(), exam.getQs21(), examDid.getAs21());
                break;
            case 22:
                loadImageAndRadioButton(exam.getAs22(), exam.getQs22(), examDid.getAs22());
                break;
            case 23:
                loadImageAndRadioButton(exam.getAs23(), exam.getQs23(), examDid.getAs23());
                break;
            case 24:
                loadImageAndRadioButton(exam.getAs24(), exam.getQs24(), examDid.getAs24());
                break;
            case 25:
                loadImageAndRadioButton(exam.getAs25(), exam.getQs25(), examDid.getAs25());
                break;
            case 26:
                loadImageAndRadioButton(exam.getAs26(), exam.getQs26(), examDid.getAs26());
                break;
            case 27:
                loadImageAndRadioButton(exam.getAs27(), exam.getQs27(), examDid.getAs27());
                break;
            case 28:
                loadImageAndRadioButton(exam.getAs28(), exam.getQs28(), examDid.getAs28());
                break;
            case 29:
                loadImageAndRadioButton(exam.getAs29(), exam.getQs29(), examDid.getAs29());
                break;
            case 30:
                loadImageAndRadioButton(exam.getAs30(), exam.getQs30(), examDid.getAs30());
                break;
            case 31:
                loadImageAndRadioButton(exam.getAs31(), exam.getQs31(), examDid.getAs31());
                break;
            case 32:
                loadImageAndRadioButton(exam.getAs32(), exam.getQs32(), examDid.getAs32());
                break;
            case 33:
                loadImageAndRadioButton(exam.getAs33(), exam.getQs33(), examDid.getAs33());
                break;
            case 34:
                loadImageAndRadioButton(exam.getAs34(), exam.getQs34(), examDid.getAs34());
                break;
            case 35:
                loadImageAndRadioButton(exam.getAs35(), exam.getQs35(), examDid.getAs35());
                break;
            case 36:
                loadImageAndRadioButton(exam.getAs36(), exam.getQs36(), examDid.getAs36());
                break;
            case 37:
                loadImageAndRadioButton(exam.getAs37(), exam.getQs37(), examDid.getAs37());
                break;
            case 38:
                loadImageAndRadioButton(exam.getAs38(), exam.getQs38(), examDid.getAs38());
                break;
            case 39:
                loadImageAndRadioButton(exam.getAs39(), exam.getQs39(), examDid.getAs39());
                break;
            case 40:
                loadImageAndRadioButton(exam.getAs40(), exam.getQs40(), examDid.getAs40());
                break;
            case 41:
                loadImageAndRadioButton(exam.getAs41(), exam.getQs41(), examDid.getAs41());
                break;
            case 42:
                loadImageAndRadioButton(exam.getAs42(), exam.getQs42(), examDid.getAs42());
                break;
            case 43:
                loadImageAndRadioButton(exam.getAs43(), exam.getQs43(), examDid.getAs43());
                break;
            case 44:
                loadImageAndRadioButton(exam.getAs44(), exam.getQs44(), examDid.getAs44());
                break;
            case 45:
                loadImageAndRadioButton(exam.getAs5(), exam.getQs5(), examDid.getAs5());
                break;
            case 46:
                loadImageAndRadioButton(exam.getAs46(), exam.getQs46(), examDid.getAs46());
                break;
            case 47:
                loadImageAndRadioButton(exam.getAs47(), exam.getQs47(), examDid.getAs47());
                break;
            case 48:
                loadImageAndRadioButton(exam.getAs48(), exam.getQs48(), examDid.getAs48());
                break;
            case 49:

                loadImageAndRadioButton(exam.getAs49(), exam.getQs49(), examDid.getAs49());
                break;
            case 50:

                loadImageAndRadioButton(exam.getAs50(), exam.getQs50(), examDid.getAs50());
                break;

        }
    }

    private void loadImageAndRadioButton(String examAnswer, String linkQs, String asExamDid) {
        tvAnswer.setText(this.getResources().getText(R.string.answer_is) + examAnswer);
        Picasso.with(ShowQuestionAndAnswerActivity.this).load(linkQs).resize(1100, 0)
                .into(imgQuestion);
        tvPositionSentence.setText(this.getResources().getText(R.string.sentence) + " " + String.valueOf(position));
        checkChoiced(asExamDid);
    }
}
