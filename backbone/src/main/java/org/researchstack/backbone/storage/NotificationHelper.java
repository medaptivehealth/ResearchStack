package org.researchstack.backbone.storage;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

import com.j256.ormlite.table.TableUtils;

import net.sqlcipher.database.SQLiteDatabase;

import org.researchstack.backbone.storage.database.TaskNotification;
import org.researchstack.backbone.utils.LogExt;

import java.sql.SQLException;
import java.util.List;

public class NotificationHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "db_notification";

    private static int DB_VERSION = 1;

    private static NotificationHelper sInstance;

    private NotificationHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public static NotificationHelper getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new NotificationHelper(context);
        }
        return sInstance;
    }

    @Override
    public void onCreate(android.database.sqlite.SQLiteDatabase sqLiteDatabase) {
        try {
            TableUtils.getCreateTableStatements(new SQLiteDatabase(sqLiteDatabase), TaskNotification.class);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(android.database.sqlite.SQLiteDatabase sqLiteDatabase, int i, int i1) {
        try {
            TableUtils.dropTables(new SQLiteDatabaseImpl(sqLiteDatabase),
                    true,
                    TaskNotification.class);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<TaskNotification> loadTaskNotifications() {
        LogExt.d(getClass(), "loadTaskNotifications()");
        try {
            return getDao(TaskNotification.class).queryForAll().list();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveTaskNotification(TaskNotification notification) {
        LogExt.d(getClass(), "saveTaskNotification() : " + notification.id);

        try {
            getDao(TaskNotification.class).createOrUpdate(notification);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteTaskNotification(int taskNotificationId) {
        LogExt.d(getClass(), "deleteTaskNotification() : " + taskNotificationId);

        try {
            getDao(TaskNotification.class).deleteById(taskNotificationId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
