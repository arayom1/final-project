package com.example.sul.exam_shedules;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewFragment extends Fragment {

    private RecyclerView recyclerExams;

    public RecyclerViewFragment() {
        // Required empty constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // This decides which layout the fragment will use.
        return inflater.inflate(R.layout.activity_recycler_view_fragment, container, false);
    }

    @Override
    // The view passed to us in this parameter contains all of the views we created in XML
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Map our view
        recyclerExams = (RecyclerView) view.findViewById(R.id.recycler_exams);

        // Every RecyclerView needs a LayoutManager. Notice that it's an inner class.
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 1);
        // Don't forget to set the manager on your RecyclerView!
        recyclerExams.setLayoutManager(layoutManager);

        final List<Exam> exams = new ArrayList<>();

        ParseObject examObject = new ParseObject("ExamObject");
        examObject.put("name", "CSIS 221");
        examObject.put("date", "05/21");
        examObject.put("time", "9am");
        examObject.put("classroom", "BR160");
        examObject.saveInBackground();

        ParseQuery<ParseObject> query = ParseQuery.getQuery("ExamObject");
        query.whereEqualTo("classroom", "BR160");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> parseObjects, ParseException e) {
                for(ParseObject obj : parseObjects){
                    exams.add(new Exam(obj.getString("name"),obj.getString("date"),obj.getString("time"),obj.getString("classroom")));
                }
                recyclerExams.setAdapter(new ExamAdapter(exams));
                ParseObject l = parseObjects.get(0);
                String name = l.getString("name");
                String classroom = l.getString("classroom");
                String date = l.getString("date");

            }
        });

        // Create data
        //List<Exam> exams = mockExams();

        // Set the adapter!

    }

          private List<Exam> mockExams() {
//        // Creates a list of Exams and fills them up with data
        List<Exam> exams = new ArrayList<>();
        exams.add(new Exam("CSIS 252","05/15","9AM","BR161"));
        exams.add(new Exam("ENG 202","05/15","10AM","LO109"));
        exams.add(new Exam("ENG 286","05/15","11AM","BR109"));
        exams.add(new Exam("CSIS 320","05/15","12PM","BR160"));
        exams.add(new Exam("CSIS 304","05/15","1PM","CB202"));
        exams.add(new Exam("MUS 100","05/15","2PM","HA115"));

        return exams;
    }
}