package io.github.fallOut015.planetary.block;

import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import net.minecraft.block.WoodType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Set;
import java.util.stream.Stream;

public class WoodTypePlanetary extends WoodType {
    private static final Set<WoodType> WOODTYPES = new ObjectArraySet<>();

    public static final WoodType CEDAR = register(new WoodTypePlanetary("cedar"));
    public static final WoodType REDWOOD = register(new WoodTypePlanetary("redwood"));
    public static final WoodType CHERRY = register(new WoodTypePlanetary("cherry"));
    public static final WoodType ASPEN = register(new WoodTypePlanetary("aspen"));
    public static final WoodType DRAGONBLOOD = register(new WoodTypePlanetary("dragonblood"));
    public static final WoodType EUCALYPTUS = register(new WoodTypePlanetary("eucalyptus"));
    public static final WoodType PINE = register(new WoodTypePlanetary("pine"));
    public static final WoodType BALSA = register(new WoodTypePlanetary("balsa"));
    public static final WoodType CONIFER = register(new WoodTypePlanetary("conifer"));
    public static final WoodType MAPLE = register(new WoodTypePlanetary("maple"));

    private final String ID;

    public WoodTypePlanetary(String ID) {
        super(ID);
        this.ID = ID;
    }

    public static WoodType register(WoodType woodType) {
        WOODTYPES.add(woodType);
        return woodType;
    }

    public static Stream<WoodType> values() {
        return WOODTYPES.stream();
    }

    public String name() {
        return this.ID;
    }
}

// TODO WoodType.create