package com.example.devfest.presentation.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.devfest.Config;
import com.example.devfest.domain.model.Speaker;
import com.example.devfest.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class SpeakerAdapter extends RecyclerView.Adapter<SpeakerAdapter.SpeakerViewHolder> {

    private List<Speaker> speakerList;

    public SpeakerAdapter(){
        speakerList = new ArrayList<>();
    }

    public OnSpeakerClickListener onSpeakerClickListener;

    public interface OnSpeakerClickListener{
        void OnItemClick(int position);
    }

    @NonNull
    @Override
    public SpeakerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view =  LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        return new SpeakerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpeakerViewHolder speakerViewHolder, int i) {
        speakerViewHolder.bind(speakerList.get(i));
    }

    @Override
    public int getItemCount() {
        return speakerList.size();
    }

    public List<Speaker> getSpeakerList() {
        return speakerList;
    }

    public void setSpeakerList(List<Speaker> speakerList) {
        this.speakerList = speakerList;
        notifyDataSetChanged();
    }

    protected class SpeakerViewHolder extends BaseViewHolder<Speaker> implements View.OnClickListener{
        private CircleImageView speakerImage;
        private TextView speakerNameTxt;
        private TextView speakerPositionTxt;
        private TextView speakerLocationTxt;

        public SpeakerViewHolder(@NonNull View itemView) {
            super(itemView);

            speakerImage = itemView.findViewById(R.id.profile_image);
            speakerNameTxt = itemView.findViewById(R.id.textViewName);
            speakerPositionTxt = itemView.findViewById(R.id.textViewPosition);
            speakerLocationTxt = itemView.findViewById(R.id.textViewLocation);
            itemView.setOnClickListener(this::onClick);
        }

        @Override
        public void bind(Speaker object) {
            Picasso.get()
                    .load(Config.PHOTOS_URL + object.getPathToPhoto())
                    .into(speakerImage);
            speakerNameTxt.setText(object.getSpeakerName());
            speakerPositionTxt.setText(object.getPosition());
            speakerLocationTxt.setText(object.getLocation());
        }

        @Override
        public void onClick(View v) {
            if (onSpeakerClickListener != null){
                onSpeakerClickListener.OnItemClick(getAdapterPosition());
            }
        }
    }
}
