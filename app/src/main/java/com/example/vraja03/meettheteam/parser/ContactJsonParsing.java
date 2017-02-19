package com.example.vraja03.meettheteam.parser;

import android.content.ContentValues;
import android.content.Context;

import com.example.vraja03.meettheteam.model.Contact;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by vraja03 on 2/18/2017.
 */

public class ContactJsonParsing {

    public ArrayList<Contact> contacts = new ArrayList<>();

    public ArrayList<Contact> loadJSONFromAsset(Context context) {
        String json = null;
        try {

            InputStream is = context.getAssets().open("team.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
            jsonReader(json);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return contacts;
    }

    private void jsonReader(String json) {
        try {
            JSONArray contactsArray = new JSONArray(json);
            for (int contact = 0; contact < contactsArray.length(); contact++) {
                Contact contactObj = new Contact();
                JSONObject individualContactObject = (JSONObject) contactsArray.get(contact);
                contactObj.setId(individualContactObject.optString("id"));
                contactObj.setAvatar(individualContactObject.optString("avatar"));
                contactObj.setBio(individualContactObject.optString("bio"));
                contactObj.setFristName(individualContactObject.optString("firstName"));
                contactObj.setLastName(individualContactObject.optString("lastName"));
                contactObj.setTitle(individualContactObject.optString("title"));
                contacts.add(contactObj);
            }

            System.out.println("$$$$" + contacts.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}
