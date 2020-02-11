package com.minskrotterdam.randomuser.controller

import com.minskrotterdam.randomuser.model.UserData
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
class RandomUserController(private val restTemplate: RestTemplate) {
    private val uri = "https://randomuser.me/api/?nat=nl&inc=gender,name"
    @GetMapping("/randomuser")
    fun randomUser(): UserData? {
        return restTemplate.getForObject(uri, UserData::class.java)
    }
}