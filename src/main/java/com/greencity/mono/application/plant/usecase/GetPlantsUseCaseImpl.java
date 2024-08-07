package com.greencity.mono.application.plant.usecase;

import com.greencity.mono.domain.plant.entity.Plant;
import com.greencity.mono.domain.plant.usecase.GetPlantsUseCase;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class GetPlantsUseCaseImpl implements GetPlantsUseCase {

  @Override
  public List<Plant> getPlants() {
    return List.of();
  }
}
