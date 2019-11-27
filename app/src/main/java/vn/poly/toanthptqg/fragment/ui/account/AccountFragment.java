package vn.poly.toanthptqg.fragment.ui.account;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import vn.poly.toanthptqg.R;
import vn.poly.toanthptqg.activity.BaseFragment;
import vn.poly.toanthptqg.activity.HomeActivity;
import vn.poly.toanthptqg.activity.LoginActivity;

public class AccountFragment extends BaseFragment {

    private CircleImageView imageAvatar;
    private TextView tvEmail;
    private TextView tvPhoneNumber;
    private TextView tvNameDisplay;
    private LinearLayout lnlLogout;
    private String  name, email, phone, linkImage;




    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return setViewFragment(R.layout.fragment_account,container,inflater);
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        getInforLogin();
        lnlLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logOut();
            }
        });
        tvNameDisplay.setText(name);
        tvEmail.setText(email);
        tvPhoneNumber.setText(phone);

        Picasso.with(getContext()).load(linkImage).into(imageAvatar);





    }
    private void init(View view){
        imageAvatar = (CircleImageView) view.findViewById(R.id.imageAvatar);
        tvEmail = (TextView) view.findViewById(R.id.tvEmail);
        tvNameDisplay = (TextView) view.findViewById(R.id.tvNameDisplay);
        tvPhoneNumber = (TextView) view.findViewById(R.id.tvPhoneNumber);
        lnlLogout = (LinearLayout) view.findViewById(R.id.lnlLogout);
    }
    public void logOut() {
        AuthUI.getInstance().signOut(getActivity()).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                clearInforLogin();
                Intent intent=new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);


            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }
    private void clearInforLogin(){
        SharedPreferences sharedPreferences= getActivity().getSharedPreferences(getActivity().getResources().getString(R.string.key_save_inforLogin), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
    private void getInforLogin(){
        SharedPreferences sharedPreferences= getActivity().getSharedPreferences(getActivity().getResources().getString(R.string.key_save_inforLogin), Context.MODE_PRIVATE);
        name=sharedPreferences.getString(getActivity().getResources().getString(R.string.name_display),"Updating");
        email=sharedPreferences.getString(getActivity().getResources().getString(R.string.email),"Updating");
        phone=sharedPreferences.getString(getActivity().getResources().getString(R.string.phone),"Updating");
        linkImage=sharedPreferences.getString(getActivity().getResources().getString(R.string.url_avatar),"https://firebasestorage.googleapis.com/v0/b/luyen-thi-toan-thptabc.appspot.com/o/updating.png?alt=media&token=aaa77d65-6069-465e-960f-c08a25b0274a");


    }
}