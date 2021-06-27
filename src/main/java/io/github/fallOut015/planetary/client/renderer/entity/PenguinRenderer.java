package io.github.fallOut015.planetary.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import io.github.fallOut015.planetary.MainPlanetary;
import io.github.fallOut015.planetary.client.renderer.entity.layers.PenguinFishInBeakLayer;
import io.github.fallOut015.planetary.client.renderer.entity.model.PenguinModel;
import io.github.fallOut015.planetary.entity.passive.PenguinEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.SalmonRenderer;
import net.minecraft.entity.passive.fish.SalmonEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PenguinRenderer extends MobRenderer<PenguinEntity, PenguinModel<PenguinEntity>> {
    public static final ResourceLocation[] TEXTURE = {
            new ResourceLocation(MainPlanetary.MODID, "textures/entity/penguin/penguin_black.png"),
            new ResourceLocation(MainPlanetary.MODID, "textures/entity/penguin/penguin_white.png"),
            new ResourceLocation(MainPlanetary.MODID, "textures/entity/penguin/penguin_striped.png"),
            new ResourceLocation(MainPlanetary.MODID, "textures/entity/penguin/penguin_macaroni.png"),
            new ResourceLocation(MainPlanetary.MODID, "textures/entity/penguin/penguin_emperor.png"),
            new ResourceLocation(MainPlanetary.MODID, "textures/entity/penguin/penguin_silver.png")
    };

    public PenguinRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new PenguinModel<>(), 0.35f);
        this.addLayer(new PenguinFishInBeakLayer(this));
    }

    @Override
    protected void setupRotations(PenguinEntity penguinEntity, MatrixStack stack, float p_225621_3_, float p_225621_4_, float p_225621_5_) {
        super.setupRotations(penguinEntity, stack, p_225621_3_, p_225621_4_, p_225621_5_);

        if(penguinEntity.isInWater()) {
            stack.mulPose(Vector3f.XP.rotationDegrees(-90));
        }
    }
    @Override
    public ResourceLocation getTextureLocation(PenguinEntity entity) {
        return TEXTURE[entity.getVariant()];
    }
}