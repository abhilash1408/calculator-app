package com.example.mayora13.linearlayout;



import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;


public class MainActivity extends AppCompatActivity {
    ArrayList<String> str = new ArrayList<String>();
    boolean dr = true;
    boolean inBrackets = false;
    int brackets = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void dr(View v){

        Button b = (Button)v;
        if(b.getText().toString()=="DEG/rad"){
            b.setText("deg/RAD");
            dr = false;
        }
        else{
            dr = true;
            b.setText("DEG/rad");
        }

    }
    public void numInput(View v){
        EditText editText = (EditText)findViewById(R.id.input);


        if(v.getId()==R.id.zero){


            str.add("0");
        }
        else if(v.getId()==R.id.one){
            str.add("1");


        }
        else if(v.getId()==R.id.two){
            str.add("2");


        }
        else if(v.getId()==R.id.three){
            str.add("3");

        }
        else if(v.getId()==R.id.four){
            str.add("4");


        }
        else if(v.getId()==R.id.five){
            str.add("5");

        }
        else if(v.getId()==R.id.six){
            str.add("6");

        }
        else if(v.getId()==R.id.seven){
            str.add("7");

        }
        else if(v.getId()==R.id.eight){
            str.add("8");

        }
        else if(v.getId()==R.id.nine){
            str.add("9");

        }
        else if(v.getId()==R.id.dot){
            str.add(".");

        }
        else if(v.getId()==R.id.sin){
            str.add("sin(");
            inBrackets=true;
            brackets++;

        }
        else if(v.getId()==R.id.cos){
            str.add("tan(");
            inBrackets=true;
            brackets++;

        }
        else if(v.getId()==R.id.tan){
            str.add("ln(");
            inBrackets=true;
            brackets++;

        }
        else if(v.getId()==R.id.log){
            str.add("log(");
            inBrackets=true;
            brackets++;

        }
        else if(v.getId()==R.id.sqrt){
            str.add("sqrt(");
            inBrackets=true;
            brackets++;

        }
        else if(v.getId()==R.id.ln){
            str.add("ln(");
            inBrackets=true;
            brackets++;

        }
        else if(v.getId()==R.id.exp){
            str.add("exp(");
            inBrackets=true;
            brackets++;

        }
        else if(v.getId()==R.id.pi){
            str.add("\u03C0");

        }
        else if(v.getId()==R.id.pow){
            str.add("^(");
            inBrackets=true;
            brackets++;

        }
        else if(v.getId()==R.id.plus){
            str.add("+");

        }
        else if(v.getId()==R.id.minus){
            str.add("-");

        }
        else if(v.getId()==R.id.multi){
            str.add("x");

        }
        else if(v.getId()==R.id.div){
            str.add("\u00F7");

        }
        else if(v.getId()==R.id.rb){
            if(inBrackets){
                str.add(")");
                brackets--;
                if(brackets<1){
                    inBrackets = false;
                }

            }
        }
        else if(v.getId()==R.id.lb){
            str.add("(");
            inBrackets = true;
            brackets++;
        }
        else if(v.getId()==R.id.ans){
            str.add("ans");

        }
        else if(v.getId()==R.id.del){

            if(str.isEmpty()){

            }
            else{
                if(str.get(str.size()-1)==")"){

                    str.remove(str.size()-1);
                    inBrackets=true;
                    brackets++;
                }
                else if(str.get(str.size()-1)=="("||str.get(str.size()-1)=="sin("||str.get(str.size()-1)=="cos("||str.get(str.size()-1)=="tan("
                        ||str.get(str.size()-1)=="ln("||str.get(str.size()-1)=="log("||str.get(str.size()-1)=="exp("){
                    str.remove(str.size()-1);
                brackets--;}
                else{
                    str.remove(str.size()-1);
                }

            }
        }

        else if (v.getId()==R.id.clr){
            EditText Edit = (EditText) findViewById(R.id.input);
            str.clear();
            Edit.setText("", TextView.BufferType.EDITABLE);
            Edit.clearFocus();
            brackets =0;
            inBrackets = false;



        }

        ///processing input
        if(v.getId()==R.id.equals){


            if(inBrackets){
                for (int m=0;m<brackets;m++){
                    str.add(")");
                }
            }
            inBrackets = false;
            customArray arr = new customArray();
            boolean isNumber=false;
            String[] VALUES = new String[] {"1","2","3","4","5","6","7","8","9","0","."};
            int i = 0;
            int k = str.size();
            String number = "";

            while(i<k){
                if(isNumber){
                    if(Arrays.asList(VALUES).contains(str.get(i))){
                        isNumber = true;
                        number+=str.get(i);
                        i++;
                    }
                    else{
                        arr.add(number,true);
                        arr.add(str.get(i),false);
                        number="";
                        isNumber = false;
                        i++;
                    }
                }
                else{
                    if(Arrays.asList(VALUES).contains(str.get(i))){
                        isNumber = true;
                        number+=str.get(i);

                    }
                    else{
                        arr.add(str.get(i),false);
                    }
                    i++;
                }
            }




            ArrayNode current = arr.head;
            int b =0;
            while (current!=null){
                if(current.number){
                    Log.d("slayer",Integer.toString(b)+"th term is "+current.content+ " it is a number " );
                }
                else{
                    Log.d("slayer",Integer.toString(b)+"th term is "+current.content+ " it is not a number " );
                }

                b++;
                current = current.next;
            }
            if(validate(arr)){
                Log.d("slayer","string is valid expression");
            }
            else{
                Log.d("slayer","string is not a valid expression");
            }
        }

        ///displaying string
        String TextInput ="";
        if(!str.isEmpty()) {
            Iterator itr = str.iterator();

            while (itr.hasNext()) {
                TextInput += itr.next();
            }

            if(inBrackets){
                String extra ="" ;
                for (int i=0;i<brackets;i++){
                    extra+=")";
                }

                TextInput+=extra;

            }
            SpannableString text = new SpannableString(TextInput);
            text.setSpan(new ForegroundColorSpan(Color.RED),TextInput.length()-brackets,TextInput.length(),0);
            editText.setText(text, TextView.BufferType.SPANNABLE);
            editText.setSelection(editText.getText().length()-1);
        }
        else{
            editText.setText(TextInput, TextView.BufferType.EDITABLE);
        }
        if(inBrackets){
            Log.d("slayer", "in brackets, "+ Integer.toString(brackets));
        }
        else{
            Log.d("slayer", "not in brackets");
        }
        editText.clearFocus();
    }
    public boolean validate(customArray arr){
        boolean valid = true;
        boolean isoper = false;
        ArrayNode current = arr.head;
        while(current !=null){
            if (isoper==true && current.number==false){
                valid = false;
            }

            else if(current.number ==true){
                isoper = false;
            }
            else{
                isoper = true;
            }
            current = current.next;
        }
        return valid;

    }
    public String evaluate(customArray arr){
        String[] oper = {"+","-","x","\u00F7","sin(","cos(","tan(","log(","ln(","exp(","^("};
        Stack<String> operators = new Stack<>();
        Stack<Integer> operands = new Stack<>();
        if(validate(arr)){
            Log.d("slayer", "input string is valid");
        }
        return "";
    }



}
