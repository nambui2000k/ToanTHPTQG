package vn.poly.toanthptqg.adapter.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import de.hdodenhof.circleimageview.CircleImageView;
import vn.poly.toanthptqg.R;

public class UniversityHolder extends RecyclerView.ViewHolder {
     public TextView tvNameUniversity,tvIdUniversity;
     public CircleImageView logoUniversity;
     public ImageView imgLocation;
     public ImageView imgScore;
    public LinearLayout lnlContent;
    public LinearLayout lnlButton;
    public LinearLayout lnlButtomRow;





    public UniversityHolder(@NonNull View itemView) {
        super(itemView);
        tvNameUniversity=itemView.findViewById(R.id.tvNameUniversity);
        tvIdUniversity=itemView.findViewById(R.id.tvIdUniversity);
        logoUniversity=itemView.findViewById(R.id.logoUniversity);
        imgLocation = (ImageView) itemView.findViewById(R.id.imgLocation);
        imgScore = (ImageView) itemView.findViewById(R.id.imgScore);
        lnlContent = (LinearLayout) itemView.findViewById(R.id.lnlContent);
        lnlButton = (LinearLayout) itemView.findViewById(R.id.lnlButton);
        lnlButtomRow = (LinearLayout) itemView.findViewById(R.id.lnlButtomRow);

    }
}
