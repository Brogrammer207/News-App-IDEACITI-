package ideacitinews.bihar.localnews.Fragment;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import ideacitinews.bihar.localnews.Adapter.RecyclerviewAdapter;
import ideacitinews.bihar.localnews.ModelClass.Blog;
import ideacitinews.bihar.localnews.R;

public class WorldFragment extends Fragment {

    private RecyclerView mBlogList;
    private DatabaseReference mDatabase;
    RecyclerviewAdapter artistAdapter;
    public static ArrayList<Blog> list;
    ProgressDialog progressDialog;

    public WorldFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_world, container, false);
        mBlogList =view.findViewById(R.id.country_recyclerView);

        mBlogList.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        mBlogList.setLayoutManager(layoutManager);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("world");
        mDatabase.keepSynced(true);
        Loaddata();
        return view;
    }

    public void Loaddata() {

        if (progressDialog == null) {
            // in standard case YourActivity.this
            progressDialog = new ProgressDialog(getContext());
            progressDialog.setMessage("Loading...");
            progressDialog.show();
        }

        mDatabase.addValueEventListener(new com.google.firebase.database.ValueEventListener() {
            @Override
            public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {

                list = new ArrayList<>();
                for (com.google.firebase.database.DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Blog artist = postSnapshot.getValue(Blog.class);
                    list.add(artist);
                }

                artistAdapter = new RecyclerviewAdapter(getContext(),list);
                mBlogList.setAdapter(artistAdapter);
                if (progressDialog.isShowing()) {
                    progressDialog.dismiss();

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}