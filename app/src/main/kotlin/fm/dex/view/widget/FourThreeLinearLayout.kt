package fm.dex.view.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout

/**
 * A extension of LinearLayout that is always 4:3 aspect ratio.
 */
class FourThreeLinearLayout(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    override fun onMeasure(widthSpec: Int, heightSpec: Int) {
        val fourThreeHeight = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthSpec) * 3 / 4,
                View.MeasureSpec.EXACTLY)
        super.onMeasure(widthSpec, fourThreeHeight)
    }

    override fun hasOverlappingRendering(): Boolean {
        return false
    }
}
