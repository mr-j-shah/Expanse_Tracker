package com.crestinfosystems_jinay.expancetracker.model

sealed class PaymentMode(val name:String) {
    object Cash : PaymentMode(name = "Cash")
    object CreditCard : PaymentMode(name="Credit Card")
    object DebitCard : PaymentMode(name = "Debit Card")
    object UPI : PaymentMode(name = "UPI")
}