package io.github.fallOut015.planetary.client.renderer.entity;

import io.github.fallOut015.planetary.MainPlanetary;
import io.github.fallOut015.planetary.client.renderer.entity.model.CrimpModel;
import io.github.fallOut015.planetary.entity.passive.CrimpEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CrimpRenderer extends MobRenderer<CrimpEntity, CrimpModel<CrimpEntity>> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(MainPlanetary.MODID, "textures/entity/crimp.png");

    public CrimpRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new CrimpModel<>(), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(CrimpEntity entity) {
        return TEXTURE;
    }
}