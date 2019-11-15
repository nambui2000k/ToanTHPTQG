package vn.poly.toanthptqg.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import vn.poly.toanthptqg.R;
import vn.poly.toanthptqg.adapter.holder.UniversityHolder;
import vn.poly.toanthptqg.model.University;

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
        University university=universityList.get(position);
        holder.tvIdUniversity.setText(university.getIdUniversity());
        holder.tvNameUniversity.setText(university.getNameUniversity());
        Picasso.with(context).load(university.getLinkLogo()).into(holder.logoUniversity);

        holder.imgLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"Địa điểm",Toast.LENGTH_LONG).show();
            }
        });
        holder.imgScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"Điểm chuẩn",Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return universityList.size();
    }
}
