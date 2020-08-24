package com.example.redditapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.redditapp.R;
import com.example.redditapp.models.Information;

import java.util.List;

public class InformationAdapter extends ArrayAdapter<Information> {
    private List<Information> informationList;
    private int resource;
    private LayoutInflater inflater;
    private Context ctx;

    public InformationAdapter(Context  context, int resource, List<Information> informationList) {
        super(context, resource, informationList);
        ctx = context;
        this.informationList = informationList;               //список
        this.resource = resource;       //view(layout)
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //создание представления для одного объекта
        View view = inflater.inflate(resource, parent, false);

        //получение элементов управления на 'layout'
        TextView tvAuthor = view.findViewById(R.id.tvAuthor);
        TextView tvDate = view.findViewById(R.id.tvDate);
        TextView tvPicture = view.findViewById(R.id.tvPicture);
        TextView tvComment = view.findViewById(R.id.tvComment);

        //отображаемая машина
        final Information car = informationList.get(position);

        tvAuthor.setText(car.getAuthor());
        tvDate.setText(car.getDate());
        tvPicture.setText(car.getPicture());
        tvComment.setText(car.getComment());

        return view;
    }
    public interface OnViewClickListener {
        void view(Information car);
    }
}
