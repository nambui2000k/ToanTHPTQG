package vn.poly.toanthptqg.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import vn.poly.toanthptqg.R;

public class DoExemActivity extends BaseActivity {
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_exem);
        tvTime = (TextView) findViewById(R.id.tvTime);
        tvFinish = (TextView) findViewById(R.id.tvFinish);
        imgQuestion = (ImageView) findViewById(R.id.imgQuestion);
        rdbA = (RadioButton) findViewById(R.id.rdbA);
        rdbB = (RadioButton) findViewById(R.id.rdbB);
        rdbC = (RadioButton) findViewById(R.id.rdbC);
        rdbD = (RadioButton) findViewById(R.id.rdbD);
        imgPrev = (ImageView) findViewById(R.id.imgPrev);
        tvPositionSentence = (TextView) findViewById(R.id.tvPositionSentence);
        imgNext = (ImageView) findViewById(R.id.imgNext);

        tvFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivy(ResultActivity.class);
            }
        });
        imgNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgQuestion.setImageResource(R.drawable.de0001_cau2);
            }
        });

        imgPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgQuestion.setImageResource(R.drawable.de0001_cau1);
            }
        });

    }
}
