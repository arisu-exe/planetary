package io.github.fallOut015.planetary.client.renderer.entity;

import io.github.fallOut015.planetary.MainPlanetary;
import io.github.fallOut015.planetary.client.renderer.entity.model.RedPandaModel;
import io.github.fallOut015.planetary.entity.passive.RedPandaEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RedPandaRenderer extends MobRenderer<RedPandaEntity, RedPandaModel<RedPandaEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(MainPlanetary.MODID, "textures/entity/red_panda.png");

    public RedPandaRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new RedPandaModel<>(), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(RedPandaEntity entity) {
        return TEXTURE;
    }
}