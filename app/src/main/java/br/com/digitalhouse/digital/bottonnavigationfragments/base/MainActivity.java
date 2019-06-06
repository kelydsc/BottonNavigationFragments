package br.com.digitalhouse.digital.bottonnavigationfragments.base;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.TextView;

import br.com.digitalhouse.digital.bottonnavigationfragments.R;
import br.com.digitalhouse.digital.bottonnavigationfragments.dashboard.DashboardFragment;
import br.com.digitalhouse.digital.bottonnavigationfragments.home.HomeFragment;
import br.com.digitalhouse.digital.bottonnavigationfragments.notification.NotificationFragment;
import br.com.digitalhouse.digital.bottonnavigationfragments.settings.SettingsFragment;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.nav_view);

        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {

                    case R.id.navigation_home:
                        //fregment para home
                        replaceFragment(new HomeFragment());

                        ///String nome = "Tairo";

                        //if(nome.equals("Tairo")){
                        //    replaceFragment(new HomeFragment());
                        //}

                        return true;

                    case R.id.navigation_dashboard:
                        //fragment para dashboard
                        replaceFragment(new DashboardFragment());

                        return true;

                    case R.id.navigation_notifications:
                        //fragment para notificaions
                        replaceFragment(new NotificationFragment());

                        return true;

                    case R.id.navigation_settings:
                        //fragments para settings
                        replaceFragment(new SettingsFragment());

                        return true;
                }

                return false;
            }
        });
        //começa com o home fragment serado
        replaceFragment(new HomeFragment());
    }

    private  void replaceFragment(Fragment fragment){

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();

    }

}
