package com.marfin.movietmdbapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.marfin.movietmdbapp.R;
import com.marfin.movietmdbapp.activity.DetailTvActivity;
import com.marfin.movietmdbapp.adapter.TvAdapter;
import com.marfin.movietmdbapp.model.ModelTv;
import com.marfin.movietmdbapp.realm.RealmHelper;

import java.util.ArrayList;
import java.util.List;

public class FragmentFavoriteTv extends Fragment implements TvAdapter.onSelectData {

    private RecyclerView rvMovieFav;
    private List<ModelTv> modelTV = new ArrayList<>();
    private RealmHelper helper;
    private TextView txtNoData;

    public FragmentFavoriteTv() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_favorite_film, container, false);

        helper = new RealmHelper(getActivity());

        txtNoData = rootView.findViewById(R.id.tvNotFound);
        rvMovieFav = rootView.findViewById(R.id.rvMovieFav);
        rvMovieFav.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvMovieFav.setAdapter(new TvAdapter(getActivity(), modelTV, this));
        rvMovieFav.setHasFixedSize(true);

        setData();
        return rootView;
    }

    private void setData() {
        modelTV = helper.showFavoriteTV();
        if (modelTV.size() == 0) {
            txtNoData.setVisibility(View.VISIBLE);
            rvMovieFav.setVisibility(View.GONE);
        } else {
            txtNoData.setVisibility(View.GONE);
            rvMovieFav.setVisibility(View.VISIBLE);
            rvMovieFav.setAdapter(new TvAdapter(getActivity(), modelTV, this));
        }
    }

    @Override
    public void onSelected(ModelTv modelTv) {
        Intent intent = new Intent(getActivity(), DetailTvActivity.class);
        intent.putExtra("detailTV", modelTv);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        setData();
    }

}
