package net.minecraft.client.gui.inventory;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.inventory.ContainerHorseInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiScreenHorseInventory extends GuiContainer
{
    private static final ResourceLocation horseGuiTextures = new ResourceLocation("textures/gui/container/horse.png");

    /** The player inventory bound to this GUI. */
    private IInventory playerInventory;

    /** The horse inventory bound to this GUI. */
    private IInventory horseInventory;

    /** The EntityHorse whose inventory is currently being accessed. */
    private EntityHorse horseEntity;

    /** The mouse x-position recorded during the last rendered frame. */
    private float mousePosx;

    /** The mouse y-position recorded during the last renderered frame. */
    private float mousePosY;

    public GuiScreenHorseInventory(IInventory playerInv, IInventory horseInv, EntityHorse horse)
    {
        super(new ContainerHorseInventory(playerInv, horseInv, horse, Minecraft.getMinecraft().thePlayer));
        this.playerInventory = playerInv;
        this.horseInventory = horseInv;
        this.horseEntity = horse;
        this.allowUserInput = false;
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items). Args : mouseX, mouseY
     */
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        this.fontRendererObj.drawString(this.horseInventory.getDisplayName().getUnformattedText(), 8, 6, 4210752);
        //this.fontRendererObj.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
        this.fontRendererObj.drawString("Health:", 9, this.ySize - 96 + 3, 4210752);
        this.fontRendererObj.drawString("Jump:", 65, this.ySize - 96 + 3, 4210752);
        this.fontRendererObj.drawString("Speed:", 115, this.ySize - 96 + 3, 4210752);
        drawStats(this.horseEntity.getMaxHealth(), (float)this.horseEntity.getHorseJumpStrength(), (float)this.horseEntity.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getBaseValue());
    }

    /**
     * Args : renderPartialTicks, mouseX, mouseY
     */
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(horseGuiTextures);
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);

        if (this.horseEntity.isChested())
        {
            this.drawTexturedModalRect(i + 79, j + 17, 0, this.ySize, 90, 54);
        }

        if (this.horseEntity.canWearArmor())
        {
            this.drawTexturedModalRect(i + 7, j + 35, 0, this.ySize + 54, 18, 18);
        }

        GuiInventory.drawEntityOnScreen(i + 51, j + 60, 17, (float)(i + 51) - this.mousePosx, (float)(j + 75 - 50) - this.mousePosY, this.horseEntity);
    }

    /**
     * Draws the screen and all the components in it. Args : mouseX, mouseY, renderPartialTicks
     */
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.mousePosx = (float)mouseX;
        this.mousePosY = (float)mouseY;
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    private void drawStats(float paramFloat1, float paramFloat2, float paramFloat3)
    {
        int i = Math.round((paramFloat1 - 15.0F) / 15.0F * 100.0F);
        int j = Math.round((paramFloat2 - 0.4F) / 0.6F * 100.0F);
        int k = Math.round((paramFloat3 - 0.1125F) / 0.225F * 100.0F);
        int m = i < 50 ? (int)((50 - i) / 50.0F * 255.0F) : 0;
        int n = i > 50 ? (int)((100 - i) / 50.0F * 255.0F) : (int)(i / 50.0F * 255.0F);
        int i1 = i > 50 ? (int)((i - 50) / 50.0F * 255.0F) : 0;
        int i2 = m << 16 | i1 << 8 | n;
        this.fontRendererObj.drawString(Integer.toString(i), 44, this.ySize - 96 + 3, i2);
        m = j < 50 ? (int)((50 - j) / 50.0F * 255.0F) : 0;
        n = j > 50 ? (int)((100 - j) / 50.0F * 255.0F) : (int)(j / 50.0F * 255.0F);
        i1 = j > 50 ? (int)((j - 50) / 50.0F * 255.0F) : 0;
        i2 = m << 16 | i1 << 8 | n;
        this.fontRendererObj.drawString(Integer.toString(j), 93, this.ySize - 96 + 3, i2);
        m = k < 50 ? (int)((50 - k) / 50.0F * 255.0F) : 0;
        n = k > 50 ? (int)((100 - k) / 50.0F * 255.0F) : (int)(k / 50.0F * 255.0F);
        i1 = k > 50 ? (int)((k - 50) / 50.0F * 255.0F) : 0;
        i2 = m << 16 | i1 << 8 | n;
        this.fontRendererObj.drawString(Integer.toString(k), 149, this.ySize - 96 + 3, i2);
    }

}
