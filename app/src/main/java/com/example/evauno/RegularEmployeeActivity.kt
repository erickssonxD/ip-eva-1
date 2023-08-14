package com.example.evauno

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class RegularEmployeeActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regular_employee)

        // View bindings
        val etGrossSalary = findViewById<EditText>(R.id.etGrossSalary)
        val tvNetSalary = findViewById<TextView>(R.id.tvNetSalary)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val btnBack = findViewById<Button>(R.id.btnBack)

        // Event handlers
        btnCalculate.setOnClickListener {
            val grossSalary = etGrossSalary.text.toString().toDouble()
            val regularEmployee = RegularEmployee(grossSalary)
            tvNetSalary.text = regularEmployee.netSalary().toString()
        }
        btnBack.setOnClickListener {
            finish()
        }
    }
}