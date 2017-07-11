package com.android.greendaodatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.android.greendaodatabase.entites.Hospital;
import com.android.greendaodatabase.entites.Patient;
import com.android.greendaodatabase.entites.PhotoData;
import com.android.greendaodatabase.entites.UserAccount;
import com.visunex.greendao.gen.DaoMaster;
import com.visunex.greendao.gen.DaoSession;
import com.visunex.greendao.gen.HospitalDao;
import com.visunex.greendao.gen.PatientDao;
import com.visunex.greendao.gen.PhotoDataDao;
import com.visunex.greendao.gen.UserAccountDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * Function
 * Created by lei.zhang on 2017/7/3.
 */

public class GreenDaoManager {
    private static String dbName;
    private static GreenDaoManager mInstance = null;
    private static DaoMaster.DevOpenHelper openHelper;
    private static DaoMaster mDaoMaster;
    private static DaoSession mDaoSession;
    private static PatientDao patientDao;
    private static HospitalDao hospitalDao;
    private static PhotoDataDao photoDataDao;
    private static UserAccountDao userAccountDao;
    private Context context;

    private GreenDaoManager(Context context, String dbName) {
        this.context = context;
        this.dbName = dbName;
        openHelper = new DaoMaster.DevOpenHelper(context.getApplicationContext(), dbName, null);
        Log.i("GreenDaoManager", "changjianshujvku");
        getDaoMaster(context);
        getDaoSession(context);
        getPatientDao();
        getHospitalDaoDao();
        getPhotoDataDao();
        getAccountDao();
    }

    public static GreenDaoManager getInstance(Context context, String dbName){
        if (mInstance == null){
            synchronized (GreenDaoManager.class){
                if (mInstance == null){
                    mInstance = new GreenDaoManager(context, dbName);
                }
            }
        }
        return mInstance;
    }

    public static SQLiteDatabase getReadableDatabase(Context context) {
        if (null == openHelper) {
            return null;
        }
        return openHelper.getReadableDatabase();
    }

    public static SQLiteDatabase getWritableDatabase(Context context) {
        if (null == openHelper) {
            return null;
        }
        return openHelper.getWritableDatabase();
    }

    public static DaoMaster getDaoMaster(Context context) {
        if (null == mDaoMaster) {
            synchronized (GreenDaoManager.class) {
                if (null == mDaoMaster) {
                    MyOpenHelper helper = new MyOpenHelper(context,dbName,null);
                    mDaoMaster = new DaoMaster(helper.getWritableDatabase());
                }
            }
        }
        return mDaoMaster;
    }

    public static DaoSession getDaoSession(Context context) {
        if (null == mDaoSession) {
            synchronized (GreenDaoManager.class) {
                mDaoSession = getDaoMaster(context).newSession();
            }
        }
        return mDaoSession;
    }

    public static PatientDao getPatientDao() {
        if (null == patientDao){
            synchronized (GreenDaoManager.class){
                patientDao = mDaoSession.getPatientDao();
            }
        }
        return patientDao;
    }

    public static HospitalDao getHospitalDaoDao() {
        if (null == hospitalDao){
            synchronized (GreenDaoManager.class){
                hospitalDao = mDaoSession.getHospitalDao();
            }
        }
        return hospitalDao;
    }

    public static PhotoDataDao getPhotoDataDao() {
        if (null == photoDataDao){
            synchronized (GreenDaoManager.class){
                photoDataDao = mDaoSession.getPhotoDataDao();
            }
        }
        return photoDataDao;
    }

    public static UserAccountDao getAccountDao() {
        if (null == userAccountDao){
            synchronized (GreenDaoManager.class){
                userAccountDao = mDaoSession.getUserAccountDao();
            }
        }
        return userAccountDao;
    }

    public void insertPatient(Patient patient) {
        patientDao.insertOrReplace(patient);
    }

    public void insertPatientList(List<Patient> patients) {
        if ((patients == null) || (patients.isEmpty())){
            return;
        }
        patientDao.insertInTx(patients);
    }

    public void updatePatient(Patient patient) {
        patientDao.update(patient);
    }

    public void deletePatient(Patient patient) {
        patientDao.delete(patient);
    }

    public void deletePatientByKey(long id) {
        patientDao.deleteByKey(id);
    }

    public void deletePatientAll() {
        patientDao.deleteAll();
    }

    public List<Patient> queryPatientAll() {
        QueryBuilder<Patient> patientQB = patientDao.queryBuilder();
        return patientQB.list();
    }

    public List<Patient> queryPatientById(long id) {
        QueryBuilder<Patient> patientQB = patientDao.queryBuilder();
        return patientQB.where(PatientDao.Properties.IdPatient.eq(id)).list();
    }

    public void insertHospital(Hospital hospital) {
        hospitalDao.insertOrReplace(hospital);
    }

    public void insertHospitalList(List<Hospital> hospitals) {
        if ((hospitals == null) || (hospitals.isEmpty())){
            return;
        }
        hospitalDao.insertInTx(hospitals);
    }

    public void updateHospital(Hospital hospital) {
        hospitalDao.update(hospital);
    }

    public void deleteHospital(Hospital hospital) {
        hospitalDao.delete(hospital);
    }

    public void deleteHospitalByKey(long id) {
        hospitalDao.deleteByKey(id);
    }

    public void deleteHospitalAll() {
        hospitalDao.deleteAll();
    }

    public List<Hospital> queryHospitalAll() {
        QueryBuilder<Hospital> hospitalQB = hospitalDao.queryBuilder();
        return hospitalQB.list();
    }

    public List<Hospital> queryHospitalById(long id) {
        QueryBuilder<Hospital> hospitalQB = hospitalDao.queryBuilder();
        return hospitalQB.where(HospitalDao.Properties.IdHospital.eq(id)).list();
    }

    public List<Hospital> getHospitalBySN(String hospitalSn){
        QueryBuilder<Hospital> hospitalQB = hospitalDao.queryBuilder();
        return hospitalQB.where(HospitalDao.Properties.HospitalSn.eq(hospitalSn)).list();
    }

    public void insertUserAccount(UserAccount userAccount) {
        userAccountDao.insertOrReplace(userAccount);
    }

    public void insertUserAccountList(List<UserAccount> userAccounts) {
        if ((userAccounts == null) || (userAccounts.isEmpty())){
            return;
        }
        userAccountDao.insertInTx(userAccounts);
    }

    public void updateUserAccount(UserAccount userAccount) {
        userAccountDao.update(userAccount);
    }

    public void deleteUserAccount(UserAccount userAccount) {
        userAccountDao.delete(userAccount);
    }

    public void deleteUserAccountByKey(long id) {
        userAccountDao.deleteByKey(id);
    }

    public void deleteUserAccountAll() {
        userAccountDao.deleteAll();
    }

    public List<UserAccount> queryUserAccountAll() {
        QueryBuilder<UserAccount> userAccountQB = userAccountDao.queryBuilder();
        return userAccountQB.list();
    }

    public List<UserAccount> queryUserAccountById(long id) {
        QueryBuilder<UserAccount> userAccountQB = userAccountDao.queryBuilder();
        return userAccountQB.where(UserAccountDao.Properties.IdUserAccount.eq(id)).list();
    }

    public void insertPhotoData(PhotoData photoData) {
        photoDataDao.insert(photoData);
    }

    public void insertPhotoDataList(List<PhotoData> photoDatas) {
        if ((photoDatas == null) || (photoDatas.isEmpty())){
            return;
        }
        photoDataDao.insertInTx(photoDatas);
    }

    public void updatePhotoData(PhotoData photoData) {
        photoDataDao.update(photoData);
    }

    public void deletePhotoData(PhotoData photoData) {
        deletePhotoDataByUUID(photoData.getPatientUuid());
    }

    public void deletePhotoDataByKey(long id) {
        photoDataDao.deleteByKey(id);
    }

    public void deletePhotoDataByUUID(long patientUuid) {
        List<PhotoData> mlists = queryPhotoDataByUUID(patientUuid);
        if (!mlists.isEmpty()){
            for (PhotoData pd : mlists){
                photoDataDao.delete(pd);
            }
        }
    }

    public void deletePhotoDataAll() {
        photoDataDao.deleteAll();
    }

    public List<PhotoData> queryPhotoDataAll() {
        QueryBuilder<PhotoData> photoDataQB = photoDataDao.queryBuilder();
        return photoDataQB.list();
    }

    public List<PhotoData> queryPhotoDataById(long id) {
        QueryBuilder<PhotoData> photoDataQB = photoDataDao.queryBuilder();
        return photoDataQB.where(PhotoDataDao.Properties.IdImageData.eq(id)).list();
    }

    public List<PhotoData> queryPhotoDataByUUID(long patientUuid) {
        QueryBuilder<PhotoData> photoDataQB = photoDataDao.queryBuilder();
        return photoDataQB.where(PhotoDataDao.Properties.PatientUuid.eq(patientUuid)).list();
    }
}
