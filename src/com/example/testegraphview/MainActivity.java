package com.example.testegraphview;

import com.jjoe64.graphview.GraphView.GraphViewData;
import com.jjoe64.graphview.BarGraphView;
import com.jjoe64.graphview.CustomLabelFormatter;
import com.jjoe64.graphview.GraphView.LegendAlign;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.GraphViewSeries.GraphViewSeriesStyle;
import com.jjoe64.graphview.LineGraphView;

import android.support.v7.app.ActionBarActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		int i, tam = 200;
		double v = 0;
		
		//Cria os dados pra o grafico SENO
		GraphViewData[]  data = new GraphViewData[tam];
		for (i = 0; i < tam; i++) {
			v += 0.3;
			data[i] = new GraphViewData(i, Math.sin(v));
		}
		//Cria uma seria para os dados do SENO
				GraphViewSeries serieSeno = new GraphViewSeries("Seno", new GraphViewSeriesStyle(Color.MAGENTA,3),data);
		
		//Cria os dados pra o grafico COSSENO
		  data = new GraphViewData[tam];
		for (i = 0; i < tam; i++) {
			v += 0.3;
			data[i] = new GraphViewData(i, Math.cos(v));
		}								
		//Cria uma seria para os dados do SENO
		GraphViewSeries serieCosseno = new GraphViewSeries("Cosseno", new GraphViewSeriesStyle(Color.GREEN,3),data);
		
		
		
		//Insere os dados no grafico
		LineGraphView graphView = new LineGraphView(this, "Exemplo Gráfico"); //Linhas
		//BarGraphView graphView = new BarGraphView(this, "Exemplo Gráfico"); //Barras
		
		
		graphView.addSeries(serieSeno);
		graphView.addSeries(serieCosseno);
		
		//Muda o stily do grafico
		graphView.getGraphViewStyle().setGridColor(Color.GRAY);
		graphView.getGraphViewStyle().setHorizontalLabelsColor(Color.RED);
		graphView.getGraphViewStyle().setVerticalLabelsColor(Color.RED);
		graphView.getGraphViewStyle().setTextSize(22);
		
		//Colacar labels no grafico
		//se não for adicionado nenhum label o graphView adiciona automaticamente
		
		//Add labels staticos
		/*graphView.setVerticalLabels(new String[]{"y1","y2","y3","y4"});
		graphView.setHorizontalLabels(new String[]{"x1","x2","x3","x4"});*/
		
		//Add labels dinamicos
	/*	graphView.setCustomLabelFormatter(new CustomLabelFormatter() {			
			@Override
			public String formatLabel(double value, boolean isValueX) {
				// Se isValue é true. então é X
				//senão é Y
				if (isValueX) {
					if (value > 2) {
						return("X1");
					}
					return("X2");
				}else{
					if (value > 2) {
						return("Y1");
					}
					return("Y2");
				}
			}
		});
		*/
		
		//Permite rolar o scroll
		graphView.setViewPort(10, 30);
		graphView.setSaveEnabled(true);
		graphView.setScalable(true);
		
		//colore o grafico na parte de baixo
		/*graphView.setDrawBackground(true);
		graphView.setBackgroundColor(Color.DKGRAY);*/
		
		//Libera as legendas para serem mostradas no grafico
		graphView.setLegendAlign(LegendAlign.BOTTOM);
		graphView.setShowLegend(true);
		
		LinearLayout layout = (LinearLayout)findViewById(R.id.layout);
		layout.addView(graphView);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
