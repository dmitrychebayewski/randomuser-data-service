package com.minskrotterdam.randomuser.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Result(
        val gender: String,
        val name: Name
)