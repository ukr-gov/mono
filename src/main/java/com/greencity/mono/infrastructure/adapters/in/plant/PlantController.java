package com.greencity.mono.infrastructure.adapters.in.plant;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plant")
public class PlantController {

  @GetMapping
  public String getPlant() {
    return "Tree";
  }
}
