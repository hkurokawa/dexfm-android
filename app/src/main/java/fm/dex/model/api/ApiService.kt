package fm.dex.model.api

import fm.dex.model.entity.Response
import retrofit2.http.GET
import rx.Observable

interface ApiService {

    val feeds: Observable<Response>

    companion object {

        val BASE_URL = "https://raw.githubusercontent.com"

        val API_PATH = "dexfm/dexfm.github.io/master/api/"
    }
}
