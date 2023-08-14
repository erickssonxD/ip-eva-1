package com.example.evauno

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.evauno.ui.theme.EvaunoTheme

class HonoraryEmployeeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val onGoBackButtonClick: () -> Unit = {
            finish()
        }

        setContent {
            EvaunoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HonoraryScreen(onGoBackButtonClick)
                }
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HonoraryScreen(onGoBackButtonClick: () -> Unit, modifier: Modifier = Modifier) {
    var gross by remember { mutableStateOf("0.0") }
    var net by remember { mutableStateOf("0.0") }

    ConstraintLayout {
        val (backButton) = createRefs()
        Column {
            Text(
                text = "Calculo de salario neto para empleado con honorarios",
                modifier = modifier
            )
            TextField(
                value = gross,
                onValueChange = { gross = it },
                label = { Text("Sueldo bruto") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Decimal
                )
            )
            Button(onClick = {
                val grossSalary = gross.toDouble()
                val employee = HonoraryEmployee(grossSalary)
                net = employee.netSalary().toString()
            }) {
                Text(text = "Calcular")
            }
            Text("El salario neto es: $net")
        }

        // Button constrained at the bottom of the screen
        Button(modifier = Modifier.constrainAs(backButton) {
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        },
            onClick = onGoBackButtonClick
        ) {
            Text(text = "Regresar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    EvaunoTheme {
        HonoraryScreen({})
    }
}