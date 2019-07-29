package com.example.dailyexpense.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dailyexpense.R;
import com.example.dailyexpense.databinding.ModelExpenseItemBinding;
import com.example.dailyexpense.model.Expense;

import java.util.List;
public class DailyExpenseAdapter extends RecyclerView.Adapter<DailyExpenseAdapter.ViewHolder> {
    private Context context;
    private List<Expense> expenses;


    public DailyExpenseAdapter(Context context, List<Expense> expenses) {
        this.context = context;
        this.expenses = expenses;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ModelExpenseItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext())
                , R.layout.model_expense_item, viewGroup, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Expense expense = expenses.get(i);
        if (expense.getImageUrl() != null && !expense.getImageUrl().equals("")) {
        }

        viewHolder.binding.expenseCatTV.setText(expense.getCategory());
        viewHolder.binding.dateTV.setText(expense.getDate());
        viewHolder.binding.amountTV.setText(expense.getAmount());


    }

    @Override
    public int getItemCount() {
        return expenses.size();
    }



    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ModelExpenseItemBinding binding;

        public ViewHolder(ModelExpenseItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
