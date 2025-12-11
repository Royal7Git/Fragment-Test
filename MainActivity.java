package com.example.fragmenttest;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Simple activity that shows how to replace fragments using FragmentManager.
 */
public class MainActivity extends Activity {
	
    private Button btnShowFirst;
    private Button btnShowSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowFirst = (Button) findViewById(R.id.btn_show_first);
        btnShowSecond = (Button) findViewById(R.id.btn_show_second);

        btnShowFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new FirstFragment());
            }
        });

        btnShowSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new SecondFragment());
            }
        });
    }

    private void replaceFragment(Fragment frag) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_container, frag);
        ft.commit();
    }
}
