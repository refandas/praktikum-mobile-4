package com.example.tugasempat;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HeroesFragment extends Fragment {

    RecyclerView recyclerView;
    private ArrayList<Heroes> listHero = new ArrayList<>();

    public HeroesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_heroes, container, false);

        recyclerView = view.findViewById(R.id.recycle_hero);
        recyclerView.setHasFixedSize(true);
        listHero.addAll(HeroesData.getHeroList());
        recyclerView();
        return view;
    }

    public void recyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        HeroesAdapter heroesAdapter = new HeroesAdapter(getContext(), listHero);
        recyclerView.setAdapter(heroesAdapter);

        heroesAdapter.setOnItemClickCallback(new HeroesAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Heroes hero) {
                Intent intent = new Intent(getContext(), DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_DATA, hero);
                startActivity(intent);
            }
        });
    }

}
