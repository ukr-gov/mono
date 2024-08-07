package com.greencity.mono.domain.plant.usecase;

import com.greencity.mono.domain.plant.entity.Plant;
import java.util.List;

public interface GetPlantsUseCase {

  List<Plant> getPlants();
}
