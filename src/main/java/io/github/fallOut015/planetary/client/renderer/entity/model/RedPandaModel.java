package io.github.fallOut015.planetary.client.renderer.entity.model;

// Made with Blockbench 3.6.2
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import io.github.fallOut015.planetary.entity.passive.RedPandaEntity;
import net.minecraft.client.renderer.entity.model.QuadrupedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RedPandaModel<T extends RedPandaEntity> extends QuadrupedModel<T> {
    private final ModelRenderer tail;

    public RedPandaModel() {
        super(9, 0, true, 23.0F, 4.8F, 2.7F, 3.0F, 49);

        this.texWidth = 64;
        this.texHeight = 64;

        this.body = new ModelRenderer(this);
        this.body.setPos(0.5F, 22.0F, 15.0F);
        this.body.texOffs(0, 39).addBox(-4.0F, -9.0F, -7.0F, 7.0F, 5.0F, 10.0F, 0.0F, false);
        this.body.texOffs(0, 39).addBox(-4.0F, -9.0F, -17.0F, 7.0F, 5.0F, 10.0F, 0.0F, false);

        this.head = new ModelRenderer(this);
        this.head.setPos(0.0F, 1.0F, -8.0F);
        this.body.addChild(this.head);
        this.head.texOffs(0, 5).addBox(-5.0F, -11.0F, -14.0F, 9.0F, 5.0F, 7.0F, 0.0F, false);
        this.head.texOffs(0, 17).addBox(-6.0F, -10.0F, -13.0F, 1.0F, 3.0F, 5.0F, 0.0F, false);
        this.head.texOffs(0, 17).addBox(4.0F, -10.0F, -13.0F, 1.0F, 3.0F, 5.0F, 0.0F, false);
        this.head.texOffs(12, 17).addBox(-6.0F, -14.0F, -13.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);
        this.head.texOffs(22, 17).addBox(2.0F, -14.0F, -13.0F, 3.0F, 3.0F, 2.0F, 0.0F, true);
        this.head.texOffs(0, 2).addBox(-3.0F, -8.0F, -15.0F, 5.0F, 2.0F, 1.0F, 0.0F, false);
        this.head.texOffs(2, 0).addBox(-2.0F, -9.0F, -15.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        this.head.texOffs(0, 31).addBox(-4.0F, -12.0F, -14.0F, 7.0F, 1.0F, 7.0F, 0.0F, false);
        this.head.texOffs(0, 25).addBox(-3.0F, -13.0F, -13.0F, 5.0F, 1.0F, 5.0F, 0.0F, false);

        tail = new ModelRenderer(this);
        tail.setPos(0.0F, 1.0F, 9.0F);
        this.body.addChild(tail);
        tail.texOffs(32, 0).addBox(-3.0F, -9.225F, -7.0F, 5.0F, 4.0F, 8.0F, 0.0F, false);
        tail.texOffs(32, 12).addBox(-3.0F, -8.0F, 1.0F, 5.0F, 3.0F, 5.0F, 0.0F, false);
        tail.texOffs(32, 19).addBox(-2.0F, -7.0F, 6.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);

        this.leg0 = new ModelRenderer(this);
        this.leg0.setPos(0.5F, 2.0F, -6.0F);
        this.body.addChild(this.leg0);
        this.leg0.texOffs(32, 23).addBox(-0.5F, -6.0F, -8.0F, 3.0F, 6.0F, 3.0F, 0.0F, false);
        this.leg0.texOffs(44, 30).addBox(-0.5F, -1.0F, -9.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        this.leg1 = new ModelRenderer(this);
        this.leg1.setPos(-0.5F, 2.0F, -6.0F);
        this.body.addChild(this.leg1);
        this.leg1.texOffs(32, 23).addBox(-3.5F, -6.0F, -8.0F, 3.0F, 6.0F, 3.0F, 0.0F, false);
        this.leg1.texOffs(44, 30).addBox(-3.5F, -1.0F, -9.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        this.leg2 = new ModelRenderer(this);
        this.leg2.setPos(0.5F, 2.0F, -15.0F);
        this.body.addChild(this.leg2);
        this.leg2.texOffs(32, 23).addBox(-0.5F, -6.0F, 15.0F, 3.0F, 6.0F, 3.0F, 0.0F, false);
        this.leg2.texOffs(44, 30).addBox(-0.5F, -1.0F, 14.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        this.leg3 = new ModelRenderer(this);
        this.leg3.setPos(-0.5F, 2.0F, -15.0F);
        this.body.addChild(this.leg3);
        this.leg3.texOffs(32, 23).addBox(-3.5F, -6.0F, 15.0F, 3.0F, 6.0F, 3.0F, 0.0F, false);
        this.leg3.texOffs(44, 30).addBox(-3.5F, -1.0F, 14.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        this.body.render(matrixStack, buffer, packedLight, packedOverlay);
    }
    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}