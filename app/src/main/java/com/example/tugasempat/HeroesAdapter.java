package com.example.tugasempat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HeroesAdapter extends RecyclerView.Adapter<HeroesAdapter.ListViewHolder> {

    private Context context;


    private ArrayList<Heroes> listHero;
    private OnItemClickCallback onItemClickCallback;

    public HeroesAdapter(ArrayList<Heroes> list) {
        this.listHero = list;
    }

    public HeroesAdapter(Context context, ArrayList<Heroes> listHero) {
        this.context = context;
        this.listHero = listHero;
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public ArrayList<Heroes> getListHero() {
        return listHero;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.heroes_item, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Glide.with(context).load(getListHero().get(position).getHeroImage()).into(holder.heroImage);
        holder.heroName.setText(getListHero().get(position).getHeroName());
        holder.heroDesc.setText(getListHero().get(position).getHeroDesc());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listHero.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listHero.size();
    }


    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView heroImage;
        TextView heroName, heroDesc;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            heroImage   = itemView.findViewById(R.id.adiv_hero_image);
            heroName    = itemView.findViewById(R.id.adtv_hero_name);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Heroes hero);
    }
}
