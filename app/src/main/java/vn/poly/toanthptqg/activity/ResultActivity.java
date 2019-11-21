package vn.poly.toanthptqg.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import vn.poly.toanthptqg.R;

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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
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

        imgCloseResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivitySendData(HomeActivity.class,"positionSelectNav",1);
            }
        });
    }
}
