package com.android.greendaodatabase.entites;


import com.visunex.greendao.gen.DaoSession;
import com.visunex.greendao.gen.HospitalDao;
import com.visunex.greendao.gen.UserAccountDao;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToOne;

/**
 * Function
 * Created by lei.zhang on 2017/7/3.
 */

@Entity
public class UserAccount {
    @Id(autoincrement = true)
    private Long idUserAccount;
    private String userName;
    private String password;
//    private String hospitalSn;
    private long idHospital;
    @ToOne(joinProperty = "idHospital")
    private  Hospital hospital;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1823587417)
    private transient UserAccountDao myDao;
    @Generated(hash = 1347689419)
    public UserAccount(Long idUserAccount, String userName, String password,
            long idHospital) {
        this.idUserAccount = idUserAccount;
        this.userName = userName;
        this.password = password;
        this.idHospital = idHospital;
    }
    @Generated(hash = 1029142458)
    public UserAccount() {
    }
    public Long getIdUserAccount() {
        return this.idUserAccount;
    }
    public void setIdUserAccount(Long idUserAccount) {
        this.idUserAccount = idUserAccount;
    }
    public String getUserName() {
        return this.userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public long getIdHospital() {
        return this.idHospital;
    }
    public void setIdHospital(long idHospital) {
        this.idHospital = idHospital;
    }
    @Generated(hash = 1437719844)
    private transient Long hospital__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1860051453)
    public Hospital getHospital() {
        long __key = this.idHospital;
        if (hospital__resolvedKey == null || !hospital__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            HospitalDao targetDao = daoSession.getHospitalDao();
            Hospital hospitalNew = targetDao.load(__key);
            synchronized (this) {
                hospital = hospitalNew;
                hospital__resolvedKey = __key;
            }
        }
        return hospital;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 678429018)
    public void setHospital(@NotNull Hospital hospital) {
        if (hospital == null) {
            throw new DaoException(
                    "To-one property 'idHospital' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.hospital = hospital;
            idHospital = hospital.getIdHospital();
            hospital__resolvedKey = idHospital;
        }
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
    @Generated(hash = 2000659435)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getUserAccountDao() : null;
    }
}