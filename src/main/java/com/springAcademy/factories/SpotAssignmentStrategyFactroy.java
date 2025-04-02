package com.springAcademy.factories;

import com.springAcademy.SpotAssignmentStrategy.ChepestSpotAssignmentStrategy;
import com.springAcademy.SpotAssignmentStrategy.RandomSpotAssignmentStrategy;
import com.springAcademy.SpotAssignmentStrategy.SpotAssignmentStrategy;
import com.springAcademy.models.SpotAssignmentStrategyType;

public class SpotAssignmentStrategyFactroy
{
    public static SpotAssignmentStrategy getSpotAssignmentStrategy(SpotAssignmentStrategyType spotAssignmentStrategyType)
    {
        if(spotAssignmentStrategyType == SpotAssignmentStrategyType.RANDOM)
        {
            return new RandomSpotAssignmentStrategy();
        }
        else if(spotAssignmentStrategyType.equals(SpotAssignmentStrategyType.CHEPEST))
        {
            return new ChepestSpotAssignmentStrategy();
        }
        else
        {
            return null;
        }
    }
}
