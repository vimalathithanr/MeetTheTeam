package com.example.vraja03.meettheteam.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vraja03.meettheteam.R;
import com.example.vraja03.meettheteam.adapter.ContactsAdapter;
import com.example.vraja03.meettheteam.model.Contact;
import com.example.vraja03.meettheteam.parser.ContactJsonParsing;

import java.util.ArrayList;

/**
 * Created by vraja03 on 2/18/2017.
 */

public class ContactsFragment extends Fragment {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contact_overview, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rvContacts);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        ContactJsonParsing contactJsonParsing = new ContactJsonParsing();
        ArrayList<Contact> arrayContactObject = contactJsonParsing.loadJSONFromAsset(getContext());
        ContactsAdapter adapter = new ContactsAdapter(arrayContactObject, getContext(), this);
        recyclerView.setAdapter(adapter);
        return view;
    }


    public void onItemClick(Contact contact) {
        System.out.println("$$$$$$$ " + contact.getId());

        Bundle bundle = new Bundle();

        bundle.putString("id", contact.getId());
        bundle.putString("name", contact.getFristName() + " " + contact.getLastName());
        bundle.putString("avatar", contact.getAvatar());
        bundle.putString("title", contact.getTitle());
        bundle.putString("bio", contact.getBio());

        ContactsDetailFragment detailFragment = new ContactsDetailFragment();
        detailFragment.setArguments(bundle);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, detailFragment).addToBackStack("Contacts").commit();


    }

}
