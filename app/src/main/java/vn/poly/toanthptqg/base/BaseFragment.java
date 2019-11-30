package vn.poly.toanthptqg.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment {
    public void replaceFragment(int id,Fragment fragment){
        getFragmentManager().beginTransaction().replace(id, fragment).commit();
    }

    public void setTitleFragment(int nameTitle){
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(nameTitle);
    }

    public View setViewFragment(int layoutFragment, ViewGroup container, LayoutInflater inflater){
        View view= inflater.inflate(layoutFragment,container,false);
        return view;
    }
}
