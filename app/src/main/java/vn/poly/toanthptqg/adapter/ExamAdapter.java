package vn.poly.toanthptqg.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.poly.toanthptqg.R;
import vn.poly.toanthptqg.activity.DoExemActivity;
import vn.poly.toanthptqg.adapter.holder.ExamHolder;
import vn.poly.toanthptqg.model.Exam;

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

    public ExamAdapter(Context context, List<Exam> examList) {
        this.context = context;
        this.examList = examList;
    }

    @NonNull
    @Override
    public ExamHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.row_exam,parent,false);
        ExamHolder examHolder=new ExamHolder(view);
        return examHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExamHolder holder, int position) {
        final Exam exam=examList.get(position);
        holder.tvNameExam.setText(exam.getNameExam());
        holder.tvNameSchool.setText(exam.getNameSchool());

        holder.tvYear.setText(exam.getYear());

        if(exam.getStatus()){
            holder.tvStatus.setText(R.string.done);
            holder.tvStatus.setTextColor(context.getResources().getColor(R.color.colorGreen));
        } else {
            holder.tvStatus.setText(R.string.no_done);
            holder.tvStatus.setTextColor(context.getResources().getColor(R.color.colorBolderAccount));
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder = new AlertDialog.Builder(context);
                View view1 = LayoutInflater.from(context).inflate(R.layout.dialog_exam, null);
                builder.setView(view1);
                alertDialog = builder.show();

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

                if(!exam.getStatus()){
                    tvScoreDialog.setVisibility(View.GONE);
                    lnlReDo.setVisibility(View.GONE);
                    lnlAmountCorrect.setVisibility(View.GONE);
                    lnlAmountIncorrect.setVisibility(View.GONE);
                    lnlAmountNotDo.setVisibility(View.GONE);
                } else {
                    tvDoExamDialog.setVisibility(View.GONE);
                }

                imgClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.dismiss();
                    }
                });

                tvDoExamDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(context, DoExemActivity.class);
                        context.startActivity(intent);
                    }
                });

                tvReDoExamDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(context, DoExemActivity.class);
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
}
