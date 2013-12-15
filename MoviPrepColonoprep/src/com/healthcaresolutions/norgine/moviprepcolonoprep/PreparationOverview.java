package com.healthcaresolutions.norgine.moviprepcolonoprep;



import java.util.ArrayList;

import com.healthcaresolutions.norgine.moviprepcolonoprep.common.Step;
import com.healthcaresolutions.norgine.moviprepcolonoprep.common.exceptions.DBAccessException;
import com.healthcaresolutions.norgine.moviprepcolonoprep.logiclayer.WorkflowService;
import com.healthcaresolutions.norgine.moviprepcolonoprep.logiclayer.impl.WorkflowServiceImpl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PreparationOverview extends Activity {
	
	private Button nextStep;
	private Button previousStep;
	private TextView txtStepDays;
	private TextView txtStepTime;
	private TextView txtStepDescribtion;
	private TextView txtAmount;
	private TextView txtStepAmount;
	private ImageView imgAction;
	
	private Context contextForListener;
	private ClickListener listener;
	
	private WorkflowService workflowService;
	private ArrayList<Step> steps;
	private int stepIndex = 0;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_overview);
		
		contextForListener = this;
		listener = new ClickListener();
		workflowService = new WorkflowServiceImpl(contextForListener, null);
		
		nextStep = (Button) findViewById(R.id.btnNextStep);
		nextStep.setOnClickListener(listener);
		previousStep = (Button) findViewById(R.id.btnPreviousStep);
		previousStep.setOnClickListener(listener);
		txtStepDays = (TextView) findViewById(R.id.txtStepDays);
		txtStepTime = (TextView) findViewById(R.id.txtStepTime);
		txtStepDescribtion = (TextView) findViewById(R.id.txtStepDescribtion);
		txtAmount = (TextView) findViewById(R.id.txtAmount);
		txtStepAmount = (TextView) findViewById(R.id.txtStepAmount);
		imgAction = (ImageView) findViewById(R.id.imgAction);
		
		try {
			steps = workflowService.getAllSteps();
			updateViewElements();
		} catch (DBAccessException e) {
			e.printStackTrace();
			Toast.makeText(getApplicationContext(), "Der Ablauf konnte nicht aus der Datenbank geladen werden!", Toast.LENGTH_SHORT).show();
			previousStep.setClickable(false);
			nextStep.setClickable(false);
		}
		
		
	}
	
	private void updateViewElements(){
		if(stepIndex==0){
			previousStep.setClickable(false);
		}
		else{
			previousStep.setClickable(true);
		}
		if(stepIndex+1>=steps.size()){
			nextStep.setClickable(false);
		}
		else{
			nextStep.setClickable(true);
		}
		
		Step step = steps.get(stepIndex);
		if(step != null){
			if(step.getDaysBefore()>0){
				txtStepDays.setText(step.getDaysBefore() + " " + getResources().getString(R.string.stepDayDescribtionFuture));
			}
			else {
				txtStepDays.setText(R.string.stepDayDescribtionToday);
			}
			txtStepTime.setText(step.getTime() + " " + getResources().getString(R.string.time));
			if(step.getAction().equals("diet")){
				txtStepDescribtion.setText(getResources().getString(R.string.action_diet));
				imgAction.setImageDrawable(getResources().getDrawable(R.drawable.no_food));
			}
			if(step.getAction().equals("drink")){
				txtStepDescribtion.setText(getResources().getString(R.string.action_drink));
				imgAction.setImageDrawable(getResources().getDrawable(R.drawable.drink));
			}
			if(step.getAmount()==null || step.getAmount().equals("")){
				txtAmount.setVisibility(View.INVISIBLE);
				txtStepAmount.setVisibility(View.INVISIBLE);
			}
			else {
				txtStepAmount.setText(step.getAmount());
			}
			
		}
		else {
			Toast.makeText(getApplicationContext(), "Dieser Ablaufschritt ist nicht vorhanden!", Toast.LENGTH_SHORT).show();
		}
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.medicine_info, menu);
		return true;
	}
	
	private class ClickListener implements OnClickListener{

		
		public void onClick(View clickedButton) {
			if(clickedButton == nextStep){
				if(stepIndex+1<=steps.size()){
					stepIndex++;
					updateViewElements();
				}	
			}
			if(clickedButton == previousStep){
				if(stepIndex-1>=0){
					stepIndex--;
					updateViewElements();
				}
			}
			
			
		}
		
	}
	
}
