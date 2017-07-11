package com.android.greendaodatabase.entites;

import com.visunex.greendao.gen.DaoSession;
import com.visunex.greendao.gen.HospitalDao;
import com.visunex.greendao.gen.PatientDao;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinProperty;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;

/**
 * Function
 * Created by lei.zhang on 2017/7/3.
 */
@Entity
public class Hospital {
    @Id(autoincrement = true)
    private Long idHospital;
    private String hospitalSn;
    private String gpsInfo;
    private String testTestjjjjjj;
    private String hospitalName;
    @ToMany(joinProperties = {
            @JoinProperty(name = "hospitalSn", referencedName = "hospitalSn")
    })
    private List<Patient> patients;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 679648518)
    private transient HospitalDao myDao;
    @Generated(hash = 1143916379)
    public Hospital(Long idHospital, String hospitalSn, String gpsInfo,
            String hospitalName) {
        this.idHospital = idHospital;
        this.hospitalSn = hospitalSn;
        this.gpsInfo = gpsInfo;
        this.hospitalName = hospitalName;
    }
    @Generated(hash = 1301721268)
    public Hospital() {
    }
    public Long getIdHospital() {
        return this.idHospital;
    }
    public void setIdHospital(Long idHospital) {
        this.idHospital = idHospital;
    }
    public String getHospitalSn() {
        return this.hospitalSn;
    }
    public void setHospitalSn(String hospitalSn) {
        this.hospitalSn = hospitalSn;
    }
    public String getGpsInfo() {
        return this.gpsInfo;
    }
    public void setGpsInfo(String gpsInfo) {
        this.gpsInfo = gpsInfo;
    }
    public String getHospitalName() {
        return this.hospitalName;
    }
    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 170952564)
    public List<Patient> getPatients() {
        if (patients == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            PatientDao targetDao = daoSession.getPatientDao();
            List<Patient> patientsNew = targetDao
                    ._queryHospital_Patients(hospitalSn);
            synchronized (this) {
                if (patients == null) {
                    patients = patientsNew;
                }
            }
        }
        return patients;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 2001663522)
    public synchronized void resetPatients() {
        patients = null;
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 267021903)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getHospitalDao() : null;
    }
}
