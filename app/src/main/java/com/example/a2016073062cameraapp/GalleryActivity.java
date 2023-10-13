/* NSM Madayizana
   2016073062
   Gallery Activity
   17 May 2023
   CSIP 6853
 */

package com.example.a2016073062cameraapp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.io.File;
import java.util.ArrayList;

public class GalleryActivity extends AppCompatActivity {
    ArrayList<String> arrayList = new ArrayList<>();
    File[] lstFile;
    private String folderName = "MyPhotoDir";
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        getFromSdCard();

        // Initialization
        viewPager = findViewById(R.id.vpMain);

        viewPagerAdapter = new ViewPagerAdapter(this, arrayList);

        viewPager.setAdapter(viewPagerAdapter);
    }

    public void getFromSdCard() {
        File file = new File(getExternalFilesDir(folderName), "/");

        if (file.isDirectory()) {
            lstFile = file.listFiles();

            for (int i = 0; i < lstFile.length; i++) {
                arrayList.add(lstFile[i].getAbsolutePath());
            }
        }
    }
}
