package com.minskrotterdam.randomuser.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Info(
        val page: Int,
        val results: Int,
        val seed: String,
        val version: String
)