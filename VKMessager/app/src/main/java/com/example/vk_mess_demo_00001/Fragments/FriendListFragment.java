package com.example.vk_mess_demo_00001.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vk_mess_demo_00001.Activitys.FriendsActivity;
import com.example.vk_mess_demo_00001.Activitys.UserActivity;
import com.example.vk_mess_demo_00001.R;
import com.example.vk_mess_demo_00001.Transformation.CircularTransformation;
import com.example.vk_mess_demo_00001.VKObjects.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class FriendListFragment extends Fragment {
    static final String ARGUMENT_PAGE_NUMBER = "arg_page_number";
    static final String ARGUMENT_PAGE_ARRAY = "arg_page_array";
    int pageNumber;
    public ArrayList<User> users;
    private RecyclerView recyclerView;

    public static FriendListFragment newInstance(int page, String info) {

        FriendListFragment pageFragment = new FriendListFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(ARGUMENT_PAGE_NUMBER, page);
        arguments.putString(ARGUMENT_PAGE_ARRAY, info);
        pageFragment.setArguments(arguments);
        return pageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        users = new Gson().fromJson(getArguments().getString(ARGUMENT_PAGE_ARRAY), new TypeToken<List<User>>() {
        }.getType());

        pageNumber = getArguments().getInt(ARGUMENT_PAGE_NUMBER);
        if (pageNumber == 1) {
            ArrayList<User> onlineUsers = new ArrayList<>();
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getOnline() == 1) {
                    onlineUsers.add(users.get(i));
                }
            }
            users = onlineUsers;
            ((FriendsActivity) getActivity()).setOnlineFriendsCount(users.size());
        }else {
            ((FriendsActivity) getActivity()).setAllFriendsCount(users.size());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_friend, null);

        recyclerView = (RecyclerView) view.findViewById(R.id.list);
        Adapter adapter = new Adapter();
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);
        return view;
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        ImageView photo;
        ImageView online;
        TextView name;
        TextView someInformation;

        public ViewHolder(View itemView) {
            super(itemView);
            photo = (ImageView) itemView.findViewById(R.id.image);
            online = (ImageView) itemView.findViewById(R.id.image2);
            name = (TextView) itemView.findViewById(R.id.text);
            someInformation = (TextView) itemView.findViewById(R.id.text2);

        }
    }

    private class Adapter extends RecyclerView.Adapter<ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(View.inflate(getContext(), R.layout.item_friend_list, null));
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            final User user = users.get(position);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getContext(), UserActivity.class);
                    intent.putExtra("userID", user.getId());
                    startActivity(intent);
                    getActivity().finish();
                }
            });

            holder.name.setText(user.getFirst_name() + " " + user.getLast_name());
            if (user.getCity()!=(null)) {
                holder.someInformation.setText(user.getCity().getTitle());
            }else {
                holder.someInformation.setText("");
            }
            if (user.getPhoto_200().equals("")) {
                Picasso.with(getContext())
                        .load("https://vk.com/images/soviet_200.png")
                        .transform(new CircularTransformation())
                        .into(holder.photo);
            } else {
                Log.i("photo",user.getPhoto_200());
                Picasso.with(getContext())
                        .load(user.getPhoto_200())
                        .transform(new CircularTransformation())
                        .into(holder.photo);
            }
            if (user.getOnline() == 1) {
                holder.online.setVisibility(View.VISIBLE);
            }else {
                holder.online.setVisibility(View.INVISIBLE);
            }
        }

        @Override
        public int getItemCount() {
            return users.size();
        }
    }
}