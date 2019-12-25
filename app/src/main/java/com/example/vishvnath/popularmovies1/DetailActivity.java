package com.example.vishvnath.popularmovies1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vishvnath.popularmovies1.model.Movie;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {


    public static final String MOVIE_DETAILS = "movie_details";

    @BindView(R.id.iv_detail_movie_poster)
    ImageView mMoviePosterDisplay;
    @BindView(R.id.tv_detail_title)
    TextView mMovieTitleDisplay;
    @BindView(R.id.tv_detail_rate)
    TextView mMovieRateDisplay;
    @BindView(R.id.tv_detail_release_date)
    TextView mMovieReleaseDisplay;
    @BindView(R.id.tv_plot_synopsis)
    TextView mMoviePlotSynopsisDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ButterKnife.bind(this);

        Movie movieDetail = getIntent().getParcelableExtra(MOVIE_DETAILS);

        mMovieTitleDisplay.setText(movieDetail.getTitle());
        mMoviePlotSynopsisDisplay.setText(movieDetail.getOverview());
        mMovieRateDisplay.setText(movieDetail.getRate());
        mMovieReleaseDisplay.setText(movieDetail.getRelease());
        Picasso.get()
                .load(movieDetail.getPoster())
                .placeholder(R.drawable.image_loading)
                .error(R.drawable.image_not_found)
                .into(mMoviePosterDisplay);

    }
}
