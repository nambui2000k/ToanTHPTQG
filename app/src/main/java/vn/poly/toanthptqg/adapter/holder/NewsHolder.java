package vn.poly.toanthptqg.adapter.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import vn.poly.toanthptqg.R;

public class NewsHolder extends RecyclerView.ViewHolder {
    public ImageView imgNews;
    public TextView tvTimeNews;
    public TextView tvTitleNews;
    public TextView tvDescriptionNews;



    public NewsHolder(@NonNull View itemView) {
        super(itemView);
        imgNews = (ImageView) itemView.findViewById(R.id.imgNews);
        tvTimeNews = (TextView) itemView.findViewById(R.id.tvTimeNews);
        tvTitleNews = (TextView) itemView.findViewById(R.id.tvTitleNews);
        tvDescriptionNews = (TextView) itemView.findViewById(R.id.tvDescriptionNews);
    }
}
