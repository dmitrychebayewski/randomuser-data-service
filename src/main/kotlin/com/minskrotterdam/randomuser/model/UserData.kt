package com.minskrotterdam.randomuser.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class UserData(
        val info: Info,
        val results: List<Result>
)