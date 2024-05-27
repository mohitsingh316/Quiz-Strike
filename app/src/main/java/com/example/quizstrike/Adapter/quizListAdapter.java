package com.example.quizstrike.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.quizstrike.Model.QuizListModel;
import com.example.quizstrike.R;

import java.util.List;


public class quizListAdapter extends RecyclerView.Adapter<quizListAdapter.QuizListViewHolder> {
    private List<QuizListModel> QuizListModels;
    private OnItemClickListener onItemClickListener;

    public void setQuizListModels(List<QuizListModel> quizListModels) {
        QuizListModels = quizListModels;
    }
    public quizListAdapter(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;

    }

    @NonNull
    @Override
    public QuizListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.each_quiz, parent, false);

        return new QuizListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuizListViewHolder holder, int position) {
        QuizListModel model = QuizListModels.get(position);
        holder.title.setText(model.getTitle());
        Glide.with(holder.itemView).load(model.getImage()).into(holder.quizImage);

    }

    @Override
    public int getItemCount() {

        if(QuizListModels == null){
            return 0;
        } else {
            return QuizListModels.size();
        }

    }

    public class QuizListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView title;
        private ImageView quizImage;
        private ConstraintLayout constraintLayout;

        public QuizListViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.quizTitleList);
            quizImage = itemView.findViewById(R.id.quizImageList);
            constraintLayout = itemView.findViewById(R.id.constraintLayout);
            constraintLayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onItemClick(getAdapterPosition());

        }
    }
    public interface OnItemClickListener {
    void onItemClick(int position);
    }

}
