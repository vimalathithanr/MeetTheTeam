package com.example.vraja03.meettheteam.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vraja03.meettheteam.R;
import com.squareup.picasso.Picasso;

/**
 * Created by vraja03 on 2/18/2017.
 */

public class ContactsDetailFragment extends Fragment {

    private ImageView ivAvatar;
    private TextView tvName;
    private TextView tvTitle;
    private TextView tvBio;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contact_detail, container, false);
        ivAvatar = (ImageView) view.findViewById(R.id.ivAvatar);
        tvName = (TextView) view.findViewById(R.id.tvName);
        tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        tvBio = (TextView) view.findViewById(R.id.tvBio);


        Bundle b = getArguments();
        if(b!=null){
            int imageSize = (int) getActivity().getResources().getDimension(R.dimen.image_size_detail);
            Picasso.with(getActivity()).load(b.getString("avatar")).resize(imageSize, imageSize).centerCrop().into(ivAvatar);
            tvName.setText(b.getString("name"));
            tvTitle.setText(b.getString("title"));
            tvBio.setText(b.getString("bio"));
        }

        return view;
    }


}
