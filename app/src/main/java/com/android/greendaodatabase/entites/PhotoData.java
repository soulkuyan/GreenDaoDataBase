package com.android.greendaodatabase.entites;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Function
 * Created by lei.zhang on 2017/7/3.
 */

@Entity
public class PhotoData {
    @Id(autoincrement = true)
    private Long idImageData;
    private String firstName;
    private long patientUuid;
    @Generated(hash = 468503016)
    public PhotoData(Long idImageData, String firstName, long patientUuid) {
        this.idImageData = idImageData;
        this.firstName = firstName;
        this.patientUuid = patientUuid;
    }
    @Generated(hash = 547584535)
    public PhotoData() {
    }
    public Long getIdImageData() {
        return this.idImageData;
    }
    public void setIdImageData(Long idImageData) {
        this.idImageData = idImageData;
    }
    public String getFirstName() {
        return this.firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public long getPatientUuid() {
        return this.patientUuid;
    }
    public void setPatientUuid(long patientUuid) {
        this.patientUuid = patientUuid;
    }
}
