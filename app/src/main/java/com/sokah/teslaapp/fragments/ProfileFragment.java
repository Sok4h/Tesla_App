package com.sokah.teslaapp.fragments;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.sokah.teslaapp.R;
import com.sokah.teslaapp.model.User;

import java.util.Objects;
import java.util.UUID;

import de.hdodenhof.circleimageview.CircleImageView;


public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }

    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    CircleImageView profilePic;
    ImageView btnAddPicture;
    FirebaseAuth auth;
    FirebaseDatabase db;
    private FirebaseStorage storage;
    User currentUser;
    private StorageReference reference;
    public Uri profilePicUri;
    ActivityResultLauncher<Intent> getProfileImageResult;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.fragment_profile, container, false);
        profilePic = root.findViewById(R.id.profile_pic);
        btnAddPicture = root.findViewById(R.id.btnAddPicture);
        storage = FirebaseStorage.getInstance();
        db = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();
         getProfileImageResult = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {

                        Intent data = result.getData();
                        profilePicUri=data.getData();
                        profilePic.setImageURI(profilePicUri);
                        UploadPicture();
                    }
                });
        reference = storage.getReference();
        btnAddPicture.setOnClickListener(v -> {
            ChoseProfilePic();
        });

        db.getReference("users").child(Objects.requireNonNull(auth.getUid())).addValueEventListener(
                new ValueEventListener() {

                    @Override
                    public void onDataChange(DataSnapshot snapshot) {

                        currentUser = snapshot.getValue(User.class);
                        Glide.with(getContext()).load(currentUser.getProfilePicUrl()).placeholder(R.drawable.profile_placeholder).centerCrop().into(profilePic);

                    }

                    @Override
                    public void onCancelled(DatabaseError error) {

                    }
                }
        );



        return root;
    }

    private void ChoseProfilePic() {

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        getProfileImageResult.launch(intent);

    }

    public void UploadPicture() {

        String imageId = String.valueOf(UUID.randomUUID());
        StorageReference profilePicRef= reference.child("images/profilePictures/"+imageId);
        profilePicRef.putFile(profilePicUri).addOnSuccessListener(taskSnapshot -> {

            Toast.makeText(getContext(), "ImagenSubida", Toast.LENGTH_SHORT).show();

            profilePicRef.getDownloadUrl().addOnSuccessListener(uri -> {



                Toast.makeText(getContext(), uri.toString(), Toast.LENGTH_SHORT).show();

                currentUser.setProfilePicUrl(uri.toString());
                db.getReference("users").child(currentUser.getId()).setValue(currentUser).addOnCompleteListener(task -> {

                    if(task.isSuccessful()){

                        Toast.makeText(getContext(),"link actualizado",Toast.LENGTH_SHORT).show();
                    }
                });
            });


        });


    }

}