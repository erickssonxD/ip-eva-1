package com.example.evauno

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.evauno.ui.theme.EvaunoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intentToRegularEmployee: () -> Unit = {
            startActivity(Intent(this, RegularEmployeeActivity::class.java))
        }
        val intentToExternalEmployee: () -> Unit = {
            startActivity(Intent(this, HonoraryEmployeeActivity::class.java))
        }

        setContent {
            EvaunoTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    EmployeeMenu(intentToRegularEmployee, intentToExternalEmployee)
                }
            }
        }
    }
}

@Composable
fun EmployeeMenu(onClickGoToRegularEmp: () -> Unit, onClickGoToHonoraryEmp: () -> Unit, modifier: Modifier = Modifier) {
    Column {
        Button(modifier = modifier, onClick = onClickGoToHonoraryEmp) {
            Text(text = "Empleado con honorarios")
        }
        Button(modifier = modifier, onClick = onClickGoToRegularEmp) {
            Text(text = "Empleado regular")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EvaunoTheme {
        EmployeeMenu({}, {})
    }
}