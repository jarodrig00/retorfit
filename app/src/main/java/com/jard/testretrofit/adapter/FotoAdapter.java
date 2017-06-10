package com.jard.testretrofit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jard.testretrofit.R;
import com.jard.testretrofit.pojo.Foto;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by jarodrig on 01/06/2017.
 */

public class FotoAdapter extends RecyclerView.Adapter<FotoAdapter.FotoViewHolder> {

    ArrayList<Foto> fotos;
    Context context;

    public void swap(ArrayList<Foto> fotos){
        if (this.fotos != null){  
            this.fotos.clear();
            if (fotos != null)
                this.fotos.addAll(fotos);
        }else{
            this.fotos = fotos;
        }
        notifyDataSetChanged();
    }
    public FotoAdapter(ArrayList<Foto> fotos){
        swap(fotos);
    }

    @Override
    public FotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.imagenes_activity, parent, false);
        context = v.getContext();
        return new FotoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FotoViewHolder holder, int position) {

        final Foto myFoto = fotos.get(position);
        holder.tvName.setText(myFoto.getNombre());
        holder.tvCount.setText(Integer.toString(myFoto.getCount()));
        Picasso.with(context)
                .load(myFoto.getUrlFoto())
                .placeholder(R.drawable.doberman)
                .into(holder.imPhoto);
    }

    @Override
    public int getItemCount() {
        if(fotos == null)
            return 0;
        else
            return fotos.size();

    }

    public class FotoViewHolder extends RecyclerView.ViewHolder{

        TextView tvName, tvCount;
        ImageView imPhoto;

        public FotoViewHolder(View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvCount = (TextView) itemView.findViewById(R.id.tvCount);
            imPhoto = (ImageView) itemView.findViewById(R.id.ivPhoto);
        }
    }
}


