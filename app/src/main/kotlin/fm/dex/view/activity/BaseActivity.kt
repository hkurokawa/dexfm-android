package fm.dex.view.activity

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

import fm.dex.R

abstract class BaseActivity : AppCompatActivity() {

    protected fun addFragment(fragment: Fragment) {
        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.content_view, fragment, fragment.javaClass.simpleName)
        ft.commit()
    }
}
