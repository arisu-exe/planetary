package io.github.fallOut015.planetary.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import io.github.fallOut015.planetary.MainPlanetary;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.WolfRenderer;
import net.minecraft.client.renderer.entity.layers.WolfCollarLayer;
import net.minecraft.client.renderer.entity.model.WolfModel;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WolfRendererPlanetary extends MobRenderer<WolfEntity, WolfModel<WolfEntity>> {
    private static final ResourceLocation WOLF_TEXTURES = new ResourceLocation(MainPlanetary.MODID, "textures/entity/wolf/wolf.png");
    private static final ResourceLocation TAMED_WOLF_TEXTURES = new ResourceLocation(MainPlanetary.MODID, "textures/entity/wolf/wolf_tame.png");
    private static final ResourceLocation ANGRY_WOLF_TEXTURES = new ResourceLocation(MainPlanetary.MODID, "textures/entity/wolf/wolf_angry.png");

    public WolfRendererPlanetary(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new WolfModel<>(), 0.5F);
        this.addLayer(new WolfCollarLayer(this));
    }

    @Override
    protected float getBob(WolfEntity p_77044_1_, float p_77044_2_) {
        return p_77044_1_.getTailAngle();
    }
    @Override
    public void render(WolfEntity p_225623_1_, float p_225623_2_, float p_225623_3_, MatrixStack p_225623_4_, IRenderTypeBuffer p_225623_5_, int p_225623_6_) {
        if (p_225623_1_.isWet()) {
            float f = p_225623_1_.getWetShade(p_225623_3_);
            this.model.setColor(f, f, f);
        }

        super.render(p_225623_1_, p_225623_2_, p_225623_3_, p_225623_4_, p_225623_5_, p_225623_6_);
        if (p_225623_1_.isWet()) {
            this.model.setColor(1.0F, 1.0F, 1.0F);
        }

    }
    @Override
    public ResourceLocation getTextureLocation(WolfEntity entity) {
        if (entity.isTame()) {
            return TAMED_WOLF_TEXTURES;
        } else {
            return entity.isAngry() ? ANGRY_WOLF_TEXTURES : WOLF_TEXTURES;
        }
    }
}