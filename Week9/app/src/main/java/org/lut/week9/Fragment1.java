package org.lut.week9;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Fragment1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    //private static final String ARG_PARAM2 = "param2";

    public Fragment1() {

    }

    public static Fragment1 newInstance(ArrayList<String> param1) {
        Fragment1 fragment = new Fragment1();
        Bundle args = new Bundle();
        args.putStringArrayList(ARG_PARAM1, param1);
       // args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);

        ArrayList<String> items = new ArrayList<>();
        if (getArguments() != null)
            items = getArguments().getStringArrayList(ARG_PARAM1);

        ListView listView = view.findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_list_item_1,items);
        listView.setAdapter(adapter);

        return view;
     //   return inflater.inflate(R.layout.list_fragment, container, false);
    }
}