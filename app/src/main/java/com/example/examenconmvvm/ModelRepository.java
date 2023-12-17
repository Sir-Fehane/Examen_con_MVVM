package com.example.examenconmvvm;

import com.example.examenconmvvm.Model;

import java.util.ArrayList;
import java.util.List;

public class ModelRepository {

    public List<Model> getModels() {
        // Simula obtener datos de una fuente (puedes reemplazar esto con llamadas reales a la base de datos, red, etc.)
        List<Model> modelList = new ArrayList<>();
        modelList.add(new Model("Marcar", 1));
        modelList.add(new Model("Telefono", 2));
        modelList.add(new Model("Internet", 3));
        modelList.add(new Model("Activity", 4));
        modelList.add(new Model("Mapa", 5));
        return modelList;
    }
}
