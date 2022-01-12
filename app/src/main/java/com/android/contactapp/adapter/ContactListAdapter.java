package com.android.contactapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.contactapp.R;
import com.android.contactapp.activity.DetailActivity;
import com.android.contactapp.model.Model;
import com.android.contactapp.model.Results;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private final Context context;
    private List<Results> list;

    public ContactListAdapter(LayoutInflater inflater, Context context) {
        this.inflater = inflater;
        this.context = context;
    }

    public void setData(List<Results> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ContactListAdapter.ViewHolder holder, final int position) {
        holder.textUsername.setText(list.get(position).getName().getTitle()+" "+list.get(position).getName().getFirst()
        +" "+list.get(position).getName().getLast());

        Glide.with(context)
                .load(list.get(position).getPicture().getThumbnail())
                .apply(RequestOptions.circleCropTransform())
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txt_username)
        TextView textUsername;

        @BindView(R.id.img_photo)
        ImageView image;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String title = list.get(getAdapterPosition()).getName().getTitle();
                    String firstName = list.get(getAdapterPosition()).getName().getFirst();
                    String lastName = list.get(getAdapterPosition()).getName().getLast();
                    String dob = list.get(getAdapterPosition()).getDob().getDate();
                    String gender = list.get(getAdapterPosition()).getGender();
                    String email = list.get(getAdapterPosition()).getEmail();
                    String phone = list.get(getAdapterPosition()).getPhone();
                    String cell = list.get(getAdapterPosition()).getCell();
                    String streetName = list.get(getAdapterPosition()).getLocation().getStreet().getName();
                    String streetNumber = list.get(getAdapterPosition()).getLocation().getStreet().getNumber();
                    String city = list.get(getAdapterPosition()).getLocation().getCity();
                    String state = list.get(getAdapterPosition()).getLocation().getState();
                    String country = list.get(getAdapterPosition()).getLocation().getCountry();
                    String postCode = list.get(getAdapterPosition()).getLocation().getPostcode();
                    String latitude = list.get(getAdapterPosition()).getLocation().getCoordinates().getLatitude();
                    String longitude = list.get(getAdapterPosition()).getLocation().getCoordinates().getLongitude();
                    String picture = list.get(getAdapterPosition()).getPicture().getLarge();

                    Intent i = new Intent(context, DetailActivity.class);
                    i.putExtra("title", title);
                    i.putExtra("firstName", firstName);
                    i.putExtra("lastName", lastName);
                    i.putExtra("dob", dob);
                    i.putExtra("gender", gender);
                    i.putExtra("email", email);
                    i.putExtra("phone", phone);
                    i.putExtra("cell", cell);
                    i.putExtra("streetName", streetName);
                    i.putExtra("streetNumber", streetNumber);
                    i.putExtra("city", city);
                    i.putExtra("state", state);
                    i.putExtra("country", country);
                    i.putExtra("postCode", postCode);
                    i.putExtra("latitude", latitude);
                    i.putExtra("longitude", longitude);
                    i.putExtra("picture", picture);
                    context.startActivity(i);

                }
            });
        }
    }
}
