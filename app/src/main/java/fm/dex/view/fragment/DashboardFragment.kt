package fm.dex.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fm.dex.DexFmApp

import javax.inject.Inject

import fm.dex.model.api.ApiService
import fm.dex.model.entity.DaoSession
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class DashboardFragment : BaseFragment() {

    @Inject
    lateinit var apiService: ApiService

    @Inject
    lateinit var daoSession: DaoSession

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        val application = activity.application as DexFmApp
        application.component.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        feeds()
    }

    private fun feeds(): Subscription {
        return apiService.feeds().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
    }

    companion object {

        fun newInstance(): DashboardFragment {
            return DashboardFragment()
        }
    }
}
