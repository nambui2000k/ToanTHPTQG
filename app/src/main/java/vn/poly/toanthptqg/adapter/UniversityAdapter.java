package vn.poly.toanthptqg.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import vn.poly.toanthptqg.R;
import vn.poly.toanthptqg.ui.school.location.MapsActivity;
import vn.poly.toanthptqg.ui.school.truescore.TrueScoreActivity;
import vn.poly.toanthptqg.adapter.holder.UniversityHolder;
import vn.poly.toanthptqg.data.model.University;

public class UniversityAdapter extends RecyclerView.Adapter<UniversityHolder> {
    private Context context;
    private List<University>  universityList;

    public UniversityAdapter(Context context, List<University> universityList) {
        this.context = context;
        this.universityList = universityList;
    }

    @NonNull
    @Override
    public UniversityHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.row_list_university,parent,false);
        UniversityHolder universityHolder=new UniversityHolder(view);

        return universityHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull UniversityHolder holder, int position) {
        final University university=universityList.get(position);
//        holder.itemView.setAnimation(AnimationUtils.loadAnimation(context,R.anim.anim_recycler_view));
        holder.logoUniversity.setAnimation(AnimationUtils.loadAnimation(context,R.anim.anim_image_recyclerview));
        holder.lnlButtomRow.setAnimation(AnimationUtils.loadAnimation(context,R.anim.anim_container_recyclerview));
        holder.lnlButton.setAnimation(AnimationUtils.loadAnimation(context,R.anim.anim_container_recyclerview));
        holder.lnlContent.setAnimation(AnimationUtils.loadAnimation(context,R.anim.anim_container_recyclerview));
        holder.tvIdUniversity.setText(university.getIdUniversity());
        holder.tvNameUniversity.setText(university.getNameUniversity());
        holder.tvIdUniversity.setText(university.getIdUniversity());

        if(university.getLinkLogo().equals("0")){
            Log.e("0","0");
            Picasso.with(context).load("https://firebasestorage.googleapis.com/v0/b/luyen-thi-toan-thptabc.appspot.com/o/updating.png?alt=media&token=aaa77d65-6069-465e-960f-c08a25b0274a").into(holder.logoUniversity);
        } else {
            Picasso.with(context).load(university.getLinkLogo()).into(holder.logoUniversity);
        }

        holder.imgLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MapsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putFloat("latitude", university.getLatitude());
                bundle.putFloat("longitude", university.getLongitude());
                bundle.putString("nameUniversity", university.getNameUniversity());
                intent.putExtras(bundle);
                 context.startActivity(intent);
                ((Activity)context).overridePendingTransition(R.anim.anim_enter_list_school_activity,R.anim.anim_exit_list_school_activity);


            }
        });
        holder.imgScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, TrueScoreActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("linkScore", university.getLinkScore());
                bundle.putString("nameUniversity", university.getNameUniversity());
                intent.putExtras(bundle);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return universityList.size();
    }
}
