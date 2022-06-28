package com.debduttapanda.mytinycalculator

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.debduttapanda.mytinycalculator.ui.theme.MyTinyCalculatorTheme

class MainActivity : ComponentActivity() {
    val text1 = mutableStateOf("")
    val text2 = mutableStateOf("")
    val result = mutableStateOf("Result")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTinyCalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(){
                        TextField(
                            value = text1.value,
                            onValueChange = {
                                text1.value = it
                            },
                            placeholder = {
                                Text("Input1")
                            },
                            label = {
                                Text("Input1")
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number
                            )
                        )
                        TextField(
                            value = text2.value,
                            onValueChange = {
                                text2.value = it
                            },
                            placeholder = {
                                Text("Input2")
                            },
                            label = {
                                Text("Input2")
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number
                            )
                        )
                        val context = LocalContext.current
                        Button(
                            onClick = {
                                val input1 = text1.value
                                val input2 = text2.value
                                if(input1.isEmpty()||input2.isEmpty()){
                                    Toast.makeText(context, "Please put inputs", Toast.LENGTH_SHORT).show()
                                    return@Button
                                }
                                try {
                                    val num1 = text1.value.toInt()
                                    val num2 = text2.value.toInt()
                                    val sum = num1 + num2
                                    result.value = sum.toString()
                                    Log.d("lfjdslfjsdfjls",sum.toString())
                                }
                                catch(e: Exception){
                                    Toast.makeText(context, "Please put valid inputs", Toast.LENGTH_SHORT).show()
                                }

                            }
                        ) {
                            Text("Click Me")
                        }
                        Text(result.value)
                    }
                }
            }
        }
    }
}