package fm.dex.model.api

import fm.dex.model.API_PATH
import fm.dex.model.entity.Response
import retrofit2.http.GET
import rx.Observable

interface ApiService {

    @GET(API_PATH + "feeds.json")
    fun feeds(): Observable<Response>
}
