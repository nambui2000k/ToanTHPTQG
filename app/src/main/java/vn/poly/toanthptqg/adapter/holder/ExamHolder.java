package vn.poly.toanthptqg.adapter.holder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import vn.poly.toanthptqg.R;

public  class ExamHolder extends RecyclerView.ViewHolder {
    public TextView tvNameExam;
    public TextView tvNameSchool;
    public TextView tvYear;
    public TextView tvStatus;



    public ExamHolder(@NonNull View itemView) {
        super(itemView);
        tvNameExam = (TextView) itemView.findViewById(R.id.tvNameExam);
        tvNameSchool = (TextView) itemView.findViewById(R.id.tvNameSchool);
        tvYear = (TextView) itemView.findViewById(R.id.tvYear);
        tvStatus = (TextView) itemView.findViewById(R.id.tvStatus);
    }
}
