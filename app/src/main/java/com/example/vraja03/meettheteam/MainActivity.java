package com.example.vraja03.meettheteam;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.vraja03.meettheteam.fragment.ContactsFragment;
import com.example.vraja03.meettheteam.parser.ContactJsonParsing;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = this.getSupportFragmentManager();
        launchFlow();
    }

    private void launchFlow() {
        ContactsFragment mContactsFragment = new ContactsFragment();
        fm.beginTransaction().replace(R.id.fragment_container, mContactsFragment).commit();
    }
}
