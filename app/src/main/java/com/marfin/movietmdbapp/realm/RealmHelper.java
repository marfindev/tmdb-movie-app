package com.marfin.movietmdbapp.realm;

import android.content.Context;
import com.marfin.movietmdbapp.model.ModelMovie;
import com.marfin.movietmdbapp.model.ModelTv;
import io.realm.Realm;
import io.realm.RealmResults;

import java.util.ArrayList;

public class RealmHelper {

    private Context mContext;
    private Realm realm;
    private RealmResults<ModelMovie> modelMovie;
    private RealmResults<ModelTv> modelTv;

    public RealmHelper(Context mContext) {
        this.mContext = mContext;
        Realm.init(mContext);
        realm = Realm.getDefaultInstance();
    }

    public ArrayList<ModelMovie> showFavoriteMovie() {
        ArrayList<ModelMovie> data = new ArrayList<>();
        modelMovie = realm.where(ModelMovie.class).findAll();

        if (modelMovie.size() > 0) {
            for (int i = 0; i < modelMovie.size(); i++) {
                ModelMovie movie = new ModelMovie();
                movie.setId(modelMovie.get(i).getId());
                movie.setTitle(modelMovie.get(i).getTitle());
                movie.setVoteAverage(modelMovie.get(i).getVoteAverage());
                movie.setOverview(modelMovie.get(i).getOverview());
                movie.setReleaseDate(modelMovie.get(i).getReleaseDate());
                movie.setPosterPath(modelMovie.get(i).getPosterPath());
                movie.setBackdropPath(modelMovie.get(i).getBackdropPath());
                movie.setPopularity(modelMovie.get(i).getPopularity());
                data.add(movie);
            }
        }
        return data;
    }

    public ArrayList<ModelTv> showFavoriteTV() {
        ArrayList<ModelTv> data = new ArrayList<>();
        modelTv = realm.where(ModelTv.class).findAll();

        if (modelTv.size() > 0) {
            for (int i = 0; i < modelTv.size(); i++) {
                ModelTv tv = new ModelTv();
                tv.setId(modelTv.get(i).getId());
                tv.setName(modelTv.get(i).getName());
                tv.setVoteAverage(modelTv.get(i).getVoteAverage());
                tv.setOverview(modelTv.get(i).getOverview());
                tv.setReleaseDate(modelTv.get(i).getReleaseDate());
                tv.setPosterPath(modelTv.get(i).getPosterPath());
                tv.setBackdropPath(modelTv.get(i).getBackdropPath());
                tv.setPopularity(modelTv.get(i).getPopularity());
                data.add(tv);
            }
        }
        return data;
    }

    public void addFavoriteMovie(int Id, String Title, double VoteAverage, String Overview,
                                 String ReleaseDate, String PosterPath, String BackdropPath, String Popularity) {
        ModelMovie movie = new ModelMovie();
        movie.setId(Id);
        movie.setTitle(Title);
        movie.setVoteAverage(VoteAverage);
        movie.setOverview(Overview);
        movie.setReleaseDate(ReleaseDate);
        movie.setPosterPath(PosterPath);
        movie.setBackdropPath(BackdropPath);
        movie.setPopularity(Popularity);

        realm.beginTransaction();
        realm.copyToRealm(movie);
        realm.commitTransaction();

        //Toast.makeText(mContext, "Data berhasil ditambah", Toast.LENGTH_SHORT).show();
    }

    public void addFavoriteTV(int Id, String Title, double VoteAverage, String Overview,
                              String ReleaseDate, String PosterPath, String BackdropPath, String Popularity) {
        ModelTv tv = new ModelTv();
        tv.setId(Id);
        tv.setName(Title);
        tv.setVoteAverage(VoteAverage);
        tv.setOverview(Overview);
        tv.setReleaseDate(ReleaseDate);
        tv.setPosterPath(PosterPath);
        tv.setBackdropPath(BackdropPath);
        tv.setPopularity(Popularity);

        realm.beginTransaction();
        realm.copyToRealm(tv);
        realm.commitTransaction();

        //Toast.makeText(mContext, "Data berhasil ditambah", Toast.LENGTH_SHORT).show();
    }

    public void deleteFavoriteMovie(int id) {
        realm.beginTransaction();
        RealmResults<ModelMovie> modelMovie = realm.where(ModelMovie.class).findAll();
        modelMovie.deleteAllFromRealm();
        realm.commitTransaction();

        //Toast.makeText(mContext, "Data berhasil dihapus", Toast.LENGTH_SHORT).show();
    }

    public void deleteFavoriteTV(int id) {
        realm.beginTransaction();
        RealmResults<ModelTv> modelTV = realm.where(ModelTv.class).findAll();
        modelTV.deleteAllFromRealm();
        realm.commitTransaction();

        //Toast.makeText(mContext, "Data berhasil dihapus", Toast.LENGTH_SHORT).show();
    }

}
