package io.github.fallOut015.planetary.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import io.github.fallOut015.planetary.MainPlanetary;
import io.github.fallOut015.planetary.client.renderer.entity.layers.MummifiedZombieOverlayLayer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.ZombieRenderer;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MummifiedZombieRenderer extends ZombieRenderer {
    private static final ResourceLocation TEXTURE = new ResourceLocation(MainPlanetary.MODID, "textures/entity/zombie/mummified_zombie.png");

    public MummifiedZombieRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn);
        this.addLayer(new MummifiedZombieOverlayLayer<>(this));
    }

    @Override
    protected void scale(ZombieEntity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.2f, 1.2f, 1.2f);
        super.scale(entitylivingbaseIn, matrixStackIn, partialTickTime);
    }
    @Override
    public ResourceLocation getTextureLocation(ZombieEntity entity) {
        return TEXTURE;
    }
}