package com.example.feedback.view.ui

import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.RadioGroup
import android.widget.RatingBar.OnRatingBarChangeListener
import androidx.lifecycle.ViewModel
import com.example.feedback.R
import javax.inject.Inject


class MainActivityViewModel @Inject
constructor(
) : ViewModel() {
    var ansSecond: String = ""
    var ansThird: String = ""
    var ansFourth: String = ""
    var ansFifth: Float = 0.0f
    var ansSixth: Float = 0.0f
    var ansFirst: String = ""

    init {
        Log.e("MODEL", "Injection MainActivityViewModel")

    }

    fun onTextAnsSecondChanged(s: CharSequence, start: Int, befor: Int, count: Int) {
        ansSecond = s.toString()
        Log.e("VALUE", "Ans2 : $ansSecond")
    }

    fun onTextAnsThirdChanged(s: CharSequence, start: Int, befor: Int, count: Int) {
        ansThird = s.toString()
        Log.e("VALUE", "Ans3 : $ansThird")
    }

    fun onCheckedChange(group: RadioGroup, checkedId: Int) {
        if (checkedId == R.id.radioFirstBtn) {
            ansFirst = "Yes"
        } else if (checkedId == R.id.radioSecondBtn) {
            ansFirst = "No"
        }
        Log.e("VALUE", "Ans1 : $ansFirst")
    }

    fun onSelectItem(
        parent: AdapterView<*>?,
        view: View?,
        pos: Int,
        id: Long
    ) {
        ansFourth = "" + parent?.selectedItem
        Log.e("VALUE", "Ans4 : $ansFourth")
    }

    var firstRatingChangeListener =
        OnRatingBarChangeListener { ratingBar, v, b ->
            ansFifth = v
            Log.e("VALUE", "Ans5 : $ansFifth")

        }

    var secondRatingChangeListener =
        OnRatingBarChangeListener { ratingBar, v, b ->
            ansSixth = v
            Log.e("VALUE", "Ans6 : $ansSixth")
        }

}