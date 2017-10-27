package com.finepointmobile.roomtest1;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    AppDatabase db;
    FloatingActionButton fab;
    RecyclerView recyclerView;
    User daniel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = findViewById(R.id.fab);
        recyclerView = findViewById(R.id.recycler_view);

        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "production")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();

        daniel = new User("Daniel", "Malone", "danieljmalone@gmail.com");

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.userDao().insertAll(daniel);
                Log.d(TAG, "onCreate: " + db.userDao().getAll().size());
            }
        });
    }
}
