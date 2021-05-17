package io.github.fallOut015.planetary.client.renderer.entity.model;

// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import io.github.fallOut015.planetary.entity.passive.JellyfishEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class JellyfishModel<T extends JellyfishEntity> extends EntityModel<T> {
    private final ModelRenderer jellyfish;
    private final ModelRenderer tentacle;
    private final ModelRenderer tentacleNW;
    private final ModelRenderer tentacleW;
    private final ModelRenderer tentacleSW;
    private final ModelRenderer tentacleS;
    private final ModelRenderer tentacleSE;
    private final ModelRenderer tentacleE;
    private final ModelRenderer tentacleNE;
    private final ModelRenderer tentacleN;

    public JellyfishModel() {
        super(RenderType::entityTranslucent);

        this.texWidth = 32;
        this.texHeight = 32;

        jellyfish = new ModelRenderer(this);
        jellyfish.setPos(0.0F, 23.1F, 0.0F);
        jellyfish.texOffs(0, 0).addBox(-4.0F, -11.1F, -4.0F, 8.0F, 6.0F, 8.0F, 0.0F, false);

        tentacle = new ModelRenderer(this);
        tentacle.setPos(0.0F, 0.9F, 0.0F);
        jellyfish.addChild(tentacle);
        setRotationAngle(tentacle, 0.0F, 0.7854F, 0.0F);
        tentacle.texOffs(0, 14).addBox(-2.0F, -12.0F, 0.0F, 4.0F, 12.0F, 0.0F, 0.0F, false);
        tentacle.texOffs(0, 10).addBox(0.0F, -12.0F, -2.0F, 0.0F, 12.0F, 4.0F, 0.0F, false);

        tentacleNW = new ModelRenderer(this);
        tentacleNW.setPos(2.75F, -5.1F, -2.75F);
        jellyfish.addChild(tentacleNW);
        tentacleNW.texOffs(8, 14).addBox(0.25F, 0.0F, -0.25F, 0.0F, 6.0F, 1.0F, 0.0F, false);
        tentacleNW.texOffs(8, 15).addBox(-0.75F, 0.0F, -0.25F, 1.0F, 6.0F, 0.0F, 0.0F, false);

        tentacleW = new ModelRenderer(this);
        tentacleW.setPos(3.0F, -5.1F, 0.0F);
        jellyfish.addChild(tentacleW);
        tentacleW.texOffs(10, 14).addBox(0.0F, 0.0F, -1.0F, 0.0F, 6.0F, 2.0F, 0.0F, false);

        tentacleSW = new ModelRenderer(this);
        tentacleSW.setPos(2.75F, -5.1F, 2.75F);
        jellyfish.addChild(tentacleSW);
        tentacleSW.texOffs(8, 15).addBox(-0.75F, 0.0F, 0.25F, 1.0F, 6.0F, 0.0F, 0.0F, false);
        tentacleSW.texOffs(8, 14).addBox(0.25F, 0.0F, -0.75F, 0.0F, 6.0F, 1.0F, 0.0F, false);

        tentacleS = new ModelRenderer(this);
        tentacleS.setPos(0.0F, -5.1F, 3.0F);
        jellyfish.addChild(tentacleS);
        tentacleS.texOffs(10, 16).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 6.0F, 0.0F, 0.0F, false);

        tentacleSE = new ModelRenderer(this);
        tentacleSE.setPos(-2.75F, -5.1F, 2.75F);
        jellyfish.addChild(tentacleSE);
        tentacleSE.texOffs(8, 14).addBox(-0.25F, 0.0F, -0.75F, 0.0F, 6.0F, 1.0F, 0.0F, false);
        tentacleSE.texOffs(8, 15).addBox(-0.25F, 0.0F, 0.25F, 1.0F, 6.0F, 0.0F, 0.0F, false);

        tentacleE = new ModelRenderer(this);
        tentacleE.setPos(-3.0F, -5.1F, 0.0F);
        jellyfish.addChild(tentacleE);
        tentacleE.texOffs(10, 14).addBox(0.0F, 0.0F, -1.0F, 0.0F, 6.0F, 2.0F, 0.0F, false);

        tentacleNE = new ModelRenderer(this);
        tentacleNE.setPos(-2.75F, -5.1F, -2.75F);
        jellyfish.addChild(tentacleNE);
        tentacleNE.texOffs(8, 14).addBox(-0.25F, 0.0F, -0.25F, 0.0F, 6.0F, 1.0F, 0.0F, false);
        tentacleNE.texOffs(8, 15).addBox(-0.25F, 0.0F, -0.25F, 1.0F, 6.0F, 0.0F, 0.0F, false);

        tentacleN = new ModelRenderer(this);
        tentacleN.setPos(0.0F, -5.1F, -3.0F);
        jellyfish.addChild(tentacleN);
        tentacleN.texOffs(10, 16).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 6.0F, 0.0F, 0.0F, false);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        //previously the render function, render code was moved to a method below
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        jellyfish.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}