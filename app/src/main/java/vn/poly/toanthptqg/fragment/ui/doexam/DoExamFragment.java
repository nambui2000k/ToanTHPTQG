package vn.poly.toanthptqg.fragment.ui.doexam;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vn.poly.toanthptqg.R;
import vn.poly.toanthptqg.activity.BaseFragment;
import vn.poly.toanthptqg.adapter.ExamAdapter;
import vn.poly.toanthptqg.adapter.NewsAdapter;
import vn.poly.toanthptqg.model.Exam;


public class DoExamFragment extends BaseFragment {
    private Toolbar toolbar;
    private RecyclerView rcvListExam;
    private ExamAdapter examAdapter;
    private List<Exam> examList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return setViewFragment(R.layout.fragment_do_exam, container, inflater);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toolbar= view.findViewById(R.id.toolbar);
        rcvListExam=view.findViewById(R.id.rcvListExam);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        ActionBar actionBar = activity.getSupportActionBar();
        actionBar.setTitle(R.string.list_exam);
        examList=new ArrayList<>();
        examList.add(new Exam("de00001","THPT Lê Văn Thịnh ","Đề khảo sát chất lượng đầu năm","2019-2020",true,"90 phút",
                "https://firebasestorage.googleapis.com/v0/b/luyen-thi-toan-thptabc.appspot.com/o/de0001_cau1.JPG?alt=media&token=7efee473-b832-4420-8f36-a83ce99b7811","https://firebasestorage.googleapis.com/v0/b/luyen-thi-toan-thptabc.appspot.com/o/de0001_cau2.JPG?alt=media&token=cca436e6-d030-48b9-bdae-d9f05a91b062","","","","","","","","",
                "","","","","","","","","","",
                "","","","","","","","","","",
                "","","","","","","","","","",
                "","","","","","","","","","",
                "A","B","","","","","","","","",
                "","","","","","","","","","",
                "","","","","","","","","","",
                "","","","","","","","","","",
                "","","","","","","","","",""));
        examList.add(new Exam("de00001","THPT Lê Văn Thịnh ","Đề khảo sát chất lượng đầu năm","2019-2020",false,"90 phút",
                "https://firebasestorage.googleapis.com/v0/b/luyen-thi-toan-thptabc.appspot.com/o/de0001_cau1.JPG?alt=media&token=7efee473-b832-4420-8f36-a83ce99b7811","https://firebasestorage.googleapis.com/v0/b/luyen-thi-toan-thptabc.appspot.com/o/de0001_cau2.JPG?alt=media&token=cca436e6-d030-48b9-bdae-d9f05a91b062","","","","","","","","",
                "","","","","","","","","","",
                "","","","","","","","","","",
                "","","","","","","","","","",
                "","","","","","","","","","",
                "A","B","","","","","","","","",
                "","","","","","","","","","",
                "","","","","","","","","","",
                "","","","","","","","","","",
                "","","","","","","","","",""));
        examList.add(new Exam("de00001","THPT Lê Văn Thịnh ","Đề khảo sát chất lượng đầu năm","2019-2020",true,"90 phút",
                "https://firebasestorage.googleapis.com/v0/b/luyen-thi-toan-thptabc.appspot.com/o/de0001_cau1.JPG?alt=media&token=7efee473-b832-4420-8f36-a83ce99b7811","https://firebasestorage.googleapis.com/v0/b/luyen-thi-toan-thptabc.appspot.com/o/de0001_cau2.JPG?alt=media&token=cca436e6-d030-48b9-bdae-d9f05a91b062","","","","","","","","",
                "","","","","","","","","","",
                "","","","","","","","","","",
                "","","","","","","","","","",
                "","","","","","","","","","",
                "A","B","","","","","","","","",
                "","","","","","","","","","",
                "","","","","","","","","","",
                "","","","","","","","","","",
                "","","","","","","","","",""));
        examList.add(new Exam("de00001","THPT Lê Văn Thịnh ","Đề khảo sát chất lượng đầu năm","2019-2020",false,"90 phút",
                "https://firebasestorage.googleapis.com/v0/b/luyen-thi-toan-thptabc.appspot.com/o/de0001_cau1.JPG?alt=media&token=7efee473-b832-4420-8f36-a83ce99b7811","https://firebasestorage.googleapis.com/v0/b/luyen-thi-toan-thptabc.appspot.com/o/de0001_cau2.JPG?alt=media&token=cca436e6-d030-48b9-bdae-d9f05a91b062","","","","","","","","",
                "","","","","","","","","","",
                "","","","","","","","","","",
                "","","","","","","","","","",
                "","","","","","","","","","",
                "A","B","","","","","","","","",
                "","","","","","","","","","",
                "","","","","","","","","","",
                "","","","","","","","","","",
                "","","","","","","","","",""));
        examList.add(new Exam("de00001","THPT Lê Văn Thịnh ","Đề khảo sát chất lượng đầu năm","2019-2020",true,"90 phút",
                "https://firebasestorage.googleapis.com/v0/b/luyen-thi-toan-thptabc.appspot.com/o/de0001_cau1.JPG?alt=media&token=7efee473-b832-4420-8f36-a83ce99b7811","https://firebasestorage.googleapis.com/v0/b/luyen-thi-toan-thptabc.appspot.com/o/de0001_cau2.JPG?alt=media&token=cca436e6-d030-48b9-bdae-d9f05a91b062","","","","","","","","",
                "","","","","","","","","","",
                "","","","","","","","","","",
                "","","","","","","","","","",
                "","","","","","","","","","",
                "A","B","","","","","","","","",
                "","","","","","","","","","",
                "","","","","","","","","","",
                "","","","","","","","","","",
                "","","","","","","","","",""));


        examAdapter=new ExamAdapter(getActivity(),examList);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        rcvListExam.setHasFixedSize(true);
        rcvListExam.setLayoutManager(linearLayoutManager);
        rcvListExam.setAdapter(examAdapter);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
        MenuItem searchItem = menu.findItem(R.id.search);
        searchItem.setVisible(false);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.share:
                Toast.makeText(getActivity(), "Share Do Exam", Toast.LENGTH_LONG).show();
                return true;
            case R.id.logout:
                Toast.makeText(getActivity(), "Logout Do Exam", Toast.LENGTH_LONG).show();
                break;
            case R.id.exit:
                Toast.makeText(getActivity(), "Exit Do Exam", Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}