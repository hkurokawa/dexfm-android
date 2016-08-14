package fm.dex.view.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import fm.dex.R;

abstract class BaseActivity extends AppCompatActivity {

    protected void addFragment(Fragment fragment) {
        final FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.content_view, fragment, fragment.getClass().getSimpleName());
        ft.commit();
    }
}
