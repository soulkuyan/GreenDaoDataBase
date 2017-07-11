package com.android.greendaodatabase.entites;


import com.visunex.greendao.gen.DaoSession;
import com.visunex.greendao.gen.PatientDao;
import com.visunex.greendao.gen.PhotoDataDao;

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
public class Patient {
    @Id(autoincrement = true)
    private Long idPatient;
    private long patientUuid;
    private String patientId;
    private String firstName;
    private String middleName;
    private String lastName;
    private int gender;
    private String birthDate;
    private String birthPlace;
    private String citizenship;
    private int brithWeight;
    private int brithHeight;
    private int gestation_age;
    private String guardianName;
    private int slibing;
    private String nationality;
    private String tel;
    private String guardianShip;
    private String createDate;
    private String hospitalSn;
    @ToMany(joinProperties = {
            @JoinProperty(name = "patientUuid", referencedName = "patientUuid")
    })
    private List<PhotoData> photoDatas;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 913916263)
    private transient PatientDao myDao;
    @Generated(hash = 300857288)
    public Patient(Long idPatient, long patientUuid, String patientId,
            String firstName, String middleName, String lastName, int gender,
            String birthDate, String birthPlace, String citizenship,
            int brithWeight, int brithHeight, int gestation_age,
            String guardianName, int slibing, String nationality, String tel,
            String guardianShip, String createDate, String hospitalSn) {
        this.idPatient = idPatient;
        this.patientUuid = patientUuid;
        this.patientId = patientId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.citizenship = citizenship;
        this.brithWeight = brithWeight;
        this.brithHeight = brithHeight;
        this.gestation_age = gestation_age;
        this.guardianName = guardianName;
        this.slibing = slibing;
        this.nationality = nationality;
        this.tel = tel;
        this.guardianShip = guardianShip;
        this.createDate = createDate;
        this.hospitalSn = hospitalSn;
    }
    @Generated(hash = 1655646460)
    public Patient() {
    }
    public Long getIdPatient() {
        return this.idPatient;
    }
    public void setIdPatient(Long idPatient) {
        this.idPatient = idPatient;
    }
    public long getPatientUuid() {
        return this.patientUuid;
    }
    public void setPatientUuid(long patientUuid) {
        this.patientUuid = patientUuid;
    }
    public String getPatientId() {
        return this.patientId;
    }
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
    public String getFirstName() {
        return this.firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getMiddleName() {
        return this.middleName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getGender() {
        return this.gender;
    }
    public void setGender(int gender) {
        this.gender = gender;
    }
    public String getBirthDate() {
        return this.birthDate;
    }
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    public String getBirthPlace() {
        return this.birthPlace;
    }
    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }
    public String getCitizenship() {
        return this.citizenship;
    }
    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }
    public int getBrithWeight() {
        return this.brithWeight;
    }
    public void setBrithWeight(int brithWeight) {
        this.brithWeight = brithWeight;
    }
    public int getBrithHeight() {
        return this.brithHeight;
    }
    public void setBrithHeight(int brithHeight) {
        this.brithHeight = brithHeight;
    }
    public int getGestation_age() {
        return this.gestation_age;
    }
    public void setGestation_age(int gestation_age) {
        this.gestation_age = gestation_age;
    }
    public String getGuardianName() {
        return this.guardianName;
    }
    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }
    public int getSlibing() {
        return this.slibing;
    }
    public void setSlibing(int slibing) {
        this.slibing = slibing;
    }
    public String getNationality() {
        return this.nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public String getTel() {
        return this.tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getGuardianShip() {
        return this.guardianShip;
    }
    public void setGuardianShip(String guardianShip) {
        this.guardianShip = guardianShip;
    }
    public String getCreateDate() {
        return this.createDate;
    }
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
    public String getHospitalSn() {
        return this.hospitalSn;
    }
    public void setHospitalSn(String hospitalSn) {
        this.hospitalSn = hospitalSn;
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 878756194)
    public List<PhotoData> getPhotoDatas() {
        if (photoDatas == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            PhotoDataDao targetDao = daoSession.getPhotoDataDao();
            List<PhotoData> photoDatasNew = targetDao
                    ._queryPatient_PhotoDatas(patientUuid);
            synchronized (this) {
                if (photoDatas == null) {
                    photoDatas = photoDatasNew;
                }
            }
        }
        return photoDatas;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1620684810)
    public synchronized void resetPhotoDatas() {
        photoDatas = null;
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
    @Generated(hash = 244362399)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getPatientDao() : null;
    }
}
