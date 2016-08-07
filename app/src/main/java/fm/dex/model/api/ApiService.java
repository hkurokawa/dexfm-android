package fm.dex.model.api;

import fm.dex.model.entity.Response;
import retrofit2.http.GET;
import rx.Observable;

interface ApiService {

    String API_PATH = "dexfm/dexfm.github.io/master/api/";

    @GET(API_PATH + "feeds.json")
    Observable<Response> getFeeds();

}
