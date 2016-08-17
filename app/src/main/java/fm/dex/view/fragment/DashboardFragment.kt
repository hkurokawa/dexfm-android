package fm.dex.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import javax.inject.Inject

import fm.dex.model.api.ApiService
import fm.dex.model.entity.DaoSession
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class DashboardFragment : BaseFragment() {

    @Inject
    internal var apiService: ApiService? = null

    @Inject
    internal var daoSession: DaoSession? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //        binding = FragmentSessionsBinding.inflate(inflater, container, false);
        return null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        apiService!!.feeds
    }

    internal val feeds: Subscription
        get() = apiService!!.feeds.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe()

    companion object {

        fun newInstance(): DashboardFragment {
            return DashboardFragment()
        }
    }
}
