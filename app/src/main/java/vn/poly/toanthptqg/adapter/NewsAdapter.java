package vn.poly.toanthptqg.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import vn.poly.toanthptqg.R;
import vn.poly.toanthptqg.activity.ReadNewsActivity;
import vn.poly.toanthptqg.adapter.holder.NewsHolder;
import vn.poly.toanthptqg.model.News;

public class NewsAdapter extends RecyclerView.Adapter<NewsHolder> {
    private Context context;
    private List<News> newsList;

    public NewsAdapter(Context context, List<News> newsList) {
        this.context = context;
        this.newsList = newsList;
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.row_news,parent,false);
        NewsHolder newsHolder=new NewsHolder(view);
        return newsHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder holder, int position) {
        final News news=newsList.get(position);
        String description=news.getDescription().substring(news.getDescription().indexOf("</br>")+5,news.getDescription().length());
        Date date = new Date(news.getTime());
        DateFormat df = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        String dateString = df.format(date);
        holder.tvTimeNews.setText(dateString);


        Picasso.with(context).load(news.getImage()).into(holder.imgNews);
        holder.tvTitleNews.setText(news.getTitle());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, ReadNewsActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("link",news.getLink());
                bundle.putString("title",news.getTitle());
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        int stDescription=0;
        if(news.getDescription().contains("></a></br>")){
            stDescription=news.getDescription().indexOf("></a></br>")+10;
        }
        holder.tvDescriptionNews.setText(news.getDescription().substring(stDescription,news.getDescription().length()));

        int stImage=0;

        if(news.getDescription().contains("data-original")){
            stImage=news.getDescription().indexOf("data-original")+15;
        } else {
            stImage=news.getDescription().indexOf("src")+5;
        }

        int edImage=0;

        if(news.getDescription().contains(".png")){
            edImage=news.getDescription().indexOf(".png")+4;
            String linkImage=news.getDescription().substring(stImage,edImage);
            Picasso.with(context).load(linkImage).into(holder.imgNews);
        } else if (news.getDescription().contains(".jpg")) {
            edImage= news.getDescription().indexOf(".jpg")+4;
            String linkImage=news.getDescription().substring(stImage,edImage);
            Picasso.with(context).load(linkImage).into(holder.imgNews);
        }else if (news.getDescription().contains(".jpeg")) {

            edImage= news.getDescription().indexOf(".jpeg")+5;
            String linkImage=news.getDescription().substring(stImage,edImage);
            Picasso.with(context).load(linkImage).into(holder.imgNews);
        } else{
            Picasso.with(context).load(" https://firebasestorage.googleapis.com/v0/b/luyen-thi-toan-thptabc.appspot.com/o/updating.png?alt=media&token=aaa77d65-6069-465e-960f-c08a25b0274a").into(holder.imgNews);


        }

    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }
}
