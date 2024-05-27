package com.example.quizstrike.repository;

import androidx.annotation.NonNull;

import com.example.quizstrike.Model.QuizListModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class QuizListRepository {
    private onFireStoreTaskComplete onFireStoreTaskComplete;
    private FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    private CollectionReference reference = firebaseFirestore.collection("Quiz");

    public QuizListRepository(onFireStoreTaskComplete onFireStoreTaskComplete){
        this.onFireStoreTaskComplete = onFireStoreTaskComplete;
    }

    public void getQuizData(){
        reference.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    onFireStoreTaskComplete.quizDataLoaded(task.getResult().toObjects(QuizListModel.class));
                } else {
                    onFireStoreTaskComplete.onError(task.getException());
                }
            }
        });
    }

    public interface onFireStoreTaskComplete{
        void quizDataLoaded(List<QuizListModel> quizListModels);
        void onError(Exception e);
    }



}
