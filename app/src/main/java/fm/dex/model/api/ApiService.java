package fm.dex.model.api;

import fm.dex.model.entity.Response;
import retrofit2.http.GET;
import rx.Observable;

public interface ApiService {

    String BASE_URL = "https://raw.githubusercontent.com";

    String API_PATH = "dexfm/dexfm.github.io/master/api/";

    @GET(API_PATH + "feeds.json")
    Observable<Response> getFeeds();
}
