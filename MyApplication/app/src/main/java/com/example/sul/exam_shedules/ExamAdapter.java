package com.example.sul.exam_shedules;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;


public class ExamAdapter extends RecyclerView.Adapter<ExamAdapter.ViewHolder> {

    List<Exam> exams;

    // Constructor class creates the adapter and passes in what we will need from our Fragment
    public ExamAdapter(List<Exam> exams) {
        this.exams = exams;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // This line inflates the layout which will be repeated
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_exam, parent, false);

        // We create an instance of our ViewHolder so we can handle click events.
        ViewHolder viewHolder = new ViewHolder(view, new ViewHolder.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                // We can handle click events in here, but only if we have
                // registered the listeners in the ViewHolder
            }
        });
        return viewHolder;
    }

    @Override
    // This method assigns the values from the exams list we passed in to the views
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvName.setText(exams.get(position).getName());
        holder.tvDate.setText(exams.get(position).getDate());
        holder.tvTime.setText(exams.get(position).getTime());
        holder.tvClassroom.setText(exams.get(position).getClassroom());
    }

    @Override
    // This simple method is needed for the RecyclerView.
    public int getItemCount() {
        return exams.size();
    }



    // This is our ViewHolder inner class. Very important!
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ItemClickListener listener;

        TextView tvName;
        TextView tvDate;
        TextView tvTime;
        TextView tvClassroom;

        // We map our views, and assign listeners in the ViewHolder constructor
        public ViewHolder(View itemView, ItemClickListener listener) {
            super(itemView);
            this.listener = listener;

            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvDate = (TextView) itemView.findViewById(R.id.tv_date);
            tvTime = (TextView) itemView.findViewById(R.id.tv_time);
            tvClassroom = (TextView) itemView.findViewById(R.id.tv_classroom);

            tvName.setOnClickListener(this);
            tvDate.setOnClickListener(this);
            tvTime.setOnClickListener(this);
            tvClassroom.setOnClickListener(this);
        }

        // This method is just to pass on the onClick event to our individual items! Neat!
        @Override
        public void onClick(View view) {
            listener.onItemClick(view, getPosition());
        }

        // This is the interface which forces our Adapter to implement the OnClickListener
        public interface ItemClickListener {
            void onItemClick(View view, int position);
        }
    }

}

