package com.rrr.genericrecyclerview;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.rrr.genericrecyclerview.adapter.RecyclerAdapter;
import com.rrr.genericrecyclerview.databinding.ActivityMainBinding;
import com.rrr.genericrecyclerview.databinding.RecyclerItemBinding;
import com.rrr.genericrecyclerview.model.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerClickInterface {

    private ActivityMainBinding activityMainBinding;
    private ArrayList<User> userList = new ArrayList<>();
    private RecyclerAdapter<User, RecyclerItemBinding> userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        fillData();
        userAdapter = new RecyclerAdapter<>(this, userList, R.layout.recycler_item, new RecyclerCallback<RecyclerItemBinding, User>() {
            @Override
            public void bindData(RecyclerItemBinding binder, User model) {
                setRecyclerData(binder, model);
            }
        });

        activityMainBinding.recyclerView.addItemDecoration(new RecyclerDividerItem(this));
        activityMainBinding.recyclerView.setAdapter(userAdapter);
    }

    private void setRecyclerData(RecyclerItemBinding binder, User model) {
        binder.setUser(model);
        binder.setHandler(this);
    }

    private void fillData() {
        User user1 = new User();
        user1.setFirstName("Ravi");
        user1.setLastName("Rupareliya");
        userList.add(user1);

        User user2 = new User();
        user2.setFirstName("Yigit");
        user2.setLastName("Boyar");
        userList.add(user2);

        User user3 = new User();
        user3.setFirstName("George");
        user3.setLastName("Mount");
        userList.add(user3);

        User user4 = new User();
        user4.setFirstName("John");
        user4.setLastName("Skeet");
        userList.add(user4);
    }

    @Override
    public void onClick(User user) {
        Toast.makeText(MainActivity.this, "First name : " + user.getFirstName(), Toast.LENGTH_LONG).show();
    }
}