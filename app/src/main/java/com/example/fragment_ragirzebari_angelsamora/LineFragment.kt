package com.example.fragment_ragirzebari_angelsamora

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.androidplot.xy.BoundaryMode
import com.androidplot.xy.LineAndPointFormatter
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
 * Use the [LineFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LineFragment : Fragment() {
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
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_line, container, false)
        plot = view.findViewById(R.id.plotLine)
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
            listOf(6.2, 6.5, 5.8, 7.8),
            "b"
        )

        val seriesC: XYSeries = SimpleXYSeries(
            listOf(1, 2, 3, 4),
            listOf(8.2, 8.3, 8.1, 12.2),
            "c"
        )
        val seriesAFormatter = LineAndPointFormatter()
        seriesAFormatter.linePaint.color = Color.BLUE
        seriesAFormatter.vertexPaint.color = Color.BLUE
        seriesAFormatter.fillPaint.color = Color.TRANSPARENT
        seriesAFormatter.linePaint.strokeWidth = 10f
        seriesAFormatter.vertexPaint.strokeWidth = 20f

        val seriesBFormatter = LineAndPointFormatter()
        seriesBFormatter.linePaint.color = Color.RED
        seriesBFormatter.vertexPaint.color = Color.RED
        seriesBFormatter.fillPaint.color = Color.TRANSPARENT
        seriesBFormatter.linePaint.strokeWidth = 10f
        seriesBFormatter.vertexPaint.strokeWidth = 20f

        val seriesCFormatter = LineAndPointFormatter()
        seriesCFormatter.linePaint.color = Color.GRAY
        seriesCFormatter.vertexPaint.color = Color.GRAY
        seriesCFormatter.fillPaint.color = Color.TRANSPARENT
        seriesCFormatter.linePaint.strokeWidth = 10f
        seriesCFormatter.vertexPaint.strokeWidth = 20f

        plot.addSeries(seriesA, seriesAFormatter)
        plot.addSeries(seriesB, seriesBFormatter)
        plot.addSeries(seriesC, seriesCFormatter)

        plot.setRangeBoundaries(0, 14, BoundaryMode.FIXED)
        plot.setDomainBoundaries(0, 4.5, BoundaryMode.FIXED)
        plot.rangeStepMode = StepMode.INCREMENT_BY_VAL
        plot.rangeStepValue = 2.0
        plot.domainStepMode = StepMode.INCREMENT_BY_VAL
        plot.domainStepValue = 1.0
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
         * @return A new instance of fragment LineFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LineFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
        }

}