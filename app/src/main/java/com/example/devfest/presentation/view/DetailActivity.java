package com.example.devfest.presentation.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.devfest.Config;
import com.example.devfest.domain.model.Speaker;
import com.example.devfest.R;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailActivity extends AppCompatActivity {

    private CircleImageView circleImageView;
    private TextView speakerNameTxt;
    private TextView speakerPositionTxt;
    private TextView speakerLocationTxt;

    private TextView timeTxt;
    private TextView dateTxt;
    private TextView titleTxt;
    private TextView contentTxt;


    private static final String EXTRA_KEY = "KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        circleImageView = findViewById(R.id.profile_image);
        speakerNameTxt = findViewById(R.id.textViewName);
        speakerPositionTxt = findViewById(R.id.textViewPosition);
        speakerLocationTxt = findViewById(R.id.textViewCompany);

        timeTxt = findViewById(R.id.textViewTime);
        dateTxt = findViewById(R.id.textViewDate);
        titleTxt = findViewById(R.id.textViewTitle);
        contentTxt = findViewById(R.id.textViewContent);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(EXTRA_KEY)){
            Speaker speaker = intent.getParcelableExtra(EXTRA_KEY);
            showInfo(speaker);
        }
    }

    public static void start(Activity activity, Parcelable parcelable){
        Intent intent = new Intent(activity, DetailActivity.class);
        intent.putExtra(EXTRA_KEY, parcelable);
        activity.startActivity(intent);
    }

    private void showInfo(Speaker speaker){
        Picasso.get()
                .load(Config.PHOTOS_URL + speaker.getPathToPhoto())
                .into(circleImageView);

        speakerNameTxt.setText(speaker.getSpeakerName());
        speakerPositionTxt.setText(speaker.getPosition());
        speakerLocationTxt.setText(speaker.getLocation());

        timeTxt.setText(speaker.getLecture().getTime());
        titleTxt.setText(speaker.getLecture().getTheme());
        contentTxt.setText(speaker.getLecture().getContent());
    }
}
