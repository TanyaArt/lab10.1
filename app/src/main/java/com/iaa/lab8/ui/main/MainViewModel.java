package com.varets.lab8.ui.main;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.varets.lab8.db.Entities.ModelCases;
import com.varets.lab8.db.Repository.CasesRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private CasesRepository casesRepository;
    private LiveData<List<ModelCases>> allCases;

    public MainViewModel(@NonNull Application application){
        super(application);
         casesRepository= new CasesRepository(application);
         allCases=  casesRepository.getCases();
     }

     public void insert (ModelCases modelCases){
         casesRepository.addCase(modelCases);
     }
     public void update(ModelCases modelCases){
         casesRepository.updateCase(modelCases);
     }
    public void delete(ModelCases modelCases){
        casesRepository.deleteCase(modelCases);
    }
    public LiveData<List<ModelCases>> getAllCases(){
        return allCases;
    }
}