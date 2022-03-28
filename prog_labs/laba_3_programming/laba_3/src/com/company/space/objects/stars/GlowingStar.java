package com.company.space.objects.stars;

import com.company.space.events.GlowingColours;
import com.company.space.events.Sparkle;
import com.company.space.objects.SpaceObject;
import com.company.space.objects.planets.SpaceObjectsNames;

public class GlowingStar extends SpaceObject implements Sparkle {

    public GlowingStar(SpaceObjectsNames starName, Double illuminationLevel) {
        super(starName, illuminationLevel);
    }

    @Override
    public void sparkle(GlowingColours glowingColours) {
        System.out.println(this.getPlanetName() + " are glowing with " + glowingColours + " light!");
    }
}
