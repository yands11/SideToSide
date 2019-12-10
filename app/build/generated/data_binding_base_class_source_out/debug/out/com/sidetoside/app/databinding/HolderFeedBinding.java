// Generated by data binding compiler. Do not edit!
package com.sidetoside.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.sidetoside.app.R;
import com.sidetoside.app.entity.LeftRight;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class HolderFeedBinding extends ViewDataBinding {
  @NonNull
  public final View gaugeLeft;

  @NonNull
  public final View gaugeRight;

  @NonNull
  public final ImageView ivLeft;

  @NonNull
  public final ImageView ivRight;

  @NonNull
  public final TextView tvLeft;

  @NonNull
  public final TextView tvRight;

  @Bindable
  protected LeftRight mData;

  protected HolderFeedBinding(Object _bindingComponent, View _root, int _localFieldCount,
      View gaugeLeft, View gaugeRight, ImageView ivLeft, ImageView ivRight, TextView tvLeft,
      TextView tvRight) {
    super(_bindingComponent, _root, _localFieldCount);
    this.gaugeLeft = gaugeLeft;
    this.gaugeRight = gaugeRight;
    this.ivLeft = ivLeft;
    this.ivRight = ivRight;
    this.tvLeft = tvLeft;
    this.tvRight = tvRight;
  }

  public abstract void setData(@Nullable LeftRight data);

  @Nullable
  public LeftRight getData() {
    return mData;
  }

  @NonNull
  public static HolderFeedBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.holder_feed, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static HolderFeedBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<HolderFeedBinding>inflateInternal(inflater, R.layout.holder_feed, root, attachToRoot, component);
  }

  @NonNull
  public static HolderFeedBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.holder_feed, null, false, component)
   */
  @NonNull
  @Deprecated
  public static HolderFeedBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<HolderFeedBinding>inflateInternal(inflater, R.layout.holder_feed, null, false, component);
  }

  public static HolderFeedBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static HolderFeedBinding bind(@NonNull View view, @Nullable Object component) {
    return (HolderFeedBinding)bind(component, view, R.layout.holder_feed);
  }
}
