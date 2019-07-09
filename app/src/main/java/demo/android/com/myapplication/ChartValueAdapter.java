/*
package demo.android.com.myapplication;

import android.content.Context;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class ChartValueAdapter extends RecyclerView.Adapter<ChartValueAdapter.MyViewHolder> {

    private  AdapterCallback mAdapterCallback;
    private ArrayList<SelectorModel> modelList;
    private Context mContext;

    public ChartValueAdapter(ArrayList<SelectorModel> model, Context fragment) {
        mContext = fragment;
        this.modelList = model;

        try {
            this.mAdapterCallback = ((AdapterCallback) fragment);
        } catch (ClassCastException e) {
            throw new ClassCastException("Activity must implement AdapterCallback.");
        }
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final RelativeLayout rl_holder;
        private ImageView indicator;
        private TextView headLine;

        public MyViewHolder(View view) {
            super(view);
            headLine = view.findViewById(R.id.headLine);
            indicator = view.findViewById(R.id.indicator);
            rl_holder = view.findViewById(R.id.rl_holder);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;

            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.row_chart_1, parent, false);
        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final SelectorModel selectorModel = modelList.get(position);
        holder.headLine.setText(selectorModel.value);
        holder.indicator.setVisibility(View.GONE);
        if(selectorModel.isSelected()){
                holder.indicator.setVisibility(View.VISIBLE);
                holder.headLine.setTextColor(ResourcesCompat.getColor(mContext.getResources(),R.color.white,null));

        }else{
            holder.indicator.setVisibility(View.GONE);
            holder.headLine.setTextColor(ResourcesCompat.getColor(mContext.getResources(),R.color.slate_grey,null));
        }

        holder.rl_holder.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                for (int i = 0; i < modelList.size(); i++) {
                    if (i == position) continue;
                    if (modelList.get(i).isSelected()) {
                        modelList.get(i).setSelected(false);
                    }
                }
                if(selectorModel.isSelected()) {
                    modelList.get(position).setSelected(true);
                    notifyDataSetChanged();
                }else{
                    selectorModel.setSelected(true);
                    notifyDataSetChanged();
                }
                mAdapterCallback.onMethodCallback(selectorModel);
            }
        });

    }

    public  interface AdapterCallback {
        void onMethodCallback(SelectorModel model);
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }
}*/
