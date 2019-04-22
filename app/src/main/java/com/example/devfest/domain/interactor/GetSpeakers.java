package com.example.devfest.domain.interactor;

import com.example.devfest.data.repositorys.DevfestRepository;
import com.example.devfest.domain.executors.Executor;
import com.example.devfest.domain.executors.Interactor;
import com.example.devfest.domain.executors.MainThread;
import com.example.devfest.domain.mappers.SpeakerMapper;
import com.example.devfest.domain.response.SpeakerResponse;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetSpeakers extends UseCase implements Interactor {
    private Executor mExecutor;
    private MainThread mMainThread;
    private GetSpeakersCallback mCallback;
    private DevfestRepository mRepository;

    public GetSpeakers(Executor mExecutor, MainThread mMainThread, GetSpeakersCallback callback) {
        this.mExecutor = mExecutor;
        this.mMainThread = mMainThread;
        this.mCallback = callback;
        mRepository = DevfestRepository.getInstance();
    }

    @Override
    public void execute() {
        if (mExecutor != null)
            this.mExecutor.run(this::run);
    }

    @Override
    public void run() {
        mRepository.loadSpeakers(new Callback<List<SpeakerResponse>>() {
            @Override
            public void onResponse(Call<List<SpeakerResponse>> call, Response<List<SpeakerResponse>> response) {
                if (mMainThread != null)
                mMainThread.post(() -> mMainThread.post(
                        () -> mCallback.onFetchSpeakersSuccess(new SpeakerMapper().transform(response.body()))
                ));
            }

            @Override
            public void onFailure(Call<List<SpeakerResponse>> call, Throwable t) {
                if (mMainThread != null)
                mMainThread.post(() -> mCallback.onFetchSpeakersError());
            }
        });
    }
}
