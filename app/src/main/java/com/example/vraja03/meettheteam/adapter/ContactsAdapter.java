package com.example.vraja03.meettheteam.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vraja03.meettheteam.R;
import com.example.vraja03.meettheteam.fragment.ContactsFragment;
import com.example.vraja03.meettheteam.model.Contact;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by vraja03 on 2/18/2017.
 */

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {

    private final Context context;
    private ContactsFragment parent;
    private ArrayList<Contact> contactObj = new ArrayList<>();

    public ContactsAdapter(ArrayList<Contact> co, Context context, ContactsFragment parent) {
        this.contactObj = co;
        this.context = context;
        this.parent = parent;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_individual, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Contact co = contactObj.get(position);


        holder.tvName.setText(co.getFristName() + "," + co.getLastName());
        String url = co.getAvatar();
        int imageSize = (int) context.getResources().getDimension(R.dimen.image_size);
        Picasso.with(context).load(url).resize(imageSize, imageSize).centerCrop().into(holder.ivAvatar);


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.onItemClick(co);
            }
        });

    }

    @Override
    public int getItemCount() {
        return contactObj.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView tvName;
        ImageView ivAvatar;

        public ViewHolder(View view) {
            super(view);
            cardView = (CardView) view.findViewById(R.id.card_view);
            tvName = (TextView) view.findViewById(R.id.tvName);
            ivAvatar = (ImageView) view.findViewById(R.id.ivAvatar);

        }

    }
}
