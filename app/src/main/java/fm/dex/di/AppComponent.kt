package fm.dex.di

import javax.inject.Singleton

import dagger.Component
import fm.dex.view.fragment.DashboardFragment

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(dashboardFragment: DashboardFragment)
}
