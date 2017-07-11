package com.android.greendaodatabase;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.greendaodatabase.entites.PhotoData;

import java.util.List;

public class MainActivity extends Activity{
    private static final String TAG = MainActivity.class.getSimpleName();
    private Button insertBtn;
    private Button updateBtn;
    private Button queryBtn;
    private Button deleteBtn;
    GreenDaoManager manager;
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        insertBtn = (Button)findViewById(R.id.button1);
        updateBtn = (Button)findViewById(R.id.button2);
        queryBtn = (Button)findViewById(R.id.button3);
        deleteBtn = (Button)findViewById(R.id.button4);
        manager = GreenDaoManager.getInstance(this, "george_wr");
        Log.i(TAG, "测试");

        final PhotoData photoData1 = new PhotoData();
        final PhotoData photoData2 = new PhotoData();
        photoData1.setFirstName("zhang");
        photoData1.setPatientUuid(111);
        photoData2.setFirstName("lei");
        photoData2.setPatientUuid(222);
        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "插入");
                if (i == 0){
                    manager.insertPhotoData(photoData1);
                    i = 1;
                }else if (i == 1){
                    manager.insertPhotoData(photoData2);
                    i = 0;
                }

            }
        });

        queryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "查询");
                List<PhotoData> list = manager.queryPhotoDataAll();
                Log.i(TAG, "查询2222        " + list.size());
                for (PhotoData photodata : list) {
                    Toast.makeText(getApplicationContext(), photodata.getIdImageData().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.deletePhotoData(photoData1);
            }
        });
    }
}
