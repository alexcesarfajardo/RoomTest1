package com.finepointmobile.roomtest1;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by danielmalone on 10/27/17.
 */

@Database(entities = User.class, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
