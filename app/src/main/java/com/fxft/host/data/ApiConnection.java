package com.fxft.host.data;

import com.fxft.host.data.request.BaseRequest;
import com.fxft.host.data.response.PluginApkList;
import com.fxft.host.global.Constants;
import com.fxft.host.utils.LogUtil;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

import static com.fxft.host.data.consts.ContentType.ACCEPT_TEXT;
import static com.fxft.host.data.consts.ContentType.CONTENT_TYPE_TEXT;
import static com.fxft.host.data.consts.HttpHeader.HTTP_HEADER_ACCEPT;
import static com.fxft.host.data.consts.HttpHeader.HTTP_HEADER_CONTENT_TYPE;

/**
 * Created by hzl520 on 2017/8/13.
 * 网络请求API
 */
public class ApiConnection {

    private static RePluginService mRePluginService;

    public interface RePluginService {
        @POST("PluginapkServlet")
        Call<PluginApkList> getPluginApkList(
                @Query("action")
                        int action,
                @Body BaseRequest body);
    }

    /**
     * 获取网络请求的实例
     */
    public static RePluginService getPluginApi() {
        if (mRePluginService == null) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(String message) {
                    LogUtil.i("网络接口", "OkHttp: " + message);
                }
            });
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient okHttpClient = new OkHttpClient.Builder().readTimeout(Constants.DEFAULT_READER_TIMEOUT, TimeUnit.SECONDS)
                    .connectTimeout(Constants.DEFAULT_NET_TIMEOUT, TimeUnit.SECONDS).writeTimeout(Constants.DEFAULT_WRITER_TIMEOUT, TimeUnit.SECONDS)
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request original = chain.request();
                            URL url = new URL(String.valueOf(original.url()));
                            StringBuilder stringBuilder = new StringBuilder();
                            if (StringUtils.isNotBlank(url.getPath())) {
                                stringBuilder.append(url.getPath());
                            }
                            if (StringUtils.isNotBlank(url.getQuery())) {
                                stringBuilder.append("?");
                                stringBuilder.append(url.getQuery());
                            }
                            LogUtil.i("网络接口", original.url().encodedQuery() + "");
                            final Map<String, String> headers = new HashMap<>();
                            headers.put(HTTP_HEADER_ACCEPT, ACCEPT_TEXT);
                            headers.put(HTTP_HEADER_CONTENT_TYPE, CONTENT_TYPE_TEXT);
                            Request request = original.newBuilder()
                                    .headers(Headers.of(headers))
                                    .build();
                            Response response = chain.proceed(request);
                            LogUtil.i("网络接口", String.valueOf(request.headers()));
                            return response;
                        }
                    }).addNetworkInterceptor(logging).build();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_NET_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            mRePluginService = retrofit.create(RePluginService.class);
        }
        return mRePluginService;
    }

}
