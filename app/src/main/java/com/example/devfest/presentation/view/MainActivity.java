package com.example.devfest.presentation.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.devfest.App;
import com.example.devfest.domain.model.Speaker;
import com.example.devfest.presentation.adapters.SpeakerAdapter;
import com.example.devfest.presentation.presenters.MainPresenter;
import com.example.devfest.R;

import java.util.List;

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
    protected void onResume() {
        super.onResume();
        presenter.updateView();
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
        speakerRecycler = findViewById(R.id.speakersRecycler);
        speakerRecycler.setLayoutManager(new LinearLayoutManager(this));
        speakerRecycler.setAdapter(speakerAdapter);
        speakerAdapter.onSpeakerClickListener = position -> DetailActivity.start(this, speakerAdapter.getSpeakerList().get(position));
    }
}
