package cn.droidlover.xdroidmvp.sys.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import com.litesuits.orm.LiteOrm;
import com.litesuits.orm.db.DataBaseConfig;
import com.litesuits.orm.db.assit.SQLiteHelper;

import java.io.File;
import java.io.FilenameFilter;

import cn.droidlover.xdroidmvp.sys.App;

/**
 * ormlite数据库管理类
 */
public class OrmLiteManager {
    public static final String DB_NAME = "mvp.db";
    public static final String PACKAGE_NAME = App.getContext().getPackageName();
    public static final String DB_PATH = "/data" + Environment.getDataDirectory().getAbsolutePath() + "/" + PACKAGE_NAME + "/databases/";

    private static LiteOrm liteOrm;
    private static OrmLiteManager instance;

    public OrmLiteManager(Context context) {
        File dbDir = new File(DB_PATH);
        File[] dbFiles = dbDir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File file, String s) {
                if (s.contains("offline") && !s.equals(DB_NAME) && !s.equals(DB_NAME + "-journal")) {
                    return true;
                }
                return false;
            }
        });
        for (File dbfile : dbFiles) {
            dbfile.delete();
        }
    }

    public static OrmLiteManager getInstance(Context context) {
        if (instance == null) {
            instance = new OrmLiteManager(context);
        }
        return instance;
    }

    public LiteOrm getLiteOrm(Context context) {
        if (liteOrm == null) {
            DataBaseConfig config = new DataBaseConfig(context, DB_PATH + DB_NAME);
            config.debugged = true; // open the log
            config.dbVersion = 1; // set database version
            // set database update listener
            config.onUpdateListener = new SQLiteHelper.OnUpdateListener() {
                @Override
                public void onUpdate(SQLiteDatabase var1, int oldCode, int newCode) {

                }
            };
            liteOrm = LiteOrm.newCascadeInstance(config);
        }
        return liteOrm;
    }

}
