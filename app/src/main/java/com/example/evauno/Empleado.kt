package com.example.evauno

abstract class Employee(protected var grossSalary: Double) {
    abstract fun netSalary(): Double
}

class RegularEmployee(grossSalary: Double) : Employee(grossSalary) {
    override fun netSalary(): Double {
        return grossSalary * 0.8
    }
}

class HonoraryEmployee(grossSalary: Double) : Employee(grossSalary) {
    override fun netSalary(): Double {
        return grossSalary * 0.87
    }
}