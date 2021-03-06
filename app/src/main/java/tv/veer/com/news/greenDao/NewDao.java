package tv.veer.com.news.greenDao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "NEW".
*/
public class NewDao extends AbstractDao<New, Void> {

    public static final String TABLENAME = "NEW";

    /**
     * Properties of entity New.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, int.class, "id", false, "ID");
        public final static Property Title = new Property(1, String.class, "title", false, "TITLE");
        public final static Property Category = new Property(2, String.class, "category", false, "CATEGORY");
        public final static Property Thumb_url = new Property(3, String.class, "thumb_url", false, "THUMB_URL");
        public final static Property Page_url = new Property(4, String.class, "page_url", false, "PAGE_URL");
    }


    public NewDao(DaoConfig config) {
        super(config);
    }
    
    public NewDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"NEW\" (" + //
                "\"ID\" INTEGER NOT NULL ," + // 0: id
                "\"TITLE\" TEXT," + // 1: title
                "\"CATEGORY\" TEXT," + // 2: category
                "\"THUMB_URL\" TEXT," + // 3: thumb_url
                "\"PAGE_URL\" TEXT);"); // 4: page_url
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"NEW\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, New entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(2, title);
        }
 
        String category = entity.getCategory();
        if (category != null) {
            stmt.bindString(3, category);
        }
 
        String thumb_url = entity.getThumb_url();
        if (thumb_url != null) {
            stmt.bindString(4, thumb_url);
        }
 
        String page_url = entity.getPage_url();
        if (page_url != null) {
            stmt.bindString(5, page_url);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, New entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(2, title);
        }
 
        String category = entity.getCategory();
        if (category != null) {
            stmt.bindString(3, category);
        }
 
        String thumb_url = entity.getThumb_url();
        if (thumb_url != null) {
            stmt.bindString(4, thumb_url);
        }
 
        String page_url = entity.getPage_url();
        if (page_url != null) {
            stmt.bindString(5, page_url);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public New readEntity(Cursor cursor, int offset) {
        New entity = new New( //
            cursor.getInt(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // title
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // category
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // thumb_url
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4) // page_url
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, New entity, int offset) {
        entity.setId(cursor.getInt(offset + 0));
        entity.setTitle(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setCategory(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setThumb_url(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setPage_url(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(New entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(New entity) {
        return null;
    }

    @Override
    public boolean hasKey(New entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
