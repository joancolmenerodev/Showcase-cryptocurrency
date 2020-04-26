package com.joancolmenerodev.library_base.presentation.extension

import android.view.View


fun View.visible(visible : Boolean ) = if(visible) this.visibility = View.VISIBLE else this.visibility = View.GONE