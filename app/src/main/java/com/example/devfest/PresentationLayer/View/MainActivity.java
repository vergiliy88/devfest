package com.example.devfest.PresentationLayer.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import com.example.devfest.App;
import com.example.devfest.DataLayer.Network.DevfestService;
import com.example.devfest.DomailLayer.Model.Speaker;
import com.example.devfest.DomailLayer.Response.SpeakerResponse;
import com.example.devfest.PresentationLayer.Adapters.SpeakerAdapter;
import com.example.devfest.PresentationLayer.Presenters.BasePresenter;
import com.example.devfest.PresentationLayer.Presenters.MainPresenter;
import com.example.devfest.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements MainMvpView{

    private RecyclerView speakerRecycler;
    
    private SpeakerAdapter speakerAdapter;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecycler();
        presenter = (MainPresenter) App.get(this).getPresenterManager().get(0);
        presenter.bindView(this);
        presenter.onCreate();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.unbindView();
    }

    @Override
    public void showData(List<Speaker> speakerList) {
        speakerAdapter.setSpeakerList(speakerList);
    }

    private void initRecycler(){
        speakerAdapter = new SpeakerAdapter();
        speakerRecycler = (RecyclerView) findViewById(R.id.speakersRecycler);
        speakerRecycler.setLayoutManager(new LinearLayoutManager(this));
        speakerRecycler.setAdapter(speakerAdapter);
        speakerAdapter.onSpeakerClickListener = position -> DetailActivity.start(this, speakerAdapter.getSpeakerList().get(position));
    }
}
