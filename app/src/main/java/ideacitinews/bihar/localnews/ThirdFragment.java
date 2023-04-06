package ideacitinews.bihar.localnews;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import ideacitinews.bihar.localnews.Adapter.NewsEpaperAdapter;
import ideacitinews.bihar.localnews.Adapter.YoutubevideoAdapter;
import ideacitinews.bihar.localnews.ModelClass.NewsEpaperModel;
import ideacitinews.bihar.localnews.ModelClass.Upload;
import ideacitinews.bihar.localnews.ModelClass.YoutubevideoModel;

public class ThirdFragment extends Fragment {

    ListView listView;

    //database reference to get uploads data
    DatabaseReference mDatabaseReference;

    //list to store uploads data
    List<Upload> uploadList;
    public ThirdFragment() {

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third, container, false);
        uploadList = new ArrayList<>();
        listView = (ListView) view.findViewById(R.id.listView);


        //adding a clicklistener on listview
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Upload upload = uploadList.get(i);
                CharSequence options[] = new CharSequence[]{
                        "Download",
                        "View",
                        "Cancel"
                };
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Choose One");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // we will be downloading the pdf
                        if (which == 0) {
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(upload.getUrl()));
                            startActivity(intent);
                        }
                        // We will view the pdf
                        if (which == 1) {
                            Intent intent = new Intent(getContext(), ViewpdfActivity.class);
                            intent.putExtra("url", upload.getUrl());
                            startActivity(intent);
                        }
                    }
                });
                builder.show();
            }
        });


        //getting the database reference
        mDatabaseReference = FirebaseDatabase.getInstance().getReference("uploadpdf");

        //retrieving upload data from firebase database
        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Upload upload = postSnapshot.getValue(Upload.class);
                    uploadList.add(upload);
                }

                String[] uploads = new String[uploadList.size()];

                for (int i = 0; i < uploads.length; i++) {
                    uploads[i] = uploadList.get(i).getName();
                }

                //displaying it to list
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, uploads);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return view;
    }


}