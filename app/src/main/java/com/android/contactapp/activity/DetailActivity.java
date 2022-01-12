package com.android.contactapp.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.android.contactapp.R;
import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.Snackbar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    public Toolbar toolbar;

    @BindView(R.id.textToolbar)
    public TextView textToolbar;

    @BindView(R.id.imageToolbar)
    public ImageView imageToolbar;

    @BindView(R.id.img_photo)
    ImageView imgPhoto;

    @BindView(R.id.textName)
    TextView textName;

    @BindView(R.id.img_copy)
    ImageView imgCopy;

    @BindView(R.id.textBod)
    TextView textBod;

    @BindView(R.id.textGender)
    TextView textGender;

    @BindView(R.id.textEmail)
    TextView textEmail;

    @BindView(R.id.textPhone)
    TextView textPhone;

    @BindView(R.id.textMobile)
    TextView textMobile;

    @BindView(R.id.textAddress)
    TextView textAddress;

    @BindView(R.id.textLocation)
    TextView textLocation;

    String title;
    String firstName;
    String lastName;
    String dob;
    String gender;
    String email;
    String phone;
    String cell;
    String streetName;
    String streetNumber;
    String city;
    String state;
    String country;
    String postCode;
    String latitude;
    String longitude;
    String picture;

    private ClipboardManager myClipboard;
    private ClipData myClip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        textToolbar.setText("Rincian Kontak");

        imageToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doShare();
            }
        });

        imgCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                copiedName(v);
            }
        });

        textEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doSendEmail();
            }
        });

        textPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doCallPhone();
            }
        });

        textMobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doCallCell();
            }
        });

        textLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMaps();
            }
        });

        Bundle extras = getIntent().getExtras();
        if (extras!=null) {
            title = extras.getString("title");
            firstName = extras.getString("firstName");
            lastName = extras.getString("lastName");
            dob = extras.getString("dob");
            gender = extras.getString("gender");
            email = extras.getString("email");
            phone = extras.getString("phone");
            cell = extras.getString("cell");
            streetName = extras.getString("streetName");
            streetNumber = extras.getString("streetNumber");
            city = extras.getString("city");
            state = extras.getString("state");
            country = extras.getString("country");
            postCode = extras.getString("postCode");
            latitude = extras.getString("latitude");
            longitude = extras.getString("longitude");
            picture = extras.getString("picture");
        }

        setDetailData();
    }

    public void setDetailData() {
        Glide.with(DetailActivity.this)
                .load(picture)
                .into(imgPhoto);

        textName.setText(title+" "+firstName+" "+lastName);
        textBod.setText(dob);
        textGender.setText(gender);
        textEmail.setText(email);
        textPhone.setText(phone);
        textMobile.setText(cell);
        textAddress.setText(streetName+" "+streetNumber+", "+city+", "+state+", "+country+", "+postCode);
        textLocation.setText(latitude+", "+longitude);
    }

    public void copiedName(View view) {
        myClipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        String text;
        text = textName.getText().toString();

        myClip = ClipData.newPlainText("text", text);
        myClipboard.setPrimaryClip(myClip);

        Snackbar.make(view, "Nama telah tersalin", Snackbar.LENGTH_SHORT).show();

    }

    public void doShare() {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT,
                textName.getText().toString()+", "+textEmail.getText().toString()+", "+textPhone.getText().toString());
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }

    public void doSendEmail() {
        Intent selectorIntent = new Intent(Intent.ACTION_SENDTO);
        selectorIntent.setData(Uri.parse("mailto:"));

        final Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{textEmail.getText().toString()});

        emailIntent.setSelector( selectorIntent );
        startActivity(Intent.createChooser(emailIntent, "Send email..."));
    }

    public void doCallPhone() {
        Intent intentDial = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + textPhone.getText().toString()));
        startActivity(intentDial);
    }

    public void doCallCell() {
        Intent intentDial = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + textMobile.getText().toString()));
        startActivity(intentDial);
    }

    public void openMaps() {
        String strUri = "http://maps.google.com/maps?q=loc:" + latitude + "," + longitude;
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(strUri));
        intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
        startActivity(intent);
    }
}
