package vn.poly.toanthptqg.ui.doexam.activity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

import java.util.List;

import vn.poly.toanthptqg.R;
import vn.poly.toanthptqg.ui.doexam.result.ResultActivity;
import vn.poly.toanthptqg.base.BaseActivity;
import vn.poly.toanthptqg.data.database.DataBaseExamDid;
import vn.poly.toanthptqg.data.model.Exam;
import vn.poly.toanthptqg.data.model.ExamDid;
import vn.poly.toanthptqg.ui.home.HomeActivity;

public class DoExamActivity extends BaseActivity implements DoExamContract.View {
    private DoExamContract.Presenter presenter;
    private TextView tvTime;
    private TextView tvFinish;
    private ImageView imgQuestion;
    private RadioButton rdbA;
    private RadioButton rdbB;
    private RadioButton rdbC;
    private RadioButton rdbD;
    private ImageView imgPrev;
    private TextView tvPositionSentence;
    private ImageView imgNext;
    private String idExam;
    private RadioGroup rgAnser;
    private int position = 1;
    private DatabaseReference mData;
    private Exam exam;
    private static final long START_TIME_IN_MILLIS = 5400000;
    private CountDownTimer countDownTimer;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;
    private String[] listAnswer;
    private DataBaseExamDid dataBaseExamDid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_exem);
        init();
        setValueDefaulAnswer();
        setCountDownTime();
        getDataFromFirebase();


        rgAnser.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                confirmChange(position);
            }
        });
        imgNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                confirmChange(position);
                position++;
                load();
            }
        });
        imgPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                confirmChange(position);
                position--;
                load();

            }
        });

        tvFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                openActivy(ResultActivity.class);
                finish();
            }
        });

    }

    public void load() {

        switch (position) {
            case 1:
                imgPrev.setVisibility(View.INVISIBLE);
                loadImageAndRadioButton(0, exam.getQs1());
                break;
            case 2:
                imgPrev.setVisibility(View.VISIBLE);
                loadImageAndRadioButton(1, exam.getQs2());
                break;
            case 3:
                loadImageAndRadioButton(2, exam.getQs3());
                break;
            case 4:
                loadImageAndRadioButton(3, exam.getQs4());
                break;
            case 5:
                loadImageAndRadioButton(4, exam.getQs5());
                break;
            case 6:
                loadImageAndRadioButton(5, exam.getQs6());
                break;
            case 7:
                loadImageAndRadioButton(6, exam.getQs7());
                break;
            case 8:
                loadImageAndRadioButton(7, exam.getQs8());
                break;
            case 9:
                loadImageAndRadioButton(8, exam.getQs9());
                break;
            case 10:
                loadImageAndRadioButton(9, exam.getQs10());
                break;
            case 11:
                loadImageAndRadioButton(10, exam.getQs11());
                break;
            case 12:
                loadImageAndRadioButton(11, exam.getQs12());
                break;
            case 13:
                loadImageAndRadioButton(12, exam.getQs13());
                break;
            case 14:
                loadImageAndRadioButton(13, exam.getQs14());
                break;
            case 15:
                loadImageAndRadioButton(14, exam.getQs15());
                break;
            case 16:
                loadImageAndRadioButton(15, exam.getQs16());
                break;
            case 17:
                loadImageAndRadioButton(16, exam.getQs17());
                break;
            case 18:
                loadImageAndRadioButton(17, exam.getQs18());
                break;
            case 19:
                loadImageAndRadioButton(18, exam.getQs19());
                break;
            case 20:
                loadImageAndRadioButton(19, exam.getQs20());
                break;
            case 21:
                loadImageAndRadioButton(20, exam.getQs21());
                break;
            case 22:
                loadImageAndRadioButton(21, exam.getQs22());
                break;
            case 23:
                loadImageAndRadioButton(22, exam.getQs23());
                break;
            case 24:
                loadImageAndRadioButton(23, exam.getQs24());
                break;
            case 25:
                loadImageAndRadioButton(24, exam.getQs25());
                break;
            case 26:
                loadImageAndRadioButton(25, exam.getQs26());
                break;
            case 27:
                loadImageAndRadioButton(26, exam.getQs27());
                break;
            case 28:
                loadImageAndRadioButton(27, exam.getQs28());
                break;
            case 29:
                loadImageAndRadioButton(28, exam.getQs29());
                break;
            case 30:
                loadImageAndRadioButton(29, exam.getQs30());
                break;
            case 31:
                loadImageAndRadioButton(30, exam.getQs31());
                break;
            case 32:
                loadImageAndRadioButton(31, exam.getQs32());
                break;
            case 33:
                loadImageAndRadioButton(32, exam.getQs33());
                break;
            case 34:
                loadImageAndRadioButton(33, exam.getQs34());
                break;
            case 35:
                loadImageAndRadioButton(34, exam.getQs35());
                break;
            case 36:
                loadImageAndRadioButton(35, exam.getQs36());
                break;
            case 37:
                loadImageAndRadioButton(36, exam.getQs37());
                break;
            case 38:
                loadImageAndRadioButton(37, exam.getQs38());
                break;
            case 39:
                loadImageAndRadioButton(38, exam.getQs39());
                break;
            case 40:
                loadImageAndRadioButton(39, exam.getQs40());
                break;
            case 41:
                loadImageAndRadioButton(40, exam.getQs41());
                break;
            case 42:
                loadImageAndRadioButton(41, exam.getQs42());
                break;
            case 43:
                loadImageAndRadioButton(42, exam.getQs43());
                break;
            case 44:
                loadImageAndRadioButton(43, exam.getQs44());
                break;
            case 45:
                loadImageAndRadioButton(44, exam.getQs45());
                break;
            case 46:
                loadImageAndRadioButton(45, exam.getQs46());
                break;
            case 47:
                loadImageAndRadioButton(46, exam.getQs47());
                break;
            case 48:
                loadImageAndRadioButton(47, exam.getQs48());
                break;
            case 49:
                imgNext.setVisibility(View.VISIBLE);
                loadImageAndRadioButton(48, exam.getQs49());
                break;
            case 50:
                imgNext.setVisibility(View.INVISIBLE);
                loadImageAndRadioButton(49, exam.getQs50());
                break;

        }
    }

    public String checkChoice(int idRadioButton) {
        String anser;
        switch (idRadioButton) {
            case R.id.rdbA:
                anser = "A";
                break;
            case R.id.rdbB:
                anser = "B";
                break;
            case R.id.rdbC:
                anser = "C";
                break;
            case R.id.rdbD:
                anser = "D";
                break;

            default:
                anser = "";
                break;
        }
        return anser;
    }

    public void checkChoiced(String choice) {
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

    public void confirmChange(int positionConfirmChange) {
        for (int i = 1; i <= 50; i++) {
            if (positionConfirmChange == i) {
                listAnswer[i - 1] = checkChoice(rgAnser.getCheckedRadioButtonId());
            }
        }
    }

    public void loadImageAndRadioButton(int positionListAnswer, String linkQs) {
        checkChoiced(listAnswer[positionListAnswer]);
        tvPositionSentence.setText(this.getResources().getText(R.string.sentence) + " " + String.valueOf(position));
        Picasso.with(DoExamActivity.this).load(linkQs).resize(1100, 0)
                .into(imgQuestion);


    }

    public void finish() {
        List<ExamDid> examDidList = dataBaseExamDid.getAllExamDidByIdExam(idExam);
        if (examDidList.size() > 0) {
            dataBaseExamDid.updateExamDid(new ExamDid(idExam,
                    listAnswer[0], listAnswer[1], listAnswer[2], listAnswer[3], listAnswer[4], listAnswer[5], listAnswer[6], listAnswer[7], listAnswer[8], listAnswer[9], listAnswer[10],
                    listAnswer[11], listAnswer[12], listAnswer[13], listAnswer[14], listAnswer[15], listAnswer[16], listAnswer[17], listAnswer[18], listAnswer[19], listAnswer[20],
                    listAnswer[21], listAnswer[22], listAnswer[23], listAnswer[24], listAnswer[25], listAnswer[26], listAnswer[27], listAnswer[28], listAnswer[29], listAnswer[30],
                    listAnswer[31], listAnswer[32], listAnswer[33], listAnswer[34], listAnswer[35], listAnswer[36], listAnswer[37], listAnswer[38], listAnswer[39], listAnswer[40],
                    listAnswer[41], listAnswer[42], listAnswer[43], listAnswer[44], listAnswer[45], listAnswer[46], listAnswer[47], listAnswer[48], listAnswer[49]));
        } else {

            dataBaseExamDid.insertExamDid(new ExamDid(idExam,
                    listAnswer[0], listAnswer[1], listAnswer[2], listAnswer[3], listAnswer[4], listAnswer[5], listAnswer[6], listAnswer[7], listAnswer[8], listAnswer[9], listAnswer[10],
                    listAnswer[11], listAnswer[12], listAnswer[13], listAnswer[14], listAnswer[15], listAnswer[16], listAnswer[17], listAnswer[18], listAnswer[19], listAnswer[20],
                    listAnswer[21], listAnswer[22], listAnswer[23], listAnswer[24], listAnswer[25], listAnswer[26], listAnswer[27], listAnswer[28], listAnswer[29], listAnswer[30],
                    listAnswer[31], listAnswer[32], listAnswer[33], listAnswer[34], listAnswer[35], listAnswer[36], listAnswer[37], listAnswer[38], listAnswer[39], listAnswer[40],
                    listAnswer[41], listAnswer[42], listAnswer[43], listAnswer[44], listAnswer[45], listAnswer[46], listAnswer[47], listAnswer[48], listAnswer[49]));
        }

        openActivitySendData(ResultActivity.class, "idExam", idExam);


    }

    private void upDateCountDownText() {
        int mintes = (int) (mTimeLeftInMillis / 1000) / 60;
        int second = (int) (mTimeLeftInMillis / 1000) % 60;
        String timeLeftFormatted = String.format("%02d:%02d", mintes, second);
        tvTime.setText(timeLeftFormatted);
    }

    private void init() {
        presenter = new DoExamPresenter(this, this);
        tvTime = (TextView) findViewById(R.id.tvTime);
        tvFinish = (TextView) findViewById(R.id.tvFinish);
        imgQuestion = (ImageView) findViewById(R.id.imgQuestion);
        rdbA = (RadioButton) findViewById(R.id.rdbA);
        rdbB = (RadioButton) findViewById(R.id.rdbB);
        rdbC = (RadioButton) findViewById(R.id.rdbC);
        rdbD = (RadioButton) findViewById(R.id.rdbD);
        imgPrev = (ImageView) findViewById(R.id.imgPrev);
        rgAnser = findViewById(R.id.rgAnser);
        tvPositionSentence = (TextView) findViewById(R.id.tvPositionSentence);
        imgNext = (ImageView) findViewById(R.id.imgNext);
        idExam = getIntent().getStringExtra("idExam");
        dataBaseExamDid = new DataBaseExamDid(DoExamActivity.this);
        listAnswer = new String[50];
    }

    public void setValueDefaulAnswer() {
        for (int i = 0; i < listAnswer.length; i++) {
            listAnswer[i] = "";
        }
    }

    public void setCountDownTime() {
        countDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long l) {
                mTimeLeftInMillis = l;
                upDateCountDownText();
            }

            @Override
            public void onFinish() {
                finish();
            }
        }.start();
    }

    public void getDataFromFirebase() {
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        countDownTimer.cancel();
        openActivitySendData(HomeActivity.class, "positionSelectNav", 1);
    }
}
