package com.wyman.module_home.service;

import com.wyman.library_common.base.DataResponse;
import com.wyman.module_home.entity.Article;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by lw on 2018/1/23.
 */

public interface HomeService {
    /**
     * 首页数据
     * http://www.wanandroid.com/article/list/0/json
     *
     * @param page page
     */
    @GET("/article/list/{page}/json")
    Observable<DataResponse<Article>> getHomeArticles(@Path("page") int page);


}
