package com.example.sportsappnav;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SecondFragment extends Fragment{

    public SecondFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        //fill spinner from string.xml
//        Spinner spinner = (Spinner) getView().findViewById(R.id.teams_spinner);
//        // Create an ArrayAdapter using the string array and a default spinner layout
//
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,  //this line is not working , cant get the context
//                R.array.teams_array, android.R.layout.simple_spinner_item);
//        // Specify the layout to use when the list of choices appears
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        // Apply the adapter to the spinner
//        spinner.setAdapter(adapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }
}