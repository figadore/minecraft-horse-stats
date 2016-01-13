# Minecraft Horse Stats

This is a port of Wubbi's mod.

Rather than building complicated redstone horse speedometers, you can install this mod. To see its effect, tame a horse, then open your inventory. The stats, including speed, health and jump strength, will be displayed as a percentage.

This is a client mod, meaning you can use it to modify your local installation of Minecraft and still gain the benefits while playing on SMP (survival multiplayer) servers

## Compatibility

Tested with Minecraft 1.8.8 and 1.8.9

## Installation

Currently only manual installation is provided. I'd gladly accept pull requests to ease the installation process using forge or whatever. See the following links for detailed manual installation instructions

[http://minecraft.gamepedia.com/Mods/Installing_mods#Installing_Mods_Manually](http://minecraft.gamepedia.com/Mods/Installing_mods#Installing_Mods_Manually)

[http://www.6minecraft.net/how-to-install-mods-minecraft/](http://www.6minecraft.net/how-to-install-mods-minecraft/)

windows tl;dr

* Create new 'version' of minecraft
  * copy `%appdata%/Roaming/.minecraft/versions/1.8.9` to `%appdata%/Roaming/.minecraft/versions/1.8.9-horse-stats`
  * rename `1.8.9.jar` and `1.8.9.json` to `1.8.9-horse-stats.jar` and `1.8.9-horse-stats.json`
  * change the `id` field in 1.8.9-horse-stats.json from `1.8.9` to `1.8.9-horse-stats`
* Right click and `open archive` on `1.8.9-horse-stats.jar` with 7zip
* delete `META-INF` folder
* drag `azb.class` into archive, then close 7zip
* create a new profile in minecraft using version 1.8.9-horse-stats
* play minecraft using new profile

## Development

I used the [Mod Coder Pack](http://www.modcoderpack.com) to modify the class.

* Run decompile.bat
* Modify src\minecraft\net\minecraft\client\gui\inventory\GuiScreenHorseInventory.java
* Run recompile.bat
* Run reobfuscate.bat
* Use files in `reobf` directory to mod Minecraft
