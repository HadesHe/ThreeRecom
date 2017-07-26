package com.lvr.threerecom.module.home;

import com.lvr.threerecom.bean.MovieInfo;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by zhanghehe on 2017/7/27.
 */

public interface MainContract {
    /**
     * Created by lvr on 2017/4/24.
     */

    interface MainModel {
        Observable<List<MovieInfo>> loadHotMovie();
    }

    /**
     * Created by lvr on 2017/4/24.
     */

    interface MainPresenter {
        void requestHotMoviee();
    }

    /**
     * Created by lvr on 2017/4/24.
     */

    interface MainView {
        void returnMovieInfos(List<MovieInfo> movieInfoList);
    }
}
