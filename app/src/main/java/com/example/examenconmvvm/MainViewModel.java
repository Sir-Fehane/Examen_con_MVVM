package com.example.examenconmvvm;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class MainViewModel extends ViewModel {

    private ModelRepository repository;
    private List<Model> modelList;

    public MainViewModel() {
        repository = new ModelRepository();
        modelList = repository.getModels();
    }

    public List<Model> getModelList() {
        return modelList;
    }
}

