package com.example.examenconmvvm;

import static com.example.examenconmvvm.MainActivity.callPermission;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.ModelHolder>{
    private List<Model> ModelList;
    private Context context;
    public ModelAdapter(List<Model> ModelList , Context context) {
        this.ModelList = ModelList;
        this.context = context;
    }
    @NonNull
    @Override
    public ModelHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater ly= LayoutInflater.from(parent.getContext());
        View view = ly.inflate(R.layout.item_contact, parent, false);
        return new ModelHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ModelHolder holder, int position) {
        Model m = ModelList.get(position);
        holder.setdata(m);

        holder.go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (m.getIr()) {
                    case 1:

                        if (ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                            Intent i = new Intent(Intent.ACTION_CALL);
                            i.setData(Uri.parse("tel:8717321111"));
                            context.startActivity(i);
                        } else {

                            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.CALL_PHONE}, callPermission);
                        }
                        break;
                    case 2:

                        if (ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {

                            Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                            context.startActivity(dialIntent);
                        } else {

                            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.CALL_PHONE}, callPermission);
                        }
                        break;
                    case 3:
                        String url = "http://www.facebook.com";
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        view.getContext().startActivity(i);
                        break;
                    case 4:
                        Intent j = new Intent(context, InfoActivity.class);
                        view.getContext().startActivity(j);
                        break;
                    case 5:
                        Intent l= new Intent(Intent.ACTION_VIEW, Uri.parse("geo:25.500000, -103.320000"));
                        view.getContext().startActivity(l);
                        break;
                }
            }
        });


    }

    @Override
    public int getItemCount() { return ModelList.size(); }

    public class ModelHolder extends RecyclerView.ViewHolder {
        Model model;
        TextView name;
        TextView go;
        int ir;
        public ModelHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            go=itemView.findViewById(R.id.ir);
        }

        public void setdata(Model m) {
            model = m;
            name.setText(m.getName());
            ir=m.getIr();
        }
    }
}
