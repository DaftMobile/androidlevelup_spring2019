package com.daftmobile.androidlevelup

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.reflect.KClass

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewAnimationButton.onClickStartActivity(ViewAnimationActivity::class)
        propertyAnimatorButton.onClickStartActivity(PropertyAnimatorActivity::class)
        constraintSetButton.onClickStartActivity(ConstraintSetActivity::class)
        springButton.onClickStartActivity(SpringActivity::class)
    }

    private fun <T : Activity> View.onClickStartActivity(activityClass: KClass<T>) = setOnClickListener {
        startActivity(Intent(context, activityClass.java))
    }
}
