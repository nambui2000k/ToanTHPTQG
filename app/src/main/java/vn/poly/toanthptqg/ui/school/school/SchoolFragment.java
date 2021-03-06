package vn.poly.toanthptqg.ui.school.school;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import vn.poly.toanthptqg.R;
import vn.poly.toanthptqg.base.BaseFragment;
import vn.poly.toanthptqg.adapter.UniversityAdapter;
import vn.poly.toanthptqg.data.model.University;

public class SchoolFragment extends BaseFragment implements SchoolContract.View {
    private SchoolContract.Presenter presenter;
    private SearchView searchView;
    private Toolbar toolbar;
    private List<University> universityList;
    private UniversityAdapter universityAdapter;
    private RecyclerView rcvListUniversity;
    private DatabaseReference mData;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return setViewFragment(R.layout.fragment_school,container,inflater);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        toolbar= view.findViewById(R.id.toolbar);
        rcvListUniversity=view.findViewById(R.id.rcvListUniversity);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        ActionBar actionBar = activity.getSupportActionBar();
        actionBar.setTitle(R.string.title_school_fragment);
        universityList=new ArrayList<>();
        presenter=new SchoolPresenter(this,getContext());
        mData = FirebaseDatabase.getInstance().getReference();
        mData.child("University").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                loadDataToRecylerView();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        mData.child("University").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                University university=dataSnapshot.getValue(University.class);
                universityList.add(new University(dataSnapshot.getKey()
                        ,university.getNameUniversity(),university.getLongitude(),university.getLatitude()
                        ,university.getLinkScore(),university.getLinkLogo()));

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
        MenuItem searchItem = menu.findItem(R.id.search);
        MenuItem shareItem = menu.findItem(R.id.share);
        shareItem.setVisible(false);
        searchView= (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setQueryHint(getString(R.string.search));
        searchView.setIconifiedByDefault(true);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(final String newText) {
                loadDataFromSearch(newText.toLowerCase());
                return false;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.share:
                Toast.makeText(getActivity(), "Share School", Toast.LENGTH_LONG).show();
                return true;
            case R.id.logout:
                presenter.logOut();
                break;
            case R.id.exit:
                getActivity().moveTaskToBack(true);
                getActivity().finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);

    }
    public void loadDataToRecylerView(){
        universityAdapter=new UniversityAdapter(getActivity(),universityList);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        rcvListUniversity.setHasFixedSize(true);
        rcvListUniversity.setLayoutManager(linearLayoutManager);
        rcvListUniversity.setAdapter(universityAdapter);
    }
    public void loadDataFromSearch(final String text){
        universityList=new ArrayList<>();
        mData.child("University").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                University university=dataSnapshot.getValue(University.class);
                if(university.getNameUniversity().toLowerCase().contains(text)){
                    universityList.add(new University(dataSnapshot.getKey()
                            ,university.getNameUniversity(),university.getLongitude(),university.getLatitude()
                            ,university.getLinkScore(),university.getLinkLogo()));
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        mData.child("University").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                loadDataToRecylerView();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}