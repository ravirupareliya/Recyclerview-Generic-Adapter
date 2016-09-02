package com.rrr.genericrecyclerview;

import android.databinding.ViewDataBinding;

/**
 *
 */
public interface RecyclerCallback<VM extends ViewDataBinding, T> {
    public void bindData(VM binder,T model);
}
