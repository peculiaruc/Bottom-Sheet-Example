package com.pecpacker.bottomsheetexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_bottom_sheet.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomSheetBehavior =
            BottomSheetBehavior.from(layout_bottom_sheet)

        floatingActionButton.setOnClickListener { view ->
            Snackbar.make(view, "  Prevention is better than Cure", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()

            if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_COLLAPSED) {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            } else {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED


                bottomSheetBehavior.setBottomSheetCallback(object :
                    BottomSheetBehavior.BottomSheetCallback() {

                    override fun onStateChanged(view: View, state: Int) {
                        when (state) {
                            BottomSheetBehavior.STATE_EXPANDED -> {
                                floatingActionButton.visibility = View.GONE
                            }
                            BottomSheetBehavior.STATE_COLLAPSED -> {
                                floatingActionButton.visibility = View.VISIBLE
                            }
                        }
                    }

                    override fun onSlide(view: View, p1: Float) {
                    }
                })
            }
        }
    }
}
