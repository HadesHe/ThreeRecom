package com.lvr.threerecom.module.home;

import com.lvr.threerecom.bean.MovieInfo;
import com.lvr.threerecom.client.RxDisposeManager;
import com.lvr.threerecom.ui.home.model.impl.MainModelImpl;
import com.lvr.threerecom.widget.LoadingDialog;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by lvr on 2017/4/24.
 */

public class MainPresenterImpl implements MainContract.MainPresenter {
    private MainContract.MainView mMainView;
    private MainContract.MainModel mMainModel;

    public MainPresenterImpl(MainContract.MainView mainView) {
        this.mMainView = mainView;
        mMainModel = new MainModelImpl();
    }

    @Override
    public void requestHotMoviee() {
        Observable<List<MovieInfo>> observable = mMainModel.loadHotMovie();
        observable.subscribe(new Observer<List<MovieInfo>>() {
            @Override
            public void onSubscribe(Disposable d) {
                RxDisposeManager.get().add("HotMovie", d);
            }

            @Override
            public void onNext(List<MovieInfo> infos) {
                mMainView.returnMovieInfos(infos);
            }

            @Override
            public void onError(Throwable e) {
                LoadingDialog.cancelDialogForLoading();
            }

            @Override
            public void onComplete() {

            }
        });

    }
}
