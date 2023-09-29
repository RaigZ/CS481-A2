package com.example.fragment_ragirzebari_angelsamora

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.androidplot.util.PixelUtils
import com.androidplot.xy.BarFormatter
import com.androidplot.xy.BarRenderer
import com.androidplot.xy.BarRenderer.BarOrientation
import com.androidplot.xy.BoundaryMode
import com.androidplot.xy.SimpleXYSeries
import com.androidplot.xy.StepMode
import com.androidplot.xy.XYGraphWidget
import com.androidplot.xy.XYPlot
import com.androidplot.xy.XYSeries
import java.text.DecimalFormat

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BarFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BarFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var plot: XYPlot

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_bar, container, false)
        plot = view.findViewById(R.id.plotBar)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val seriesA: XYSeries = SimpleXYSeries(
            listOf(1, 2, 3, 4),
            listOf(4.3, 2.5, 3.5, 4.5),
            "a"
        )

        val seriesB: XYSeries = SimpleXYSeries(
            listOf(1, 2, 3, 4),
            listOf(2.4, 4.4, 1.8, 2.8),
            "b"
        )

        val seriesC: XYSeries = SimpleXYSeries(
            listOf(1, 2, 3, 4),
            listOf(2, 2, 3, 5),
            "c"
        )
        val seriesABarFormatter = BarFormatter()
        seriesABarFormatter.fillPaint.color = Color.BLUE

        val seriesBBarFormatter = BarFormatter()
        seriesBBarFormatter.fillPaint.color = Color.RED

        val seriesCBarFormatter = BarFormatter()
        seriesCBarFormatter.fillPaint.color = Color.GRAY

        plot.addSeries(seriesA, seriesABarFormatter)
        plot.addSeries(seriesB, seriesBBarFormatter)
        plot.addSeries(seriesC, seriesCBarFormatter)

        val renderer = plot.getRenderer(BarRenderer::class.java)
        renderer.barOrientation = BarOrientation.SIDE_BY_SIDE
        renderer.setBarGroupWidth(BarRenderer.BarGroupWidthMode.FIXED_WIDTH, PixelUtils.dpToPix(35f))

        plot.setRangeBoundaries(0, 6, BoundaryMode.FIXED)
        plot.setDomainBoundaries(0, 4.5, BoundaryMode.FIXED)

        plot.domainStepMode = StepMode.INCREMENT_BY_VAL
        plot.domainStepValue = 1.0
        plot.rangeStepMode = StepMode.INCREMENT_BY_VAL
        plot.rangeStepValue = 1.0
        plot.graph.getLineLabelStyle(XYGraphWidget.Edge.LEFT).format = DecimalFormat("#")
        plot.graph.getLineLabelStyle(XYGraphWidget.Edge.BOTTOM).format = DecimalFormat("#")
    }

        companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BarFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BarFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
