package amirahmed.com.mtlf4androidapplication.Utils;


import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class RealmApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(getApplicationContext());

        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name("examples.realm")
                .build();

        Realm.setDefaultConfiguration(realmConfiguration);
    }
}
