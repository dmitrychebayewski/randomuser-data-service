package com.minskrotterdam.randomuser.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Name(
        val title: String,
        val first: String,
        val last: String
)