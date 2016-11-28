package eslyz.netdemo.api;

import eslyz.netdemo.bean.StoreInfo;
import eslyz.netdemo.bean.result.Result;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by eslyz on 2016/11/28.
 */

public interface TestApi {

    @GET("fauna/store/queryStoreById")
    Observable<Result<StoreInfo>> queryStoreById(@Query("storeId") Long storeId);


}
