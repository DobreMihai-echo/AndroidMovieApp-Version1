package com.example.myandroidapplication.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myandroidapplication.R;
import com.example.myandroidapplication.model.Cast;
import com.example.myandroidapplication.model.Movie;

import java.util.List;

public class CastAdapter extends RecyclerView.Adapter<CastAdapter.ViewHolder> {
    private List<Cast> castList;
    private Context context;

    public CastAdapter(List<Cast> castList,Context context) {
        this.castList = castList;
        this.context = context;
    }


    @NonNull
    @Override
    public CastAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View castView = inflater.inflate(R.layout.cast_display_layout,parent,false);
        ViewHolder viewHolder = new ViewHolder(castView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CastAdapter.ViewHolder holder, int position) {
        Cast cast = castList.get(position);
        holder.setItems(cast);

    }

    @Override
    public int getItemCount() {
        return castList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        public ImageView cImageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cImageView = itemView.findViewById(R.id.cast_image);
        }

        public void setItems(Cast cast) {
            cImageView.setImageResource(cast.getfImage());
        }


    }
}
