package com.silambar.parcelabledemo.java;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.silambar.parcelabledemo.R;
import java.util.ArrayList;

/**
 * Created by silambarasan on 16/03/18.
 */

public class TempleAdapter extends RecyclerView.Adapter<TempleAdapter.TempleHolder> {

  private ArrayList<Temple> temples = new ArrayList<>();
  private OnTempleClick  onTempleClick;

  public TempleAdapter(ArrayList<Temple> temples) {
    this.temples = temples;
  }

  @Override public TempleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.row_temple, parent, false);
    return new TempleHolder(view);
  }

  @Override public void onBindViewHolder(TempleHolder holder, int position) {
    Temple temple = temples.get(position);
    holder.templeTitle.setText(temple.getName());
    holder.templeDesc.setText(temple.getInfo().getDescription());
    holder.templeImage.setImageResource(temple.getImage());
  }

  @Override public int getItemCount() {
    return temples.size();
  }

  public void setClickListener(OnTempleClick onTempleClick) {
    this.onTempleClick = onTempleClick;
  }

  class TempleHolder extends ViewHolder implements OnClickListener {

    ImageView templeImage;
    TextView templeTitle;
    TextView templeDesc;

    TempleHolder(View itemView) {
      super(itemView);
      templeImage = itemView.findViewById(R.id.temple_image);
      templeTitle = itemView.findViewById(R.id.temple_title);
      templeDesc = itemView.findViewById(R.id.temple_description);
      itemView.setOnClickListener(this);
    }

    @Override public void onClick(View v) {
      if (onTempleClick!=null){
        onTempleClick.onClick(v, temples.get(getAdapterPosition()), getAdapterPosition());
      }
    }
  }

  public interface OnTempleClick{
    void onClick(View view, Temple temple, int position);
  }
}
