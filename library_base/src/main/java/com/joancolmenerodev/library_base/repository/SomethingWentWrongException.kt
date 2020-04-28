package com.joancolmenerodev.library_base.repository

class SomethingWentWrongException(override val cause: Exception? = null) : Exception(cause)