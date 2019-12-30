package com.sidetoside.app.ui.bindingadapter

import android.view.View
import androidx.databinding.BindingAdapter


@BindingAdapter("click")
fun View.bindClickListener(func: (() -> Unit)?) {
    setOnClickListener { func?.invoke() }
}