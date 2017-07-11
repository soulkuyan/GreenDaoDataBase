package com.visunex.greendao.gen;

import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import com.android.greendaodatabase.entites.PhotoData;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "PHOTO_DATA".
*/
public class PhotoDataDao extends AbstractDao<PhotoData, Long> {

    public static final String TABLENAME = "PHOTO_DATA";

    /**
     * Properties of entity PhotoData.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property IdImageData = new Property(0, Long.class, "idImageData", true, "_id");
        public final static Property FirstName = new Property(1, String.class, "firstName", false, "FIRST_NAME");
        public final static Property PatientUuid = new Property(2, long.class, "patientUuid", false, "PATIENT_UUID");
    }

    private Query<PhotoData> patient_PhotoDatasQuery;

    public PhotoDataDao(DaoConfig config) {
        super(config);
    }
    
    public PhotoDataDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"PHOTO_DATA\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: idImageData
                "\"FIRST_NAME\" TEXT," + // 1: firstName
                "\"PATIENT_UUID\" INTEGER NOT NULL );"); // 2: patientUuid
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"PHOTO_DATA\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, PhotoData entity) {
        stmt.clearBindings();
 
        Long idImageData = entity.getIdImageData();
        if (idImageData != null) {
            stmt.bindLong(1, idImageData);
        }
 
        String firstName = entity.getFirstName();
        if (firstName != null) {
            stmt.bindString(2, firstName);
        }
        stmt.bindLong(3, entity.getPatientUuid());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, PhotoData entity) {
        stmt.clearBindings();
 
        Long idImageData = entity.getIdImageData();
        if (idImageData != null) {
            stmt.bindLong(1, idImageData);
        }
 
        String firstName = entity.getFirstName();
        if (firstName != null) {
            stmt.bindString(2, firstName);
        }
        stmt.bindLong(3, entity.getPatientUuid());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public PhotoData readEntity(Cursor cursor, int offset) {
        PhotoData entity = new PhotoData( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // idImageData
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // firstName
            cursor.getLong(offset + 2) // patientUuid
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, PhotoData entity, int offset) {
        entity.setIdImageData(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setFirstName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setPatientUuid(cursor.getLong(offset + 2));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(PhotoData entity, long rowId) {
        entity.setIdImageData(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(PhotoData entity) {
        if(entity != null) {
            return entity.getIdImageData();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(PhotoData entity) {
        return entity.getIdImageData() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "photoDatas" to-many relationship of Patient. */
    public List<PhotoData> _queryPatient_PhotoDatas(long patientUuid) {
        synchronized (this) {
            if (patient_PhotoDatasQuery == null) {
                QueryBuilder<PhotoData> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.PatientUuid.eq(null));
                patient_PhotoDatasQuery = queryBuilder.build();
            }
        }
        Query<PhotoData> query = patient_PhotoDatasQuery.forCurrentThread();
        query.setParameter(0, patientUuid);
        return query.list();
    }

}
